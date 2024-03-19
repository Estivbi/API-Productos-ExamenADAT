package com.utad.Producto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class ProductoModel {

    // Atributos
    @Id
    // Generación automática de claves
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;
    private Double price;
    private String category;

    private Integer stock;


}