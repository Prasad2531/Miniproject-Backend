package com.procure;

import com.procure.entity.Manufacturer;
import com.procure.entity.Medicine;
import com.procure.entity.PurchaseOrder;
import com.procure.repository.ProcureRepository;
import com.procure.service.ProcureService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProcureServiceApplicationTests {

	Medicine medicineOne = new Medicine(38, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);

	List<Manufacturer> manufacturer = new ArrayList<Manufacturer>();
//    Manufacturer manufacturer= new Manufacturer(20,"Sameer","Capsol",new Date(2012-12-10),10);

	PurchaseOrder purchaseOrder=new PurchaseOrder(10,new Date(2012-12-10),manufacturer,new Date(2012-12-12),new BigDecimal(134.5d));

	@Autowired
	private ProcureService procureService;

	@MockBean
	private ProcureRepository procureRepository;


	@Test
	public void getPurchaseOrderTest(){
		when(procureRepository.findAll()).thenReturn(Stream.of(
				purchaseOrder
		).collect(Collectors.toList()));

		List<PurchaseOrder> purchaseOrder1 = procureService.getPurchaseOrder();
		assertEquals(1, purchaseOrder1.size());
	}

	@Test
	public void addPurchaseOrderTest() {
		PurchaseOrder c1= procureService.addPurchaseOrder(purchaseOrder);
		assertEquals(10,c1.getId());
	}

	@Test
	public void deletePurchaseOrderTest(){
		when(procureRepository.findAll()).thenReturn(Stream.of(
				purchaseOrder
		).collect(Collectors.toList()));

		List<PurchaseOrder> order1 = procureService.getPurchaseOrder();
		assertEquals(1, order1.size());
		PurchaseOrder cust = order1.get(0);
		procureService.deletePurchaseOrder(cust.getId());
		List<PurchaseOrder> cust2=procureRepository.findAll();

		assertEquals(cust2.size(),procureService.getPurchaseOrder().size());
	}

	@Test
	public void updateCustomerTest() {

		when(procureRepository.save(purchaseOrder)).thenReturn(purchaseOrder);

		PurchaseOrder order = procureRepository.save(purchaseOrder);

		assertEquals("PurchaseOrder Updated", procureService.updatePurchaseOrder(purchaseOrder));
	}

}
