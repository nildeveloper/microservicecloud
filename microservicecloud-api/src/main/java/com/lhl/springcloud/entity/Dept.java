package com.lhl.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created with IntellJ IDEA.
 * User: lhl
 * Date: 2019-01-07
 * Time: 15:18
 * Description:
 */
//@AllArgsConstructor  // 全参构造函数
@NoArgsConstructor  // 空参构造函数
@Data  // getter and setter
@Accessors(chain = true)  // 链式调用
public class Dept implements Serializable {  // 必须序列化

    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source; // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname) {
        this.dname = dname;
    }
}
