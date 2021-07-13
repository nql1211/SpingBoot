package com.ifisolution.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Customers {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(
            name = "customer_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String customerName;
    @Column(
            name = "phone",
            nullable = false
    )
    private String phone;
    @Column(
            name = "address",
            nullable = false
    )
    private String address;

//    @OneToMany(
//            mappedBy = "customers",
//            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
//            fetch = FetchType.LAZY)
//    private Set<Invoices> invoices;

    public Customers(String customerName, String phone, String address) {
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
    }

}
