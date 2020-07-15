package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TEST_Excel_Generator
{
    @Test
    public void shouldReturnWorkbook() throws IOException, ParseException {

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

        Date startDate = new Date(2020-1900, 9,5);

        Course course = new Course("SQL course", schedule,startDate,14,participants);

        Date calculatedDateOfSecondLesson = CalculatorOfSecondLessonDate.calculateSecondLessonDate(cyclicLesson2.getDay(),startDate);
        int numberOfLessons = CalculatorNumOfLessons.calculateNUmberOfLessons(cyclicLesson1.getStartTime(),cyclicLesson1.getEndTime(),cyclicLesson2.getStartTime(),cyclicLesson2.getEndTime(), course.getTotalHours());

        WorkBookCreator workBookCreator = new WorkBookCreator(participants,course.getTotalHours(),numberOfLessons,startDate,cyclicLesson1.getStartTime(),cyclicLesson1.getEndTime(),
                cyclicLesson2.getStartTime(), cyclicLesson2.getEndTime(),calculatedDateOfSecondLesson);
        workBookCreator.generateWorkBook();



        Date expectedDate = new Date(2020-1900, 9,7);//Wednesday = startDate + 2
        int expectedNumberOfLessons = 8;

        Assert.assertTrue(participants.toString().contains("Patryk Smiertka"));
        Assert.assertEquals(expectedDate,workBookCreator.getCalculatedDateOfSecondLesson());
        Assert.assertEquals(expectedNumberOfLessons,workBookCreator.getNumberOfLessons());
    }

    @Test
    public void shouldReturnCalculatedSecondLessonDate(){
        Date startDate = new Date(2020-1900, 9,5);
        Date calculatedDateOfSecondLesson = CalculatorOfSecondLessonDate.calculateSecondLessonDate(DayOfWeek.WEDNESDAY,startDate);
        Date expectedDate = new Date(2020-1900,9,7);

        Assert.assertEquals(expectedDate,calculatedDateOfSecondLesson);
    }
    
    @Test
    public void shouldReturnDifferenceValue() throws ParseException {

        String firstStartDate_Cycle_1 = "15:00";
        String endStartDate_Cycle_1 = "19:00";
        GetDifference getDifference = new GetDifference(firstStartDate_Cycle_1,endStartDate_Cycle_1);

        long difference = getDifference.getDiff();
        long expectedDifference = 240; // result giving in minutes

        Assert.assertEquals(expectedDifference,difference);
    }

    @Test
    public void shouldCheckEvenValue(){
        boolean evenValue = EvenChecker.checkIfEven(6);
        boolean notEvenValue = EvenChecker.checkIfEven(7);

        Assert.assertTrue(evenValue);
        Assert.assertTrue(!notEvenValue);
    }

    @Test
    public void shouldReturnCalculatedNumberOfLessons() throws ParseException {

        String firstStartDate_Cycle_1 = "16:00";
        String endStartDate_Cycle_1 = "18:00";

        String firstStartDate_Cycle_2 = "15:00";
        String endStartDate_Cycle_2 = "17:00";

        int totalHoursInCourse = 20;
        int numberOfLessons = CalculatorNumOfLessons.calculateNUmberOfLessons(firstStartDate_Cycle_1,endStartDate_Cycle_1,
                firstStartDate_Cycle_2,endStartDate_Cycle_2, totalHoursInCourse);
        int expectedNumbersOfLessons = 10;// totalHoursInCourse / 2

        Assert.assertEquals(expectedNumbersOfLessons,numberOfLessons);
    }
}
