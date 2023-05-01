package com.geekster.UniversityEventmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer studentId;

    @Pattern(regexp = "[A-Z][a-zA-Z]*")
    private String firstName;
    private String lastName;

    @Pattern(regexp = "^(1[8,9]|2[0-5])$")
    private String age;

    @Enumerated(EnumType.STRING)
    private EDepartment department;
}
