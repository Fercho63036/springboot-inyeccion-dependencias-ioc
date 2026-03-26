package com.ariel.springboot.di.app.springboot.repositories;

import java.util.Arrays;
import java.util.List;

import com.ariel.springboot.di.app.springboot.models.Product;

// Repository: capa encargada de acceder y gestionar los datos (simula o conecta con la base de datos)
public class ProductRepositoryImpl implements ProductRepository{
    private List<Product> data;
    // Inicializa una lista fija de productos simulando una base de datos
    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "Cpu Intel Core i9",300L),
            new Product(3L, "Teclado Razer Mini 60%",300L),
            new Product(4L, "Motherboard Gigabyte",300L)
        );
    }
    // Retorna todos los productos almacenados
    @Override
    public List<Product> findAll(){
        return data;
    }
    // Busca un producto por su id en la lista y retorna null si no lo encuentra
    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
