package org.GrupoNavarro;

import java.util.ArrayList;

public class Solicitud extends Servicios{

    private String codigoSolicitud;
    private String fechaAtención;
    private String fechaEmisión;
    private String comentarios;
    private String estado;

    //Llamo a Zona (para sacar tarifa)
    private ZonaPostal zona;
    //Listo las solicitudes
    private ArrayList<Solicitud> listaSolicitudes;

    public Solicitud(String nombre, double tarifaServico, String codigoSolicitud, String fechaAtención, String fechaEmisión, String comentarios, String estado, Servicios servicio, ZonaPostal zona) {
        super(nombre, tarifaServico);
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtención = fechaAtención;
        this.fechaEmisión = fechaEmisión;
        this.comentarios = comentarios;
        this.estado = estado;
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
        double importeBase = servicio.getTarifaServico();
        double igv = importeBase*0.18;
        double importeFinal = importeBase+igv;
        return importeFinal;
    }


}
