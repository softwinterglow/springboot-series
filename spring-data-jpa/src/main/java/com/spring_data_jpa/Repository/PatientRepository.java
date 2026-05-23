package com.spring_data_jpa.Repository;

import com.spring_data_jpa.dto.BloodGroupCountResponseEntity;
import com.spring_data_jpa.entity.Patient;
import com.spring_data_jpa.entity.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate BirthDate, String email);
    List<Patient> findByGender(String gender);

    @Query("SELECT p FROM Patient where p.bloodGroup =?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup")BloodGroupType bloodGroup);


    @Query("select new com.spring_data_jpa.dto.BloodGroupCountResponseEntity (p.bloodGroup, Count(p)) from patient p group  by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

}
