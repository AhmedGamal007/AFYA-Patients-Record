package org.afya.records.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;


import java.util.Date;

@Entity
@Data
@Table(name = "patient")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , unique = true , name= "patient_id")
    private Integer id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "passport")
    private String passportPath ;


    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "arrive_date" )
    private Date arriveDate ;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "leave_date" )
    private Date leaveDate ;

    @Column(name = "hospital_name")
    private String hospitalName ;

    @Column(name = "hospital_number")
    private String hospitalNumber;

    @Column(name =  "type_of_disease")
    private String typeOfDisease ;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "examination_date" )
    private Date examinationDate ;


    @Column(name = "patient_number")
    private String patientNumber ;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "submission_date" )
    private Date submissionDate ;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private String status ;

    @Column(name = "sent_by")
    private String sentBy;
}

