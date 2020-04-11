import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-04 15:16
 **/
public class JobAppTest {

    public static void main(String[] args) {
        ApplicationContext cs = new ClassPathXmlApplicationContext("applicationContext-quartz.xml");

    }
}
