package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, ParseException {
        Participant participant1 = new Participant("Artur Smiertka","artur@gmail.com");
        Participant participant2 = new Participant("Angelika Nowak","angelika@gmail.com");
        Participant participant3 = new Participant("Jan Kowalski","jan@gmail.com");
        Participant participant4 = new Participant("Patryk Smiertka","patryk@gmail.com");

        List<Participant> participants = new ArrayList<>();
        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);
        participants.add(participant4);

        CyclicLesson cyclicLesson1 = new CyclicLesson(DayOfWeek.MONDAY,"16:00","18:00");
        CyclicLesson cyclicLesson2 = new CyclicLesson(DayOfWeek.WEDNESDAY,"16:30","18:00");

        List<CyclicLesson> cyclicLessons = new ArrayList<>();
        cyclicLessons.add(cyclicLesson1);
        cyclicLessons.add(cyclicLesson2);

        Schedule schedule = new Schedule(cyclicLessons);

        Date  startDate = new Date(2020-1900, 9,5);

        Course course = new Course("SQL course", schedule,startDate,14,participants);

        Date calculatedDateOfSecondLesson = CalculatorOfSecondLessonDate.calculateSecondLessonDate(cyclicLesson2.getDay(),startDate);
        int numberOfLessons = CalculatorNumOfLessons.calculateNUmberOfLessons(cyclicLesson1.getStartTime(),cyclicLesson1.getEndTime(),cyclicLesson2.getStartTime(),cyclicLesson2.getEndTime(), course.getTotalHours());

        WorkBookCreator workBookCreator = new WorkBookCreator(participants,course.getTotalHours(),numberOfLessons,startDate,cyclicLesson1.getStartTime(),cyclicLesson1.getEndTime(),
                cyclicLesson2.getStartTime(), cyclicLesson2.getEndTime(),calculatedDateOfSecondLesson);
        workBookCreator.generateWorkBook();

    }
}



