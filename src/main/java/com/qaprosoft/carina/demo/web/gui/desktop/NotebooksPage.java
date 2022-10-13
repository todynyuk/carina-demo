package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksPageBase;
import com.qaprosoft.carina.demo.web.utils.DeviceUseStateEnum;
import com.qaprosoft.carina.demo.web.utils.ItemStateEnum;
import com.qaprosoft.carina.demo.web.utils.VideoCardTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NotebooksPageBase.class)
public class NotebooksPage extends NotebooksPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalLaptopBrandCheckBox;

    @FindBy(xpath = "//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid']")
    private List<ExtendedWebElement> priceInputFields;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> searchBrandList;

    @FindBy(xpath = "//div[@class='goods-tile__availability goods-tile__availability--unavailable ng-star-inserted' and contains(.,' Немає в наявності ')]")
    private List<ExtendedWebElement> notAvailableText;

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<ExtendedWebElement> priceLaptopText;

    @FindBy(xpath = "//button[@class='button button_color_gray button_size_small slider-filter__button']")
    private ExtendedWebElement okButton;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalDeviceUseStateCheckBox;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalAvailableStateCheckBox;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalVideoCardTypeCheckBox;

    @FindBy(xpath = "//span[@class='sidebar-block__toggle-title' and contains(.,' Обсяг SSD ')]//../following-sibling::*[@class='sidebar-block__inner ng-star-inserted']/*/*/*/*/*/*/*/*/a[@class='checkbox-filter__link' and contains(.,'%s')]")
    private ExtendedWebElement ssdStorageCapacityCheckBox;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public NotebooksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void brandCheckBoxClick(String brandName) {
        universalLaptopBrandCheckBox.format(brandName).click();
    }

    @Override
    public void setSsdStorageCapacityCheckboxClick(String laptopSsdStorageCapacityValue) {
        ssdStorageCapacityCheckBox.format(laptopSsdStorageCapacityValue).click();
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
        universalVideoCardTypeCheckBox.format(videoCardTypeEnum.getVideoCardType()).click();
    }

    @Override
    public void deviceUseStateCheckboxClick(DeviceUseStateEnum useState) {
        universalDeviceUseStateCheckBox.format(useState.getDeviceUseState()).click();
    }

    @Override
    public void itemAvailableCheckboxClick(ItemStateEnum status) {
        universalAvailableStateCheckBox.format(status.getDeviceUseState()).click();
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
    public boolean verifySearchByIsNotAvailableLaptops() {
        boolean result = false;
        for (ExtendedWebElement item : notAvailableText) {
            result = (item.isElementPresent());
        }
        return result;
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
}
