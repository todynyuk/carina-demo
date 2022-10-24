package com.qaprosoft.carina.demo.web.enums;

public enum DropdownFilterOptions {

    BY_RATING("За рейтингом"),
    FROM_LOW_TO_HIGH("Від дешевих до дорогих"),
    FROM_HIGH_TO_LOW("Від дорогих до дешевих"),
    LATEST("Новинки");

    private String optionText;

    DropdownFilterOptions(String optionText) {
        this.optionText = optionText;
    }

    public String getOptionText() {
        return optionText;
    }
}
