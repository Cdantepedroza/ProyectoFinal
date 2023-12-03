package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PersonalTecnico extends PersonaDatos {
    private String codigoEmpleado;
    private Especialidad especialidad;
    private static final PersonalTecnico objPersonalTecnico = new PersonalTecnico();

    public PersonalTecnico(String nombreCompleto, String dni, String numeroCelular, String direccion, String codigoEmpleado, Especialidad especialidad) {
        super(nombreCompleto, dni, numeroCelular, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = especialidad != null ? especialidad : new Especialidad("DES", "Desconocido");
    }

    public PersonalTecnico(){
        super();
    }
    public static PersonalTecnico getInstance() {
        return objPersonalTecnico;
    }
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(Especialidad especialidad) {
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
    private static Especialidad Electricidad = new Especialidad("ELE", "Electricidad");
    private static Especialidad Seguridad = new Especialidad("SEG", "Seguridad");
    private static Especialidad Telecomunicaciones = new Especialidad("TEL", "Telecomunicaciones");

    public List<PersonalTecnico> getTecnicos() {
        return tecnicos;
    }

    public static void setTecnicos(List<PersonalTecnico> tecnicos) {
        PersonalTecnico.tecnicos = tecnicos;
    }
    public static void registrarTecnico(PersonalTecnico tecnico) {
        tecnicos .add(tecnico);
    }

    public static void imprimirTecnicos() {

        PersonalTecnico tecnico1 = new PersonalTecnico("Juan Pérez", "12345678A", "912345678", "Calle Mayor, 123", "1234", Electricidad);
        PersonalTecnico tecnico2 = new PersonalTecnico("Pepe La plata", "12345678A", "912345678", "Calle Mayor, 123", "1234", Seguridad);
        PersonalTecnico tecnico3 = new PersonalTecnico("Claudia Pérez", "12345678A", "912345678", "Calle Mayor, 123", "1234", Telecomunicaciones);

        PersonalTecnico.registrarTecnico(tecnico1);
        PersonalTecnico.registrarTecnico(tecnico2);
        PersonalTecnico.registrarTecnico(tecnico3);

        System.out.println("Lista de técnicos: \n");

        for (PersonalTecnico tecnico : tecnicos) {
            System.out.println("Nombre: " + tecnico.getnombreCompleto());
            System.out.println("DNI: " + tecnico.getDni());
            System.out.println("Número de teléfono: " + tecnico.getnumCelular());
            System.out.println("Dirección: " + tecnico.getDireccion());
            System.out.println("Código de personal técnico: " + tecnico.getCodigoEmpleado());
            System.out.println("Especialidad: " + tecnico.getEspecialidad().getNombre()+" \n");
        }
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
            // Crear el objeto Especialidad
            Especialidad objEspecialidad = Especialidad.obtenerEspecialidad(especialidad);

            // Crear el objeto PersonalTecnico
            PersonalTecnico tecnico = new PersonalTecnico(nombreCompleto, dni, numeroCelular, direccion, codigoEmpleado, objEspecialidad);

            // Agregar el técnico a la lista
            PersonalTecnico.registrarTecnico(tecnico);
            System.out.println("Técnico registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar el técnico: " + e.getMessage());
        }
    }


}
