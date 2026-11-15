param([int]$Port = 9901)

$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
$Base = "http://127.0.0.1:$Port"

# Build Chinese strings from code points so this source file stays pure ASCII.
$zhangsan = -join ([char]0x5F20, [char]0x4E09)
$lisi     = -join ([char]0x674E, [char]0x56DB)
$addr1    = -join ([char]0x6DF1, [char]0x5733, [char]0x5E02, [char]0x5357, [char]0x5C71, [char]0x533A, [char]0x79D1, [char]0x6280, [char]0x56ED, '1', [char]0x680B, '201')
$addr2    = -join ([char]0x4E0A, [char]0x6D77, [char]0x5E02, [char]0x6D66, [char]0x4E1C, [char]0x65B0, [char]0x533A, [char]0x4E16, [char]0x7EAA, [char]0x5927, [char]0x9053, '100', [char]0x53F7)
$edited   = $addr1 + '-AB'

function Invoke-Api {
    param([string]$Method, [string]$Path, $Body, [string]$Token)
    $req = [System.Net.HttpWebRequest]::Create($Base + $Path)
    $req.Method = $Method
    $req.ContentType = 'application/json;charset=UTF-8'
    if ($Token) { $req.Headers.Add('Authorization', 'Bearer ' + $Token) }
    if ($null -ne $Body) {
        $bytes = [System.Text.Encoding]::UTF8.GetBytes(($Body | ConvertTo-Json -Compress -Depth 8))
        $req.ContentLength = $bytes.Length
        $rs = $req.GetRequestStream(); $rs.Write($bytes, 0, $bytes.Length); $rs.Close()
    }
    try { $resp = $req.GetResponse() }
    catch [System.Net.WebException] {
        $resp = $_.Exception.Response
        if ($null -eq $resp) { throw }
    }
    $sr = New-Object System.IO.StreamReader($resp.GetResponseStream(), [System.Text.Encoding]::UTF8)
    $text = $sr.ReadToEnd(); $http = [int]$resp.StatusCode; $resp.Close()
    $json = if ($text) { $text | ConvertFrom-Json } else { $null }
    return [pscustomobject]@{ Http = $http; Json = $json; Raw = $text }
}

function Check($label, $cond) {
    if ($cond) { Write-Host "  [PASS] $label" }
    else { Write-Host "  [FAIL] $label" -ForegroundColor Red; $script:Failed++ }
}

$script:Failed = 0

# ---- login both accounts ----
$tkAdmin = (Invoke-Api POST '/api/auth/login' @{ username = 'admin';  password = '123456' }).Json.data.token
$tkBuyer = (Invoke-Api POST '/api/auth/login' @{ username = 'buyer1'; password = '123456' }).Json.data.token
Write-Host "tokens: admin=$([bool]$tkAdmin) buyer1=$([bool]$tkBuyer)"

$pid1 = (Invoke-Api GET '/api/shop/products?pageNo=1&pageSize=1&status=1' $null $tkBuyer).Json.data.list[0].id
Write-Host "test product: $pid1"

# ---- 1. buyer address book starts empty ----
Write-Host "`n=== 1. buyer address book initially empty ==="
$r = Invoke-Api GET '/api/shop/addresses' $null $tkBuyer
Check 'code=200' ($r.Json.code -eq 200)
Write-Host "  existing count = $($r.Json.data.Count)"

# ---- 2. add first address -> auto default ----
Write-Host "`n=== 2. add first address (expect auto isDefault=1) ==="
$r = Invoke-Api POST '/api/shop/addresses' @{ receiverName = $zhangsan; receiverPhone = '13800000001'; receiverAddress = $addr1 } $tkBuyer
Check 'code=200' ($r.Json.code -eq 200)
Check 'isDefault=1' ($r.Json.data.isDefault -eq 1)
Check 'chinese stored intact' ($r.Json.data.receiverName -eq $zhangsan -and $r.Json.data.receiverAddress -eq $addr1)
$idA = $r.Json.data.id
Write-Host "  idA=$idA"

# ---- 3. add second address -> not default ----
Write-Host "`n=== 3. add second address (expect isDefault=0) ==="
$r = Invoke-Api POST '/api/shop/addresses' @{ receiverName = $lisi; receiverPhone = '13800000002'; receiverAddress = $addr2 } $tkBuyer
$idB = $r.Json.data.id
Check 'isDefault=0' ($r.Json.data.isDefault -eq 0)
Write-Host "  idB=$idB"

# ---- 4. list has 2 ----
Write-Host "`n=== 4. list ==="
$r = Invoke-Api GET '/api/shop/addresses' $null $tkBuyer
Check 'count=2' ($r.Json.data.Count -eq 2)
Check 'default row first' ($r.Json.data[0].id -eq $idA)

# ---- 5. switch default to idB ----
Write-Host "`n=== 5. set idB as default ==="
$r = Invoke-Api POST "/api/shop/addresses/$idB/default" @{} $tkBuyer
Check 'code=200' ($r.Json.code -eq 200)
$r = Invoke-Api GET '/api/shop/addresses' $null $tkBuyer
Check 'idB now default' ($r.Json.data | Where-Object { $_.id -eq $idB -and $_.isDefault -eq 1 })
Check 'idA no longer default' ($r.Json.data | Where-Object { $_.id -eq $idA -and $_.isDefault -eq 0 })
Check 'still exactly one default' (@($r.Json.data | Where-Object { $_.isDefault -eq 1 }).Count -eq 1)

