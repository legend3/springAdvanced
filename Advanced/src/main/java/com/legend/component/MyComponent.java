package com.legend.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("myComponent99999")  //id  name
public class MyComponent implements ApplicationContextAware , BeanNameAware {
        private ApplicationContext applicationContext;//容器
        private String beanName ;//设置bean的名字
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("000000000000000000000000000000"+applicationContext);
        this.applicationContext= applicationContext ;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("获取当前bean的name: "+name);
        this.beanName = name ;
    }
}
