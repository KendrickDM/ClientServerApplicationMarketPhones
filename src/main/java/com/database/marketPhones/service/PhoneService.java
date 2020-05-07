package com.database.marketPhones.service;

import com.database.marketPhones.model.Phone;
import com.database.marketPhones.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone findById(Long idP){
        return phoneRepository.getOne(idP);
    }

    public List<Phone> findAll(){
        return phoneRepository.findAll();
    }

    public Phone savePhone(Phone phone){
        return phoneRepository.save(phone);
    }

    public void deleteById(Long idP){
        phoneRepository.deleteById(idP);
    }

}
