package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;

public class PersonalTecnico extends PersonaDatos {
    private String codigoEmpleado;
    private String especialidad;

    public PersonalTecnico(String nombreCompleto, String dni, String numeroCelular, String direccion, String codigoEmpleado, String especialidad) {
        super(nombreCompleto, dni, numeroCelular, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = especialidad;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "PersonalTecnico{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
    private static List<PersonalTecnico> tecnicos = new ArrayList<>();

    static {
        tecnicos.add(new PersonalTecnico("Juan Silva", "12345678", "912345678", "Calle tulipan, 123", "987654321", "electricista"));
        tecnicos.add(new PersonalTecnico("Carla Sánchez", "987654321", "654321098", "Calle 2 de mayo 456", "567891234", "electricista"));
        tecnicos.add(new PersonalTecnico("María La Plata", "345678912", "789123456", "Calle la molina 789", "345678912", "electricista"));
        tecnicos.add(new PersonalTecnico("Antonio García", "567891234", "891234567", "Calle trece 891", "567891234", "electricista"));
        tecnicos.add(new PersonalTecnico("Laura Martínez", "789123456", "912345678", "Calle flores 912", "789123456", "electricista"));
    }
    public static void imprimirTecnicos() {
        System.out.println("Lista de técnicos: \n");

        for (PersonalTecnico tecnico : tecnicos) {
            System.out.println("Nombre: " + tecnico.getnombreCompleto());
            System.out.println("DNI: " + tecnico.getDni());
            System.out.println("Número de teléfono: " + tecnico.getnumCelular());
            System.out.println("Dirección: " + tecnico.getDireccion());
            System.out.println("Código de personal técnico: " + tecnico.getCodigoEmpleado());
            System.out.println("Especialidad: " + tecnico.getEspecialidad()+" \n");
        }
    }
}
