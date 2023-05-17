package com.procure.service;

import com.procure.entity.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProcureService {
    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder);
    public String deletePurchaseOrder(int id);
    public String updatePurchaseOrder(PurchaseOrder purchaseOrder);
    public List<PurchaseOrder> getPurchaseOrder();
}
