package com.jumia.phonenumberscategorization.repo;

import com.jumia.phonenumberscategorization.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "select * from customer",countQuery = "select count(*) from customer", nativeQuery = true)
//    Page<Customer> findAllCustomers(Pageable pageable);

    @Query("select a from Customer a")
    Page<Customer> findAllCustomers(Pageable pageable);

}
