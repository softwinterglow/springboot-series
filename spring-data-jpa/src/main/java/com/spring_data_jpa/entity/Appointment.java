package com.spring_data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;
    @Column(length = 500)
    private String reason;
    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
