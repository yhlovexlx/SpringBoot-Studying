package com.xiaoniucr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter1Application {

    //使用内置tomcat容器启动项目
    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

}
