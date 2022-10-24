package com.qaprosoft.carina.demo.web.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.AutoLightsPageBase;

public enum AutoCategories {
    AUTO_LIGHTS("Автосвітло", AutoLightsPageBase.class);

    private String namePage;

    private Class<? extends AbstractPage> pageClass;

    AutoCategories(String namePage, Class<? extends AbstractPage> pageClass) {
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
