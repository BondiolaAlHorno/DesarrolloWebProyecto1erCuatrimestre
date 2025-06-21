package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
public class Prestamo {
    private Item item;
    private Persona persona;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Boolean renovado;

    public Prestamo(Item item, Persona persona, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.item = item;
        this.persona = persona;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.renovado = false;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "item=" + item +
                ", persona=" + persona +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", renovado=" + renovado +
                '}';
    }
}
