package com.utad.Producto.service;

import com.utad.Producto.model.ProductoModel;
import com.utad.Producto.repository.ProdutcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    // Inyectamos el repositorio
    @Autowired
    ProdutcoRepository produtcoRepository;

    // Métodos CRUD
    public List<ProductoModel> getAllProductos() {
        return produtcoRepository.findAll();
    }
    public ProductoModel saveOrUpdateProducto(ProductoModel producto) {
        return produtcoRepository.save(producto);
    }
    public Optional<ProductoModel> getProductoById(Long idProducto) {
        return produtcoRepository.findById(idProducto);
    }
    public List<ProductoModel> searchProductoByName(String name) {
        return produtcoRepository.findByNameContainingIgnoreCase(name);
    }

    public String deleteProducto(Long idProducto) {
        if (produtcoRepository.existsById(idProducto)) {
            produtcoRepository.deleteById(idProducto);
            return "Producto borrado correctamente";
        } else {
            return ("Producto no encontrado con id " + idProducto);
        }
    }

    public String updateProducto(Long idProducto, ProductoModel updatedProducto){
        if (produtcoRepository.existsById(idProducto)) {
            ProductoModel producto = produtcoRepository.findById(idProducto).get();
            producto.setName(updatedProducto.getName());
            producto.setDescription(updatedProducto.getDescription());
            producto.setPrice(updatedProducto.getPrice());
            producto.setStock(updatedProducto.getStock());
            produtcoRepository.save(producto);
            return "Producto actualizado correctamente";
        } else {
            return "Error: Producto no encontrado con id " + idProducto;
        }
    }

    /*public List<ProductoModel> getSinStock() {
        return produtcoRepository.findByStockLessThan(1);
    }*/
    public List<ProductoModel> getConStock() {
        List<ProductoModel> allProductos = produtcoRepository.findAll();
        return allProductos.stream()
                .filter(producto -> producto.getStock() > 0)
                .collect(Collectors.toList());
    }
}
