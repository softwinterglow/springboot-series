package com.example.SpringbootWeb.dto;


//DTO = Data Transfer Object
//A simple object used to transfer data between layers (like from controller → service → client).
//It does not contain business logic. Its only job is to carry data.
//Think of it as an envelope: it just carries information; it doesn’t do anything with it.
public class EmployeeDTO {
     private Long id;
     private String username;
     private String password; // sensitive
     private String email;

     public EmployeeDTO(){

     }

    public EmployeeDTO(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
