package com.jumia.phonenumberscategorization.model.response;

import com.jumia.phonenumberscategorization.enums.APIResponseResponseCode;
import com.jumia.phonenumberscategorization.enums.APIResponseResponseDesc;
import com.jumia.phonenumberscategorization.enums.APIResponseResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class APIResponse {
    private String statusCode;
    private String statusMessage;
    private List responseData;
    private String errorFullTrace;
    private String errorMessage;

    public APIResponse(){}

    public APIResponse(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(APIResponseResponseCode statusCode) {
        this.statusCode = statusCode.getCode();
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(APIResponseResponseDesc statusMessage) {
        this.statusMessage = statusMessage.getCode();
    }
}
