package com.qaprosoft.carina.demo.web.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksAndComputersPageBase;
import com.qaprosoft.carina.demo.web.gui.common.SmartphonesAndTvElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ToolsAndAutoProductsPageBase;

public enum CategoriesMenu {
    LAPTOPS_AND_COMPUTERS("Ноутбуки та комп’ютери", NotebooksAndComputersPageBase.class),
    SMARTPHONES_AND_TV("Смартфони, ТВ і електроніка", SmartphonesAndTvElectronicsPageBase.class),
    TOOLS_AND_AUTO_PRODUCTS("Інструменти та автотовари", ToolsAndAutoProductsPageBase.class);

    private String namePage;

    private Class<? extends AbstractPage> pageClass;

    CategoriesMenu(String namePage, Class<? extends AbstractPage> pageClass) {
        this.namePage = namePage;
        this.pageClass = pageClass;
    }

    public String getNamePage() {
        return namePage;
    }

    public Class<? extends AbstractPage> getPageClass() {
        return this.pageClass;
    }
}
