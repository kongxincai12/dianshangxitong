# 供应商制程数据模块 - 快速参考

## 🎯 快速开始

### 1️⃣ 数据库初始化
```bash
# 在 Oracle 中执行
sqlplus username/password@database
@sql/create_supplier_process_data_table.sql
```

### 2️⃣ 注入 Repository
```java
@Autowired
private SupplierProcessDataRepository repository;
```

### 3️⃣ 保存数据
```java
SupplierProcessData data = new SupplierProcessData();
data.setBatchId("BATCH_20260124001");
data.setSupplierCode("SUP001");
data.setMaterialCode("MAT001");
data.setSn("SN123456789");
data.setTestItem("电压测试");
data.setTestValue(3.3);
data.setResult("PASS");
data.setTotalResult("PASS");
data.setGuid(UUID.randomUUID().toString().replace("-", ""));
repository.save(data);
```

---

## 📚 常用方法速查

| 方法 | 说明 | 示例 |
|------|------|------|
| `save(data)` | 保存单条数据 | `repository.save(data)` |
| `saveAll(list)` | 批量保存 | `repository.saveAll(dataList)` |
| `findByBatchId(id)` | 查询批次数据 | `repository.findByBatchId("BATCH_001")` |
| `findByStatus(status)` | 查询指定状态数据 | `repository.findByStatus(0)` |
| `findByGuid(guid)` | 根据GUID查询 | `repository.findByGuid("abc123...")` |
| `countByBatchId(id)` | 统计批次数量 | `repository.countByBatchId("BATCH_001")` |
| `deleteByBatchId(id)` | 删除批次数据 | `repository.deleteByBatchId("BATCH_001")` |

---

## 🔢 状态码

| 值 | 含义 | 使用场景 |
|----|------|----------|
| 0 | 待发送 | 数据刚导入，等待发送 |
| 1 | 发送成功 | 数据已成功发送 |
| 2 | 发送失败 | 发送失败，需记录 errorMsg |

---

## 📋 字段说明

| 字段 | 类型 | 必填 | 说明 |
|------|------|------|------|
| id | Long | ✅ | 主键，自动生成 |
| batchId | String | ⭐ | 批次号 |
| status | Integer | ✅ | 状态，默认0 |
| errorMsg | String | ❌ | 错误信息 |
| supplierCode | String | ⭐ | 供应商编码 |
| type | String | ⭐ | 检测类型 |
| materialCategory | String | ⭐ | 物料大类 |
| materialClassification | String | ⭐ | 物料细分类 |
| materialCode | String | ⭐ | 物料代码 |
| station | String | ⭐ | 工序 |
| sn | String | ⭐ | 条码SN |
| testItem | String | ⭐ | 测试项 |
| testValue | Double | ⭐ | 实际测试值 |
| transitTime | Date | ⭐ | 测试过站时间 |
| result | String | ⭐ | 结果 |
| totalResult | String | ⭐ | 总结果 |
| guid | String | ⭐ | 唯一标识(32位) |
| createTime | Date | ✅ | 创建时间，自动生成 |

✅ = 自动生成  
⭐ = 业务必填  
❌ = 可选

---

## 💼 业务示例

### Excel 上传处理
```java
@Transactional
public String uploadExcel(MultipartFile file) {
    String batchId = "BATCH_" + System.currentTimeMillis();
    List<SupplierProcessData> dataList = parseExcel(file, batchId);
    repository.saveAll(dataList);
    return batchId;
}
```

### 发送数据
```java
public void sendPendingData() {
    List<SupplierProcessData> pending = repository.findByStatus(0);
    for (SupplierProcessData data : pending) {
        try {
            sendToExternal(data);
            data.setStatus(1);
        } catch (Exception e) {
            data.setStatus(2);
            data.setErrorMsg(e.getMessage());
        }
        repository.save(data);
    }
}
```

### 查询统计
```java
// 查询待发送数量
Long count = repository.countByBatchIdAndStatus(batchId, 0);

// 查询失败记录
List<SupplierProcessData> failedList = repository.findByStatus(2);
```

---

## 📁 相关文件

- 实体类: `src/main/java/com/jcd/model/SupplierProcessData.java`
- Repository: `src/main/java/com/jcd/repository/SupplierProcessDataRepository.java`
- 建表脚本: `sql/create_supplier_process_data_table.sql`
- 详细文档: `docs/SupplierProcessData_README.md`
- 完整总结: `docs/SupplierProcessData_Summary.md`

---

## ⚡ 快捷提示

1. **GUID生成**: `UUID.randomUUID().toString().replace("-", "")`
2. **批次号生成**: `"BATCH_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())`
3. **删除操作**: 需要 `@Transactional` 注解
4. **批量操作**: 优先使用 `saveAll()` 而非循环 `save()`
5. **查询优化**: 已创建索引的字段: batchId, status, guid, supplierCode, sn

---

生成时间: 2026-01-24
