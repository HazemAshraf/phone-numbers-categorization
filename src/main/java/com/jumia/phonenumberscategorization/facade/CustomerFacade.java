package com.jumia.phonenumberscategorization.facade;


import com.jumia.phonenumberscategorization.entity.Customer;
import com.jumia.phonenumberscategorization.enums.CountryCodes;
import com.jumia.phonenumberscategorization.enums.CountryRegexEnum;
import com.jumia.phonenumberscategorization.model.dto.CustomerDTO;
import com.jumia.phonenumberscategorization.model.response.APIResponse;
import com.jumia.phonenumberscategorization.service.CustomerService;
import com.jumia.phonenumberscategorization.util.APIResponseGenerator;
import com.jumia.phonenumberscategorization.util.DataUtil;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerFacade {
    @Autowired
    CustomerService customerService;

    public APIResponse readAllCustomerCategorizedPhoneNumbers(int page, String filterText) {
        var customerList = customerService.readAllCustomers(page);
        if (DataUtil.isNullOrEmpty(customerList))
            return APIResponseGenerator.generateNoDataFoundFailureResponse();

        List<CustomerDTO> customerDTOList = mappingToCustomerDTO(customerList.getContent());
        customerDTOList.forEach(customerDTO -> detectCountry(customerDTO));

        List<CustomerDTO> filteredCustomerList = null;
        if (filterText != null) filteredCustomerList = filterCountryListByCountryName(customerDTOList, filterText);

        Collection<CustomerDTO> customerDTOCollection = new ArrayList<>(customerDTOList);
        if (!DataUtil.isNullOrEmpty(filteredCustomerList))
            customerDTOCollection = new ArrayList<>(filteredCustomerList);

        return APIResponseGenerator.generateSuccessResponse(Arrays.asList(customerDTOCollection.toArray()));
    }

    public List<CustomerDTO> mappingToCustomerDTO(List<Customer> customerList) {
        return customerList.stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    public CustomerDTO detectCountry(CustomerDTO customerDTO) {
        var countryRegexEnum = CountryRegexEnum.fromId(customerDTO.getPhone());
        if (countryRegexEnum != null) {
            switch (countryRegexEnum) {
                case Cameroon:
                    customerDTO.setCountry(CountryCodes.Cameroon.name());
                    break;
                case Ethiopia:
                    customerDTO.setCountry(CountryCodes.Ethiopia.name());
                    break;
                case Morocco:
                    customerDTO.setCountry(CountryCodes.Morocco.name());
                    break;
                case Mozambique:
                    customerDTO.setCountry(CountryCodes.Mozambique.name());
                    break;
                case Uganda:
                    customerDTO.setCountry(CountryCodes.Uganda.name());
                    break;
            }
        } else {
            customerDTO.setCountry("Invalid");
        }
        return customerDTO;
    }

    private List<CustomerDTO> filterCountryListByCountryName(List<CustomerDTO> customerDTOList, String filterText) {
        return customerDTOList.stream().filter(customerDTO -> customerDTO.getCountry().equals(filterText)).collect(Collectors.toList());
    }

    public long countAllCustomers() {
        return customerService.countAllCustomers();
    }

}
