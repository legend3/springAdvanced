package com.legend.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * P6 利用Spring底层组件进行开发
 * Aware的子接口(ApplicationContextAware, BeanNameAware等等....)
 * 中都包含一个set方法(告诉我们该Aware子接口包含了容器的某一个组件(applicationContext,name))，
 * 如果要用这些组件，就能通过set方法传给成员属性，方便我们使用！
 *
 * */
@Component("myComponent99999")  //id  name
public class MyComponent implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;
    private String beanName;
    /**
     * ApplicationContextAware接口的作用：获取容器(AnnotationConfigApplicationContext new之前)，
     * "提前将容器封装入MyComponent类中，操作容器"。
     *
     * 容器会自动把applicationContext参数传入重写方法中，
     * 再通过重写方法把applicationContext传给成员变量applicationContext()，
     * 以后就能当作一个类(MyComponent)的属性来使用“容器”。
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("通过setApplicationContext方法提前获取的容器: " + applicationContext);
        this.applicationContext= applicationContext;//main()方法之前，通过setApplicationContext()方法将Ioc容器供我们使用；用完后才main()中new出容器
    }
    /**
     * BeanNameAware的作用：获取当前bean的名字
     *
     * */
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware获取当前bean的name: " + name);//获取当前bean的name: myComponent99999
        this.beanName = name;
    }
}
