package com.microservicios.shoppingService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservicios.shoppingService.model.Customer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tlb_invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_invoice")
    private String numberInvoice;

    private String description;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    //si se crea una cabezera tambien se tienen que crear todos sus detalles y si no existe la cabezera
    //tampoco existirian sus detalles
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items;

    private String state;

    @Transient
    private Customer customer;
    public Invoice(){
        items = new ArrayList<>();
    }

    //me permite insertar registrar la fecha antes de insertarlo en nuestra base de datos
    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

}