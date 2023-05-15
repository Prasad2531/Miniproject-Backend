/**
 * This interface represents the repository for the Medicine entity, providing access to CRUD operations
 * using Spring Data JPA. 
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date or version]
 */

package com.medicine.repository;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.medicine.Entity.Medicine;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

    List<Medicine> findAll(Sort sort);
    public List<Medicine>findAllByCustomerId(int customerId);

}