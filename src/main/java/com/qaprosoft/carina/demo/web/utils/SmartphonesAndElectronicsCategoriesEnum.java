package com.qaprosoft.carina.demo.web.utils;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.SmartphonesPageBase;

public enum SmartphonesAndElectronicsCategoriesEnum {

    SMARTPHONES("Мобільні телефони", SmartphonesPageBase.class);

    private String namePage;

    private Class<? extends AbstractPage> pageClass;

    SmartphonesAndElectronicsCategoriesEnum(String namePage, Class<? extends AbstractPage> pageClass) {
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
