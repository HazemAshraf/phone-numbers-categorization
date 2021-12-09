package com.jumia.phonenumberscategorization.util;

import java.util.List;

public class DataUtil {
    public static boolean isNullOrEmpty(Object data) {
        if (data == null) {
            return true;
        } else if (data instanceof List) {
            return ((List) data).isEmpty();
        }
        return false;
    }
}
