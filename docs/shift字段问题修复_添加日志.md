# 🔧 shift is not null 错误 - 问题分析和修复

## 🔴 问题描述

执行后返回错误：
```
java.lang.Exception: QMS返回错误: shift is not null
```

这说明 **shift 字段值为 null**，但 QMS 要求它不能为 null。

---

## 🐛 根本原因

在 `QmsApiService.sendData()` 方法中，批量发送数据时构建请求体的代码**不完整**，缺少了以下关键字段：

❌ **缺失的字段**：
1. `shift` - 班别
2. `machineNo` - 机台编号
3. `supCreateTime` - 供应商创建时间
4. `supUpdateTime` - 供应商更新时间
5. `upperLimit` - 测试上限
6. `lowerLimit` - 测试下限

之前代码只构建了 13 个基础字段，导致这 6 个字段为 null。

---

## ✅ 已修复内容

### 1. 修复 sendData 方法的数据构建

**修改前**（错误代码）：
```java
Map<String, Object> singleMap = new HashMap<>();
singleMap.put("supplierCode", data.getSupplierCode());
singleMap.put("type", data.getType());
// ... 只有 13 个字段
// ❌ 缺少 shift, machineNo, supCreateTime, supUpdateTime, upperLimit, lowerLimit
```

**修改后**（正确代码）：
```java
Map<String, Object> singleMap = new HashMap<>();

// 基础字段（13个）
singleMap.put("guid", data.getGuid() != null ? data.getGuid() : "");
singleMap.put("supplierCode", data.getSupplierCode() != null ? data.getSupplierCode() : "");
// ... 其他基础字段

// ✅ shift（必填，默认"0"）
String shift = data.getShift();
singleMap.put("shift", (shift != null && !shift.trim().isEmpty()) ? shift : "0");

// ✅ machineNo（必填，默认"NA"）
String machineNo = data.getMachineNo();
singleMap.put("machineNo", (machineNo != null && !machineNo.trim().isEmpty()) ? machineNo : "NA");

// ✅ supCreateTime（必填）
if (data.getSupCreateTime() != null) {
    singleMap.put("supCreateTime", sdf.format(data.getSupCreateTime()));
} else {
    singleMap.put("supCreateTime", sdf.format(new Date()));
}

// ✅ supUpdateTime（必填）
if (data.getSupUpdateTime() != null) {
    singleMap.put("supUpdateTime", sdf.format(data.getSupUpdateTime()));
} else {
    singleMap.put("supUpdateTime", sdf.format(new Date()));
}

// ✅ upperLimit 和 lowerLimit（选填）
singleMap.put("upperLimit", data.getUpperLimit() != null ? data.getUpperLimit() : "");
singleMap.put("lowerLimit", data.getLowerLimit() != null ? data.getLowerLimit() : "");
```

### 2. 添加详细的调试日志

现在会记录以下信息：

#### 请求前日志：
```
========== 开始批量发送数据到 QMS ==========
准备批量发送 2 条数据...
========== 完整请求体 ==========
字段总数: 19, 数据条数: 2
JSON Body: {"datas":[{...完整JSON...}]}
```

#### 发送时日志：
```
========== 发送请求到 QMS ==========
URL: https://open-apimarket-sandbox.myoas.com/isc-qms-api/gateway/qms/qms-spc/open-api/supplier/data
Headers: appId=xxx, timestamp=xxx, nonce=xxx, sign=xxx
Request Body (完整): {...}
```

#### 响应日志：
```
========== QMS 响应 ==========
HTTP Status: 200
Response Body: {...}
QMS 返回结果: success=true/false, message=xxx
```

---

## 🎯 关键修复点

### 所有 19 个字段都必须包含

