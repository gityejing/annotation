package com.annotation.field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*子类直接继承我们的父类*/
public class SubClass extends SuperClass {
	// 调用注解注入属性，默认值是123，这里设置为test
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
		// 输出一下我们的属性值
		System.out.println(new SubClass().getNum());
		(new SubClass()).show("ssss");
	}
}
