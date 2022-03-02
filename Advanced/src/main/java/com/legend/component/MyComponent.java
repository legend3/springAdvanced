package com.legend.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*P6 利用Spring底层组件进行开发*/
@Component("myComponent99999")  //id  name
public class MyComponent implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;
    private String beanName;

    /**
     * ——ApplicationContextAware接口的作用：
     *
     * 容器会自动把applicationContext参数传入实现方法中，
     * 再通过实现方法把applicationContext传给成员变量applicationContext()，
     * 以后就能当作一个类的属性来使用“容器”。
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("000000000000000000000000000000——"+applicationContext);
        this.applicationContext= applicationContext;//main()方法之前，通过setApplicationContext()方法将Ioc容器供我们使用；用完后才main()中new出容器！
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("获取当前bean的name: "+name);
        this.beanName = name;
    }
}
