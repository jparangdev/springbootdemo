package kr.co.jparangdev.springbootdemo.kakao.service;

import kr.co.jparangdev.springbootdemo.kakao.models.Stores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoresUtil {
    public static boolean isOpen(Stores stores, String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        int curTime = (dateTime.getHour() * 60) + dateTime.getMinute();
        return false;
    }
}
