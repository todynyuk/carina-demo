package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.demo.web.gui.components.ShoppingBasket;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.DevicePageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DevicePageBase.class)
public class DevicePage extends DevicePageBase {

    @FindBy(xpath = "//li[contains(@class,'product')]/*/*/*//span[contains(@class,'buy')]")
    private ExtendedWebElement buyButton;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder')]")
    private ExtendedWebElement basketPopUpWindow;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder--large')]")
    private ShoppingBasket shoppingBasket;

    @FindBy(xpath = "//button[contains(@class,'header__button--active')]")
    private ExtendedWebElement basketButton;

    @FindBy(xpath = "//p[@class='product-prices__big']")
    private ExtendedWebElement chosenProductPriceText;

    @FindBy(xpath = "//p[@class='status-label status-label--green ng-star-inserted']")
    private ExtendedWebElement isAvailableText;

    @FindBy(xpath = "//h1[@class='product__title']")
    private ExtendedWebElement shortDeviceCharacteristicsText;

    @FindBy(xpath = "//p[@class='product-about__brief ng-star-inserted']")
    private ExtendedWebElement aboutDeviceCharacteristicsText;

    @FindBy(xpath = "//h3[@class='product-tabs__heading']//span[@class='product-tabs__heading_color_gray']")
    private ExtendedWebElement descriptionDeviceCharacteristicsText;

    public DevicePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean verifyChosenColor(String color) {
        return StringUtils.containsIgnoreCase(shortDeviceCharacteristicsText.getText(), color);
    }

    @Override
    public Integer getSmartphonePriceText() {
        return Integer.valueOf(chosenProductPriceText.getText().replace(" ", "")
                .replaceAll("[^0-9?!\\\\.]", ""));
    }

    @Override
    public boolean verifyChosenRamInShortCharacteristics(String param) {
        return StringUtils.containsIgnoreCase(shortDeviceCharacteristicsText.getText(), param);
    }

    @Override
    public boolean verifyChosenParameterInShortCharacteristics(String param) {
        return StringUtils.containsIgnoreCase(aboutDeviceCharacteristicsText.getText(), param);
    }

    @Override
    public boolean verifyChosenParamInAllCharacteristics(String param) {
        return StringUtils.containsIgnoreCase(descriptionDeviceCharacteristicsText.getText(), param);
    }

    @Override
    public boolean isAvailableTextPresent() {
        return isAvailableText.isElementPresent();
    }

    @Override
    public void clickOnBuyButton() {
        buyButton.click();
        if (!basketPopUpWindow.isElementPresent(2)) {
            basketButton.click();
        }
    }

    @Override
    public boolean isPopUpWindowPresent() {
        return basketPopUpWindow.isElementPresent();
    }

    @Override
    public ShoppingBasket getBasketMenu() {
        return shoppingBasket;
    }
}
