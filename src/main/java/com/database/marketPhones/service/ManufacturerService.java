package com.database.marketPhones.service;

import com.database.marketPhones.model.Manufacturer;
import com.database.marketPhones.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }
    public Manufacturer findById(Long idM){
        return manufacturerRepository.getOne(idM);
    }
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
    public Manufacturer saveManufacturer(Manufacturer manufacturer){ return manufacturerRepository.save(manufacturer); }
    public void deleteById(Long idM){
        manufacturerRepository.deleteById(idM);
    }
}
