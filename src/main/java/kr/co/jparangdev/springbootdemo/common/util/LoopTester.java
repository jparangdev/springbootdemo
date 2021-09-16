package kr.co.jparangdev.springbootdemo.common.util;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class LoopTester {

    ForkJoinPool pool = new ForkJoinPool(6);

    public long forLoopSumMinus(List<Integer> list) {
        long result = 0;
        for(int i = 0; i<list.size(); i++) {
            result += findEvenInteger(list.get(i));
        }
        return result;
    }

    public long advancedForLoopSumMinus(List<Integer> list) {
        long result = 0;
        for(int i : list) {
            result += findEvenInteger(i);
        }
        return result;
    }

    public long streamSumMinus(List<Integer> list) {
        return list.stream().mapToInt(this::findEvenInteger).sum();
    }

    public long parallelStreamSumMinus(List<Integer> list) {
        return list.parallelStream().mapToInt(this::findEvenInteger).sum();
    }

    public long parallelStreamSumMinusWithPool(List<Integer> list) throws ExecutionException, InterruptedException {
        return pool.submit(() -> list.parallelStream().mapToInt(this::findEvenInteger).sum()).get();
    }

    private int findEvenInteger(int i) {
        return ((i % 2) == 0) ? i : i * -1;
    }
}
