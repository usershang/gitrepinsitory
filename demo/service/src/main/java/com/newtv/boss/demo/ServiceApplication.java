package com.newtv.boss.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by gbk on 2017/8/28.
 */
@SpringBootApplication(scanBasePackages={"com.newtv.boss.demo.*"})
@MapperScan({"com.newtv.boss.demo.core.dao.mapper"})
@EnableEurekaClient
public class ServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceApplication.class);
    }

    public static void main(String[] args) {
        new ServiceApplication()
                .configure(new SpringApplicationBuilder(ServiceApplication.class))
                .run(args);
    }
}
