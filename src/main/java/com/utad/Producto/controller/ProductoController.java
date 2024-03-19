package com.utad.Producto.controller;

import com.utad.Producto.model.ProductoModel;
import com.utad.Producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/productos")
public class ProductoController {
    // Inyectamos el servicio
    private final ProductoService productoService;

    // Constructor
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    // Método para guardar un producto
    public ResponseEntity<ProductoModel> save(@RequestBody ProductoModel producto) {
        ProductoModel newProducto = productoService.saveOrUpdateProducto(producto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newProducto);
    }

    @GetMapping
    // Método para obtener todos los productos
    public ResponseEntity<List<ProductoModel>> getAll() {
        List<ProductoModel> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{idProducto}")
    // Método para obtener un producto por id
    public ResponseEntity<Optional<ProductoModel>> getById(@PathVariable Long idProducto) {
        Optional<ProductoModel> producto = productoService.getProductoById(idProducto);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    // Método para buscar productos por nombre
    public ResponseEntity<List<ProductoModel>> searchProductos(@RequestParam String nombre) {
        List<ProductoModel> productos = productoService.searchProductoByName(nombre);
        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("/{idProducto}")
    // Método para borrar un producto por id
    public ResponseEntity delete(@PathVariable Long idProducto) {
        String message = productoService.deleteProducto(idProducto);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{idProducto}")
    // Método para actualizar un producto por id
    public ResponseEntity<String> update(@PathVariable Long idProducto, @RequestBody ProductoModel updatedProducto) {
        String producto = productoService.updateProducto(idProducto, updatedProducto);
        return ResponseEntity.ok(producto);
    }

    // Filtrar de entre todos los productos agotados (sin stock).
    @GetMapping("/sin stock")
    public ResponseEntity<List<ProductoModel>> getConStock() {
        List<ProductoModel> productos = productoService.getConStock();
        return ResponseEntity.ok(productos);
    }
}
