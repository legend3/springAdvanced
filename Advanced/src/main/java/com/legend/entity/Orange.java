package com.legend.entity;

public class Orange {
    //自定义容器初始化时自动执行的方法
    public void OrangeBeanInit(){
        System.out.println("OrangeBean初始化时自动执行的方法OrangeBeanInit...");
    }
    //自定义容器关闭前自动执行的方法
    public void OrangeBeanInitDestroy(){
        System.out.println("OrangeBean销毁前自动执行方法OrangeBeanInitDestroy...");
    }
}
