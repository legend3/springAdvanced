package com.legend.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        "com.legend.entity.Orange"
//        BeanDefinition beanDefinition =  new RootBeanDefinition(Orange.class) ;
        BeanDefinition beanDefinition =  new RootBeanDefinition("com.legend.entity.Orange") ;
        //将RootBeanDefinitionbean转换成beanDefinition的类Orange.class/com.legend.entity.Orange注册入BeanDefinitionRegistry("bean定义注册",即容器中)中
        registry.registerBeanDefinition("myOrange",  beanDefinition); // id ,class

    }
}
