# QMS 系统对接模块 - 使用文档

## 📋 概述

本模块实现了与 QMS 系统的数据对接功能，包括签名生成、数据发送、状态管理等完整流程。

---

## 📁 文件清单

### 1. 工具类
- **QmsSignUtils.java** (`src/main/java/com/jcd/utils/QmsSignUtils.java`)
  - 实现 HMAC-SHA1 签名算法
  - 生成签名、时间戳、随机数

### 2. 服务类
- **QmsApiService.java** (`src/main/java/com/jcd/service/QmsApiService.java`)
  - 核心业务逻辑
  - 数据发送、状态更新

### 3. Controller
- **QmsDataSendController.java** (`src/main/java/com/jcd/controller/QmsDataSendController.java`)
  - 提供 REST API 接口
  - 手动触发发送、查询状态

### 4. 配置类
- **RestTemplateConfig.java** (`src/main/java/com/jcd/config/RestTemplateConfig.java`)
  - RestTemplate Bean 配置
  - HTTP 请求超时设置

### 5. 配置文件
- **application.properties** (`src/main/resources/application.properties`)
  - QMS API 配置

---

## ⚙️ 配置说明

### application.properties 配置

```properties
# QMS AppId
qms.api.appId=isc-qms-sup-80000150

# QMS 密钥 (开发环境)
qms.api.secret.dev=KlSHDMqdETYUnwueuV
# QMS 密钥 (生产环境)
qms.api.secret.prod=pRejkQlpLpCSpsOkXO

# QMS 主机地址 (开发环境)
qms.api.host.dev=open-apimarket-sandbox.myoas.com
# QMS 主机地址 (生产环境)
qms.api.host.prod=open-apimarket.myoas.com

# QMS API 路径
qms.api.path=/isc-qms-api/gateway/qms/qms-spc/open-api/supplier/data

# 当前环境配置 (dev/prod)
qms.api.env=dev

# 是否为测试环境 (测试环境需要发送 envid 头)
qms.api.test=true
# 环境标识 (SIT/UAT/PROD)
qms.api.envid=SIT
```

### 环境切换

**切换到生产环境：**
```properties
qms.api.env=prod
qms.api.test=false
```

**切换到开发环境：**
```properties
qms.api.env=dev
qms.api.test=true
qms.api.envid=SIT
```

---

## 🔐 签名算法

### 签名原理

使用 HMAC-SHA1 算法，签名原文格式：
```
method & host & path & appId & timestamp & nonce
```

### 示例

```java
String method = "POST";
String host = "open-apimarket-sandbox.myoas.com";
String path = "/isc-qms-api/gateway/qms/qms-spc/open-api/supplier/data";
String appId = "isc-qms-sup-80000150";
String timestamp = "1706083200";
String nonce = "abc123def456";
String secret = "KlSHDMqdETYUnwueuV";

String sign = QmsSignUtils.generateSign(method, host, path, appId, timestamp, nonce, secret);
```

---

## 📡 API 接口

### 1. 发送指定批次数据

**请求：**
```http
POST /api/qms/send/batch/{batchId}
```

**示例：**
```bash
curl -X POST http://localhost:9099/api/qms/send/batch/BATCH_20260124143000
```

**响应：**
```json
{
  "success": true,
  "message": "批次数据发送完成",
  "batchId": "BATCH_20260124143000",
  "successCount": 50,
  "failCount": 2,
  "skipCount": 0,
  "totalCount": 52
}
```

---

### 2. 发送所有待发送数据

**请求：**
```http
POST /api/qms/send/pending
```

**示例：**
```bash
curl -X POST http://localhost:9099/api/qms/send/pending
```

**响应：**
```json
{
  "success": true,
  "message": "待发送数据处理完成",
  "successCount": 100,
  "failCount": 5,
  "skipCount": 0,
  "totalCount": 105
}
```

---

### 3. 重发失败数据

**请求：**
```http
POST /api/qms/send/retry-failed
```

**示例：**
```bash
curl -X POST http://localhost:9099/api/qms/send/retry-failed
```

**响应：**
```json
{
  "success": true,
  "message": "失败数据重发完成",
  "successCount": 3,
  "failCount": 2,
  "skipCount": 0,
  "totalCount": 5
}
```

---

### 4. 查询批次状态

**请求：**
```http
GET /api/qms/status/batch/{batchId}
```

**示例：**
```bash
curl http://localhost:9099/api/qms/status/batch/BATCH_20260124143000
```

**响应：**
```json
{
  "success": true,
  "batchId": "BATCH_20260124143000",
  "totalCount": 100,
  "pendingCount": 0,
  "successCount": 98,
  "failCount": 2
}
```

---

### 5. 查询全部状态统计

**请求：**
```http
GET /api/qms/status/all
```

