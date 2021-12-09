package com.jumia.phonenumberscategorization.enums;

import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;


@Getter
@ToString
public enum CountryRegexEnum {

    Cameroon("\\(237\\)\\ ?[2368]\\d{7,8}$"),
    Ethiopia("\\(251\\)\\ ?[1-59]\\d{8}$"),
    Morocco("\\(212\\)\\ ?[5-9]\\d{8}$"),
    Mozambique("\\(258\\)\\ ?[28]\\d{7,8}$"),
    Uganda("\\(256\\)\\ ?\\d{9}$")
    ;


    private final String code;

    CountryRegexEnum(String code) {
        this.code = code;
    }

    public static CountryRegexEnum fromId(String id) {
        for (CountryRegexEnum at : CountryRegexEnum.values()) {
            if(Pattern.matches(at.getCode(), id)){
                return at;
            }
        }
        return null;
    }
}
