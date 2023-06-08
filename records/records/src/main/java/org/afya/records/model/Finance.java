package org.afya.records.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "finance")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finance_id")
    private Integer financeId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name="total")
    private Double total = 0.0;
    @Column(name="paid")
    private Double paid = 0.0;
    @Column(name="amount_left")
    private Double left = 0.0;
}
