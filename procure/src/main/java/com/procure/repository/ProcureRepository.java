package com.procure.repository;

import com.procure.entity.Procure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcureRepository extends JpaRepository<Procure,Integer> {

//    @Query("select u from Procure u where u.medicineName=:N ")
//    public List<Procure> getMedicineName(@Param("N") String name);
}
