package com.legend.config;

import com.legend.entity.*;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//配置类
@Configuration
/** 非三层组件(2) */
// @Import({Apple.class, Banana.class})//第一种方式
// @Import({Orange.class, MyImportSelector.class})//第二种方式
// @Import({MyImportBeanDefinitionRegistrar.class})//第三种方式

/** 三层组件 */
//@ComponentScan(value="com.legend", excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes ={Controller.class})})
//@ComponentScan(value="com.legend", excludeFilters = {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes ={StudentDao.class})})
//@ComponentScan(value="com.legend", includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes ={Controller.class})}, useDefaultFilters = false)
//@ComponentScan(value="com.legend", includeFilters = {@ComponentScan.Filter(type= FilterType.CUSTOM, classes ={ MyFilter.class})}, useDefaultFilters = false)//自定义扫描器MyFilter.class
@ComponentScan(value= "com.legend")
public class MyConfig {
        /*
        相当于xml文件中配置：
            <bean id="myaddress" class="com.legend.entity.Address">
                  <property name="homeAddrss" value="xa"></property>
                  <property name="schoolAddrss" value="bj"></property>
            </bean>
        */
/** 非三层组件(1) */
//  @Bean //bean的id默认就是方法名：myStudent
   @Bean(value="stu")//id="stu" class="...Student"//测试生命周期方法4,MyXxx类
//   @Bean(value="stu",initMethod = "myInit",destroyMethod = "myDestroy")  //id="stu" class="...Student"
//   @Scope("prototype")

//   @Scope("singleton")
//   @Lazy

//   @Autowired//（一）
    public Student myStudent(@Autowired @Qualifier("address2") Address address) {//（二）支持方法参数中注入：address=Address{homeAddrss='xa02', schoolAddrss='bj02'}；@Qualifier按照名字
        Student student = new Student(10,"zs10",23);
//        Address address = new Address("xa02","bj02");//手动方式注入
        System.out.println("——address:"+address);
        student.setAddress(address);
        return student;
    }
    @Bean
    public Address address1() {
        Address address = new Address("xa01","bj01");
        return address;
    }

    @Bean
    public Address address2(){
        Address address = new Address("xa02","bj02");
        return address ;
    }
//
//    @Bean
//    @Conditional(OilCarCondition.class)//OilCarCondition.class定义了满足的条件，方能注册oilCarBean
//    public Car oilCar()
//    {
//        return new OilCar() ;
//    }
//
//    @Bean
//    @Conditional(EnergyCarCondition.class)//EnergyCarCondition.class定义了满足的条件，方能注册energyCarBean
//    public Car energyCar()
//    {
//        return new EnergyCar() ;
//    }
/** 非三层组件(3) */
    @Bean(value = "F")
    public FactoryBean<Apple> myFactoryBean() {
       return new MyFactoryBean();//到底是什么？MyFactoryBean 、Apple ？
    }

    /*P6 环境切换*/
    @Profile("myApple")//一种环境
    @Bean("apple")
    public Fruit apple(){
       return new Apple() ;
    }

    @Profile("myBanana")//另一种环境
    @Bean("banana")
    public Fruit banana() {
        return new Banana() ;
    }
}
