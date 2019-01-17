package com.lhl.springcloud;

import com.lhl.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-07
 * Time: 16:56
 * Description:
 */
// 启用自定义Ribbon 负载均衡算法   注意：MySelfRule 不能放在主启动类包下面， 所以新建com.lhl.myrule包
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration=MySelfRule.class)  
@EnableEurekaClient  // 整合Eureka
@SpringBootApplication
@EnableDiscoveryClient
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
