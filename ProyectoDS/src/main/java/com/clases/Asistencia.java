package com.clases;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Asistencia{

    private LocalDate fecha;
    private String asistencia;
    private MateriaImplementada materia;
    private Documento justificacion;

    public Asistencia (LocalDate fecha, String asistencia, MateriaImplementada materia){
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.materia = materia;
        this.justificacion = null;
    }

    public void justificarInasistencia(Documento justificacion){
        this.setJustificacion(justificacion);
    }
}
