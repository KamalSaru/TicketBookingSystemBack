package com.diyo.TicketBookingSystem.controller;

import com.diyo.TicketBookingSystem.entity.Customer;
import com.diyo.TicketBookingSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;


@RestController//used to create REST ful web services using Spring MVC,mapping request data
@RequestMapping("customer")//used to map web requests onto specific handler classes and/or handler methods
@CrossOrigin("http://localhost:4200/") //Angular connections from java(backend)
public class CustomerController {
    @Autowired//used for automatic dependency injection
    private CustomerService customerService;

    //Posting details information----------
    @PostMapping
    public String saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return "Customer details save successfully!!";
    }

    //Get all list information------
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    //Get details using ID-----------
    @GetMapping("/{ID}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("ID") Long ID){
        return ResponseEntity.ok(customerService.getCustomerById(ID));
    }

    //Edit/Update the details--------
    @PutMapping("/{ID}")
    public ResponseEntity<String >updateCustomer(@RequestBody Customer customer, @PathVariable("ID") Long ID){
        return ResponseEntity.ok(customerService.updateCustomer(customer, ID));
    }

    //Delete details using ID------------
    @DeleteMapping("/{ID}")
    public ResponseEntity<String>deleteCustomerById(@PathVariable("ID") Long ID){
        customerService.deleteCustomerById(ID);
        return ResponseEntity.ok("Customer details is successfully deleted!!");
    }

    //Get details using first name---------
    @GetMapping("/search/{firstName}")
    public ResponseEntity<List<Customer>> searchCustomer(@PathVariable("firstName")String firstName){
        return ResponseEntity.ok(customerService.findByFirstNameContaining(firstName));
    }

    //Patch method use to update partial field in the column-----------------
    @PatchMapping("/{ID}")
    public ResponseEntity<String> updateCustomerPartially(@RequestBody Customer updatedCustomer, @PathVariable("ID") Long ID){
        customerService.updateCustomerPartially(updatedCustomer,ID);
        return ResponseEntity.ok("Customer partial field update successfully!!");
    }

}
