package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.web.gui.common.ToolsAndAutoProductsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ToolsAndAutoProductsPageBase.class)
public class ToolsAndAutoProductsPage extends ToolsAndAutoProductsPageBase {

    public ToolsAndAutoProductsPage(WebDriver driver) {
        super(driver);
        setPageURL("instrumenty-i-avtotovary/c4627858/");
    }
}
