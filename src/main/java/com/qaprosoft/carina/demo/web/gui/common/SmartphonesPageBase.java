package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.ItemStateEnum;

public abstract class SmartphonesPageBase extends AbstractPage {

    public SmartphonesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void universalCheckBoxClick(String parameter);

    public abstract void universalRomStorageCapacityButtonClick(String parameter);

    public abstract void itemAvailableCheckboxClick(ItemStateEnum status);

    public abstract void checkBoxWithCyrillicClick(String parameter);

    public abstract Integer getSmartphonePriceText(int index);

    public abstract boolean checkIsChooseColorPresentInDescription(String colorEnglishVersion, int index);

    public abstract DevicePageBase linkMoreAboutDeviceClick(int index);
}
