package com.database.marketPhones.controller;

import com.database.marketPhones.model.Customer;
import com.database.marketPhones.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String findAll(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/customer/customer-list";
    }
    @GetMapping("/customer-create")
    public String createCustomerForm(Customer customer){
        return "/customer/customer-create";
    }
    @PostMapping("/customer-create")
    public String createCustomer(@Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/customer/customer-create";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    @GetMapping("customer-delete/{idC}")
    public String deleteCustomer(@PathVariable("idC") Long idC){
        customerService.deleteById(idC);
        return "redirect:/customers";
    }
    @GetMapping("customer-update/{idC}")
    public String updateCustomerForm(@PathVariable("idC") Long idC, Model model){
        Customer customer =customerService.findById(idC);
        model.addAttribute("customer", customer);
        return "/customer/customer-update";
    }
    @PostMapping("/customer-update")
    public String updateCustomer(@Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/customer/customer-update";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
}
