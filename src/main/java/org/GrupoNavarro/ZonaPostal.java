package org.GrupoNavarro;
import java.util.ArrayList;
import java.util.Scanner;

public class ZonaPostal {
    private double tarifaZona;
    private String codigoPostal;
    private String nombreDistrito;
    private static ArrayList<ZonaPostal> listaZonaPostal = new ArrayList();

    public ZonaPostal(double tarifaZona, String codigoPostal, String nombreDistrito) {
        this.tarifaZona = tarifaZona;
        this.codigoPostal = codigoPostal;
        this.nombreDistrito = nombreDistrito;
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
        ZonaPostal zonapostal1 = new ZonaPostal(25,"15001","Lima");
        ZonaPostal zonapostal2 = new ZonaPostal(35,"15002", "Callao");
        listaZonaPostal.add(zonapostal1);
        listaZonaPostal.add(zonapostal2);
    }

    public static void registrarNuevaZonaPostal() {
        System.out.println("Registrar nueva Zona Postal:");

        // Solicitar datos de la nueva zona postal
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la tarifa de la Zona Postal: ");
        double tarifaZona = scanner.nextDouble();

        System.out.print("Ingrese el código postal de la Zona Postal: ");
        String codigoPostal = scanner.next();

        System.out.print("Ingrese el nombre del distrito de la Zona Postal: ");
        String nombreDistrito = scanner.next();

        // Crear y agregar la nueva zona postal a la lista
        ZonaPostal nuevaZonaPostal = new ZonaPostal(tarifaZona, codigoPostal, nombreDistrito);
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
                "Tarifa Zona:" + getTarifaZona() +", Codigo Postal:" + getCodigoPostal() +", Distrito: " + getNombreDistrito();
    }



}