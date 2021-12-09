package com.jumia.phonenumberscategorization.util;

import com.jumia.phonenumberscategorization.enums.APIResponseResponseCode;
import com.jumia.phonenumberscategorization.enums.APIResponseResponseDesc;
import com.jumia.phonenumberscategorization.model.response.APIResponse;

public class APIResponseCodesGenerator {
    public static void generateSuccessCode(APIResponse apiResponse) {
        apiResponse.setStatusCode(APIResponseResponseCode.SUCCESS);
        apiResponse.setStatusMessage(APIResponseResponseDesc.SUCCESS);
    }
    public static void generateFailureCode(APIResponse apiResponse) {
        apiResponse.setStatusCode(APIResponseResponseCode.FAILED);
        apiResponse.setStatusMessage(APIResponseResponseDesc.FAILED);
    }

    public static void generateStatusCode(APIResponse apiResponse, APIResponseResponseCode apiResponseResponseCode, APIResponseResponseDesc apiResponseResponseDesc) {
        apiResponse.setStatusCode(apiResponseResponseCode);
        apiResponse.setStatusMessage(apiResponseResponseDesc);
    }
}
