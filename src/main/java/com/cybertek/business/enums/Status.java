package com.cybertek.business.enums;

public enum Status {
    OPEN("Open"),IN_PROGRESS("In Progress"),UAT_TEST("UAT Testing"),COMPLETE("Completed");

    private String value;

    Status(String value){
        this.value=value;
    }

    String getValue(){
        return value;
    }


}
