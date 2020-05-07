package com.database.marketPhones.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idS;
    @Column(name = "organization")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Organization")
    private String organization;
    @Column(name = "representative")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Representative")
    private String representative;
    @Column(name = "numphone")
    @NotBlank
    @Size(min = 3, max = 11, message = "Invalid NumPhone")
    private String numPhone;
    @Column(name = "city")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid City")
    private String city;
    @Column(name = "address")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Address")
    private String address;
}
