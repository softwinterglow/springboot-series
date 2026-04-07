package com.example.SpringbootWeb.Services;


import com.example.SpringbootWeb.dto.EmployeeDTO;
import com.example.SpringbootWeb.entities.EmployeeEntity;
import com.example.SpringbootWeb.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private final EmployeeRepository employeerepository;

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeerepository, ModelMapper modelMapper) {
        this.employeerepository = employeerepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
          EmployeeEntity employeeentity= employeerepository.findById(id).orElse(null);
        return modelMapper.map(employeeentity, EmployeeDTO.class);

    }


//    public List<EmployeeDTO> getAllEmployees() {
//        List<EmployeeEntity> employeeEntities= employeerepository.findAll();
//        return employeeEntities
//                .stream()
//                .map(employeeEntity -> modelMapper(employeeEntity,EmployeeDTO.class))
//                .collect(Collectors.toList());
//    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeerepository.findAll();

        // Convert each Entity to DTO and collect them into a List
        return employeeEntities.stream()
                .map(entity -> modelMapper.map(entity, EmployeeDTO.class)) // Use .map()
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeEntity inputEmployee) {
        EmployeeEntity toSaveeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeerepository.save(toSaveeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }


    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {

    }
}
