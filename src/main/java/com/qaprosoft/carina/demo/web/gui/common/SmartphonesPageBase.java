package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.utils.ItemStateEnum;
import org.openqa.selenium.WebDriver;

public abstract class SmartphonesPageBase extends AbstractPage {

    public SmartphonesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void brandCheckBoxClick(String brandName);

    public abstract void ramButtonClick(String ram);

    public abstract void materialCheckBoxClick(String material);

    public abstract void colorCheckBoxClick(String color);

    public abstract void itemAvailableCheckboxClick(ItemStateEnum status);

    public abstract Integer getSmartphonePriceText(int index);

    public abstract boolean checkIsChooseColorPresentInDescription(String colorEnglishVersion, int index);

    public abstract DevicePageBase linkMoreAboutDeviceClick(int index);
}
