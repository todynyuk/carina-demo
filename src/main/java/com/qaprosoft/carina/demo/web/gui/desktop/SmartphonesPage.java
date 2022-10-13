package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.DevicePageBase;
import com.qaprosoft.carina.demo.web.gui.common.SmartphonesPageBase;
import com.qaprosoft.carina.demo.web.utils.ItemStateEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SmartphonesPageBase.class)
public class SmartphonesPage extends SmartphonesPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalSmartphoneBrandCheckBox;

    @FindBy(xpath = "//span[@class='sidebar-block__toggle-title' and contains(.,'Вбудована')]" +
            "/../following-sibling::*[@class='sidebar-block__inner ng-star-inserted']" +
            "/*/*/*/*/*/*/*/*/a[contains(.,'%s')]")
    private ExtendedWebElement universalRamStorageCapacityButton;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement materialSmartphoneCheckBox;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalSmartphoneColorCheckBox;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalAvailableStateCheckBox;

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
    public void brandCheckBoxClick(String brandName) {
        universalSmartphoneBrandCheckBox.format(brandName).click();
    }

    @Override
    public void ramButtonClick(String ram) {
        universalRamStorageCapacityButton.format(ram).click();
    }

    @Override
    public void materialCheckBoxClick(String material) {
        materialSmartphoneCheckBox.format(material).click();
    }

    @Override
    public void colorCheckBoxClick(String color) {
        universalSmartphoneColorCheckBox.format(color).click();
    }

    @Override
    public void itemAvailableCheckboxClick(ItemStateEnum status) {
        universalAvailableStateCheckBox.format(status.getDeviceUseState()).click();
    }

    @Override
    public Integer getSmartphonePriceText(int index) {
        return Integer.valueOf(priceSmartphoneText.get(index).getText().replace(" ", ""));
    }

    @Override
    public boolean checkIsChooseColorPresentInDescription(String colorEnglishVersion, int index) {
        return shortDeviceCharacteristicsList.get(index).getText().contains(colorEnglishVersion);
    }

    @Override
    public DevicePageBase linkMoreAboutDeviceClick(int index) {
        linksListMoreAboutDevice.get(index).click();
        return initPage(getDriver(), DevicePageBase.class);
    }
}
