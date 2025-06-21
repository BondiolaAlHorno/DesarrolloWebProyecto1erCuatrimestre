package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
@Getter
@Setter
public class MateriaEstudiante {
    private Estudiante estudiante;
    private MateriaImplementada materia;
    private List<InstanciaEvaluativa> evaluaciones;
    private EvalucaionFinal evalucaionFinal;
    private Boolean estadoPromocion;
    private Boolean estadoCursada;
    private Boolean equivalencia;

    public MateriaEstudiante(Estudiante estudiante,
                             MateriaImplementada materia,
                             List<InstanciaEvaluativa> evaluaciones,
                             EvalucaionFinal evalucaionFinal,
                             Boolean estadoPromocion,
                             Boolean estadoCursada,
                             Boolean equivalencia){
        this.estudiante = estudiante;
        this.materia = materia;
        this.evaluaciones = evaluaciones;
        this.evalucaionFinal = evalucaionFinal;
        this.estadoPromocion = estadoPromocion;
        this.estadoCursada = estadoCursada;
        this.equivalencia = equivalencia;
    }

    //MÉTODO DE CREACIÓN DE "MATERIA"
    public static MateriaEstudiante altaMateriaEstudiante(Estudiante estudiante,
                                                          MateriaImplementada materia,
                                                          List<InstanciaEvaluativa> evaluaciones,
                                                          EvalucaionFinal evalucaionFinal,
                                                          Boolean estadoPromocion,
                                                          Boolean estadoCursada,
                                                          Boolean equivalencia){
        return new MateriaEstudiante(estudiante,materia,evaluaciones,evalucaionFinal,estadoPromocion,estadoCursada,equivalencia);
    }

    //MÉTODO DE MODIFICACIÓN DE "MATERIA"
    public void modificarMateriaEstudiante(Estudiante estudiante,
                                              MateriaImplementada materia,
                                              List<InstanciaEvaluativa> evaluaciones,
                                              EvalucaionFinal evalucaionFinal,
                                              Boolean estadoPromocion,
                                              Boolean estadoCursada,
                                              Boolean equivalencia){
        this.setEstudiante(estudiante);
        this.setMateria(materia);
        this.setEvaluaciones(evaluaciones);
        this.setEvalucaionFinal(evalucaionFinal);
        this.setEstadoPromocion(estadoPromocion);
        this.setEstadoCursada(estadoCursada);
        this.setEquivalencia(equivalencia);
    }

    public List<Object> recuperarMateriaEstudiante(){
        return new ArrayList<>(List.of(
                this.getEstudiante(),
                this.getMateria(),
                this.getEvaluaciones(),
                this.getEvalucaionFinal(),
                this.getEstadoPromocion(),
                this.getEstadoCursada(),
                this.getEquivalencia()));
    }
}
