package kr.co.jparangdev.springbootdemo.common.annotation;

import kr.co.jparangdev.springbootdemo.common.constants.TimeEnum;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeCheck {
    TimeEnum unit() default TimeEnum.MILLISECOND; // 실행시간을 표기해줄 시간단위
}
