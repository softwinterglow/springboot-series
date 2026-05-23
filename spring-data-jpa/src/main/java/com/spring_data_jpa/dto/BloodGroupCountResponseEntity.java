package com.spring_data_jpa.dto;


import com.spring_data_jpa.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {
      private BloodGroupType bloodGroupType;
      private Long count;

}
