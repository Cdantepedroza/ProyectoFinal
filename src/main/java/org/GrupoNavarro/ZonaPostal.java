package org.GrupoNavarro;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class ZonaPostal {
    private String ciudad;
    private double precioBase;

    private static ArrayList<ZonaPostal> listaZona;

    public static ArrayList<ZonaPostal> getListaZona() {
        return listaZona;
    }

    public static void setListaZona(ArrayList<ZonaPostal> listaZona) {
        ZonaPostal.listaZona = listaZona;
    }

    public ZonaPostal(String ciudad, double precioBase) {
        this.ciudad = ciudad;
        this.precioBase = precioBase;
        listaZona = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double calcularPrecioFinal(String distritoElegido) {
        double precioFinal = precioBase;

        // Comparar directamente la ciudad y ajustar el precio final
        if (ciudad.equalsIgnoreCase("Lima")) {
            if (distritoElegido.equalsIgnoreCase("chorrillos")) {
                precioFinal += 100;
            } else if (distritoElegido.equalsIgnoreCase("comas")) {
                precioFinal += 150;
            } else if (distritoElegido.equalsIgnoreCase("lima")) {
                precioFinal += 120;
            } else if (distritoElegido.equalsIgnoreCase("manzanales")) {
                precioFinal += 50;
            } else if (distritoElegido.equalsIgnoreCase("la victoria")) {
                precioFinal += 30;
            } else if (distritoElegido.equalsIgnoreCase("magdalena")) {
                precioFinal += 70;
            } else {
                System.out.println("El distrito elegido no está en la lista. Se utilizará el precio base.");
            }
        } else {
            System.out.println("La ciudad elegida no está en la lista. No se puede calcular el precio.");
        }

        return precioFinal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una instancia del servicio para Lima con un precio base de 400
        ZonaPostal servicioLima = new ZonaPostal("Lima", 400);

        // Mostrar menú de distritos
        System.out.println("Menú de Distritos:");
        System.out.println("1. Chorrillos");
        System.out.println("2. Comas");
        System.out.println("3. Lima");
        System.out.println("4. Manzanales");
        System.out.println("5. La Victoria");
        System.out.println("6. Magdalena");

        // Solicitar la elección del usuario
        System.out.print("Ingrese el número del distrito deseado: ");
        int opcion = scanner.nextInt();

        // Obtener el nombre del distrito según la opción del usuario
        String distritoElegido;
        switch (opcion) {
            case 1:
                distritoElegido = "chorrillos";
                break;
            case 2:
                distritoElegido = "comas";
                break;
            case 3:
                distritoElegido = "lima";
                break;
            case 4:
                distritoElegido = "manzanales";
                break;
            case 5:
                distritoElegido = "la victoria";
                break;
            case 6:
                distritoElegido = "magdalena";
                break;
            default:
                System.out.println("Opción no válida. Se utilizará el distrito por defecto (lima).");
                distritoElegido = "lima";
        }

        // Ejemplo de cálculo del precio final para el distrito seleccionado
        double precioFinal = servicioLima.calcularPrecioFinal(distritoElegido);

        // Mostrar el resultado
        System.out.println("Precio final para el distrito " + distritoElegido + ": " + precioFinal);


    }

    public static void imprimirZona(){
        System.out.println("Lista de Zonas: \n");
        int contador = 1;
        for (ZonaPostal zona : listaZona) {

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
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String nombreDistrito = "";
        // Solicitar datos de la nueva zona postal
        while (true){
            try {
                System.out.print("Ingrese el nombre del distrito de la Zona Postal: ");
                nombreDistrito = scanner.nextLine();
                //verficacion de que los datos "nombre distrito" son de tipo letra
                if (nombreDistrito.matches("[^[a-zA-Z\\\\s]+$]+")){
                    throw new IllegalArgumentException("El nombre del distrito debe contener solo letras");
                } break;
            } catch (IllegalArgumentException e){
                System.out.println("Error:"+ e.getMessage());
            }
        }


        String codigoPostal;
        while (true) {
            try {
                System.out.print("Ingrese el código postal de la Zona Postal: ");
                codigoPostal = scanner.next();
                Integer.parseInt(codigoPostal);
                if (codigoPostal.length()<=5){
                    break;
                } else {
                    System.out.println("error: el codigo postal debe contener como maximo 5 digitos, intentelo nuevamente");
                }

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
