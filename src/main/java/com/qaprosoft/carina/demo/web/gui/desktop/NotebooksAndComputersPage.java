package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksAndComputersPageBase;
import com.qaprosoft.carina.demo.web.utils.ComputersCategoriesEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NotebooksAndComputersPageBase.class)
public class NotebooksAndComputersPage extends NotebooksAndComputersPageBase {

    @FindBy(xpath = "//a[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted' and contains(.,' %s ')]")
    private ExtendedWebElement universalMenuCategoriesLink;

    public NotebooksAndComputersPage(WebDriver driver) {
        super(driver);
        setPageURL("computers-notebooks/c80253/");
    }

    @Override
    public AbstractPage clickOnDeviceCategoryLink(ComputersCategoriesEnum linkName) {
        universalMenuCategoriesLink.format(linkName.getNamePage()).click();
        return initPage(getDriver(), linkName.getPageClass());
    }
}
