package com.database.marketPhones.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;
    @Column(name = "fullname")
    @NotBlank
    @Size(min = 3, max = 50, message = "Invalid FullName")
    private String fullName;
    @Column(name = "city")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid City")
    private String city;
    @Column(name = "address")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Address")
    private String address;
    @Column(name = "passport")
    @NotBlank
    @Size(min = 3, max = 10, message = "Invalid Passport")
    private String passport;
    @Column(name = "numphone")
    @NotBlank
    @Size(min = 3, max = 11, message = "Invalid NumPhone")
    private String numPhone;
    @Column(name = "email")
    @NotBlank
    @Email(message = "Invalid Email")
    private String email;
}
