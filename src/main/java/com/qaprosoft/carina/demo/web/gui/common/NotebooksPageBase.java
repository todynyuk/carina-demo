package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.DeviceUseStateEnum;
import com.qaprosoft.carina.demo.web.enums.ItemStateEnum;
import com.qaprosoft.carina.demo.web.enums.VideoCardTypeEnum;

public abstract class NotebooksPageBase extends AbstractPage {

    public NotebooksPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void brandOrSsdStorageCapacityCheckboxClick(String parameter);

    public abstract void setPriceLimit(int index, String limitPrice);

    public abstract void okButtonClick();

    public abstract void videoCardTypeCheckBoxClick(VideoCardTypeEnum videoCardTypeEnum);

    public abstract void deviceUseStateCheckboxClick(DeviceUseStateEnum useState);

    public abstract void itemAvailableCheckboxClick(ItemStateEnum status);

    public abstract boolean verifySearchByChosenBrand(String brandName);

    public abstract boolean verifySearchByIsNotAvailableLaptops(int index);

    public abstract boolean verifySortByCustomMaximumPrice(String maxPriceValue);

    public abstract DevicePageBase linkMoreAboutDeviceClick(int index);
}
