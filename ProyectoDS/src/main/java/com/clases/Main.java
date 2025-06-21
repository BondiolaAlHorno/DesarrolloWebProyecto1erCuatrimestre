package com.clases;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaPrestamos sistema = new SistemaPrestamos();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n---- MENÚ ----");
            System.out.println("1 - Dar de alta Item");
            System.out.println("2 - Dar de baja Item");
            System.out.println("3 - Modificar Item");
            System.out.println("4 - Dar de alta Persona");
            System.out.println("5 - Dar de baja Persona");
            System.out.println("6 - Modificar Persona");
            System.out.println("7 - Dar de alta Préstamo");
            System.out.println("8 - Dar de baja Préstamo");
            System.out.println("9 - Modificar Préstamo");
            System.out.println("10 - Consultar Préstamos por DNI");
            System.out.println("11 - Ver Historial Completo de Préstamos");
            System.out.println("12 - Renovar Préstamo");
            System.out.println("13 - Devolver Préstamo");
            System.out.println("0 - Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del Item: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo del Item: ");
                    String tipo = sc.nextLine();
                    Item nuevo = new Item(nombre, tipo);
                    sistema.altaItem(nuevo);
                    System.out.println("Item dado de alta.");
                }
                case 2 -> {
                    System.out.print("Nombre del Item a eliminar: ");
                    String nombre = sc.nextLine();
                    if (sistema.bajaItem(nombre)) {
                        System.out.println("Item eliminado.");
                    } else {
                        System.out.println("No se pudo eliminar. El item no existe o está prestado.");
                    }
                }
                case 3 -> {
                    System.out.print("Nombre del Item a modificar: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nuevo nombre (ENTER para no cambiar): ");
                    String nuevoNombre = sc.nextLine();
                    if (nuevoNombre.isEmpty()) nuevoNombre = null;
                    System.out.print("Nuevo tipo (ENTER para no cambiar): ");
                    String nuevoTipo = sc.nextLine();
                    if (nuevoTipo.isEmpty()) nuevoTipo = null;
                    System.out.print("Estado (disponible=true / prestado=false / ENTER para no cambiar): ");
                    String estadoStr = sc.nextLine();
                    Boolean nuevoEstado = null;
                    if (!estadoStr.isEmpty()) {
                        nuevoEstado = Boolean.parseBoolean(estadoStr);
                    }
                    if (sistema.modificacionItem(nombre, nuevoNombre, nuevoTipo, nuevoEstado)) {
                        System.out.println("Item modificado.");
                    } else {
                        System.out.println("No se pudo modificar. Item no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("Nombre Persona: ");
                    String nom = sc.nextLine();
                    System.out.print("Apellido Persona: ");
                    String ape = sc.nextLine();
                    System.out.print("DNI Persona (número): ");
                    String dni = sc.nextLine();
                    Persona p = new Persona(nom, ape, dni);
                    sistema.altaPersona(p);
                    System.out.println("Persona dada de alta.");
                }
                case 5 -> {
                    System.out.print("DNI Persona a eliminar: ");
                    String dni = sc.nextLine();
                    if (sistema.bajaPersona(dni)) {
                        System.out.println("Persona eliminada.");
                    } else {
                        System.out.println("No se pudo eliminar. La persona no existe o tiene préstamos activos.");
                    }
                }
                case 6 -> {
                    System.out.print("DNI Persona a modificar: ");
                    String dni = sc.nextLine();
                    System.out.print("Nuevo nombre (ENTER para no cambiar): ");
                    String nuevoNom = sc.nextLine();
                    if (nuevoNom.isEmpty()) nuevoNom = null;
                    System.out.print("Nuevo apellido (ENTER para no cambiar): ");
                    String nuevoApe = sc.nextLine();
                    if (nuevoApe.isEmpty()) nuevoApe = null;
                    System.out.print("Nuevo DNI (número) (0 para no cambiar): ");
                    String nuevoDni = sc.nextLine();
                    String dniObj = nuevoDni.equals("0") ? null : nuevoDni;

                    if (sistema.modificacionPersona(dni, nuevoNom, nuevoApe, dniObj)) {
                        System.out.println("Persona modificada.");
                    } else {
                        System.out.println("No se pudo modificar. Persona no encontrada.");
                    }
                }
                case 7 -> {
                    System.out.print("Nombre del Item a prestar: ");
                    String nombreItem = sc.nextLine();
                    System.out.print("DNI de la Persona que presta: ");
                    String dni = sc.nextLine();
                    System.out.print("Fecha inicio préstamo (AAAA-MM-DD): ");
                    String fInicio = sc.nextLine();
                    System.out.print("Fecha fin préstamo (AAAA-MM-DD): ");
                    String fFin = sc.nextLine();
                    try {
                        LocalDate inicio = LocalDate.parse(fInicio);
                        LocalDate fin = LocalDate.parse(fFin);
                        if (sistema.altaPrestamo(nombreItem, dni, inicio, fin)) {
                            System.out.println("Préstamo registrado.");
                        } else {
                            System.out.println("No se pudo registrar el préstamo. Verifique datos y que el item esté disponible.");
                        }
                    } catch (Exception e) {
                        System.out.println("Formato de fecha inválido.");
                    }
                }
                case 8 -> {
                    System.out.print("Nombre del Item a devolver: ");
                    String nombreItem = sc.nextLine();
                    System.out.print("DNI de la Persona que devuelve: ");
                    String dni = sc.nextLine();
                    if (sistema.bajaPrestamo(nombreItem, dni)) {
                        System.out.println("Préstamo eliminado y item devuelto.");
                    } else {
                        System.out.println("No se pudo eliminar el préstamo. Verifique datos.");
                    }
                }
                case 9 -> {
                    System.out.print("Nombre del Item del préstamo a modificar: ");
                    String nombreItem = sc.nextLine();
                    System.out.print("DNI de la Persona: ");
                    String dni = sc.nextLine();

                    System.out.print("Nueva fecha inicio (AAAA-MM-DD) o ENTER para no cambiar: ");
                    String nuevoInicioStr = sc.nextLine();
                    LocalDate nuevoInicio = null;
                    if (!nuevoInicioStr.isEmpty()) {
                        try {
                            nuevoInicio = LocalDate.parse(nuevoInicioStr);
                        } catch (Exception e) {
                            System.out.println("Fecha inicio inválida, no se cambiará.");
                        }
                    }
                    System.out.print("Nueva fecha fin (AAAA-MM-DD) o ENTER para no cambiar: ");
                    String nuevoFinStr = sc.nextLine();
                    LocalDate nuevoFin = null;
                    if (!nuevoFinStr.isEmpty()) {
                        try {
                            nuevoFin = LocalDate.parse(nuevoFinStr);
                        } catch (Exception e) {
                            System.out.println("Fecha fin inválida, no se cambiará.");
                        }
                    }
                    System.out.print("Renovado? (true/false) o ENTER para no cambiar: ");
                    String renovadoStr = sc.nextLine();
                    Boolean renovado = null;
                    if (!renovadoStr.isEmpty()) {
                        renovado = Boolean.parseBoolean(renovadoStr);
                    }

                    if (sistema.modificacionPrestamo(nombreItem, dni, nuevoInicio, nuevoFin, renovado)) {
                        System.out.println("Préstamo modificado.");
                    } else {
                        System.out.println("No se pudo modificar. Préstamo no encontrado.");
                    }
                }
                case 10 -> {
                    System.out.print("DNI de la Persona para consultar préstamos: ");
                    String dni = sc.nextLine();
                    List<Prestamo> lista = sistema.consultarPrestamo(dni);
                    if (lista.isEmpty()) {
                        System.out.println("No tiene préstamos activos.");
                    } else {
                        System.out.println("Préstamos de la persona:");
                        for (Prestamo p : lista) {
                            System.out.println(p);
                        }
                    }
                }
                case 11 -> {
                    List<Prestamo> lista = sistema.historialPrestamos();
                    if (lista.isEmpty()) {
                        System.out.println("No hay préstamos registrados.");
                    } else {
                        System.out.println("Historial completo de préstamos:");
                        for (Prestamo p : lista) {
                            System.out.println(p);
                        }
                    }
                }
                case 12 -> {
                    System.out.print("Nombre del Item para renovar préstamo: ");
                    String nombreItem = sc.nextLine();
                    System.out.print("DNI de la Persona: ");
                    String dni = sc.nextLine();
                    if (sistema.renovarPrestamo(nombreItem, dni)) {
                        System.out.println("Préstamo renovado 7 días más.");
                    } else {
                        System.out.println("No se pudo renovar. Verifique que el préstamo exista y no haya sido renovado antes.");
                    }
                }
                case 13 -> {
                    System.out.print("Nombre del Item a devolver: ");
                    String nombreItem = sc.nextLine();
                    System.out.print("DNI de la Persona que devuelve: ");
                    String dni = sc.nextLine();
                    if (sistema.devolverPrestamo(nombreItem, dni)) {
                        System.out.println("Préstamo devuelto y eliminado.");
                    } else {
                        System.out.println("No se pudo devolver. Verifique datos.");
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
