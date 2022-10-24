package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.DispensationPointsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DispensationPointsPageBase.class)
public class DispensationPointsPage extends DispensationPointsPageBase {

    @FindBy(xpath = "//button[contains(@class,'tags__toggle') and contains(.,'Показати ще')]")
    private ExtendedWebElement showMoreButton;

    @FindBy(xpath = "//a[@class='tags__link' and contains(.,'%s')]")
    private ExtendedWebElement chooseCityButton;

    @FindBy(xpath = "//h1[@class='contacts-section__heading']")
    private ExtendedWebElement dispensationPointsTitleText;

    @FindBy(xpath = "//h1[contains(@class,'static-page__heading')]")
    private ExtendedWebElement pickupPointsTitleText;

    public DispensationPointsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDispensationPointsTitleTextPresent() {
        return dispensationPointsTitleText.isElementPresent();
    }

    @Override
    public void clickChooseCityButton(String cityName) {
        showMoreButton.click();
        chooseCityButton.format(cityName).click();
    }

    @Override
    public boolean isDispensationPointsTitleTextContainsChosenCity(String cityName) {
        return dispensationPointsTitleText.getText().contains(cityName);
    }

    @Override
    public boolean isPickUpPointsTitleTextContainsChosenCity(String cityName) {
        return pickupPointsTitleText.getText().contains(cityName);
    }
}
