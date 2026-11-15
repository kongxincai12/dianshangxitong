# ✅ 问题已修复 - supCreateTime 字段问题

## 🔴 错误理解（之前）
以为 "supCreateTime is not null" 表示不应该发送这个字段

## ✅ 正确理解（现在）
"supCreateTime is not null" 的意思是：**这个字段不能为 null，必须有值！**

---

## 🔧 已修复内容

### 1. QmsApiService.java
**恢复了** `supCreateTime` 和 `supUpdateTime` 字段的发送，并添加三层保护：

```java
// 16. supCreateTime（必填，不能为 null）
if (data.getSupCreateTime() != null) {
    dataMap.put("supCreateTime", sdf.format(data.getSupCreateTime()));
} else {
    dataMap.put("supCreateTime", sdf.format(new Date())); // 兜底
}

// 17. supUpdateTime（必填，不能为 null）
if (data.getSupUpdateTime() != null) {
    dataMap.put("supUpdateTime", sdf.format(data.getSupUpdateTime()));
} else {
    dataMap.put("supUpdateTime", sdf.format(new Date())); // 兜底
}
```

### 2. 三层保护机制
确保 `supCreateTime` 和 `supUpdateTime` 永远不为 null：

1. **UploadService**: 数据创建时明确设置 `new Date()`
2. **@PrePersist**: 数据库保存前自动兜底
3. **QmsApiService**: 发送 QMS 前再次检查并兜底

---

## 📊 最终字段清单

### 发送给 QMS 的字段：**19 个**

1. guid ✅
2. supplierCode ✅
3. type ✅
4. materialCategory ✅
5. materialClassification ✅
6. materialCode ✅
7. station ✅
8. sn ✅
9. testItem ✅
10. testValue ✅
11. transitTime ✅
12. result ✅
13. totalResult ✅
14. shift ✅（默认 "0"）
15. machineNo ✅（默认 "NA"）
16. **supCreateTime** ✅（**必须有值，不能为 null**）
17. **supUpdateTime** ✅（**必须有值，不能为 null**）
18. upperLimit ✅
19. lowerLimit ✅

---

## 🚀 下一步操作

1. **重启应用**
   ```bash
   .\mvnw.cmd spring-boot:run
   ```

2. **重新测试上传**
   - 上传 Excel 文件
   - 检查日志，应该看到数据成功发送
   - 验证 `status=1`（发送成功）

3. **验证数据库**
   ```sql
   SELECT ID, SUP_CREATE_TIME, SUP_UPDATE_TIME, STATUS
   FROM SUPPLIER_PROCESS_DATA
   WHERE STATUS = 1
   ORDER BY ID DESC
   LIMIT 10;
   ```

---

## ✅ 预期结果

- ✅ Excel 上传成功
- ✅ 数据保存到数据库，supCreateTime 和 supUpdateTime 有值
- ✅ 数据发送到 QMS 成功
- ✅ **不再出现** "supCreateTime is not null" 错误
- ✅ 数据状态更新为 1（发送成功）

---

**修复时间**: 2026-01-24  
**关键点**: supCreateTime 和 supUpdateTime 是 QMS **必填字段**，必须发送且不能为 null！
