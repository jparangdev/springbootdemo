package kr.co.jparangdev.springbootdemo;

import kr.co.jparangdev.springbootdemo.biz.test.service.MethodTestService;
import kr.co.jparangdev.springbootdemo.common.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class SpringbootdemoApplicationTests {

    @Autowired
    MethodTestService methodTestService;

    @Autowired
    DateUtil dateUtil;

    @Test
    void contextLoads() {
    }


    @Test
    void timeCheckTest() {
        methodTestService.randomAdd();
    }

    @Test
    void createDateListTest() throws ParseException {
        String sdate = "2021-09-01";
        String edate = "2021-09-28";

        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd");


        List<Map<String,Object>> dlyRows = new ArrayList<>();
        String dlySdate;
        String dlyEdate;
        Map<String, Object> dlyRow;

        dlyRow = new HashMap<>();
        dlySdate = "2021-08-02";
        dlyEdate = "2021-09-04";
        dlyRow.put("startDate",tf.parse(dlySdate));
        dlyRow.put("endDate",tf.parse(dlyEdate));
        dlyRows.add(dlyRow);

        dlyRow = new HashMap<>();
        dlySdate = "2021-09-09";
        dlyEdate = "2021-09-15";
        dlyRow.put("startDate",tf.parse(dlySdate));
        dlyRow.put("endDate",tf.parse(dlyEdate));
        dlyRows.add(dlyRow);

        dlyRow = new HashMap<>();
        dlySdate = "2021-09-27";
        dlyEdate = "2021-10-30";
        dlyRow.put("startDate",tf.parse(dlySdate));
        dlyRow.put("endDate",tf.parse(dlyEdate));
        dlyRows.add(dlyRow);


        List<Map<String,Object>> list = dateUtil.createDateListBetweenTowDate(tf.parse(sdate),tf.parse(edate),dlyRows);
        list.forEach(m->{System.out.println(m.get("startDay")+" - "+m.get("endDay"));});
    }
}
