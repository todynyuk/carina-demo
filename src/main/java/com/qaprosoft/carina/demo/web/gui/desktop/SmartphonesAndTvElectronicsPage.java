package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.SmartphonesAndTvElectronicsPageBase;
import com.qaprosoft.carina.demo.web.enums.SmartphonesAndElectronicsCategoriesEnum;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SmartphonesAndTvElectronicsPageBase.class)
public class SmartphonesAndTvElectronicsPage extends SmartphonesAndTvElectronicsPageBase {

    @FindBy(xpath = "//a[contains(@class,'tile-cats__heading') and contains(.,'%s')]")
    private ExtendedWebElement universalMenuCategoriesLink;

    public SmartphonesAndTvElectronicsPage(WebDriver driver) {
        super(driver);
        setPageURL("telefony-tv-i-ehlektronika/c4627949/");
    }

    @Override
    public AbstractPage clickOnDeviceCategoryLink(SmartphonesAndElectronicsCategoriesEnum linkName) {
        universalMenuCategoriesLink.format(linkName.getNamePage()).click();
        return initPage(getDriver(), linkName.getPageClass());
    }
}
