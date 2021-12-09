package com.jumia.phonenumberscategorization.model.dto;

import com.jumia.phonenumberscategorization.entity.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerDTO {

    private int id;

    private String name;

    private String phone;

    private String country;

    public CustomerDTO(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
    }
}
