package com.solvd.consts;

import lombok.Getter;

@Getter
public enum TaskPredefinedTime {
    AM7("07:00", "07:00 AM"),
    AM09("09:00", "09:00 AM"),
    AM10("10:00", "10:00 AM"),
    PM4("16:00", "04:00 PM");

    private final String value;
    private final String value_AMPM;

    TaskPredefinedTime(String value, String value_AMPM) {
        this.value = value;
        this.value_AMPM = value_AMPM;
    }
}
