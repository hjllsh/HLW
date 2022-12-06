package com.hlw.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String changeTime(String dateTime) throws ParseException {

        dateTime = dateTime .replace("Z", " UTC");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) format1.parse(dateTime);
        String time= format2.format(date);
        return time;
    }

}
