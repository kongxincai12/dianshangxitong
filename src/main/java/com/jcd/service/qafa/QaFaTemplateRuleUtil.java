package com.jcd.service.qafa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcd.model.qafa.QaFaTemplateItem;

import java.math.BigDecimal;
import java.util.List;

public final class QaFaTemplateRuleUtil {

    public static final String MODE_WARN = "WARN";
    public static final String MODE_FORCE_NG = "FORCE_NG";

    private QaFaTemplateRuleUtil() {
    }

    public static void applyRuleFields(List<QaFaTemplateItem> items) {
        if (items == null) return;
        for (QaFaTemplateItem item : items) {
            applyRuleFields(item);
        }
    }

    public static void applyRuleFields(QaFaTemplateItem item) {
        if (item == null) return;
        JSONObject rule = parseRuleJson(item.getRuleJson());

        if (item.getStandardMin() == null) {
            item.setStandardMin(firstBigDecimal(rule, "standardMin", "min", "lowerLimit", "lower"));
        }
        if (item.getStandardMax() == null) {
            item.setStandardMax(firstBigDecimal(rule, "standardMax", "max", "upperLimit", "upper"));
        }
        if (item.getRangeCheckEnabled() == null) {
            item.setRangeCheckEnabled(booleanAsInt(firstValue(rule, "rangeCheckEnabled", "enabled")));
        }
        item.setRangeCheckMode(normalizeMode(firstText(item.getRangeCheckMode(), getString(rule, "rangeCheckMode"), getString(rule, "mode"))));
    }

    public static String mergeRangeRuleJson(QaFaTemplateItem item) {
        JSONObject rule = parseRuleJson(item == null ? null : item.getRuleJson());
        if (item == null) return rule.toJSONString();
        applyRuleFields(item);

        if (item.getStandardMin() != null) rule.put("standardMin", item.getStandardMin());
        else rule.remove("standardMin");

        if (item.getStandardMax() != null) rule.put("standardMax", item.getStandardMax());
        else rule.remove("standardMax");

        boolean enabled = item.getRangeCheckEnabled() != null && item.getRangeCheckEnabled() == 1;
        rule.put("rangeCheckEnabled", enabled);
        rule.put("rangeCheckMode", normalizeMode(item.getRangeCheckMode()));
        return rule.toJSONString();
    }

    public static boolean isBooleanItem(QaFaTemplateItem item) {
        if (item == null || item.getInputType() == null) return false;
        String inputType = item.getInputType().trim().toUpperCase();
        return "PASS_FAIL".equals(inputType) || "PASSFAIL".equals(inputType);
    }

    public static boolean shouldCheckRange(QaFaTemplateItem item) {
        applyRuleFields(item);
        if (item == null || isBooleanItem(item)) return false;
        if (item.getInputType() == null || !"NUMBER".equalsIgnoreCase(item.getInputType().trim())) return false;
        if (item.getRangeCheckEnabled() == null || item.getRangeCheckEnabled() != 1) return false;
        return item.getStandardMin() != null || item.getStandardMax() != null;
    }

    public static boolean isForceNg(QaFaTemplateItem item) {
        applyRuleFields(item);
        return item != null && MODE_FORCE_NG.equals(normalizeMode(item.getRangeCheckMode()));
    }

    public static RangeCheckResult checkRange(QaFaTemplateItem item, String value) {
        if (!shouldCheckRange(item) || !hasText(value)) return RangeCheckResult.ok();
        BigDecimal actual;
        try {
            actual = new BigDecimal(value.trim());
        } catch (Exception e) {
            return RangeCheckResult.fail("不是有效数字");
        }
        if (item.getStandardMin() != null && actual.compareTo(item.getStandardMin()) < 0) {
            return RangeCheckResult.fail("低于标准下限 " + item.getStandardMin());
        }
        if (item.getStandardMax() != null && actual.compareTo(item.getStandardMax()) > 0) {
            return RangeCheckResult.fail("高于标准上限 " + item.getStandardMax());
        }
        return RangeCheckResult.ok();
    }

    public static String normalizeMode(String mode) {
        if (!hasText(mode)) return MODE_WARN;
        String m = mode.trim().toUpperCase();
        if ("FORCE".equals(m) || "NG".equals(m) || "FORCE_NG".equals(m)) return MODE_FORCE_NG;
        return MODE_WARN;
    }

    private static JSONObject parseRuleJson(String text) {
        if (!hasText(text)) return new JSONObject();
        try {
            JSONObject obj = JSON.parseObject(text);
            return obj == null ? new JSONObject() : obj;
        } catch (Exception e) {
            return new JSONObject();
        }
    }

    private static BigDecimal firstBigDecimal(JSONObject obj, String... keys) {
        for (String key : keys) {
            Object value = firstValue(obj, key);
            if (value == null) continue;
            try {
                return value instanceof BigDecimal ? (BigDecimal) value : new BigDecimal(String.valueOf(value).trim());
            } catch (Exception ignored) {
            }
        }
        return null;
    }

    private static Object firstValue(JSONObject obj, String... keys) {
        if (obj == null || keys == null) return null;
        for (String key : keys) {
            if (obj.containsKey(key)) return obj.get(key);
        }
        return null;
    }

    private static String getString(JSONObject obj, String key) {
        Object value = firstValue(obj, key);
        return value == null ? null : String.valueOf(value);
    }

    private static String firstText(String... values) {
        if (values == null) return null;
        for (String value : values) {
            if (hasText(value)) return value;
        }
        return null;
    }

    private static Integer booleanAsInt(Object value) {
        if (value == null) return 0;
        if (value instanceof Boolean) return (Boolean) value ? 1 : 0;
        String s = String.valueOf(value).trim();
        return "1".equals(s) || "Y".equalsIgnoreCase(s) || "YES".equalsIgnoreCase(s) || "TRUE".equalsIgnoreCase(s) ? 1 : 0;
    }

    private static boolean hasText(String value) {
        return value != null && value.trim().length() > 0;
    }

    public static class RangeCheckResult {
        private final boolean pass;
        private final String message;

        private RangeCheckResult(boolean pass, String message) {
            this.pass = pass;
            this.message = message;
        }

        public static RangeCheckResult ok() {
            return new RangeCheckResult(true, "");
        }

        public static RangeCheckResult fail(String message) {
            return new RangeCheckResult(false, message);
        }

        public boolean isPass() {
            return pass;
        }

        public String getMessage() {
            return message;
        }
    }
}
