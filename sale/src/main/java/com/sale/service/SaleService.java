package com.sale.service;

import com.sale.entity.Sale;

import java.util.List;

public interface SaleService {
    public String addSales(Sale sales);

    public String deleteSales(int id);

    public String updateSales(Sale sale);

    public List<Sale> getSale();
}
