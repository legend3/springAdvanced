package com.legend.condition;

import com.legend.entity.Student;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * 注册能生成OilCar Bean的满足条件
 */
public class OilCarCondition implements Condition {
    //如果当前环境是 oil，则加入 OilCar
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        /**
         * 验证例一、
         * 利用conditionContext上下文作为盘点条件
         * 获取环境（Environment不是必须的，只是本例利用环境作为判断条件！）
         */
//        Environment environment = conditionContext.getEnvironment();
//        String carType = environment.getProperty("car.type");//VM.options中添加： -Dcar.type=oil
//        if(carType.contains("oil")){
//            return true;
//        }
        /**
         * 验证例二、
         * 利用annotatedTypeMetadata获取类元信息作为判断条件
         *
         */
        Student student = new Student();
        //获取指定类(Student)的元信息,用于判断条件！
        System.out.println("OilCarCondition所有注解: " + annotatedTypeMetadata.getAllAnnotationAttributes(Student.class.getName(), false));


        
        return false;
    }
}
