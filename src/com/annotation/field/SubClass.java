package com.annotation.field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*����ֱ�Ӽ̳����ǵĸ���*/
public class SubClass extends SuperClass {
	// ����ע��ע�����ԣ�Ĭ��ֵ��123����������Ϊtest
	@MyAnnotion(value = "test")
	private String num;

	@MyAnnotion2(value="hello world")
	private void show(String arg){
		System.out.println(arg);
	}
	
	public SubClass(){
		Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
        	if(method.isAnnotationPresent(MyAnnotion2.class)){
        		MyAnnotion2 myAnnotion2 = method.getAnnotation(MyAnnotion2.class);
        		try {
        			method.setAccessible(true);
					method.invoke(this, myAnnotion2.value());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} 
        	}
		}
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public static void main(String[] args) {
		// ���һ�����ǵ�����ֵ
		System.out.println(new SubClass().getNum());
		(new SubClass()).show("ssss");
	}
}
