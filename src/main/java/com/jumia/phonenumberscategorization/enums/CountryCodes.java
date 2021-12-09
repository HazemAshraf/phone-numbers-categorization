package com.jumia.phonenumberscategorization.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
//@ToString
public enum CountryCodes {

    Cameroon("237"),
    Ethiopia("251"),
    Morocco("212"),
    Mozambique("258"),
    Uganda("256")
   ;



    private final String code;

    CountryCodes(String code) {
        this.code = code;
    }

    public static CountryCodes fromId(String id) {
        for (CountryCodes at : CountryCodes.values()) {
            if (at.getCode().equals(id)) {
                return at;
            }
        }
        return null;
    }

    public static List<CountryCodes> getAll() {
        return Arrays.asList(CountryCodes.values().clone());
    }
}
