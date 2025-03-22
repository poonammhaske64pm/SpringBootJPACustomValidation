package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Pattern(regexp = "[A-Za-z]*", message = "name should contain atleast 2 character")
    private String name;

    @Email(message = "email should be valid")
    private String emailId;

    @Size(min = 4, message = "password should contain atleast 4 character")
    private String emailPassword;

    private double salary;
}
