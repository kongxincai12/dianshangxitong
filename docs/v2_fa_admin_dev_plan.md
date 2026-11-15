# FA 模板维护 Web 后台 (v2) — 开发计划文档

> **目的**：在新窗口/新会话开工时，仅凭本文档即可独立完成 v2 开发，无需回看 v1 对话历史。  
> **状态**：v1 (PDA 三件套) 已上线；FA 后端代码已从备份恢复并编译通过。  
> **创建日期**：2026-04-30

---

## 0. 一句话目标

新做一个 **浏览器 Web 后台**，给品质工程师维护 **首件检验 (FA) 模板**：工序、版本、分组、检查项的 CRUD + 启用/停用 + 复制新版本。  
**只做模板维护，其它(记录/实验数据/审批)继续走 PDA。**

---

## 1. 仓库与坐标

| 角色 | 路径 | 端口 | 备注 |
|---|---|---|---|
| 后端 (复用) | `Y:\PDA\pdaserver` | **9900** | Spring Boot 2.7.3 / Java 8 / MyBatis / Oracle 12c |
| 前端 (新建) | `Y:\jcd-mes-fa-admin` | dev: 5173 | Vue 3 + Vite + TypeScript + Element Plus |
| 数据库 | Oracle 12c TSMES | — | DDL **已执行**(用户 2026-04-30 确认)，账号见 `application.properties` |
| 参考前端 | `Y:\PDA\jcd-mes-lqc-app` | — | 登录方式 / api 封装 / storage key 参考它 |
| **不要碰** | `Y:\TSMES_Oracle12`、`D:\Project\smartshelf`、`Y:\pdaserver`(端口 7007 那个) | — | 不属于本项目 |

---

## 2. 已确认的需求决策（来自用户）

1. **登录**：复用 `USERPROFILE` 表 + `LoginServerController` (`POST /api/auth/login`) + JWT；**不做角色/菜单权限**，登录通过即可用全部功能。
2. **ACTIVE 唯一性**：同 `PROCESS_CODE` 同时只允许 1 条 `STATUS='ACTIVE'`。启用新版本时，**自动把同工序旧 ACTIVE 改为 INACTIVE**。
3. **DDL**：`Y:\PDA\pdaserver\sql\qa_fa_init.sql` 已在目标库执行完毕，所有 `QA_FA_*` 表已就位。
4. **后端位置**：admin 接口直接加进 `Y:\PDA\pdaserver`，**不另起 jar**；新接口走 `/api/qa-fa/admin/**` 与现有 PDA 端 `/api/qa-fa/templates`(只读) 隔离。
5. **前端技术栈**：Vue 3 + Vite + TypeScript + Element Plus + Pinia + axios。

---

## 3. 数据库现状（参考用，不要再建表）

```
QA_FA_TEMPLATE          模板主表 (PROCESS_CODE, VERSION, STATUS=DRAFT/ACTIVE/INACTIVE)
  └─ QA_FA_TEMPLATE_SECTION    区块 (1 模板 N 区块, 按 SORT_NO)
       └─ QA_FA_TEMPLATE_ITEM  检查项 (1 区块 N 项, 按 SORT_NO)

QA_FA_RECORD / QA_FA_RECORD_ITEM   首件记录(PDA 写入, admin 不动)
QA_FA_AUDIT_LOG                    审计日志(admin 写操作必须记)
QA_FA_LAB_DATA / *_ITEM            实验数据(admin 不动)
QA_FA_USER_PREF                    用户偏好(admin 不动)
SEQ_QA_FA_RECORD_NO                序列(admin 不用)
```

**字段速查 (model 类已存在)**：
- `QaFaTemplate`: id, processCode, processName, version, name, sopRef, status, validFrom, validTo, remark, createBy/Time, updateBy/Time
- `QaFaTemplateSection`: id, templateId, code, name, sortNo, remark
- `QaFaTemplateItem`: id, templateId, sectionId, code, name, tool, standardText, inputType, unit, ruleJson, fillRole, required, critical, sortNo, remark

**枚举值约定**：
- `STATUS`: `DRAFT` / `ACTIVE` / `INACTIVE`（注意 DDL 默认 `ACTIVE`，但新建走 `DRAFT`）
- `INPUT_TYPE`: `PASS_FAIL` / `NUMBER` / `RANGE` / `TEXT` / `LAB_LINK` / `FINAL_JUDGE`
- `FILL_ROLE`: `PROD` / `QC` / `BOTH`
- `REQUIRED` / `CRITICAL`: 0/1
- `RULE_JSON` 示例：`{"min":0,"max":100}` / `{"expect":"PASS"}` / `{"options":["A","B"]}`

