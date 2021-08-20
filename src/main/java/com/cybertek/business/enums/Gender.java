package com.cybertek.business.enums;


import lombok.Getter;

@Getter
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
