package com.ariel.springboot.di.app.springboot.services;

import java.util.List;
import java.util.stream.Collectors;

import com.ariel.springboot.di.app.springboot.models.Product;
import com.ariel.springboot.di.app.springboot.repositories.ProductRepositoryImpl;

// Service: capa que aplica lógica de negocio usando datos del repository sin modificar los originales
public class ProductServiceImpl implements ProductService{

    // Crea una instancia del repository para acceder a los datos
    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    // Obtiene todos los productos y devuelve copias con el precio aumentado en 25%
    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            // Calcula el nuevo precio con un incremento del 25%
            Double priceTax = p.getPrice() * 1.25d;
            // Clona el producto original para no modificar el objeto base
            Product newProd = (Product) p.clone();
            // Asigna el nuevo precio al clon (no al original)
            newProd.setPrice(priceTax.longValue());
            // Retorna el nuevo producto modificado
            return newProd;
        }).collect(Collectors.toList()); // Convierte el stream en lista
    }

    // Busca un producto por id sin modificarlo
    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
