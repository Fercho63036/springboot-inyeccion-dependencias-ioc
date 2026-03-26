package com.ariel.springboot.di.app.springboot.models;

// Clase modelo que representa un producto y permite ser clonado (copiado)
public class Product implements Cloneable{

    private Long id;
    private String name;
    private Long price;

    public Product() {
        
    }

    public Product(Long id, String name, Long price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    // Sobrescribe clone() para permitir copiar el objeto actual
    @Override
    public Object clone(){
        try {
            // Crea una copia superficial del objeto usando la implementación de Object
            return super.clone();
        } catch(CloneNotSupportedException e) {
            // Si falla la clonación, crea manualmente un nuevo objeto con los mismos valores
            return new Product(this.getId(), this.getName(), getPrice());
        }
    }
}
