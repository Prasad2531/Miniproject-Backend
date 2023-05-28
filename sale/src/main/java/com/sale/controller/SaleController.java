package com.sale.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.sale.entity.Sales;
import com.sale.repository.SaleRepository;
import com.sale.service.SalesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * This class represents the controller for Sales management
 */
@RequestMapping("/sale")
@RestController
public class SaleController {
    @Autowired
    private SalesService service;
    @Autowired
    private SaleRepository dao;

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path = "/getAllSales")
    public List<Sales> getAllSales() {
        return service.getSales();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(path = "/insertSale")
    public String insertSale(@Valid @RequestBody Sales obj) {
        System.out.println("Received data : " + obj);
        return service.addSale(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping(path = "/updateSale")
    public String updateSale(@RequestBody Sales obj) throws Exception {
        Optional<Sales> sale = dao.findById(obj.getSaleId());

        if (!sale.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        Sales updatedObj = sale.get();
        updatedObj.setDate(obj.getDate());
        updatedObj.setMedicineName(obj.getMedicineName());
        updatedObj.setPrice(obj.getPrice());
        updatedObj.setMedicineQunatity(obj.getMedicineQunatity());

        return service.updateSale(obj);

    }
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping (path="/deleteSale/{id}")
    public String deleteSale(@PathVariable int id) {
        System.out.println("Sale record deleted. Given id : " + id);
        service.deleteSale(id);
        return "Record Deleted Successfully";
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="getSaleByDate/{date}")
    public List<Sales> getSaleByDate(@PathVariable Date date){
        return service.getSaleByDate(date);

    }
}