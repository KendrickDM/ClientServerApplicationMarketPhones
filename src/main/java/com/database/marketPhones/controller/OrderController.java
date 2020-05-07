package com.database.marketPhones.controller;

import com.database.marketPhones.model.Order;
import com.database.marketPhones.service.*;
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
public class OrderController {

    @Autowired
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
    @Autowired
    public void setManufacturerService(ManufacturerService manufacturerService) { this.manufacturerService = manufacturerService; }
    @Autowired
    public void setPhoneService(PhoneService phoneService) { this.phoneService = phoneService; }
    @Autowired
    public void setCustomerService(CustomerService customerService){this.customerService = customerService; }

    private CustomerService customerService;

    private PhoneService phoneService;

    private  StaffService staffService;

    private ManufacturerService manufacturerService;

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }
    @GetMapping("/orders")
    public String findAll(Model model){
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        model.addAttribute("staffs", staffService.findAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("phones", phoneService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "/order/order-list";
    }
    @GetMapping("/order-create")
    public String createOrderForm(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("staffs", staffService.findAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("phones", phoneService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "/order/order-create";
    }
    @PostMapping("/order-create")
    public String createOrder(@Valid Order order, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/order/order-create";
        }
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
    @GetMapping("order-delete/{idO}")
    public String deleteOrder(@PathVariable("idO") Long idO){
        orderService.deleteById(idO);
        return "redirect:/orders";
    }
    @GetMapping("order-update/{idO}")
    public String updateOrderForm(@PathVariable("idO") Long idO, Model model){
        Order order =orderService.findById(idO);
        model.addAttribute("order", order);
        model.addAttribute("staffs", staffService.findAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("phones", phoneService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "/order/order-update";
    }
    @PostMapping("/order-update")
    public String updateOrder(@Valid Order order, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/order/order-update";
        }
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
}
