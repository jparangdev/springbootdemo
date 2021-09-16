package kr.co.jparangdev.springbootdemo.common.util;

import java.util.List;

public class LoopTester {

    public long forLoopSumMinus(List<Integer> list) {
        long result = 0;
        for(int i = 0; i<list.size(); i++) {
            int val = list.get(i);
            if(val%2 == 0)
                result += val;
            else
                result -= val;
        }
        return result;
    }

    public long advancedForLoopSumMinus(List<Integer> list) {
        long result = 0;
        for(int val : list) {
            if(val%2 == 0)
                result += val;
            else
                result -= val;
        }
        return result;
    }

    public long streamSumMinus(List<Integer> list) {
        return list.stream().mapToInt( i-> ((i % 2) == 0) ? i : i * -1).sum();
    }

    public long parallelStreamSumMinus(List<Integer> list) {
        return list.parallelStream().mapToInt( i-> ((i % 2) == 0) ? i : i * -1).sum();
    }

}
