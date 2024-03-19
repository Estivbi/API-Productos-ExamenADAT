package com.utad.Producto.repository;

import com.utad.Producto.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutcoRepository extends JpaRepository<ProductoModel, Long> {
    //  Método para buscar productos por nombre
    List<ProductoModel> findByNameContainingIgnoreCase(String name);

    // Método para buscar productos por stock
    List<ProductoModel> findByStockLessThan(Integer stock);


}
