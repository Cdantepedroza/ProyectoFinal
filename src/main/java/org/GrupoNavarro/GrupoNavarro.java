package org.GrupoNavarro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GrupoNavarro {
    private String nombre;

    private GrupoNavarro() {
    }
    private static List<Cliente> listaClientes = new ArrayList<>();


    public GrupoNavarro(String nombre) {
        this.nombre = nombre;
    }

    public static void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    public static void imprimirClientes() {
        System.out.println("\nLista de Clientes:");
        int contador = 1;

        for (Cliente cliente : listaClientes) {
            System.out.println(contador + ". " + cliente);
            contador++;
        }
    }
    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    /*
    CRITERIOS DE CREACION DE CODIGO DE CLIENTE
        CC: Iniciales que representan "Código de Cliente".
        XXXX: 4 primeros Números del DNI .
        YY: Año de registro del cliente o algún otro identificador temporal.
        Por ejemplo, si el código de cliente fuera "CC-7569-21", podrías interpretarlo como el
        "Código de Cliente 7569 registrado en el año 2021". Asegúrate de ajustar este formato.
    */
    public static void registrarNuevoCliente() {
        System.out.println("Agregar cliente:");

        Scanner scanner = new Scanner(System.in);

        String nombreCliente = "";
        while (true) {
            try {
                System.out.print("Ingrese el nombre del cliente: ");
                nombreCliente = scanner.nextLine();
                if (!nombreCliente.matches("^[a-zA-Z\\s]+$")) {
                    throw new IllegalArgumentException("El nombre debe contener solo letras y espacios.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        String dniCliente = "";
        while (true) {
            try {
                System.out.print("Ingrese el DNI del cliente: ");
                dniCliente = scanner.nextLine();
                if (!dniCliente.matches("\\d+")) {
                    throw new InputMismatchException("El DNI debe contener solo números.");
                }
                break; // Salir del bucle si la validación es exitosa
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        String celularCliente = "";
        while (true) {
            try {
                System.out.print("Ingrese el número de celular del cliente: ");
                celularCliente = scanner.nextLine();
                if (!celularCliente.matches("\\d{1,9}")) {
                    throw new InputMismatchException("El número de celular debe contener solo números y tener como máximo 9 dígitos.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.print("Ingrese la dirección del cliente: ");
        String direccionCliente = scanner.nextLine();
        // combinacion para codigo de cliente - 4 primeros digitos de dni
        String codigoCliente = "CC-" + dniCliente.substring(0, 4);
        // combinacion para codigo de cliente - año
        int year = LocalDate.now().getYear() % 100;
        codigoCliente += String.format("-%02d", year);
        String codigoPostal = "";
        while (true) {
            try {
                System.out.print("Ingrese el código Postal: ");
                codigoPostal = scanner.nextLine();
                if (!codigoPostal.matches("\\d+")) {
                    throw new InputMismatchException("El código postal debe contener solo números.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        Cliente nuevoCliente = new Cliente(nombreCliente, dniCliente, celularCliente, direccionCliente, codigoCliente, codigoPostal);
        GrupoNavarro.agregarCliente(nuevoCliente);
        System.out.println("Cliente agregado correctamente.");
    }
}
