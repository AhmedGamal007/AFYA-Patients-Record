package org.afya.records.mapper;

import org.afya.records.dto.FinanceDTO;
import org.afya.records.model.Finance;

public class FinanceMapper {
    public static Finance financeDTOTofinance(FinanceDTO financeDTO){

        return Finance.builder()
                .patient(financeDTO.getPatient())
                .total(financeDTO.getTotal())
                .paid(financeDTO.getPaid())
                .left(financeDTO.getLeft())
                .build();
    }

}
