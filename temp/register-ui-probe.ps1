# Probe the exact payload shop.html's doRegister() sends (nickname/phone may be null).
param([int]$Port = 9901)
$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
$Base = "http://127.0.0.1:$Port"
$Out = "$PSScriptRoot\register-ui-probe.out.txt"
"" | Set-Content -Path $Out -Encoding ascii

function Invoke-Api {
    param([string]$Method, [string]$Path, $Body)
    $req = [System.Net.HttpWebRequest]::Create($Base + $Path)
    $req.Method = $Method
    $req.ContentType = 'application/json;charset=UTF-8'
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
    return [pscustomobject]@{ Http = $http; Raw = $text; Json = ($text | ConvertFrom-Json) }
}

$script:Failed = 0
function Check($label, $cond, $detail) {
    if ($cond) { Write-Host "  [PASS] $label" }
    else { Write-Host "  [FAIL] $label" -ForegroundColor Red; $script:Failed++ }
    if ($detail) { Add-Content -Path $Out -Value ("{0} :: {1}" -f $label, $detail) }
}

$u = 'uitest01'

Write-Host "=== register with the payload the UI sends (phone omitted -> null) ==="
$body = @{ username = $u; password = 'abc123'; nickname = 'UI-Tester'; phone = $null }
$r = Invoke-Api POST '/api/auth/register' $body
Check 'code=200 or 409(dup)' ($r.Json.code -eq 200 -or $r.Json.code -eq 409) $r.Raw

Write-Host "=== login with that account ==="
$r = Invoke-Api POST '/api/auth/login' @{ username = $u; password = 'abc123' }
Check 'login code=200' ($r.Json.code -eq 200) $r.Raw
Check 'fullname echoed' ($r.Json.data.user.fullname -eq 'UI-Tester') $r.Raw
$tk = $r.Json.data.token

Write-Host "=== token works on a guarded endpoint ==="
$req = [System.Net.HttpWebRequest]::Create($Base + '/api/shop/profile')
$req.Headers.Add('Authorization', 'Bearer ' + $tk)
$resp = $req.GetResponse()
$sr = New-Object System.IO.StreamReader($resp.GetResponseStream(), [System.Text.Encoding]::UTF8)
$raw = $sr.ReadToEnd(); $resp.Close()
Check 'profile admin=false' ((($raw | ConvertFrom-Json).data.admin) -eq $false) $raw

Write-Host "=== duplicate username -> 409 (UI shows the backend message) ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = $u; password = 'abc123'; nickname = 'X'; phone = $null }
Check 'code=409' ($r.Json.code -eq 409) $r.Raw

Write-Host "`ncleanup: delete $u from SHOP_USER"
Write-Host "================ FAILED=$Failed ================"
if ($Failed -gt 0) { exit 1 }
