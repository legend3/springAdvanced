package com.legend.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /**
         * RootBeanDefinitionbean将Orange.class/"com.legend.entity.Orange"类型定义bean
         */
        BeanDefinition beanDefinition = new RootBeanDefinition("com.legend.entity.Orange");//指定bean的类型
        beanDefinition.setScope("singleton");//设置作用域
        beanDefinition.setLazyInit(true);//懒加载
        beanDefinition.setInitMethodName("OrangeBeanInit");//初始化方法
        beanDefinition.setDestroyMethodName("OrangeBeanInitDestroy");//销毁方法
        // 注册入BeanDefinitionRegistry("bean定义注册",即容器中)中
        registry.registerBeanDefinition("myOrange",  beanDefinition);//id, class;设置bean的id标识名

    }
}
