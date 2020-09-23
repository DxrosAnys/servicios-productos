package com.formacionbdi.springboot.app.productos.models.entity;

import lombok.Getter;
import lombok.Setter;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = -3705505440435868427L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @Column(name = "create_at")
    @Temporal(DATE)
    private Date createAt;

    @Transient
    private Integer port;
}
