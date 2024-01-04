package com.solvd.pages.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SpecialOfferPopupPageBase extends AbstractPage {

    protected SpecialOfferPopupPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TasksPageBase closePopup();
}
