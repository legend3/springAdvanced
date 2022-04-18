package com.legend.converter;

import com.legend.entity.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;
/**
 * P4-生命周期，方法四：适用于三层组件("获取bean、操作bean")
 *
 * BeanPostProcessor拦截的是所有的(容器中)bean，也就是在bean实例化之后完成
 * 顺序:  容器创建bean    postProcessBeforeInitialization拦截实例化的各bean
 *
 * 声明，指生成对象不赋值的过程。
 * 初始化，是给对象赋值的过程。
 * 实例化，是使用new为对象分配内存的过程。
 */
@Controller //(4个(三层组件))
public class MyXxx implements BeanPostProcessor {
    //拦截器
    @Override//bean:Student(zs)
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化: "+beanName+": "+bean);
        if(bean instanceof Student){//如果拦截到Student实例
            System.out.println("MyXxx拦截器初始化...");
            Student stu = (Student)bean;
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
