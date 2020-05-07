package com.database.marketPhones.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idO;
    @Column(name = "idemployee")
    @NotNull
    private int idEmpl;
    @Column(name = "idmanufacturer")
    @NotNull
    private int idManf;
    @Column(name = "idphone")
    @NotNull
    private int idPh;
    @Column(name = "postdate")
    @Size(min = 3, max = 10, message = "Invalid PostDate")
    private String postDate;
    @Column(name = "dateexecution")
    @Size(min = 3, max = 10, message = "Invalid DataExecution")
    private String dateExecution;
    @Column(name = "idcustomer")
    @NotNull
    private int idCust;
    @Column(name = "quantityphone")
    @NotBlank
    @Size(min = 1, max = 30, message = "Invalid QuantityPhone")
    private String quantityPhone;
    @Column(name = "pricephone")
    @NotBlank
    @Size(min = 4, max = 30, message = "Invalid PricePhone")
    private String pricePhone;
}
