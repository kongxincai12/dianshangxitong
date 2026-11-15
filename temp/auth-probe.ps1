# SHOP_USER auth probe (login / register). ASCII-only source so PS 5.1 reads it correctly.
param([int]$Port = 9901)
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
    $text = $sr.ReadToEnd(); $http = [int]$resp.StatusCode; $resp.Close()
    $json = if ($text) { $text | ConvertFrom-Json } else { $null }
    return [pscustomobject]@{ Http = $http; Json = $json; Raw = $text }
}

$script:Failed = 0
function Check($label, $cond) {
    if ($cond) { Write-Host "  [PASS] $label" }
    else { Write-Host "  [FAIL] $label" -ForegroundColor Red; $script:Failed++ }
}

$user = 'probe' + (Get-Random -Maximum 99999)

Write-Host "=== 1. legacy accounts still log in (digest migrated as-is) ==="
$r = Invoke-Api POST '/api/auth/login' @{ username = 'admin'; password = '123456' } $null
Check 'admin login code=200' ($r.Json.code -eq 200)
Check 'response has data.token' ([bool]$r.Json.data.token)
Check 'data.user.username' ($r.Json.data.user.username -eq 'admin')
Check 'data.user.fullname present' ([bool]$r.Json.data.user.fullname)
Check 'data.user.userposition present' ($null -ne $r.Json.data.user.PSObject.Properties['userposition'])
Check 'no password leaked' (-not ($r.Raw -match '1028891b'))

Write-Host "=== 2. wrong password -> 401 with legacy wording ==="
$r = Invoke-Api POST '/api/auth/login' @{ username = 'admin'; password = 'wrongpass' } $null
Check 'http 401' ($r.Http -eq 401)
Check 'code 401' ($r.Json.code -eq 401)

Write-Host "=== 3. blank credentials -> 400 ==="
$r = Invoke-Api POST '/api/auth/login' @{ username = ''; password = '' } $null
Check 'http 400' ($r.Http -eq 400)

Write-Host "=== 4. register a new customer ($user) ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = $user; password = 'abc123'; nickname = 'probe-buyer'; phone = '13800000009' } $null
Check 'code=200' ($r.Json.code -eq 200)
Check 'password not echoed' (-not ($r.Raw -match 'abc123'))

Write-Host "=== 5. new account can log in and is NOT admin ==="
$r = Invoke-Api POST '/api/auth/login' @{ username = $user; password = 'abc123' } $null
Check 'login ok' ($r.Json.code -eq 200)
$tk = $r.Json.data.token
$p = Invoke-Api GET '/api/shop/profile' $null $tk
Check 'profile.admin = false' ($p.Json.data.admin -eq $false)

Write-Host "=== 6. new customer cannot manage products ==="
$d = Invoke-Api POST '/api/shop/products' @{ name = 'x'; price = 1; stock = 1 } $tk
Check '403 on product create' ($d.Json.code -eq 403)

Write-Host "=== 7. duplicate username rejected ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = $user; password = 'abc123' } $null
Check 'rejected' ($r.Json.code -ne 200)

Write-Host "=== 8. short password rejected ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = ($user + 'x'); password = '123' } $null
Check 'rejected' ($r.Json.code -eq 400)

Write-Host "=== 9. self-registration cannot mint an admin (role forced to customer) ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = ($user + 'a'); password = 'abc123'; role = 'admin' } $null
$r = Invoke-Api POST '/api/auth/login' @{ username = ($user + 'a'); password = 'abc123' } $null
$p = Invoke-Api GET '/api/shop/profile' $null $r.Json.data.token
Check 'still not admin' ($p.Json.data.admin -eq $false)

Write-Host "`nprobe user for manual cleanup: $user  (also $($user)a)"
Write-Host "================ FAILED=$Failed ================"
if ($Failed -gt 0) { exit 1 }