---

## 4. 后端开发任务清单 (Y:\PDA\pdaserver)

### 4.1 新增文件

```
src/main/java/com/jcd/
├── controller/qafa/admin/
│   └── QaFaTemplateAdminController.java
├── service/qafa/
│   ├── QaFaTemplateAdminService.java
│   └── impl/QaFaTemplateAdminServiceImpl.java
├── dto/qafa/admin/
│   ├── TemplateSaveDto.java          # 头 + sections + items 全量
│   ├── TemplateQueryDto.java         # 分页/筛选条件
│   └── TemplateSectionDto.java
│   └── TemplateItemDto.java
└── (如果现有 QaFaTemplateMapper.xml 不够用,在同文件内追加 admin 段)

src/main/resources/mapper/qafa/
└── QaFaTemplateMapper.xml            # 追加 admin 写操作
```

### 4.2 接口列表 (统一前缀 `/api/qa-fa/admin/templates`)

| Method | Path | 用途 | 入参 | 返回 |
|---|---|---|---|---|
| GET | `/` | 分页列表 | `processCode?, status?, keyword?, pageNum=1, pageSize=20` | `{ total, rows:[QaFaTemplate] }` |
| GET | `/{id}` | 详情(含 sections+items) | path id | `{ template, sections:[{...,items:[]}] }` |
| POST | `/` | 新建模板(带 sections+items) | `TemplateSaveDto` | `{ id }`，状态固定 `DRAFT` |
| PUT | `/{id}` | 全量修改(头 + 全量替换 sections+items) | `TemplateSaveDto` | `{ id }`，仅 `DRAFT` 可改 |
| POST | `/{id}/copy` | 复制为新版本 | 可选 `{ newVersion }` | `{ id }`，状态 `DRAFT`，version 默认旧版+`.1` |
| POST | `/{id}/enable` | 启用 (DRAFT/INACTIVE → ACTIVE) | — | `{ id }`，**自动把同 process 旧 ACTIVE 改 INACTIVE** |
| POST | `/{id}/disable` | 停用 (ACTIVE → INACTIVE) | — | `{ id }` |
| DELETE | `/{id}` | 删除 | — | `{ id }`，仅 `DRAFT` 可删；其它状态返回 409 |
| GET | `/processes` | 工序字典(给下拉用) | — | `[{processCode, processName}]` |

**统一返回格式**（沿用项目约定）：
```json
{ "code": 200, "message": "ok", "data": ... }
```
错误码：`400` 参数错、`401` 未登录、`403` 状态禁止、`404` 不存在、`409` 业务冲突(已被引用/已是 ACTIVE 等)、`500` 内部错。

### 4.3 业务规则（必须实现）

1. **新建/修改保存**：在一个 `@Transactional` 内：
   - upsert `QA_FA_TEMPLATE`（更新走 PUT 时校验 `STATUS='DRAFT'`，否则 403）
   - 按 `templateId` 全删 `QA_FA_TEMPLATE_ITEM`、`QA_FA_TEMPLATE_SECTION`，再批量 insert
   - **MyBatis 批量 insert 必须显式 `jdbcType`**（VARCHAR/DECIMAL/INTEGER），否则首批 NULL 会触发 `ORA-01790`
2. **启用 (enable)**：
   - 一条 SQL：`update QA_FA_TEMPLATE set STATUS='INACTIVE', UPDATE_TIME=sysdate where PROCESS_CODE=? and STATUS='ACTIVE' and ID<>?`
   - 然后：`update ... set STATUS='ACTIVE' where ID=?`
   - 启用前校验：至少 1 个 section + 1 个 item；processCode/version/name 非空
3. **删除/修改 items 前**：检查 `QA_FA_RECORD` 是否引用该模板：
   ```sql
   select count(1) from QA_FA_RECORD where TEMPLATE_ID = ?
   ```
   被引用：DELETE 拒(409)、PUT 拒(409，提示用复制新版本)、enable/disable 允许
