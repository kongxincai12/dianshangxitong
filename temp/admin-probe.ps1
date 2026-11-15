# Shop admin permission probe. ASCII-only source.
param([int]$Port = 9901)
$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
[Console]::OutputEncoding = [Text.Encoding]::UTF8
$Base = 'http://localhost:' + $Port

function Send-Req($method, $path, $body, $token) {
  $hs = @{ 'Content-Type' = 'application/json' }
  if ($token) { $hs['Authorization'] = "Bearer $token" }
  $a = @{ Uri = ($Base + $path); Method = $method; Headers = $hs; UseBasicParsing = $true; TimeoutSec = 60 }
  if ($body) { $a['Body'] = ($body | ConvertTo-Json -Depth 8 -Compress) }
  try {
    $resp = Invoke-WebRequest @a
    $txt = [Text.Encoding]::UTF8.GetString($resp.RawContentStream.ToArray())
    return ($txt | ConvertFrom-Json)
  } catch [System.Net.WebException] {
    $r = $_.Exception.Response
    if ($r -ne $null) {
      $sr = New-Object IO.StreamReader($r.GetResponseStream(), [Text.Encoding]::UTF8)
      $txt = $sr.ReadToEnd()
      try { return ($txt | ConvertFrom-Json) } catch { return @{ code = [int]$r.StatusCode; message = $txt } }
    }
    throw
  }
}

function Login($u, $pw) {
  $r = Send-Req POST '/api/auth/login' @{ username = $u; password = $pw } $null
  if ($r.code -ne 200) { throw ('login ' + $u + ' failed: code=' + $r.code + ' ' + $r.message) }
  return $r.data.token
}

Write-Host '=== admin token ==='
$tkAdmin = Login 'admin' '123456'
Write-Host ('ok len=' + $tkAdmin.Length)

Write-Host '=== 1. GET /api/shop/profile as admin ==='
$p1 = Send-Req GET '/api/shop/profile' $null $tkAdmin
Write-Host ('code=' + $p1.code + ' username=' + $p1.data.username + ' userposition=' + $p1.data.userposition + ' admin=' + $p1.data.admin)

Write-Host '=== 2. buyer token ==='
$tkBuyer = Login 'buyer1' '123456'
Write-Host ('ok len=' + $tkBuyer.Length)

Write-Host '=== 3. GET /api/shop/profile as buyer ==='
$p3 = Send-Req GET '/api/shop/profile' $null $tkBuyer
Write-Host ('code=' + $p3.code + ' username=' + $p3.data.username + ' userposition=' + $p3.data.userposition + ' admin=' + $p3.data.admin)

$prod = (Send-Req GET '/api/shop/products?pageNo=1&pageSize=1&status=1' $null $tkBuyer).data.list[0]
$pid1 = $prod.id
Write-Host ('=== product under test: ' + $pid1 + ' (' + $prod.name + ') ===')

Write-Host '=== 4. buyer READ products (must be allowed) ==='
$p4 = Send-Req GET '/api/shop/products?pageNo=1&pageSize=3&status=1' $null $tkBuyer
Write-Host ('code=' + $p4.code + ' total=' + $p4.data.total)

Write-Host '=== 5. buyer POST product status (must be 403) ==='
$p5 = Send-Req POST ('/api/shop/products/' + $pid1 + '/status?status=1') $null $tkBuyer
Write-Host ('code=' + $p5.code + ' message=' + $p5.message)

Write-Host '=== 6. buyer POST category (must be 403, nothing inserted) ==='
$p6 = Send-Req POST '/api/shop/categories' @{ name = 'should-be-denied'; sortNo = 99 } $tkBuyer
Write-Host ('code=' + $p6.code + ' message=' + $p6.message)

Write-Host '=== 7. buyer POST product (must be 403) ==='
$p7 = Send-Req POST '/api/shop/products' @{ name = 'denied-product'; price = 1; stock = 1; status = 1 } $tkBuyer
Write-Host ('code=' + $p7.code + ' message=' + $p7.message)

Write-Host '=== 8. buyer DELETE product (must be 403) ==='
$p8 = Send-Req DELETE ('/api/shop/products/' + $pid1) $null $tkBuyer
Write-Host ('code=' + $p8.code + ' message=' + $p8.message)

Write-Host '=== 9. admin POST product status (must be allowed) ==='
$p9 = Send-Req POST ('/api/shop/products/' + $pid1 + '/status?status=1') $null $tkAdmin
Write-Host ('code=' + $p9.code + ' message=' + $p9.message)

Write-Host '=== 10. no token at all (must be 401) ==='
$p10 = Send-Req GET '/api/shop/profile' $null $null
Write-Host ('code=' + $p10.code + ' message=' + $p10.message)

Write-Host '=== 11. category count unchanged after denied writes ==='
$p11 = Send-Req GET '/api/shop/categories' $null $tkBuyer
Write-Host ('code=' + $p11.code + ' categories=' + $p11.data.Count)
Write-Host '=== DONE ==='
