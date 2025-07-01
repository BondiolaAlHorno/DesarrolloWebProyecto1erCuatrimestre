package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Carrera {
    private String nombre;
    private List<Materia> materias;
    private String duracion;
    private List<Comision> comisiones;

    public Carrera(String nombre, List<Materia> materias, String duracion) {
        this.nombre = nombre;
        this.materias = materias != null ? new ArrayList<>(materias) : new ArrayList<>();
        this.duracion = duracion;
        this.comisiones = new ArrayList<>();
    }

    // Constructor por defecto
    public Carrera() {
        this.materias = new ArrayList<>();
    }

    // AGREGAR CARRERA
    public static Carrera altaCarrera(String nombre, List<Materia> materias, String duracion) {
        return new Carrera(nombre, materias, duracion);
    }

    public void modificarCarrera(String nombre, List<Materia> materias, String duracion) {
        this.setNombre(nombre);
        this.setMaterias(materias);
        this.setDuracion(duracion);
    }

    public List<Object> recuperarCarrera() {
        return new ArrayList<>(List.of(this.getNombre(), this.getMaterias(), this.getDuracion()));
    }

    // Métodos para gestión de materias
    public void agregarMateria(Materia materia) {
        if (materia != null && !this.materias.contains(materia)) {
            this.materias.add(materia);
        }
    }

    public void eliminarMateria(Materia materia) {
        this.materias.remove(materia);
    }

    public boolean tieneMateria(Materia materia) {
        return this.materias.contains(materia);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "nombre='" + nombre + '\'' +
                ", duracion='" + duracion + '\'' +
                ", cantidadMaterias=" + (materias != null ? materias.size() : 0) +
                ", cantidadComisiones=" + (comisiones != null ? comisiones.size() : 0) +
                '}';
    }
}