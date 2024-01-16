package com.solvd.pages.android;

import com.solvd.pages.base.InputTaskPageBase;
import com.solvd.pages.base.TaskDateSettingsPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = InputTaskPageBase.class)
public class InputTaskPage extends InputTaskPageBase {

    @FindBy(xpath = ".//android.widget.EditText[contains(@resource-id, 'task_create_input')]")
    private ExtendedWebElement inputNewTaskTextField;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'task_create_btn')]")
    private ExtendedWebElement addTaskConfirmBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'task_create_calendar_text')]")
    private ExtendedWebElement selectDateBtn;

    @FindBy(xpath = ".//android.widget.RelativeLayout[contains(@resource-id, 'task_create_root')]/androidx.recyclerview.widget.RecyclerView")
    private ExtendedWebElement inputTaskBackground;

    public InputTaskPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void inputTaskText(String taskText) {
        inputNewTaskTextField.type(taskText);
    }

    @Override
    public void clickAddTaskConfirmBtn() {
        addTaskConfirmBtn.click();
    }

    @Override
    public TasksPageBase leaveInputTaskMode() {
        inputTaskBackground.click();
        return initPage(TasksPageBase.class);
    }

    @Override
    public TaskDateSettingsPageBase clickSelectDateBtn() {
        selectDateBtn.click();
        return initPage(TaskDateSettingsPageBase.class);
    }
}
