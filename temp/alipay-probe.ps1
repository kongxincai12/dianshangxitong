# Alipay integration probe. ASCII-only source so PS 5.1 reads it correctly.
param([int]$Port = 9900, [string]$TunnelHost = 'sb76aff6.natappfree.cc')
$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
[Console]::OutputEncoding = [Text.Encoding]::UTF8
$Base = 'http://localhost:' + $Port

function Send-Req($method, $path, $body, $token) {
  $hs = @{ 'Content-Type' = 'application/json' }
  if ($token) { $hs['Authorization'] = "Bearer $token" }
  $a = @{ Uri = ($Base + $path); Method = $method; Headers = $hs; UseBasicParsing = $true; TimeoutSec = 90 }
  if ($body) { $a['Body'] = ($body | ConvertTo-Json -Depth 8 -Compress) }
  $resp = Invoke-WebRequest @a
  $txt = [Text.Encoding]::UTF8.GetString($resp.RawContentStream.ToArray())
  if ($txt) { return ($txt | ConvertFrom-Json) } else { return $null }
}

Write-Host '=== 1. login ==='
$lg = Send-Req POST '/api/auth/login' @{ username = 'admin'; password = '123456' } $null
if ($lg.code -ne 200) { throw ('login failed: ' + $lg.message) }
$tk = $lg.data.token
Write-Host ('ok, token len = ' + $tk.Length)

Write-Host '=== 2. pay on a CANCELLED shop order (should be rejected, also proves selectByOrderNo SQL) ==='
$r2 = Send-Req POST '/api/alipay/pay' @{ subject = 'probe-cancelled'; totalAmount = 0.01; outTradeNo = 'SO202611150001' } $tk
Write-Host ('code=' + $r2.code + ' message=' + $r2.message)

Write-Host '=== 3. create a fresh PENDING order ==='
$prods = (Send-Req GET '/api/shop/products?pageNo=1&pageSize=20&status=1' $null $tk).data
# a product with 0 stock makes checkout fail on 409 and hides the real alipay result
$p = $prods.list | Where-Object { $_.stock -gt 0 } | Select-Object -First 1
$pid1 = $p.id
Write-Host ('product: ' + $pid1 + ' price=' + $p.price)
$null = Send-Req DELETE '/api/shop/cart' $null $tk
$null = Send-Req POST '/api/shop/cart' @{ productId = $pid1; quantity = 1 } $tk
$order = (Send-Req POST '/api/shop/orders/checkout' @{
  receiverName = 'test'; receiverPhone = '13800000000'; receiverAddress = 'sz road 1'; remark = 'alipay probe'
} $tk).data
Write-Host ('orderNo=' + $order.orderNo + ' id=' + $order.id + ' amount=' + $order.totalAmount + ' status=' + $order.status)

Write-Host '=== 4. POST /api/alipay/pay with the real PENDING orderNo ==='
$r4 = Send-Req POST '/api/alipay/pay' @{
  subject = 'shop-order-' + $order.orderNo
  body = 'alipay probe'
  totalAmount = [double]$order.totalAmount
  outTradeNo = $order.orderNo
  timeoutExpress = '30m'
  createBy = 'admin'
} $tk
Write-Host ('code=' + $r4.code)
if ($r4.code -eq 200) {
  Write-Host ('payType=' + $r4.data.payType + ' totalAmount=' + $r4.data.totalAmount + ' outTradeNo=' + $r4.data.outTradeNo)
  $u = $r4.data.payUrl
  if ($u.Length -gt 160) { $u = $u.Substring(0, 160) + ' ...[len=' + $r4.data.payUrl.Length + ']' }
  Write-Host ('payUrl=' + $u)
} else { Write-Host ('message=' + $r4.message) }

Write-Host '=== 5. pay again (reuse existing payment order) ==='
$r5 = Send-Req POST '/api/alipay/pay' @{
  subject = 'shop-order-' + $order.orderNo; totalAmount = 0.01; outTradeNo = $order.orderNo
} $tk
Write-Host ('code=' + $r5.code + ' totalAmount(should follow DB)=' + $r5.data.totalAmount + ' msg=' + $r5.message)

Write-Host '=== 6. local payment order ==='
$r6 = Send-Req GET ('/api/alipay/query/' + $order.orderNo) $null $tk
Write-Host ('code=' + $r6.code + ' orderStatus=' + $r6.data.orderStatus + ' amount=' + $r6.data.totalAmount)

Write-Host '=== 7. unsigned notify (must be rejected by signature check) ==='
$notifyBody = 'out_trade_no=' + $order.orderNo + '&trade_no=2026111522001000000000000000&trade_status=TRADE_SUCCESS&total_amount=' + $order.totalAmount + '&sign=abc&sign_type=RSA2'
$na = @{ Uri = ($Base + '/api/alipay/notify'); Method = 'Post'; Headers = @{ 'Content-Type' = 'application/x-www-form-urlencoded' }; Body = $notifyBody; UseBasicParsing = $true }
$nresp = Invoke-WebRequest @na
Write-Host ('notify response = [' + ([Text.Encoding]::UTF8.GetString($nresp.RawContentStream.ToArray())) + ']')

Write-Host '=== 8. order status must still be PENDING ==='
$r8 = Send-Req GET ('/api/shop/orders/' + $order.id) $null $tk
Write-Host ('status=' + $r8.data.status + ' payTime=' + $r8.data.payTime)

Write-Host '=== 9. active query to alipay (settle-by-query path, no crash expected) ==='
$r9 = Send-Req POST '/api/alipay/query/status' @{ outTradeNo = $order.orderNo } $tk
Write-Host ('code=' + $r9.code + ' data=' + ($r9.data | ConvertTo-Json -Compress) + ' msg=' + $r9.message)

Write-Host '=== 10. notify tunnel reachability (public natapp url in config) ==='
try {
  $t = Invoke-WebRequest -Uri ('http://' + $TunnelHost + '/api/alipay/notify') -Method Post -Body 'out_trade_no=probe' -ContentType 'application/x-www-form-urlencoded' -UseBasicParsing -TimeoutSec 15
  Write-Host ('tunnel HTTP 200, body head = ' + (([Text.Encoding]::UTF8.GetString($t.RawContentStream.ToArray())).Substring(0, 80)))
} catch {
  Write-Host ('tunnel unreachable: ' + $_.Exception.Message)
}
Write-Host '=== DONE, orderNo=' + $order.orderNo + ' ==='
