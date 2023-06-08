package org.afya.records.service;

import lombok.RequiredArgsConstructor;
import org.afya.records.dto.PatientDTO;
import org.afya.records.mapper.PatientMapper;
import org.afya.records.model.Finance;
import org.afya.records.repository.FinanceRepository;
import org.afya.records.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.afya.records.model.Patient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final FinanceRepository financeRepository;


    public Patient addPatient(PatientDTO patientDTO){
        try {
            return patientRepository.save(PatientMapper.patientDTOtoPatient(patientDTO));
        }
        catch (Exception ex){
            System.out.println("--------------------------------sss-------------------------------");
            ex.printStackTrace();
            return null;
        }

    }
    public List<Patient> viewAll(){
        return patientRepository.findAll();
    }

    public Patient editPatient(Integer id,PatientDTO patientDTO){
        Patient patientToUpdate = PatientMapper.patientDTOtoPatientTransfer(patientRepository.getReferenceById(id), patientDTO);
        return patientRepository.save(patientToUpdate);
    }

    public void deletePatient(Integer id){
        Finance f = financeRepository.findByPatient(patientRepository.findById(id).orElse(null)).orElse(null);
        if (f != null) {
            financeRepository.delete(f);
        }
        patientRepository.deleteById(id);
    }
    public void addToFinance(Integer id){
        Patient patient = patientRepository.findById(id).orElse(null);
        if(financeRepository.findByPatient(patient).orElse(null)==null)
        financeRepository.save(Finance.builder()
                .patient(patient)
                .total(0.0)
                .left(0.0)
                .paid(0.0)
                .build());
    }
    public Patient getPatient(Integer id){
        return patientRepository.findById(id).orElse(null);
    }

}
