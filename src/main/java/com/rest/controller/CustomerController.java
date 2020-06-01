package com.rest.controller;

import com.rest.model.Customer;
import com.rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController{


    private CustomerService customerService;

    @RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
    @ResponseStatus(code=HttpStatus.CREATED)
    public void saveCustomer(@RequestBody Customer customer){
        customerService.save(customer);
    }

    @GetMapping("/findCustomer")
    public ResponseEntity<Customer> findCustomerById(@RequestParam int id){
        Customer customer=customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/findAllCustomers")
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> customer=customerService.findAllCustomers();
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteById(id);
    }

    @PutMapping("/replaceCustomer/{id}")
    public ResponseEntity<Customer> replaceCustomer(@RequestBody Customer customer, @PathVariable Integer id){
        Customer replacedCustomer=customerService.replaceCustomer(customer, id);
        return ResponseEntity.ok(replacedCustomer);
    }

    @GetMapping("/findDistinctLocation")
    public ResponseEntity<List<String>> findDistinctLocation(){
        List<String> list=customerService.findDistinctLocation();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findNizh")
    public ResponseEntity<List<String>> findNizh(){
        List<String> result=customerService.findNizh();
        return ResponseEntity.ok(result);
    }
}
