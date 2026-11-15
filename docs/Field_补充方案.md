# 供应商制程数据字段补充方案

## 📋 问题分析

根据 QMS 项目供应商接口文档 V2.6 的"5.供应商制程数据（原材料供应商）"接口规范，当前实现缺失以下字段：

### 缺失字段清单

| 字段名 | 类型 | 说明 | 是否必填 |
|--------|------|------|----------|
| **shift** | String | 班别 | 否 |

## 🔧 修复方案

### 1. 数据库修改

#### 1.1 添加字段 SQL
```sql
-- 添加 shift 字段
ALTER TABLE SUPPLIER_PROCESS_DATA ADD SHIFT VARCHAR2(50);

-- 添加注释
COMMENT ON COLUMN SUPPLIER_PROCESS_DATA.SHIFT IS '班别';

-- 创建索引（如果需要经常按班别查询）
CREATE INDEX IDX_SPD_SHIFT ON SUPPLIER_PROCESS_DATA(SHIFT);
```

### 2. 实体类修改

#### 2.1 SupplierProcessData.java
在实体类中添加 shift 字段及其 getter/setter 方法。

### 3. DTO 修改

#### 3.1 SupplierProcessDataExcelDTO.java
在 Excel 导入 DTO 中添加 shift 字段。

### 4. Service 修改

#### 4.1 UploadService.java
在转换方法中添加 shift 字段的映射。

#### 4.2 QmsApiService.java
在构建请求体方法中添加 shift 字段。

---

## 📝 详细修改步骤

### 步骤 1: 执行数据库脚本

```sql
-- 连接到 Oracle 数据库
sqlplus username/password@database

-- 执行以下 SQL
ALTER TABLE SUPPLIER_PROCESS_DATA ADD SHIFT VARCHAR2(50);
COMMENT ON COLUMN SUPPLIER_PROCESS_DATA.SHIFT IS '班别';
CREATE INDEX IDX_SPD_SHIFT ON SUPPLIER_PROCESS_DATA(SHIFT);

-- 提交
COMMIT;
```

### 步骤 2: 修改 Java 代码

所有相关的 Java 文件都需要添加 shift 字段的支持。

---

## ⚠️ 注意事项

1. **数据库兼容性**: 
   - 新增字段为可空字段，不影响已有数据
   - 建议在测试环境先验证

2. **历史数据**:
   - 已存在的数据 shift 字段为 NULL
   - 可以通过 UPDATE 语句批量设置默认值

3. **向后兼容**:
   - DTO 中 shift 字段设为可选
   - Service 层需要处理 NULL 值

4. **接口文档**:
   - 需要更新 API 文档
   - Excel 模板需要添加"班别"列

---

## 🧪 测试建议

### 1. 单元测试
```java
@Test
public void testShiftField() {
    SupplierProcessData data = new SupplierProcessData();
    data.setShift("白班");
    assertEquals("白班", data.getShift());
}
```

### 2. 集成测试
- 测试 Excel 上传包含 shift 字段
- 测试发送到 QMS 系统
- 测试查询包含 shift 字段的数据

### 3. 回归测试
- 测试不包含 shift 字段的旧数据能正常处理
- 测试 shift 为 NULL 的情况

---

## 📊 影响范围评估

| 模块 | 影响程度 | 修改内容 |
|------|----------|----------|
| 数据库 | 低 | 添加一个字段 |
| 实体类 | 低 | 添加字段和方法 |
| DTO | 低 | 添加字段 |
| Service | 低 | 添加字段映射 |
| Controller | 无 | 无需修改 |
| 前端 | 中 | Excel 模板需更新 |

---

**创建时间:** 2026-01-24  
**版本:** 1.0  
**状态:** 待执行
