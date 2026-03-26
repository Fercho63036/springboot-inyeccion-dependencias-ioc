package com.ariel.springboot.di.app.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.springboot.di.app.springboot.models.Product;
import com.ariel.springboot.di.app.springboot.services.ProductServiceImpl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Controller: expone endpoints HTTP que usan el service para devolver datos al cliente (API REST)
@RestController
@RequestMapping("/api")
public class SomeController {
    
    // Conecta el controlador con el service para usar la lógica de negocio
    private ProductServiceImpl service = new ProductServiceImpl();

    // Endpoint GET /api → obtiene todos los productos pasando por el service (que aplica lógica) y repository (datos)
    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    // Endpoint GET /api/{id} → obtiene un producto por id usando el flujo controller → service → repository
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
    
}
