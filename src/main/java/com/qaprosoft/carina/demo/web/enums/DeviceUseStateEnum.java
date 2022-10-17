package com.qaprosoft.carina.demo.web.enums;

public enum DeviceUseStateEnum {
    NEW("Новий"),
    USED("Б/в");

    private String useState;

    DeviceUseStateEnum(String useState) {
        this.useState = useState;
    }

    public String getDeviceUseState() {
        return useState;
    }
}
