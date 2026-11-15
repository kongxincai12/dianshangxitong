# 🔧 shift 字段补充 - 快速参考

## ✅ 修改清单

| # | 文件 | 状态 | 说明 |
|---|------|-----|------|
| 1 | `sql/alter_supplier_process_data_add_shift.sql` | ✅ 新建 | 数据库字段添加脚本 |
| 2 | `sql/create_supplier_process_data_table.sql` | ✅ 更新 | 建表脚本添加 SHIFT |
| 3 | `SupplierProcessData.java` | ✅ 更新 | 实体类添加 shift 字段 |
| 4 | `SupplierProcessDataExcelDTO.java` | ✅ 更新 | DTO 添加 shift (index=7) |
| 5 | `UploadService.java` | ✅ 更新 | 添加字段映射 |
| 6 | `QmsApiService.java` | ✅ 更新 | 请求体添加 shift |

---

## 📋 部署命令

```bash
# 1. 数据库
sqlplus user/pass@db
@sql/alter_supplier_process_data_add_shift.sql

# 2. 编译
cd Z:\pdaserver
.\mvnw.cmd clean compile

# 3. 重启
.\mvnw.cmd spring-boot:run
```

---

## 🧪 快速测试

```sql
-- 验证字段
DESC SUPPLIER_PROCESS_DATA;

-- 测试数据
INSERT INTO SUPPLIER_PROCESS_DATA 
(ID, BATCH_ID, STATUS, SUPPLIER_CODE, SN, SHIFT) 
VALUES 
(SEQ_SUPPLIER_PROCESS_DATA_ID.NEXTVAL, 'TEST001', 0, 'SUP001', 'SN001', '白班');

-- 查询
SELECT ID, SN, SHIFT FROM SUPPLIER_PROCESS_DATA WHERE SHIFT IS NOT NULL;
```

---

## 📊 Excel 列序（更新）

```
0  供应商编码
1  检测类型
2  物料大类
3  物料细分类
4  物料代码
5  工序
6  条码SN
7  班别 ⭐ NEW
8  测试项
9  实际测试值
10 测试过站时间
11 结果
12 总结果
```

---

## ⚠️ 重要提醒

1. ✅ shift 字段可为空（NULL）
2. ✅ 不影响现有数据和功能
3. ✅ Excel 模板需要添加"班别"列
4. ✅ QMS 请求会包含 shift 字段

---

**创建时间:** 2026-01-24  
**所有修改已完成** ✅
