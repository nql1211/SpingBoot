package com.ifisolution.project1.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class LineItems {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "invoice_id",
            referencedColumnName = "id",
            nullable = false)
    @JsonIncludeProperties("id")
    private Invoices invoices;

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false,
            referencedColumnName = "id")
    @JsonIncludeProperties("id")
    private Products products;

    private Integer quantity;
}
