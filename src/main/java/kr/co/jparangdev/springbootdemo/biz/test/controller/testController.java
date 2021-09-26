package kr.co.jparangdev.springbootdemo.biz.test.controller;

import kr.co.jparangdev.springbootdemo.common.exception.CustomTypeException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class testController {

    @GetMapping("/filterLogging")
    public Map<String, Object> filterLogging() {
        return null;
    }

    @GetMapping("/ExceptionTest")
    public void ExceptionTest() {
        throw new CustomTypeException("테스트!!");
    }
}
