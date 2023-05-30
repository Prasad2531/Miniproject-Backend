package com.procure.controller;

import com.procure.entity.Procure;
import com.procure.service.ProcureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/procure")
@CrossOrigin("*")
public class ProcureController {
    @Autowired
    private ProcureService procureService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/getMedicines")
    public List<Procure> getMedicines(){
        return procureService.getAll();
    }

//    @GetMapping(path = "/getMedicineName/{name}")
//    public List<Procure> getMedicines(@PathVariable String name){
//        System.out.println(name);
//        return procureService.getProcureByName(name);
//    }

    @GetMapping("/getMedicine/{id}")
    public Procure getMedicine(@PathVariable int id) {
        return procureService.getProcure(id);
    }


    @PostMapping(path = "/addMedicine")
    public String addMedicine(@RequestBody Procure procure){
        procureService.addProcure(procure);
        return "Procure Added Successfully";
    }

    @PutMapping(path = "/updateMedicine/{medicineId}")
    public void updateMedicine(@RequestBody Procure procure){
        procureService.updateMedicine(procure);
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteMedicine(@PathVariable int id)
    {
        procureService.deleteProcure(id);
        return "Record Deleted Successfully";
    }
}
