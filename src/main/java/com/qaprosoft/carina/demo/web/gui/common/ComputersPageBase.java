package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class ComputersPageBase extends AbstractPage {

    public ComputersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void universalShowCheckBoxButtonClick(String parameter);

    public abstract void checkBoxWithCyrillicClick(String parameter);

    public abstract void universalCheckBoxClick(String parameter);

    public abstract DevicePageBase linkMoreAboutDeviceClick(int index);
}
