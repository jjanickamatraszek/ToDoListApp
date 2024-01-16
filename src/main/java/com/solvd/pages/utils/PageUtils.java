package com.solvd.pages.utils;

import com.solvd.pages.base.SpecialOfferPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.solvd.pages.base.WelcomePageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import io.appium.java_client.HasSettings;
import io.appium.java_client.Setting;

public class PageUtils implements ICustomTypePageFactory {

    public TasksPageBase goToTaskPage() {
        WelcomePageBase welcomePage = initPage(WelcomePageBase.class);
        SpecialOfferPageBase specialOfferPage = welcomePage.clickContinueBtn();
        specialOfferPage.clickCloseScreenBtn().closePopup();
        return initPage(TasksPageBase.class);
    }

    public void setImageMatchThreshold(double value) {
        HasSettings driver = (HasSettings) getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, value);
    }
}
