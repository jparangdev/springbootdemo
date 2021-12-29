package kr.co.jparangdev.springbootdemo.common.exceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import kr.co.jparangdev.springbootdemo.common.exception.CustomTypeException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

  private final MessageSource messageSource;


  @ExceptionHandler(CustomTypeException.class)
  public ResponseEntity customTypeException(CustomTypeException e) {
    System.out.println("CustomTest!!");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity argumentNotValidException(MethodArgumentNotValidException e, Locale locale) {
    String message = "";
    BindingResult br = e.getBindingResult();
    List<FieldError> fieldErrors = br.getFieldErrors();
    for (FieldError fieldError : fieldErrors) {
      Object[] arguments = fieldError.getArguments();
      String defaultMessage = fieldError.getDefaultMessage();
      message += Arrays.stream(fieldError.getCodes())
          .map(s->messageSource.getMessage(s,arguments,null,locale))
          .filter(s-> StringUtils.hasText(s))
          .findFirst()
          .orElse(defaultMessage);
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }



}
