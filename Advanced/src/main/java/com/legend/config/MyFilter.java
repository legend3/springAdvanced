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
        //补充：1. （目的）通过annotationMetadata获取到所有的bean，再自定义(哪些)对象添加入容器中
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();//读取底层类的完整注释元数据，包括注释方法的元数据，
            //扫描器扫描"org.legend"包中所有的类，getClassName()可以拿到该包中 所有标有三层注解的类
        String className = annotationMetadata.getClassName();
//        System.out.println("className: " + className);

        //只过滤出与学校相关的三层组件且将这些类加入IOC容器
        if(className.contains("School")) {//补充：2. annotationMetadata中哪些要加入到IOC容器
//            System.out.println("有School！");
            return true;
        }
        return false;
    }
}