**示例：**
```bash
curl http://localhost:9099/api/qms/status/all
```

**响应：**
```json
{
  "success": true,
  "totalCount": 500,
  "pendingCount": 100,
  "successCount": 380,
  "failCount": 20
}
```

---

## 💻 代码示例

### 在 Service 中使用

```java
@Service
public class YourService {
    
    @Autowired
    private QmsApiService qmsApiService;
    
    @Autowired
    private SupplierProcessDataRepository repository;
    
    public void processAndSend(String batchId) {
        // 1. 获取批次数据
        List<SupplierProcessData> dataList = repository.findByBatchId(batchId);
        
        // 2. 发送到 QMS
        QmsApiService.SendResult result = qmsApiService.sendData(dataList);
        
        // 3. 处理结果
        System.out.println("发送成功: " + result.getSuccessCount());
        System.out.println("发送失败: " + result.getFailCount());
    }
}
```

### 直接调用 Service 方法

```java
// 发送指定批次
SendResult result1 = qmsApiService.sendBatchData("BATCH_20260124001");

// 发送所有待发送的数据
SendResult result2 = qmsApiService.sendPendingData();

// 重发失败的数据
SendResult result3 = qmsApiService.resendFailedData();
```

---

## 📊 数据流程

### 完整流程图

```
1. Excel 上传
   ↓
2. 数据解析 (UploadService)
   ↓
3. 保存到数据库 (status=0)
   ↓
4. 发送到 QMS (QmsApiService)
   ↓
5. 更新状态
   - 成功: status=1, errorMsg=null
   - 失败: status=2, errorMsg=错误信息
```

### 请求头构建

```java
Headers:
- Content-Type: application/json
- appId: isc-qms-sup-80000150
- timestamp: 1706083200
- nonce: abc123def456789
- sign: Base64(HMAC-SHA1(signString, secret))
- envid: SIT (仅测试环境)
```

### 请求体格式

```json
{
  "datas": [
    {
      "supplierCode": "SUP001",
      "type": "电压测试",
      "materialCategory": "电子元件",
      "materialClassification": "电阻",
      "materialCode": "MAT001",
      "station": "测试工序",
      "sn": "SN123456789",
      "testItem": "电压",
      "testValue": 3.3,
      "transitTime": "2026-01-24 14:30:00",
      "result": "PASS",
      "totalResult": "PASS",
      "guid": "12345678901234567890123456789012"
    }
  ]
}
```

---

## ⚠️ 注意事项

### 1. 状态管理
- **0**: 待发送 - 数据刚导入，等待发送
- **1**: 发送成功 - 已成功发送到 QMS
- **2**: 发送失败 - 发送失败，errorMsg 记录错误原因

### 2. 签名有效期
- 时间戳使用秒级精度
- 建议在 5 分钟内完成请求

### 3. 重试机制
- 失败的数据可以通过 `/api/qms/send/retry-failed` 接口重发
- 建议定时任务定期重发失败数据

### 4. 并发控制
- Service 层使用 `@Transactional` 保证数据一致性
- 避免同时发送同一批次数据

### 5. 日志监控
- 所有关键操作都有日志记录
- 查看 `logs/app.log` 获取详细日志

---

## 🔧 故障排查

### 问题 1: 签名错误

**现象：** QMS 返回 "签名验证失败"

**解决方案：**
1. 检查 appId 和 secret 是否正确
2. 确认签名原文拼接顺序正确
3. 验证时间戳是否在有效期内

### 问题 2: 连接超时

**现象：** 请求超时

**解决方案：**
1. 检查网络连接
2. 确认 QMS 主机地址正确
3. 调整 RestTemplate 超时配置

### 问题 3: 数据格式错误

**现象：** QMS 返回 "数据格式不正确"

**解决方案：**
1. 检查请求体 JSON 格式
2. 确认所有必填字段都已填写
3. 验证时间格式是否正确

---

## 📈 扩展建议

### 1. 定时任务
创建定时任务自动发送待发送数据：

```java
@Component
public class QmsSendScheduler {
    
    @Autowired
    private QmsApiService qmsApiService;
    
    @Scheduled(cron = "0 */10 * * * ?") // 每 10 分钟执行一次
    public void sendPendingData() {
        qmsApiService.sendPendingData();
    }
}
```

### 2. 消息队列
使用消息队列异步发送数据，提高吞吐量

### 3. 监控告警
集成监控系统，失败率超过阈值时发送告警

### 4. 数据备份
定期备份已发送成功的数据

---

## 📞 技术支持

如有问题，请联系：
- 技术团队
- 查看日志: `logs/app.log`
- 参考 QMS API 文档

---

**生成时间:** 2026-01-24  
**版本:** 1.0  
**状态:** ✅ 完成
