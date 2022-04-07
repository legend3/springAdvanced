package com.legend.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

//监听器
//@Component    //为了演示2暂时注掉
public class MyListener implements ApplicationListener {
    //方式一(实现接口)：监听对象
    @Override
    public void onApplicationEvent(ApplicationEvent event) {//ctrl+alt+b查看ApplicationEvent的实现事件(能监听的事件)
        System.out.println("========**********========"+event+"======*********==========");
    }
}
