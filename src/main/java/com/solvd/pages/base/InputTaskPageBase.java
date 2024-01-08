package com.solvd.pages.base;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class InputTaskPageBase extends AbstractPage implements IMobileUtils {

    protected InputTaskPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract InputTaskPageBase inputTaskText(String taskText);

    public abstract void clickAddTaskConfirmBtn();

    public abstract TasksPageBase leaveInputTaskMode();

    public abstract TaskDateSettingsPageBase clickSelectDateBtn();
}
