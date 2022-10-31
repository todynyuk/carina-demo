package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.AutoLights;
import com.qaprosoft.carina.demo.web.gui.common.AutoLightsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AutoLightsPageBase.class)
public class AutoLightsPage extends AutoLightsPageBase {

    @FindBy(xpath = "//span[@class='portal-navigation__link-text' and contains(., '%s')]")
    private ExtendedWebElement universalMenuCategoriesLink;

    public AutoLightsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage clickOnDeviceCategoryLink(AutoLights linkName) {
        universalMenuCategoriesLink.format(linkName.getNamePage()).click();
        return initPage(getDriver(), linkName.getPageClass());
    }

    @Override
    public String getCategoryText(AutoLights linkName) {
        return universalMenuCategoriesLink.format(linkName.getNamePage()).getText();
    }
}
