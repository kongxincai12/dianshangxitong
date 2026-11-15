# JCD MES PDA · v1 阶段总结（用于启动 v2 数据维护后台）

> 本文档汇总到目前为止 PDA 三件套（`jcd-mes-pro-app` / `jcd-mes-lqc-app` / `pdaserver`）已经稳定下来的约定和踩过的坑，方便 v2"数据维护后台"开发时直接复用，不要再重复试错。

---

## 一、运行时坐标（不写死，仅记录当前部署）

| 组件 | 地址 / 端口 |
|------|------------|
| pdaserver | `:9900`（生产用），代码里默认 `:9099` 的引用一律以实际部署为准 |
| 前端 BASE_URL | `pro` = `uni.getStorageSync('server_url') \|\| 'http://192.168.10.30:9900'`，`lqc` 同步对齐到 `:9900` |
| 数据库 | 由 `application.properties` 决定，**经常切**（TSMES / SZMES / 测试库）。代码、文档、回答都不要写死库名/IP |

---

## 二、登录态与权限

- 登录接口：`POST /api/login/login`，返回 `{ user: {username, fullname, userposition}, token }`
- JWT 由 `JwtUtils` 颁发；所有 `/api/**` 请求带 `Authorization: Bearer <token>`，过滤器把 `current_employee_id` 注入 request attribute
- **前端 storage key 区别（v2 复用时一定要注意）**：
  - 生产 PDA：`current_employee` → `{ employeeId, employeeName, ... }`
  - 品质 PDA：`currentUser`        → `{ username, fullname, userposition }`，**没有 employeeId**
- v2 数据维护后台如果是 Web，建议沿用 `LoginServerController` + JWT，不要再造一套用户体系
- **姓名展示规则**：业务表只存工号（`OPERATOR_ID / PROD_USER_ID / QC_USER_ID`），查询时 `LEFT JOIN USERPROFILE U on U.USERNAME = X.OPERATOR_ID` + `NVL(U.FULLNAME, X.XXX_NAME)` 兜底，不要在业务表里冗余 fullname

---

## 三、API & 响应契约

```jsonc
// 成功
{ "code": 200, "message": "操作成功", "data": { ... } }
// 失败
{ "code": 4xx/5xx, "message": "错误描述", "data": null }
```

- Controller 一律返回 `ResponseEntity<Map<String,Object>>`，HTTP 状态用 `ResponseEntity.ok / .status(...)`
- 业务异常抛 `BusinessException(code, message)`，全局 handler 统一转换
- 前端 `request()` 直接返回 `res.data.data`；非 200 自动 toast + reject

---

## 四、配置外置（v2 必须遵守）

**所有"会经常改"的配置都用 `@Value("${xxx:默认值}")` 注入，不要硬编码。**

部署目录布局：
```
D:\app\pdaserver\
  ├─ pdaserver-x.x.jar
  └─ config\
       └─ application.properties   ← 只写要覆盖的项，UTF-8，可写中文
```
优先级：`./config/` > `./` > jar 内置；等价方式：命令行 `--xxx=yyy`、环境变量 `XXX_YYY`、`--spring.config.additional-location=file:./conf/`。

UNC 路径示例（双反斜杠转义）：
```properties
qa.smb.root=\\\\10.10.100.21\\物理实验室报告
```

---

## 五、v1 已建好的 FA（首件检验）模块速查

### 后端
| 文件 | 作用 |
|------|------|
| `controller/qafa/QaFa*Controller.java` | 列表 / 详情 / 生产录入 / 品管审批 / 实验室浏览导入 |
| `service/qafa/impl/QaFaRecordServiceImpl.java` | 主流程；`validateRequiredItems` 接受 value 或 pass 任一非空 |
| `service/qafa/impl/QaFaLabServiceImpl.java` | 解析实验室 Excel；**注意 `@Transactional` 失败会一并回滚 header**，要诊断要拆事务或用 `REQUIRES_NEW` |
| `service/qafa/impl/SmbBrowseServiceImpl.java` | UNC 直接 `Files.list()`，不用 jcifs；超时 5s |
| `mapper/qafa/QaFaRecordMapper.xml` | record/item CRUD；查询已 LEFT JOIN USERPROFILE 显示姓名 |
| `mapper/qafa/QaFaAuditLogMapper.xml` | 审核轨迹；同样 LEFT JOIN 显示姓名 |
| `mapper/qafa/QaFaLabDataMapper.xml` | 实验室数据；`batchInsertItems` 所有占位符必须带 `jdbcType` 防 ORA-01790 |

### 前端（lqc）
| 文件 | 作用 |
|------|------|
| `pages/first-article/first-article-list.vue` | 列表 |
| `pages/first-article/first-article-entry.vue` | 生产录入 |
| `pages/first-article/first-article-approval.vue` | 品管审批；强制双列、布尔项隐藏输入框只显通过 chip、`canEditQc` 用 `currentUser.username` 比对 |

---

## 六、踩过的坑（v2 不要再犯）

1. **storage key 写错** → LQC 页面误读 `current_employee` 导致按钮永远隐藏
2. **ORA-01790** → MyBatis `union all` 批量插入未带 `jdbcType`
3. **@Transactional 静默回滚** → 子表插入失败把 header 也撤了，用户看不到任何痕迹
4. **配置硬编码** → SMB 路径 / 服务地址写死在代码或 jar 里 properties，每改一次都要重新编译；改用外置 `config/application.properties`
5. **库名写死** → 文档里写 "JCD_TS@TSMES" 假设永远不变，结果切到 SZMES 后全是误导
6. **PNL/PCS 双向计算无防抖位** → 死循环
7. **H5 假装能扫码** → `uni.scanCode` 只在 APP/小程序生效

---

## 七、v2 起步建议（数据维护后台）

> 这里只是**待办候选**，具体功能等用户在 v2 第一轮里确认。

可能的内容：
- 模板维护：`QA_FA_TEMPLATE` / `QA_FA_TEMPLATE_ITEM` 的可视化增删改 + 启停 / 版本
- 设备参数维护：默认参数 + 独立参数（OVERRIDE / DEFAULT）的 PC 端管理（PDA 上有简版，PC 端要更顺手）
- 物料 / 批次 / 工序基础数据浏览（只读，跳转 .NET MES 维护）
- 用户与角色映射（沿用 `USERPROFILE`，只做角色/菜单映射表）
- 操作审计、配置项在线编辑（只针对 v2 自己的业务表，**不要碰 .NET MES 同名表**）

技术栈建议（待用户确认）：
- 前端：Vue3 + Vite + Element Plus（Naive 也可），单页 SPA
- 后端：复用 pdaserver（同一 jar 增模块）；**不要**单独再起一个 Spring 工程，免得登录态、配置文件、库连接重复维护
- 路由前缀：`/api/admin/**` 与 PDA 的 `/api/**` 区分；JWT 复用，必要时增加角色 claim
- 部署：和 pdaserver 同机，前端打包后丢到 `static/admin/`，由 Spring Boot 一并 serve

---

## 八、本次会话已完成的最后两个变更（用于 commit / 部署 checklist）

1. `first-article-approval.vue` `canEditQc` 改用 `currentUser.username`
2. `QaFaRecordMapper.xml` / `QaFaAuditLogMapper.xml` 增加 LEFT JOIN USERPROFILE 显示姓名
3. SMB 路径等可变配置改用外置 `config/application.properties`，无需重新打包

部署清单：
- [ ] 重启 pdaserver
- [ ] 现场建好 `pdaserver/config/application.properties`，写入需要覆盖的项
- [ ] 重新构建并上传 lqc PDA APK
