package com.jumia.phonenumberscategorization.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum APIResponseResponseDesc {

    SUCCESS("Success"),
    FAILED("Failed"),
    NO_DATA_FOUND("No data found"),
    UN_AUTHORIZED_LOGIN("UnAuthorized Login, Wrong Username or password or you don't have the required privileges to login!");

    private final String code;

    APIResponseResponseDesc(String code) {
        this.code = code;
    }

    public static APIResponseResponseDesc fromId(String id) {
        for (APIResponseResponseDesc at : APIResponseResponseDesc.values()) {
            if (at.getCode().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
