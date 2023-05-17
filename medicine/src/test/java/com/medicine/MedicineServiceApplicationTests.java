package com.medicine;

import com.medicine.Entity.Medicine;
import com.medicine.repository.MedicineRepository;
import com.medicine.service.MedicineService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MedicineServiceApplicationTests {

	@Autowired
	private MedicineService medicineService;

	@MockBean
	private MedicineRepository medicineRepository;

	@Test
	public void getMedicineTest(){
		when(medicineRepository.findAll()).thenReturn(Stream.of(
				new Medicine(1,"Paracetamol","For Fever","2 times a day",new BigDecimal(32.32d),new Date(2003-02-21),new Date(2004-02-20),20,12),
				new Medicine(4,"Paracetamol","For Fever","2 times a day",new BigDecimal(300.32d),new Date(2003-02-21),new Date(2005-02-20),10,11)
		).collect(Collectors.toList()));

		assertEquals(2,medicineService.getMedicine().size());
	}

	@Test
	public void addMedicineTest() {
		Medicine medicine= new Medicine(111,"Dolo","For Cold","1 times a day",new BigDecimal(12.32d),new Date(2103-02-21),new Date(2104-02-20),30,2);
		when(medicineRepository.save(medicine)).thenReturn(medicine);

		assertEquals("Medicine added",medicineService.addMedicine(medicine));
	}

	@Test
	public void getMedicineofUserTest(){
		int id =1;

		when(medicineRepository.findAllByCustomerId(id)).thenReturn(Stream.of(
				new Medicine(1,"Paracetamol","For Fever","2 times a day",new BigDecimal(32.32d),new Date(2003-02-21),new Date(2004-02-20),20,12)
		).collect(Collectors.toList()));

		assertEquals(1,medicineService.getMedicineofUser(id).size());
	}

	@Test
	public void deleteMedicineTest(){
		int id=2;
		medicineRepository.deleteById(id);

		assertEquals("Mediciner deleted 2",medicineService.deleteMedicine(id));

	}

	@Test
	public void updateMedicineTest(){
		Medicine medicine= new Medicine(101,"Odomos","Mosquito Repellent","Apply in Night",new BigDecimal(70d),new Date(2103-02-21),new Date(2104-02-20),30,12);

		when(medicineRepository.save(medicine)).thenReturn(medicine);

		assertEquals("Medicine Updated",medicineService.updateMedicine(medicine));

	}
}
