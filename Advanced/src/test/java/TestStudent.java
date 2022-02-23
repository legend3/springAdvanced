import com.legend.config.MyConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void testXml()
    {
        //1.创建Spring的IOC容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从IOC容器中获取Bean实例(id为"student"的Student对象)
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name :beanDefinitionNames){
            System.out.println(name);
        }
//        Student stu1 =(Student)context.getBean("student");//setXxx()
//        Student stu2 =(Student)context.getBean("student");//setXxx()
//        System.out.println(stu1 ==stu2);
//        Student student = (Student) context.getBean("student");
//        System.out.println(student);//验证(Bean)init阶段进行了赋值
//        ((ClassPathXmlApplicationContext) context).close();

    }
    @Test
    public void testAnnotation()
    {
        //注解方式
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
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

        //实现调用spring底层组件
//        System.out.println(context+"9999999999999999999");
//        StudentDao studao = (StudentDao)context.getBean("studentDao") ;
//        System.out.println(studao);

        //三层注解的@Autowired
//        StudentService stuService = (StudentService)context.getBean("stuService") ;
//        System.out.println("stuServicez注入: " + stuService.getStudentDao());
//        System.out.println("*******8*8*8******"+ stuService.getStudentDao());
        //bean+返回值的@Autowired
//        Student stu =( Student)context.getBean("stu");
//        System.out.println(stu);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name :beanDefinitionNames){
            System.out.println("name: " + name);//name:id
        }
//        Object obj = context.getBean("myFactoryBean");
//        System.out.println(obj);
//
//        Object obj2 = context.getBean("&myFactoryBean");
//        System.out.println(obj2);
//        Student stu1 = (Student)context.getBean(Student.class) ;
//        Student stu2 = (Student)context.getBean(Student.class) ;
//        System.out.println(stu1==stu2);
        //Student stu = new Student();
//        System.out.println(stu1);
//        MyIntToStringConverter converter = (MyIntToStringConverter)context.getBean("myConverter");
//        converter.myConverter();

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
}
