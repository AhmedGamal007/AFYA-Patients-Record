package org.afya.records.controller;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.afya.records.dto.PatientDTO;
import org.afya.records.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/afya")
@RequiredArgsConstructor
public class PatientController {


    private final PatientService patientService;

    @PostMapping("/addPatient")
    public ResponseEntity addPatient(@RequestBody PatientDTO patientDTO){
            this.patientService.addPatient(patientDTO);
            return ResponseEntity.ok().body(patientDTO);
    }

    @GetMapping("/viewPatients")
    public  ResponseEntity viewAll(){
    return ResponseEntity.ok().body(patientService.viewAll());
    }

    @PutMapping("/editPatient/{id}")
    public ResponseEntity editPatient(@PathVariable Integer id, @RequestBody PatientDTO patientDTO){
            patientService.editPatient(id, patientDTO);
        return ResponseEntity.ok().body(patientDTO);
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("image") MultipartFile file) throws Exception{
        String path_directory="C:\\Users\\user\\Desktop\\AFYA Project\\AFYA\\src\\assets\\passports";
        System.out.println("------------------------------------"+file.getOriginalFilename()+"----------------------------------"+file.getContentType());
        Files.copy(file.getInputStream(),Paths.get(path_directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING); 
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity deletePatient(@PathVariable Integer id){
            patientService.deletePatient(id);
            return ResponseEntity.accepted().body(null);
    }
    @GetMapping("/getPatient/{id}")
    public ResponseEntity getPatient(@PathVariable Integer id){

        return ResponseEntity.ok(patientService.getPatient(id));
    }
}


