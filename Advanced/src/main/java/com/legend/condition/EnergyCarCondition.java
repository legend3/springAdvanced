package com.legend.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnergyCarCondition implements Condition {
    //如果当前环境是 oil，则加入 OilCar
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //获取环境
        Environment environment = conditionContext.getEnvironment();
        String carType = environment.getProperty("car.type");//VM.options中添加： car.type="energy"
        if(carType.contains("energy")){
            return true ;
        }
        return false;
    }
}
