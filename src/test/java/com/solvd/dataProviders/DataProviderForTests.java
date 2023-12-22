package com.solvd.dataProviders;

import com.solvd.consts.ReminderValue;
import com.solvd.consts.TaskPredefinedDay;
import com.solvd.consts.TaskPredefinedTime;
import com.solvd.utils.TimeDateUtils;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;

public class DataProviderForTests {

    @DataProvider
    public Object[][] predefinedTaskTimeDateAndReminders() {
        return new Object[][]{
                {TaskPredefinedDay.TOMORROW, LocalDate.now().plusDays(1), TaskPredefinedTime.AM10, ReminderValue.MIN_10_BEFORE},
                {TaskPredefinedDay.THREE_DAY_LATER, LocalDate.now().plusDays(3), TaskPredefinedTime.AM7, ReminderValue.MIN_15_BEFORE},
                {TaskPredefinedDay.THIS_SUNDAY, TimeDateUtils.getThisSundayLocalDate(LocalDate.now()), TaskPredefinedTime.PM4, ReminderValue.MIN_30_BEFORE}
        };
    }
}
