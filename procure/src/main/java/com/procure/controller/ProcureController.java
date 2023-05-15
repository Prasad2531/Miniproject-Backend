package com.procure.controller;

import com.procure.entity.PurchaseOrder;
import com.procure.repository.ProcureRepository;
import com.procure.service.ProcureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procure")
public class ProcureController {
    @Autowired
    private ProcureService procureService;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProcureRepository procureRepo;
    @GetMapping("/home")
    public String home(){
        return "Home";
    }
    /**
     * This method retrieves a list of all Purchase_Order entities.
     * @return List of Purchase_Order
     */
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="/getAllPurchaseOrder")
    public List<PurchaseOrder> getAllPurchaseOrder() {
        return procureService.getPurchaseOrder();
//		System.out.println("Get list of all Purchase_Order successfully");
//		return purOr;
    }

    /**
     * This method inserts a new Purchase_Order entity into the database.
     * @param obj The Purchase_Order object to be inserted, validated using @Valid annotation
     * @return the saved purchase order object
     */
    @CrossOrigin("http://localhost:4200")
    @PostMapping(path="/insertPurchaseOrder")
    public String insertPurchaseOrder(@Valid @RequestBody PurchaseOrder obj) {
        System.out.println("Received data : " + obj);
        return procureService.addPurchaseOrder(obj);
//		return "Record Inserted Successfully";
    }

    /**
     * This method updates an existing Purchase_Order entity in the database.
     * @param obj The Purchase_Order object containing the updated data. Must be a valid object.
     * @return The updated PurchaseOrder object.
     * @throws ChangeSetPersister.NotFoundException if the PurchaseOrder object is not found in the database.
     */
    @CrossOrigin("http://localhost:4200")
    @PutMapping(path="/updatePurchaseOrder")
    public String updatePurchaseOrder(@Valid @RequestBody PurchaseOrder obj) throws ChangeSetPersister.NotFoundException {
        Optional<PurchaseOrder> purOr = procureRepo.findById(obj.getId());

        if (!purOr.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        PurchaseOrder purOrUpd = purOr.get();
        purOrUpd.setPurchaseDate(obj.getPurchaseDate());
        purOrUpd.setManufacturer(obj.getManufacturer());
        purOrUpd.setExpectedDeliveryDate(obj.getExpectedDeliveryDate());
        purOrUpd.setTotalCost(obj.getTotalCost());
        System.out.println("Received Data in PutMapping :" + obj);
        return procureService.updatePurchaseOrder(purOrUpd);
    }

    /**
     * This method deletes a Purchase_Order entity from the database using the given id.
     * @param id The id of the Purchase_Order to be deleted.
     * @return String message indicating success or failure of the operation.
     */
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping (path="/deletePurchaseOrder/{id}")
    public String deletePurchaseOrder(@PathVariable int id) {
        System.out.println("Purchase_Order record deleted. Given id : " + id);
        procureService.deletePurchaseOrder(id);
        return "Record Deleted Successfully";
    }
}
