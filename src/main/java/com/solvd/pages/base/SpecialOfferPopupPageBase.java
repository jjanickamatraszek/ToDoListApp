package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class SpecialOfferPopupPageBase extends BaseToDoListAppBase {

    protected SpecialOfferPopupPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TasksPageBase closePopup();
}
