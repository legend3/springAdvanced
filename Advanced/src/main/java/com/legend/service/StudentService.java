package com.legend.service;

import com.legend.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("stuService")
public class StudentService {
    //按照bean名称注入(只能有一个bean)
//    @Qualifier("stuDao2")
    //默认:required=true,从IoC容器中 寻找一个 类型StudentDao的Bean（根据类型），必须要有这个bean，如果没有就会报错
    //required=false如果有直接注入，没有跳过，不会报错
//    @Autowired(required=false)
//    @Autowired
    //按照类名注入(也只能有一个bean)
//    @Resource(type=StudentDao.class)
//    @Inject
    private StudentDao studentDao ;

//    @Autowired
//    public StudentService(StudentDao studentDao){
//        this.studentDao= studentDao ;
//    }

//    public StudentService(StudentDao studentDao,String xxx){
//        this.studentDao= studentDao ;
//    }
    @Autowired
    public void setStudentDao(StudentDao studentDao) {//@Autowired: null
        System.out.println("***************************111111-");
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }
}
