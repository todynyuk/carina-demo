package com.qaprosoft.carina.demo.web.gui.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(id = "fat-menu")
    private ExtendedWebElement catalogButton;

    @FindBy(xpath = "//a[contains(@class, 'js-menu-categories__link') and contains(.,'%s')]")
    private ExtendedWebElement universalCategoryMenu;

    @FindBy(xpath = "//input[contains(@class, 'search-form__input')]")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit')]")
    private ExtendedWebElement searchBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isCatalogButtonClickable(){
       return  catalogButton.isClickable();
    }

    public void clickCatalogButton(){
        catalogButton.click();
    }

    public  boolean isSelectedSectionVisible(MenuCategory menuCategory){
       return universalCategoryMenu.format(menuCategory.getNamePage()).isVisible();
    }

    public AbstractPage clickOnCategoryMenu(MenuCategory menuCategory) {
        universalCategoryMenu.format(menuCategory.getNamePage()).click();
        return initPage(getDriver(), menuCategory.getPageClass());
    }

    public SearchPageBase searchItems(String param) {
        searchInput.type(param);
        searchBtn.click();
        return initPage(getDriver(), SearchPageBase.class);
    }
}
