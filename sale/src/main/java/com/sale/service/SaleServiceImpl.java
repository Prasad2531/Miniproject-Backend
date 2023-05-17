package com.sale.service;

import com.sale.entity.Sale;
import com.sale.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    private SaleRepository saleRepo;
    public Sale addSales(Sale sales){
        saleRepo.save(sales);
        return sales;
    }
    public String deleteSales(int id){
        Sale sale=saleRepo.getById(id);
        saleRepo.delete(sale);
        return "Sales deleted "+id;
    }
    public String updateSales(Sale sale){
        saleRepo.save(sale);
        return "Sales Updated";
    }
    public List<Sale> getSale(){
        List<Sale> sale=saleRepo.findAll();
        return sale;
    }

}
