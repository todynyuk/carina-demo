package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.DevicePageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DevicePageBase.class)
public class DevicePage extends DevicePageBase {

    @FindBy(xpath = "//p[@class='product-prices__big']")
    private ExtendedWebElement chosenProductPriceText;

    @FindBy(xpath = "//h1[@class='product__title']")
    private ExtendedWebElement shortSmartphoneCharacteristicsText;

    @FindBy(xpath = "//h3[@class='product-tabs__heading']//span[@class='product-tabs__heading_color_gray']")
    private ExtendedWebElement descriptionSmartphoneCharacteristicsText;

    public DevicePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean verifyChosenColor(String color) {
        return StringUtils.containsIgnoreCase(shortSmartphoneCharacteristicsText.getText(), color);
    }

    @Override
    public Integer getSmartphonePriceText() {
        return Integer.valueOf(chosenProductPriceText.getText().replace(" ", "").replaceAll("[^0-9?!\\\\.]", ""));
    }

    @Override
    public boolean verifyChosenRamInShortCharacteristics(String ram) {
        return StringUtils.containsIgnoreCase(shortSmartphoneCharacteristicsText.getText(), ram);
    }

    @Override
    public boolean verifyChosenRamInAllCharacteristics(String ram) {
        return StringUtils.containsIgnoreCase(descriptionSmartphoneCharacteristicsText.getText(), ram);
    }
}
