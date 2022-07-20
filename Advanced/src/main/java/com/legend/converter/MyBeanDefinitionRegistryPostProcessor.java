package com.legend.converter;

import com.legend.entity.Orange;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * P7-1
 * BeanDefinitionRegistryPostProcessor拦截即将被解析、加载的bean(BeanDefination)
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /** BeanDefinitionRegistryPostProcessor继承自BeanFactoryPostProcessor的方法（bean的工厂），但是执行的时机、阶段不一样！*/
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("【a继承BeanFactoryPostProcessor的方法，后执行】postProcessBeanFactory:容器中注册的bean的数量:" + beanFactory.getBeanDefinitionCount());
        Object myBean = beanFactory.getBean("myBean");//验证：取一下Orange bean
        System.out.println("【a实现的postProcessBeanFactory方法获取的bean: "  + myBean.getClass().getName());
    }
//    ApplicationListener，

    //BeanDefinitionRegistryPostProcessor接口自己的方法  （维护着容器中所有bean的注册信息(registry,容器的bean注册表)）
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("【a自身方法，先执行】postProcessBeanDefinitionRegistry:容器中注册的bean的数量:"+registry.getBeanDefinitionCount());

        /**
         * 意义、作用、时机：
         * 在bean(在容器中)注册之前，就可以额外增加一个：postProcessBeanDefinitionRegistry （可以为容器 额外增加一些bean的注册）
         * */
        // 产生一个BeanDefinition对象(Orange bean在被解析、加载之前的状态)，通过BeanDefinition创建一个Orange的bean
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Orange.class);
//        beanDefinitionBuilder.getBeanDefinition();//AbstractBeanDefinition是beanDefinition的子类

        registry.registerBeanDefinition("myBean", beanDefinitionBuilder.getBeanDefinition());//给Orange bean加上个id值,注册入容器
    }
}
