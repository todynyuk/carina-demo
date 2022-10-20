package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.AutoCategories;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.web.gui.common.ToolsAndAutoProductsPageBase;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ToolsAndAutoProductsPageBase.class)
public class ToolsAndAutoProductsPage extends ToolsAndAutoProductsPageBase {

    @FindBy(xpath = "//a[contains(@class,'tile-cats__heading') and contains(.,'%s')]")
    private ExtendedWebElement universalMenuCategoriesLink;

    public ToolsAndAutoProductsPage(WebDriver driver) {
        super(driver);
        setPageURL("instrumenty-i-avtotovary/c4627858/");
    }

    @Override
    public AbstractPage clickOnDeviceCategoryLink(AutoCategories linkName) {
        universalMenuCategoriesLink.format(linkName.getNamePage()).click();
        return initPage(getDriver(), linkName.getPageClass());
    }
}
