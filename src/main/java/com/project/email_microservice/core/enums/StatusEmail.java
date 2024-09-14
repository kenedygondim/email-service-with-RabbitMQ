package com.project.email_microservice.core.enums;

import lombok.Getter;

@Getter
public enum StatusEmail {
    SENT("SENT"),
    ERROR ("ERROR");

    private final String status;

    StatusEmail(String status){
        this.status = status;
    }
}
