package org.afya.records.controller;

import lombok.RequiredArgsConstructor;
import org.afya.records.dto.EmployeeDTO;
import org.afya.records.dto.FinanceDTO;
import org.afya.records.dto.PatientDTO;
import org.afya.records.service.FinanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/afya")
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService financeService;
    @GetMapping("/viewStats")
    public ResponseEntity viewStats(){
       return ResponseEntity.ok().body(financeService.viewStats());
    }
    @GetMapping("/viewFinance")
    public ResponseEntity viewFinance(){
        return ResponseEntity.ok().body(financeService.viewFinance());
    }

    @PutMapping("/editFinance/{id}")
    public ResponseEntity editPatient(@PathVariable Integer id, @RequestBody FinanceDTO financeDTO){
        financeService.editFinance(id,financeDTO);
        return ResponseEntity.ok().body(financeDTO);
    }
    @PostMapping("/viewFilteredStats")
    public ResponseEntity viewFilteredStats(@RequestBody String[] date){
        return ResponseEntity.ok().body(financeService.viewFilteredStats(date[0],date[1]));
    }
    @GetMapping("/yearsFound")
    public ResponseEntity yearsFound(){
        return ResponseEntity.ok().body(financeService.yearsFound());
    }
}
