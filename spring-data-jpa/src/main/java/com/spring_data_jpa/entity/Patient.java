package com.spring_data_jpa.entity;


import com.spring_data_jpa.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@ToString
@Table
        (name = "patient",
        uniqueConstraints ={
//                @UniqueConstraint(name ="unique_patient_email", columnNames = "email"),
                @UniqueConstraint(name="unique_patient_name_date_of_birth", columnNames = {"name","birth_date"})
        },
           indexes = {
                @Index(name="idx_patient_birth_date", columnList = "birth_date")
           }

        )

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="patient_name", nullable = false)
    private String name;
//    @ToString.Exclude
    private LocalDate birthDate;
    @Column(unique = true)
    private String email;
    private String gender;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne
    @JoinColumn(name ="patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}
