package org.afya.records.repository;

import org.afya.records.model.Finance;
import org.afya.records.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FinanceRepository extends JpaRepository<Finance,Integer> {
    @Query (nativeQuery = true,value = "SELECT SUM(total) FROM finance")
    Double totalAmount();
    @Query (nativeQuery = true,value = "SELECT SUM(paid) FROM finance")
    Double paidAmount();

    @Query (nativeQuery = true,value = "SELECT SUM(amount_left) FROM finance")
    Double leftAmount();

    @Query(nativeQuery = true,value = "SELECT SUM(f.total) FROM afya.finance f INNER JOIN afya.patient p ON f.patient_id = p.patient_id WHERE p.arrive_date LIKE ?;")
    Double totalAmountStat(String date);
    @Query(nativeQuery = true,value = "SELECT SUM(f.paid) FROM afya.finance f INNER JOIN afya.patient p ON f.patient_id = p.patient_id WHERE p.arrive_date LIKE ?;")
    Double paidAmountStat(String date);
    @Query(nativeQuery = true,value = "SELECT SUM(f.amount_left) FROM afya.finance f INNER JOIN afya.patient p ON f.patient_id = p.patient_id WHERE p.arrive_date LIKE ?;")
    Double leftAmountStat(String date);

    @Query(nativeQuery = true,value = "SELECT distinct(left(p.arrive_date,4)) as Dat FROM afya.finance f INNER JOIN afya.patient p ON f.patient_id = p.patient_id ORDER BY dat ASC;")
    List<Integer> yearsFound();
    void deleteFinanceByPatient(Patient patient);

    Optional<Finance> findByPatient(Patient patient);
}
