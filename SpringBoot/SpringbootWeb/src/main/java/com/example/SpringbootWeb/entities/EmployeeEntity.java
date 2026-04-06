package com.example.SpringbootWeb.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


//@Entity       →  "this class talks to the database"
//@Table        →  "specifically THIS table in the database"
//@Id           →  "this field is the primary key"
//@GeneratedValue →  "generate the id automatically"


@Table(name = "employees")  //Tells JPA — "map this class to a database table called employees" / Your Java class  →  Database table /EmployeeEntity     →  employees

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;      // ← was missing!


}
