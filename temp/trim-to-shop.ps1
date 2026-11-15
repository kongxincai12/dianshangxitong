param([switch]$Apply)

# Trim the monolith down to the shop (e-commerce) module only.
# Deletions go through `git rm`, so everything stays recoverable from the
# backup-mes-full branch and from git history.
$ErrorActionPreference = 'Stop'
Set-Location (Split-Path $PSScriptRoot -Parent)
$root = $PWD.Path

$keepJava = @(
'com/jcd/PdaserverApplication.java'
'com/jcd/config/AlipayConfig.java'
'com/jcd/config/JwtInterceptor.java'
'com/jcd/config/MyWebConfigurer.java'
'com/jcd/config/ShopAdminGuard.java'
'com/jcd/controller/AlipayController.java'
'com/jcd/controller/shop/ShopAddressController.java'
'com/jcd/controller/shop/ShopCartController.java'
'com/jcd/controller/shop/ShopOrderController.java'
'com/jcd/controller/shop/ShopProductController.java'
'com/jcd/dto/AlipayPayRequestDto.java'
'com/jcd/dto/AlipayPayResponseDto.java'
'com/jcd/dto/AlipayQueryRequestDto.java'
'com/jcd/dto/AlipayRefundRequestDto.java'
'com/jcd/dto/shop/CartItemDto.java'
'com/jcd/dto/shop/CheckoutDto.java'
'com/jcd/dto/shop/ShopLoginDto.java'
'com/jcd/dto/shop/ShopRegisterDto.java'
'com/jcd/exception/BusinessException.java'
'com/jcd/exception/GlobalExceptionHandler.java'
'com/jcd/mapper/PaymentOrderMapper.java'
'com/jcd/mapper/shop/ShopAddressMapper.java'
'com/jcd/mapper/shop/ShopCartMapper.java'
'com/jcd/mapper/shop/ShopCategoryMapper.java'
'com/jcd/mapper/shop/ShopOrderMapper.java'
'com/jcd/mapper/shop/ShopProductMapper.java'
'com/jcd/mapper/shop/ShopUserMapper.java'
'com/jcd/model/PaymentOrder.java'
'com/jcd/model/shop/ShopAddress.java'
'com/jcd/model/shop/ShopCart.java'
'com/jcd/model/shop/ShopCategory.java'
'com/jcd/model/shop/ShopOrder.java'
'com/jcd/model/shop/ShopOrderItem.java'
'com/jcd/model/shop/ShopProduct.java'
'com/jcd/model/shop/ShopUser.java'
'com/jcd/service/AlipayService.java'
'com/jcd/service/Impl/AlipayServiceImpl.java'
'com/jcd/service/shop/ShopAddressService.java'
'com/jcd/service/shop/ShopCartService.java'
'com/jcd/service/shop/ShopOrderService.java'
'com/jcd/service/shop/ShopProductService.java'
'com/jcd/service/shop/ShopUserService.java'
'com/jcd/service/shop/impl/ShopAddressServiceImpl.java'
'com/jcd/service/shop/impl/ShopCartServiceImpl.java'
'com/jcd/service/shop/impl/ShopOrderServiceImpl.java'
'com/jcd/service/shop/impl/ShopProductServiceImpl.java'
'com/jcd/utils/JwtUtils.java'
'com/jcd/utils/Result.java'
)

