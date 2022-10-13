package com.qaprosoft.carina.demo.web.utils;

public enum ItemStateEnum {
    NOT_AVAILABLE("Немає в наявності"),
    AVAILABLE("Є в наявності"),
    WILL_EXPIRE("Закінчується");

    private String itemAvailableState;

    ItemStateEnum(String itemAvailableState) {
        this.itemAvailableState = itemAvailableState;
    }

    public String getDeviceUseState() {
        return itemAvailableState;
    }
}
