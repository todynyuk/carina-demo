package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.DropdownFilterOptions;
import com.qaprosoft.carina.demo.web.gui.components.ShoppingBasket;
import org.openqa.selenium.WebDriver;

public abstract class DrlPageBase extends AbstractPage {

    public DrlPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCategoryText();

    public abstract Integer getAddedToCartGoodsCounterValue();

    public abstract boolean isAddedToCartGoodsCounterTextPresent();

    public abstract String getListMoreAboutDeviceLinkText(int index);

    public abstract Integer getItemPriceValue(int index);

    public abstract void clickBuyButtonByIndex(int index);

    public abstract void clickDropdownOption(DropdownFilterOptions drl);

    public abstract boolean isAllGoodsSortedFromLowToHighPrice();

    public abstract boolean isAllGoodsSortedFromHighToLowPrice();

    public abstract void clickOnShoppingBasketButton();

    public abstract ShoppingBasket getBasketMenu();
}
