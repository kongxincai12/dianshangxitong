// 一次性语法检查：抽出 shop.html 里的内联 <script>，逐个 node --check
const fs = require('fs');
const cp = require('child_process');
const html = fs.readFileSync('src/main/resources/static/shop.html', 'utf8');
const re = /<script(?![^>]*\bsrc=)[^>]*>([\s\S]*?)<\/script>/gi;
let m, i = 0, bad = 0;
while ((m = re.exec(html))) {
  i++;
  const f = 'temp/_chk' + i + '.js';
  fs.writeFileSync(f, m[1]);
  const r = cp.spawnSync(process.execPath, ['--check', f], { encoding: 'utf8' });
  if (r.status === 0) {
    console.log('block ' + i + ' (line ' + html.slice(0, m.index).split('\n').length + '): OK');
  } else {
    bad++;
    console.log('block ' + i + ': SYNTAX ERROR\n' + r.stderr);
  }
  fs.unlinkSync(f);
}
console.log('checked ' + i + ' inline block(s), errors=' + bad);
