package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
 /*   @Query("""
                      SELECT p FROM Patient p
                  WHERE (LOWER(p.firstName) LIKE LOWER(CONCAT('%', :term, '%')) OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :term, '%')))
            """)
    List<Patient> search(@Param("term") String term);

    */

    @Query("""
    SELECT p FROM Patient p
    WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%', :term, '%'))
       OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :term, '%'))
""")    List<Patient> search(@Param("term") String term, Pageable pageable);
}
