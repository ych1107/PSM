package com.ujiuye.jobs;

import com.ujiuye.info.bean.Email;
import org.quartz.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @program: PSM
 * @description: 编码格式的定时发送邮件
 * @author: Mr.C
 * @create: 2019-12-04 16:57
 **/
public class JobEmail implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        Email email = (Email) jobDataMap.get("email");
        JavaMailSenderImpl javaMailSender= (JavaMailSenderImpl)jobDataMap.get("JavaMailSenderImpl");
        MultipartFile file =(MultipartFile)jobDataMap.get("file");
        String emailAddress = (String)jobDataMap.get("emailAddress");
        String fileAddress = (String) jobDataMap.get("fileAddress");
        Scheduler sche =(Scheduler) jobDataMap.get("sche");
        try {
        //得到邮件对象
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            //发送人邮箱，和容器中保持一致
            helper.setFrom("780278667@qq.com");
            helper.setTo(emailAddress);
            helper.setSubject(email.getTitle());
            helper.setText(email.getContent());
            FileSystemResource resource = new FileSystemResource(new File(fileAddress));
            helper.addAttachment(file.getOriginalFilename(), resource);
            javaMailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                if (!sche.isShutdown()){
                     sche.shutdown();
                  }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