4. **审计**：所有写操作 (POST/PUT/DELETE/enable/disable/copy) 写一条 `QA_FA_AUDIT_LOG`，operatorId 取 JWT，operatorName 取 `USERPROFILE.FULLNAME`。可参考现有 `QaFaRecordServiceImpl` 怎么写的。
5. **ID 生成**：用 `java.util.UUID.randomUUID().toString().replace("-","")`。版本号 `version` 用户填或自增（copy 时 `oldVersion + ".1"` 简单实现即可）。

### 4.4 鉴权

- 复用现有 `JwtUtils`，从 `Authorization: Bearer xxx` 解 token，取 `username`。
- **不引入 Spring Security**。在每个 admin 接口里手动校验 token 即可（参考 `LoginServerController` / 现有 controller 取 token 的写法）。
- 没拿到 username 一律返回 `401`。

### 4.5 CORS

确认 `Y:\PDA\pdaserver` 已有全局 CORS 配置（`config/` 目录下找 `CorsConfig` 或 `WebMvcConfig`）。如果没放开 `http://localhost:5173`，加上即可。前端 dev 用 vite proxy 也能绕过，二选一。

---

## 5. 前端开发任务清单 (Y:\jcd-mes-fa-admin，新建)

### 5.1 脚手架

```bash
cd Y:\
npm create vite@latest jcd-mes-fa-admin -- --template vue-ts
cd jcd-mes-fa-admin
npm i element-plus @element-plus/icons-vue axios pinia vue-router@4
npm i -D unplugin-auto-import unplugin-vue-components sass
```

### 5.2 目录结构

```
src/
├── api/
│   ├── request.ts          # axios 实例 + JWT 拦截器 + 401 跳登录 + 统一 res.data.data 解包
│   ├── auth.ts             # login()
│   └── template.ts         # 模板 CRUD/enable/disable/copy/processes
├── router/
│   └── index.ts            # /login, /(layout) → /templates, /templates/:id/edit
├── stores/
│   └── user.ts             # token, currentUser, login(), logout()
├── views/
│   ├── Login.vue
│   ├── Layout.vue          # 顶部用户名 + 退出，左侧菜单只放“模板维护”
│   └── template/
│       ├── List.vue        # 表格 + 筛选(工序/状态/关键字) + 操作按钮
│       └── Editor.vue      # 头表单 + sections 折叠面板 + items 行内表格(新增/删除/排序)
├── utils/
│   └── auth.ts             # token 存取(localStorage)
├── App.vue
└── main.ts
```

### 5.3 关键约定

1. **请求基址**：`vite.config.ts` 配 proxy
   ```ts
   server: {
     proxy: {
       '/api': { target: 'http://localhost:9900', changeOrigin: true }
     }
   }
   ```
   生产部署时 nginx 转发。
2. **token 存 localStorage**，key 用 `fa_admin_token`、`fa_admin_user`，**不要**和 PDA 端的 storage 撞名。
3. **响应解包**：拦截器里 `res.data.code===200` 返回 `res.data.data`，否则 `ElMessage.error` + `Promise.reject`。
4. **登录流程**：`POST /api/auth/login` body `{username, password}` → 拿到 `{token, user:{username, fullname,...}}` → 存 store + localStorage → 跳 `/templates`。
5. **路由守卫**：未登录跳 `/login`；401 拦截器清 token 跳 `/login`。

### 5.4 页面要点

**List.vue**
- 顶部筛选：工序下拉(调 `/processes`)、状态下拉(DRAFT/ACTIVE/INACTIVE/全部)、关键字
- 表格列：工序、版本、名称、SOP、状态(tag 着色)、有效期、更新时间、更新人、操作
- 操作按钮按状态显示：
  - DRAFT：编辑、启用、删除
  - ACTIVE：查看、停用、复制为新版本
  - INACTIVE：查看、启用、复制为新版本
- 「新建」按钮 → 跳 Editor 空白页

**Editor.vue**
- 顶部表单：工序(下拉)、版本、名称、SOP、有效期、备注
- 中部：`el-collapse` 列出 sections，每个 section 一个折叠面板
  - section 头部：code、name、排序、+/- 按钮
  - section 内：`el-table` 列出 items，每行可编辑（code/name/tool/inputType/unit/ruleJson/fillRole/required/critical/sortNo）
  - INPUT_TYPE 改变时，给 ruleJson 一个简单提示（不强校验，textarea 让用户填 JSON）
- 底部：保存(草稿)、保存并启用、取消
- **DRAFT** 状态全字段可编辑；**ACTIVE/INACTIVE** 全部只读，只显示「复制为新版本」按钮

