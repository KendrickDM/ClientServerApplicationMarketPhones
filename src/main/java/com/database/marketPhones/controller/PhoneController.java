package com.database.marketPhones.controller;

import com.database.marketPhones.model.Phone;
import com.database.marketPhones.service.ManufacturerService;
import com.database.marketPhones.service.PhoneService;
import com.database.marketPhones.service.SupplierService;
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
public class PhoneController {

    @Autowired
    public void setManufacturerService(ManufacturerService manufacturerService) { this.manufacturerService = manufacturerService; }
    @Autowired
    public void setSupplierService(SupplierService supplierService) { this.supplierService = supplierService; }

    private ManufacturerService manufacturerService;

    private SupplierService supplierService;

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @GetMapping("/phones")
    public String findAll(Model model){
        List<Phone> phones = phoneService.findAll();
        model.addAttribute("phones", phones);
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "/phone/phone-list";
    }
    @GetMapping("/phone-create")
    public String createForm(Model model) {
        model.addAttribute("phone", new Phone());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "/phone/phone-create";
    }
    @PostMapping("/phone-create")
    public String createPhone(@Valid Phone phone, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/phone/phone-create";
        }
        phoneService.savePhone(phone);
        return "redirect:/phones";
    }
    @GetMapping("phone-delete/{idP}")
    public String deletePhone(@PathVariable("idP") Long idP){
        phoneService.deleteById(idP);
        return "redirect:/phones";
    }
    @GetMapping("phone-update/{idP}")
    public String updatePhoneForm(@PathVariable("idP") Long idP, Model model){
        Phone phone = phoneService.findById(idP);
        model.addAttribute("phone", phone);
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "/phone/phone-update";
    }
    @PostMapping("/phone-update")
    public String updatePhone(@Valid Phone phone, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/phone/phone-update";
        }
        phoneService.savePhone(phone);
        return "redirect:/phones";
    }
}
