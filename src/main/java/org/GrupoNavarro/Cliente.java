package org.GrupoNavarro;

public class Cliente extends PersonaDatos {
    private String codigoCliente;
    private String codigoZona;
    private String nombreZona;

    public Cliente(String nombreCompleto, String dni, String numeroCelular, String direccion, String codigoCliente, String codigoZona, String nombreZona) {
        super(nombreCompleto, dni, numeroCelular, direccion);
        this.codigoCliente = codigoCliente;
        this.codigoZona = codigoZona;
        this.nombreZona = nombreZona;
    }

}
