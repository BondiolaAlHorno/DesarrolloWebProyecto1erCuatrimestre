package com.clases;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@EqualsAndHashCode
@Getter
@Setter
public class InstanciaEvaluativa{
    private Estudiante estudiante;
    private LocalDate fecha;
    private Double nota;
    private MateriaImplementada materia;

    public InstanciaEvaluativa(Estudiante estudiante, LocalDate fecha, Double nota, MateriaImplementada materia){
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.nota = nota;
        this.materia = materia;
    }

    //Método estático para agregar una nueva instancia evaluativa
    public static InstanciaEvaluativa altaInstanciaEvaluativa(Estudiante estudiante, LocalDate fecha, Double nota, MateriaImplementada materia){
        return new InstanciaEvaluativa(estudiante, fecha, nota, materia);
    }

    //Método de instancia para modificar una instancia evaluativa existente
    public void modificarInstanciaEvaluativa(Estudiante estudiante, LocalDate fecha, Double nota, MateriaImplementada materia){
        this.setEstudiante(estudiante);
        this.setFecha(fecha);
        this.setNota(nota);
        this.setMateria(materia);
    }

    public List<Object> recuperarInstanciaEvaluativa(){
        return new ArrayList<>(List.of(this.getEstudiante(),this.getFecha(),this.getNota(),this.getMateria()));
    }
}