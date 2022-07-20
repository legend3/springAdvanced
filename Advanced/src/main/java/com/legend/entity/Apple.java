package com.legend.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Apple extends Fruit {
    @PostConstruct
    public void init() {
        System.out.println("Apple的容器初始化方法....");
    }
    @PreDestroy
    public void destroy(){//方法名自定义
        System.out.println("Apple的容器销毁方法....");
    }
}
