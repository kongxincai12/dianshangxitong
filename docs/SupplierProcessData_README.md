# 供应商制程数据模块 (Supplier Process Data)

## 概述
本模块用于存储和管理从 Excel 上传的供应商制程数据。

## 文件清单

### 1. 实体类
- **文件路径**: `src/main/java/com/jcd/model/SupplierProcessData.java`
- **说明**: JPA 实体类，对应数据库表 `SUPPLIER_PROCESS_DATA`

### 2. Repository 接口
- **文件路径**: `src/main/java/com/jcd/repository/SupplierProcessDataRepository.java`
- **说明**: Spring Data JPA Repository 接口，提供数据访问操作

### 3. 数据库脚本
- **文件路径**: `sql/create_supplier_process_data_table.sql`
- **说明**: Oracle 数据库建表脚本，包含表结构、序列和索引

## 数据库表结构

### 表名: SUPPLIER_PROCESS_DATA

| 字段名 | 类型 | 说明 | 约束 |
|--------|------|------|------|
| ID | NUMBER(19) | 主键ID | PRIMARY KEY, 自增 |
| BATCH_ID | VARCHAR2(100) | 批次号 | - |
| STATUS | NUMBER(1) | 状态 (0=待发送, 1=发送成功, 2=发送失败) | NOT NULL, DEFAULT 0 |
| ERROR_MSG | VARCHAR2(500) | 错误信息 | - |
| SUPPLIER_CODE | VARCHAR2(100) | 供应商编码 | - |
| TYPE | VARCHAR2(100) | 检测类型 | - |
| MATERIAL_CATEGORY | VARCHAR2(100) | 物料大类 | - |
| MATERIAL_CLASSIFICATION | VARCHAR2(100) | 物料细分类 | - |
| MATERIAL_CODE | VARCHAR2(100) | 物料代码 | - |
| STATION | VARCHAR2(100) | 工序 | - |
| SN | VARCHAR2(200) | 条码SN | - |
| TEST_ITEM | VARCHAR2(200) | 测试项 | - |
| TEST_VALUE | NUMBER(20, 6) | 实际测试值 | - |
| TRANSIT_TIME | DATE | 测试过站时间 | - |
| RESULT | VARCHAR2(50) | 结果 | - |
| TOTAL_RESULT | VARCHAR2(50) | 总结果 | - |
| GUID | VARCHAR2(32) | 唯一标识(32位) | - |
| CREATE_TIME | DATE | 创建时间 | DEFAULT SYSDATE |

### 索引
- `IDX_SPD_BATCH_ID`: 批次号索引
- `IDX_SPD_STATUS`: 状态索引
- `IDX_SPD_GUID`: GUID索引
- `IDX_SPD_SUPPLIER_CODE`: 供应商编码索引
- `IDX_SPD_SN`: 条码SN索引
- `IDX_SPD_BATCH_STATUS`: 批次号+状态复合索引

## 使用示例

### 1. 注入 Repository

```java
@Service
public class SupplierProcessDataService {
    
    @Autowired
    private SupplierProcessDataRepository repository;
    
    // ...
}
```

### 2. 保存数据

```java
// 创建单条数据
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

// 批量保存
List<SupplierProcessData> dataList = new ArrayList<>();
// ... 添加数据到 dataList
repository.saveAll(dataList);
```

### 3. 查询数据

```java
// 根据批次号查询
List<SupplierProcessData> list = repository.findByBatchId("BATCH_20260124001");

// 根据状态查询
List<SupplierProcessData> pendingList = repository.findByStatus(0); // 待发送

// 根据批次号和状态查询
List<SupplierProcessData> list2 = repository.findByBatchIdAndStatus("BATCH_20260124001", 0);

// 根据 GUID 查询
SupplierProcessData data = repository.findByGuid("12345678901234567890123456789012");

// 根据供应商编码查询
List<SupplierProcessData> list3 = repository.findBySupplierCode("SUP001");

// 根据条码SN查询
List<SupplierProcessData> list4 = repository.findBySn("SN123456789");
```

### 4. 统计数据

```java
// 统计指定批次的数据总数
Long count = repository.countByBatchId("BATCH_20260124001");

// 统计指定批次中待发送的数据数量
Long pendingCount = repository.countByBatchIdAndStatus("BATCH_20260124001", 0);
```

