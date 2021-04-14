package kr.co.jparangdev.springbootdemo.kakao.models;

import javax.persistence.*;


@Embeddable
class BusinessHour {
    @Column(name = "off_day")
    private int offDay;

    @Column(name = "run24")
    private boolean run24;

    @Column(name = "open_time")
    private String openTime;

    @Column(name = "close_time")
    private int closeTime;


    public int getOffDay() {
        return offDay;
    }

    public void setOffDay(int offDay) {
        this.offDay = offDay;
    }

    public boolean isRun24() {
        return run24;
    }

    public void setRun24(boolean run24) {
        this.run24 = run24;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

}

