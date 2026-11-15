/*
 * 从 shop.html 里原样抽出 doRegister() 的源码，注入桩依赖后在 Node 里执行，
 * 逐条断言前端 5 个校验分支的提示文字与是否发出请求。
 * 之所以抽源码而不是重写：重写只能证明「我以为的逻辑」，证明不了文件里真实的逻辑。
 */
import { readFileSync } from 'node:fs';

const html = readFileSync(new URL('../src/main/resources/static/shop.html', import.meta.url), 'utf8');

function extract(name) {
  const start = html.indexOf('async function ' + name + '() {');
  if (start < 0) throw new Error('未找到函数 ' + name);
  let i = html.indexOf('{', start), depth = 0;
  for (let j = i; j < html.length; j++) {
    if (html[j] === '{') depth++;
    else if (html[j] === '}') { depth--; if (depth === 0) return html.slice(start, j + 1); }
  }
  throw new Error('函数 ' + name + ' 花括号不配对');
}

const src = extract('doRegister');
console.log('抽出的源码行数 = ' + src.split('\n').length + '\n');

let failed = 0;
function check(label, cond, actual) {
  if (cond) console.log('  [PASS] ' + label);
  else { console.log('  [FAIL] ' + label + '  实际: ' + actual); failed++; }
}

async function run(form, postImpl) {
  const toasts = [], calls = [], steps = [];
  const box = { username: '', password: '', confirm: '', nickname: '', phone: '' };
  Object.assign(box, form);
  const regForm = box;
  const loginForm = { username: '', password: '' };
  const notify = (m, e) => toasts.push(m);
  const showAuth = v => steps.push('showAuth(' + v + ')');
  const doLogin = async () => { steps.push('doLogin'); };
  const http = { post: async (p, b) => { calls.push({ path: p, body: b }); return postImpl(p, b); } };
  const regLoading = { value: false };

  const fn = new Function(
    'regForm', 'loginForm', 'notify', 'showAuth', 'doLogin', 'http', 'regLoading',
    'var f = ' + src.replace('async function doRegister()', 'async function __t()') + '; return f();'
  );
  await fn(regForm, loginForm, notify, showAuth, doLogin, http, regLoading);
  return { toasts, calls, steps, loginForm, loadingAfter: regLoading.value };
}

const OK = async () => ({ username: 'x' });
const DUP = async () => { const e = new Error('dup'); e.code = 409; e.message = '用户名已存在: uitest88'; throw e; };

console.log('=== 场景① 必填项为空 ===');
let r = await run({ username: '', password: '', confirm: '' }, OK);
check('提示「请填写用户名和密码」', r.toasts[0] === '请填写用户名和密码', JSON.stringify(r.toasts));
check('未发出任何请求', r.calls.length === 0, JSON.stringify(r.calls));

r = await run({ username: 'uitest88', password: '', confirm: '' }, OK);
check('密码为空也被拦住', r.toasts[0] === '请填写用户名和密码', JSON.stringify(r.toasts));

r = await run({ username: 'uitest88', password: 'abc123', confirm: '' }, OK);
check('确认密码为空也被拦住', r.toasts[0] === '请填写用户名和密码', JSON.stringify(r.toasts));

console.log('\n=== 场景② 长度与一致性 ===');
r = await run({ username: 'ab', password: 'abc123', confirm: 'abc123' }, OK);
check('用户名 2 字符 →「用户名至少 3 个字符」', r.toasts[0] === '用户名至少 3 个字符', JSON.stringify(r.toasts));
check('  且未发请求', r.calls.length === 0, JSON.stringify(r.calls));

r = await run({ username: 'uitest88', password: '123', confirm: '123' }, OK);
check('密码 3 位 →「密码至少 6 个字符」', r.toasts[0] === '密码至少 6 个字符', JSON.stringify(r.toasts));

r = await run({ username: 'uitest88', password: 'abc123', confirm: 'abc999' }, OK);
check('两次不一致 →「两次输入的密码不一致」', r.toasts[0] === '两次输入的密码不一致', JSON.stringify(r.toasts));
check('  且未发请求', r.calls.length === 0, JSON.stringify(r.calls));

console.log('\n=== 场景③ 校验通过后注册并自动登录 ===');
r = await run({ username: 'uitest88', password: 'abc123', confirm: 'abc123', nickname: '浏览器测试', phone: '' }, OK);
check('发出 /api/auth/register', r.calls[0] && r.calls[0].path === '/api/auth/register', JSON.stringify(r.calls));
const body = r.calls[0].body;
check('payload 含 username/password', body.username === 'uitest88' && body.password === 'abc123', JSON.stringify(body));
check('昵称原样传，手机号留空时传 null 而不是空串', body.nickname === '浏览器测试' && body.phone === null, JSON.stringify(body));
check('payload 里没有 role 字段（防提权）', !('role' in body), JSON.stringify(Object.keys(body)));
check('凭据回填到 loginForm', r.loginForm.username === 'uitest88' && r.loginForm.password === 'abc123', JSON.stringify(r.loginForm));
check('切回登录视图后自动 doLogin', r.steps.join(',') === 'showAuth(login),doLogin', JSON.stringify(r.steps));
check('按钮 loading 已复位', r.loadingAfter === false, String(r.loadingAfter));

console.log('\n=== 场景④ 重名（后端 409）===');
r = await run({ username: 'uitest88', password: 'abc123', confirm: 'abc123' }, DUP);
check('原样显示后端 message', r.toasts[0] === '用户名已存在: uitest88', JSON.stringify(r.toasts));
check('不会误触发自动登录', !r.steps.includes('doLogin'), JSON.stringify(r.steps));
check('按钮 loading 已复位', r.loadingAfter === false, String(r.loadingAfter));

console.log('\n================ FAILED=' + failed + ' ================');
process.exit(failed > 0 ? 1 : 0);
