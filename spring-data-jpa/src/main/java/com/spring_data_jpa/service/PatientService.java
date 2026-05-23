package com.spring_data_jpa.service;


import com.spring_data_jpa.Repository.PatientRepository;
import com.spring_data_jpa.entity.Patient;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
          return p1;
    }

}
