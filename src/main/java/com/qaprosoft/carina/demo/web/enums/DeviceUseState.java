package com.qaprosoft.carina.demo.web.enums;

public enum DeviceUseState {
    NEW("Новий"),
    USED("Б/в");

    private String useState;

    DeviceUseState(String useState) {
        this.useState = useState;
    }

    public String getDeviceUseState() {
        return useState;
    }
}
