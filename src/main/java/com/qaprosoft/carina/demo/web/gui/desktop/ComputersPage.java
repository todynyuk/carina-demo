package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.ComputersPageBase;
import com.qaprosoft.carina.demo.web.gui.common.DevicePageBase;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ComputersPageBase.class)
public class ComputersPage extends ComputersPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckBox;

    @FindBy(xpath = "//a[contains(@class,'checkbox-filter__link') and contains(., '%s')]")
    private ExtendedWebElement universalCheckBoxWithCyrillic;

    @FindBy(xpath = "//span[@class='sidebar-block__toggle-title' and contains (., '%s')]/..")
    private ExtendedWebElement universalShowCheckBoxButton;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> linksListMoreAboutDevice;

    @FindBy(xpath = "//div[contains(@class,'goods-tile__availability')]")
    private List<ExtendedWebElement> readyToSendDeviceStratusList;

    public ComputersPage(WebDriver driver) {
        super(driver);
        setPageURL("computers/c80095/");
    }

    @Override
    public void clickUniversalShowCheckBoxButton(String parameter) {
        universalShowCheckBoxButton.format(parameter).sendKeys(Keys.PAGE_DOWN);
        universalShowCheckBoxButton.format(parameter).click();
    }

    @Override
    public void clickСheckBoxWithCyrillic(String parameter) {
        universalCheckBoxWithCyrillic.format(parameter).click();
    }

    @Override
    public void clickUniversalCheckBox(String parameter) {
        universalCheckBox.format(parameter).click();
    }

    @Override
    public DevicePageBase clickLinkMoreAboutDevice(int index) {
        linksListMoreAboutDevice.get(index).sendKeys(Keys.PAGE_UP);
        linksListMoreAboutDevice.get(index).click();
        return initPage(getDriver(), DevicePageBase.class);
    }

    @Override
    public boolean verifyReadyToSendDevicesStatus(String param) {
        return readyToSendDeviceStratusList.stream().allMatch((model) -> StringUtils.containsIgnoreCase(model.getText(), param));
    }
}
