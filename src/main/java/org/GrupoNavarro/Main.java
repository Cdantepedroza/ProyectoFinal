package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //P1
    public static void main(String[] args) {

        GrupoNavarro empresa = new GrupoNavarro("Grupo Navarro");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Técnicos");
            System.out.println("2. Pedidos");
            System.out.println("3. Tarifas");
            System.out.println("4. Reporte de Empleados");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuTecnicos(scanner);
                    break;
                case 2:
                    menuPedidos(scanner);
                case 3:
                    menuTarifas(scanner);
                case 4:
                    menuReporte(scanner);
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    }
            }
        }
    private static void menuTecnicos(Scanner scanner){
        do {
            System.out.println("\nMenú Técnicos:");
            System.out.println("1. Registrar Técnico");
            System.out.println("2. Lista de Técnicos");
            System.out.println("3. Registrar Especialidad");
            System.out.println("4. Lista de Especialidades");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionTecnicos = scanner.nextInt();

            switch (opcionTecnicos){
                case 1:
                    // implementar logica aqui
                    System.out.println("Registrar tecnico ");
                    break;
                case 2:
                    // implementar logica aqui
                    System.out.println("Registrar tecnico ");
                    break;
                case 3:
                    // implementar logica aqui
                    System.out.println("Registrar tecnico ");
                    break;
                case 4:
                    // implementar logica aqui
                    System.out.println("Registrar tecnico ");
                    break;
                case 0:
                    // volver al menu principal
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }while (true);
    }

    private static void menuPedidos(Scanner scanner){
        do {
            System.out.println("\nMenú Pedidos:");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Lista de Pedidos");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionPedidos = scanner.nextInt();
            switch (opcionPedidos){
                case 1:
                    // Registrar Pedido
                    // Implementa la lógica para registrar un pedido y sus detalles
                    System.out.println("Registrar Pedido - Implementa la lógica aquí");
                    break;
                case 2:
                    // Lista de Pedidos
                    // Implementa la lógica para mostrar la lista de pedidos registrados
                    System.out.println("Lista de Pedidos - Implementa la lógica aquí");
                    break;
                case 0:
                    // volver al menu principal
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }while (true);
    }
    private static void menuTarifas(Scanner scanner){
        do {
            System.out.println("\nMenú Tarifas:");
            System.out.println("1. Lista de Tarifas");
            System.out.println("2. Agregar Tarifa");
            System.out.println("3. Modificar Tarifa");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionTarifas = scanner.nextInt();
            switch (opcionTarifas){
                case 1:
                    // Lista de Tarifas
                    // Implementa la lógica para mostrar la lista de tarifas
                    System.out.println("Lista de Tarifas - Implementa la lógica aquí");
                    break;
                case 2:
                    // Agregar Tarifa
                    // Implementa la lógica para agregar una tarifa
                    System.out.println("Agregar Tarifa - Implementa la lógica aquí");
                    break;
                case 3:
                    // Modificar Tarifa
                    // Implementa la lógica para modificar una tarifa
                    System.out.println("Modificar Tarifa - Implementa la lógica aquí");
                    break;
                case 0:
                    // volver al menu principal
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }while (true);
    }
    private static void menuReporte(Scanner scanner){
        do {
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
                    // volver al menu principal
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }while (true);
    }

}