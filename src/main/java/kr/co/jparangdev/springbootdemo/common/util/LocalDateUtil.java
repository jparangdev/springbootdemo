package kr.co.jparangdev.springbootdemo.common.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class LocalDateUtil {

    public List<LocalDate> createLocalDateList(String startDate, String endDate) {
        List<LocalDate> dateList = new ArrayList<>();
        LocalDate eDate = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate cDate = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);

        while(cDate.isBefore(eDate) || cDate.isEqual(eDate)) {
            dateList.add(cDate);
            cDate = cDate.plusDays(1);
        }
        return dateList;
    }

    public List<Map<String,LocalDate>> splitLocalDateList(List<LocalDate> inputList, List<Map<String,String>> ignoreDateList) {

        ignoreDateList.forEach(m->{
                String igStartDate = m.get("startDate");
                String igEndDate = m.get("endDate");
                LocalDate sDate = LocalDate.parse(igStartDate,DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate eDate = LocalDate.parse(igEndDate,DateTimeFormatter.ISO_LOCAL_DATE);

                //TODO : 람다로 매칭되는 데이터 빼는 함수 만들어보기
                inputList.forEach(l->{

                });
        });

        return null;
    }

}
