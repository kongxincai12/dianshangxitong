//package com.jcd.Tools;
//
//
//import com.jcd.model.EmailModel;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//@Component
//public class MailSendUtils {
//
//    private static final Logger logger = LoggerFactory.getLogger(MailSendUtils.class);//定义logger，打印日志用的。
//
//    /**
//     * 发送者地址
//     **/
//    private static String posterAdress = "itapp@jcdfpc.com";
//
//    /**
//     * 发送者姓名
//     **/
//    private static final String posterName = "LDMS";
//
//    @Resource
//    private JavaMailSender javaMailSender;
//
//    @Resource
//    private JavaMailSenderImpl javaMailSenderImpl;
//
//    public void test(String user,String to,String Subject,String Content){
//        SimpleMailMessage message=new SimpleMailMessage();
//        message.setFrom(user);
//        message.setTo(to);
//        message.setSubject(Subject);
//        message.setText(Content);
//        javaMailSender.send(message);
//    }
//    public void sendattentment(){
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
////邮件发送者
//            helper.setFrom("itapp@jcdfpc.com");
////邮件接收者(可以有多个)
//            helper.setTo("laijiasheng@jcdfpc.com");
//            helper.setSubject("主题：有附件");
//            helper.setText("有附件的邮件");
//            FileSystemResource file = new FileSystemResource(new File("E:\\WebProject\\LDMS\\LDMS_Mail\\src\\main\\resources\\weixin.jpg"));
//            helper.addAttachment("附件-1.jpg", file);
//            helper.addAttachment("附件-2.jpg", file);
//            javaMailSender.send(mimeMessage);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//    /**
//     * 文本发送
//     **/
//    public  void sendEmailAsText(final EmailModel emailModel) {
//        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
//            mimeMessage.setFrom(posterAdress);
//            mimeMessage.setRecipients(Message.RecipientType.TO, emailModel.getRecieverEmailAddress());
//            mimeMessage.setText("<html><body>"
//                    + "hello：" + emailModel.getRecieverName()
//                    + "<br>" + "msg：" + emailModel.getEmailContent()
//                    + "<br>" + "from :" + posterName
//                    + "</body></html>");
//        };
//        try {
//            this.javaMailSender.send(mimeMessagePreparator);
//            logger.info("邮件已返送至[{}]邮箱！", emailModel.getRecieverName());
//        } catch (MailException e) {
//            logger.error("邮箱异常：{}", e);
//        }
//    }
//
//    /**
//     * html 网页发送
//     * 该方法为同步方法
//     **/
//    public void sendEmailAsSysExceptionHtml(final EmailModel emailModel) {//用final关键字修饰的变量，只能进行一次赋值操作，并且在生存期内不可以改变它的值。
//        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper;
//        try {
//            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//            mimeMessageHelper.setFrom(posterAdress);
//            mimeMessageHelper.setTo(emailModel.getRecieverEmailAddress());
//            mimeMessageHelper.setText("<!DOCTYPE html>\n" +
//                            "<html>\n" +
//                            "\t<head>\n" +
//                            "\t\t<meta charset=\"UTF-8\">\n" +
//                            "\t\t<title></title>\n" +
//                            "\t</head>\n" +
//                            "\t<style>\n" +
//                            "\t\tbody,\n" +
//                            "\t\ttable,\n" +
//                            "\t\ttbody,\n" +
//                            "\t\ttr {\n" +
//                            "\t\t\tbackground-color: aquamarine;\n" +
//                            "\t\t\tbackground-size: 100%;\n" +
//                            "\t\t}\n" +
//                            "\t</style>\n" +
//                            "\n" +
//                            "\t<body>\n" +
//                            "\t\t<table border=\"solid 2 px\" align=\"center\" style=\"text-align: center;\">\n" +
//                            "\t\t\t<tbody>\n" +
//                            "\t\t\t\t<tr>\n" +
//                            "\t\t\t\t\t<td width=\"200px\" bgcolor=\"coral\">时间</td>\n" +
//                            "\t\t\t\t\t<td width=\"80%\" bgcolor=\"azure\">" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</td>\n" +
//                            "\t\t\t\t</tr>\n" +
//                            "\t\t\t\t<tr>\n" +
//                            "\t\t\t\t\t<td width=\"200px\" bgcolor=\"coral\">信息</td>\n" +
//                            "\t\t\t\t\t<td width=\"80%\" bgcolor=\"azure\">" + "测试" + "</td>\n" +
//                            "\t\t\t\t</tr>\n" +
//                            "\t\t\t\t<tr>\n" +
//                            "\t\t\t\t\t<td width=\"200px\" bgcolor=\"coral\">堆栈</td>\n" +
//                            "\t\t\t\t\t<td width=\"80%\" bgcolor=\"azure\" style=\"text-align: left;\">" + emailModel.getEmailContent() + "</td>\n" +
//                            "\t\t\t\t</tr>\n" +
//                            "\t\t\t</tbody>\n" +
//                            "\t\t</table>\n" +
//                            "\t</body>\n" +
//                            "\n" +
//                            "</html>"
//                    , true);
//
//            this.javaMailSender.send(mimeMessage);
//            logger.info("邮件已返送至[{}]邮箱！", emailModel.getRecieverEmailAddress());
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        } catch (MailException e) {
//            logger.error("邮箱异常：{}", e);
//        }
//    }
//
//
//    /**
//     * 批量发送邮件
//     */
//
//    public void  setBatchMessages(final EmailModel emailModel) {
//        //String[] strArr = {"laijiasheng@jcdfpc.com"};
//        String sendto = emailModel.getRecieverEmailAddress();
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();// 通过MimeMessage创建一个MimeMessageHelper msgHelper
//        MimeMessageHelper messageHelper;
//        try {
//            messageHelper = new MimeMessageHelper(mimeMessage, true); //使用MimeMessageHelper设置邮件的发送地址、收件地址、主题以及内容
//            messageHelper.setFrom(posterAdress); // 发送的邮件来自哪里
//            messageHelper.setTo(sendto.contains(";")?sendto.split(";"):new String[]{sendto});// 发送的邮件到哪里
//            messageHelper.setSubject(emailModel.getEmailTheme());
//            messageHelper.setText( emailModel.getEmailContent()
//                    , true);
//            this.javaMailSender.send(mimeMessage);
//            logger.info("邮箱已返送至[{}]邮箱！", emailModel.getRecieverEmailAddress());
//            logger.info("现在时间为[{}]", new Date());
//        } catch (Exception e) {
//            logger.error("邮箱异常：{}", e);
//        }
//    }
//}
