package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DevicePageBase extends AbstractPage {

    public DevicePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean verifyChosenColor(String color);

    public abstract Integer getSmartphonePriceText();

    public abstract boolean verifyChosenRamInShortCharacteristics(String ram);

    public abstract boolean verifyChosenRamInAllCharacteristics(String ram);
}
