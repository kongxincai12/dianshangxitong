# ✅ QMS 异常处理和 Shift 字段修复

## 🔴 发现的问题

### 问题 1: 异常没有返回给前端
```
java.lang.Exception: QMS返回错误: Shift ( day: 0 / night: 1 )
```

**问题**：
- ❌ QMS 发送失败时抛出异常
- ❌ 异常被 catch 捕获，但前端收不到详细错误信息
- ❌ 用户只看到通用错误，无法定位问题

### 问题 2: Shift 字段值不符合 QMS 要求
QMS 错误信息 **"Shift ( day: 0 / night: 1 )"** 说明：
- QMS 要求 shift 值必须是：
  - 白班（day）: `"0"`
  - 夜班（night）: `"1"`
- 如果发送了其他值（如 "白班"、"夜班"、空字符串等），QMS 会拒绝

---

## ✅ 已修复内容

### 1. 改进异常处理 - 返回详细错误给前端

#### DataUploadController.java
```java
try {
    QmsApiService.SendResult sendResult = qmsApiService.sendData(result.getDataList());
    
    // 根据结果返回
    if (failCount == 0) {
        // 全部成功
    } else {
        // 部分失败或全部失败
    }
    
} catch (Exception qmsException) {
    // ✅ 捕获 QMS 异常并返回给前端
    String errorMsg = qmsException.getMessage();
    logger.error("QMS 发送异常: {}", errorMsg, qmsException);
    
    response.put("success", false);
    response.put("message", "发送到 QMS 失败: " + errorMsg);
    response.put("errorDetail", errorMsg);  // 详细错误信息
    
    return ResponseEntity.status(500).body(response);
}
```

**前端将收到**：
```json
{
  "success": false,
  "message": "发送到 QMS 失败: Shift ( day: 0 / night: 1 )",
  "errorDetail": "Shift ( day: 0 / night: 1 )",
  "batchId": "BATCH_20260124180000",
  "fileName": "test.xlsx",
  "totalRows": 100
}
```

---

### 2. 添加 Shift 字段标准化逻辑

#### 新增 normalizeShift 方法

```java
/**
 * 标准化 shift 字段值
 * QMS 要求: day: 0 / night: 1
 */
private String normalizeShift(String shift) {
    if (shift == null || shift.trim().isEmpty()) {
        return "0"; // 默认白班
    }
    
    String trimmed = shift.trim();
    
    // 如果已经是 0 或 1，直接返回
    if ("0".equals(trimmed) || "1".equals(trimmed)) {
        return trimmed;
    }
    
    // 转换中文或英文描述
    String lower = trimmed.toLowerCase();
    if (lower.contains("白") || lower.contains("day") || lower.contains("早")) {
        return "0";
    } else if (lower.contains("夜") || lower.contains("晚") || lower.contains("night")) {
        return "1";
    }
    
    // 默认返回 0
    logger.warn("无法识别的 shift 值: {}, 默认为 0（白班）", shift);
    return "0";
}
```

#### 转换规则

| Excel 中的值 | 转换后 | 说明 |
|-------------|--------|------|
| `"0"` | `"0"` | 直接使用 ✅ |
| `"1"` | `"1"` | 直接使用 ✅ |
| `"白班"` | `"0"` | 自动转换 ✅ |
| `"夜班"` | `"1"` | 自动转换 ✅ |
| `"day"` | `"0"` | 自动转换 ✅ |
| `"night"` | `"1"` | 自动转换 ✅ |
| `"早班"` | `"0"` | 自动转换 ✅ |
| `"晚班"` | `"1"` | 自动转换 ✅ |
| 空值/null | `"0"` | 默认白班 ✅ |
| 其他值 | `"0"` | 默认白班 + 警告日志 ⚠️ |

---

## 📊 前端响应示例

### 情况 1: QMS 参数错误
```json
{
  "success": false,
  "message": "发送到 QMS 失败: Shift ( day: 0 / night: 1 )",
  "errorDetail": "Shift ( day: 0 / night: 1 )",
  "batchId": "BATCH_20260124180000",
  "fileName": "test.xlsx",
  "totalRows": 2
}
```
**HTTP Status**: 500

---

### 情况 2: QMS 网络错误
```json
{
  "success": false,
  "message": "发送到 QMS 失败: Connection timeout",
  "errorDetail": "Connection timeout",
  "batchId": "BATCH_20260124180000",
  "fileName": "test.xlsx",
  "totalRows": 2
}
```
**HTTP Status**: 500

---

### 情况 3: QMS 认证失败
```json
{
  "success": false,
  "message": "发送到 QMS 失败: 签名验证失败",
  "errorDetail": "签名验证失败",
  "batchId": "BATCH_20260124180000",
  "fileName": "test.xlsx",
  "totalRows": 2
}
```
**HTTP Status**: 500

