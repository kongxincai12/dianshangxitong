package com.jcd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WCF MaterialSer SOAP 客户端
 * <p>
 * 通过 SOAP 1.1 调用 C# WCF 服务的 PassLocation / UpnTransfer4Location 等方法，
 * 复用 C# 端完整的业务验证逻辑（过站检查、工艺路线校验、料号-储位映射等）。
 * <p>
 * WSDL: {wcf.material-ser.url}?wsdl  (参见 MaterialSer.xml)
 * 协议: SOAP 1.1, document/literal, BasicHttpBinding
 * 命名空间: http://tempuri.org/
 */
@Service
public class WcfMaterialService {

    private static final Logger logger = LoggerFactory.getLogger(WcfMaterialService.class);

    private static final String SOAP_NS = "http://tempuri.org/";
    private static final String SOAP_ACTION_PREFIX = "http://tempuri.org/IMaterialSer/";

    @Value("${wcf.material-ser.url:http://10.10.100.138:8021/Evo.Services/MaterialSer/}")
    private String wcfUrl;

    private RestTemplate wcfRestTemplate;

    @PostConstruct
    public void init() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000);  // 10秒连接超时
        factory.setReadTimeout(30000);     // 30秒读取超时 (WCF可能有复杂事务)
        this.wcfRestTemplate = new RestTemplate(factory);

        // 强制 StringHttpMessageConverter 使用 UTF-8 编码
        // Spring 默认 ISO-8859-1，会导致中文参数（如站名"线边仓入库"）传输乱码
        this.wcfRestTemplate.getMessageConverters().stream()
                .filter(c -> c instanceof org.springframework.http.converter.StringHttpMessageConverter)
                .map(c -> (org.springframework.http.converter.StringHttpMessageConverter) c)
                .forEach(c -> c.setDefaultCharset(StandardCharsets.UTF_8));

        logger.info("[WCF] MaterialSer SOAP客户端初始化完成, URL={}, charset=UTF-8", wcfUrl);
    }

    // ===================== 公开方法 =====================

    /**
     * 调用 C# PassLocation — 线边仓入库（含完整过站校验）
     *
     * @param ltcode      储位编码 (LOC_NAME)
     * @param locationid  LOCATIONID (可传空串，C#内部会根据ltcode查)
     * @param upnname     UPN条码
     * @param type        操作类型 "2"=线边仓入库
     * @param stationname 站点名称，如 "线边仓入库"
     * @param username    操作人
     * @param sysUserId   系统用户ID (可传空串)
     * @return WcfResult 包含 success 和 message
     */
    public WcfResult passLocation(String ltcode, String locationid, String upnname,
                                  String type, String stationname,
                                  String username, String sysUserId) {
        String soapBody =
                "<tem:PassLocation>" +
                "  <tem:ltcode>" + escapeXml(ltcode) + "</tem:ltcode>" +
                "  <tem:locationid>" + escapeXml(locationid) + "</tem:locationid>" +
                "  <tem:upnname>" + escapeXml(upnname) + "</tem:upnname>" +
                "  <tem:type>" + escapeXml(type) + "</tem:type>" +
                "  <tem:stationname>" + escapeXml(stationname) + "</tem:stationname>" +
                "  <tem:username>" + escapeXml(username) + "</tem:username>" +
                "  <tem:sys_user_id>" + escapeXml(sysUserId) + "</tem:sys_user_id>" +
                "</tem:PassLocation>";

        String response = callSoap("PassLocation", soapBody);
        boolean success = extractBooleanTag(response, "PassLocationResult");
        String message = extractStringTag(response, "message");

        logger.info("[WCF] PassLocation: upn={}, ltcode={}, success={}, msg={}",
                upnname, ltcode, success, message);
        return new WcfResult(success, message);
    }

    /**
     * 查询UPN本次入库是否会执行SMT直接退料，以及需要用户确认的剩余数量。
     */
    public WcfSmtDirectReturnPreviewResult checkSmtDirectReturnForInbound(String upnname, String sysUserId) {
        String soapBody =
                "<tem:CheckSmtDirectReturnForInbound>" +
                "  <tem:upnname>" + escapeXml(upnname) + "</tem:upnname>" +
                "  <tem:sys_user_id>" + escapeXml(sysUserId) + "</tem:sys_user_id>" +
                "</tem:CheckSmtDirectReturnForInbound>";

        String response = callSoap("CheckSmtDirectReturnForInbound", soapBody);
        boolean success = extractBooleanTag(response, "CheckSmtDirectReturnForInboundResult");
        boolean needConfirm = extractBooleanTag(response, "needConfirm");
        String remainingQtyText = extractStringTag(response, "remainingQty");
        BigDecimal remainingQty = remainingQtyText.isEmpty() ? BigDecimal.ZERO : new BigDecimal(remainingQtyText);
        String message = extractStringTag(response, "message");

        logger.info("[WCF] CheckSmtDirectReturnForInbound: upn={}, success={}, needConfirm={}, remainingQty={}, msg={}",
                upnname, success, needConfirm, remainingQty, message);
        return new WcfSmtDirectReturnPreviewResult(success, needConfirm, remainingQty, message);
    }

    /**
     * 使用用户确认的UPN剩余数量执行SMT直接退料入库。
     */
    public WcfResult passLocationWithSmtReturnConfirmation(String ltcode, String locationid, String upnname,
                                                            String type, String stationname, String username,
                                                            String sysUserId, BigDecimal confirmedRemainingQty) {
        String soapBody =
                "<tem:PassLocationWithSmtReturnConfirmation>" +
                "  <tem:ltcode>" + escapeXml(ltcode) + "</tem:ltcode>" +
                "  <tem:locationid>" + escapeXml(locationid) + "</tem:locationid>" +
                "  <tem:upnname>" + escapeXml(upnname) + "</tem:upnname>" +
                "  <tem:type>" + escapeXml(type) + "</tem:type>" +
                "  <tem:stationname>" + escapeXml(stationname) + "</tem:stationname>" +
                "  <tem:username>" + escapeXml(username) + "</tem:username>" +
                "  <tem:sys_user_id>" + escapeXml(sysUserId) + "</tem:sys_user_id>" +
                "  <tem:confirmedRemainingQty>" + confirmedRemainingQty.toPlainString() + "</tem:confirmedRemainingQty>" +
                "</tem:PassLocationWithSmtReturnConfirmation>";

        String response = callSoap("PassLocationWithSmtReturnConfirmation", soapBody);
        boolean success = extractBooleanTag(response, "PassLocationWithSmtReturnConfirmationResult");
        String message = extractStringTag(response, "message");

        logger.info("[WCF] PassLocationWithSmtReturnConfirmation: upn={}, ltcode={}, confirmedQty={}, success={}, msg={}",
                upnname, ltcode, confirmedRemainingQty, success, message);
        return new WcfResult(success, message);
    }

    /**
     * 调用 C# UpnTransfer4Location — UPN移库
     *
     * @param locationSn 目标储位编码 (LOC_NAME)
     * @param upnname    UPN条码
     * @param username   操作人
     * @param sysUserId  系统用户ID (可传空串)
     * @return WcfResult 包含 success 和 message
     */
    public WcfResult upnTransfer4Location(String locationSn, String upnname,
                                          String username, String sysUserId) {
        String soapBody =
                "<tem:UpnTransfer4Location>" +
                "  <tem:locationSn>" + escapeXml(locationSn) + "</tem:locationSn>" +
                "  <tem:upnname>" + escapeXml(upnname) + "</tem:upnname>" +
                "  <tem:username>" + escapeXml(username) + "</tem:username>" +
                "  <tem:sys_user_id>" + escapeXml(sysUserId) + "</tem:sys_user_id>" +
                "</tem:UpnTransfer4Location>";

        String response = callSoap("UpnTransfer4Location", soapBody);
        boolean success = extractBooleanTag(response, "UpnTransfer4LocationResult");
        String message = extractStringTag(response, "message");

        logger.info("[WCF] UpnTransfer4Location: upn={}, locationSn={}, success={}, msg={}",
                upnname, locationSn, success, message);
        return new WcfResult(success, message);
    }

    /**
     * 调用 C# CheckLocation — 校验储位
     *
     * @param ltcode    储位编码 (LOC_NAME)
     * @param type      操作类型
     * @param sysUserId 系统用户ID (可传空串)
     * @return WcfCheckLocationResult 包含 success, message, locationId
     */
    public WcfCheckLocationResult checkLocation(String ltcode, String type, String sysUserId) {
        String soapBody =
                "<tem:CheckLocation>" +
                "  <tem:ltcode>" + escapeXml(ltcode) + "</tem:ltcode>" +
                "  <tem:type>" + escapeXml(type) + "</tem:type>" +
                "  <tem:sys_user_id>" + escapeXml(sysUserId) + "</tem:sys_user_id>" +
                "</tem:CheckLocation>";

        String response = callSoap("CheckLocation", soapBody);
        boolean success = extractBooleanTag(response, "CheckLocationResult");
        String message = extractStringTag(response, "message");
        String locationId = extractStringTag(response, "locaionid"); // 注意: WSDL里就是 locaionid (拼写如此)

        logger.info("[WCF] CheckLocation: ltcode={}, success={}, locationId={}, msg={}",
                ltcode, success, locationId, message);
        return new WcfCheckLocationResult(success, message, locationId);
    }

    // ===================== SOAP 底层调用 =====================

    /**
     * 构建 SOAP 1.1 信封并发送 HTTP POST 请求
     */
    private String callSoap(String action, String soapBody) {
        String envelope =
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"" +
                " xmlns:tem=\"" + SOAP_NS + "\">" +
                "  <s:Body>" +
                "    " + soapBody +
                "  </s:Body>" +
                "</s:Envelope>";

        HttpHeaders headers = new HttpHeaders();
        // 必须指定 charset=utf-8，否则 Spring 默认 ISO-8859-1 导致中文参数乱码
        headers.setContentType(new MediaType("text", "xml", StandardCharsets.UTF_8));
        headers.set("SOAPAction", "\"" + SOAP_ACTION_PREFIX + action + "\"");

        HttpEntity<String> request = new HttpEntity<>(envelope, headers);

        logger.info("[WCF] SOAP请求: action={}, url={}", action, wcfUrl);
        // 打印完整信封便于排查（含参数值）
        logger.info("[WCF] SOAP信封: {}", envelope);

        try {
            String response = wcfRestTemplate.postForObject(wcfUrl, request, String.class);
            // 打印完整响应便于排查
            logger.info("[WCF] SOAP响应: action={}, response={}", action, response);
            return response != null ? response : "";
        } catch (Exception e) {
            logger.error("[WCF] SOAP调用失败: action={}, url={}, 请求信封={}", action, wcfUrl, envelope);
            logger.error("[WCF] SOAP异常详情:", e);
            throw new RuntimeException("WCF服务调用失败 [" + action + "]: " + e.getMessage(), e);
        }
    }

    // ===================== XML 解析辅助 =====================

    /**
     * 从 SOAP 响应中提取指定标签的 boolean 值
     * 支持带命名空间前缀的标签，如 <a:PassLocationResult>true</a:PassLocationResult>
     */
    private boolean extractBooleanTag(String xml, String tagName) {
        String value = extractStringTag(xml, tagName);
        return "true".equalsIgnoreCase(value);
    }

    /**
     * 从 SOAP 响应中提取指定标签的文本内容
     * 兼容无前缀和带前缀的标签: <message> 或 <a:message>
     */
    private String extractStringTag(String xml, String tagName) {
        if (xml == null || xml.isEmpty()) return "";

        // 匹配 <tagName> 或 <prefix:tagName>，支持带属性
        Pattern pattern = Pattern.compile(
                "<(?:[a-zA-Z0-9]+:)?" + Pattern.quote(tagName) + "(?:\\s[^>]*)?>([^<]*)</(?:[a-zA-Z0-9]+:)?" + Pattern.quote(tagName) + ">",
                Pattern.DOTALL);
        Matcher matcher = pattern.matcher(xml);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }

        // 检查是否是 nil 标签 <tagName i:nil="true"/>
        Pattern nilPattern = Pattern.compile(
                "<(?:[a-zA-Z0-9]+:)?" + Pattern.quote(tagName) + "\\s[^>]*nil=\"true\"\\s*/?>",
                Pattern.DOTALL);
        if (nilPattern.matcher(xml).find()) {
            return "";
        }

        return "";
    }

    /**
     * XML 特殊字符转义
     */
    private String escapeXml(String value) {
        if (value == null) return "";
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    // ===================== 结果类 =====================

    /**
     * WCF 调用结果（通用: PassLocation / UpnTransfer4Location）
     */
    public static class WcfResult {
        public final boolean success;
        public final String message;

        public WcfResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        @Override
        public String toString() {
            return "WcfResult{success=" + success + ", message='" + message + "'}";
        }
    }

    /**
     * WCF CheckLocation 调用结果（多一个 locationId 返回值）
     */
    public static class WcfCheckLocationResult {
        public final boolean success;
        public final String message;
        public final String locationId;

        public WcfCheckLocationResult(boolean success, String message, String locationId) {
            this.success = success;
            this.message = message;
            this.locationId = locationId;
        }

        @Override
        public String toString() {
            return "WcfCheckLocationResult{success=" + success + ", message='" + message + "', locationId='" + locationId + "'}";
        }
    }

    public static class WcfSmtDirectReturnPreviewResult {
        public final boolean success;
        public final boolean needConfirm;
        public final BigDecimal remainingQty;
        public final String message;

        public WcfSmtDirectReturnPreviewResult(boolean success, boolean needConfirm,
                                               BigDecimal remainingQty, String message) {
            this.success = success;
            this.needConfirm = needConfirm;
            this.remainingQty = remainingQty;
            this.message = message;
        }
    }
}
