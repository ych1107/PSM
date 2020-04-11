import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-04 15:34
 **/
public class EmailAppTest {
    @Test
    public void test() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-email.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);
        MimeMessage message = bean.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("15294818079@163.com");
        helper.setTo("780278667@qq.com");
        helper.setSubject("你好");
        helper.setText("这是测试的邮箱功能");
        bean.send(message);
        System.out.println("发送成功");
    }
}