---

### 情况 4: 成功（修复后）
```json
{
  "success": true,
  "message": "上传成功！共 2 条数据，全部发送到 QMS 成功",
  "batchId": "BATCH_20260124180000",
  "fileName": "test.xlsx",
  "totalRows": 2,
  "successCount": 2,
  "failCount": 0
}
```
**HTTP Status**: 200

---

## 🎯 使用建议

### Excel 模板中 shift 列的填写

#### 推荐方式（最佳）
直接使用数字：
- 白班: `0`
- 夜班: `1`

#### 兼容方式（自动转换）
使用中文或英文：
- 白班: `白班`、`day`、`早班`
- 夜班: `夜班`、`night`、`晚班`

#### 示例数据
```
供应商编码 | ... | 班别 | 测试项 | ...
SUP001    | ... | 0    | 电压   | ...
SUP001    | ... | 1    | 电压   | ...
SUP001    | ... | 白班  | 电压   | ...  (自动转换为 0)
SUP001    | ... | 夜班  | 电压   | ...  (自动转换为 1)
```

---

## 📝 日志增强

### 添加的日志

#### 1. Shift 转换日志
```
DEBUG - 数据 123 shift 值: 原始=白班, 转换后=0
WARN  - 无法识别的 shift 值: ABC, 默认为 0（白班）
```

#### 2. QMS 异常日志
```
ERROR - QMS 发送异常: Shift ( day: 0 / night: 1 )
```

---

## 🧪 测试验证

### 测试 1: Shift 值为 "0" 或 "1"
```
✅ 预期: 直接发送，QMS 接受
```

### 测试 2: Shift 值为中文
```
输入: "白班" 或 "夜班"
✅ 预期: 自动转换为 "0" 或 "1"，QMS 接受
```

### 测试 3: Shift 值为空
```
输入: 空值或 null
✅ 预期: 默认转换为 "0"（白班），QMS 接受
```

### 测试 4: Shift 值为其他
```
输入: "ABC" 或其他无法识别的值
✅ 预期: 默认转换为 "0"，记录警告日志，QMS 接受
```

### 测试 5: QMS 返回错误
```
✅ 预期: 前端收到详细的错误信息
```

---

## 🔧 前端处理建议

### 显示详细错误信息

```javascript
if (!response.success) {
  if (response.errorDetail) {
    // 显示详细错误
    showError(`上传失败: ${response.message}\n详细信息: ${response.errorDetail}`);
    
    // 如果是 Shift 错误，给出友好提示
    if (response.errorDetail.includes('Shift')) {
      showTip('请确保 Excel 中的"班别"列填写正确：白班填写 0，夜班填写 1');
    }
  } else {
    showError(response.message);
  }
}
```

### 错误提示示例

```html
<div class="alert alert-danger">
  <h4>❌ 上传失败</h4>
  <p>发送到 QMS 失败: Shift ( day: 0 / night: 1 )</p>
  <div class="help-text">
    <strong>提示:</strong> 班别字段填写说明：
    <ul>
      <li>白班请填写: 0</li>
      <li>夜班请填写: 1</li>
    </ul>
  </div>
  <button onclick="downloadTemplate()">下载正确模板</button>
</div>
```

---

## 📋 修改文件清单

| 文件 | 修改内容 | 状态 |
|------|---------|------|
| `DataUploadController.java` | 添加 QMS 异常捕获和详细错误返回 | ✅ |
| `QmsApiService.java` | 添加 normalizeShift() 方法 | ✅ |
| `QmsApiService.java` | sendData 方法中使用 normalizeShift | ✅ |
| `QmsApiService.java` | buildRequestBody 方法中使用 normalizeShift | ✅ |

---

## ✅ 总结

### 修复的问题
1. ✅ QMS 异常现在会详细返回给前端
2. ✅ Shift 字段自动标准化为 "0" 或 "1"
3. ✅ 支持多种 shift 值输入方式（数字、中文、英文）
4. ✅ 添加详细的日志记录

### 用户体验改进
1. ✅ 前端能看到详细的错误信息
2. ✅ 用户可以根据错误信息修正数据
3. ✅ Excel 填写更灵活（自动转换）
4. ✅ 开发调试更方便（详细日志）

### 容错能力提升
1. ✅ 自动转换多种 shift 值格式
2. ✅ 无效值使用默认值并记录警告
3. ✅ 不会因为 shift 值导致上传失败

---

**修复时间**: 2026-01-24  
**关键改进**: 
- QMS 异常详细返回给前端
- Shift 字段自动标准化
- 支持多种输入格式
