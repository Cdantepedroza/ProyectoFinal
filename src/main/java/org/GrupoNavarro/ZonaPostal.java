package org.GrupoNavarro;
import java.util.ArrayList;
import java.util.Scanner;

public class ZonaPostal {
    private String nombreDistrito;
    private String codigoPostal;
    private double tarifaZona;


    private static ArrayList<ZonaPostal> listaZonaPostal = new ArrayList();

    public ZonaPostal(String nombreDistrito, String codigoPostal, double tarifaZona) {
        this.nombreDistrito = nombreDistrito;
        this.codigoPostal = codigoPostal;
        this.tarifaZona = tarifaZona;
    }
    public ZonaPostal() {

    }
    public ArrayList<ZonaPostal> getListaZonaPostal() {
        return listaZonaPostal;
    }

    public static void agregarZonaPostal(ZonaPostal zonaPostal){
        listaZonaPostal.add(zonaPostal);
    }
    public void cargaInicialZonas() {
        ZonaPostal zonapostal1 = new ZonaPostal("Lima","15001",25);
        ZonaPostal zonapostal2 = new ZonaPostal("Callao","15002",35 );
        listaZonaPostal.add(zonapostal1);
        listaZonaPostal.add(zonapostal2);
    }

    public static void registrarNuevaZonaPostal() {
        System.out.println("Registrar nueva Zona Postal:");

        // Solicitar datos de la nueva zona postal
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del distrito de la Zona Postal: ");
        String nombreDistrito = scanner.nextLine();

        String codigoPostal;
        while (true) {
            try {
                System.out.print("Ingrese el código postal de la Zona Postal: ");
                codigoPostal = scanner.next();
                Integer.parseInt(codigoPostal);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: El código postal debe ser un valor numérico. Inténtelo nuevamente.");
            }
        }

        double tarifaZona = 0.0;;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese la tarifa de la Zona Postal: ");
                tarifaZona = scanner.nextDouble();
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico .");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }

        ZonaPostal nuevaZonaPostal = new ZonaPostal(nombreDistrito, codigoPostal,tarifaZona );
        ZonaPostal.agregarZonaPostal(nuevaZonaPostal);

        System.out.println("Zona Postal registrada correctamente.");
    }

    public static void imprimirZonasPostales() {
        System.out.println("Lista de Zonas Postales:");
        int contador = 1;

        for (ZonaPostal zona : listaZonaPostal) {
            System.out.println(contador + ". " + zona);
            contador++;
        }
    }

    public double getTarifaZona() {
        return tarifaZona;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }
    @Override
    public String toString() {
        return
                 ", Distrito: " + getNombreDistrito()+", Codigo Postal:" + getCodigoPostal() +  "Tarifa Zona:" + getTarifaZona();
    }
}