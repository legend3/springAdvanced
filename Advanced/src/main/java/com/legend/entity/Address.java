package com.legend.entity;

public class Address {
    private String homeAddrss ;
    private String schoolAddrss ;

    public Address(String homeAddrss, String schoolAddrss) {//有有参构造方法，也可以
        this.homeAddrss = homeAddrss;
        this.schoolAddrss = schoolAddrss;
    }

    public String getHomeAddrss() {
        return homeAddrss;
    }

    public void setHomeAddrss(String homeAddrss) {
        this.homeAddrss = homeAddrss;
    }

    public String getSchoolAddrss() {
        return schoolAddrss;
    }

    public void setSchoolAddrss(String schoolAddrss) {
        this.schoolAddrss = schoolAddrss;
    }

    @Override
    public String toString() {
        return "Address{" +
                "homeAddrss='" + homeAddrss + '\'' +
                ", schoolAddrss='" + schoolAddrss + '\'' +
                '}';
    }
}
