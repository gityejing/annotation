package com.annotation.field;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SuperClass {
    // 在我们的父类的默认构造方法中来进行属性注入的操作，这里利用了子类会默认调用父类的无参构造方法的特性
    public SuperClass() {
        //获得类中的所有的属性
        Field[] fields = this.getClass().getDeclaredFields();
        //遍历fields
        for (Field field : fields) {
            //如果这个field有注解MyAnnotion
            if (field.isAnnotationPresent(MyAnnotion.class)) {
                //获得field对应的MyAnnotion实例
                MyAnnotion myAnnotion = field.getAnnotation(MyAnnotion.class);
                try {
                    //因为field是私有属性，所以要设置这里
                    field.setAccessible(true);
                    //修改field的值为annotion中注入的值
                    field.set(this, myAnnotion.value());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
