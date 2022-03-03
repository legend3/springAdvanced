package com.legend.converter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * P7-1
 * BeanFactoryPostProcessor拦截的对象是容器，(获取到了容器也就可以获取bean)
 */
@Component
public class MyYYY implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        beanFactory.getBeanDefinition("id");//根据bean的名字(id)获取bean
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("【b】&&&&&&&&&&&&&&容器中bean的个数："+count);
        String[] names = beanFactory.getBeanDefinitionNames();//name->id <bean id ="">
        System.out.println("【b】&&&&&&&&&&&&&&容器中所有bean的名字：" + Arrays.asList(names));


    }
}
