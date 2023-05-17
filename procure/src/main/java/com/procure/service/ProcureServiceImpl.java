package com.procure.service;

import com.procure.entity.PurchaseOrder;
import com.procure.repository.ProcureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcureServiceImpl implements ProcureService{
    @Autowired
    private ProcureRepository procureRepo;
    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder){
        procureRepo.save(purchaseOrder);
        return purchaseOrder;
    }
    public String deletePurchaseOrder(int id){
        PurchaseOrder purchaseOrder= procureRepo.getReferenceById(id);
        procureRepo.delete(purchaseOrder);
        return "PurchaseOrder deleted "+id;
    }
    public String updatePurchaseOrder(PurchaseOrder purchaseOrder){
        procureRepo.save(purchaseOrder);
        return "PurchaseOrder Updated";
    }
    public List<PurchaseOrder> getPurchaseOrder(){
        List<PurchaseOrder> purchaseOrder=procureRepo.findAll();
        return purchaseOrder;
    }
}
