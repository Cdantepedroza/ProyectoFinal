package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;


public final class Cliente extends PersonaDatos {
    private String codigoCliente;
    private String codigoPostal;

    public Cliente(String nombreCompleto, String dni, String numeroCelular, String direccion, String codigoCliente, String codigoPostal) {
        super(nombreCompleto, dni, numeroCelular, direccion);


        this.codigoCliente = codigoCliente;
        this.codigoPostal = codigoPostal;

    }
    public Cliente() {
    }


    public static void CargarClientes() {
        Cliente cliente1 = new Cliente("Juan García","75697852","9658324","av siempre viva", "CC-7569-23","15001");
        Cliente cliente2 = new Cliente("María Rodríguez", "81234567", "9876543", "Calle Principal", "CC-8123-24", "15026");
        Cliente cliente3 = new Cliente("Carlos Martínez", "93218765", "8765432", "Av. Central", "CCC-9321-23", "15333");
        Cliente cliente4 = new Cliente("Ana López", "66554433", "1122334", "Calle de los Sueños", "CC-6655-23", "15072");
        Cliente cliente5 = new Cliente("Luis Pérez", "88887777", "9999888", "Av. Colorida", "CC-8888-23", "15018");
        Cliente cliente6 = new Cliente("Laura Sánchez", "78569742", "5555666", "Calle Tranquila", "CC-7856-23", "45678");
        Cliente cliente7 = new Cliente("Miguel Fernández", "02358967", "3333444", "Av. Animada", "CC-0235-24", "98765");
        Cliente cliente8 = new Cliente("Sofía González", "10257936", "6666777", "Calle Principal", "CC-1025-23", "23456");
        Cliente cliente9 = new Cliente("Alejandro Ramírez", "69853674", "4444333", "Av. Serena", "CC-6985-25", "78901");
        Cliente cliente10 = new Cliente("Carmen Díaz", "23689675", "5678901", "Calle Alegre", "CC-2368-21", "12345");
        Cliente cliente11 = new Cliente("Rogelio Martínez Díaz", "75697852", "9658324", "Av. Siempre Viva", "CC-7569-26", "15102");
        GrupoNavarro.agregarCliente(cliente1);
        GrupoNavarro.agregarCliente(cliente2);
        GrupoNavarro.agregarCliente(cliente3);
        GrupoNavarro.agregarCliente(cliente4);
        GrupoNavarro.agregarCliente(cliente5);
        GrupoNavarro.agregarCliente(cliente6);
        GrupoNavarro.agregarCliente(cliente7);
        GrupoNavarro.agregarCliente(cliente8);
        GrupoNavarro.agregarCliente(cliente9);
        GrupoNavarro.agregarCliente(cliente10);
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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