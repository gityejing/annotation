package com.annotation.field;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SuperClass {
    // �����ǵĸ����Ĭ�Ϲ��췽��������������ע��Ĳ��������������������Ĭ�ϵ��ø�����޲ι��췽��������
    public SuperClass() {
        //������е����е�����
        Field[] fields = this.getClass().getDeclaredFields();
        //����fields
        for (Field field : fields) {
            //������field��ע��MyAnnotion
            if (field.isAnnotationPresent(MyAnnotion.class)) {
                //���field��Ӧ��MyAnnotionʵ��
                MyAnnotion myAnnotion = field.getAnnotation(MyAnnotion.class);
                try {
                    //��Ϊfield��˽�����ԣ�����Ҫ��������
                    field.setAccessible(true);
                    //�޸�field��ֵΪannotion��ע���ֵ
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
