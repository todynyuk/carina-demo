package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.HomePageBase;
import com.qaprosoft.carina.demo.web.enums.CategoriesMenuEnum;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "fat-menu")
    private ExtendedWebElement burgerMenuButton;

    @FindBy(xpath = "//a[@class='menu-categories__link' and contains(.,'%s')]")
    private ExtendedWebElement universalMenuCategoriesLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AbstractPage clickOnCategoryLink(CategoriesMenuEnum linkName) {
        universalMenuCategoriesLink.format(linkName.getNamePage()).click();
        return initPage(getDriver(), linkName.getPageClass());
    }
}
