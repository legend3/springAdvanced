package com.legend.converter;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * P4（三层组件bean）Bean的生命周期方式三
 */
@Component(value = "myFunction")//@Bean + 返回值
//@Lazy
public class MyFunction implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyFunction初始化...afterPropertiesSet");
    }

    //拿到bean后调用的方法(功能)
    public void myMethod(){
        System.out.println("myMethod方法....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyFunction销毁...destroy");
    }
}
