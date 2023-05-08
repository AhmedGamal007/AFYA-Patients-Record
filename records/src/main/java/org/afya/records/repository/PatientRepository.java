package org.afya.records.repository;

import org.afya.records.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer>, JpaSpecificationExecutor<Patient> {
    //    @Query(value = "SELECT p FROM patient as p")
//    Page<Patient> findAllByFilter(PatientSearchDTO patientSearchDTO);

}
