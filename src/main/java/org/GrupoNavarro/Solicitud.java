package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solicitud extends Servicios{

    private String codigoSolicitud;
    private String fechaAtención;
    private String fechaEmisión;
    private String comentarios;
    private String estado;

    //Llamo a Zona (para sacar tarifa)
    private ZonaPostal zona;
    //Llamo a técnico
    private PersonalTecnico personalTecnico;
    //Listo las solicitudes
    private static ArrayList<Solicitud> listaSolicitudes;

    public Solicitud(String nombre, double tarifaServico, String codigoSolicitud, String fechaAtención, String fechaEmisión, String comentarios, ZonaPostal zona) {
        super(nombre, tarifaServico);
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtención = fechaAtención;
        this.fechaEmisión = fechaEmisión;
        this.comentarios = comentarios;
        this.estado = "EN GESTION";
        this.zona = zona;
        this.listaSolicitudes = new ArrayList<>();
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getFechaAtención() {
        return fechaAtención;
    }

    public void setFechaAtención(String fechaAtención) {
        this.fechaAtención = fechaAtención;
    }

    public String getFechaEmisión() {
        return fechaEmisión;
    }

    public void setFechaEmisión(String fechaEmisión) {
        this.fechaEmisión = fechaEmisión;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public static void agregarSolicitud(Solicitud solicitud){
        listaSolicitudes.add(solicitud);
    }

    public double descuentoServicio(Servicios servicio){

        if (servicio.getNombre().equals("Alarmas de seguridad")){
            return 0.20;
        } else if (servicio.getNombre().equals("Cercos electricos")) {
            return 0.15;
        } else if (servicio.getNombre().equals("Intercomunicadores")) {
            return 0.10;
        } else {
            return 0;
        }
    }

    public double costoFinal(Servicios servicio, ZonaPostal zona){
        //Falta agregar Zona
        double importeBase = servicio.getTarifaServico();
        double igv = importeBase*0.18;
        return importeBase+igv-descuentoServicio(servicio);
    }

    public void listarSolicitudes() {
        System.out.println("\nLista de Solicitudes:");
        int contador = 1;
        for (Solicitud servicio : listaSolicitudes) {
            System.out.println(contador + ". " + servicio);
            contador++;
        }
    }

    public static void registrarNuevaSolicitud(){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);;

        System.out.println("Agregar Solicitud:");
        // Ingresar código de nueva solicitud
        System.out.print("Ingrese el código de la solicitud: ");
        String codSolicitud = scanner.nextLine();
        System.out.print("Ingrese la fecha de atención: ");
        String fechaAt = scanner.nextLine();
        System.out.print("Ingrese la fecha de Emisión: ");
        String fechaEm = scanner.nextLine();
        System.out.print("Ingrese comentarios: ");
        String comentarios = scanner.nextLine();
        System.out.print("Seleccione su Servicio");
        System.out.print("Seleccione su Zana");

        String nom = "";
        double varr = 0;

        try {
            // Crear y agregar solicitud a la lista
            //Solicitud nuevaSolicitud = new Solicitud(nom,varr,codSolicitud,fechaAt,fechaEm,comentarios,);
            //Solicitud.agregarSolicitud(nuevaSolicitud);
            System.out.println("Servicio agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el servicio: " + e.getMessage());
        }

    }




}
