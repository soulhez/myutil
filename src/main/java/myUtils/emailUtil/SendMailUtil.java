package myUtils.emailUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 邮件发送工具类
 * 
 * @author tzx
 * @date 2018年1月29日
 */
@Component
public class SendMailUtil {
	/**
	 * 发送方邮箱
	 */
	@Value("${sendEmailAdd}")
	private String sendEmailAdd;
	/**
	 * 发送方邮箱用户名
	 */
	@Value("${emailName}")
	private String emailName;
	/**
	 * 发送方邮箱密码（客户端授权码，非登录密码）
	 */
	@Value("${emailPwd}")
	private String emailPwd;
	/**
	 * 接收方邮箱
	 */
	@Value("${reciveEmailAdd}")
	private String reciveEmailAdd;
	/**
	 * 邮箱类型
	 */
	@Value("${eamilType}")
	private String eamilType;
	/**
	 * 是否开启认证
	 */
	@Value("${eamilAuthType}")
	private String eamilAuthType;

	public boolean sendEmail(String subject, String emailContent, List<String> fileNameList) {
		Properties pro = new Properties();
		// 设置客户端类型
		pro.put("mail.smtp.host", eamilType);
		pro.put("mail.smtp.auth", eamilAuthType);
		// Properties pro = mailConfig.getProperties();
		// 根据邮件的会话属性构造一个发送邮件的Session
		MailAuthenticator authenticator = new MailAuthenticator(emailName, emailPwd);
		Session session = Session.getInstance(pro, authenticator);
		// 监控邮件命令
		try {
			// 根据Session 构建邮件信息
			Message message = new MimeMessage(session);
			// 创建邮件发送者地址
			Address from = new InternetAddress(sendEmailAdd);
			// 设置邮件消息的发送者
			message.setFrom(from);
			// 验证邮箱地址
			List<String> auth = new ArrayList<String>();
			auth.add(reciveEmailAdd);
			String toAddress = validateEmail(auth);
			if (!toAddress.isEmpty()) {
				// 创建邮件的接收者地址
				Address[] to = InternetAddress.parse(toAddress);
				// 设置邮件接收人地址
				message.setRecipients(Message.RecipientType.TO, to);
				message.setSubject(subject);
				// 邮件容器
				MimeMultipart mimeMultiPart = new MimeMultipart();
				// 设置HTML
				BodyPart bodyPart = new MimeBodyPart();
				bodyPart.setContent(emailContent, "text/html;charset=utf-8");
				mimeMultiPart.addBodyPart(bodyPart);
				if (fileNameList != null) {
					BodyPart attchPart = null;
					for (int i = 0; i < fileNameList.size(); i++) {
						if (!fileNameList.get(i).isEmpty()) {
							attchPart = new MimeBodyPart();
							// 附件数据源
							DataSource source = new FileDataSource(fileNameList.get(i));
							// 将附件数据源添加到邮件体
							attchPart.setDataHandler(new DataHandler(source));
							// 设置附件名称为原文件名
							attchPart.setFileName(MimeUtility.encodeText(source.getName()));
							mimeMultiPart.addBodyPart(attchPart);
						}
					}
				}
				message.setContent(mimeMultiPart);
				message.setSentDate(new Date());
				// 保存邮件
				message.saveChanges();
				// 发送邮件
				Transport.send(message);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("邮件发送失败");
		}
		return false;
	}

	/**
	 * 校验邮箱格式
	 * 
	 * @param emailList
	 * @return
	 */
	public String validateEmail(List<String> emailList) {
		StringBuffer buffer = new StringBuffer();
		if (!emailList.isEmpty()) {
			String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern p = Pattern.compile(regEx);
			for (int i = 0; i < emailList.size(); i++) {
				Matcher match = p.matcher(emailList.get(i));
				if (match.matches()) {
					buffer.append(emailList.get(i));
					if (i < emailList.size() - 1) {
						buffer.append(",");
					}
				}
			}
		}
		return buffer.toString();
	}
}
