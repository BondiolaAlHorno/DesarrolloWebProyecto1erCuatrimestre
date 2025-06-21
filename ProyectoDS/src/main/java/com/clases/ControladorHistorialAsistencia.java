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
public class ControladorHistorialAsistencia {
    private List<Carrera> carreraList;
    private List<Comision> comisionList;
    private List<Materia> materiaList;
    private List<MateriaImplementada> materiaImplementadaList;
    private List<MateriaEstudiante> materiaEstudianteList;
    private List<AsistenciaEstudiante> asistenciaEstudianteList;
    private List<Estudiante> estudianteList;

    public ControladorHistorialAsistencia(){}

    public List<AsistenciaEstudiante> crearListadoDeAsistencias(MateriaImplementada materia){
//        List<AsistenciaEstudiante> asistencias = materia.getEstudiantes().stream().map(estudiante -> AsistenciaEstudiante.altaAsistenciaEstudiante(LocalDate.now(),"A",materia,estudiante)).collect(Collectors.toList());
        List<AsistenciaEstudiante> asistencias = new ArrayList<>();
        for (Estudiante estudiante : materia.getEstudiantes()){
            asistencias.add(AsistenciaEstudiante.altaAsistenciaEstudiante(LocalDate.now(),"A",materia,estudiante));
        }
        return asistencias;
    }

    public List<Comision> recuperarListadoDeComisionesPorCarrera(Carrera carrera, List<Comision> comisiones){
        List<Comision> comisionesMateria = new ArrayList<>();
        for(Comision comision : comisiones){
            if (comision.getCarrera().equals(carrera)){
                comisionesMateria.add(comision);
            }
        }
        return  comisionesMateria;
    }

    public List<MateriaImplementada> recuperarListadoMateriasCursadas(Estudiante estudiante) {
//        List<MateriaImplementada> materias = estudiante.getMaterias().stream().map(MateriaEstudiante::getMateria).collect(Collectors.toList());
        List<MateriaImplementada> materias = new ArrayList<>();
        for (MateriaEstudiante materiaEstudiante : estudiante.getMaterias()){
            materias.add(materiaEstudiante.getMateria());
        }
        return materias;
    }

    public List<LocalDate> recuperarListadoDeFechas(List<AsistenciaEstudiante> listaAsistencia){
//        List<LocalDate> listaFecha = listaAsistencia.stream().map(AsistenciaEstudiante::getFecha).collect(Collectors.toList());
        List<LocalDate> listaFecha = new ArrayList<>();
        for (AsistenciaEstudiante asistencia : listaAsistencia){
            listaFecha.add(asistencia.getFecha());
        }
        return listaFecha;
    }

    public List<AsistenciaEstudiante> recuperarListadoAsistenciaPorMateria(List<AsistenciaEstudiante> listaAsistencia, MateriaImplementada materia){
//        List<AsistenciaEstudiante> asistencias = listaAsistencia.stream().filter(asistencia -> materia.equals(asistencia.getMateria())).collect(Collectors.toList());
        List<AsistenciaEstudiante> asistencias = new ArrayList<>();
        for (AsistenciaEstudiante asistencia : listaAsistencia){
            if (materia.equals(asistencia.getMateria())){
                asistencias.add(asistencia);
            }
        }
        return asistencias;
    }

    public List<AsistenciaEstudiante> recuperarListadoAsistenciaPorFecha(List<AsistenciaEstudiante> listaAsistencia, LocalDate fecha){
//        List<AsistenciaEstudiante> asistencias = listaAsistencia.stream().filter(asistencia -> fecha.equals(asistencia.getFecha())).collect(Collectors.toList());
        List<AsistenciaEstudiante> asistencias = new ArrayList<>();
        for (AsistenciaEstudiante asistencia : listaAsistencia){
            if (fecha.equals(asistencia.getFecha())){
                asistencias.add(asistencia);
            }
        }
        return asistencias;
    }

    public List<AsistenciaEstudiante> recuperarListadoAsistenciaPorEstudiante(List<AsistenciaEstudiante> listaAsistencia, Estudiante estudiante){
//        List<AsistenciaEstudiante> asistencias = listaAsistencia.stream().filter(asistencia -> estudiante.equals(asistencia.getEstudiante())).collect(Collectors.toList());
        List<AsistenciaEstudiante> asistencias = new ArrayList<>();
        for (AsistenciaEstudiante asistencia : listaAsistencia){
            if (estudiante.equals(asistencia.getEstudiante())){
                asistencias.add(asistencia);
            }
        }
        return asistencias;
    }

    public Double recuperarPorcentajeDeAsistencia(List<AsistenciaEstudiante> listaAsistencia){
//        double porcentaje = ((double)listaAsistencia.stream().filter(asistencia -> "P".equals(asistencia.getAsistencia()) || "J".equals(asistencia.getAsistencia())).count())/(double)listaAsistencia.size()*100.0;
        double porcentaje = 0.0;
        int presentes = 0;
        for (AsistenciaEstudiante asistencia : listaAsistencia){
            if ("P".equals(asistencia.getAsistencia()) || "J".equals(asistencia.getAsistencia())){
                presentes++;
            }
        }
        porcentaje = ((presentes/(double)listaAsistencia.size())*100.0);
        return porcentaje;
    }

    public Double recuperarPromedioSinAplazos(Estudiante estudiante){
        List<Double> notas = new ArrayList<>();
        for (MateriaEstudiante materia : estudiante.getMaterias()){
            if (materia.getEvalucaionFinal().getNota()<4.0){
                notas.add(materia.getEvalucaionFinal().getNota());
            }
        }
        return (notas.stream().mapToDouble(Double::doubleValue).sum())/notas.size();
    }
}
