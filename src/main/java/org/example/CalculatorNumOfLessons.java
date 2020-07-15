package org.example;

import java.text.ParseException;

public class CalculatorNumOfLessons {
    public static int calculateNUmberOfLessons(String startTimeFrom_1_CyclicLesson, String endTimeFrom_1_CyclicLesson,
                                          String  startTimeFrom_2_CyclicLesson,String endTimeFrom_2_CyclicLesson, int getTotalHours ) throws ParseException {
        GetDifference getDifference = new GetDifference(startTimeFrom_1_CyclicLesson,endTimeFrom_1_CyclicLesson);

        GetDifference getDifference2 = new GetDifference(startTimeFrom_2_CyclicLesson,endTimeFrom_2_CyclicLesson);

        long firstDuration = getDifference.getDiff();
        long secondDuration = getDifference2.getDiff();
        int numberOfLessons = 0;
        if(firstDuration == secondDuration) {
            numberOfLessons = (int) ((getTotalHours * 60) / firstDuration);
        }else
        {
            numberOfLessons = (int) ((getTotalHours * 60) / ((firstDuration+secondDuration)/2));
        }
        return numberOfLessons;
    }
}
