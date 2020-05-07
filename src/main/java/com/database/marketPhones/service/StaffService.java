package com.database.marketPhones.service;

import com.database.marketPhones.model.Staff;
import com.database.marketPhones.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    public Staff findById(Long idE){
        return staffRepository.getOne(idE);
    }
    public List<Staff> findAll(){
        return staffRepository.findAll();
    }
    public Staff saveStaff(Staff staff){
        return staffRepository.save(staff);
    }
    public void deleteById(Long idE){ staffRepository.deleteById(idE); }
}
