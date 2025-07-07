package com.clases;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Legajo {
    private String fechaAlta;
    private List<Documento> documentacion;
    private Boolean estado;

    public Legajo(String fechaAlta, List<Documento> documentacion, Boolean estado) {
        this.fechaAlta = fechaAlta;
        this.documentacion = documentacion;
        this.estado = estado;
    }

    public static Legajo crearLegajo(String fechaAlta, List<Documento> documentos) {
        return new Legajo(fechaAlta, documentos, true);
    }

    public void actualizarLegajo(String nuevaFecha, List<Documento> nuevosDocumentos, Boolean nuevoEstado) {
        this.fechaAlta = nuevaFecha;
        this.documentacion = nuevosDocumentos;
        this.estado = nuevoEstado;
    }

    public String consultarLegajo() {
        return "Fecha de alta: " + fechaAlta + "\n" +
                "Estado: " + (estado ? "Activo" : "Inactivo") + "\n" +
                "Cantidad de documentos: " + (documentacion != null ? documentacion.size() : 0);
    }

    public String controlDeCondicionDetallado() {
        // Documentos requeridos
        List<String> requeridos = List.of("DNI", "TITULO", "CV", "MATRICULA");

        // Extraer tipos presentes en el legajo
        List<String> tiposPresentes = new ArrayList<>();
        if (documentacion != null) {
            for (Documento doc : documentacion) {
                if (doc.getTipo() != null) {
                    tiposPresentes.add(doc.getTipo().toUpperCase());
                }
            }
        }

        // Verificar faltantes
        List<String> faltantes = new ArrayList<>();
        for (String requerido : requeridos) {
            if (!tiposPresentes.contains(requerido.toUpperCase())) {
                faltantes.add(requerido);
            }
        }

        // Evaluar condición
        if (!estado) {
            return "Estado: IRREGULAR - El legajo está inactivo.";
        } else if (faltantes.isEmpty()) {
            return "Estado: REGULAR - Toda la documentación está completa.";
        } else if (faltantes.size() < requeridos.size()) {
            return "Estado: PENDIENTE - Faltan documentos: " + String.join(", ", faltantes);
        } else {
            return "Estado: IRREGULAR - No se ha presentado documentación obligatoria.";
        }
    }

}
