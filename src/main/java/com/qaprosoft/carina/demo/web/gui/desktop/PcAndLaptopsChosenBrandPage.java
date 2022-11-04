package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.DevicePageBase;
import com.qaprosoft.carina.demo.web.gui.common.PcAndLaptopsChosenBrandPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PcAndLaptopsChosenBrandPageBase.class)
public class PcAndLaptopsChosenBrandPage extends PcAndLaptopsChosenBrandPageBase {

    @FindBy(xpath = "//h1[@class='catalog-heading']")
    private ExtendedWebElement pageTitleText;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> linksListMoreAboutDevice;

    public PcAndLaptopsChosenBrandPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageTitleContainsChosenParameters(String param) {
        return pageTitleText.getText().contains(param);
    }

    @Override
    public String getProductText(int index) {
        return linksListMoreAboutDevice.get(index).getText();
    }

    @Override
    public DevicePageBase clickLinkMoreAboutDevice(int index) {
        linksListMoreAboutDevice.get(index).click();
        return initPage(getDriver(), DevicePageBase.class);
    }
}
