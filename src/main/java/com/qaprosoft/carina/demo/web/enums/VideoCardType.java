package com.qaprosoft.carina.demo.web.enums;

public enum VideoCardType {

    INTEGRATED_VIDEO_CARD("Інтегрована"),
    DISCRETE_VIDEO_CARD("Дискретна");

    private String videoCardType;

    VideoCardType(String videoCardType) {
        this.videoCardType = videoCardType;
    }

    public String getVideoCardType() {
        return videoCardType;
    }
}
