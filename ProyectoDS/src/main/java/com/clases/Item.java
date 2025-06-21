package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Item {
    private String nombre;
    private String tipo;
    private Boolean estado; // true = disponible, false = prestado

    public Item(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = true; // disponible al crearlo
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado=" + (estado ? "Disponible" : "Prestado") +
                '}';
    }
}
