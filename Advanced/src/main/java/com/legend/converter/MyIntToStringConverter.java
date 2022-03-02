package com.legend.converter;


import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * JAVA规范：生命周期演示
 * 功能性的bean！
 */
@Component(value="myConverter")//功能性注解属于三层注解！   @Bean + 返回值
public class MyIntToStringConverter {

    @PostConstruct//相当于init()
    public void init(){//方法名自定义
        System.out.println("转换..Init...");
    }
    public void myConverter(){
        System.out.println("转换.......");
    }

    @PreDestroy//相当于destroy()
    public void destroy(){//方法名自定义
        System.out.println("转换..destroy...");
    }
}
