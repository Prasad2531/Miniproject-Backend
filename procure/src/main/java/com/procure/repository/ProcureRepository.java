package com.procure.repository;

import com.procure.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcureRepository extends JpaRepository<PurchaseOrder,Integer> {
}
