package com.qaprosoft.carina.demo.web.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.ComputersPageBase;
import com.qaprosoft.carina.demo.web.gui.common.NotebooksPageBase;

public enum ComputersCategories {
    LAPTOPS("Ноутбуки", NotebooksPageBase.class),
    COMPUTERS("неттопи, моноблоки", ComputersPageBase.class);

    private String namePage;

    private Class<? extends AbstractPage> pageClass;

    ComputersCategories(String namePage, Class<? extends AbstractPage> pageClass) {
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
