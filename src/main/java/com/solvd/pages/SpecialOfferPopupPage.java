package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SpecialOfferPopupPage extends AbstractPage {

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'dialog_close')]")
    private ExtendedWebElement giveUpSpecialOfferPopupCloseBtn;

    public SpecialOfferPopupPage(WebDriver driver) {
        super(driver);
    }

    public TasksPage closePopup() {
        giveUpSpecialOfferPopupCloseBtn.click();
        return new TasksPage(getDriver());
    }
}