---

## 6. 开发顺序（建议小步快跑）

1. **后端先**：
   - (1) 写 `QaFaTemplateAdminService` 接口 + impl 骨架（先 list/detail）
   - (2) 在 `QaFaTemplateMapper.xml` 加 admin SQL
   - (3) controller 串起来，用 Postman / curl 验证 list+detail+save
   - (4) 补 enable/disable/delete/copy/审计
2. **前端**：
   - (5) 起脚手架 + 跑通登录 + Layout
   - (6) List 页（只读联调）
   - (7) Editor 页（CRUD 联调）
   - (8) enable/disable/copy 按钮
3. **联调收尾**：在 lqc-app 的 first-article 页面验证：admin 启用的新模板能在 PDA 里被读到。

---

## 7. 一定要避开的坑（v1 踩过的）

1. **MyBatis 批量插入 ORA-01790**：`<foreach>` 里所有 `#{...}` 必须带 `jdbcType=VARCHAR/DECIMAL/INTEGER`，否则首条 NULL 会让 Oracle 推断成不同类型。
2. **`@Transactional` 全回滚**：保存模板时若 items 失败，整个事务回滚是对的；但**审计日志不能在同事务里写**，要么 `REQUIRES_NEW`，要么写在 controller 里包一层。
3. **storage key 不要混**：本项目用 `fa_admin_*`；不要去读 PDA 的 `current_employee` / `currentUser`。
4. **不要新建用户表 / 角色表**：MES 早就规定只用 `USERPROFILE`。
5. **不要引入 Lombok 新版/Java 17 写法**：项目锁 Java 8 + Spring Boot 2.7.3。Lombok `@Data` 已在用，沿用即可。
6. **配置外置**：所有"运维要改"的项（数据库、JWT 秘钥）已在 `application.properties`。**不要在代码里硬编码**端口/IP。
7. **响应结构**：必须 `{code, message, data}`，前端 axios 拦截器靠 `code===200` 判断。
8. **PROCESS_CODE 唯一 ACTIVE 规则**：enable 时务必先把同 process 的旧 ACTIVE 改 INACTIVE，不要漏。

---

## 8. 启动 / 验收清单

**后端**：
- [ ] `mvn clean package -DskipTests`
- [ ] 替换 `Y:\PDA\pdaserver\target\*.jar`，重启服务（端口 9900）
- [ ] curl 验：`POST /api/auth/login` 拿 token → `GET /api/qa-fa/admin/templates` 返回 200

**前端**：
- [ ] `npm run dev` 起 5173，登录成功进 List
- [ ] 新建一个 DRAFT 模板（含 1 section + 2 item），保存成功
- [ ] enable → 列表状态变 ACTIVE，旧版 ACTIVE 自动 INACTIVE
- [ ] PDA (lqc-app) 首件页面能拉到这个新模板

**部署**：
- [ ] 前端 `npm run build` → `dist/` 拷到 nginx
- [ ] nginx 配置 `/api/` 反代到 `http://<pdaserver>:9900/api/`
- [ ] 浏览器访问 `http://<服务器>/` 能登录

---

## 9. 给新会话 agent 的提示词（直接粘贴用）

```
你现在接手 jcd-mes-fa-admin (FA 模板维护 Web 后台 v2) 的开发。
请先读 Y:\PDA\pdaserver\docs\v2_fa_admin_dev_plan.md，按里面的清单做。
约束：
- 后端在 Y:\PDA\pdaserver (Spring Boot 2.7.3 / Java 8 / 端口 9900)，
  只在 com.jcd.controller.qafa.admin / com.jcd.service.qafa 下加新文件。
- 前端在 Y:\jcd-mes-fa-admin (Vue3+Vite+TS+ElementPlus，新建)。
- DDL 已执行，model 类已就位 (com.jcd.model.qafa)，不要重复建。
- 不引入 Lombok 新版 / Spring Security / Java 17 / Spring Boot 3。
- 响应结构 {code,message,data}，code===200 成功。
- 启用模板时同 PROCESS_CODE 旧 ACTIVE 自动改 INACTIVE。
开始时先确认：1) 是从后端骨架开始还是前端脚手架开始？  2) 是否要我先把现有 QaFaTemplateMapper.xml 给你看？
```

---

**完。把本文档发给新会话即可独立续作。**
