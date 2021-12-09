package com.jumia.phonenumberscategorization.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}