package com.jumia.phonenumberscategorization.service;

import com.jumia.phonenumberscategorization.entity.Customer;
import com.jumia.phonenumberscategorization.repo.CustomerRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Value("${Pagination.NumberOfRecords.PerPage}")
    private int noOfRecords;

    public Page<Customer> readAllCustomers(int page){
        Pageable pageable = PageRequest.of((page-1), noOfRecords);
        Page<Customer> customerPage = customerRepository.findAllCustomers(pageable);
        return customerPage;
    }

    public long countAllCustomers(){
        return customerRepository.count();
    }

}
