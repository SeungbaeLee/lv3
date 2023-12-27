package com.hh99.lv3.admin.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Department {
    curriculum,marketing,development
//    curriculum("curriculum"),
//    marketing("marketing"),
//    development("development");
//
//    @Getter
//    private final String krName;
//
//    Department(String krName) {
//        this.krName = krName;
//    }
//
//    @JsonValue
//    public String getDepartment() {
//        return krName;
//    }
}
