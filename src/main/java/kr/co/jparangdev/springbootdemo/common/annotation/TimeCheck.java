package kr.co.jparangdev.springbootdemo.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeCheck {
    String unit() default "SECOND"; // 실행시간을 표기해줄 시간단위
}
