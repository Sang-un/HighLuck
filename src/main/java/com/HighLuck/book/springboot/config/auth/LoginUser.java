package com.HighLuck.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)// 이 어노테이션이 생성될 수 있는 위치를 지정함
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {// @interface 는 이 파일을 어노테이션 클래스로 지정한다.
}