# ---- 6. add cart item, checkout WITHOUT addressId -> uses default (idB) ----
Write-Host "`n=== 6. checkout without addressId (expect default address idB) ==="
[void](Invoke-Api POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $tkBuyer)
$r = Invoke-Api POST '/api/shop/orders/checkout' @{ remark = 'no-address-id' } $tkBuyer
Check 'code=200' ($r.Json.code -eq 200)
Check 'receiver=lisi' ($r.Json.data.receiverName -eq $lisi)
Check 'address=addr2' ($r.Json.data.receiverAddress -eq $addr2)
$orderNo1 = $r.Json.data.orderNo
$orderId1 = $r.Json.data.id
Write-Host "  order=$orderNo1 receiver=$($r.Json.data.receiverName) addr=$($r.Json.data.receiverAddress)"

# ---- 7. checkout WITH explicit addressId=idA ----
Write-Host "`n=== 7. checkout with explicit addressId=idA ==="
[void](Invoke-Api POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $tkBuyer)
$r = Invoke-Api POST '/api/shop/orders/checkout' @{ addressId = $idA; remark = 'pick-idA' } $tkBuyer
Check 'code=200' ($r.Json.code -eq 200)
Check 'receiver=zhangsan' ($r.Json.data.receiverName -eq $zhangsan)
Check 'address=addr1' ($r.Json.data.receiverAddress -eq $addr1)
$orderId2 = $r.Json.data.id

# ---- 8. read back from DB via order detail ----
Write-Host "`n=== 8. read order back from DB (persistence proof) ==="
$r = Invoke-Api GET "/api/shop/orders/$orderId2" $null $tkBuyer
Check 'db receiver=zhangsan' ($r.Json.data.receiverName -eq $zhangsan)
Check 'db address intact' ($r.Json.data.receiverAddress -eq $addr1)

# ---- 9. bogus addressId -> 404 ----
Write-Host "`n=== 9. checkout with non-existent addressId ==="
[void](Invoke-Api POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $tkBuyer)
$r = Invoke-Api POST '/api/shop/orders/checkout' @{ addressId = 'no-such-address-id-0000000000000000' } $tkBuyer
Check 'rejected' ($r.Json.code -ne 200)
Write-Host "  code=$($r.Json.code) message=$($r.Json.message)"

# ---- 10. cross-user address -> 403 ----
Write-Host "`n=== 10. admin tries to use buyer's address idA ==="
[void](Invoke-Api POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $tkAdmin)
$r = Invoke-Api POST '/api/shop/orders/checkout' @{ addressId = $idA } $tkAdmin
Check 'rejected' ($r.Json.code -ne 200)
Write-Host "  code=$($r.Json.code) message=$($r.Json.message)"

# ---- 11. legacy fallback: admin has empty address book, hand-typed fields still work ----
Write-Host "`n=== 11. legacy fallback (empty address book + hand-typed fields) ==="
$r = Invoke-Api GET '/api/shop/addresses' $null $tkAdmin
Write-Host "  admin address count = $($r.Json.data.Count)"
[void](Invoke-Api POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $tkAdmin)
$r = Invoke-Api POST '/api/shop/orders/checkout' @{ receiverName = 'legacy'; receiverPhone = '13900000000'; receiverAddress = 'Hand Typed Address' } $tkAdmin
Check 'code=200 (compat kept)' ($r.Json.code -eq 200)
Check 'receiver=legacy' ($r.Json.data.receiverName -eq 'legacy')
$legacyOrder = $r.Json.data.orderNo

# ---- 12. empty receiver everywhere -> 400 ----
Write-Host "`n=== 12. no address at all -> rejected ==="
[void](Invoke-Api POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $tkAdmin)
$r = Invoke-Api POST '/api/shop/orders/checkout' @{ remark = 'nothing' } $tkAdmin
Check 'rejected' ($r.Json.code -ne 200)
Write-Host "  code=$($r.Json.code) message=$($r.Json.message)"

# ---- 13. update address ----
Write-Host "`n=== 13. PUT update idA address ==="
$r = Invoke-Api PUT "/api/shop/addresses/$idA" @{ receiverName = $zhangsan; receiverPhone = '13800000001'; receiverAddress = $edited } $tkBuyer
Check 'code=200' ($r.Json.code -eq 200)
$r = Invoke-Api GET '/api/shop/addresses' $null $tkBuyer
$row = $r.Json.data | Where-Object { $_.id -eq $idA }
Check 'address updated' ($row.receiverAddress -eq $edited)
$r = Invoke-Api GET "/api/shop/orders/$orderId2" $null $tkBuyer
Check 'historical order still has old address' ($r.Json.data.receiverAddress -eq $addr1)

# ---- 14. delete default -> earliest remaining promoted ----
Write-Host "`n=== 14. delete the default (idB) -> expect idA promoted ==="
$r = Invoke-Api DELETE "/api/shop/addresses/$idB" $null $tkBuyer
Check 'code=200' ($r.Json.code -eq 200)
$r = Invoke-Api GET '/api/shop/addresses' $null $tkBuyer
Check 'count=1' ($r.Json.data.Count -eq 1)
Check 'idA became default' ($r.Json.data[0].id -eq $idA -and $r.Json.data[0].isDefault -eq 1)

# ---- 15. buyer cannot see admin's addresses ----
Write-Host "`n=== 15. ownership isolation ==="
$r = Invoke-Api GET '/api/shop/addresses' $null $tkBuyer
Check 'buyer sees only own 1 address' ($r.Json.data.Count -eq 1)

Write-Host "`n================ FAILED=$Failed ================"
if ($Failed -gt 0) { exit 1 }
