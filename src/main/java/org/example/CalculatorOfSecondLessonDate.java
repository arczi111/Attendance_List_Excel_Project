package org.example;

import java.time.DayOfWeek;
import java.util.Date;

public class CalculatorOfSecondLessonDate {
    public static Date calculateSecondLessonDate(DayOfWeek day, Date startDate) {

        int numberOfDay = 0;

        if (day == DayOfWeek.MONDAY) {
            numberOfDay = 0;
        } else if (day == DayOfWeek.TUESDAY) {
            numberOfDay = 1;
        } else if (day == DayOfWeek.WEDNESDAY) {
            numberOfDay = 2;
        } else if (day == DayOfWeek.THURSDAY) {
            numberOfDay = 3;
        } else if (day == DayOfWeek.FRIDAY) {
            numberOfDay = 4;
        } else if (day == DayOfWeek.SATURDAY) {
            numberOfDay = 5;
        } else if (day == DayOfWeek.SUNDAY) {
            numberOfDay = 6;
        }

        Date newDate = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDay() + 4 + numberOfDay);
        return newDate;
    }
}
