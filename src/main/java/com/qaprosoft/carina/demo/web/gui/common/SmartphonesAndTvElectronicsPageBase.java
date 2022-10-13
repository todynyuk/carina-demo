package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.utils.SmartphonesAndElectronicsCategoriesEnum;
import org.openqa.selenium.WebDriver;

public abstract class SmartphonesAndTvElectronicsPageBase extends AbstractPage {

    public SmartphonesAndTvElectronicsPageBase(WebDriver driver) {
        super(driver);

    }

    public abstract AbstractPage clickOnDeviceCategoryLink(SmartphonesAndElectronicsCategoriesEnum linkName);
}
