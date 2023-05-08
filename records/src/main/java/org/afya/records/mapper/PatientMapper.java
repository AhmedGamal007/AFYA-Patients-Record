package org.afya.records.mapper;

import org.afya.records.dto.PatientDTO;
import org.afya.records.model.Patient;

public class PatientMapper {

    public static Patient patientDTOtoPatient(PatientDTO patientDTO){
        return Patient.builder()
                .arriveDate(patientDTO.getArriveDate())
                .name(patientDTO.getName())
                .passportPath(patientDTO.getPassportPath())
                .leaveDate(patientDTO.getLeaveDate())
                .hospitalName(patientDTO.getHospitalName())
                .hospitalNumber(patientDTO.getHospitalNumber())
                .typeOfDisease(patientDTO.getTypeOfDisease())
                .examinationDate(patientDTO.getExaminationDate())
                .patientNumber(patientDTO.getPatientNumber())
                .submissionDate(patientDTO.getSubmissionDate())
                .note(patientDTO.getNote())
                .status(patientDTO.getStatus())
                .build();

    }
    public static Patient patientDTOtoPatientTransfer(Patient patient,PatientDTO patientDTO){
        patient.setArriveDate(patientDTO.getArriveDate());
        patient.setName(patientDTO.getName());
        patient.setPassportPath(patientDTO.getPassportPath());
        patient.setLeaveDate(patientDTO.getLeaveDate());
        patient.setHospitalName(patientDTO.getHospitalName());
        patient.setHospitalNumber(patientDTO.getHospitalNumber());
        patient.setTypeOfDisease(patientDTO.getTypeOfDisease());
        patient.setExaminationDate(patientDTO.getExaminationDate());
        patient.setPatientNumber(patientDTO.getPatientNumber());
        patient.setSubmissionDate(patientDTO.getSubmissionDate());
        patient.setNote(patientDTO.getNote());
        patient.setStatus(patientDTO.getStatus());
        return patient;
    }
}
