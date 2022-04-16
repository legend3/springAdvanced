import com.legend.config.MyConfig;
import com.legend.converter.MyIntToStringConverter;
import com.legend.entity.Student;
import com.legend.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestCases {
    @Test
    public void testXml() {
        //1.创建Spring的IOC容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.纳入IOC容器，配置文件形式 (id为"student"的Student对象)
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
//        Student stu1 =(Student)context.getBean("student");//setXxx()
//        Student stu2 =(Student)context.getBean("student");//setXxx()
//        System.out.println(stu1 ==stu2);//P2判断singleton/prototype测试
//        Student student = (Student) context.getBean("student");
//        System.out.println(student);//验证(Bean)init阶段进行了赋值
//        ((ClassPathXmlApplicationContext) context).close();

    }

    @Test
    public void test01() {
        //注解方式@Bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        Student myStudent = (Student) context.getBean("myStudent");//默认：方法名即为bean的名称
        Student stu = (Student) context.getBean("stu");//@Bean(value="stu")
        System.out.println(stu);
    }

    @Test
    public void test02() {
        /** 注解扫描器 **/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03() {
        /** P2 作用域 */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);//容器初始化，自动触发调用myInit方法
        //上述验证singleton时是否自动产生bean

        //下面部分验证prototype作用域时是否每次新生成对象
//        Student stu1 = context.getBean(Student.class);
//        Student stu2 = context.getBean(Student.class);
//        System.out.println("两次生成bean是否相等: " + (stu1==stu2));
    }

    @Test
    public void test04() {
        /** 条件注解 */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);//容器初始化
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {//遍历所有的bean
            System.out.println("name: " + name);
        }
    }

    @Test
    public void test05() {
        /** P3(先注释掉@Conditional的Bean,不然环境没有设置-Dcar.type=xxx会报错！)import注入方式 */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);//容器初始化
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for(String name :beanDefinitionNames){
//            System.out.println(name);
//        }
        /** (先注释掉@Import的Bean) FactoryBean注入方式 */
        Object obj = context.getBean("F");//Apple
        System.out.println("F: " + obj);

        Object obj2 = context.getBean("&F");//MyFactoryBean
        System.out.println("&F: " + obj2);
    }

    @Test
    public void test06() {
        /*P4 Bean的生命周期，xml方式*/
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = (Student) context.getBean("student");
//        System.out.println(student);//验证(Bean)init阶段进行了赋值
//        ((ClassPathXmlApplicationContext) context).close();

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        /*Bean的生命周期，注解方式*/
//        Student student2 = (Student) context.getBean("stu");
//        System.out.println(student2);

        /*Bean的生命周期，JAVA规范方式*/
        MyIntToStringConverter converter = (MyIntToStringConverter)context.getBean("myConverter");
        converter.myConverter();

        /*实现两个接口*/
//        MyFunction myFunction = (MyFunction) context.getBean("myFunction");
//        myFunction.myMethod();

        /**/
        ((AnnotationConfigApplicationContext) context).close();
    }

    @Test
    public void test07() {
        /*P5 三层注解的@Autowired*/
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        StudentDao studentDao = (StudentDao) context.getBean("stuDao");//StudentDao为类时
//        System.out.println(studentDao);//检测扫描三层组件

        StudentService stuService = (StudentService) context.getBean("stuService");
        System.out.println("stuServicez注入: " + stuService.getStudentDao());
        System.out.println("*******8*8*8******" + stuService.getStudentDao());

        //bean+返回值的@Autowired
        Student stu = (Student) context.getBean("stu");
        System.out.println("student注入" + stu);
    }

    @Test
    public void test08() {
        //P6实现调用spring底层组件
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println(context + "——9999999999999999999");
    }

    @Test
    public void test09() {
        //P6 @Profile切换环境，激活方式一：idea Vm Options
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object apple = context.getBean("apple");
//        Object banana = context.getBean("banana");
        System.out.println("------myApple------" + apple);
//        System.out.println("------myBanana------"+banana);
    }

    @Test
    public void test10() {
        //P6 @Profile切换环境，切换环境激活二：不配置idea Vm Options，而是硬编码方式切换环境
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();//0.不放参数(调的AnnotationConfigApplicationContext无参构造)，使容器不在此保存！
        ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
        environment.setActiveProfiles("myBanana");//1.激活
//        Object banana = context.getBean("banana");//错误
        //保存点
        context.register(MyConfig.class);//2.激活(了环境参数)后保存(入容器)
        context.refresh();//3.刷新(AnnotationConfigApplicationContext的无参构造了，必须使用refresh()手动刷新)
    }

    @Test
    public void test11() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //自定义监听器事件且发布：创建一个事件并且发布，两种实现形式：

        //1.直接匿名实例化ApplicationEvent自定义事件
//        context.publishEvent(new ApplicationEvent("My Event") {
//         });
        //2.创建一个自定义监听类(实现ApplicationEvent接口)
        MyEvent3 evn = new MyEvent3(context);
        context.publishEvent(evn);//发布

        ((AnnotationConfigApplicationContext) context).close();
    }
}
