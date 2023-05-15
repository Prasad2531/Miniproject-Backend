package com.medicine.service;

import java.util.List;
import java.util.Optional;


import com.medicine.Entity.Medicine;
import org.springframework.stereotype.Service;


public interface MedicineService {
    public String addMedicine(Medicine medicine);
    public String deleteMedicine(int id);
    public String updateMedicine(Medicine medicine);
    public List<Medicine> getMedicine();

    public List<Medicine> getMedicineofUser(int userId);


}
