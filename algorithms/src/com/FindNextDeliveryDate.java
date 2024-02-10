package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FindNextDeliveryDate {
    public static LocalDate findNExtDeliveryDate(LocalDate currentDate, int scheduleDay, String scheduleType){
        int month = currentDate.getMonth().getValue();
        int year = currentDate.getYear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        if(scheduleType.equals("M")){
            if(month==1 && scheduleDay>28){
                if(isLeapYear( month,year)){
                    scheduleDay = 29;
                    month++;
                }
            }else if(month==12){
                month =1;
                year++;
            }else{
                month++;
            }
            if(scheduleDay==31) {
                scheduleDay = getValidDay(scheduleDay, month);
            }
        }
        if(scheduleType.equals("Q")){
            switch (month) {
                case 1, 2, 3:
                    month = 4;
                    break;
                case 4,5,6:
                    month = 7;
                    break;
                case 7,8,9:
                    month=10;
                    break;
                case 10,11,12:
                    month=1;
                    year++;
                    break;
            }

            if(scheduleDay==31 && month==4){
                scheduleDay--;
            }
        }
        return LocalDate.parse(scheduleDay+"-"+month+"-"+year, formatter);
    }
    private static int getValidDay(int day, int month){
        switch (month){
            case 4,6,9,11:
                day--;
        }
        return day;
    }
    private static boolean isLeapYear( int mm, int yyyy){
        return LocalDate.of(yyyy, mm, 1).isLeapYear();
    }
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        System.out.println(findNExtDeliveryDate(LocalDate.parse("08-Jan-2024", formatter), 15, "M")); //2024-02-15
        System.out.println(findNExtDeliveryDate(LocalDate.parse("08-Mar-2024", formatter), 31, "M")); //2024-04-30
        System.out.println(findNExtDeliveryDate(LocalDate.parse("08-Dec-2024", formatter), 31, "M")); //2025-01-31
        System.out.println(findNExtDeliveryDate(LocalDate.parse("08-Feb-2024", formatter), 28, "M")); //2024-03-28


        System.out.println(findNExtDeliveryDate(LocalDate.parse("08-Jan-2024", formatter), 31, "Q")); //2024-04-30
        System.out.println(findNExtDeliveryDate(LocalDate.parse("08-Oct-2024", formatter), 25, "Q")); //2025-01-25
        System.out.println(findNExtDeliveryDate(LocalDate.parse("08-Aug-2024", formatter), 31, "Q")); //2025-10-31
    }
}
