package kr.co.jparangdev.springbootdemo.common.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* 랜덤 숫자 유틸 클래스*/
public class RandomMaker {

    Random random;
    public RandomMaker() {
        this.random = new Random();
    }

    public RandomMaker(Random random) {
        this.random = random;
    }

    public int getRandomInt(int start, int end) {
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(start+end)+start;
    }

    public List<Integer> getRandomIntegerList(int start, int end, int size) {
        List<Integer> list = new LinkedList<>();
        random.setSeed(System.currentTimeMillis());
        for(int i =0; i<size; i++) list.add(random.nextInt(start+end)+start);
        return list;
    }
}
