package kr.co.jparangdev.springbootdemo.common.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class DateUtil {

    public List<Map<String,Object>> createDateListBetweenTowDate(Date startDate, Date endDate, List<Map<String, Object>> dlyRows) {
        List<LocalDate> dateList = new ArrayList<>();
        LocalDate sDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate eDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        while (sDate.compareTo(eDate) <= 0) {
            boolean isDelay = false;
            for(Map<String, Object> dlyRow : dlyRows) {
                if(!dlyRow.containsKey("startDate") || !dlyRow.containsKey("endDate")) continue;
                LocalDate dStartDate = ((Date) dlyRow.get("startDate")).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate dEndDate = ((Date) dlyRow.get("endDate")).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if(sDate.compareTo(dStartDate) >= 0 && sDate.compareTo(dEndDate) <= 0) {
                    isDelay = true;
                    break;
                }
            }
            if(isDelay) {
                dateList.add(null);
            } else {
                dateList.add(sDate);
            }
            sDate = sDate.plusDays(1);
        }

        Map<String, Object> map = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        int size = dateList.size();
        for(int i=0; i<size;i++) {
            LocalDate cur = dateList.get(i);
            if(cur != null) {
                LocalDate prev = (i-1<0) ? null : dateList.get(i-1);
                LocalDate next = (i+1>=size) ? null : dateList.get(i+1);
                Date curDate = Date.from(cur.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

                if(prev == null) {
                    map.put("startDay",curDate);
                }
                if(next == null) {
                    map.put("endDay",curDate);
                    list.add((map));
                    map = new HashMap<>();
                }
            }
        }

        return list;


    }

}
