package com.legend.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

//自定义筛选
public class MyFilter  implements TypeFilter {


    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //扫描器扫描"org.legend"包中所有的类，getClassName()可以拿到该包中 所有(DAO三层注解)类的名字
        String className = annotationMetadata.getClassName();
        //只过滤出与学校相关的三层组件
        if(className.contains("School"))
            return true ;

        return false;
    }
}
