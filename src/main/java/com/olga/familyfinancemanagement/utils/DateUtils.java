package com.olga.familyfinancemanagement.utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.time.LocalDate.now;
import static java.time.ZoneOffset.UTC;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class DateUtils {


    public static Date getFirstDayOfCurrentMonth() {
        return Date.from(now().with(firstDayOfMonth()).atStartOfDay().toInstant(UTC));
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
/*
    public static Date getLastDayOfCurrentMonth() {
        return Date.from(now().with(lastDayOfMonth()).atStartOfDay().toInstant(UTC));
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
*/
    public static Date addMonths(Date date, int months) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        return c.getTime();
    }

    public static Date parseYYYYMM(String yyyymm) {
        try {
            int yyyymmAsInt = Integer.parseInt(yyyymm);
            int year = yyyymmAsInt / 100;
            int month = yyyymmAsInt % 100;

            if (year > 2000 && year < 2100 && month >= 1 && month <= 12) {
                return Date.from(LocalDate.of(year, month, 1).atStartOfDay().toInstant(UTC));
            }
            // invalid date
            return null;
        } catch (NumberFormatException e) {
            //failed to parse
            return null;
        }
    }
}
