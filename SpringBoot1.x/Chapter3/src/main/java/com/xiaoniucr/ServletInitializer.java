package com.xiaoniucr;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 使用外部tomcat容器部署项目
 * @author Mr.Yang
 * @create 2019/07/21 17:52
 * @copyright www.xiaoniucr.com
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Chapter3Application.class);
    }
}
