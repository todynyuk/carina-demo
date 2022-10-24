package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.DropdownFilterOptions;
import com.qaprosoft.carina.demo.web.gui.common.DrlPageBase;
import com.qaprosoft.carina.demo.web.gui.components.ShoppingBasket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DrlPageBase.class)
public class DrlPage extends DrlPageBase {

    @FindBy(xpath = "//select[contains(@class,'select-css')]/option[contains(text(),'%s')]")
    private ExtendedWebElement universalDropdownOption;

    @FindBy(xpath = "//h1[@class='catalog-heading ng-star-inserted']")
    private ExtendedWebElement categoryTitleText;

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<ExtendedWebElement> priceItemText;

    @FindBy(xpath = "//button[contains(@class,'buy-button')]")
    private List<ExtendedWebElement> buyButton;

    @FindBy(xpath = "//span[@class='counter counter--green ng-star-inserted']")
    private ExtendedWebElement addedToCartGoodsCounterText;

    @FindBy(xpath = "//button[contains(@class,'header__button--active')]")
    private ExtendedWebElement shoppingBasketButton;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder--large')]")
    private ShoppingBasket basket;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> linksListMoreAboutDevice;

    public DrlPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getCategoryText() {
        return categoryTitleText.getText().replace(" ", "");
    }

    @Override
    public Integer getAddedToCartGoodsCounterValue() {
        return Integer.valueOf(addedToCartGoodsCounterText.getText());
    }

    @Override
    public boolean isAddedToCartGoodsCounterTextPresent() {
        return addedToCartGoodsCounterText.isElementPresent();
    }

    @Override
    public String getListMoreAboutDeviceLinkText(int index) {
        return linksListMoreAboutDevice.get(index).getText();
    }

    @Override
    public Integer getItemPriceValue(int index) {
        return Integer.valueOf(priceItemText.get(index).getText());
    }

    @Override
    public void clickBuyButtonByIndex(int index) {
        buyButton.get(index).click();
    }

    @Override
    public void clickDropdownOption(DropdownFilterOptions drl) {
        universalDropdownOption.format(drl.getOptionText()).click();
    }

    @Override
    public boolean isAllGoodsSortedFromLowToHighPrice() {
        boolean state = false;
        for (int i = 0; i < priceItemText.size() - 1; i++) {
            state = Integer.parseInt(priceItemText.get(i).getText()) <= Integer.parseInt(priceItemText.get(i + 1).getText());
        }
        //return priceItemText.stream().allMatch(p->p>=(p+1))
//        return  IntStream.range(0,priceItemText.size()-1).forEach(i -> {
//            Integer.parseInt(priceItemText.get(i).getText())>=Integer.parseInt(priceItemText.get(i+1).getText());
//        });

        return state;
    }

    @Override
    public boolean isAllGoodsSortedFromHighToLowPrice() {
        boolean state = false;
        for (int i = 0; i < priceItemText.size() - 1; i++) {
            state = Integer.parseInt(priceItemText.get(i).getText().replace(" ", ""))
                    >= Integer.parseInt(priceItemText.get(i + 1).getText().replace(" ", ""));
        }
        return state;
    }

    @Override
    public void clickOnShoppingBasketButton() {
        shoppingBasketButton.click();
    }

    @Override
    public ShoppingBasket getBasketMenu() {
        return basket;
    }
}
