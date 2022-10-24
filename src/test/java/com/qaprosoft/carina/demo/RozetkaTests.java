package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.web.gui.components.ShoppingBasket;
import com.qaprosoft.carina.demo.web.gui.desktop.DispensationPointsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.demo.web.enums.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.gui.common.*;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.qaprosoft.carina.core.foundation.utils.R;

public class RozetkaTests implements IAbstractTest {

    @Test
    public void testVerifySearchBrandNameMaxCustomPriceAndAvailable() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        NotebooksAndComputersPageBase notebooksAndComputersPageBase = (NotebooksAndComputersPageBase) homePage.clickOnCategoryLink(CategoriesMenu.LAPTOPS_AND_COMPUTERS);
        NotebooksPageBase notebooksPageBase = (NotebooksPageBase) notebooksAndComputersPageBase.clickOnDeviceCategoryLink(ComputersCategories.LAPTOPS);
        notebooksPageBase.clickBrandOrSsdStorageCapacityCheckbox(R.TESTDATA.get("computerBrandName"));
        Assert.assertTrue(notebooksPageBase.verifySearchByChosenBrand(R.TESTDATA.get("computerBrandName")), "One or more  laptops aren`t have this brand name");
        notebooksPageBase.setPriceLimit(1, R.TESTDATA.get("maxPriceValue"));
        notebooksPageBase.clickOkButton();
        Assert.assertTrue(notebooksPageBase.verifySortByCustomMaximumPrice(R.TESTDATA.get("maxPriceValue")), "List prices contains price more than custom maximum price");
        notebooksPageBase.clickDeviceUseStateCheckbox(DeviceUseState.NEW);
        notebooksPageBase.clickItemAvailableCheckbox(ItemState.AVAILABLE);
        Assert.assertTrue(notebooksPageBase.verifySearchByIsNotAvailableLaptops(1), "Text IsNotAvailable exist on one or more laptops");
    }

    @Test
    public void testVerifyItemColorRamAndPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SmartphonesAndTvElectronicsPageBase smartphones = (SmartphonesAndTvElectronicsPageBase) homePage.clickOnCategoryLink(CategoriesMenu.SMARTPHONES_AND_TV);
        SmartphonesPageBase smartphonesPageBase = (SmartphonesPageBase) smartphones.clickOnDeviceCategoryLink(SmartphonesAndElectronicsCategories.SMARTPHONES);
        smartphonesPageBase.clickUniversalCheckBox(R.TESTDATA.get("smartphoneBrandName"));
        smartphonesPageBase.clickUniversalRomStorageCapacityButton("256");
        smartphonesPageBase.clickСheckBoxWithCyrillic("Синій");
        smartphonesPageBase.clickСheckBoxWithCyrillic("Скло");
        smartphonesPageBase.clickItemAvailableCheckbox(ItemState.AVAILABLE);
        int smartphoneByIndexPrice = smartphonesPageBase.getSmartphonePriceText(2);
        Assert.assertTrue(smartphonesPageBase.checkIsChooseColorPresentInDescription(R.TESTDATA.get("colorEnglishVersion"), 2));
        DevicePageBase devicePageBase = smartphonesPageBase.clickLinkMoreAboutDevice(2);
        Assert.assertTrue(devicePageBase.verifyChosenColor(R.TESTDATA.get("colorEnglishVersion")), "Color tests are not equals");
        int smartphonePrice = devicePageBase.getSmartphonePriceText();
        Assert.assertEquals(smartphonePrice, smartphoneByIndexPrice, "Prices are not equals");
        Assert.assertTrue(devicePageBase.verifyChosenRamInShortCharacteristics(R.TESTDATA.get("rom")), "RAM values not contains in selected text");
        Assert.assertTrue(devicePageBase.verifyChosenParamInAllCharacteristics(R.TESTDATA.get("rom")), "RAM values not contains in selected text");
    }

    @Test
    public void testVerifyItemRamMatrixTypeAndProcessor() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        NotebooksAndComputersPageBase notebooksAndComputersPageBase = (NotebooksAndComputersPageBase) homePage.clickOnCategoryLink(CategoriesMenu.LAPTOPS_AND_COMPUTERS);
        ComputersPageBase computersPageBase = (ComputersPageBase) notebooksAndComputersPageBase.clickOnDeviceCategoryLink(ComputersCategories.COMPUTERS);
        computersPageBase.clickUniversalCheckBox(R.TESTDATA.get("computerBrandName"));
        computersPageBase.clickUniversalCheckBox(R.TESTDATA.get("processorName"));
        computersPageBase.clickСheckBoxWithCyrillic("8 ГБ");
        computersPageBase.clickСheckBoxWithCyrillic("Моноблоки");
        computersPageBase.clickUniversalShowCheckBoxButton("Тип матриці");
        computersPageBase.clickUniversalCheckBox(R.TESTDATA.get("matrixType"));
        computersPageBase.clickUniversalCheckBox(ItemState.AVAILABLE.getDeviceUseState());
        DevicePageBase devicePageBase = computersPageBase.clickLinkMoreAboutDevice(1);
        Assert.assertTrue(devicePageBase.verifyIsAvailableTextPresent(), "Available text not presented");
        Assert.assertTrue(devicePageBase.verifyChosenParameterInShortCharacteristics(R.TESTDATA.get("processorName")), "Processor name text not contains in about device text");
        Assert.assertTrue(devicePageBase.verifyChosenParameterInShortCharacteristics("8 ГБ"), "Ram text not contains in about device text");
        Assert.assertTrue(devicePageBase.verifyChosenParameterInShortCharacteristics(R.TESTDATA.get("matrixType")), "Matrix type text not contains in about device text");
        Assert.assertTrue(devicePageBase.verifyChosenParamInAllCharacteristics(R.TESTDATA.get("computerBrandName")), "Brand text not contains in description device text");
        Assert.assertTrue(devicePageBase.verifyChosenParamInAllCharacteristics("Моноблок"), "Computer type text not contains in description device text");
    }

    @Test
    public void testVerifySortByPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ToolsAndAutoProductsPageBase toolsAndAutoProducts = (ToolsAndAutoProductsPageBase) homePage.clickOnCategoryLink(CategoriesMenu.TOOLS_AND_AUTO_PRODUCTS);
        AutoLightsPageBase autoLights = (AutoLightsPageBase) toolsAndAutoProducts.clickOnDeviceCategoryLink(AutoCategories.AUTO_LIGHTS);
        String chosenCategoryText = autoLights.getCategoryText(AutoLights.DRL);
        DrlPageBase drl = (DrlPageBase) autoLights.clickOnDeviceCategoryLink(AutoLights.DRL);
        String categoryTitleText = drl.getCategoryText();
        Assert.assertEquals(categoryTitleText, chosenCategoryText, "Texts category are not equals");
        drl.clickDropdownOption(DropdownFilterOptions.FROM_LOW_TO_HIGH);
        Assert.assertTrue(drl.isAllGoodsSortedFromLowToHighPrice(), "Goods not sorted from low to high price");
        drl.clickDropdownOption(DropdownFilterOptions.FROM_HIGH_TO_LOW);
        Assert.assertTrue(drl.isAllGoodsSortedFromHighToLowPrice(), "Goods not sorted from high to low price");
    }

    @Test
    public void testVerifyAddingAndCountGoodsInBasket() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ToolsAndAutoProductsPageBase toolsAndAutoProducts = (ToolsAndAutoProductsPageBase) homePage.clickOnCategoryLink(CategoriesMenu.TOOLS_AND_AUTO_PRODUCTS);
        AutoLightsPageBase autoLights = (AutoLightsPageBase) toolsAndAutoProducts.clickOnDeviceCategoryLink(AutoCategories.AUTO_LIGHTS);
        DrlPageBase drl = (DrlPageBase) autoLights.clickOnDeviceCategoryLink(AutoLights.DRL);
        Assert.assertFalse(drl.isAddedToCartGoodsCounterTextPresent(), "Text added to cart goods counter presented");
        drl.clickBuyButtonByIndex(1);
        Assert.assertTrue(drl.isAddedToCartGoodsCounterTextPresent(), "Text added to cart goods counter isn't presented");
        drl.clickBuyButtonByIndex(2);
        int addedToCartGoodsCounterValue = drl.getAddedToCartGoodsCounterValue();
        ShoppingBasket shoppingBasket = drl.getBasketMenu();
        int goodsInShoppingBasketCount = shoppingBasket.getGoodsInCartListSize();
        Assert.assertEquals(goodsInShoppingBasketCount, addedToCartGoodsCounterValue, "Added to cart goods counter value");
    }

    @Test
    public void testVerifyUsualPriceItemAndInBasket() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ToolsAndAutoProductsPageBase toolsAndAutoProducts = (ToolsAndAutoProductsPageBase) homePage.clickOnCategoryLink(CategoriesMenu.TOOLS_AND_AUTO_PRODUCTS);
        AutoLightsPageBase autoLights = (AutoLightsPageBase) toolsAndAutoProducts.clickOnDeviceCategoryLink(AutoCategories.AUTO_LIGHTS);
        DrlPageBase drl = (DrlPageBase) autoLights.clickOnDeviceCategoryLink(AutoLights.DRL);
        String shortDescription = drl.getListMoreAboutDeviceLinkText(2);
        int itemPrice = drl.getItemPriceValue(2);
        drl.clickBuyButtonByIndex(2);
        drl.clickOnShoppingBasketButton();
        ShoppingBasket shoppingBasket = drl.getBasketMenu();
        String itemCardDescriptionText = shoppingBasket.getGoodsDescriptionText(0);
        Assert.assertEquals(itemCardDescriptionText, shortDescription, "Texts are not equals");
        int shoppingBasketItemPrice = shoppingBasket.getSumPriceText();
        Assert.assertEquals(shoppingBasketItemPrice, itemPrice, "Prices are not equals");
        shoppingBasket.setInputFieldValue(Integer.valueOf(R.TESTDATA.get("shoppingBasketCount")));
        int changedItemPrice = shoppingBasket.getSumPriceText();
        Assert.assertEquals(changedItemPrice, (itemPrice * Integer.valueOf(R.TESTDATA.get("shoppingBasketCount"))), "Prices are not equals");
    }

    @Test
    public void testVerifyChoseCityInDispensationPointsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        DispensationPointsPageBase dispensationPoints = homePage.clickDispensationPointsLink();
        Assert.assertTrue(dispensationPoints.isDispensationPointsTitleTextPresent(),
                "Dispensation Points Title Text isn't presented");
        dispensationPoints.clickChooseCityButton("Полтава");
        Assert.assertTrue(dispensationPoints.isDispensationPointsTitleTextContainsChosenCity("Полтава"),
                "Dispensation points title not contains chosen city");
        Assert.assertTrue(dispensationPoints.isPickUpPointsTitleTextContainsChosenCity("Полтава"),
                "PickUp points title not contains chosen city");
    }

    @Test
    public void testAddGoodsInBasketAndCheckItEmpty() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ToolsAndAutoProductsPageBase toolsAndAutoProducts = (ToolsAndAutoProductsPageBase) homePage.clickOnCategoryLink(CategoriesMenu.TOOLS_AND_AUTO_PRODUCTS);
        AutoLightsPageBase autoLights = (AutoLightsPageBase) toolsAndAutoProducts.clickOnDeviceCategoryLink(AutoCategories.AUTO_LIGHTS);
        DrlPageBase drl = (DrlPageBase) autoLights.clickOnDeviceCategoryLink(AutoLights.DRL);
        drl.clickBuyButtonByIndex(3);
        drl.clickOnShoppingBasketButton();
        ShoppingBasket shoppingBasket = drl.getBasketMenu();
        Assert.assertFalse(shoppingBasket.isBasketEmptyStatusTextPresent(), "Basket empty status text is presented");
        int goodsInShoppingBasketCount = shoppingBasket.getGoodsInCartListSize();
        Assert.assertTrue(goodsInShoppingBasketCount > 0, "Basket is empty");
    }


}
