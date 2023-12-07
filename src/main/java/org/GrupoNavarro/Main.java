package org.GrupoNavarro;

import java.util.*;
public class Main {
    //P1
    public static void main(String[] args) {

        GrupoNavarro empresa = new GrupoNavarro("Grupo Navarro");

        // LOGIN USER ADMIN ************************
        UsuarioAdm usuario = UsuarioAdm.getInstance(); //User: admin Pass: Passw0rd
        usuario.loginVerificationUser();  //Es codigoUser y Password
        // LOGIN USER ADMIN ************************

        //Carga Inicial Tecnicos
        PersonalTecnico.cargaInicialTecnicos();
        // Carga de servicios base
        Servicios.cargaInicialServicios();
        // Carga Inicial de clientes
        Cliente.CargarClientes();
        // lista base de zonas postales
        ZonaPostal.cargaInicialZonas();
        Solicitud.CargaInicialSolicitudes();

        Scanner scanner = new Scanner(System.in);

        boolean ejecutarUnaVez = true;

        while (true) {
            if (ejecutarUnaVez) {
                System.out.println("\n╔═══════════════════════════════╗");
                System.out.println("║         GRUPO NAVARRO         ║");
                System.out.println("╚═══════════════════════════════╝");
                System.out.println("            Bienvenido            ");
                ejecutarUnaVez = false;
            }
            System.out.println("Menú Principal de Opciones:");
            System.out.println("1. Técnicos");
            System.out.println("2. Pedidos");
            System.out.println("3. Clientes");
            System.out.println("4. Zona Postal");
            System.out.println("5. Servicios");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuTecnicos(scanner);
                    break;
                case 2:
                    menuPedidos(scanner);
                    break;
                case 3:
                    menuClientes(scanner);
                    break;
                case 4:
                    menuZonaPostal(scanner);
                    break;
                case 5:
                    menuServicios(scanner);
                    break;
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
            System.out.println("3. Actualizar registro de Técnico");
            System.out.println("4. Eliminar  Técnico");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionTecnicos = scanner.nextInt();

            switch (opcionTecnicos){
                case 1:
                    PersonalTecnico.registrarNuevoTecnico();
                    break;
                case 2:
                    PersonalTecnico.imprimirTecnicos();
                    break;
                case 3:
                    PersonalTecnico.actualizarTecnico();
                    break;
                case 4:
                    PersonalTecnico.eliminarTecnico();
                    break;
                case 0:
                    // volver al menu principal
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
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
            System.out.println("3. Actualizar Pedidos");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionPedidos = scanner.nextInt();
            switch (opcionPedidos){
                case 1:
                    Solicitud.registroNuevaSolicitud();
                    break;
                case 2:
                    System.out.println("\n");
                    Solicitud.imprimirListaSolicitudes();
                    break;
                case 3:
                    Solicitud.actualizarSolicitud();
                    break;
                case 0:
                    // volver al menu principal
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }while (true);
    }
    private static void menuClientes(Scanner scanner){
        do {
            System.out.println("\nMenú Clientes:");
            System.out.println("1. Registrar nuevo Cliente");
            System.out.println("2. Lista de Clientes");
            System.out.println("3. Actualizar de Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionClientes = scanner.nextInt();
            switch (opcionClientes){
                case 1:
                    GrupoNavarro.registrarNuevoCliente();
                    break;
                case 2:
                    GrupoNavarro.imprimirClientes();
                    break;
                case 3:
                    GrupoNavarro.actualizarCliente();
                    break;
                case 4:
                    GrupoNavarro.eliminarCliente();
                    break;
                case 0:
                    // volver al menu principal
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }while (true);
    }
    private static void menuZonaPostal(Scanner scanner){
        do {
            System.out.println("\nMenú Zona Postal:");
            System.out.println("1. Lista de Zona Postal");
            System.out.println("2. Agregar Zona Postal");
            System.out.println("3. Modificar Zona postal");
            System.out.println("4. Eliminar Zona postal");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionTarifas = scanner.nextInt();
            switch (opcionTarifas){
                case 1:
                    ZonaPostal.imprimirZonasPostales();
                    break;
                case 2:
                    ZonaPostal.registrarNuevaZonaPostal();
                    break;
                case 3:
                    ZonaPostal.modificarZonaPostalMain();
                    break;
                case 4:
                    ZonaPostal.eliminarZonaPostal();
                    break;
                case 0:
                    // volver al menu principal
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }while (true);
    }
    private static void menuServicios(Scanner scanner){

        do {
            System.out.println("\nMenú Servicos:");
            System.out.println("1. Registrar nuevo servicio");
            System.out.println("2. Modificar servicio");
            System.out.println("3. Lista de servicios");
            System.out.println("0. Volver al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcionServicios = scanner.nextInt();
            switch (opcionServicios){
                case 1:
                    Servicios.registrarNuevoServicio();
                    break;
                case 2:
                    Servicios.modificarServicioT();
                    break;
                case 3:
                    Servicios.imprimirServicios();
                    break;
                case 0:
                    // volver al menu principal
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }while (true);
    }

}
