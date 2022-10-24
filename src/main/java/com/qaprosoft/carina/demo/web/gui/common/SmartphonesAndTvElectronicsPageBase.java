package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.SmartphonesAndElectronicsCategories;

public abstract class SmartphonesAndTvElectronicsPageBase extends AbstractPage {

    public SmartphonesAndTvElectronicsPageBase(WebDriver driver) {
        super(driver);

    }

    public abstract AbstractPage clickOnDeviceCategoryLink(SmartphonesAndElectronicsCategories linkName);
}
