package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.components.ShoppingBasket;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddToBagButton(int index);

    public abstract void clickOnBasketButton();

    public abstract ShoppingBasket getBasketMenu();
}
