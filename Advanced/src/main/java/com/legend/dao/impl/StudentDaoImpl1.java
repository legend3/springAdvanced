package com.legend.dao.impl;

import com.legend.dao.StudentDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary//当多个同类型的bean时，设置这个为默认的bean
@Repository("stuDao1")
public class StudentDaoImpl1 implements StudentDao {
}
