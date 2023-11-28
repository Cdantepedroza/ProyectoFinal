package org.modelo;

public class PersonaDatos {
    private String nombre_completo;
    private String dni;
    private int numero_celular;
    private String direccion;

    public PersonaDatos(String nombre_completo, String dni, int numero_celular, String direccion) {
        this.nombre_completo = nombre_completo;
        this.dni = dni;
        this.numero_celular = numero_celular;
        this.direccion = direccion;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(int numero_celular) {
        this.numero_celular = numero_celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
