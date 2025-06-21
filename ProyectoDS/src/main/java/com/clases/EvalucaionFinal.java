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
public class EvalucaionFinal extends InstanciaEvaluativa {
    private String tomo;
    private String folio;

    public EvalucaionFinal(Estudiante estudiante, LocalDate fecha, Double nota, MateriaImplementada materia, String tomo, String folio) {
        super(estudiante, fecha, nota, materia);
        this.tomo = tomo;
        this.folio = folio;
    }

    //MÉTODO DE CREACION "ALTA FINAL"
    public static EvalucaionFinal altaEvalucaionFinal(Estudiante estudiante, LocalDate fecha, Double nota, MateriaImplementada materia, String tomo, String folio){
        return new EvalucaionFinal(estudiante, fecha, nota, materia, tomo, folio);
    }

    //MÉTODO DE MODIFICACION DE "NOTA FINAL"
    public void modificarEvalucaionFinal(Estudiante estudiante, LocalDate fecha, Double nota, MateriaImplementada materia, String tomo, String folio){
        setEstudiante(estudiante);
        setFecha(fecha);
        setNota(nota);
        setMateria(materia);
        setTomo(tomo);
        setFolio(folio);
    }

    public List<Object> recuperarEvaluacionFinal(){
        return new ArrayList<>(List.of(this.getEstudiante(),this.getFecha(),this.getNota(),this.getMateria(),this.getTomo(),this.getFolio()));
    }
}
