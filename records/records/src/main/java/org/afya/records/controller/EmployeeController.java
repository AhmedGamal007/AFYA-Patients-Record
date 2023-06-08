package org.afya.records.controller;

import org.afya.records.dto.EmployeeDTO;
import org.afya.records.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/afya")
@RequiredArgsConstructor
public class EmployeeController {
 
    private final EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println("Asdasd");
        employeeService.addEmployee(employeeDTO);
    }
    @GetMapping("/viewEmployee")
    public  ResponseEntity viewAll(){
    return ResponseEntity.ok().body(employeeService.viewAll());
    }
    @DeleteMapping("/removeEmployee/{id}")
    public void removeEmployee(@PathVariable Integer id){

        employeeService.removeEmployee(id);
    }
}
