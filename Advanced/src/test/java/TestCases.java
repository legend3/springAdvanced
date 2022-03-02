import com.legend.config.MyConfig;
import com.legend.entity.Student;
import com.legend.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCases {
    @Test
    public void testXml()
    {
        //1.创建Spring的IOC容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.纳入IOC容器，配置文件形式 (id为"student"的Student对象)
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name :beanDefinitionNames){
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
        for(String name :beanDefinitionNames){
            System.out.println(name);
        }
    }
    @Test
    public void test03() {
        /** P2 作用域 */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);//容器初始化
//        Student stu1 = context.getBean(Student.class) ;
//        Student stu2 = context.getBean(Student.class) ;
//        System.out.println(stu1==stu2);
    }
    @Test
    public void test04() {
        /** 条件注解 */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);//容器初始化
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
    @Test
    public void test05() {
        /** P3(先注释掉@Conditional的Bean)import注入方式 */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);//容器初始化
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for(String name :beanDefinitionNames){
//            System.out.println(name);
//        }
        /** (先注释掉@Import的Bean)FactoryBean注入方式 */
        Object obj = context.getBean("F");//MyFactoryBean
        System.out.println(obj);

        Object obj2 = context.getBean("&F");//Apple
        System.out.println(obj2);
    }
    @Test
    public void test06() {
        /*P4 Bean的生命周期，xml方式*/
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = (Student) context.getBean("student");
//        System.out.println(student);//验证(Bean)init阶段进行了赋值
//        ((ClassPathXmlApplicationContext) context).close();

        /*Bean的生命周期，注解方式*/
        ApplicationContext context2 = new AnnotationConfigApplicationContext(MyConfig.class);
//        Student student2 = (Student) context2.getBean("stu");
////        System.out.println(student2);
//        ((AnnotationConfigApplicationContext) context2).close();

        /*Bean的生命周期，JAVA规范方式*/
//        MyIntToStringConverter converter = (MyIntToStringConverter)context2.getBean("myConverter");
//        converter.myConverter();
//        ((AnnotationConfigApplicationContext) context2).close();

        /*实现两个接口*/
//        MyFunction myFunction = (MyFunction) context2.getBean("myFunction");
//        myFunction.myMethod();
//        ((AnnotationConfigApplicationContext) context2).close();

        /**/
        ((AnnotationConfigApplicationContext) context2).close();
    }
    @Test
    public void test07() {
        /*P5 三层注解的@Autowired*/
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        StudentDao studentDao = (StudentDao) context.getBean("stuDao");//StudentDao为类时
//        System.out.println(studentDao);//检测扫描三层组件

        StudentService stuService = (StudentService)context.getBean("stuService");
        System.out.println("stuServicez注入: " + stuService.getStudentDao());
        System.out.println("*******8*8*8******"+ stuService.getStudentDao());

        //bean+返回值的@Autowired
        Student stu =(Student)context.getBean("stu");
        System.out.println("student注入" + stu);
    }
    @Test
    public void test08() {
        //实现调用spring底层组件
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println(context+"——9999999999999999999");
    }
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();//0.不在此保存！
        //切换环境激活二：
//        ConfigurableEnvironment environment = (ConfigurableEnvironment)context.getEnvironment();
//        environment.setActiveProfiles("myApple");//1.激活
//            //保存点
//        context.register(MyConfig.class);//2.保存
//        context.refresh();//3.刷新(AnnotationConfigApplicationContext的无参构造了，必须使用refresh()手动刷新)
//
//        //@Profile切换环境
//        Object apple = context.getBean("apple");
////        Object banana = context.getBean("banana");
//        System.out.println("------------"+apple);
////        System.out.println("------------"+banana);





        //自定义监听器：创建一个事件 并且发布
        //1.直接匿名实例化ApplicationEvent自定义事件
//        context.publishEvent(new ApplicationEvent("My Event") {
//         });
//        //2.创建一个自定义监听类(实现ApplicationEvent接口)
//        MyEvent3 evn =  new MyEvent3(context);
//        context.publishEvent(evn) ;
//
//
//        ((AnnotationConfigApplicationContext) context).close();
}