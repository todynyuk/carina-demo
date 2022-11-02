package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.demo.web.gui.components.ShoppingBasket;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class DevicePageBase extends AbstractPage {

    public DevicePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean verifyChosenColor(String color);

    public abstract Integer getSmartphonePriceText();

    public abstract boolean verifyChosenRamInShortCharacteristics(String ram);

    public abstract boolean verifyChosenParameterInShortCharacteristics(String param);

    public abstract boolean verifyChosenParamInAllCharacteristics(String ram);

    public abstract boolean verifyIsAvailableTextPresent();

    public abstract ShoppingBasket clickOnBuyButton();
}
