package com.lhl.springcloud.controller;

import com.lhl.springcloud.entity.Dept;
import com.lhl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-07
 * Time: 16:47
 * Description: 消费端， Feign 面向接口编程，Spring 自动注入DeptClientService 对象，优雅简单的进行服务调用
 * 无需在使用RestTemplate + Ribbon负载均衡进行调用
 * Feign 集成 Ribbon， 默认LB算法为 轮询算法
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept) {
        return this.service.add(dept);
    }

}
 