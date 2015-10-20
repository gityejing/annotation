package com.annotation.field;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
/*�ĸ�Ԫע�⣬���ǵ���˼ �����˼��䣩������ �����ĵ� ���Ա�����ʹ�� ������ʱ����ʹ�� ע���Ŀ����FIELD*/
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyAnnotion {
    //��һ����ΪVALUE��ֵ��Ĭ��Ϊ123
    String value() default "123";
}
