package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Comision {

    private List<MateriaImplementada> materias;
    private Carrera carrera;
    private List<Estudiante> estudiantes;
    private String turno;
    private String nombre;

    public Comision(List<MateriaImplementada> materia, Carrera carrera, List<Estudiante> estudiantes,String turno,String nombre){
        this.materias = materia;
        this.carrera = carrera;
        this.estudiantes = estudiantes;
        this.turno = turno;
        this.nombre = nombre;
    }

    public static Comision altaComision(List<MateriaImplementada> materia, Carrera carrera, List<Estudiante> estudiantes,String turno,String nombre){
        return new Comision(materia,carrera,estudiantes,turno,nombre);
    }

    public void modificarComision(List<MateriaImplementada> materia, Carrera carrera, List<Estudiante> estudiantes,String turno,String nombre){
        this.setMaterias(materia);
        this.setCarrera(carrera);
        this.setEstudiantes(estudiantes);
        this.setTurno(turno);
        this.setNombre(nombre);
    }

}
