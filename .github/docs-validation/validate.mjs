import fs from 'node:fs';
import path from 'node:path';
import { JSDOM } from 'jsdom';

// Mermaid's sanitizer requires browser DOM globals before the Mermaid module loads.
const dom = new JSDOM('<!doctype html><html><body></body></html>', {
  url: 'https://example.test'
});
globalThis.window = dom.window;
globalThis.document = dom.window.document;
globalThis.Node = dom.window.Node;
globalThis.Element = dom.window.Element;
const { default: mermaid } = await import('mermaid');

const root = path.resolve(import.meta.dirname, '../..');
const errors = [];
const files = [];
const fence = String.fromCharCode(96).repeat(3);
const diagramRegex = new RegExp(fence + 'mermaid[^\\S\\n]*\\n([\\s\\S]*?)' + fence, 'g');
const linkRegex = /\[[^\]]+\]\(([^)]+)\)/g;

function visit(directory) {
  for (const entry of fs.readdirSync(directory, { withFileTypes: true })) {
    const full = path.join(directory, entry.name);
    if (entry.isDirectory()) visit(full);
    else if (entry.name.endsWith('.md')) files.push(full);
  }
}
visit(path.join(root, 'docs'));
files.push(path.join(root, 'README.md'));
mermaid.initialize({ startOnLoad: false, securityLevel: 'strict' });


// Preserve GitHub's README.md convention; require lowercase kebab-case for other docs.
for (const file of files) {
  const name = path.basename(file);
  if (name !== 'README.md' && !/^[a-z0-9]+(?:-[a-z0-9]+)*\.md$/.test(name)) {
    errors.push(path.relative(root, file) + ': filename must use lowercase kebab-case');
  }
}

let diagrams = 0;
let links = 0;
for (const file of files) {
  const markdown = fs.readFileSync(file, 'utf8');
  const label = path.relative(root, file);
  for (const block of markdown.matchAll(diagramRegex)) {
    diagrams++;
    try {
      await mermaid.parse(block[1]);
    } catch (error) {
      errors.push(label + ': Mermaid parse error: ' + (error?.message ?? error));
    }
  }
  for (const match of markdown.matchAll(linkRegex)) {
    const destination = match[1].trim().replace(/^<|>$/g, '');
    if (/^(?:https?:|mailto:|#|javascript:)/i.test(destination)) continue;
    const urlPath = destination.split('#')[0].split('?')[0];
    if (!urlPath) continue;
    const target = path.resolve(path.dirname(file), decodeURIComponent(urlPath));
    links++;
    if (!target.startsWith(root + path.sep)) errors.push(label + ': link leaves repository: ' + destination);
    else if (!fs.existsSync(target)) errors.push(label + ': broken link: ' + destination);
  }
}

const gof = fs.readdirSync(path.join(root, 'docs/guides')).filter(x => x.endsWith('.md'));
const enterprise = fs.readdirSync(path.join(root, 'docs/enterprise'))
  .filter(x => x.endsWith('.md') && !['README.md', 'spring-integration.md'].includes(x));
if (gof.length !== 23) errors.push('Expected 23 GoF guides, found ' + gof.length);
if (enterprise.length !== 5) errors.push('Expected 5 enterprise guides, found ' + enterprise.length);
for (const file of [
  ...gof.map(p => path.join(root, 'docs/guides', p)),
  ...enterprise.map(p => path.join(root, 'docs/enterprise', p))
]) {
  const markdown = fs.readFileSync(file, 'utf8');
  const label = path.relative(root, file);
  if (!markdown.includes(fence + 'mermaid')) errors.push(label + ': no Mermaid diagram');
  if (!markdown.includes('java -cp target/classes')) errors.push(label + ': no runnable command');
  if (!/Expected output|Expected result/i.test(markdown)) errors.push(label + ': no expected output');
  if (!markdown.includes('-Dtest=')) errors.push(label + ': no focused test command');
}
if (diagrams < 30) errors.push('Expected at least 30 Mermaid diagrams; found ' + diagrams);
for (const error of errors) console.error('ERROR ' + error);
if (errors.length) process.exitCode = 1;
else console.log('PASS: ' + files.length + ' Markdown files, ' + links +
                 ' relative links, ' + diagrams + ' Mermaid diagrams.');
