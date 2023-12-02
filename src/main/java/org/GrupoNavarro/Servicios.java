package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Servicios  {
    private String nombre;
    private double tarifaServico;

    public static ArrayList<Servicios> listaServicios = new ArrayList<>();

    public Servicios(String nombre, double tarifaServico) {
        this.nombre = nombre;
        this.tarifaServico = tarifaServico;
    }
    public Servicios() {

    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifaServico() {
        return tarifaServico;
    }

    public static void agregarServicio(Servicios servicio) {
        listaServicios.add(servicio);
    }

    public static ArrayList<Servicios> getListaServicios() {
        return listaServicios;
    }
    public void cargaInicialServicios(){
        Servicios servicio1 = new Servicios("Instalacioón de camaras", 400);
        Servicios servicio2 = new Servicios("Cercos electricos", 300);
        Servicios servicio3 = new Servicios("Alarmas de seguridad", 500);
        Servicios servicio4 = new Servicios("Intercomunicadores", 800);
        Servicios servicio5 = new Servicios("Alarmas contra incendio", 700);
        Servicios servicio6 = new Servicios("Control de acceso", 280);
        Servicios servicio7 = new Servicios("Instalacion electrica", 700);
        Servicios.agregarServicio(servicio1);
        Servicios.agregarServicio(servicio2);
        Servicios.agregarServicio(servicio3);
        Servicios.agregarServicio(servicio4);
        Servicios.agregarServicio(servicio5);
        Servicios.agregarServicio(servicio6);
        Servicios.agregarServicio(servicio7);
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tarifa: " + tarifaServico;
    }
    public static void imprimirServicios() {
        System.out.println("\nLista de Servicios:");
        int contador = 1;

        for (Servicios servicio : listaServicios) {
            System.out.println(contador + ". " + servicio);
            contador++;
        }
    }
    public static void registrarNuevoServicio(){
        System.out.println("Agregar servicio:");

        // Solicitar nombre del servicio
        System.out.print("Ingrese el nombre del servicio: ");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);;
        String nombreServicio = scanner.nextLine();

        // Solicitar tarifa del servicio
        double tarifaServicio = 0.0;
        boolean entradaValida = false;

        // Validar que la entrada sea un double
        while (!entradaValida) {
            try {
                System.out.print("Ingrese la tarifa del servicio: ");
                tarifaServicio = scanner.nextDouble();
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico para la tarifa.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        try {
            // Crear y agregar el servicio a la lista
            Servicios nuevoServicio = new Servicios(nombreServicio, tarifaServicio);
            Servicios.agregarServicio(nuevoServicio);
            System.out.println("Servicio agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el servicio: " + e.getMessage());
        }
    }

}
