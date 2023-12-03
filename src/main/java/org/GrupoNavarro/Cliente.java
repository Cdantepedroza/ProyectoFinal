package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;


public final class  Cliente extends PersonaDatos {
    private String codigoCliente;
    private String codigoPostal;

    private static final Cliente objCliente = new Cliente();

    // Lista de clientes
    private static List<Cliente> listaClientes = new ArrayList<>();
    public Cliente() {

    }
    public Cliente(String nombreCompleto, String dni, String numeroCelular, String direccion, String codigoCliente, String codigoPostal ) {
        super(nombreCompleto, dni, numeroCelular, direccion);
        this.codigoCliente = codigoCliente;
        this.codigoPostal = codigoPostal;

    }
    public static void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }


    @Override
    public String toString() {
        return "Nombre: " + getnombreCompleto() +
                ", DNI: " + getDni() +
                ", Celular: " + getnumCelular() +
                ", Dirección: " + getDireccion() +
                ", Código Cliente: " + getCodigoCliente() +
                ", Código Postal: " + getCodigoPostal();
    }
}