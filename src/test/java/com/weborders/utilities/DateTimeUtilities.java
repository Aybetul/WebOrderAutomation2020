package com.weborders.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeUtilities {

    /**
     * This method returns current date as a string.
     * Provide a format as a parameter
     *
     * MM - to specify month like: 01, 02, 03,
     * MMM - to specify month like: Jan, Feb, Mar
     *
     * dd - to specify day, like 01, 02, 03
     *
     * yyyy - to specify year like: 2010, 2020
     *
     * @param format for example: MMM dd, yyyy = Mar 29, 2020
     * @return current date as a string
     *
     * https://www.journaldev.com/17899/java-simpledateformat-java-date-format
     */
   public static String GetCurrentDate(String format){
       return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
   }
     /*
     * @param end
     * @param format
     * @return Time  Difference
             */
     public static long getTimeDifference(String start, String end, String format){
         LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
         LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
         return ChronoUnit.HOURS.between(startTime, endTime);
     }

    // From web search that i found
//    public static long getTimeDifference2(String start, String end, String formater) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat(formater);
//        Date date1 = format.parse(start);
//        Date date2 = format.parse(end);
//        long difference = date2.getTime() - date1.getTime();
//        return difference;
//
//    }

   // second approach to find time difference
    public static long startAndEndTime(String start, String end) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        Date date1 = format.parse(start);
        Date date2 = format.parse(end);
        long difference = date2.getTime() - date1.getTime();
        long diffHours = difference / (60 * 60 *1000);
        return diffHours;
    }
}
