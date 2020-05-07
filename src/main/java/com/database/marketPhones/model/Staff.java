package com.database.marketPhones.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;
    @Column(name = "fullname")
    @NotBlank
    @Size(min = 3, max = 50, message = "Invalid FullName")
    private String fullName;
    @Column(name = "post")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Post")
    private String post;
    @Column(name = "dateofbirth")
    @NotBlank
    @Size(min = 3, max = 10, message = "Invalid DateOfBirthday")
    private String dateOfBirth;
    @Column(name = "devicedate")
    @NotBlank
    @Size(min = 3, max = 10, message = "Invalid DeviceDate")
    private String deviceDate;
    @Column(name = "city")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid City")
    private String city;
}
