package com.solvd.pages.android;

import com.solvd.pages.base.SideMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideMenuPageBase.class)
public class SideMenuPage extends SideMenuPageBase {

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }
}
