package org.GrupoNavarro;

import java.util.ArrayList;

public class Solicitud {

    private String codigoSolicitud;
    private String fechaAtención;
    private String fechaEmisión;
    private String comentarios;
    private String estado;

    //Llamo a Servicios
    private Servicios servicio;
    //Llamo a Zona
    private ZonaPostal zona;
    //Listo las solicitudes
    private ArrayList<Solicitud> listaSolicitudes;

    public Solicitud(String codigoSolicitud, String fechaAtención, String fechaEmisión, String comentarios) {
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtención = fechaAtención;
        this.fechaEmisión = fechaEmisión;
        this.comentarios = comentarios;
        this.estado = "EN GESTION";
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


    public void agregarSolicitud(Solicitud solicitud){
        listaSolicitudes.add(solicitud);
    }

    public void costoServicio(){
        //if(servicio.getTipo().equals("Gasfiteria"))
        //{
        // return servicio.getCostoServicio;
        //}
    }
    public void costoZona(){
        //if(zona.getZona().equals("Lima"))
        //{
        // return zona.getTarifaZona();
        //}

        //O puede ser solo un intento

        //if(zona.getZona().equals("Lima"))
        //{
        // return zona.getTarifaZona();
        //}

    }

    public void descuentoZonaServicio(){
        //if(zona.getZona().equals("Lima"))
        //{
        // return zona.getTarifaZona();
        //}
    }

    public double costoFinal(Servicios servicio, ZonaPostal zona){
        //Falta agregar Zona
        double importeFinal = servicio.getTarifaServico();
        return 0.00;
    }


}
