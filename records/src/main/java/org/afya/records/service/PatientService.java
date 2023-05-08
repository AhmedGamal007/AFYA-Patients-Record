package org.afya.records.service;

import lombok.RequiredArgsConstructor;
import org.afya.records.dto.PatientDTO;
import org.afya.records.mapper.PatientMapper;
import org.afya.records.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.afya.records.model.Patient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    public String addPatient(PatientDTO patientDTO){
        try {
            patientRepository.save(PatientMapper.patientDTOtoPatient(patientDTO));
            return "Patient Is Added Successfully";
        }
        catch (Exception ex){
            System.out.println("--------------------------------sss-------------------------------");
            ex.printStackTrace();
        }
        return null;
    }
    public List<Patient> viewAll(){
        return patientRepository.findAll();
    }

    public void editPatient(Integer id,PatientDTO patientDTO){
        Patient patientToUpdate = PatientMapper.patientDTOtoPatientTransfer(patientRepository.getReferenceById(id), patientDTO);
        patientRepository.save(patientToUpdate);
    }

    public void deletePatient(Integer id){
        patientRepository.deleteById(id);
    }
    public Patient getPatient(Integer id){
        return patientRepository.findById(id).orElse(null);
    }

}
