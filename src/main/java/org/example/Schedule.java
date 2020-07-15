package org.example;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<CyclicLesson> cyclicLessons = new ArrayList<>();

    public Schedule(List<CyclicLesson> cyclicLessons){
        this.cyclicLessons = cyclicLessons;
    }
}
