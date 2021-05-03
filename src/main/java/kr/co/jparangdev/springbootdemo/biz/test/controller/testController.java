package kr.co.jparangdev.springbootdemo.biz.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class testController {

    @GetMapping("/filterLogging")
    public @ResponseBody
    Map<String, Object> filterLogging() {
        return null;
    }
}
