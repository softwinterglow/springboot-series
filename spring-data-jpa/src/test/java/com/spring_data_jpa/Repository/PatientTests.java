package com.spring_data_jpa.Repository;

import com.spring_data_jpa.dto.BloodGroupCountResponseEntity;
import com.spring_data_jpa.entity.Patient;
import com.spring_data_jpa.entity.type.BloodGroupType;
import com.spring_data_jpa.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

//    @Test
//    public void testPatientRepository(){
//        List<Patient> patientList = patientRepository.findAll();
//        System.out.println(patientList);
//    }

    @Test
    public void testTranscationMethods() {

//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);

//
//        Patient patient = patientRepository.findByName("Bob Smith");
//        System.out.println(patient);

//        List<Patient> patient1 = patientRepository.findByBirthDateOrEmail(LocalDate.of(1990,05,14), "alice@gmail.com");
//        for (Patient patient: patient1){
//            System.out.println(patient);
//        }
//
//        List<Patient> patientGender = patientRepository.findByGender("Male");
//        for(Patient patient : patientGender){
//            System.out.println(patient);
//        }


//        List<Patient> patiendBloodGroup = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        for (Patient patient: patiendBloodGroup){
//            System.out.println(patient
//            );
//        }

        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
           for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList){
               System.out.println(bloodGroupCountResponse);
           }

    }
    }