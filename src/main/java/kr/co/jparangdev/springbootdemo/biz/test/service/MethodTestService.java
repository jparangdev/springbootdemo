package kr.co.jparangdev.springbootdemo.biz.test.service;

import kr.co.jparangdev.springbootdemo.common.annotation.TimeCheck;
import kr.co.jparangdev.springbootdemo.common.constants.TimeEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MethodTestService {

    @TimeCheck(unit = TimeEnum.NANO)
    public void randomAdd() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for(int i =0; i<10000; i++){
            list.add(random.nextInt(10000));
        }
    }
}
