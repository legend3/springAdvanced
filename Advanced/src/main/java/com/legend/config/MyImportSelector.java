package com.legend.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.yanqun.com.com.legend.entity.Apple","com.yanqun.com.com.legend.entity.Banana"};  //返回值就是 要加入IOC容器的Bean的全类名
    }
}
