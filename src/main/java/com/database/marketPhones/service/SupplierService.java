package com.database.marketPhones.service;

import com.database.marketPhones.model.Supplier;
import com.database.marketPhones.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier findById(Long idS){
        return supplierRepository.getOne(idS);
    }

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public Supplier saveSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void deleteById(Long idS){
        supplierRepository.deleteById(idS);
    }
}
