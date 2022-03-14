package com.springdemo.controller;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
        
    @RequestMapping("/list")
    public String listCustomer(Model theModel) {
        
        //get Customer from DAO
        List<Customer> theCustomer = customerService.getCustomers();
        
        //add  the customer to model
        theModel.addAttribute("customers",theCustomer);
        
        //value returns
        return "list-customer";
    }
    
    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        
        Customer theCustomer = new Customer();
        
        theModel.addAttribute("customer",theCustomer);
        
        return "customer-form";
    }
    
    @RequestMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        
        //save customer
        customerService.saveCustomer(theCustomer);
        
        return "redirect:/customer/list";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        
        Customer theCustomer = customerService.updateCustomer(theId);
        
        theModel.addAttribute("customer",theCustomer);
        
        return "customer-form";
    }
    
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        
        customerService.deleteCustomer(theId);
        
        return "redirect:/customer/list";
    }
}
