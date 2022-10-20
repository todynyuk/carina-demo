package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.DevicePageBase;
import com.qaprosoft.carina.demo.web.gui.common.SmartphonesPageBase;
import com.qaprosoft.carina.demo.web.enums.ItemState;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SmartphonesPageBase.class)
public class SmartphonesPage extends SmartphonesPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckBox;

    @FindBy(xpath = "//a[contains(@class,'checkbox-filter__link') and contains(., '%s')]")
    private ExtendedWebElement universalCheckBoxWithCyrillic;

    @FindBy(xpath = "//a[@class='tile-filter__link' and contains(.,'%s')]")
    private ExtendedWebElement universalRomStorageCapacityButton;

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<ExtendedWebElement> priceSmartphoneText;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> shortDeviceCharacteristicsList;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> linksListMoreAboutDevice;

    public SmartphonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickUniversalCheckBox(String parameter) {
        universalCheckBox.format(parameter).click();
    }

    @Override
    public void clickUniversalRomStorageCapacityButton(String parameter) {
        universalRomStorageCapacityButton.format(parameter).click();
    }

    @Override
    public void clickItemAvailableCheckbox(ItemState status) {
        universalCheckBox.format(status.getDeviceUseState()).click();
    }

    @Override
    public void clickСheckBoxWithCyrillic(String parameter) {
        universalCheckBoxWithCyrillic.format(parameter).click();
    }

    @Override
    public Integer getSmartphonePriceText(int index) {
        linksListMoreAboutDevice.get(index).sendKeys(Keys.PAGE_UP);
        return Integer.valueOf(priceSmartphoneText.get(index).getText().replace(" ", ""));
    }

    @Override
    public boolean checkIsChooseColorPresentInDescription(String colorEnglishVersion, int index) {
        return shortDeviceCharacteristicsList.get(index).getText().contains(colorEnglishVersion);
    }

    @Override
    public DevicePageBase clickLinkMoreAboutDevice(int index) {
        linksListMoreAboutDevice.get(index).click();
        return initPage(getDriver(), DevicePageBase.class);
    }
}
