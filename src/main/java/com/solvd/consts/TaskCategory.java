package com.solvd.consts;

import lombok.Getter;

@Getter
public enum TaskCategory {
    DEFAULT("No Category"),
    WORK("Work"),
    PERSONAL("Personal"),
    WISHLIST("Wishlist"),
    BIRTHDAY("Birthday");

    private final String name;

    TaskCategory(String name) {
        this.name = name;
    }
}
