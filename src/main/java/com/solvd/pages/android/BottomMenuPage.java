package com.solvd.pages.android;

import com.solvd.pages.base.BottomMenuPageBase;
import com.solvd.pages.base.CalendarPageBase;
import com.solvd.pages.base.SideMenuPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.solvd.pages.utils.PageUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BottomMenuPageBase.class)
public class BottomMenuPage extends BottomMenuPageBase {

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id,'tasks_img')]")
    private ExtendedWebElement tasksBtn;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id,'calendar_img')]")
    private ExtendedWebElement calendarBtn;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id,'ic_menu')]")
    private ExtendedWebElement menuBtn;

    public BottomMenuPage(WebDriver driver) {
        super(driver);
    }

    public TasksPageBase clickTasksBtn() {
        PageUtils.clickIfNotSelected(tasksBtn);
        return initPage(TasksPageBase.class);
    }

    public CalendarPageBase clickCalendarBtn() {
        PageUtils.clickIfNotSelected(calendarBtn);
        return initPage(CalendarPageBase.class);
    }

    @Override
    public SideMenuPageBase clickMenuBtn() {
        PageUtils.clickIfNotSelected(menuBtn);
        return initPage(SideMenuPageBase.class);
    }
}
