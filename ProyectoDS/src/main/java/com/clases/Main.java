package com.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //OBTENGO LA FECHA ACTUAL
        LocalDate f = LocalDate.now();

        //CREAMOS PERSONAS Y ESTUDIANTES
        Persona p = new Persona("Elias", "Pagnoni", "123456");
        Estudiante est = new Estudiante("Nico", "Drean", "159753");
        ArrayList<Estudiante> listEst = new ArrayList<>();
        listEst.add(est);

        //CREAMOS LA CARRERA
        Carrera car = new Carrera("Desarrollador de Software", "3 años");

        //CREAMOS LA MATERIA
        Materia mat = new Materia("Matematicas", 2, 2);

        MateriaImplementada matImp = new MateriaImplementada(mat, doc, "12", "True",com);

        //CREACION DE LISTA DE MATERIAS IMPLEMENTADAS
        Comision com = new Comision(List.of(matImp), car, listEst); //Se agregará matImp luego

        //CREACION DE ASISTENCIA
        Asistencia asistencia = new Asistencia(f,"Presente", null, est);

        //CREAR DOCENTE (DOCENTE NECESITA UNA ASISTENCIA Y MATERIA IMPLEMENTADA, QUE AÚN NO ESTÁN LISTOS)
        Docente doc = new Docente("Nicolás", "Dino", "456789", 1, asistencia, null);

        //CREAR MATERIA IMPLEMENTADA (AHORA QUE TENEMOS DOCENTE Y COMISION)
        MateriaImplementada matImp = new MateriaImplementada(mat, doc, "12", "True",com);

        //ASIGNAMOS LA MATERIA IMPLEMENTADA A LA ASISTENCIA Y AL DOCENTE
        asistencia.setMateria(matImp);
        doc.setMateria(matImp);

        //LISTA DE ASISTENCIAS
        ArrayList<Asistencia> listaAsistencia = new ArrayList<>();
        listaAsistencia.add(asistencia);

        //LO VERIFICAMOS
        System.out.println("Estudiante: " + est.getNombre());
        System.out.println("Materia: " + mat.getNombre());
        System.out.println("Asistencia: " + asistencia.getAsistencia());

    }
}
