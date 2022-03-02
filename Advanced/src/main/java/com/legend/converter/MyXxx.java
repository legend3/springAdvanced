package com.legend.converter;

import com.legend.entity.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;

/**
 * BeanPostProcessor拦截的是所有的(容器中)bean，也就是在bean实例化之后完成
 * 顺序:      容器创建bean(构造方法)     postProcessBeforeInitialization初始化各bean     容器初始化bean
 */
@Controller //(4个(三层组件))
public class MyXxx implements BeanPostProcessor {

    //拦截器
    @Override//bean:Student(zs)
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("初始化:"+beanName+":"+bean);

        if(bean instanceof Student){//如果拦截到Student实例
            System.out.println("MyXxx...初始化..");
            Student stu = (Student)bean ;
            stu.setStuName("zs123456");//偷梁换柱(传入的zs，换成ls名字)修改Student bean的属性值
            stu.setStuNo(123);
            return stu;//如果是Student bean,返回修改后的bean
        }
        return bean;//其他bean
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Student) {
            System.out.println("销毁:" + beanName + ":" + bean);
            System.out.println("MyXxx...销毁..");
        }
//        System.out.println("销毁:"+beanName+":"+bean);
            return bean;
    }
}
