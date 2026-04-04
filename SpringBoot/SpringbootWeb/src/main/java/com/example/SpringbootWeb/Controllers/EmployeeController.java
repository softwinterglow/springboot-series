package com.example.SpringbootWeb.Controllers;


import com.example.SpringbootWeb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;


//@Controller is used to mark a class as a Spring MVC controller.
//@RestController is a specialized version of @Controller.
//        What it does:
//        Combines:
//        @Controller
//        @ResponseBody
//        Tells Spring: “Return data directly as HTTP response (JSON/XML), not a view.”

@RestController
@RequestMapping("/employees") // Now this is the parent path like the and those below are now the the children path like employees/employeeID


public class EmployeeController {


//    @GetMapping("/message")
//    public String message(){
//        return "my first spring get request";
//    }


//
//    What is @PathVariable?
//    Short answer: It lets you grab values from the URL path and use them as method parameters.

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeID") long id){
        return new EmployeeDTO(id,"miku","miku123","miku@gmail.com");
    }

//    @Requestparam example
//Short answer: It grabs values from the Query String (the part of the URL after the ?) and injects them into your method.
//    Your Example (Expanded):
//    Imagine you want to search for employees by department or sort them.


    @GetMapping // here this is the default path because im not appending anything
    public String getEmployeeByAge(@RequestParam(required = false) Integer age, // now passing this is optional its upto you if you wanna pass or not
                                   @RequestParam(required = false) String sortBy){
        return "Hi your age is " + age +" " + sortBy;
    }

    @PostMapping //Post is used whenever you want to create
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setUsername("nezuko");
        inputEmployee.setId(20L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployee(){
        return "hello from put";
    }



}
