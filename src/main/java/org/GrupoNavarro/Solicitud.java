package org.GrupoNavarro;

public class SolicitudPedido {

    //JV
    private String codigoSolicitud;
    private String fechaAtención;
    private String fechaEmisión;
    private String comentarios;
    private String estado;

    //Heredo Servicio con su tarifa
    private String servicio;
    //Heredo Zona con su tarifa
    private String zona;

    public SolicitudPedido(String codigoSolicitud, String fechaAtención, String fechaEmisión, String comentarios) {
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtención = fechaAtención;
        this.fechaEmisión = fechaEmisión;
        this.comentarios = comentarios;
        this.estado = "EN GESTION";
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


    private void costoServicio(){
        //if(servicio.getTipo().equals("Gasfiteria"))
        //{
        // return servicio.getCostoServicio;
        //}
    }
    private void costoZona(){
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

    private void descuentoZonaServicio(){
        //if(zona.getZona().equals("Lima"))
        //{
        // return zona.getTarifaZona();
        //}
    }

    private void costoFinal(){
        //return costoServicio()+costoZona()-descuentoZonaServicio();
    }


}
