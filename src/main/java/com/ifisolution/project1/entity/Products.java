package com.ifisolution.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Products {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private Double price;

    @OneToMany(
            mappedBy = "products",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = false)
    private Set<LineItems> lineItems;

}
