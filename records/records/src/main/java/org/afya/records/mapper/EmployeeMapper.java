package org.afya.records.mapper;

import org.afya.records.dto.EmployeeDTO;
import org.afya.records.model.Employee;

public class EmployeeMapper {
    public static EmployeeDTO employeeToEmployeeDTO(Employee employee){
        return EmployeeDTO
        .builder()
        .id(employee.getId())
        .employeeName(employee.getEmployeeName())
        .build();
    }

    public static Employee employeeDTOToEmployee(EmployeeDTO employeeDTO){
        System.out.println(employeeDTO.getEmployeeName());
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        System.out.println(employee.getEmployeeName());
        return employee;
    }
}
