package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class SpecialOfferPageBase extends BaseToDoListAppBase {

    protected SpecialOfferPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SpecialOfferPopupPageBase clickCloseScreenBtn();
}
