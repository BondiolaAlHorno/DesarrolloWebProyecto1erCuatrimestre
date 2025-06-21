package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode
@Getter
@Setter
public class MateriaImplementada {

    private Materia materia;
    private List<Docente> docente;
    private List<Horario> horario;
    private Boolean promocion;
    private Comision comision;
    private List<Estudiante> estudiantes;

    public MateriaImplementada(Materia materia, List<Docente> docente, List<Horario> horario, Boolean promocion, Comision comision, List<Estudiante> estudiantes){
        this.materia = materia;
        this.docente = docente;
        this.horario = horario;
        this.promocion = promocion;
        this.comision = comision;
        this.estudiantes = estudiantes;
    }

    public static MateriaImplementada altaMateriaImplementada(Materia materia, List<Docente> docente, List<Horario> horario, Boolean promocion, Comision comision, List<Estudiante> estudiantes){
        return new MateriaImplementada(materia,docente,horario,promocion,comision,estudiantes);
    }

    public void modificarMateriaImplementada(Materia materia, List<Docente> docente, List<Horario> horario, Boolean promocion, Comision comision, List<Estudiante> estudiantes){
        this.setMateria(materia);
        this.setDocente(docente);
        this.setHorario(horario);
        this.setPromocion(promocion);
        this.setComision(comision);
        this.setEstudiantes(estudiantes);
    }

    public List<Object> recuperarMateriaImplementada(){
        return new ArrayList<>(List.of(this.getMateria(),this.getDocente(),this.getHorario(),this.getPromocion(),this.getComision(),this.getEstudiantes()));
    }
}
