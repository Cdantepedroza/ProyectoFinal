package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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

    public static void registrarTecnico(PersonalTecnico tecnico) {
        tecnicos .add(tecnico);
    }

    public static void SolicitarDatosTecnico() {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Solicitar nombre completo del técnico
        System.out.print("Ingrese el nombre completo del técnico: ");
        String nombreCompleto = scanner.nextLine();
        //Validaciones
        if (nombreCompleto.isEmpty()) {
            System.out.println("El nombre completo no puede estar vacío.");
            return;
        }
        // Solicitar DNI del técnico
        System.out.print("Ingrese el DNI del técnico: ");
        String dni = scanner.nextLine();
        //Validaciones
        if (!dni.matches("[0-9]{8}")) {
            System.out.println("El DNI debe tener 8 dígitos");
            return;
        }
        // Solicitar número de teléfono del técnico
        System.out.print("Ingrese el número de teléfono del técnico: ");
        String numeroCelular = scanner.nextLine();

        // Solicitar dirección del técnico
        System.out.print("Ingrese la dirección del técnico: ");
        String direccion = scanner.nextLine();

        // Solicitar código de empleado del técnico
        System.out.print("Ingrese el código de empleado del técnico: ");
        String codigoEmpleado = scanner.nextLine();

        // Solicitar especialidad del técnico
        System.out.print("Ingrese la especialidad del técnico: ");
        String especialidad = scanner.nextLine();

        try {
            // Crear el técnico
            PersonalTecnico tecnico = new PersonalTecnico(nombreCompleto, dni, numeroCelular, direccion, codigoEmpleado, especialidad);

            // Agregar el técnico a la lista
            PersonalTecnico.registrarTecnico(tecnico);
            System.out.println("Técnico registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar el técnico: " + e.getMessage());
        }
    }


}
