package com.microservicios.shoppingService.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_invoice_items")
public class InvoiceItem  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive(message = "El stock debe ser mayor que cero")
    private Double quantity;
    private Double  price;

    @Column(name = "product_id")
    private Long productId;

    //Aunque lo vamos a poder utilizar en nuestro POJO y en todo el sistema e incluso devolverlo al cliente
    //generando un JSON, NO VA A SER REGISTRADO EN NUESTRA BASE DE DATOS
    @Transient
    private Double subTotal;
    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }
    public InvoiceItem(){
        this.quantity=(double) 0;
        this.price=(double) 0;

    }
}
