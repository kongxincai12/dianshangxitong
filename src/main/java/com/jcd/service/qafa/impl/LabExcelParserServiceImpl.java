package com.jcd.service.qafa.impl;

import com.jcd.model.qafa.QaFaLabData;
import com.jcd.model.qafa.QaFaLabDataItem;
import com.jcd.service.qafa.LabExcelParserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FT160 实验室 xlsx 解析 (锚点法).
 *
 * 文件名样例: 002-20613A-M110615001-03.xlsx 或 002-20613A-D2ZE-M110615001-03.xlsx
 */
@Service
public class LabExcelParserServiceImpl implements LabExcelParserService {

    /** 允许识别为元素列的列名白名单 (大小写不敏感) */
    private static final Set<String> ALLOWED_ELEMENT_COLS = new HashSet<>(Arrays.asList(
            "AU", "NI", "NI;P", "P 浓度", "P浓度", "CU", "PD", "SN"
    ));

    private static final Pattern FILE_NAME_PATTERN = Pattern.compile(
            "^(\\d{3})-([A-Za-z0-9]+)(?:-([A-Za-z0-9]+))?-(M\\d+)(?:-([A-Z]+))?-(\\d+)\\.xlsx$",
            Pattern.CASE_INSENSITIVE);

    @Override
    public ParseResult parse(String filePath, String fileName, String recordLotName) throws Exception {
        ParseResult result = new ParseResult();
        QaFaLabData header = new QaFaLabData();
        header.setFileName(fileName);
        result.setHeader(header);

        // 文件名解析
        if (fileName != null) {
            Matcher m = FILE_NAME_PATTERN.matcher(fileName);
            if (m.matches()) {
                String parsedLot = m.group(4); // Mxxxxxxx
                header.setFileLotParsed(parsedLot);
                if (recordLotName != null && parsedLot != null && recordLotName.contains(parsedLot)) {
                    header.setLotMatchResult("MATCH");
                } else {
                    header.setLotMatchResult("MISMATCH");
                }
            } else {
                header.setLotMatchResult("UNKNOWN");
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(0);
            // 1. 抓取头部信息
            scanHeader(sheet, header);
            // 2. 找 [测量结果] 表
            List<QaFaLabDataItem> items = parseMeasureTable(sheet);
            result.setItems(items);
            result.setParseStatus(items.isEmpty() ? "PARTIAL" : "OK");
        } catch (Exception e) {
            result.setParseStatus("FAILED");
            result.setParseError(e.getMessage());
            if (result.getItems() == null) result.setItems(new ArrayList<>());
        }
        return result;
    }

    /* ===================================================================== */

    private void scanHeader(Sheet sheet, QaFaLabData header) {
        int last = Math.min(sheet.getLastRowNum(), 80); // 头部信息一般在前 80 行内
        for (int r = sheet.getFirstRowNum(); r <= last; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            for (int c = row.getFirstCellNum(); c >= 0 && c < row.getLastCellNum(); c++) {
                String text = cellString(row.getCell(c));
                if (text == null || text.isEmpty()) continue;
                String t = text.trim();
                String right = nextNonEmpty(row, c);

                if (matches(t, "样品名称")) header.setSampleName(right);
                else if (matches(t, "测量员", "测試員")) header.setMeasurer(right);
                else if (matches(t, "Machine Name", "机台名称", "機台名稱")) header.setMachineName(right);
                else if (matches(t, "判定标准", "判定標準")) {
                    header.setJudgeStdText(right);
                    parseJudgeStdRange(right, header);
                } else if (matches(t, "判定")) {
                    if (right != null) {
                        if (right.contains("ACC") || right.contains("OK") || right.contains("合格")) header.setJudgeResult("ACC");
                        else if (right.contains("NG") || right.contains("不合格")) header.setJudgeResult("NG");
                        else header.setJudgeResult(right);
                    }
                } else if (matches(t, "测试日期", "測試日期", "Test Date")) {
                    Cell rc = nextNonEmptyCell(row, c);
                    if (rc != null && rc.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(rc)) {
                        header.setTestDate(rc.getDateCellValue());
                    }
                }
            }
        }
    }

    /**
     * 解析 "Au:0.05~0.15um Ni:2.0~5.0um" 之类的范围
     */
    private void parseJudgeStdRange(String text, QaFaLabData header) {
        if (text == null) return;
        Pattern p = Pattern.compile("(Au|Ni)\\s*[:：]?\\s*([\\d.]+)\\s*[~～-]\\s*([\\d.]+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        while (m.find()) {
            String el = m.group(1).toUpperCase();
            try {
                BigDecimal lo = new BigDecimal(m.group(2));
                BigDecimal hi = new BigDecimal(m.group(3));
                if ("AU".equals(el)) {
                    header.setJudgeStdAuMin(lo);
                    header.setJudgeStdAuMax(hi);
                } else if ("NI".equals(el)) {
                    header.setJudgeStdNiMin(lo);
                    header.setJudgeStdNiMax(hi);
                }
            } catch (Exception ignore) {}
        }
    }

    /* ====================== [测量结果] 表 ====================== */

    private List<QaFaLabDataItem> parseMeasureTable(Sheet sheet) {
        List<QaFaLabDataItem> result = new ArrayList<>();

        // 1. 找 [测量结果] 锚点
        int anchorRow = -1;
        int anchorCol = -1;
        outer:
        for (int r = sheet.getFirstRowNum(); r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            for (int c = row.getFirstCellNum(); c >= 0 && c < row.getLastCellNum(); c++) {
                String t = cellString(row.getCell(c));
                if (t != null && (t.contains("[测量结果]") || t.contains("[測量結果]") || t.contains("测量结果"))) {
                    anchorRow = r;
                    anchorCol = c;
                    break outer;
                }
            }
        }
        if (anchorRow < 0) return result;

        // 2. 在锚点之下 1-6 行找列头(包含 "Au"/"Ni" 等关键词)
        int headerRow = -1;
        for (int r = anchorRow + 1; r <= Math.min(anchorRow + 8, sheet.getLastRowNum()); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            for (int c = row.getFirstCellNum(); c >= 0 && c < row.getLastCellNum(); c++) {
                String t = cellString(row.getCell(c));
                if (t == null) continue;
                String tu = t.trim().toUpperCase();
                if (ALLOWED_ELEMENT_COLS.contains(tu)) {
                    headerRow = r;
                    break;
                }
            }
            if (headerRow >= 0) break;
        }
        if (headerRow < 0) return result;

        Row hRow = sheet.getRow(headerRow);
        // 收集列: cellIdx -> columnName
        LinkedHashMap<Integer, String> colMap = new LinkedHashMap<>();
        for (int c = hRow.getFirstCellNum(); c >= 0 && c < hRow.getLastCellNum(); c++) {
            String t = cellString(hRow.getCell(c));
            if (t == null) continue;
            String tu = t.trim().toUpperCase();
            if (ALLOWED_ELEMENT_COLS.contains(tu)) {
                colMap.put(c, t.trim());
            }
        }
        if (colMap.isEmpty()) return result;

        // 3. 从 headerRow+1 开始往下找统计行(平均/标准差/CV%/范围/最大/最小)与原始测量数据
        // 先收集所有数据行 (左侧第一列为序号或为空时跳过统计行)
        Map<String, Map<Integer, BigDecimal>> stats = new HashMap<>(); // statName -> col -> value
        Map<Integer, List<BigDecimal>> rawValues = new HashMap<>();
        Map<Integer, Boolean> infiniteFlag = new HashMap<>();
        Map<Integer, String> unitMap = new HashMap<>();

        for (int r = headerRow + 1; r <= Math.min(headerRow + 200, sheet.getLastRowNum()); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            // 用左侧 anchorCol 列附近找标签
            String label = null;
            for (int c = Math.max(0, anchorCol - 1); c <= anchorCol + 2 && c < (row.getLastCellNum() < 0 ? 0 : row.getLastCellNum()); c++) {
                String t = cellString(row.getCell(c));
                if (t != null && !t.trim().isEmpty()) { label = t.trim(); break; }
            }
            if (label == null) continue;

            String key = mapStatLabel(label);
            if ("UNIT".equals(key)) {
                for (Map.Entry<Integer, String> en : colMap.entrySet()) {
                    String u = cellString(row.getCell(en.getKey()));
                    if (u != null) unitMap.put(en.getKey(), u.trim());
                }
            } else if (key != null) {
                Map<Integer, BigDecimal> map = stats.computeIfAbsent(key, k -> new HashMap<>());
                for (Map.Entry<Integer, String> en : colMap.entrySet()) {
                    Cell cell = row.getCell(en.getKey());
                    BigDecimal v = readDecimal(cell);
                    String txt = cellString(cell);
                    if (txt != null && (txt.contains("∞") || txt.equalsIgnoreCase("INF"))) {
                        infiniteFlag.put(en.getKey(), true);
                    }
                    if (v != null) map.put(en.getKey(), v);
                }
            } else if (label.matches("^\\d+$")) {
                // 原始测量数据行 (左侧为纯数字序号)
                for (Map.Entry<Integer, String> en : colMap.entrySet()) {
                    Cell cell = row.getCell(en.getKey());
                    BigDecimal v = readDecimal(cell);
                    if (v != null) rawValues.computeIfAbsent(en.getKey(), k -> new ArrayList<>()).add(v);
                }
            }
        }

        // 4. 组装 items
        int sort = 0;
        for (Map.Entry<Integer, String> en : colMap.entrySet()) {
            int colIdx = en.getKey();
            QaFaLabDataItem it = new QaFaLabDataItem();
            it.setColumnName(en.getValue());
            it.setUnit(unitMap.get(colIdx));
            it.setAvgVal(getStat(stats, "AVG", colIdx));
            it.setStdVal(getStat(stats, "STD", colIdx));
            it.setCvVal(getStat(stats, "CV", colIdx));
            it.setRangeVal(getStat(stats, "RANGE", colIdx));
            it.setMaxVal(getStat(stats, "MAX", colIdx));
            it.setMinVal(getStat(stats, "MIN", colIdx));
            it.setInfiniteFlag(Boolean.TRUE.equals(infiniteFlag.get(colIdx)) ? 1 : 0);
            List<BigDecimal> raw = rawValues.get(colIdx);
            if (raw != null && !raw.isEmpty()) {
                StringBuilder sb = new StringBuilder("[");
                for (int i = 0; i < raw.size(); i++) {
                    if (i > 0) sb.append(",");
                    sb.append(raw.get(i).toPlainString());
                }
                sb.append("]");
                it.setRawValuesJson(sb.toString());
            }
            it.setSortNo(sort++);
            result.add(it);
        }
        return result;
    }

    private BigDecimal getStat(Map<String, Map<Integer, BigDecimal>> stats, String key, int col) {
        Map<Integer, BigDecimal> m = stats.get(key);
        return m == null ? null : m.get(col);
    }

    private String mapStatLabel(String label) {
        String t = label.replace("％", "%").replace(" ", "");
        if (t.contains("平均")) return "AVG";
        if (t.contains("标准差") || t.contains("標準差") || t.equalsIgnoreCase("STDEV") || t.equalsIgnoreCase("STD")) return "STD";
        if (t.contains("CV%") || t.equalsIgnoreCase("CV")) return "CV";
        if (t.contains("范围") || t.contains("範圍") || t.equalsIgnoreCase("RANGE")) return "RANGE";
        if (t.contains("最大") || t.equalsIgnoreCase("MAX")) return "MAX";
        if (t.contains("最小") || t.equalsIgnoreCase("MIN")) return "MIN";
        if (t.contains("单位") || t.contains("單位") || t.equalsIgnoreCase("UNIT")) return "UNIT";
        return null;
    }

    /* ===================== cell helpers ===================== */

    private String cellString(Cell cell) {
        if (cell == null) return null;
        try {
            switch (cell.getCellType()) {
                case STRING:  return cell.getStringCellValue();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString();
                    }
                    double d = cell.getNumericCellValue();
                    if (d == Math.floor(d) && !Double.isInfinite(d)) return Long.toString((long) d);
                    return Double.toString(d);
                case BOOLEAN: return Boolean.toString(cell.getBooleanCellValue());
                case FORMULA:
                    try { return cell.getStringCellValue(); }
                    catch (Exception e) {
                        try { return Double.toString(cell.getNumericCellValue()); }
                        catch (Exception ignore) { return null; }
                    }
                default: return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private BigDecimal readDecimal(Cell cell) {
        if (cell == null) return null;
        try {
            if (cell.getCellType() == CellType.NUMERIC) {
                return BigDecimal.valueOf(cell.getNumericCellValue());
            }
            String s = cellString(cell);
            if (s == null) return null;
            s = s.replace(",", "").trim();
            if (s.contains("∞") || s.equalsIgnoreCase("INF")) return null;
            return new BigDecimal(s);
        } catch (Exception e) {
            return null;
        }
    }

    private String nextNonEmpty(Row row, int fromCol) {
        Cell c = nextNonEmptyCell(row, fromCol);
        return cellString(c);
    }

    private Cell nextNonEmptyCell(Row row, int fromCol) {
        if (row == null) return null;
        int last = row.getLastCellNum();
        for (int i = fromCol + 1; i < last; i++) {
            Cell c = row.getCell(i);
            String t = cellString(c);
            if (t != null && !t.trim().isEmpty()) return c;
        }
        return null;
    }

    private boolean matches(String text, String... keys) {
        if (text == null) return false;
        String t = text.replace(" ", "");
        for (String k : keys) {
            if (t.contains(k.replace(" ", ""))) return true;
        }
        return false;
    }
}
