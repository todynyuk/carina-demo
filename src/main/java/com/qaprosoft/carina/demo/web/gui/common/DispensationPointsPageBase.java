package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DispensationPointsPageBase extends AbstractPage {

    public DispensationPointsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDispensationPointsTitleTextPresent();

    public abstract void clickChooseCityButton(String cityName);

    public abstract boolean isDispensationPointsTitleTextContainsChosenCity(String cityName);

    public abstract boolean isPickUpPointsTitleTextContainsChosenCity(String cityName);
}
