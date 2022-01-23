package com.legend.converter;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class MyFunction implements InitializingBean , DisposableBean {

        public void myMethod(){

        }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyFunction初始化...afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyFunction销毁。。。destroy");
    }
}
