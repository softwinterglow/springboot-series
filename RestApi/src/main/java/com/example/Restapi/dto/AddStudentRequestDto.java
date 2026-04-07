package com.example.Restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

public class AddStudentRequestDto {

        @NotBlank(message = "name is required")
        @Size(max = 30, min = 3, message = "name length shoule be 3-30")
        private String name;

        @Email
        @NotBlank(message="email is required")
        private String email;


}
