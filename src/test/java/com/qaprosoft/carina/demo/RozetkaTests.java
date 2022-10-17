package com.qaprosoft.carina.demo;


import com.qaprosoft.carina.demo.web.enums.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.gui.common.*;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.qaprosoft.carina.core.foundation.utils.R;


public class RozetkaTests implements IAbstractTest {

    @Test
    public void testVerifySearchBrandNameMaxCustomPriceAndAvailable() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        NotebooksAndComputersPageBase notebooksAndComputersPageBase = (NotebooksAndComputersPageBase) homePage.clickOnCategoryLink(CategoriesMenuEnum.LAPTOPS_AND_COMPUTERS);
        NotebooksPageBase notebooksPageBase = (NotebooksPageBase) notebooksAndComputersPageBase.clickOnDeviceCategoryLink(ComputersCategoriesEnum.LAPTOPS);
        notebooksPageBase.brandOrSsdStorageCapacityCheckboxClick(R.TESTDATA.get("laptopBrandName"));
        Assert.assertTrue(notebooksPageBase.verifySearchByChosenBrand(R.TESTDATA.get("laptopBrandName")), "One or more  laptops aren`t have this brand name");
        notebooksPageBase.setPriceLimit(1, R.TESTDATA.get("maxPriceValue"));
        notebooksPageBase.okButtonClick();
        Assert.assertTrue(notebooksPageBase.verifySortByCustomMaximumPrice(R.TESTDATA.get("maxPriceValue")), "List prices contains price more than custom maximum price");
        notebooksPageBase.deviceUseStateCheckboxClick(DeviceUseStateEnum.NEW);
        notebooksPageBase.itemAvailableCheckboxClick(ItemStateEnum.AVAILABLE);
        Assert.assertTrue(notebooksPageBase.verifySearchByIsNotAvailableLaptops(1), "Text IsNotAvailable exist on one or more laptops");
    }

    @Test
    public void testVerifyItemColorRamAndPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SmartphonesAndTvElectronicsPageBase smartphones = (SmartphonesAndTvElectronicsPageBase) homePage.clickOnCategoryLink(CategoriesMenuEnum.SMARTPHONES_AND_TV);
        SmartphonesPageBase smartphonesPageBase = (SmartphonesPageBase) smartphones.clickOnDeviceCategoryLink(SmartphonesAndElectronicsCategoriesEnum.SMARTPHONES);
        smartphonesPageBase.universalCheckBoxClick(R.TESTDATA.get("smartphoneBrandName"));
        smartphonesPageBase.universalRomStorageCapacityButtonClick("256");
        smartphonesPageBase.checkBoxWithCyrillicClick("Синій");
        smartphonesPageBase.checkBoxWithCyrillicClick("Скло");
        smartphonesPageBase.itemAvailableCheckboxClick(ItemStateEnum.AVAILABLE);
        int smartphoneByIndexPrice = smartphonesPageBase.getSmartphonePriceText(2);
        Assert.assertTrue(smartphonesPageBase.checkIsChooseColorPresentInDescription(R.TESTDATA.get("colorEnglishVersion"), 2));
        DevicePageBase devicePageBase = smartphonesPageBase.linkMoreAboutDeviceClick(2);
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
        NotebooksAndComputersPageBase notebooksAndComputersPageBase = (NotebooksAndComputersPageBase) homePage.clickOnCategoryLink(CategoriesMenuEnum.LAPTOPS_AND_COMPUTERS);
        ComputersPageBase computersPageBase = (ComputersPageBase) notebooksAndComputersPageBase.clickOnDeviceCategoryLink(ComputersCategoriesEnum.COMPUTERS);
        computersPageBase.universalCheckBoxClick(R.TESTDATA.get("computerBrandName"));
        computersPageBase.universalCheckBoxClick(R.TESTDATA.get("processorName"));
        computersPageBase.checkBoxWithCyrillicClick("8 ГБ");
        computersPageBase.checkBoxWithCyrillicClick("Моноблоки");
        computersPageBase.universalShowCheckBoxButtonClick("Тип матриці");
        computersPageBase.universalCheckBoxClick(R.TESTDATA.get("matrixType"));
        computersPageBase.universalCheckBoxClick(ItemStateEnum.AVAILABLE.getDeviceUseState());
        DevicePageBase devicePageBase = computersPageBase.linkMoreAboutDeviceClick(1);
        Assert.assertTrue(devicePageBase.verifyIsAvailableTextPresent(), "Available text not present");
        Assert.assertTrue(devicePageBase.verifyChosenParameterInShortCharacteristics(R.TESTDATA.get("processorName")), "Processor name text not contains in about device text");
        Assert.assertTrue(devicePageBase.verifyChosenParameterInShortCharacteristics("8 ГБ"), "Ram text not contains in about device text");
        Assert.assertTrue(devicePageBase.verifyChosenParameterInShortCharacteristics(R.TESTDATA.get("matrixType")), "Matrix type text not contains in about device text");
        Assert.assertTrue(devicePageBase.verifyChosenParamInAllCharacteristics(R.TESTDATA.get("computerBrandName")), "Brand text not contains in description device text");
        Assert.assertTrue(devicePageBase.verifyChosenParamInAllCharacteristics("Моноблок"), "Computer type text not contains in description device text");
    }
}
