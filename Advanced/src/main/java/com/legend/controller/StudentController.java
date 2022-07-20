package com.legend.controller;

import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//id="studentController" class=""
@Controller()
public class StudentController  {//Servlet
    @PostConstruct
    public void init() {
        System.out.println("StudentController的容器初始化方法....");
    }
    @PreDestroy
    public void destroy(){//方法名自定义
        System.out.println("StudentController的容器销毁方法....");
    }
}
