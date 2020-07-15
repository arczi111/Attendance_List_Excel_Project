package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WorkBookCreator {

    private List participants;
    private int getTotalHours;
    private int  numberOfLessons;
    private Date startDate;
    private String startTimeFrom_1_CyclicLesson;
    private String endTimeFrom_1_CyclicLesson;
    private String startTimeFrom_2_CyclicLesson;
    private String endTimeFrom_2_CyclicLesson;
    private Date calculatedDateOfSecondLesson;

    public WorkBookCreator(List participants,
            int getTotalHours,
            int  numberOfLessons,
            Date startDate,
            String startTimeFrom_1_CyclicLesson,
            String endTimeFrom_1_CyclicLesson,
            String startTimeFrom_2_CyclicLesson,
            String endTimeFrom_2_CyclicLesson,
            Date calculatedDateOfSecondLesson){
        this.participants = participants;
        this.getTotalHours = getTotalHours;
        this. numberOfLessons = numberOfLessons;
        this.startDate = startDate;
        this.startTimeFrom_1_CyclicLesson = startTimeFrom_1_CyclicLesson;
        this.endTimeFrom_1_CyclicLesson  = endTimeFrom_1_CyclicLesson;
        this.startTimeFrom_2_CyclicLesson = startTimeFrom_2_CyclicLesson;
        this.endTimeFrom_2_CyclicLesson = endTimeFrom_2_CyclicLesson;
        this.calculatedDateOfSecondLesson = calculatedDateOfSecondLesson;
    }

    public List getParticipants() {
        return participants;
    }

    public int getGetTotalHours() {
        return getTotalHours;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStartTimeFrom_1_CyclicLesson() {
        return startTimeFrom_1_CyclicLesson;
    }

    public String getEndTimeFrom_1_CyclicLesson() {
        return endTimeFrom_1_CyclicLesson;
    }

    public String getStartTimeFrom_2_CyclicLesson() {
        return startTimeFrom_2_CyclicLesson;
    }

    public String getEndTimeFrom_2_CyclicLesson() {
        return endTimeFrom_2_CyclicLesson;
    }

    public Date getCalculatedDateOfSecondLesson() {
        return calculatedDateOfSecondLesson;
    }

    public void generateWorkBook() throws  IOException {

            Workbook wb = new HSSFWorkbook();
            Sheet sheet1 = wb.createSheet("Information");
            Sheet sheet2 = wb.createSheet("Attendece List");
            CreationHelper createHelper = wb.getCreationHelper();

            generateFirstSheet(wb,sheet1,getTotalHours,numberOfLessons,createHelper,startDate,startTimeFrom_1_CyclicLesson,endTimeFrom_1_CyclicLesson,
                    calculatedDateOfSecondLesson,startTimeFrom_2_CyclicLesson,endTimeFrom_2_CyclicLesson);
            generateNamesAndOrdinalNumSecondSheet(wb,sheet2,participants,numberOfLessons);
            generateDatesFirstROwSecondSheet(sheet2, numberOfLessons,  startDate, wb,  createHelper, calculatedDateOfSecondLesson);

            saveWork(wb);
        }
        private void generateFirstSheet(Workbook wb, Sheet sheet1, int totalHours, int numberOfLessons, CreationHelper createHelper, Date startDate, String startTimeFrom_1_CyclicLesson,
                                    String endTimeFrom_1_CyclicLesson, Date calculatedDateOfSecondLesson, String  startTimeFrom_2_CyclicLesson, String endTimeFrom_2_CyclicLesson){
        CellStyle borderCellStyle = wb.createCellStyle();
        borderCellStyle.setBorderTop(BorderStyle.THIN);
        borderCellStyle.setBorderBottom(BorderStyle.THIN);
        borderCellStyle.setBorderLeft(BorderStyle.THIN);
        borderCellStyle.setBorderRight(BorderStyle.THIN);

        borderCellStyle.setAlignment(HorizontalAlignment.JUSTIFY);

        Row row1 = sheet1.createRow(0);

        Cell cell1_Row1 = row1.createCell(0);
        cell1_Row1.setCellValue("Course");
        cell1_Row1.setCellStyle(borderCellStyle);

        Cell cell2_Row1 = row1.createCell(1);
        cell2_Row1.setCellValue("SQL essentials");
        cell2_Row1.setCellStyle(borderCellStyle);
        sheet1.autoSizeColumn(1);

        Row row2 = sheet1.createRow(1);

        Cell cell1_Row2 = row2.createCell(0);
        cell1_Row2.setCellValue("Hours planned");
        cell1_Row2.setCellStyle(borderCellStyle);

        Cell cell2_Row2 = row2.createCell(1);
        cell2_Row2.setCellValue(totalHours);
        cell2_Row2.setCellStyle(borderCellStyle);

        Row row3 = sheet1.createRow(2);

        Cell cell1_Row3 = row3.createCell(0);
        cell1_Row3.setCellValue("Lesson planned");
        cell1_Row3.setCellStyle(borderCellStyle);

        Cell cell2_Row3 = row3.createCell(1);
        cell2_Row3.setCellValue(numberOfLessons);
        cell2_Row3.setCellStyle(borderCellStyle);

        sheet1.autoSizeColumn(0);
        int dayIncreaserFirstLesson = 0;
        int dayIncreaserSecondLesson = 0;
        for(int i = 4; i < numberOfLessons+4; i++) {

            CellStyle dataCellStyle = wb.createCellStyle();
            dataCellStyle.setBorderTop(BorderStyle.THIN);
            dataCellStyle.setBorderBottom(BorderStyle.THIN);
            dataCellStyle.setBorderLeft(BorderStyle.THIN);
            dataCellStyle.setBorderRight(BorderStyle.THIN);
            dataCellStyle.setAlignment(HorizontalAlignment.JUSTIFY);

            Calendar c = Calendar.getInstance();
            dataCellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("m/d/yy"));

            Row rowWithDateAndLessonHours = sheet1.createRow(i);
            if(EvenChecker.checkIfEven(i)){
                Cell dynamicCell0 = rowWithDateAndLessonHours.createCell(0);
                c.setTime(startDate);
                c.add(Calendar.DATE, dayIncreaserFirstLesson);
                startDate = c.getTime();
                dynamicCell0.setCellValue(startDate);
                dynamicCell0.setCellStyle(dataCellStyle);

                Cell dynamicCell1 = rowWithDateAndLessonHours.createCell(1);
                dynamicCell1.setCellValue(startTimeFrom_1_CyclicLesson);
                dynamicCell1.setCellStyle(dataCellStyle);

                Cell dynamicCell2 = rowWithDateAndLessonHours.createCell(2);
                dynamicCell2.setCellValue(endTimeFrom_1_CyclicLesson);
                dynamicCell2.setCellStyle(dataCellStyle);

                dayIncreaserFirstLesson =  7;
            }else{
                {
                    Cell dynamicCell0 = rowWithDateAndLessonHours.createCell(0);
                    c.setTime(calculatedDateOfSecondLesson);
                    c.add(Calendar.DATE, dayIncreaserSecondLesson);
                    calculatedDateOfSecondLesson = c.getTime();
                    dynamicCell0.setCellValue(calculatedDateOfSecondLesson);
                    dynamicCell0.setCellStyle(dataCellStyle);

                    Cell dynamicCell1 = rowWithDateAndLessonHours.createCell(1);
                    dynamicCell1.setCellValue(startTimeFrom_2_CyclicLesson);
                    dynamicCell1.setCellStyle(dataCellStyle);

                    Cell dynamicCell2 = rowWithDateAndLessonHours.createCell(2);
                    dynamicCell2.setCellValue(endTimeFrom_2_CyclicLesson);
                    dynamicCell2.setCellStyle(dataCellStyle);

                    dayIncreaserSecondLesson =  7;
                }
            }
        }
    }
    private void generateDatesFirstROwSecondSheet(Sheet sheet, Integer numberOfLessons, Date startDate,Workbook wb, CreationHelper createHelper, Date globalCalculatedDateOfSecondLesson){
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy"));
        Row dynamicRow = sheet.createRow(0);

        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setAlignment(HorizontalAlignment.JUSTIFY);

        Row row2 = sheet.createRow(0);

        Cell cell1sheet2 = row2.createCell(0);
        cell1sheet2.setCellValue("#");
        cell1sheet2.setCellStyle(cellStyle);

        Cell cell2sheet2 = row2.createCell(1);
        cell2sheet2.setCellValue("Name");
        cell2sheet2.setCellStyle(cellStyle);

        Calendar c = Calendar.getInstance();
        int dayIncreaserFirstLesson = 0;
        int dayIncreaserSecondLesson = 0;

        for (int i = 2; i<numberOfLessons+2; i++){
           sheet.autoSizeColumn(i-2);
            if(EvenChecker.checkIfEven(i)){
                Cell dynamicCell0 = dynamicRow.createCell(i);
                c.setTime(startDate);
                c.add(Calendar.DATE, dayIncreaserFirstLesson);
                startDate = c.getTime();
                dynamicCell0.setCellValue(startDate);
                dynamicCell0.setCellStyle(cellStyle);
                dayIncreaserFirstLesson = 7;
            }else {
                {
                    Cell dynamicCell0 = dynamicRow.createCell(i);
                    c.setTime(globalCalculatedDateOfSecondLesson);
                    c.add(Calendar.DATE, dayIncreaserSecondLesson);
                    globalCalculatedDateOfSecondLesson = c.getTime();
                    dynamicCell0.setCellValue(globalCalculatedDateOfSecondLesson);
                    dynamicCell0.setCellStyle(cellStyle);
                    dayIncreaserSecondLesson = 7;
                }
            }
        }

    }
    private void generateNamesAndOrdinalNumSecondSheet(Workbook wb, Sheet sheet2, List participants, int numberOfLessons ){
        CellStyle borderCellStyle = wb.createCellStyle();
        borderCellStyle.setBorderTop(BorderStyle.THIN);
        borderCellStyle.setBorderBottom(BorderStyle.THIN);
        borderCellStyle.setBorderLeft(BorderStyle.THIN);
        borderCellStyle.setBorderRight(BorderStyle.THIN);
        borderCellStyle.setAlignment(HorizontalAlignment.JUSTIFY);

        for(int i = 1; i<participants.size()+1;i++){
            Row dynamicRow = sheet2.createRow(i);
            Cell dynamicCellOrdinalNumber = dynamicRow.createCell(0);
            dynamicCellOrdinalNumber.setCellValue(i);
            dynamicCellOrdinalNumber.setCellStyle(borderCellStyle);
            Cell dynamicCellName = dynamicRow.createCell(1);
            dynamicCellName.setCellValue(participants.get(i-1).toString());
            dynamicCellName.setCellStyle(borderCellStyle);
            for (int j = 2; j < numberOfLessons + 2; j++) {
                Cell cell = dynamicRow.createCell(j);
                cell.setCellStyle(borderCellStyle);
            }
        }
    }
    private void saveWork(Workbook wb) throws IOException {
        try (OutputStream fileOut = new FileOutputStream("SQL_course.xls")) {

            wb.write(fileOut);
        }
    }
}
