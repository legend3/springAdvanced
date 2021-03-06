package com.legend.config;

import com.legend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/** 配置类 */
@Configuration

/**
 * P3
 * 非三层组件(2)@Import——test05
 * https://www.bbsmax.com/A/QV5ZPWwyzy/
 */
// @Import({Apple.class, Banana.class})//第一种方式: 直接编写到@Import中
// @Import({Orange.class, MyImportSelector.class})//第二种方式：自定义ImportSelector接口的实现类
 @Import({MyImportBeanDefinitionRegistrar.class})//第三种方式：编写ImportBeanDefinitionRegistrar接口的实现类

/**
 * P1
 * 三层组件
 */
//@ComponentScan(value="com.legend", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes ={Controller.class})})
//@ComponentScan(value="com.legend", excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes ={StudentDao.class})})
//@ComponentScan(value="com.legend", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes ={Controller.class})}, useDefaultFilters = false)
//@ComponentScan(value="com.legend", includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyFilter.class})}, useDefaultFilters = false)//自定义扫描器MyFilter.class
@ComponentScan(value= "com.legend")//三层的注解形式的扫描器
public class MyConfig {
        /*
        相当于xml文件中配置：
            <bean id="myaddress" class="com.legend.entity.Address">
                  <property name="homeAddrss" value="xa"></property>
                  <property name="schoolAddrss" value="bj"></property>
            </bean>
        */
/**
 * P1
 * 非三层组件(1)@Bean——test01
 */
//  @Bean //bean的id默认就是方法名：myStudent
//  @Bean(value="stu")//id="stu" class="...Student"

    /**
     * P2
     * Bean的作用域
     */
//   @Scope("prototype")
//   @Scope("singleton")
//   @Lazy

   /**
    * P4-Bean的生命周期
    */
   @Bean(value="stu", initMethod = "myInit", destroyMethod = "myDestroy")//id="stu" class="...Student"//测试生命周期方法4,MyXxx类
   //(一)方法前
   @Autowired
   @Qualifier("address2")
    public Student myStudent(@Autowired @Qualifier("address2") Address address) {//(二)支持 方法参数中 注入: address=Address{homeAddrss='xa02', schoolAddrss='bj02'}；@Qualifier按照名字
        Student student = new Student(10,"zs10",23);
//        Address address = new Address("xa02","bj02"); //手动方式注入
        System.out.println("——address:" + address);//
        student.setAddress(address);//stu才是bean(不是Student)
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
        return address;
    }

    /**
     * 条件注解——test04
     */
//    @Bean
//    @Conditional(OilCarCondition.class)//OilCarCondition.class定义了满足的条件(-Dcar.type=oil)，方能注册oilCarBean
//    public Car oilCar()
//    {
//        return new OilCar();
//    }
//
//    @Bean
//    @Conditional(EnergyCarCondition.class)//EnergyCarCondition.class定义了满足的条件(-Dcar.type=energy)，方能注册energyCarBean
//    public Car energyCar()
//    {
//        return new EnergyCar();
//    }

    /**
     * 非三层组件(3)工厂Bean——test01
     */
//    @Bean(value = "F")
//    public FactoryBean<Apple> myFactoryBean() {
//       return new MyFactoryBean();//到底是什么？MyFactoryBean 、Apple？
//    }

    /*P6 环境切换*/
    @Profile("myApple")//一种环境
    @Bean("apple")
    public Fruit apple(){
       return new Apple();
    }

    @Profile("myBanana")//另一种环境
    @Bean("banana")
    public Fruit banana() {
        return new Banana();
    }
}
