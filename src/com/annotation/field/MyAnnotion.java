package com.annotation.field;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
/*四个元注解，他们的意思 （个人记忆）依次是 生成文档 可以被子类使用 在运行时可以使用 注解的目标是FIELD*/
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyAnnotion {
    //有一个名为VALUE的值，默认为123
    String value() default "123";
}
