package kr.co.jparangdev.springbootdemo;

import kr.co.jparangdev.springbootdemo.biz.test.service.MethodTestService;
import kr.co.jparangdev.springbootdemo.common.util.LocalDateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
class SpringbootdemoApplicationTests {

    @Autowired
    MethodTestService methodTestService;

    @Autowired
    LocalDateUtil localDateUtil;

    @Test
    void contextLoads() {
    }


    @Test
    void timeCheckTest() {
        methodTestService.randomAdd();
    }

    @Test
    void createDateListTest() {
        String sdate = "2021-09-08";
        String edate = "2021-09-30";

        List<LocalDate> list = localDateUtil.createLocalDateList(sdate,edate);
        list.forEach(System.out::println);
    }
}
