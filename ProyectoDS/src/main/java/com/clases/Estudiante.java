package com.clases;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Estudiante extends Persona {
    private List<Carrera> carreras;
    private List<MateriaEstudiante> materias;


    public Estudiante(String nombre, String apellido, String dni){
        super(nombre, apellido, dni);
        this.carreras = new ArrayList<>();
        this.materias = new ArrayList<>();
    }

    //Modulo alta estudiante(constructor simplificado)
    public static Estudiante altaEstudiante(String nombre, String apellido, String dni) {
        return new Estudiante(nombre,apellido,dni);
    }

    //Modificar estudiante 
    public void modificarEstudiante(String nombre, String apellido, String dni) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
    }

    public List<Object> recuperarEstudiante(){
        return new ArrayList<>(List.of(this.getNombre(),this.getApellido(),this.getDni(),this.getCarreras(),this.getMaterias()));
    }

    public List<MateriaImplementada> recuperarListadoMateriasCursadas() {
//        List<MateriaImplementada> materias = estudiante.getMaterias().stream().map(MateriaEstudiante::getMateria).collect(Collectors.toList());
        List<MateriaImplementada> materias = new ArrayList<>();
        for (MateriaEstudiante materiaEstudiante : this.getMaterias()){
            materias.add(materiaEstudiante.getMateria());
        }
        return materias;
    }
//    public void agregarCarrera(Carrera carrera){
//        this.carreras.add(carrera);
//    }
//
//    //Método para eliminar carrera
//    public void eliminarCarrera(Carrera carrera){
//        this.carreras.remove(carrera);
//    }
//
//    //Metodo para agregar materia
//    public void agregarMateria(MateriaEstudiante materia){
//        this.materias.add(materia);
//    }
//
//    //Metodo para eliminar materia
//    public void eliminarMateria(MateriaEstudiante materia){
//        this.materias.remove(materia);
//    }
}


