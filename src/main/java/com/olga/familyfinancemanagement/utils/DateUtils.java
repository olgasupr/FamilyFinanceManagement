package com.olga.familyfinancemanagement.utils;

import java.util.Date;

import static java.time.LocalDate.now;
import static java.time.ZoneOffset.UTC;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class DateUtils {

    public static Date getFirstDayOfCurrentMonth() {
        return Date.from(now().with(firstDayOfMonth()).atStartOfDay().toInstant(UTC));
    }

    public static Date getLastDayOfCurrentMonth() {
        return Date.from(now().with(lastDayOfMonth()).atStartOfDay().toInstant(UTC));
    }
}
