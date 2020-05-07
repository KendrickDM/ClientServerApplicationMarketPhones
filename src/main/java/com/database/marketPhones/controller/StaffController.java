package com.database.marketPhones.controller;

import com.database.marketPhones.model.Staff;
import com.database.marketPhones.service.StaffService;
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
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staffs")
    public String findAll(Model model){
        List<Staff> staffs = staffService.findAll();
        model.addAttribute("staffs", staffs);
        return "/staff/staff-list";
    }
    @GetMapping("/staff-create")
    public String createStaffForm(Staff staff){
        return "/staff/staff-create";
    }
    @PostMapping("/staff-create")
    public String createStaff(@Valid Staff staff, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/staff/staff-create";
        }
        staffService.saveStaff(staff);
        return "redirect:/staffs";
    }
    @GetMapping("staff-delete/{idE}")
    public String deleteStaff(@PathVariable("idE") Long idE){
        staffService.deleteById(idE);
        return "redirect:/staffs";
    }
    @GetMapping("staff-update/{idE}")
    public String updateStaffForm(@PathVariable("idE") Long idE, Model model){
        Staff staff =staffService.findById(idE);
        model.addAttribute("staff", staff);
        return "/staff/staff-update";
    }
    @PostMapping("/staff-update")
    public String updateStaff(@Valid Staff staff, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/staff/staff-create";
        }
        staffService.saveStaff(staff);
        return "redirect:/staffs";
    }
}
