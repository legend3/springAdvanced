package com.legend.service;

import com.legend.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stuService")
public class StudentService {
    /*方式一*/
    //按照bean名称注入(只能有一个bean)
//    @Qualifier("stuDao2")//@Autowired识别到多个同类型的bean时, 可以结合使用@Qualifier指定具体bean的名字
    //默认:required=true,从IoC容器中 寻找一个 类型StudentDao的Bean（根据类型），必须要有这个bean，如果没有就会报错
    //required=false如果有直接注入，没有跳过，不会报错
//    @Autowired(required=false)
//    @Autowired//（一）

    /*方式二*/
//    @Resource(type=StudentDao.class)//按照类名注入(也只能有一个bean)
//    @Resource(name="stuDao2")//按照名字找

    /*方式三*/
//    @Inject
    private StudentDao studentDao;

//    @Autowired
//    public StudentService(StudentDao studentDao){
//        this.studentDao= studentDao ;
//    }

//    public StudentService(StudentDao studentDao,String xxx){
//        this.studentDao= studentDao ;
//    }
//    @Qualifier("stuDao2")
//    @Autowired//(二)
    public void setStudentDao(@Autowired StudentDao studentDao) {  // (三)放入set方法参数中，@Autowired: null，三层注解不支持此方式
        System.out.println("***************************111111-");   // (一)、(二)、(三)哪个会调用set方法的检查:    (二)调用
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }
}
