package com.library.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 邮件发送工具类
 * 
 * @author Administrator
 *
 */
public class SendEmailUtil {
	private final static String HOST = "smtp.163.com"; // POP3服务器
	private final static String FROM = "账号"; // 发件人
	private final static String PASSWORD = "密码";// 发件人密码

	/**
	 * 不带附件的邮件发送方式
	 * @param to       收件人地址
	 * @param content  邮件内容
	 * @param subject  邮件主题
	 */
	public static void sendEmail(String to, String content, String subject) {
		Properties prop = new Properties();		//实例化Properties类
		prop.put("mail.smtp.host", HOST);		//指定采用SMTP协议的邮件发送服务器的主机名
		prop.put("mail.smtp.auth", "true");			//指定SMTP服务器需要验证
		Session sess = Session.getDefaultInstance(prop);	//根据已经配置的属性创建Session实例
		//sess.setDebug(true);		//设置调试标志
		MimeMessage message = new MimeMessage(sess);	//实例化MimeMessage类
		try {
			message.setFrom(new InternetAddress(FROM));// 给消息对象设置发件人
		    message.setRecipients(Message.RecipientType.TO, to); //设置收件人
		    message.setSubject(subject);	//设置主题
			message.setSentDate(new Date());		//发件时间
			Multipart mul = new MimeMultipart(); // 新建一个MimeMultipart对象来存放多个BodyPart对象
			BodyPart mdp = new MimeBodyPart(); // 新建一个存放信件内容的BodyPart对象
			mdp.setContent(content, "text/html;charset=gbk");
			mul.addBodyPart(mdp); // 将含有信件内容的BodyPart加入到MimeMulitipart对象中
			message.setContent(mul); // 把mul作为消息对象的内容
			message.saveChanges();
			Transport transport = sess.getTransport("smtp");
			// 以smtp方式登录邮箱，第1个参数是发送邮件用的邮件服务器SMTP地址，第2个参数为用户名，第3个参数为密码
			transport.connect(HOST, FROM, PASSWORD);			//建立与邮件服务器的连接
			transport.sendMessage(message, message.getAllRecipients());		//发送邮件
			transport.close();
		} catch (MessagingException e) { 
			System.out.println("发送邮件产生的错误：" + e.getMessage());
			e.printStackTrace();
		}	
	}
}
