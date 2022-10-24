package com.qaprosoft.carina.demo.web.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.DrlPageBase;

public enum AutoLights {

    DRL("Денні ходові вогні", DrlPageBase.class);

    private String namePage;

    private Class<? extends AbstractPage> pageClass;

    AutoLights(String namePage, Class<? extends AbstractPage> pageClass) {
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
