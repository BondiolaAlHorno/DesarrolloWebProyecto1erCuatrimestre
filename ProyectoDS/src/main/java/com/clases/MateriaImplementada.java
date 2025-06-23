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

    public MateriaImplementada(Materia materia, List<Docente> docente, List<Horario> horario, 
                              Boolean promocion, Comision comision, List<Estudiante> estudiantes) {
        this.materia = materia;
        this.docente = docente != null ? new ArrayList<>(docente) : new ArrayList<>();
        this.horario = horario != null ? new ArrayList<>(horario) : new ArrayList<>();
        this.promocion = promocion;
        this.comision = comision;
        this.estudiantes = estudiantes != null ? new ArrayList<>(estudiantes) : new ArrayList<>();
    }

    // Constructor por defecto
    public MateriaImplementada() {
        this.docente = new ArrayList<>();
        this.horario = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public static MateriaImplementada altaMateriaImplementada(Materia materia, List<Docente> docente, 
                                                            List<Horario> horario, Boolean promocion, 
                                                            Comision comision, List<Estudiante> estudiantes) {
        return new MateriaImplementada(materia, docente, horario, promocion, comision, estudiantes);
    }

    public void modificarMateriaImplementada(Materia materia, List<Docente> docente, List<Horario> horario, 
                                           Boolean promocion, Comision comision, List<Estudiante> estudiantes) {
        this.setMateria(materia);
        this.setDocente(docente);
        this.setHorario(horario);
        this.setPromocion(promocion);
        this.setComision(comision);
        this.setEstudiantes(estudiantes);
    }

    public List<Object> recuperarMateriaImplementada() {
        return new ArrayList<>(List.of(this.getMateria(), this.getDocente(), this.getHorario(), 
                                     this.getPromocion(), this.getComision(), this.getEstudiantes()));
    }

    // Métodos para gestión de docentes
    public void agregarDocente(Docente docente) {
        if (docente != null && !this.docente.contains(docente)) {
            this.docente.add(docente);
        }
    }

    public void eliminarDocente(Docente docente) {
        this.docente.remove(docente);
    }

    // Métodos para gestión de horarios
    public void agregarHorario(Horario horario) {
        if (horario != null && !this.horario.contains(horario)) {
            this.horario.add(horario);
        }
    }

    public void eliminarHorario(Horario horario) {
        this.horario.remove(horario);
    }

    // Métodos para gestión de estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null && !this.estudiantes.contains(estudiante)) {
            this.estudiantes.add(estudiante);
        }
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);
    }

    public int getCantidadEstudiantes() {
        return this.estudiantes.size();
    }

    // Método para verificar si tiene conflictos de horario
    public boolean tieneConflictoHorario() {
        for (int i = 0; i < horario.size(); i++) {
            for (int j = i + 1; j < horario.size(); j++) {
                if (horario.get(i).seSolapaCon(horario.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean puedeAgregarDocente(Docente docente) {
        // Validar que el docente no tenga conflictos de horario
        return docente != null && !this.docente.contains(docente);
    }
    
    public boolean validarIntegridad() {
        return materia != null && 
               comision != null && 
               !docente.isEmpty() && 
               !horario.isEmpty() &&
               !tieneConflictoHorario();
    }

    @Override
    public String toString() {
        return "MateriaImplementada{" +
                "materia=" + (materia != null ? materia.getNombre() : "null") +
                ", cantidadDocentes=" + docente.size() +
                ", cantidadHorarios=" + horario.size() +
                ", promocion=" + promocion +
                ", cantidadEstudiantes=" + estudiantes.size() +
                '}';
    }
}
