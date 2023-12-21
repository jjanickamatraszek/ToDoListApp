package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {

    @FindBy(xpath = ".//android.widget.FrameLayout[contains(@resource-id, 'welcome_start')]")
    private ExtendedWebElement continueBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public SpecialOfferPage clickContinueBtn() {
        continueBtn.click();
        return new SpecialOfferPage(getDriver());
    }
}
