package com.solvd.consts;

import lombok.Getter;

@Getter
public enum ReminderValue {
    MIN_5_BEFORE(5, "5 minutes before"),
    MIN_10_BEFORE(10, "10 minutes before"),
    MIN_15_BEFORE(15, "15 minutes before"),
    MIN_30_BEFORE(30, "30 minutes before");

    private final int value;
    private final String desc;

    ReminderValue(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
