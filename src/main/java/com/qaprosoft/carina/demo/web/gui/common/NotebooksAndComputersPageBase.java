package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.ComputersCategories;

public abstract class NotebooksAndComputersPageBase extends AbstractPage {

    public NotebooksAndComputersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCategoryTitleText();

    public abstract String getPageTitleText();

    public abstract AbstractPage clickOnDeviceCategoryLink(ComputersCategories linkName);

    public abstract PcAndLaptopsChosenBrandPageBase clickOnSliderBrandLink(String param);
}
