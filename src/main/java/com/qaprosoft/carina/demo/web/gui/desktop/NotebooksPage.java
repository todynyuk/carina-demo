package com.qaprosoft.carina.demo.web.gui.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksPageBase;
import com.qaprosoft.carina.demo.web.enums.DeviceUseStateEnum;
import com.qaprosoft.carina.demo.web.enums.ItemStateEnum;
import com.qaprosoft.carina.demo.web.enums.VideoCardTypeEnum;
import com.qaprosoft.carina.demo.web.gui.common.DevicePageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NotebooksPageBase.class)
public class NotebooksPage extends NotebooksPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckBox;

    @FindBy(xpath = "//input[contains(@class,'slider-filter__input')]")
    private List<ExtendedWebElement> priceInputFields;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> searchBrandList;

    @FindBy(xpath = "//div[contains(@class, 'goods-tile__availability') and contains(.,' Немає в наявності ')]")
    private List<ExtendedWebElement> notAvailableText;

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<ExtendedWebElement> priceLaptopText;

    @FindBy(xpath = "//button[contains(@class,'slider-filter__button')]")
    private ExtendedWebElement okButton;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> linksListMoreAboutDevice;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public NotebooksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void brandOrSsdStorageCapacityCheckboxClick(String parameter) {
        universalCheckBox.format(parameter).click();
    }

    @Override
    public void setPriceLimit(int index, String limitPrice) {
        priceInputFields.get(index).type(limitPrice);
    }

    @Override
    public void okButtonClick() {
        okButton.click();
    }

    @Override
    public void videoCardTypeCheckBoxClick(VideoCardTypeEnum videoCardTypeEnum) {
        universalCheckBox.format(videoCardTypeEnum.getVideoCardType()).click();
    }

    @Override
    public void deviceUseStateCheckboxClick(DeviceUseStateEnum useState) {
        universalCheckBox.format(useState.getDeviceUseState()).click();
    }

    @Override
    public void itemAvailableCheckboxClick(ItemStateEnum status) {
        universalCheckBox.format(status.getDeviceUseState()).click();
    }

    @Override
    public boolean verifySearchByChosenBrand(String brandName) {
        boolean result = false;
        for (ExtendedWebElement model : searchBrandList) {
            result = (StringUtils.containsIgnoreCase(model.getText(), brandName));
        }
        return result;
    }

    @Override
    public boolean verifySearchByIsNotAvailableLaptops(int index) {
        linksListMoreAboutDevice.get(index).sendKeys(Keys.PAGE_UP);
        return notAvailableText.size() == 0;
    }

    @Override
    public boolean verifySortByCustomMaximumPrice(String maxPriceValue) {
        boolean result = false;
        int customMaxPrice = Integer.valueOf(maxPriceValue);
        int priceFromList;
        for (ExtendedWebElement price : priceLaptopText) {
            priceFromList = Integer.valueOf(price.getText().replace(" ", ""));
            result = (priceFromList <= customMaxPrice);
        }
        return result;
    }

    @Override
    public DevicePageBase linkMoreAboutDeviceClick(int index) {
        linksListMoreAboutDevice.get(index).click();
        return initPage(getDriver(), DevicePageBase.class);
    }
}