# path relative to a base directory, forward slashes
function Rel([string]$full, [string]$base) {
    if (-not $full.StartsWith($base)) { throw "not under base: $full" }
    return $full.Substring($base.Length).TrimStart('\').Replace('\', '/')
}

$srcJava = Join-Path $root 'src\main\java'
$srcRes  = Join-Path $root 'src\main\resources'
$srcTest = Join-Path $root 'src\test\java'

$javaKeep = New-Object System.Collections.Generic.List[string]
$javaDel  = New-Object System.Collections.Generic.List[string]
Get-ChildItem $srcJava -Recurse -Filter *.java | ForEach-Object {
    $rel = Rel $_.FullName $srcJava
    if ($keepJava -contains $rel) { $javaKeep.Add($rel) } else { $javaDel.Add("src/main/java/$rel") }
}

$xmlDel = New-Object System.Collections.Generic.List[string]
$xmlKeep = New-Object System.Collections.Generic.List[string]
Get-ChildItem (Join-Path $srcRes 'mapper') -Recurse -Filter *.xml | ForEach-Object {
    $rel = Rel $_.FullName $srcRes
    if ($rel -like 'mapper/shop/*' -or $rel -eq 'mapper/PaymentOrderMapper.xml') {
        $xmlKeep.Add($rel)
    } else { $xmlDel.Add("src/main/resources/$rel") }
}

$testDel = New-Object System.Collections.Generic.List[string]
Get-ChildItem $srcTest -Recurse -Filter *.java | ForEach-Object {
    $rel = Rel $_.FullName $srcTest
    if ($rel -match 'factory|PdaServiceImpl') { $testDel.Add("src/test/java/$rel") }
}

$sqlDel = New-Object System.Collections.Generic.List[string]
$keepSqlFiles = @('create_shop_tables.sql','create_shop_user.sql','create_shop_address_table.sql','create_pda_payment_order.sql')
Get-ChildItem (Join-Path $root 'sql') -File | ForEach-Object {
    if ($keepSqlFiles -notcontains $_.Name) { $sqlDel.Add("sql/$($_.Name)") }
}
$sqlDirDel = New-Object System.Collections.Generic.List[string]
Get-ChildItem (Join-Path $root 'sql') -Directory | ForEach-Object { $sqlDirDel.Add("sql/$($_.Name)") }

$docDel = New-Object System.Collections.Generic.List[string]
Get-ChildItem (Join-Path $root 'doc') -Recurse -File | ForEach-Object {
    $rel = Rel $_.FullName $root
    if ($rel -ne 'doc/shop_api.postman_collection.json') { $docDel.Add($rel) }
}
if (Test-Path (Join-Path $root 'create_pda_eqp_station_rel.sql')) {
    $docDel.Add('create_pda_eqp_station_rel.sql')
}
if (Test-Path (Join-Path $root 'src\main\resources\META-INF\spring.factories')) {
    $docDel.Add('src/main/resources/META-INF/spring.factories')
}

Write-Host "KEEP java  : $($javaKeep.Count)"
Write-Host "DEL  java  : $($javaDel.Count)"
Write-Host "KEEP xml   : $($xmlKeep.Count)  -> $($xmlKeep -join ', ')"
Write-Host "DEL  xml   : $($xmlDel.Count)"
Write-Host "DEL  test  : $($testDel.Count)"
Write-Host "DEL  sql   : $($sqlDel.Count) file(s) + $($sqlDirDel.Count) dir(s) -> $($sqlDirDel -join ', ')"
Write-Host "DEL  misc  : $($docDel.Count)"
Write-Host "DEL  docs  : whole directory (contains non-ascii names, removed via git rm -r)"

if (-not $Apply) {
    Write-Host "`nDRY RUN only. Re-run with -Apply to delete through git rm."
    exit 0
}

function Remove-Batch($paths, [string]$label) {
    if ($paths.Count -eq 0) { return }
    $arr = @($paths)
    for ($i = 0; $i -lt $arr.Count; $i += 40) {
        $end = [Math]::Min($i + 39, $arr.Count - 1)
        $slice = $arr[$i..$end]
        # no --ignore-unmatch on purpose: a wrong path must fail loudly, not be skipped
        $out = git rm --quiet -- $slice 2>&1
        if ($LASTEXITCODE -ne 0) {
            Write-Host "git rm FAILED for batch at index $i (first: $($slice[0]))" -ForegroundColor Red
            $out | Select-Object -First 3 | ForEach-Object { Write-Host "    $_" }
            $script:GitFail++
        }
    }
    Write-Host "removed $label : $($paths.Count) (git failures: $GitFail)"
}

$script:GitFail = 0

Remove-Batch $javaDel 'java'
Remove-Batch $xmlDel  'xml'
Remove-Batch $testDel 'test'
Remove-Batch $sqlDel  'sql'
Remove-Batch $docDel  'misc'

foreach ($d in $sqlDirDel) {
    git rm -r --quiet --ignore-unmatch -- $d 2>&1 | Out-Null
}
if ($sqlDirDel.Count -gt 0) { Write-Host "removed sql subdirs : $($sqlDirDel -join ', ')" }

git rm -r --quiet --ignore-unmatch -- docs 2>&1 | Out-Null
Write-Host "removed docs directory"

Write-Host "`njava left : $((Get-ChildItem $srcJava -Recurse -Filter *.java -ErrorAction SilentlyContinue | Measure-Object).Count)"
Write-Host "xml left  : $((Get-ChildItem (Join-Path $srcRes 'mapper') -Recurse -Filter *.xml -ErrorAction SilentlyContinue | Measure-Object).Count)"
