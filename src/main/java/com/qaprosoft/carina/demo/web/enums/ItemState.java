package com.qaprosoft.carina.demo.web.enums;

public enum ItemState {
    NOT_AVAILABLE("Немає в наявності"),
    AVAILABLE("Є в наявності"),
    WILL_EXPIRE("Закінчується");

    private String itemAvailableState;

    ItemState(String itemAvailableState) {
        this.itemAvailableState = itemAvailableState;
    }

    public String getDeviceUseState() {
        return itemAvailableState;
    }
}
