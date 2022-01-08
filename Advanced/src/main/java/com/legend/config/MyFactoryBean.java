package com.legend.config;

import com.legend.entity.Apple;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Apple();
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;  //Apple
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
