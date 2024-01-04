package com.solvd.pages.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {

    protected WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SpecialOfferPageBase clickContinueBtn();
}
