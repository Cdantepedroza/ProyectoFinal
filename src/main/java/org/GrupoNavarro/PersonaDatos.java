package org.GrupoNavarro;

public abstract class  PersonaDatos  {
    private String nombreCompleto;
    private String dni;
    private String numeroCelular;
    private String direccion;

    public PersonaDatos(String nombreCompleto, String dni, String numeroCelular, String direccion) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.numeroCelular = numeroCelular;
        this.direccion = direccion;
    }

    public PersonaDatos() {

    }

    public String getnombreCompleto() {
        return nombreCompleto;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombreCompleto = nombre_completo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getnumCelular() {
        return numeroCelular;
    }

    public void setnumCelular(String numero_celular) {
        this.numeroCelular = numero_celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
