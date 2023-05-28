package com.procure.service;

import com.procure.entity.Procure;
import com.procure.repository.ProcureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcureService {

    @Autowired
    ProcureRepository procureRepository;

    public Procure addProcure(Procure procure){
        return procureRepository.save(procure);
    }

    public List<Procure> getAll(){
        return procureRepository.findAll();
    }

    public List<Procure> getProcureByName(String name){
        return procureRepository.getMedicineName(name);
    }

    public Procure getProcure(int id){
        Optional<Procure> med = procureRepository.findById(id);
        return med.get();
    }

    public void deleteProcure(int id){
        procureRepository.deleteById(id);
    }

    public Procure updateMedicine(Procure procure){
        Optional<Procure> med = procureRepository.findById(procure.getMedicineId());

        Procure updPro = med.get();
        updPro.setMedicineId(procure.getMedicineId());
        updPro.setMedicineName(procure.getMedicineName());
        updPro.setDescription(procure.getDescription());
        updPro.setDosage(procure.getDosage());
        updPro.setPrice(procure.getPrice());
        updPro.setManufactureDate(procure.getManufactureDate());
        updPro.setExpiryDate(procure.getExpiryDate());
        updPro.setCurrentStock(procure.getCurrentStock());

        Procure procure1 = procureRepository.save(updPro);
        return procure1;
    }





}

