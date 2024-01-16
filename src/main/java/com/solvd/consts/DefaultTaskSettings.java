package com.solvd.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultTaskSettings {
    public static final String timeAndReminderSetting = "No";
    public static final String repeatTaskSetting = "No";
    public static final String dueDateSetting = "No Date";
    public static final ReminderValue defaultReminderMinutes = ReminderValue.MIN_5_BEFORE;
}
