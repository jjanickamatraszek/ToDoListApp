package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SpecialOfferPage extends AbstractPage {

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'toolbar_back')]")
    private ExtendedWebElement closeScreenBtn;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'dialog_close')]")
    private ExtendedWebElement giveUpSpecialOfferPopupCloseBtn;

    public SpecialOfferPage(WebDriver driver) {
        super(driver);
    }

    public SpecialOfferPage clickCloseScreenBtn() {
        closeScreenBtn.click();
        return this;
    }

    public TasksPage closePopup() {
        waitUntil(ExpectedConditions.visibilityOf(giveUpSpecialOfferPopupCloseBtn.getElement()), 5);
        giveUpSpecialOfferPopupCloseBtn.click();
        return new TasksPage(getDriver());
    }
}
