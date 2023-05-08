package org.afya.records.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@JsonSerialize
@AllArgsConstructor
@Data
@Builder

public class PatientSearchDTO {

    private String name = null;

    private String passportPath = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd" ,  locale ="##defualt"  )
    private Date arriveDate = null;
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd" ,  locale ="##defualt"  )
    private Date leaveDate = null;
    private String hospitalName = null;
    private String hospitalNumber = null;
    private String typeOfDisease = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd" ,  locale ="##defualt"  )
    private Date examinationDate = null;
    private String patientNumber = null;
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd" ,  locale ="##defualt"  )
    private Date submissionDate=null;
    private String note;
    private String status = null;
}
