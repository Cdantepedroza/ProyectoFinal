package org.GrupoNavarro;

public class PersonalTecnico extends PersonaDatos {
    private String codigoEmpleado;
    private String especialidad;


    public PersonalTecnico(String nombreCompleto, String dni, String numero_celular, String direccion, String codigoEmpleado, String especialidad) {
        super(nombreCompleto, dni, numero_celular, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = especialidad;
    }
}
