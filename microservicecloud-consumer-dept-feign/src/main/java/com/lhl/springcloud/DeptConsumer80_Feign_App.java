package com.lhl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-07
 * Time: 16:56
 * Description:
 */
@EnableFeignClients(basePackages= {"com.lhl.springcloud"})
@EnableEurekaClient  // 整合Eureka
@SpringBootApplication
public class DeptConsumer80_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
