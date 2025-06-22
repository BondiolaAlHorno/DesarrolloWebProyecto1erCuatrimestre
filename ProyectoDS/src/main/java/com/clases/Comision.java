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

    public Comision(List<MateriaImplementada> materias, Carrera carrera, List<Estudiante> estudiantes, 
                   String turno, String nombre) {
        this.materias = materias != null ? new ArrayList<>(materias) : new ArrayList<>();
        this.carrera = carrera;
        this.estudiantes = estudiantes != null ? new ArrayList<>(estudiantes) : new ArrayList<>();
        this.turno = turno;
        this.nombre = nombre;
    }

    // Constructor por defecto
    public Comision() {
        this.materias = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public static Comision altaComision(List<MateriaImplementada> materias, Carrera carrera, 
                                       List<Estudiante> estudiantes, String turno, String nombre) {
        return new Comision(materias, carrera, estudiantes, turno, nombre);
    }

    public void modificarComision(List<MateriaImplementada> materias, Carrera carrera, 
                                 List<Estudiante> estudiantes, String turno, String nombre) {
        this.setMaterias(materias);
        this.setCarrera(carrera);
        this.setEstudiantes(estudiantes);
        this.setTurno(turno);
        this.setNombre(nombre);
    }

    public List<Object> recuperarComision() {
        return new ArrayList<>(List.of(this.getMaterias(), this.getCarrera(), this.getEstudiantes(), 
                                     this.getTurno(), this.getNombre()));
    }

    // Métodos para gestión de materias implementadas
    public void agregarMateriaImplementada(MateriaImplementada materia) {
        if (materia != null && !this.materias.contains(materia)) {
            this.materias.add(materia);
            // Establecer la relación bidireccional
            materia.setComision(this);
        }
    }

    public void eliminarMateriaImplementada(MateriaImplementada materia) {
        if (this.materias.remove(materia)) {
            // Romper la relación bidireccional
            materia.setComision(null);
        }
    }

    // Métodos para gestión de estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null && !this.estudiantes.contains(estudiante)) {
            this.estudiantes.add(estudiante);
            // También agregar el estudiante a todas las materias implementadas
            for (MateriaImplementada materia : this.materias) {
                materia.agregarEstudiante(estudiante);
            }
        }
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        if (this.estudiantes.remove(estudiante)) {
            // También eliminar el estudiante de todas las materias implementadas
            for (MateriaImplementada materia : this.materias) {
                materia.eliminarEstudiante(estudiante);
            }
        }
    }

    public int getCantidadEstudiantes() {
        return this.estudiantes.size();
    }

    // Método para obtener todos los docentes de la comisión
    public List<Docente> getTodosLosDocentes() {
        List<Docente> todosLosDocentes = new ArrayList<>();
        for (MateriaImplementada materia : this.materias) {
            for (Docente docente : materia.getDocente()) {
                if (!todosLosDocentes.contains(docente)) {
                    todosLosDocentes.add(docente);
                }
            }
        }
        return todosLosDocentes;
    }

    // Método para verificar si tiene conflictos de horario
    public boolean tieneConflictosHorario() {
        List<Horario> todosLosHorarios = new ArrayList<>();
        
        // Recopilar todos los horarios de todas las materias
        for (MateriaImplementada materia : this.materias) {
            todosLosHorarios.addAll(materia.getHorario());
        }
        
        // Verificar conflictos
        for (int i = 0; i < todosLosHorarios.size(); i++) {
            for (int j = i + 1; j < todosLosHorarios.size(); j++) {
                if (todosLosHorarios.get(i).seSolapaCon(todosLosHorarios.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para verificar si la comisión está completa (tiene carrera y al menos una materia)
    public boolean estaCompleta() {
        return this.carrera != null && !this.materias.isEmpty() && 
               this.turno != null && !this.turno.isEmpty() &&
               this.nombre != null && !this.nombre.isEmpty();
    }

    @Override
    public String toString() {
        return "Comision{" +
                "nombre='" + nombre + '\'' +
                ", turno='" + turno + '\'' +
                ", carrera=" + (carrera != null ? carrera.getNombre() : "null") +
                ", cantidadMaterias=" + materias.size() +
                ", cantidadEstudiantes=" + estudiantes.size() +
                '}';
    }
}