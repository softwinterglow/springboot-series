package com.example.SpringbootWeb.Controllers;


import com.example.SpringbootWeb.entities.EmployeeEntity;
import com.example.SpringbootWeb.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller is used to mark a class as a Spring MVC controller.
//@RestController is a specialized version of @Controller.
//        What it does:
//        Combines:
//        @Controller
//        @ResponseBody
//        Tells Spring: “Return data directly as HTTP response (JSON/XML), not a view.”

@RestController
@RequestMapping("/employees") // Now this is the parent path like the and those below are now the the children path like employees/employeeID


public class EmployeeControllers {


//    @GetMapping("/message")
//    public String message(){
//        return "my first spring get request";
//    }

    private final EmployeeRepository employeerepository;

    public EmployeeControllers(EmployeeRepository employeeRepository) {
        this.employeerepository = employeeRepository;
    }


//
//    What is @PathVariable?
//    Short answer: It lets you grab values from the URL path and use them as method parameters.

    @GetMapping("/{employeeID}")
        public EmployeeEntity getEmployeeById(@PathVariable(name="employeeID") long id){
            return employeerepository.findById(id).orElse(null);
    }





//    @Requestparam example
//Short answer: It grabs values from the Query String (the part of the URL after the ?) and injects them into your method.
//    Your Example (Expanded):
//    Imagine you want to search for employees by department or sort them.


    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age, // now passing this is optional its upto you if you wanna pass or not
                                                @RequestParam(required = false) String sortBy){
        return employeerepository.findAll();
    }




    @PostMapping //Post is used whenever you want to create
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
       return employeerepository.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployee(){
        return "hello from put";
    }



}
