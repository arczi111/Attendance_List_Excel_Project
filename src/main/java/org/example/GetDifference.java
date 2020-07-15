package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDifference {
    Date d1 = null;
    Date d2 = null;
    private String startTime;
    private String endTime;


    public GetDifference(String startTime,String endTime ) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public long getDiff() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        d1 = format.parse(startTime);
        d2 = format.parse(endTime);

        long diff = d2.getTime() - d1.getTime();

        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffMinAndHour = diffMinutes + diffHours * 60;

        return diffMinAndHour;
    }
}
