package com.diyo.TicketBookingSystem.repository;

import com.diyo.TicketBookingSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Search/getting customer details using the first name-------------------
    List<Customer> findByFirstNameContaining(String firstName);
}
