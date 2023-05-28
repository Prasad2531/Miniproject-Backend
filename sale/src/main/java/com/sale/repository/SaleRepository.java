package com.sale.repository;

import com.sale.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sales,Integer> {

    List<Sales> findByDate(Date date);
}
