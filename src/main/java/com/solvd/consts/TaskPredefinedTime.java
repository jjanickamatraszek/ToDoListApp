package com.solvd.consts;

import lombok.Getter;

@Getter
public enum TaskPredefinedTime {
    AM7("07:00", "07:00 AM", 7),
    AM09("09:00", "09:00 AM", 9),
    AM10("10:00", "10:00 AM", 10),
    PM4("16:00", "04:00 PM", 16);

    private final String value;
    private final String value_AMPM;
    private final int hourByNumber;

    TaskPredefinedTime(String value, String value_AMPM, int hourByNumber) {
        this.value = value;
        this.value_AMPM = value_AMPM;
        this.hourByNumber = hourByNumber;
    }
}
