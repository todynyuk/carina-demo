package com.qaprosoft.carina.demo.web.utils;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksPageBase;

public enum ComputersCategoriesEnum {
    LAPTOPS("Ноутбуки", NotebooksPageBase.class);

    private String namePage;

    private Class<? extends AbstractPage> pageClass;

    ComputersCategoriesEnum(String namePage, Class<? extends AbstractPage> pageClass) {
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
