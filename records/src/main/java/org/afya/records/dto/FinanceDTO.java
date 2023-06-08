package org.afya.records.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.afya.records.model.Patient;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinanceDTO {

    private Integer financeId;
    private Patient patient;
    private Double total;
    private Double paid;
    private Double left;
}
