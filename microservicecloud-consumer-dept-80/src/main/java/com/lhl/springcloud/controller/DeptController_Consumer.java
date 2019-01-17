package com.lhl.springcloud.controller;

import com.lhl.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-07
 * Time: 16:47
 * Description: 消费端， 需要通过 restTemplate 调用 服务提供端接口
 * 常用 restTemplate 访问 restful 接口非常加单，（url, requestMap, responseBean.class）
 */
@RestController
public class DeptController_Consumer {

    // 写死的地址 + 端口 + ip
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    
    // 通过微服务名称从Eureka 中获取服务提供端
    // Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }
    
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
 