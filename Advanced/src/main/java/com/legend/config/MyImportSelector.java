package com.legend.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.legend.entity.Apple","com.legend.entity.Banana"};//返回值就是 要加入IOC容器的Bean的全类名
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        /*过滤*/
        return b -> b.contains("Apple");//对selectImports返回的String[]加一个过滤器，过滤掉Apple(会返回一个java.lang.Object)
    }
}
