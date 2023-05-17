package com.medicine.service;

import com.medicine.Entity.Medicine;
import com.medicine.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@ComponentScan
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    private MedicineRepository medicineRepo;
    public String addMedicine(Medicine medicine){
        medicineRepo.save(medicine);
        return "Medicine added";
    }
    public String deleteMedicine(int id){
        Medicine medicine=medicineRepo.getById(id);
        medicineRepo.delete(medicine);
        return "Mediciner deleted "+id;
    }
    public String updateMedicine(Medicine medicine){
        medicineRepo.save(medicine);
        return "Medicine Updated";
    }
    public List<Medicine> getMedicine(){
        List<Medicine> medicine=medicineRepo.findAll();
        return medicine;
    }
    @Override
    public List<Medicine> getMedicineofUser(int custId){
        List<Medicine> med = medicineRepo.findAllByCustomerId(custId);
        return med;

    }

}
