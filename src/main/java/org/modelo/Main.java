package org.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //P1
    public static void main(String[] args) {
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Tecnico tecnico2 = new Tecnico("Nombre del Técnico", "Apellido del Técnico", "DNI del Técnico");
        ArrayList<Especialidad> especialidades = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<Tarifa> tarifas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Técnicos");
            System.out.println("2. Pedidos");
            System.out.println("3. Tarifas");
            System.out.println("4. Reporte de Empleados");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Submenú para Técnicos
                    while (true) {
                        System.out.println("\nMenú Técnicos:");
                        System.out.println("1. Registrar Técnico");
                        System.out.println("2. Lista de Técnicos");
                        System.out.println("3. Registrar Especialidad");
                        System.out.println("4. Lista de Especialidades");
                        System.out.println("0. Volver al Menú Principal");

                        System.out.print("Seleccione una opción: ");
                        int opcionTecnicos = scanner.nextInt();

                        switch (opcionTecnicos) {
                            case 1:
                                Tecnico tecnico = new Tecnico("Tecnico1", "apellido", "14785236");
                                System.out.println("Registrar Técnico - Implementa la lógica aquí");
                                break;

                            case 2:
                                System.out.println("Lista de Técnicos - Implementa la lógica aquí");
                                break;

                            case 3:
                                // registrar especialidad
                                Especialidad especialidad = new Especialidad("Especialidad1");
                                System.out.println("Registrar Especialidad - Implementa la lógica aquí");
                                break;

                            case 4:
                                // Lista de Especialidades
                                System.out.println("Lista de Especialidades - Implementa la lógica aquí");
                                break;

                            case 0:
                                // Volver al Menú Principal
                                break;

                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                        break;
                    }

                case 2:
                    // Submenú para Pedidos
                    while (true) {
                        System.out.println("\nMenú Pedidos:");
                        System.out.println("1. Registrar Pedido");
                        System.out.println("2. Lista de Pedidos");
                        System.out.println("0. Volver al Menú Principal");

                        System.out.print("Seleccione una opción: ");
                        int opcionPedidos = scanner.nextInt();

                        switch (opcionPedidos) {
                            case 1:
                                // Registrar Pedido
                                Pedido pedido = new Pedido("Pedido 1","instalacion camaras", tecnico2,50);
                                // Implementa la lógica para registrar un pedido y sus detalles
                                System.out.println("Registrar Pedido - Implementa la lógica aquí");
                                break;

                            case 2:
                                // Lista de Pedidos
                                // Implementa la lógica para mostrar la lista de pedidos registrados
                                System.out.println("Lista de Pedidos - Implementa la lógica aquí");
                                break;

                            case 0:
                                // Regresar Menú Principal
                                break;

                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                        break;
                    }


                case 3:
                    // Submenú para Tarifas
                    while (true) {
                        System.out.println("\nMenú Tarifas:");
                        System.out.println("1. Lista de Tarifas");
                        System.out.println("2. Agregar Tarifa");
                        System.out.println("3. Modificar Tarifa");
                        System.out.println("0. Volver al Menú Principal");

                        System.out.print("Seleccione una opción: ");
                        int opcionTarifas = scanner.nextInt();

                        switch (opcionTarifas) {
                            case 1:

                                // Lista de Tarifas
                                // Implementa la lógica para mostrar la lista de tarifas
                                System.out.println("Lista de Tarifas - Implementa la lógica aquí");
                                break;

                            case 2:
                                // Agregar Tarifa
                                Tarifa tarifa = new Tarifa("instalacion", 50);
                                // Implementa la lógica para agregar una tarifa
                                System.out.println("Agregar Tarifa - Implementa la lógica aquí");
                                break;

                            case 3:
                                // Modificar Tarifa
                                // Implementa la lógica para modificar una tarifa
                                System.out.println("Modificar Tarifa - Implementa la lógica aquí");
                                break;

                            case 0:
                                // Volver al Menú Principal
                                break;

                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                        break;
                    }


                case 4:
                    // Reporte de Empleados
                    // Implementa la lógica para mostrar el reporte de empleados (lista de empleados)

                    while(true){
                        System.out.println("\nMenú Reporte:");
                        System.out.println("1. Reporte Empleados");
                        System.out.println("2. Reporte Solicitudes");
                        System.out.println("0. Volver al Menú Principal");

                        System.out.print("Seleccione una opción: ");
                        int opcionReporte = scanner.nextInt();

                        switch (opcionReporte){
                            case 1:
                                System.out.println("Lista de Tarifas - Implementa la lógica aquí");
                                break;
                            case 2:
                                System.out.println("Lista de Tarifas - Implementa la lógica aquí");
                                break;
                            case 0:
                                // Volver al Menú Principal
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                        break;
                    }

                case 0:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}