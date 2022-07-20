package com.legend.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 定义一个监听器，去监听"被监听事件"
 */
@Component
public class MyListener2 {
    //方式二（注解方式）：本方法是一个 监听方法
    @EventListener(classes = {MyEvent.class})//可以是任何类型(被监听)，此处仅仅监听ApplicationEvent及它的子类
    public void myListenerMethod(ApplicationEvent event){
        System.out.println("--监听事件(方式二)---" + event);
    }
}
