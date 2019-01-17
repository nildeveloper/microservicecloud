package com.lhl.springcloud.service;

import com.lhl.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-16
 * Time: 12:03
 * Description: Feign 需要调用的接口
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")  // 面向 MICROSERVICECLOUD-DEPT 微服务的接口
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)    
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);

}
