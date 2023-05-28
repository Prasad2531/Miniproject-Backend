//package com.customer;
//
//import com.customer.entity.Customer;
//import com.customer.repository.CustomerRepository;
//import com.customer.service.CustomerService;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class CustomerServiceApplicationTests {
//
//	ArrayList<Medicine> med = new ArrayList<Medicine>();
//	Medicine firstMedicine = new Medicine(35, "Vicks_1", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35,1);
//	Medicine secondMedicine = new Medicine(36, "Vicks_2", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35,1);
//	Medicine thirdMedicine = new Medicine(37, "Vicks_3", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35,1);
//
//	List<Medicine> medicinesOne = new ArrayList<>();
//	Medicine medicineOne = new Medicine(38, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35,2);
//
//	Customer customerOne = new Customer(1, "Prasad", "Patare", "8888496629", "prasad@gmail.com", med, new Date(2001-06-04));
//	Customer customerTwo = new Customer(2, "Amit", "Shinde", "9766107234", "ams941@gmail.com", medicinesOne, new Date(2001-06-04));
//
//
//	@Autowired
//	private CustomerService customerService;
//
//	@MockBean
//	private CustomerRepository customerRepository;
//
//	@Test
//	public void getCustomerTest(){
//		when(customerRepository.findAll()).thenReturn(Stream.of(
//				customerOne
//		).collect(Collectors.toList()));
//
//		List<Customer> customers = customerService.getCustomer();
//		assertEquals(1, customers.size());
//
//		Customer customer = customers.get(0);
//		assertEquals("Prasad", customer.getFirstName());
//		assertEquals("Patare", customer.getLastName());
//		assertEquals("prasad@gmail.com", customer.getEmail());
//
//	}
//	@Test
//	public void addCustomerTest() {
//		Customer c1= customerService.addCustomer(customerTwo);
//		assertEquals(2,c1.getId());
//		assertEquals("Amit",c1.getFirstName());
//	}
//
//	@Test
//	public void updateCustomerTest() {
//
//		when(customerRepository.save(customerTwo)).thenReturn(customerTwo);
//
//		Customer customer1 = customerRepository.save(customerTwo);
//
//		assertEquals("Amit", customer1.getFirstName());
//		customerTwo.setFirstName("Meghraj");
//		customerService.updateCustomer(customerTwo);
//		assertEquals("Meghraj", customer1.getFirstName());
//	}
//
//	@Test
//	public void deleteCustomerTest(){
//		when(customerRepository.findAll()).thenReturn(Stream.of(
//				customerTwo
//		).collect(Collectors.toList()));
//
//		List<Customer> customers = customerService.getCustomer();
//		assertEquals(1, customers.size());
//		Customer customer = customers.get(0);
//		customerService.deleteCustomer(customer.getId());
//		List<Customer> cust=customerRepository.findAll();
//
//		assertEquals(cust.size(),customerService.getCustomer().size());
//	}
//
//
//
//
//
//
//
//
//
//
//}