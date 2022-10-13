package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.utils.DeviceUseStateEnum;
import com.qaprosoft.carina.demo.web.utils.ItemStateEnum;
import com.qaprosoft.carina.demo.web.utils.VideoCardTypeEnum;
import org.openqa.selenium.WebDriver;

public abstract class NotebooksPageBase extends AbstractPage {

    public NotebooksPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void brandCheckBoxClick(String brandName);

    public abstract void setSsdStorageCapacityCheckboxClick(String laptopSsdStorageCapacityValue);

    public abstract void setPriceLimit(int index, String limitPrice);

    public abstract void okButtonClick();

    public abstract void videoCardTypeCheckBoxClick(VideoCardTypeEnum videoCardTypeEnum);

    public abstract void deviceUseStateCheckboxClick(DeviceUseStateEnum useState);

    public abstract void itemAvailableCheckboxClick(ItemStateEnum status);

    public abstract boolean verifySearchByChosenBrand(String brandName);

    public abstract boolean verifySearchByIsNotAvailableLaptops();

    public abstract boolean verifySortByCustomMaximumPrice(String maxPriceValue);
}
