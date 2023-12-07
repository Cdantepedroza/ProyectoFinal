package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PersonalTecnico extends PersonaDatos {
    private String codigoEmpleado;
    private String especialidad;
    private static ArrayList<PersonalTecnico> listaTecnicos = new ArrayList<>();

    public PersonalTecnico(String nombreCompleto, String dni, String numeroCelular, String direccion, String codigoEmpleado, String especialidad) {
        super(nombreCompleto, dni, numeroCelular, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = especialidad;
        listaTecnicos.add(this); // Agregar el técnico a la lista automáticamente al ser creado
    }
    public PersonalTecnico() {

    }
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }
    public String getEspecialidadTecnico() {
        return getEspecialidad();
    }

    public static ArrayList<PersonalTecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public static void agregarTecnico(PersonalTecnico tecnico) {
        listaTecnicos.add(tecnico);
    }
    public String getNombreCompletoTecnico(){
        return getnombreCompleto();
    }
    public String getNumeroCelularTecnico(){
        return getnumCelular();
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = String.valueOf(especialidad);
    }
    @Override
    public String toString() {
        return
                "nombreCompleto: " + getNombreCompletoTecnico() +
                ", dni: " + getDni() +
                ", numeroCelular: " + getNumeroCelularTecnico()  +
                ", direccion: " + getDireccion() +
                ", codigoEmpleado: " + codigoEmpleado +
                ", especialidad: " + especialidad ;
    }
    private static List<PersonalTecnico> tecnicos = new ArrayList<>();
    private static Especialidad Electricidad = new Especialidad("ELE", "Electricidad");
    private static Especialidad Seguridad = new Especialidad("SEG", "Seguridad");
    private static Especialidad Telecomunicaciones = new Especialidad("TEL", "Telecomunicaciones");

    public static void registrarTecnico(PersonalTecnico tecnico) {
        listaTecnicos .add(tecnico);
    }
    public static void cargaInicialTecnicos(){
        PersonalTecnico tecnico1 = new PersonalTecnico("Juan Pérez", "12345678A", "912345678", "Calle Mayor, 123", "1234", "Instalación de cámaras");
        PersonalTecnico tecnico2 = new PersonalTecnico("Pepe La plata", "12345678A", "912345678", "Calle Mayor, 123", "1234", "Cercos eléctricos");
        PersonalTecnico tecnico3 = new PersonalTecnico("Claudia Pérez", "12345678A", "912345678", "Calle Mayor, 123", "1234", "Alarmas de seguridad");
        PersonalTecnico tecnico4 = new PersonalTecnico("Eduardo Martínez", "87654321B", "987654321", "Calle Principal, 456", "5678", "Intercomunicadores");
        PersonalTecnico tecnico5 = new PersonalTecnico("María Sánchez", "87654321B", "987654321", "Calle Principal, 456", "5678", "Alarmas contra incendio");
        PersonalTecnico tecnico6 = new PersonalTecnico("Luis Rodríguez", "87654321B", "987654321", "Calle Principal, 456", "5678", "Control de acceso");
        PersonalTecnico tecnico7 = new PersonalTecnico("Ana Gómez", "98765432C", "876543210", "Avenida Central, 789", "9876", "Instalación eléctrica");
        PersonalTecnico tecnico8 = new PersonalTecnico("Carlos Pérez", "98765432C", "876543210", "Avenida Central, 789", "9876", "Instalación de cámaras");
        PersonalTecnico tecnico9 = new PersonalTecnico("Laura Martínez", "98765432C", "876543210", "Avenida Central, 789", "9876", "Cercos eléctricos");
        PersonalTecnico tecnico10 = new PersonalTecnico("Roberto Sánchez", "65432109D", "654987321", "Calle Secundaria, 567", "3456", "Alarmas de seguridad");

        PersonalTecnico.registrarTecnico(tecnico1);
        PersonalTecnico.registrarTecnico(tecnico2);
        PersonalTecnico.registrarTecnico(tecnico3);
        PersonalTecnico.registrarTecnico(tecnico4);
        PersonalTecnico.registrarTecnico(tecnico5);
        PersonalTecnico.registrarTecnico(tecnico6);
        PersonalTecnico.registrarTecnico(tecnico7);
        PersonalTecnico.registrarTecnico(tecnico8);
        PersonalTecnico.registrarTecnico(tecnico9);
        PersonalTecnico.registrarTecnico(tecnico10);

    }
    public static void imprimirTecnicos() {

        System.out.println("Lista de técnicos: \n");

        for (PersonalTecnico tecnico : listaTecnicos) {
            System.out.println("Nombre: " + tecnico.getnombreCompleto());
            System.out.println("DNI: " + tecnico.getDni());
            System.out.println("Número de teléfono: " + tecnico.getnumCelular());
            System.out.println("Dirección: " + tecnico.getDireccion());
            System.out.println("Código de personal técnico: " + tecnico.getCodigoEmpleado());
            System.out.println("Especialidad: " + tecnico.getEspecialidad()+" \n");
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
            PersonalTecnico tecnico = new PersonalTecnico(nombreCompleto, dni, numeroCelular, direccion, codigoEmpleado, especialidad);

            // Agregar el técnico a la lista
            PersonalTecnico.registrarTecnico(tecnico);
            System.out.println("Técnico registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar el técnico: " + e.getMessage());
        }
    }


}
