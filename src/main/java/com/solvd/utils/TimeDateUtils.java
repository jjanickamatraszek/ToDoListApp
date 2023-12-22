package com.solvd.utils;

import com.solvd.consts.TaskPredefinedTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeDateUtils {

    public static String parseDateToTasksListPageDateFormat(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM-dd"));
    }

    public static String parseDateToTasksListPageDateTimeFormat(LocalDate date, TaskPredefinedTime time) {
        return date.format(DateTimeFormatter.ofPattern("MM-dd")) + " " + time.getValue_AMPM();
    }

    public static String parseDateToTaskPageDateFormat(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public static LocalDate getThisSundayLocalDate(LocalDate day) {
        return LocalDate.now().plusDays(7 - day.getDayOfWeek().getValue());
    }

    public static String moveBackTimeByMinutes(TaskPredefinedTime time, int minutes) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        return dtf.format(LocalTime.parse(time.getValue_AMPM(), dtf).minusMinutes(minutes));
    }
}
