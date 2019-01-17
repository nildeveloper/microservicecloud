package com.lhl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-08
 * Time: 15:37
 * Description:  在启动类上标注新组件技术的 Enable 标签
 * Eureka 启动类， 接受其他微服务注册进来
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001_App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class, args);
    }
    
}
