# Server-side half of the 5 scenarios. Uses apitest88 so it never collides with the
# browser run, which is configured with uitest88.
param([int]$Port = 9900)
$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
$Base = "http://127.0.0.1:$Port"

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
    $text = $sr.ReadToEnd(); $code = [int]$resp.StatusCode; $resp.Close()
    return [pscustomobject]@{ Http = $code; Json = ($text | ConvertFrom-Json); Raw = $text }
}

function AdminFlag([string]$Token) {
    $r = Invoke-Api GET '/api/shop/profile' $null $Token
    return $r.Json.data.admin
}

$script:Failed = 0
function Check($label, $cond, $detail) {
    if ($cond) { Write-Host "  [PASS] $label" }
    else { Write-Host "  [FAIL] $label  -> $detail" -ForegroundColor Red; $script:Failed++ }
}

$u = 'apitest88'

Write-Host "=== scenario 3: register a brand new account, then log in with it ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = $u; password = 'abc123'; nickname = 'API-Tester'; phone = $null }
Check 'register code=200' ($r.Json.code -eq 200) $r.Raw

$r = Invoke-Api POST '/api/auth/login' @{ username = $u; password = 'abc123' }
Check 'login code=200' ($r.Json.code -eq 200) $r.Raw
Check 'token issued' ([bool]$r.Json.data.token) $r.Raw
Check 'fullname = nickname' ($r.Json.data.user.fullname -eq 'API-Tester') $r.Raw
Check 'profile.admin=false' ((AdminFlag $r.Json.data.token) -eq $false) 'new account must not be admin'

Write-Host "=== scenario 4: same username again -> 409 ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = $u; password = 'abc123'; nickname = 'X'; phone = $null }
Check 'code=409' ($r.Json.code -eq 409) $r.Raw

Write-Host "=== scenario 5: legacy accounts still work ==="
$r = Invoke-Api POST '/api/auth/login' @{ username = 'admin'; password = '123456' }
Check 'admin login code=200' ($r.Json.code -eq 200) $r.Raw
Check 'admin is admin' ((AdminFlag $r.Json.data.token) -eq $true) 'admin flag must be true'
$adminName = $r.Json.data.user.fullname

$r = Invoke-Api POST '/api/auth/login' @{ username = 'buyer1'; password = '123456' }
Check 'buyer1 login code=200' ($r.Json.code -eq 200) $r.Raw
Check 'buyer1 is NOT admin' ((AdminFlag $r.Json.data.token) -eq $false) 'buyer1 flag must be false'
$buyerName = $r.Json.data.user.fullname

Write-Host "=== wrong password on the new account -> 401 ==="
$r = Invoke-Api POST '/api/auth/login' @{ username = $u; password = 'wrong1' }
Check 'http 401' ($r.Http -eq 401) $r.Raw

Write-Host ""
Write-Host "legacy fullnames: admin=[$adminName] buyer1=[$buyerName]"
Write-Host "cleanup target: delete $u from SHOP_USER"
Write-Host "================ FAILED=$Failed ================"
if ($Failed -gt 0) { exit 1 }
