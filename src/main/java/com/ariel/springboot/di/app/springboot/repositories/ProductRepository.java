package com.ariel.springboot.di.app.springboot.repositories;

import java.util.List;

import com.ariel.springboot.di.app.springboot.models.Product;

public interface ProductRepository {
// Declara el contrato llamado ProductRepository, visible desde cualquier lugar
    List<Product> findAll();
    // Método obligatorio: quien implemente esto DEBE retornar una lista de productos
    Product findById (Long id);
    // Método obligatorio: quien implemente esto DEBE retornar un producto por su id
}