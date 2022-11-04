package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.demo.web.gui.common.PcAndLaptopsChosenBrandPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksAndComputersPageBase;
import com.qaprosoft.carina.demo.web.enums.ComputersCategories;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NotebooksAndComputersPageBase.class)
public class NotebooksAndComputersPage extends NotebooksAndComputersPageBase {

    @FindBy(xpath = "//li[contains(@class,'breadcrumbs__item')]/span")
    private ExtendedWebElement titleCategoryText;

    @FindBy(xpath = "//h1[contains(@class,'portal__heading')]")
    private ExtendedWebElement pageTitleText;

    @FindBy(xpath = "//a[contains(@class,'tile-cats__heading') and contains(.,'%s')]")
    private ExtendedWebElement universalMenuCategoriesLink;

    @FindBy(xpath = "//li[contains(@class,'simple-slider__item')]//a[contains(@href,'%s')]")
    private ExtendedWebElement universalSliderCategoriesLink;

    public NotebooksAndComputersPage(WebDriver driver) {
        super(driver);
        setPageURL("computers-notebooks/c80253/");
    }

    @Override
    public String getCategoryTitleText() {
        return titleCategoryText.getText();
    }

    @Override
    public String getPageTitleText() {
        return pageTitleText.getText();
    }

    @Override
    public AbstractPage clickOnDeviceCategoryLink(ComputersCategories linkName) {
        universalMenuCategoriesLink.format(linkName.getNamePage()).click();
        return initPage(getDriver(), linkName.getPageClass());
    }

    @Override
    public PcAndLaptopsChosenBrandPageBase clickOnSliderBrandLink(String param) {
        universalSliderCategoriesLink.format(param).click();
        return initPage(getDriver(), PcAndLaptopsChosenBrandPageBase.class);
    }
}
