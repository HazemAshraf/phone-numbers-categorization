package com.jumia.phonenumberscategorization.util;

import com.jumia.phonenumberscategorization.enums.APIResponseResponseCode;
import com.jumia.phonenumberscategorization.enums.APIResponseResponseDesc;
import com.jumia.phonenumberscategorization.model.response.APIResponse;

import java.util.Arrays;
import java.util.List;

public class APIResponseGenerator {
    public static APIResponse generateSuccessResponse(List data) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setResponseData(data);
        APIResponseCodesGenerator.generateSuccessCode(apiResponse);
        return apiResponse;
    }

    public static APIResponse generateNoDataFoundFailureResponse() {
        return generateFailureResponse(APIResponseResponseCode.NO_DATA_FOUND, APIResponseResponseDesc.NO_DATA_FOUND);
    }

    private static APIResponse generateFailureResponse(APIResponseResponseCode apiResponseResponseCode, APIResponseResponseDesc apiResponseResponseDesc) {
        APIResponse apiResponse = new APIResponse();
        APIResponseCodesGenerator.generateStatusCode(apiResponse, apiResponseResponseCode, apiResponseResponseDesc);
        return apiResponse;
    }

    public static Object generateUnAuthorizedUserFailureResponse(Exception ex) {
        APIResponse apiResponse = generateFailureResponse(APIResponseResponseCode.UN_AUTHORIZED_LOGIN,
                APIResponseResponseDesc.UN_AUTHORIZED_LOGIN);
        apiResponse.setErrorFullTrace(Arrays.toString(ex.getStackTrace()));
        apiResponse.setErrorMessage(ex.getMessage());
        return apiResponse;
    }

}
