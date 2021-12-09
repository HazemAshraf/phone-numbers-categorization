package com.jumia.phonenumberscategorization;

import com.jumia.phonenumberscategorization.entity.Customer;
import com.jumia.phonenumberscategorization.enums.CountryCodes;
import com.jumia.phonenumberscategorization.facade.CustomerFacade;
import com.jumia.phonenumberscategorization.model.dto.CustomerDTO;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PhoneNumbersCategorizationApplicationTests {

    @Autowired
    private CustomerFacade customerFacade;

    @Before
    public void setUp() {
        List<CustomerDTO> customerDTOList = Arrays.asList(
                new CustomerDTO(new Customer(1, "MICHAEL MICHAEL", "(237) 677046616")),
                new CustomerDTO(new Customer(2, "ABRAHAM NEGASH", "(251) 911203317")),
                new CustomerDTO(new Customer(3, "Yosaf Karrouch", "(212) 698054317")),
                new CustomerDTO(new Customer(4, "Florencio Samuel", "(258) 847602609")),
                new CustomerDTO(new Customer(5, "JACKSON NELLY", "(256) 775069443")),
                new CustomerDTO(new Customer(6, "Younes Boutikyad", "(212) 6546545369")));

        given(customerFacade.mappingToCustomerDTO(new ArrayList<>()))
                .willReturn(customerDTOList);
    }

    @Test
    public void whenGiveCustomerDTO_detectCountryByPhoneNumber() {
        CustomerDTO customerDTO;
        customerDTO = customerFacade.detectCountry(new CustomerDTO(new Customer(1, "MICHAEL MICHAEL", "(237) 677046616")));
        assertThat(customerDTO.getCountry()).isEqualTo(CountryCodes.Cameroon.name());
        customerDTO = customerFacade.detectCountry(new CustomerDTO(new Customer(2, "ABRAHAM NEGASH", "(251) 911203317")));
        assertThat(customerDTO.getCountry()).isEqualTo(CountryCodes.Ethiopia.name());
        customerDTO = customerFacade.detectCountry(new CustomerDTO(new Customer(3, "Yosaf Karrouch", "(212) 698054317")));
        assertThat(customerDTO.getCountry()).isEqualTo(CountryCodes.Morocco.name());
        customerDTO = customerFacade.detectCountry(new CustomerDTO(new Customer(4, "Florencio Samuel", "(258) 847602609")));
        assertThat(customerDTO.getCountry()).isEqualTo(CountryCodes.Mozambique.name());
        customerDTO = customerFacade.detectCountry(new CustomerDTO(new Customer(5, "JACKSON NELLY", "(256) 775069443")));
        assertThat(customerDTO.getCountry()).isEqualTo(CountryCodes.Uganda.name());
    }

}
