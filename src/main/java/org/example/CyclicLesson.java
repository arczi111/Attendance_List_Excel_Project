package org.example;

import java.time.DayOfWeek;

public class CyclicLesson {
    private DayOfWeek day;
    private String startTime;
    private String endTime;

    public CyclicLesson(DayOfWeek day, String startTime, String endTime){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
