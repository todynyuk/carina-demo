package com.qaprosoft.carina.demo.web.gui.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingBasket extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//a[@class='cart-product__title']")
    private List<ExtendedWebElement> goodsInCartTitleText;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']//span[1]")
    private ExtendedWebElement sumPrice;

    @FindBy(xpath = "//h4[@class='cart-dummy__heading']")
    private ExtendedWebElement basketEmptyStatusText;

    @FindBy(xpath = "//input[@data-testid='cart-counter-input']")
    private ExtendedWebElement goodsCountInputField;

    public ShoppingBasket(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isBasketEmptyStatusTextPresent() {
        return basketEmptyStatusText.isElementPresent();
    }

    public Integer getGoodsInCartListSize() {
        return goodsInCartTitleText.size();
    }

    public Integer getSumPriceText() {
        return Integer.valueOf(sumPrice.getText());
    }

    public String getGoodsDescriptionText(int index) {
        return goodsInCartTitleText.get(index).getText();
    }

    public void setInputFieldValue(int count) {
        goodsCountInputField.type(String.valueOf(count));
    }
}
