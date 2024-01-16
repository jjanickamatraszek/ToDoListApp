package com.solvd.pages.android;

import com.solvd.consts.ReminderValue;
import com.solvd.pages.base.ReminderPageBase;
import com.solvd.pages.base.TaskDateSettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ReminderPageBase.class)
public class ReminderPage extends ReminderPageBase {

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'reminder_at_values')]")
    private ExtendedWebElement reminderAtBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'reminder_at')]")
    private ExtendedWebElement reminderALabel;

    @FindBy(xpath = ".//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'popup_rv')]")
    private ExtendedWebElement reminderTimePopup;

    @FindBy(xpath = ".//android.widget.CheckBox[contains(@resource-id,'dialog_item_check') and @text='%s']")
    private ExtendedWebElement reminderValueCheckboxFormatted;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'dialog_confirm')]")
    private ExtendedWebElement doneBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'dialog_cancel')]")
    private ExtendedWebElement cancelBtn;

    public ReminderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ReminderPageBase openReminderDropDown() {
        reminderAtBtn.click();
        return this;
    }

    @Override
    public ReminderPageBase selectReminderValue(ReminderValue value) {
        reminderValueCheckboxFormatted.format(value.getDesc()).click();
        return this;
    }

    @Override
    public ReminderPageBase closeReminderDropDown() {
        getDriver().navigate().back();
        return this;
    }

    @Override
    public TaskDateSettingsPageBase clickDoneBtn() {
        doneBtn.click();
        return initPage(TaskDateSettingsPageBase.class);
    }
}
