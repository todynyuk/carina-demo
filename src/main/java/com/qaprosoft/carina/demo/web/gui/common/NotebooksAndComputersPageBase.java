package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.utils.ComputersCategoriesEnum;
import org.openqa.selenium.WebDriver;

public abstract class NotebooksAndComputersPageBase extends AbstractPage {

    public NotebooksAndComputersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage clickOnDeviceCategoryLink(ComputersCategoriesEnum linkName);
}
