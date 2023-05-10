package org.afya.records.repository;

import java.util.Optional;

import org.afya.records.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // public Optional<Employee> findByName(String employeeName);
}
