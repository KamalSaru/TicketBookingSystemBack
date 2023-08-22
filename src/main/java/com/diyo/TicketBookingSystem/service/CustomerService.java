package com.diyo.TicketBookingSystem.service;

import com.diyo.TicketBookingSystem.entity.Customer;
import com.diyo.TicketBookingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    @Autowired //used for automatic dependency injection
    private CustomerRepository customerRepository;

    //Post/save all the customers details PostMapping----------
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    //Get all details information--------
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    //Get method using ID------------
    public Customer getCustomerById(Long ID) {
        Optional<Customer> customer = customerRepository.findById(ID);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    //Put/Edit/update the details----------------
    public String updateCustomer(Customer customersInfo, Long ID) {
        Optional<Customer> customerDetail = customerRepository.findById(ID);
        if (customerDetail.isPresent()) {
            Customer customer = customerDetail.get();
            customer.setFirstName(customersInfo.getFirstName());
            customer.setLastName(customersInfo.getLastName());
            customer.setAddress(customersInfo.getAddress());
            customer.setDob(customersInfo.getDob());
            customer.setGender(customersInfo.getGender());
            customer.setPhone(customersInfo.getPhone());
            customer.setEmail(customersInfo.getEmail());
            //Ticket list information
            customer.setTicketList(customersInfo.getTicketList());
            //save details after update the information
            customer.setActive(customersInfo.getActive());
            customer.setStatus(customersInfo.getStatus());
            customerRepository.save(customer);
            return "Customer details update successfully!!";
        } else {
            return "Customer ID number " + ID + " doesn't exit!!";
        }
    }

    //Delete details using ID--------------------
    public void deleteCustomerById(Long ID) {
        customerRepository.deleteById(ID);
    }

    //Get/Search customer details using first name--------------------
    public List<Customer> findByFirstNameContaining(String firstName) {
        customerRepository.findByFirstNameContaining(firstName);
        return customerRepository.findByFirstNameContaining(firstName);
    }

    //Patch method to update partial field update--------------------
    public String updateCustomerPartially(@RequestBody Customer updatedCustomer, @PathVariable Long ID) {
        Optional<Customer> customerOptional = customerRepository.findById(ID);
        if (customerOptional.isPresent()) {
            //Customer exists
            Customer existingCustomerData = customerOptional.get();
            if (updatedCustomer.getFirstName() != null) {
                existingCustomerData.setFirstName(updatedCustomer.getFirstName());
            }
            if (updatedCustomer.getLastName() != null) {
                existingCustomerData.setLastName(updatedCustomer.getLastName());
            }
            if (updatedCustomer.getAddress() != null) {
                existingCustomerData.setAddress(updatedCustomer.getAddress());
            }
            if (updatedCustomer.getDob() != null) {
                existingCustomerData.setDob(updatedCustomer.getDob());
            }
            if (updatedCustomer.getGender() != null) {
                existingCustomerData.setGender(updatedCustomer.getGender());
            }
            if (updatedCustomer.getPhone() != null) {
                existingCustomerData.setPhone(updatedCustomer.getPhone());
            }
            if (updatedCustomer.getEmail() != null) {
                existingCustomerData.setEmail(updatedCustomer.getEmail());
            }
            if (updatedCustomer.getActive() != null) {
                existingCustomerData.setActive(updatedCustomer.getActive());
            }
            if (updatedCustomer.getStatus() != null) {
                existingCustomerData.setStatus(updatedCustomer.getStatus());
            }
            //Ticket list information**********
            if (updatedCustomer.getTicketList() != null) {
                existingCustomerData.setTicketList(updatedCustomer.getTicketList());
            }
            customerRepository.save(existingCustomerData);
            return "Customer partial field update successfully!!";
        } else {
            return "Customer ID number" + updatedCustomer.getCustomerID() + "not found!!";
        }
    }
}
