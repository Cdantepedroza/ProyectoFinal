package org.GrupoNavarro;

public class Cliente extends PersonaDatos {
    private String codigoCliente;
    private String codigoPostal;

    public Cliente(String nombre_completo, String dni, String numero_celular, String direccion, String codigoCliente, String codigoPostal) {
        super(nombre_completo, dni, numero_celular, direccion);
        this.codigoCliente = codigoCliente;
        this.codigoPostal = codigoPostal;
    }
}
