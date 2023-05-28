package com.sale.service;

import com.sale.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sale.entity.Sales;

import java.sql.Date;
import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SaleRepository dao;
    public String addSale(Sales sale){
        dao.save(sale);
        return "Sale added";
    }
    public String deleteSale(int id){
       Sales sale=dao.getById(id);
        dao.delete(sale);
        return "sale deleted "+id;
    }
    public List<Sales> getSaleByDate(Date date){
        List<Sales> sale=dao.findByDate(date);
        return sale;
    }
    public String updateSale(Sales sale){
        dao.save(sale);
        return "Sale Updated";
    }
    public List<Sales> getSales(){
        List<Sales> sale=dao.findAll();
        return sale;
    }

}
