package com.clases;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
@Getter
@Setter
public class SistemaPrestamos {
    private List<Item> items ;
    private List<Persona> personas ;
    private List<Prestamo> prestamos ;

    public SistemaPrestamos() {
        items = new ArrayList<>();
        personas = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    // --------- ITEM ---------
    public void altaItem(Item item) {
        items.add(item);
    }

    public boolean bajaItem(String nombre) {
        Item item = buscarItem(nombre);
        if (item != null && item.getEstado()) { // sólo si está disponible
            return items.remove(item);
        }
        return false;
    }

    public boolean modificacionItem(String nombre, String nuevoNombre, String nuevoTipo, Boolean nuevoEstado) {
        Item item = buscarItem(nombre);
        if (item != null) {
            if (nuevoNombre != null) item.setNombre(nuevoNombre);
            if (nuevoTipo != null) item.setTipo(nuevoTipo);
            if (nuevoEstado != null) item.setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    private Item buscarItem(String nombre) {
        for (Item i : items) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return null;
    }

    // --------- PERSONA ---------
    public void altaPersona(Persona persona) {
        personas.add(persona);
    }

    public boolean bajaPersona(String dni) {
        Persona p = buscarPersona(dni);
        if (p != null && prestamos.stream().noneMatch(pr -> pr.getPersona().getDni().equals(dni))) {
            return personas.remove(p);
        }
        return false; // no se puede borrar persona con préstamos activos
    }

    public boolean modificacionPersona(String dni, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        Persona p = buscarPersona(dni);
        if (p != null) {
            if (nuevoNombre != null) p.setNombre(nuevoNombre);
            if (nuevoApellido != null) p.setApellido(nuevoApellido);
            if (nuevoDni != null) p.setDni(nuevoDni);
            return true;
        }
        return false;
    }

    private Persona buscarPersona(String dni) {
        for (Persona p : personas) {
            if (p.getDni().equals(dni)) {
                return p;
            }
        }
        return null;
    }

    // --------- PRESTAMO ---------
    public boolean altaPrestamo(String nombreItem, String dniPersona, LocalDate inicio, LocalDate fin) {
        Item item = buscarItem(nombreItem);
        Persona persona = buscarPersona(dniPersona);

        if (item == null || persona == null) {
            return false;
        }
        if (!item.getEstado()) {
            return false; // item ya está prestado
        }

        Prestamo prestamo = new Prestamo(item, persona, inicio, fin);
        prestamos.add(prestamo);
        item.setEstado(false); // marcar item como prestado
        return true;
    }

    public boolean bajaPrestamo(String nombreItem, String dniPersona) {
        Prestamo p = buscarPrestamo(nombreItem, dniPersona);
        if (p != null) {
            prestamos.remove(p);
            p.getItem().setEstado(true); // marcar item disponible
            return true;
        }
        return false;
    }

    public boolean modificacionPrestamo(String nombreItem, String dniPersona, LocalDate nuevoInicio, LocalDate nuevoFin, Boolean renovado) {
        Prestamo p = buscarPrestamo(nombreItem, dniPersona);
        if (p != null) {
            if (nuevoInicio != null) p.setFecha_inicio(nuevoInicio);
            if (nuevoFin != null) p.setFecha_fin(nuevoFin);
            if (renovado != null) p.setRenovado(renovado);
            return true;
        }
        return false;
    }

    private Prestamo buscarPrestamo(String nombreItem, String dniPersona) {
        for (Prestamo p : prestamos) {
            if (p.getItem().getNombre().equalsIgnoreCase(nombreItem) && p.getPersona().getDni().equals(dniPersona)) {
                return p;
            }
        }
        return null;
    }

    // --------- FUNCIONES SOLICITADAS ---------

    // Renueva un préstamo extendiendo la fecha de fin 7 días, sólo 1 vez
    public boolean renovarPrestamo(String nombreItem, String dniPersona) {
        Prestamo p = buscarPrestamo(nombreItem, dniPersona);
        if (p != null && !p.getRenovado()) {
            p.setFecha_fin(p.getFecha_fin().plusDays(7));
            p.setRenovado(true);
            return true;
        }
        return false;
    }

    // Devuelve el préstamo y libera el item
    public boolean devolverPrestamo(String nombreItem, String dniPersona) {
        Prestamo p = buscarPrestamo(nombreItem, dniPersona);
        if (p != null) {
            p.getItem().setEstado(true);
            prestamos.remove(p);
            return true;
        }
        return false;
    }

    // Consulta todos los préstamos de una persona por DNI
    public List<Prestamo> consultarPrestamo(String dni) {
        return prestamos.stream()
                .filter(p -> p.getPersona().getDni().equals(dni))
                .collect(Collectors.toList());
    }

    // Devuelve lista de todos los préstamos
    public List<Prestamo> historialPrestamos() {
        return new ArrayList<>(prestamos);
    }
}

