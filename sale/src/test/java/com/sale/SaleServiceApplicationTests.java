//package com.sale;
//
//import com.sale.entity.Sales;
//import com.sale.repository.SaleRepository;
//import com.sale.service.SalesService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class SaleServiceApplicationTests {
//
//	Sales sales = new Sales(10,"Vicks",12, 50,new Date(2020-2-22));
//
//	@Autowired
//	private SalesService saleService;
//
//	@MockBean
//	private SaleRepository saleRepository;
//
//	@Test
//	public void addSalesTest() {
//		Sales c1= saleService.addSale(sales);
//		assertEquals(10,c1.getId());
//	}
//
//	@Test
//	public void deleteSalesTest(){
//		when(saleRepository.findAll()).thenReturn(Stream.of(
//				sales
//		).collect(Collectors.toList()));
//
//		List<Sales> sales1 = saleService.getSale();
//		assertEquals(1, sales1.size());
//		Sales customer = sales1.get(0);
//		saleService.deleteSales(customer.getId());
//		List<Sales> cust=saleRepository.findAll();
//
//		assertEquals(cust.size(),saleService.getSale().size());
//	}
//
//	@Test
//	public void updateCustomerTest() {
//
//		when(saleRepository.save(sales)).thenReturn(sales);
//
//		Sales order = saleRepository.save(sales);
//
//		assertEquals("Sales Updated", saleService.updateSales(sales));
//	}
//
//	@Test
//	public void getPurchaseOrderTest(){
//		when(saleRepository.findAll()).thenReturn(Stream.of(
//				sales
//		).collect(Collectors.toList()));
//
//		List<Sales> purchaseOrder1 = saleService.getSale();
//		assertEquals(1, purchaseOrder1.size());
//	}
//
//
//
//
//
//
//
//}
