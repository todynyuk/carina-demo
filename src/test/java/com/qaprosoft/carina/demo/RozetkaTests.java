package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.gui.common.*;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.qaprosoft.carina.demo.web.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTests implements IAbstractTest {

    String laptopBrandName = "Fujitsu";

    String smartphoneBrandName = "Xiaomi";

    String laptopSsdStorageCapacityValue = "256 ГБ";

    String minPriceValue = "10000";

    String material="Скло";
    String color = "Синій";

    String ram = "256";

    String colorEnglishVersion = "Blue";

    String maxPriceValue = "60000";

    @Test
    public void testVerifySearchBrandNameMaxCustomPriceAndAvailable() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        NotebooksAndComputersPageBase notebooksAndComputersPageBase = (NotebooksAndComputersPageBase) homePage.clickOnCategoryLink(CategoriesMenuEnum.LAPTOPS_AND_COMPUTERS);
        NotebooksPageBase notebooksPageBase = (NotebooksPageBase) notebooksAndComputersPageBase.clickOnDeviceCategoryLink(ComputersCategoriesEnum.LAPTOPS);
        notebooksPageBase.brandCheckBoxClick(laptopBrandName);
        Assert.assertTrue(notebooksPageBase.verifySearchByChosenBrand(laptopBrandName), "One or more  laptops aren`t have this brand name");
        notebooksPageBase.setPriceLimit(1, maxPriceValue);
        notebooksPageBase.okButtonClick();
        Assert.assertTrue(notebooksPageBase.verifySortByCustomMaximumPrice(maxPriceValue), "List prices contains price more than custom maximum price");
        notebooksPageBase.videoCardTypeCheckBoxClick(VideoCardTypeEnum.DISCRETE_VIDEO_CARD);
        notebooksPageBase.deviceUseStateCheckboxClick(DeviceUseStateEnum.NEW);
        notebooksPageBase.itemAvailableCheckboxClick(ItemStateEnum.AVAILABLE);
        Assert.assertFalse(notebooksPageBase.verifySearchByIsNotAvailableLaptops(), "Text IsNotAvailable exist on one or more laptops");
    }


    @Test
    public void testVerifyItemColorRamAndPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SmartphonesAndTvElectronicsPageBase smartphones = (SmartphonesAndTvElectronicsPageBase) homePage.clickOnCategoryLink(CategoriesMenuEnum.SMARTPHONES_AND_TV);
        SmartphonesPageBase smartphonesPageBase = (SmartphonesPageBase) smartphones.clickOnDeviceCategoryLink(SmartphonesAndElectronicsCategoriesEnum.SMARTPHONES);
        smartphonesPageBase.brandCheckBoxClick(smartphoneBrandName);
        smartphonesPageBase.ramButtonClick(ram);
        smartphonesPageBase.colorCheckBoxClick(color);
        smartphonesPageBase.materialCheckBoxClick(material);
        smartphonesPageBase.itemAvailableCheckboxClick(ItemStateEnum.AVAILABLE);
        int smartphoneByIndexPrice = smartphonesPageBase.getSmartphonePriceText(2);
        Assert.assertTrue(smartphonesPageBase.checkIsChooseColorPresentInDescription(colorEnglishVersion, 2));
        DevicePageBase devicePageBase = smartphonesPageBase.linkMoreAboutDeviceClick(2);
        Assert.assertTrue(devicePageBase.verifyChosenColor(colorEnglishVersion), "Color tests are not equals");
        int smartphonePrice = devicePageBase.getSmartphonePriceText();
        Assert.assertEquals(smartphonePrice, smartphoneByIndexPrice, "Prices are not equals");
        Assert.assertTrue(devicePageBase.verifyChosenRamInShortCharacteristics(ram),"RAM values not contains in selected text");
        Assert.assertTrue(devicePageBase.verifyChosenRamInAllCharacteristics(ram),"RAM values not contains in selected text");
    }
}
