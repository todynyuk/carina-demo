package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.demo.web.enums.AutoCategories;
import com.qaprosoft.carina.demo.web.enums.ComputersCategories;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class ToolsAndAutoProductsPageBase extends AbstractPage {

    public ToolsAndAutoProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage clickOnDeviceCategoryLink(AutoCategories linkName);
}
