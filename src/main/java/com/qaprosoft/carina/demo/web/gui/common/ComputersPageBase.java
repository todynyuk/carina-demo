package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class ComputersPageBase extends AbstractPage {

    public ComputersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickUniversalShowCheckBoxButton(String parameter);

    public abstract void clickСheckBoxWithCyrillic(String parameter);

    public abstract void clickUniversalCheckBox(String parameter);

    public abstract DevicePageBase clickLinkMoreAboutDevice(int index);

    public abstract boolean verifyReadyToSendDevicesStatus(String param);
}
