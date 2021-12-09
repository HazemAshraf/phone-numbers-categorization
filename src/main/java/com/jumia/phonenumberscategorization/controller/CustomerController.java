package com.jumia.phonenumberscategorization.controller;

import com.jumia.phonenumberscategorization.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping(value = "/phoneNoCat/{page}", method = RequestMethod.GET)
    public ResponseEntity<?> readAllCustomerCategorizedPhoneNumbers(@PathVariable("page") int page){
        return ResponseEntity.ok(this.customerFacade.readAllCustomerCategorizedPhoneNumbers(page, null));

    }
}
