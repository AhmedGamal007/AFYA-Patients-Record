package org.afya.records.service;

import lombok.RequiredArgsConstructor;
import org.afya.records.dto.FinanceDTO;
import org.afya.records.dto.FinanceStatistics;
import org.afya.records.dto.PatientDTO;
import org.afya.records.mapper.PatientMapper;
import org.afya.records.model.Finance;
import org.afya.records.model.Patient;
import org.afya.records.repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private final FinanceRepository financeRepository;

    public FinanceStatistics viewStats(){
        return FinanceStatistics.builder()
                .total(financeRepository.totalAmount())
                .paid(financeRepository.paidAmount())
                .left(financeRepository.leftAmount())
                .build();

    }
    public List<Integer> yearsFound(){
        return financeRepository.yearsFound();
    }
    public FinanceStatistics viewFilteredStats(String year, String month){
        if(year == null || year.length() == 0) year = "%";
        if(month == null || year.length() == 0) month = "%";
        String date = year+"-"+month+"-%";
        System.out.println(financeRepository.totalAmountStat(year+"-"+month+"-%"));
        return FinanceStatistics.builder()
                .total(financeRepository.totalAmountStat(date))
                .paid(financeRepository.paidAmountStat(date))
                .left(financeRepository.leftAmountStat(date))
                .build();
    }
    public List<Finance> viewFinance(){
        return financeRepository.findAll();
    }

    public void editFinance(Integer id, FinanceDTO financeDTO){
        Finance financeToUpdate = financeRepository.findById(id).orElse(null);
        financeToUpdate.setTotal(financeDTO.getTotal());
        financeToUpdate.setPaid(financeDTO.getPaid());
        financeToUpdate.setLeft(financeDTO.getLeft());
        financeRepository.save(financeToUpdate);

    }
}
