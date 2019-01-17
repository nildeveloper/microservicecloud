package com.lhl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-11
 * Time: 15:36
 * Description:  自定义 Ribbon 负载均衡算法
 */
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
//        return new RandomRule();  //Ribbon默认是轮询，我自定义为随机
        return new RandomRule_LHL();  // 使用自定义Ribbon 负载均衡算法， 每个微服务被调用5次后再轮询
    }
}
 