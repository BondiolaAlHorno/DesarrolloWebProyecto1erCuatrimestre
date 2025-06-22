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

    public Horario(String horaInicio, String horaFin, String dia) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
    }

    // Constructor por defecto
    public Horario() {
    }

    public static Horario altaHorario(String horaInicio, String horaFin, String dia) {
        return new Horario(horaInicio, horaFin, dia);
    }

    public void modificarHorario(String horaInicio, String horaFin, String dia) {
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin); // Corregí el error del getter
        this.setDia(dia);
    }

    public List<Object> recuperarHorario() {
        return new ArrayList<>(List.of(this.getHoraInicio(), this.getHoraFin(), this.getDia()));
    }

    // Método para validar si hay superposición de horarios
    public boolean seSolapaCon(Horario otroHorario) {
        if (!this.dia.equals(otroHorario.dia)) {
            return false;
        }
        
        // Acá debería implementar la lógica de comparación de horas
        // Por ahora retorna false, pero debería convertir las horas a un formato comparable
        return false;
    }

    // Método para verificar si el horario es válido
    public boolean esValido() {
        return horaInicio != null && horaFin != null && dia != null &&
               !horaInicio.isEmpty() && !horaFin.isEmpty() && !dia.isEmpty();
    }

    @Override
    public String toString() {
        return "Horario{" +
                "dia='" + dia + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                '}';
    }
}
