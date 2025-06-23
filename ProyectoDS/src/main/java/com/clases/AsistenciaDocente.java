package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@Getter
@Setter
public class AsistenciaDocente extends Asistencia {
    private Time horarioIngreso;
    private Time horarioSalida;
    private Docente docente;

    public AsistenciaDocente(LocalDate fecha, String asistencia, MateriaImplementada materia, Time horarioIngreso, Time horarioSalida, Docente docente) {
        super(fecha, asistencia, materia);
        this.horarioIngreso = horarioIngreso;
        this.horarioSalida = horarioSalida;
        this.docente = docente;
    }
    public static AsistenciaDocente altaAsistenciaDocente(LocalDate fecha, String asistencia, MateriaImplementada materia,Time horarioIngreso, Time horarioSalida, Docente docente ) {
        return new AsistenciaDocente(fecha, asistencia, materia, horarioIngreso, horarioSalida, docente);
    }

    public void modificarAsistenciaDocente(LocalDate fecha, String asistencia, MateriaImplementada materia, Time horarioIngreso, Time horarioSalida, Docente docente) {
        this.setFecha(fecha);
        this.setAsistencia(asistencia);
        this.setMateria(materia);
        this.setHorarioIngreso(horarioIngreso);
        this.setHorarioSalida(horarioSalida);
        this.setDocente(docente);
    }

    //Consultar historial de asistencia

    private List<AsistenciaDocente> historialAsistencias = new ArrayList<>();
    public List<AsistenciaDocente> consultarHistorial() {
            return historialAsistencias;
        }

}

