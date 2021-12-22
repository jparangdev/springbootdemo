package kr.co.jparangdev.springbootdemo.common.exceptionHandler;

import kr.co.jparangdev.springbootdemo.common.exception.CustomTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = CustomTypeException.class)
  public ResponseEntity customTypeException(CustomTypeException e) {
    System.out.println("CustomTest!!");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
  }
}
