package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SpecialOfferPage extends AbstractPage {

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'toolbar_back')]")
    private ExtendedWebElement closeScreenBtn;

    public SpecialOfferPage(WebDriver driver) {
        super(driver);
    }

    public SpecialOfferPopupPage clickCloseScreenBtn() {
        closeScreenBtn.click();
        return new SpecialOfferPopupPage(getDriver());
    }
}
