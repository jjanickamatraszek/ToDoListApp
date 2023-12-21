package com.solvd.pages;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class PageUtils implements ICustomTypePageFactory {

    public TasksPage goToTaskPage() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        SpecialOfferPage specialOfferPage = welcomePage.clickContinueBtn();
        specialOfferPage.clickCloseScreenBtn().closePopup();
        return new TasksPage(getDriver());
    }
}
