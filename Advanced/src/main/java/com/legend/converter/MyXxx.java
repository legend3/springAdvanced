package com.legend.converter;

import com.legend.entity.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;

/**
 * BeanPostProcessor拦截的是所有的(容器中)bean，也就是在bean实例化之后完成
 */
@Controller //(4个)
public class MyXxx implements BeanPostProcessor {

    //拦截器
    @Override//bean:Student(zs)
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("初始化:"+beanName+":"+bean);
//        bean.setName("ls")//偷梁换柱(传入的zs，换成ls名字)

        if(bean instanceof Student){//只拦截出Student
            System.out.println("MyXxx...初始化..");
            Student stu = (Student)bean ;
            stu.setStuName("zs123456");//修改Student bean的属性值
            stu.setStuNo(123);
            return stu ;
        }

        return bean;
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
