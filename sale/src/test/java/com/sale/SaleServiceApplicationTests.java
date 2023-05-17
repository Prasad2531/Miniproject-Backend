package com.sale;

import com.netflix.discovery.converters.Auto;
import com.sale.entity.Customer;
import com.sale.entity.Medicine;
import com.sale.entity.Sale;
import com.sale.repository.SaleRepository;
import com.sale.service.SaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SaleServiceApplicationTests {

	List<Medicine> medicineOne= new ArrayList<>();

	List<Customer> customerOne=new ArrayList<>();
	//	Medicine medicineOne = new Medicine(38, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);
//	Customer customerOne = new Customer(1, "Prasad", "Patare", "8888496629", "prasad@gmail.com",medicineOne, new Date(2001-06-04));
	Sale sales = new Sale(10,new Date(2020-2-22),customerOne,new BigDecimal(20d));

	@Autowired
	private SaleService saleService;

	@MockBean
	private SaleRepository saleRepository;

	@Test
	public void addSalesTest() {
		Sale c1= saleService.addSales(sales);
		assertEquals(10,c1.getId());
	}

	@Test
	public void deleteSalesTest(){
		when(saleRepository.findAll()).thenReturn(Stream.of(
				sales
		).collect(Collectors.toList()));

		List<Sale> sales1 = saleService.getSale();
		assertEquals(1, sales1.size());
		Sale customer = sales1.get(0);
		saleService.deleteSales(customer.getId());
		List<Sale> cust=saleRepository.findAll();

		assertEquals(cust.size(),saleService.getSale().size());
	}

	@Test
	public void updateCustomerTest() {

		when(saleRepository.save(sales)).thenReturn(sales);

		Sale order = saleRepository.save(sales);

		assertEquals("Sales Updated", saleService.updateSales(sales));
	}

	@Test
	public void getPurchaseOrderTest(){
		when(saleRepository.findAll()).thenReturn(Stream.of(
				sales
		).collect(Collectors.toList()));

		List<Sale> purchaseOrder1 = saleService.getSale();
		assertEquals(1, purchaseOrder1.size());
	}







}