### 5. 更新状态

```java
// 更新为发送成功
SupplierProcessData data = repository.findById(1L).orElse(null);
if (data != null) {
    data.setStatus(1); // 发送成功
    repository.save(data);
}

// 更新为发送失败
data.setStatus(2); // 发送失败
data.setErrorMsg("网络连接超时");
repository.save(data);
```

### 6. 删除数据

```java
// 删除指定批次的所有数据
@Transactional
public void deleteBatch(String batchId) {
    repository.deleteByBatchId(batchId);
}
```

## 业务流程示例

### Excel 文件上传处理流程

```java
@Service
public class ExcelUploadService {
    
    @Autowired
    private SupplierProcessDataRepository repository;
    
    @Transactional
    public String uploadExcel(MultipartFile file) throws Exception {
        // 1. 生成批次号
        String batchId = "BATCH_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        
        // 2. 解析 Excel 文件
        List<SupplierProcessData> dataList = parseExcel(file, batchId);
        
        // 3. 批量保存到数据库
        repository.saveAll(dataList);
        
        return batchId;
    }
    
    private List<SupplierProcessData> parseExcel(MultipartFile file, String batchId) {
        List<SupplierProcessData> dataList = new ArrayList<>();
        // Excel 解析逻辑
        // ...
        return dataList;
    }
}
```

### 数据发送处理流程

```java
@Service
public class DataSendService {
    
    @Autowired
    private SupplierProcessDataRepository repository;
    
    public void sendPendingData() {
        // 1. 查询待发送的数据
        List<SupplierProcessData> pendingList = repository.findByStatus(0);
        
        // 2. 发送数据
        for (SupplierProcessData data : pendingList) {
            try {
                // 调用外部接口发送数据
                sendToExternalSystem(data);
                
                // 更新状态为发送成功
                data.setStatus(1);
                repository.save(data);
            } catch (Exception e) {
                // 更新状态为发送失败
                data.setStatus(2);
                data.setErrorMsg(e.getMessage());
                repository.save(data);
            }
        }
    }
    
    private void sendToExternalSystem(SupplierProcessData data) {
        // 外部系统接口调用逻辑
        // ...
    }
}
```

## 数据库部署

### 步骤 1: 执行 SQL 脚本
在 Oracle 数据库中执行 `sql/create_supplier_process_data_table.sql` 脚本:

```sql
-- 连接到 Oracle 数据库
sqlplus username/password@database

-- 执行脚本
@sql/create_supplier_process_data_table.sql
```

### 步骤 2: 验证表创建
```sql
-- 查看表结构
DESC SUPPLIER_PROCESS_DATA;

-- 查看序列
SELECT * FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_SUPPLIER_PROCESS_DATA_ID';

-- 查看索引
SELECT INDEX_NAME, COLUMN_NAME FROM USER_IND_COLUMNS 
WHERE TABLE_NAME = 'SUPPLIER_PROCESS_DATA';
```

## 注意事项

1. **批次号管理**: 建议使用时间戳或UUID生成唯一的批次号
2. **GUID唯一性**: GUID字段用于数据去重，确保每条记录的GUID唯一
3. **状态管理**: 
   - 0: 待发送（初始状态）
   - 1: 发送成功
   - 2: 发送失败（需记录错误信息）
4. **事务处理**: 批量删除操作需要加 `@Transactional` 注解
5. **性能优化**: 已创建相关索引，查询时尽量使用索引字段

## 扩展建议

1. **添加更多查询方法**: 根据业务需求在 Repository 中添加自定义查询方法
2. **添加 DTO**: 创建数据传输对象，用于前后端数据交互
3. **添加 Service 层**: 封装业务逻辑
4. **添加 Controller**: 提供 REST API 接口
5. **添加异常处理**: 统一处理异常情况
6. **添加日志记录**: 记录关键操作日志
7. **添加数据校验**: 使用 JSR-303 注解进行数据验证

## 相关文档

- [Spring Data JPA 官方文档](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [JPA 注解说明](https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html)
- [Oracle 数据库文档](https://docs.oracle.com/en/database/)
