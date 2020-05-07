package com.database.marketPhones.controller;

import com.database.marketPhones.model.Supplier;
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
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public String findAll(Model model){
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "/supplier/supplier-list";
    }
    @GetMapping("/supplier-create")
    public String supplierCreateForm(Supplier supplier){
        return"/supplier/supplier-create";
    }
    @PostMapping("/supplier-create")
    public String supplierCreate(@Valid Supplier supplier, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/supplier/supplier-create";
        }
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }
    @GetMapping("supplier-delete/{idS}")
    public String deleteSupplier(@PathVariable("idS") Long idS){
        supplierService.deleteById(idS);
        return "redirect:/suppliers";
    }
    @GetMapping("/supplier-update/{idS}")
    public String supplierUpdateForm(@PathVariable("idS") Long idS, Model model){
        Supplier supplier = supplierService.findById(idS);
        model.addAttribute("supplier", supplier);
        return "/supplier/supplier-update";
    }
    @PostMapping("supplier-update")
    public String supplerUpdate(@Valid Supplier supplier, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/supplier/supplier-update";
        }
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }
}
