package org.GrupoNavarro;

import java.util.ArrayList;

public class Servicios {
    private String nombre;
    private double tarifaServico;

    private ArrayList<Servicios> servicios = new ArrayList<>();
    Servicios servicio1 = new Servicios("Instalacioón de camaras", 56);
    Servicios servicio2 = new Servicios("Cercos electricos", 80);
    Servicios servicio3 = new Servicios("Alarmas de seguridad", 500);
    Servicios servicio4 = new Servicios("Intercomunicador", 200);
    Servicios servicio5 = new Servicios("Alarmas contra incendio", 150);
    Servicios servicio6 = new Servicios("Control de acceso", 170);
    Servicios servicio7 = new Servicios("electricistas", 800);

    public Servicios(String nombre, double tarifaServico) {
        this.nombre = nombre;
        this.tarifaServico = tarifaServico;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifaServico() {
        return tarifaServico;
    }
}
