package com.database.marketPhones.controller;

import com.database.marketPhones.model.Manufacturer;
import com.database.marketPhones.service.ManufacturerService;
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
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/manufacturers")
    public String findAll(Model model){
        List<Manufacturer> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "/manufacturer/manufacturer-list";
    }
    @GetMapping("/manufacturer-create")
    public String manufacturerCreateForm(Manufacturer manufacturer){
        return "/manufacturer/manufacturer-create";
    }
    @PostMapping("/manufacturer-create")
    public String manufacturerCreate(@Valid Manufacturer manufacturer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/manufacturer/manufacturer-create";
        }
        manufacturerService.saveManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }
    @GetMapping("manufacturer-delete/{idM}")
    public String deleteManufacturer(@PathVariable("idM") Long idM){
        manufacturerService.deleteById(idM);
        return "redirect:/manufacturers";
    }
    @GetMapping("manufacturer-update/{idM}")
    public String updateManufacturerForm(@PathVariable("idM") Long idM, Model model){
        Manufacturer manufacturer = manufacturerService.findById(idM);
        model.addAttribute("manufacturer", manufacturer);
        return "/manufacturer/manufacturer-update";
    }
    @PostMapping("/manufacturer-update")
    public String updateManufacturer(@Valid Manufacturer manufacturer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/manufacturer/manufacturer-update";
        }
        manufacturerService.saveManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }
}
