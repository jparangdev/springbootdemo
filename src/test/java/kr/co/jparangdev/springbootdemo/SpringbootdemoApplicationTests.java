package kr.co.jparangdev.springbootdemo;

import kr.co.jparangdev.springbootdemo.biz.test.service.MethodTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootdemoApplicationTests {

    @Autowired
    MethodTestService methodTestService;

    @Test
    void contextLoads() {
    }


    @Test
    void timeCheckTest() {
        methodTestService.randomAdd();
    }
}
