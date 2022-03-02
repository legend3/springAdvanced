package com.legend.config;

import com.legend.entity.Apple;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Apple();//容器中需要放入一个Apple Bean
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;  //类型是Apple类型
    }

    @Override
    public boolean isSingleton() {
        return true;//单例模式的
    }
}
