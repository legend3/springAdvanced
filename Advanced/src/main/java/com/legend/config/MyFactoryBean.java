package com.legend.config;

import com.legend.entity.Apple;
import org.springframework.beans.factory.FactoryBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Apple();//容器中需要放入一个Apple Bean
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;//类型是Apple类型
    }

    @Override
    public boolean isSingleton() {
        return true;//单例模式的
    }

    @PostConstruct
    public void init() {
        System.out.println("MyFactoryBean的容器初始化方法....");
    }

    @PreDestroy//相当于destroy()
    public void destroy(){//方法名自定义
        System.out.println("MyFactoryBean的容器销毁方法....");
    }
}
