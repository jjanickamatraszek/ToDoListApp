package com.solvd.consts;

import lombok.Getter;

@Getter
public enum ReminderValue {
    MIN_5_BEFORE(5),
    MIN_10_BEFORE(10),
    MIN_15_BEFORE(15),
    MIN_30_BEFORE(30);

    private final int value;

    ReminderValue(int value) {
        this.value = value;
    }
}
