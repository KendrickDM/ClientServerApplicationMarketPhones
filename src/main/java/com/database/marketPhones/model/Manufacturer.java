package com.database.marketPhones.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "manufacturers")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idM;
    @Column(name = "manufacturer")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Manufacturer")
    private String manf;
    @Column(name = "countrymanf")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Country")
    private String countryManf;
}
