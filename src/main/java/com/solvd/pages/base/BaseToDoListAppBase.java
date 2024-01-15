package com.solvd.pages.base;

import com.solvd.pages.utils.PageUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BaseToDoListAppBase extends AbstractPage implements IMobileUtils {

    protected PageUtils pageUtils;

    protected BaseToDoListAppBase(WebDriver driver) {
        super(driver);
        pageUtils = new PageUtils();
    }
}
