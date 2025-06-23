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

    public void setHoraInicio(String horaInicio) {
        if (horaInicio == null || horaInicio.trim().isEmpty()) {
            throw new IllegalArgumentException("La hora de inicio no puede ser nula o vacía");
        }
        if (!validarFormatoHora(horaInicio.trim())) {
            throw new IllegalArgumentException("Formato de hora inválido. Use HH:mm");
        }
        this.horaInicio = horaInicio.trim();
    }
    
    public void setHoraFin(String horaFin) {
        if (horaFin == null || horaFin.trim().isEmpty()) {
            throw new IllegalArgumentException("La hora de fin no puede ser nula o vacía");
        }
        if (!validarFormatoHora(horaFin.trim())) {
            throw new IllegalArgumentException("Formato de hora inválido. Use HH:mm");
        }
        this.horaFin = horaFin.trim();
    }
    
    public void setDia(String dia) {
        if (dia == null || dia.trim().isEmpty()) {
            throw new IllegalArgumentException("El día no puede ser nulo o vacío");
        }
        String[] diasValidos = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO"};
        String diaUpper = dia.trim().toUpperCase();
        boolean esValido = Arrays.stream(diasValidos).anyMatch(d -> d.equals(diaUpper));
        if (!esValido) {
            throw new IllegalArgumentException("Día inválido. Use: Lunes, Martes, Miércoles, Jueves, Viernes, Sábado");
        }
        this.dia = diaUpper;
    }
    
    public List<Object> recuperarHorario() {
        return new ArrayList<>(List.of(this.getHoraInicio(), this.getHoraFin(), this.getDia()));
    }

    // Método para validar si hay superposición de horarios
    public boolean seSolapaCon(Horario otroHorario) {
        if (!this.dia.equals(otroHorario.dia)) {
            return false;
        }
        
        try {
            // Convertir horas a minutos desde medianoche para facilitar comparación
            int inicioEste = convertirHoraAMinutos(this.horaInicio);
            int finEste = convertirHoraAMinutos(this.horaFin);
            int inicioOtro = convertirHoraAMinutos(otroHorario.horaInicio);
            int finOtro = convertirHoraAMinutos(otroHorario.horaFin);
            
            // Verificar si hay solapamiento
            // Dos horarios se solapan si: inicio1 < fin2 && inicio2 < fin1
            return inicioEste < finOtro && inicioOtro < finEste;
            
        } catch (Exception e) {
            // Si hay error en el formato de hora, asumir que no se solapan
            return false;
        }
    }
    
    // Método auxiliar para convertir hora en formato "HH:mm" a minutos desde medianoche
    private int convertirHoraAMinutos(String hora) {
        if (hora == null || hora.isEmpty()) {
            throw new IllegalArgumentException("Hora no válida");
        }
        
        String[] partes = hora.split(":");
        if (partes.length != 2) {
            throw new IllegalArgumentException("Formato de hora inválido. Use HH:mm");
        }
        
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        
        if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59) {
            throw new IllegalArgumentException("Hora fuera del rango válido");
        }
        
        return horas * 60 + minutos;
    }

    // Método para verificar si el horario es válido
    public boolean esValido() {
        if (horaInicio == null || horaFin == null || dia == null ||
            horaInicio.isEmpty() || horaFin.isEmpty() || dia.isEmpty()) {
            return false;
        }
        
        try {
            int inicioMinutos = convertirHoraAMinutos(horaInicio);
            int finMinutos = convertirHoraAMinutos(horaFin);
            
            // La hora de fin debe ser posterior a la hora de inicio
            return finMinutos > inicioMinutos;
            
        } catch (Exception e) {
            return false;
        }
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
