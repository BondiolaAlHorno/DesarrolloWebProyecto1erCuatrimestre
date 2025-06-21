package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Horario {
    private String horaInicio;
    private String horaFin;
    private String dia;

    public Horario(String horaInicio,String horaFin,String dia){
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.dia=dia;
    }

    public static Horario altaHorario(String horaInicio,String horaFin,String dia){
        return new Horario(horaInicio, horaFin, dia);
    }

    public void modificarHorario(String horaInicio,String horaFin,String dia){
        this.setHoraInicio(horaInicio);
        this.setHoraFin(getHoraFin());
        this.setDia(dia);
    }

    public List<Object> recuperarHorario(){
        return new ArrayList<>(List.of(this.getHoraInicio(),this.getHoraFin(),this.getDia()));
    }
}
