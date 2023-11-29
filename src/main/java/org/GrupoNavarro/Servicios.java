package org.GrupoNavarro;

import java.util.ArrayList;

public class Servicios {
    private String nombre;
    private double tarifaServico;

    public static ArrayList<Servicios> listaServicios = new ArrayList<>();

    Servicios(String nombre, double tarifaServico) {
        this.nombre = nombre;
        this.tarifaServico = tarifaServico;

    }
    public String getNombre() {
        return nombre;
    }

    public double getTarifaServico() {
        return tarifaServico;
    }

    public static void agregarServicio(Servicios servicio) {
        listaServicios.add(servicio);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tarifa: " + tarifaServico;
    }
    public static void imprimirServicios() {
        System.out.println("\nLista de Servicios:");
        for (Servicios servicio : listaServicios) {
            System.out.println(servicio);
        }
    }
}
