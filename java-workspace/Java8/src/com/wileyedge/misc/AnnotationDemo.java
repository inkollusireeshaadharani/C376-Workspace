package com.wileyedge.misc;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{
	String info() default "";
}

class Annotated{
	@Test(info="AWESOME")
	public void foo(String myParam) {
        System.out.println("That is " + myParam);
    }
	@Test(info="GOOD")
	public void zoo(String myParam) {
    	System.out.println("This is " + myParam);
    }
}

class TestAnnotationParser{
	public void parse(Class cls) {
		Method[] methods = cls.getMethods();
		for(Method m : methods) {
			if(m.isAnnotationPresent(Test.class)) {
				Test test = m.getAnnotation(Test.class);
				String info = test.info();
				if ("AWESOME".equals(info)) {
					try {
						m.invoke(Annotated.class.newInstance(), "COOL");
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| InstantiationException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

public class AnnotationDemo {

	public static void main(String[] args) {
		TestAnnotationParser parser = new TestAnnotationParser();
		parser.parse(Annotated.class);
	}

}
