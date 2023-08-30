package com.demo.security.mapper;

import java.lang.reflect.Method;

public class Mapper <T ,V> {

    public  V  transform(T t , V v) throws Exception {
        Class<?> classV = v.getClass();
        Class<?> classT =t.getClass();
        Method[] methodV= classV.getMethods();

        for(Method mv : methodV) {
            String methodName = mv.getName();
            if (methodName.startsWith("set")) {
                String getterMethod = "get" + methodName.substring(3);
                Method methodT = classT.getMethod(getterMethod);

                Object value = methodT.invoke(t);
                mv.invoke(v, value);
            }
        }

    return v;
    }
}
