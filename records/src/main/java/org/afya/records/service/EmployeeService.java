package org.afya.records.service;

import java.util.List;

import org.afya.records.dto.EmployeeDTO;
import org.afya.records.mapper.EmployeeMapper;
import org.afya.records.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<EmployeeDTO> viewAll(){
        return employeeRepository.findAll().stream().map(employee -> EmployeeMapper.employeeToEmployeeDTO(employee)).toList();
    }

    public void addEmployee(EmployeeDTO employeeDTO){
        employeeRepository.save(EmployeeMapper.employeeDTOToEmployee(employeeDTO));
    }

    public void removeEmployee(Integer id){
        employeeRepository.delete(
            employeeRepository.findById(id).orElse(null)
        );
    }
}
