package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Documento {
    private String nombre;
    private String tipo; //por ej DNI, TITULO, CV
    private String urlArchivo; //o ruta local

    public Documento(String nombre, String tipo, String urlArchivo){
        this.nombre=nombre;
        this.tipo=tipo;
        this.urlArchivo=urlArchivo;
    }
}
