package com.newtv.boss.demo.core.service;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by gbk on 2017/8/28.
 */
@SpringBootApplication(scanBasePackages={"com.newtv.boss.demo.*"})
@MapperScan({"com.newtv.boss.demo.core.dao.mapper"})
public class TestConfig  {

}
