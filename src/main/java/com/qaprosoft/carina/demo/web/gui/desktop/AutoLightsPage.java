package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.web.gui.common.AutoLightsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AutoLightsPageBase.class)
public class AutoLightsPage extends AutoLightsPageBase{

    public AutoLightsPage(WebDriver driver) {
        super(driver);
    }
}
