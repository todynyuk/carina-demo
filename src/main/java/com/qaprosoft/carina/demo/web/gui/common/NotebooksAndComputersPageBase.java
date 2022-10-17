package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.ComputersCategoriesEnum;

public abstract class NotebooksAndComputersPageBase extends AbstractPage {

    public NotebooksAndComputersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage clickOnDeviceCategoryLink(ComputersCategoriesEnum linkName);
}
