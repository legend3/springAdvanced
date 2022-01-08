package com.legend.dao.impl;

import com.legend.dao.StudentDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository("stuDao1")
public class StudentDaoImpl1 implements StudentDao {
}
