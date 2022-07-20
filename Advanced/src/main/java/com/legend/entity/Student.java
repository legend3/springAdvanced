package com.legend.entity;


public class Student {
    //简单类型：  8个基本类型+String
    private int stuNo ;
    private String stuName ;
    private int stuAge;
    private Address address ;

    public Student() {
        System.out.println("student 无参构造");
    }

    public Student(int stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
        System.out.println("student 有参构造");
    }

    //P4 容器初始化bean(自定义方法)
    public void myInit(){
        stuName = "初始化zs";//可以在容器初始化时就完成赋值
        System.out.println("初始化方法myInit...");
    }
    //容器关闭方法
    public void myDestroy(){
        System.out.println("destroy...");
    }

    public int getStuNo() {
        return stuNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", address=" + address +
                '}';
    }
}
