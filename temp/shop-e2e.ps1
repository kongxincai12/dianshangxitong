$ErrorActionPreference = 'Stop'
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
$base = 'http://localhost:9900'
$pid_ = 'prd0000000000000000000000000002'   # 无线蓝牙耳机, 库存 500

function Body($resp) { [System.Text.Encoding]::UTF8.GetString($resp.RawContentStream.ToArray()) }
function Api($method, $path, $obj) {
  $wa = @{ Uri = $base + $path; Method = $method; UseBasicParsing = $true; TimeoutSec = 30 }
  if ($token) { $wa.Headers = @{ Authorization = "Bearer $token" } }
  if ($null -ne $obj) {
    $json = $obj | ConvertTo-Json -Compress
    $wa.ContentType = 'application/json'
    $wa.Body = [System.Text.Encoding]::UTF8.GetBytes($json)
  }
  try { return (Body (Invoke-WebRequest @wa)) }
  catch {
    $r = $_.Exception.Response
    if ($r) { return "HTTP $([int]$r.StatusCode) " + (New-Object System.IO.StreamReader($r.GetResponseStream())).ReadToEnd() }
    throw
  }
}

# 1. 登录取 token
$login = (Api 'Post' '/api/auth/login' @{ username = 'admin'; password = '123456' }) | ConvertFrom-Json
$token = $login.data.token
"[1] 登录 code=$($login.code) user=$($login.data.user.username) tokenLen=$($token.Length)"

# 2. 加购物车
"[2] 加入购物车 -> " + (Api 'Post' '/api/shop/cart' @{ productId = $pid_; quantity = 2 })

# 3. 查购物车
$cartRaw = Api 'Get' '/api/shop/cart' $null
"[3] 购物车 -> $cartRaw"
$cart = $cartRaw | ConvertFrom-Json
$cartId = $cart.data[0].id

# 4. 改数量
"[4] 改数量为 3 -> " + (Api 'Put' "/api/shop/cart/$cartId" @{ quantity = 3 })

# 5. 结算下单
$orderRaw = Api 'Post' '/api/shop/orders/checkout' @{
  receiverName = '测试收货人'; receiverPhone = '13800000000'; receiverAddress = '测试地址 1 号'; remark = '接口联调'
}
"[5] 下单 -> $orderRaw"
$order = $orderRaw | ConvertFrom-Json
$orderId = $order.data.id

# 6. 查订单详情
"[6] 订单详情 -> " + (Api 'Get' "/api/shop/orders/$orderId" $null)

# 7. 取消订单（库存回补）
"[7] 取消订单 -> " + (Api 'Post' "/api/shop/orders/$orderId/cancel" $null)

# 8. 校验库存是否回到 500
$prod = (Api 'Get' "/api/shop/products/$pid_" $null) | ConvertFrom-Json
"[8] 商品库存 = $($prod.data.stock) (期望 500), 状态 = $($prod.data.name)"

# 9. 清空购物车
"[9] 清空购物车 -> " + (Api 'Delete' '/api/shop/cart' $null)

# 10. 订单列表
"[10] 订单列表 -> " + (Api 'Get' '/api/shop/orders?pageNo=1&pageSize=5' $null)
