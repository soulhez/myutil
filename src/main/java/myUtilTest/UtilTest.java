package myutiltest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myutils.emailutil.SendMailUtil;

/**
 * 
 * @author tzx
 * @date 2018年1月31日
 */
public class UtilTest {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		ApplicationContext context = getContext("spring.xml");
		emailTest(context);
	}

	/**
	 * 获取spring上下文
	 * 
	 * @param applicationFile
	 * @return
	 */
	private static ApplicationContext getContext(String applicationFile) {
		return new ClassPathXmlApplicationContext(applicationFile);
	}

	/**
	 * 邮箱工具类测试
	 */
	private static void emailTest(ApplicationContext context) {
		SendMailUtil sendMailUtil = (SendMailUtil) context.getBean("sendMailUtil");
		// 添加主题
		String subject = "邮件工具类测试";
		// 添加正文
		String emailContent = "测试一下邮件发送工具类的功能";
		// 添加附件
		List<String> fileList = new ArrayList<String>();
		fileList.add("C:\\Users\\tzx\\Desktop\\jindu.png");
		sendMailUtil.sendEmail(subject, emailContent, fileList);
	}

}
