package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksAndComputersPageBase;
import com.qaprosoft.carina.demo.web.enums.ComputersCategories;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NotebooksAndComputersPageBase.class)
public class NotebooksAndComputersPage extends NotebooksAndComputersPageBase {

    @FindBy(xpath = "//a[contains(@class,'tile-cats__heading') and contains(.,'%s')]")
    private ExtendedWebElement universalMenuCategoriesLink;

    public NotebooksAndComputersPage(WebDriver driver) {
        super(driver);
        setPageURL("computers-notebooks/c80253/");
    }

    @Override
    public AbstractPage clickOnDeviceCategoryLink(ComputersCategories linkName) {
        universalMenuCategoriesLink.format(linkName.getNamePage()).click();
        return initPage(getDriver(), linkName.getPageClass());
    }
}
