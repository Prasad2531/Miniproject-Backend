package com.sale.controller;

import java.util.List;
import java.util.Optional;

import com.sale.entity.Sale;
import com.sale.repository.SaleRepository;
import com.sale.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * This class represents the controller for Sales management
 */
@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    private SaleRepository saleRepo;

    @GetMapping("/home")
    public String home(){
        return "Home from sale";
    }
    /**
     * Get a list of all Sale records
     * @return List of Sale records
     */
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="/getAllSales")
    public List<Sale> getAllSales() {
        return saleService.getSale();
//		System.out.println("Get list of all Sales successfully");
//		return sale;
    }

    /**
     * Insert a new Sales record
     * @param obj - Sales object to insert
     * @return the saved sales object
     */
    @CrossOrigin("http://localhost:4200")
    @PostMapping(path="/insertSales")
    public String insertSales(@Valid @RequestBody Sale obj) {
        System.out.println("Received data : " + obj);
        return saleService.addSales(obj);
//		return "Record Inserted Successfully";
    }

    /**
     * Update an existing Sales record
     * @param obj - Sales object to update
     * @return The updated Sales object.
     * @throws ChangeSetPersister.NotFoundException if the Sales object is not found in the database.
     */
    @CrossOrigin("http://localhost:4200")
    @PutMapping(path="/updateSales")
    public String updateSales(@Valid @RequestBody Sale obj) throws ChangeSetPersister.NotFoundException {
        Optional<Sale> sale = saleRepo.findById(obj.getId());

        if (!sale.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }

        Sale saleUpd = sale.get();
        saleUpd.setSaleDate(obj.getSaleDate());
        saleUpd.setCustomer(obj.getCustomer());
        saleUpd.setTotalCost(obj.getTotalCost());
        System.out.println("Received Data in PutMapping :" + obj);
        return saleService.updateSales(obj);
    }

    /**
     * Delete an existing Sales record by its id
     * @param id - Id of the Sales record to delete
     * @return String message indicating if the record was deleted successfully or not
     */
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping (path="/deleteSales/{id}")
    public String deleteSales(@PathVariable int id) {
        System.out.println("Sales record deleted. Given id : " + id);
        saleService.deleteSales(id);
        return "Record Deleted Successfully";
    }

}
