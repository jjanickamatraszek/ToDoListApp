package com.solvd.pages.android;

import com.solvd.pages.base.TaskPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TaskPageBase.class)
public class TaskPage extends TaskPageBase {

    @FindBy(xpath = ".//android.widget.EditText[contains(@resource-id,'task_detail_input')]")
    private ExtendedWebElement taskText;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'detail_due_date_text')]")
    private ExtendedWebElement taskDueDate;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'detail_time_text')]")
    private ExtendedWebElement taskTime;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'task_detail_category')]")
    private ExtendedWebElement category;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'detail_time_text')]")
    private ExtendedWebElement timeAndReminderSetting;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'detail_reminder_text') and not(contains(@resource-id,'title'))]")
    private ExtendedWebElement reminderAtField;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'detail_repeat_text')]")
    private ExtendedWebElement repeatTaskSetting;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'detail_notes_text')]")
    private List<ExtendedWebElement> notesList;

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTaskText() {
        return taskText.getText();
    }

    @Override
    public String getCategory() {
        return category.getText();
    }

    @Override
    public String getTimeAndReminderSetting() {
        return timeAndReminderSetting.getText();
    }

    @Override
    public String getRepeatTaskSetting() {
        return repeatTaskSetting.getText();
    }

    @Override
    public int getNotesAmount() {
        return notesList.size();
    }

    @Override
    public String getTaskDueDate() {
        return taskDueDate.getText();
    }

    @Override
    public String getTaskTime() {
        return taskTime.getText();
    }

    @Override
    public String getReminderAtTime() {
        return reminderAtField.getText();
    }
}
