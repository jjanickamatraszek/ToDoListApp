package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends BaseToDoListAppBase {

    protected WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SpecialOfferPageBase clickContinueBtn();
}
