package com.packt.mvneclipse.annotationdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	public String key();
	
	public String value() default "admin";
}
