package com.solvd.pages.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SpecialOfferPageBase extends AbstractPage {

    protected SpecialOfferPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SpecialOfferPopupPageBase clickCloseScreenBtn();
}
