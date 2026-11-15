# Verify the Chinese ROLE whitelist path end to end:
#   Oracle ZHS16GBK -> JDBC -> Java String -> JWT claim  vs.
#   application.properties (\uXXXX escaped) -> Spring ISO-8859-1 read -> Java String
# Kept ASCII-only so PS 5.1 cannot mangle it; Chinese is built from code points.
param([int]$Port = 9900)
$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
$Base = "http://127.0.0.1:$Port"
$Java = "C:\Program Files\Java\jdk-17.0.4\bin\java.exe"
$Cp = "temp\sqlrunner;C:\Users\Administrator\.m2\repository\com\oracle\database\jdbc\ojdbc8\21.5.0.0\ojdbc8-21.5.0.0.jar;C:\Users\Administrator\.m2\repository\cn\easyproject\orai18n\12.1.0.2.0\orai18n-12.1.0.2.0.jar"
$Url = "jdbc:oracle:thin:@//localhost:1521/orcl"

$adminRole = [string]([char]0x7BA1 + [char]0x7406 + [char]0x5458)   # guan-li-yuan
$otherRole = [string]([char]0x5DE5 + [char]0x7A0B + [char]0x5E08)   # gong-cheng-shi

function Invoke-Api($Method, $Path, $Body, $Token) {
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
    catch [System.Net.WebException] { $resp = $_.Exception.Response; if ($null -eq $resp) { throw } }
    $sr = New-Object System.IO.StreamReader($resp.GetResponseStream(), [System.Text.Encoding]::UTF8)
    $text = $sr.ReadToEnd(); $resp.Close()
    return ($text | ConvertFrom-Json)
}

function RunSql($sqlText, $tag) {
    $f = "temp\role-cn-run.sql"
    # UTF-8 without BOM, otherwise Oracle sees a garbage first token
    [System.IO.File]::WriteAllText((Join-Path (Get-Location) $f), $sqlText, (New-Object System.Text.UTF8Encoding($false)))
    # the runner prints [OK]/[FAIL] but still exits 0, so the text is the real signal
    $out = & $Java -cp $Cp ShopSqlRunner $f $Url JCD_SZ wzw2015578 | Out-String
    if ($LASTEXITCODE -ne 0 -or $out -match 'FAIL') { throw "SQL step '$tag' failed:`n$out" }
}

function AdminOf($roleLabel) {
    $j = Invoke-Api POST '/api/auth/login' @{ username = 'roletest1'; password = 'abc123' } $null
    $p = Invoke-Api GET '/api/shop/profile' $null $j.data.token
    return $p.data.admin
}

$script:Failed = 0
function Check($label, $cond, $actual) {
    if ($cond) { Write-Host "  [PASS] $label" }
    else { Write-Host "  [FAIL] $label  actual=$actual" -ForegroundColor Red; $script:Failed++ }
}

Write-Host "=== setup: register roletest1 (self-service role is always customer) ==="
$r = Invoke-Api POST '/api/auth/register' @{ username = 'roletest1'; password = 'abc123'; nickname = 'RoleTest'; phone = $null } $null
Check 'register code=200' ($r.code -eq 200) ($r | ConvertTo-Json -Compress)
Check 'customer is not admin' ((AdminOf 'init') -eq $false) 'expect false'

Write-Host "=== case A: ROLE = admin-role from properties -> admin must be true ==="
RunSql "UPDATE SHOP_USER SET ROLE = '$adminRole' WHERE USERNAME = 'roletest1';`nCOMMIT;`n" 'admin-role'
$v = AdminOf $adminRole
Check 'admin flag = true (Chinese ROLE matched)' ($v -eq $true) $v

Write-Host "=== case B: ROLE = a role NOT in the whitelist -> admin must be false ==="
RunSql "UPDATE SHOP_USER SET ROLE = '$otherRole' WHERE USERNAME = 'roletest1';`nCOMMIT;`n" 'other-role'
$v = AdminOf $otherRole
Check 'admin flag = false (not a blanket "any role wins")' ($v -eq $false) $v

Write-Host "=== cleanup ==="
RunSql "DELETE FROM SHOP_USER WHERE USERNAME = 'roletest1';`nCOMMIT;`n" 'delete'
$j = Invoke-Api POST '/api/auth/login' @{ username = 'roletest1'; password = 'abc123' } $null
Check 'account really removed (login code=401)' ($j.code -eq 401) $j.code

Write-Host "`n================ FAILED=$Failed ================"
if ($Failed -gt 0) { exit 1 }
