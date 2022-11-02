package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.DeviceUseState;
import com.qaprosoft.carina.demo.web.enums.ItemState;
import com.qaprosoft.carina.demo.web.enums.VideoCardType;

public abstract class NotebooksPageBase extends AbstractPage {

    public NotebooksPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickBrandOrSsdStorageCapacityCheckbox(String parameter);

    public abstract void setPriceLimit(int index, String limitPrice);

    public abstract void clickOkButton();

    public abstract void clickVideoCardTypeCheckBox(VideoCardType videoCardTypeEnum);

    public abstract void clickDeviceUseStateCheckbox(DeviceUseState useState);

    public abstract void clickItemAvailableCheckbox(ItemState status);

    public abstract boolean verifySearchByChosenBrand(String brandName);

    public abstract boolean verifySearchByIsNotAvailableLaptops(int index);

    public abstract boolean verifySortByCustomMaximumPrice(String maxPriceValue);

    public abstract String getChosenProductText(int index);

    public abstract DevicePageBase clickLinkMoreAboutDevice(int index);
}
