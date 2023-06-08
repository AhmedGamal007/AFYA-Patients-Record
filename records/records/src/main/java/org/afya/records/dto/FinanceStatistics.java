package org.afya.records.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FinanceStatistics {

    private Double total;
    private Double paid;
    private Double left;
}
