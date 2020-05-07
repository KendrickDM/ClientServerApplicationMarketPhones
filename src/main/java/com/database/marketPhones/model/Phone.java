package com.database.marketPhones.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;
    @Column(name = "idmanufacturer")
    @NotNull
    private int idManufacturer;
    @Column(name = "model")
    @NotBlank
    @Size(min = 3, max = 40, message = "Invalid Model")
    private String model;
    @Column(name = "idsupplier")
    @NotNull
    private int idSupplier;
    @Column(name = "color")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Color")
    private String color;
    @Column(name = "typephone")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid TypePhone")
    private String typePhone;
    @Column(name = "scrdiagonal")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid ScrDiagonal")
    private String scrDiagonal;
    @Column(name = "platform")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Platform")
    private String platform;
    @Column(name = "builtinmemory")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid BuiltInMemory")
    private String builtInMemory;
    @Column(name = "scrresolution")
    @NotBlank
    @Size(min = 1, max = 30, message = "Invalid ScrResolution")
    private String scrResolution;
    @Column(name = "batterycapacity")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid BatteryCapacity")
    private String batteryCapacity;
    @Column(name = "numsimcards")
    @NotBlank
    @Size(min = 1, max = 30, message = "Invalid NumSimCards")
    private String numSimCards;
    @Column(name = "typesimcards")
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid TypeSimCards")
    private String typeSimCards;
}
