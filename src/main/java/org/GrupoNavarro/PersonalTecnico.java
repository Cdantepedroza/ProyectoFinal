package org.GrupoNavarro;

import java.time.LocalDate;
import java.util.*;

public class PersonalTecnico extends PersonaDatos {
    private String codigoEmpleado;
    private String especialidad;
    private static ArrayList<PersonalTecnico> listaTecnicos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public PersonalTecnico(String nombreCompleto, String dni, String numeroCelular, String direccion, String codigoEmpleado, String especialidad) {
        super(nombreCompleto, dni, numeroCelular, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = especialidad;
    }
    public PersonalTecnico() {

    }
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }
    public String getEspecialidadTecnico() {
        return getEspecialidad();
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public static ArrayList<PersonalTecnico> getListaTecnicos() {
        return listaTecnicos;
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
    public static void agregarTecnico(PersonalTecnico tecnico) {
        listaTecnicos .add(tecnico);
    }
    public static void cargaInicialTecnicos(){
        PersonalTecnico tecnico1 = new PersonalTecnico("Juan Pérez", "87420519", "912345678", "Calle Mayor, 123", "CT-8742", "Instalación de cámaras");
        PersonalTecnico tecnico2 = new PersonalTecnico("Pepe La plata", "35671892", "912345678", "Calle Mayor, 123", "CT-3567", "Cercos eléctricos");
        PersonalTecnico tecnico3 = new PersonalTecnico("Claudia Pérez", "49203687", "912345678", "Calle Mayor, 123", "CT-4920", "Alarmas de seguridad");
        PersonalTecnico tecnico4 = new PersonalTecnico("Eduardo Martínez", "63159728", "987654321", "Calle Principal, 456", "CT-6315", "Intercomunicadores");
        PersonalTecnico tecnico5 = new PersonalTecnico("María Sánchez", "82041365", "987654321", "Calle Principal, 456", "CT-8204", "Alarmas contra incendio");
        PersonalTecnico tecnico6 = new PersonalTecnico("Luis Rodríguez", "94568723", "987654321", "Calle Principal, 456", "CT-9456", "Control de acceso");
        PersonalTecnico tecnico7 = new PersonalTecnico("Ana Gómez", "10728456", "876543210", "Avenida Central, 789", "CT-1072", "Instalación eléctrica");
        PersonalTecnico tecnico8 = new PersonalTecnico("Carlos Pérez", "58392017", "876543210", "Avenida Central, 789", "CT-5839", "Instalación de cámaras");
        PersonalTecnico tecnico9 = new PersonalTecnico("Laura Martínez", "89012345", "876543210", "Avenida Central, 789", "CT-8901", "Cercos eléctricos");
        PersonalTecnico tecnico10 = new PersonalTecnico("Roberto Sánchez", "76543210", "654987321", "Calle Secundaria, 567", "CT-7654", "Alarmas de seguridad");

        PersonalTecnico.agregarTecnico(tecnico1);
        PersonalTecnico.agregarTecnico(tecnico2);
        PersonalTecnico.agregarTecnico(tecnico3);
        PersonalTecnico.agregarTecnico(tecnico4);
        PersonalTecnico.agregarTecnico(tecnico5);
        PersonalTecnico.agregarTecnico(tecnico6);
        PersonalTecnico.agregarTecnico(tecnico7);
        PersonalTecnico.agregarTecnico(tecnico8);
        PersonalTecnico.agregarTecnico(tecnico9);
        PersonalTecnico.agregarTecnico(tecnico10);

    }
    public static void imprimirTecnicos() {
        System.out.println("Lista de técnicos:");
        int contador = 1;
        for (PersonalTecnico tecnico : listaTecnicos) {
            System.out.println("Técnico #" + contador + ":");
            System.out.println(tecnico.toString());
            contador++;
        }
    }
    public static void registrarNuevoTecnico() {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

            System.out.print("Ingrese el nombre completo del técnico: ");
            String nombreCompleto = scanner.nextLine();

            if (nombreCompleto.isEmpty()) {
                System.out.println("El nombre completo no puede estar vacío.");
                return;
            }
            System.out.print("Ingrese el DNI del técnico: ");
            String dni = scanner.nextLine();

            if (!dni.matches("[0-9]{8}")) {
                System.out.println("El DNI debe tener 8 dígitos");
                return;
            }
            System.out.print("Ingrese el número de teléfono del técnico: ");
            String numeroCelular = scanner.nextLine();

            System.out.print("Ingrese la dirección del técnico: ");
            String direccion = scanner.nextLine();
            String codigoEmpleado = "CT-" + dni.substring(0, 4);

            System.out.print("Ingrese la especialidad del técnico: ");
            String especialidad = String.valueOf(elegirEspecialidad());

            try {

                PersonalTecnico tecnico = new PersonalTecnico(nombreCompleto, dni, numeroCelular, direccion, codigoEmpleado, especialidad);

                PersonalTecnico.agregarTecnico(tecnico);
                System.out.println("Técnico registrado correctamente.");

            } catch (Exception e) {
                System.out.println("Error al registrar el técnico: " + e.getMessage());
            }
    }
    public static void actualizarTecnico() {
        imprimirTecnicoNombreDni();

        System.out.print("\nIngrese el DNI del Técnico que desea actualizar:");
        String dniTecnicoActualizar = scanner.nextLine();

        PersonalTecnico tecnicoActualizar = buscarTencicoPorDNI(dniTecnicoActualizar);

        if (tecnicoActualizar != null) {
            System.out.println("Actualizando Técnico: "+ tecnicoActualizar.getnombreCompleto() +" - DNI: "+ dniTecnicoActualizar);

            String nuevonombreTecnico = "";
            while (true) {
                try {
                    System.out.print("Ingrese el nuevo nombre del Técnico: ");
                    nuevonombreTecnico = scanner.nextLine();
                    if (!nuevonombreTecnico.matches("^[a-zA-Z\\s]+$")) {
                        throw new IllegalArgumentException("El nombre debe contener solo letras y espacios.");
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String nuevoDniTecnico = "";
            while (true) {
                try {
                    System.out.print("Ingrese el nuevo DNI del Técnico: ");
                    nuevoDniTecnico = scanner.nextLine();
                    if (!nuevoDniTecnico.matches("\\d+")) {
                        throw new InputMismatchException("El DNI debe contener solo números.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            String nuevoCelularTecnico = "";
            while (true) {
                try {
                    System.out.print("Ingrese el número de celular actualizado del Técnico: ");
                    nuevoCelularTecnico = scanner.nextLine();
                    if (!nuevoCelularTecnico.matches("\\d{1,9}")) {
                        throw new InputMismatchException("El número de celular debe contener solo números y tener como máximo 9 dígitos.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.print("Ingrese la dirección actualizada del Técnico: ");
            String nuevaDireccionTecnico = scanner.nextLine();
            String nuevoCodigoEmpleado = "CT-" + nuevoDniTecnico.substring(0, 4);

            String nuevaEspecialidad = String.valueOf(elegirEspecialidad());

            tecnicoActualizar.setNombreCompleto(nuevonombreTecnico);
            tecnicoActualizar.setDni(nuevoDniTecnico);
            tecnicoActualizar.setCodigoEmpleado(nuevoCodigoEmpleado);
            tecnicoActualizar.setNumeroCelular(nuevoCelularTecnico);
            tecnicoActualizar.setDireccion(nuevaDireccionTecnico);
            tecnicoActualizar.setEspecialidad(nuevaEspecialidad);

            System.out.println("Tecnico actualizado exitosamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
        }
    }

    public static void eliminarTecnico() {
        imprimirTecnicoNombreDni();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese el DNI del Técnico que desea eliminar:");
        String dniTecnicoEliminar = scanner.nextLine();

        PersonalTecnico tecnico = buscarTencicoPorDNI(dniTecnicoEliminar);

        if (tecnico != null) {
            System.out.println("Eliminando Técnico - DNI: " + dniTecnicoEliminar);

            listaTecnicos.remove(tecnico);

            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún Técnico con el DNI proporcionado.");
        }
    }
    public static void imprimirTecnicoNombreDni() {
        System.out.println("\nLista de Tecnicos:");
        int contador = 1;

        for (PersonalTecnico tecnico : listaTecnicos) {
            System.out.println(contador + ". " + tecnico.getNombreCompletoTecnico()+", " + tecnico.getDni() );
            contador++;
        }
    }

    private static PersonalTecnico buscarTencicoPorDNI(String dniTecnico) {
        for (PersonalTecnico tecnico : listaTecnicos) {
            if (tecnico.getDni().equals(dniTecnico)) {
                System.out.println("Registro encontrado: "+ tecnico.getnombreCompleto()+", DNI: " + tecnico.getDni());
                return tecnico;
            }
        }
        return null;
    }
    private static String elegirEspecialidad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Especialidades:");
        do {
            for (int i = 0; i < Servicios.listaServicios.size(); i++) {
                Servicios servicio = Servicios.listaServicios.get(i);
                System.out.println((i + 1) + ". " + servicio.getNombre());
            }
            System.out.print("***Digite un número***\n");
            System.out.print("Seleccione un servicio:");
            int opcionElegida = scanner.nextInt();

            if (opcionElegida >= 1 && opcionElegida <= Servicios.listaServicios.size()) {
                return Servicios.listaServicios.get(opcionElegida - 1).getNombre();
            } else {
                System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (true);
    }

    public String toString2() {
        return
                "nombreCompleto: " + getNombreCompletoTecnico() +
                        ", especialidad: " + especialidad ;
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
}
