package com.legend.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 前言: spring自带的ApplicationEvent及其子类/子接口类型事件有限
 * P8 自定义监听器事件(ApplicationEvent的子)
 */
public class MyEvent extends ApplicationEvent {//1.继承ApplicationEvent后，MyEvent3就是一个"被监听的事件"(它里面发生了什么都是事件中的过程)
    public MyEvent(Object source) {//2.事件的名字
        super(source);
//        System.out.println("MyEvent3被监听事件: " + source);
    }
}
