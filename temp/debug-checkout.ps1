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
    return [pscustomobject]@{ Http = $http; Raw = $text }
}

$tk = (Invoke-Api POST '/api/auth/login' @{ username = 'buyer1'; password = '123456' }).Raw | ConvertFrom-Json
$token = $tk.data.token
Write-Host "cart:"
(Invoke-Api GET '/api/shop/cart' $null $token).Raw
Write-Host "`naddresses:"
(Invoke-Api GET '/api/shop/addresses' $null $token).Raw
$pid1 = ((Invoke-Api GET '/api/shop/products?pageNo=1&pageSize=1&status=1' $null $token).Raw | ConvertFrom-Json).data.list[0].id
[void](Invoke-Api POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $token)
Write-Host "`ncheckout (no addressId):"
(Invoke-Api POST '/api/shop/orders/checkout' @{ remark = 'debug' } $token).Raw
