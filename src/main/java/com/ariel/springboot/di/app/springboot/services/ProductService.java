package com.ariel.springboot.di.app.springboot.services;

import java.util.List;
import java.util.stream.Collectors;

import com.ariel.springboot.di.app.springboot.models.Product;
import com.ariel.springboot.di.app.springboot.repositories.ProductRepository;

// Service: capa que obtiene datos del repository y aplica lógica de negocio (como el aumento de precios) antes de devolverlos
public class ProductService {

    // Inicializa el repository para que el service pueda acceder a los datos
    private ProductRepository repository = new ProductRepository();

    // Obtiene todos los productos y les aplica un aumento del 25% al precio
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }
    
    // Busca y retorna un producto por su id desde el repository
    public Product findById(Long id){
        return repository.findById(id);
    }
}
