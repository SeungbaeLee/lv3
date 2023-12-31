package com.hh99.lv3.domain.admin.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Role {
    MANAGER,STAFF
//    MANAGER("MANAGER"),STAFF("STAFF");
//    @Getter
//    private final String krName;
//
//    Role(String krName) {
//        this.krName = krName;
//    }
//
//    @JsonValue
//    public String getRole() {
//        return krName;
//    }
}
