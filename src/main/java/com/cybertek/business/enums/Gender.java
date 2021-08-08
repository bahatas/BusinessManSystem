package com.cybertek.business.enums;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private final String value;

    Gender(String value){
        this.value = value;
    }

    String getValue(){
        return value;
    }
}
