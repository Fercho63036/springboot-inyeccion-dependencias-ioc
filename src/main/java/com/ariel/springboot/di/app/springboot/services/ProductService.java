package com.ariel.springboot.di.app.springboot.services;
// Carpeta/paquete donde vive este archivo

import java.util.List;
// Importa List para usarlo como tipo de retorno

import com.ariel.springboot.di.app.springboot.models.Product;
// Importa la clase Product para usarla en los métodos

public interface ProductService {
// Declara el contrato llamado ProductService, visible desde cualquier lugar

    List<Product> findAll();
    // Método obligatorio: quien implemente esto DEBE retornar todos los productos

    Product findById (Long id);
    // Método obligatorio: quien implemente esto DEBE retornar un producto por su id
}