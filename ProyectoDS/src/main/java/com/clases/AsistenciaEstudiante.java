package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class AsistenciaEstudiante extends Asistencia{
    private Estudiante estudiante;

    public AsistenciaEstudiante(LocalDate fecha, String asistencia, MateriaImplementada materia, Estudiante estudiante){
        super(fecha,asistencia,materia);
        this.estudiante=estudiante;
    }

    public static AsistenciaEstudiante altaAsistenciaEstudiante(LocalDate fecha, String asistencia, MateriaImplementada materia, Estudiante estudiante) {
        return new AsistenciaEstudiante(fecha, asistencia, materia,estudiante);
    }

    public void modificarAsistenciaEstudiante(LocalDate fecha, String asistencia, MateriaImplementada materia, Estudiante estudiante) {
        this.setFecha(fecha);
        this.setAsistencia(asistencia);
        this.setMateria(materia);
        this.setEstudiante(estudiante);
    }

    public List<Object> recuperarAsistenciaEstudiante(){
        return new ArrayList<>(List.of(this.getFecha(),this.getAsistencia(),this.getMateria(),this.getEstudiante()));
    }
}
