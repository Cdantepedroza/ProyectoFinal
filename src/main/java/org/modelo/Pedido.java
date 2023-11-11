package org.modelo;

public class Pedido {
    private String cliente;
    private String tipoServicio;
    private Tecnico tecnicoAsignado;
    private double tarifaUbicacion;
    // Otros atributos relacionados con el pedido
    public Pedido(String cliente, String tipoServicio, Tecnico tecnicoAsignado, double tarifaUbicacion) {
        this.cliente = cliente;
        this.tipoServicio = tipoServicio;
        this.tecnicoAsignado = tecnicoAsignado;
        this.tarifaUbicacion = tarifaUbicacion;
    }

}
