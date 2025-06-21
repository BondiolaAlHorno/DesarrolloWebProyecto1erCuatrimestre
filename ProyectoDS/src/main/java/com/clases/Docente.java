package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@EqualsAndHashCode
@Getter
@Setter
public class Docente extends  Persona{
    private Integer legajo;
    private List<Asistencia> asistencia;
    private MateriaImplementada materia;

    public Docente(String nombre,String apellido,String dni,Integer legajo,List<Asistencia> asistencia,MateriaImplementada materia){
        super(nombre, apellido, dni);
        this.legajo = legajo;
        this.asistencia = asistencia;
        this.materia = materia;
    }

    //Método para crear un nuevo docente
    public static Docente altaDocente(String nombre,String apellido,String dni,Integer legajo,List<Asistencia> asistencia,MateriaImplementada materia) {
        return new Docente(nombre, apellido, dni, legajo, asistencia, materia);
    }

    //Método de instancia para modificar un docente existente
    public void modificarDocente(String nombre,String apellido,String dni,Integer legajo,List<Asistencia> asistencia,MateriaImplementada materia) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setLegajo(legajo);
        this.setAsistencia(asistencia);
        this.setMateria(materia);
    }

}