| # | 字段名 | 默认值逻辑 | 状态 |
|---|--------|-----------|------|
| 1-13 | 基础字段 | 空字符串或0 | ✅ 已修复 |
| 14 | **shift** | **默认 "0"** | ✅ 已修复 |
| 15 | **machineNo** | **默认 "NA"** | ✅ 已修复 |
| 16 | **supCreateTime** | **当前时间** | ✅ 已修复 |
| 17 | **supUpdateTime** | **当前时间** | ✅ 已修复 |
| 18 | **upperLimit** | **空字符串** | ✅ 已修复 |
| 19 | **lowerLimit** | **空字符串** | ✅ 已修复 |

---

## 📊 日志使用方法

### 查看完整请求体
```bash
tail -f logs/app.log | grep "完整请求体" -A 5
```

### 查看 QMS 响应
```bash
tail -f logs/app.log | grep "QMS 响应" -A 5
```

### 查看详细字段信息
```bash
tail -f logs/app.log | grep "字段总数"
```

### 查看错误详情
```bash
tail -f logs/app.log | grep "QMS 返回失败详情"
```

---

## 🧪 测试步骤

1. **重启应用**
   ```bash
   # 停止当前应用
   # 重新启动
   .\mvnw.cmd spring-boot:run
   ```

2. **重新测试上传**
   - 上传 Excel 文件
   - 观察日志输出

3. **检查日志**
   查看日志中的完整请求体，确认包含所有 19 个字段：
   ```
   字段总数: 19, 数据条数: 2
   ```

4. **验证结果**
   - ✅ 不再出现 "shift is not null" 错误
   - ✅ 不再出现 "supCreateTime is not null" 错误
   - ✅ QMS 返回 success=true
   - ✅ 数据状态更新为 status=1

---

## 🔍 排查流程

如果还有问题，按以下顺序检查：

### 1. 检查请求体字段数
在日志中查找：
```
字段总数: 19
```
如果不是 19，说明还有字段缺失。

### 2. 检查具体字段值
在日志中查找 JSON Body，检查：
- `shift` 是否存在且不为 null
- `machineNo` 是否存在且不为 null
- `supCreateTime` 是否存在且不为 null
- `supUpdateTime` 是否存在且不为 null

### 3. 检查 QMS 错误信息
在日志中查找：
```
QMS 返回失败详情: {...}
```
查看完整的错误信息。

### 4. 检查数据库字段值
```sql
SELECT ID, SHIFT, MACHINE_NO, SUP_CREATE_TIME, SUP_UPDATE_TIME
FROM SUPPLIER_PROCESS_DATA
WHERE BATCH_ID = 'BATCH_20260124xxx'
ORDER BY ID DESC
LIMIT 5;
```

确保数据库中这些字段有值。

---

## ⚠️ 重要提醒

### sendData 方法 vs buildRequestBody 方法

项目中有**两处**构建请求体的代码：

1. **sendData 方法** - 用于批量发送（主要使用）
   - ✅ 已修复，包含所有 19 个字段

2. **buildRequestBody 方法** - 用于单条发送
   - ✅ 之前已修复，包含所有 19 个字段

确保两处代码都包含完整的 19 个字段！

---

## 📝 修改文件清单

| 文件 | 修改内容 | 状态 |
|------|---------|------|
| `QmsApiService.java` | sendData 方法 - 添加缺失的 6 个字段 | ✅ |
| `QmsApiService.java` | 添加详细日志（请求前、发送时、响应后） | ✅ |
| `QmsApiService.java` | buildRequestBody 方法 - 添加字段日志 | ✅ |

---

## 🎉 预期结果

重启应用后：

1. ✅ 日志会显示完整的请求体（19个字段）
2. ✅ 所有必填字段都有默认值兜底
3. ✅ 不再出现 "xxx is not null" 错误
4. ✅ QMS 返回 success=true
5. ✅ 数据状态更新为 status=1

---

**修复时间**: 2026-01-24  
**关键问题**: sendData 方法中缺少 6 个字段  
**解决方案**: 补齐所有 19 个字段并添加详细日志
