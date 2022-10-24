package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.AutoLights;
import org.openqa.selenium.WebDriver;

public abstract class AutoLightsPageBase extends AbstractPage {

    public AutoLightsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage clickOnDeviceCategoryLink(AutoLights linkName);

    public abstract String getCategoryText(AutoLights linkName);
}
