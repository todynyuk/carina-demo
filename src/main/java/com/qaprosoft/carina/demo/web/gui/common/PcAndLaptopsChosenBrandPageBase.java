package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PcAndLaptopsChosenBrandPageBase extends AbstractPage {

    public PcAndLaptopsChosenBrandPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageTitleContainsChosenParameters(String param);

    public abstract String getProductText(int index);

    public abstract DevicePageBase clickLinkMoreAboutDevice(int index);
}
