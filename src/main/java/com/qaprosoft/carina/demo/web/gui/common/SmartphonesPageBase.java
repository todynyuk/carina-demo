package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.ItemState;

public abstract class SmartphonesPageBase extends AbstractPage {

    public SmartphonesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickUniversalCheckBox(String parameter);

    public abstract void clickUniversalRomStorageCapacityButton(String parameter);

    public abstract void clickItemAvailableCheckbox(ItemState status);

    public abstract void clickСheckBoxWithCyrillic(String parameter);

    public abstract Integer getSmartphonePriceText(int index);

    public abstract boolean checkIsChooseColorPresentInDescription(String colorEnglishVersion, int index);

    public abstract DevicePageBase clickLinkMoreAboutDevice(int index);
}
