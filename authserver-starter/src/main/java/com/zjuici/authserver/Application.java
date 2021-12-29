package com.zjuici.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @author fuzeqiang
 * @projectName ddd-template
 * @title: Application
 * @date 2021/12/29 14:01
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //启动springboot应用，并记录进程ID
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

}
