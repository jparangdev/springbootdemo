package kr.co.jparangdev.springbootdemo.common;


import kr.co.jparangdev.springbootdemo.common.annotation.TimeCheck;
import kr.co.jparangdev.springbootdemo.common.constants.TimeEnum;
import kr.co.jparangdev.springbootdemo.common.util.LoopTester;
import kr.co.jparangdev.springbootdemo.common.util.RandomMaker;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoopMethodTest {

    static RandomMaker randomMake;

    LoopTester loopTester = new LoopTester();

    static List<Integer> list;

    StopWatch stopWatch;

    @BeforeAll
    static void setList() {
        randomMake = new RandomMaker();
        list = randomMake.getRandomIntegerList(1,10,200000);
    }

    @BeforeEach
    protected void start() {
        stopWatch = new StopWatch();
        stopWatch.start();
    }

    @AfterEach
    protected void end() {
        stopWatch.stop();
        double time = Math.round(stopWatch.getLastTaskTimeMillis());
        String unitStr = "ms";
        String str = "Method RunningTime is : "+time+" " +unitStr;
        System.out.println(str);
        System.out.println();
    }

    @Test
    @Order(0)
    public void first() {
        System.out.println(list.size());;
    }

    @Test
    @Order(1)
    public void forLoopSumMinus() {
        long result = loopTester.forLoopSumMinus(list);
        System.out.println("forLoopSumMinus: "+result);
    }

    @Test
    @Order(2)
    public void advancedForLoopSumMinus() {
        long result = loopTester.advancedForLoopSumMinus(list);
        System.out.println("advancedForLoopSumMinus: "+ result);
    }


    @Test
    @Order(3)
    public void streamSumMinus() {
        long result = loopTester.streamSumMinus(list);
        System.out.println("streamSumMinus: "+result);
    }

    @Test
    @Order(4)
    public void parallelStreamSumMinus() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","4");
        long result = loopTester.parallelStreamSumMinus(list);
        System.out.println("parallelStreamSumMinus: "+result);
    }



}
