package com.jumia.phonenumberscategorization.enums;

import lombok.Getter;

@Getter
//@ToString
public enum APIResponseResponseCode {

    SUCCESS("0000"),
    FAILED("0001"),
    NO_DATA_FOUND("0002"),
    SYSTEM_ERROR("0010"),
    UN_AUTHORIZED_LOGIN("032");



    private final String code;

    APIResponseResponseCode(String code) {
        this.code = code;
    }

    public static APIResponseResponseCode fromId(String id) {
        for (APIResponseResponseCode at : APIResponseResponseCode.values()) {
            if (at.getCode().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
