package kr.co.jparangdev.springbootdemo.common.exceptionHandler;

import kr.co.jparangdev.springbootdemo.common.exception.CustomTypeException;
import kr.co.jparangdev.springbootdemo.common.exception.MemberDuplicateException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler{

    @ExceptionHandler(MemberDuplicateException.class)
    public ResponseEntity<String> memberDuplicated(MemberDuplicateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
