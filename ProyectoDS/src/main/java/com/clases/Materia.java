package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Materia {
    private String nombre;
    private Integer anioCarrera;
    private Integer cargaHoraria;

    public Materia(String nombre, Integer anioCarrera, Integer cargaHoraria) {
        this.nombre = nombre;
        this.anioCarrera = anioCarrera;
        this.cargaHoraria = cargaHoraria;
    }

    // Constructor por defecto
    public Materia() {
    }

    // MÉTODO PARA CREAR UNA MATERIA LEYENDO DATOS DESDE CONSOLA
    public static Materia altaMateria(String nombre, Integer anioCarrera, Integer cargaHoraria) {
        return new Materia(nombre, anioCarrera, cargaHoraria);
    }

    // MÉTODO PARA MODIFICAR LOS ATRIBUTOS DE UNA MATERIA
    public void modificarMateria(String nombre, Integer anioCarrera, Integer cargaHoraria) {
        this.nombre = nombre;
        this.anioCarrera = anioCarrera;
        this.cargaHoraria = cargaHoraria;
    }

    public List<Object> recuperarMateria() {
        return new ArrayList<>(List.of(this.getNombre(), this.getAnioCarrera(), this.getCargaHoraria()));
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", anioCarrera=" + anioCarrera +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}