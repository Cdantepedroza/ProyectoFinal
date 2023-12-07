package org.GrupoNavarro;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setTarifaZona(double tarifaZona) {
        this.tarifaZona = tarifaZona;
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

    public static ArrayList<ZonaPostal> getListaZonaPostal() {
        return listaZonaPostal;
    }
    public static void cargaInicialZonas() {
        ZonaPostal zonapostal1 = new ZonaPostal("Lima","15001",25);
        ZonaPostal zonapostal2 = new ZonaPostal("Callao","15002",35 );
        ZonaPostal zonapostal3 = new ZonaPostal("Ate Vitarte","15026",30);
        ZonaPostal zonapostal4 = new ZonaPostal("Breña","15083",28);
        ZonaPostal zonapostal5 = new ZonaPostal("Barranco","15063",24.90);
        ZonaPostal zonapostal6 = new ZonaPostal("Carabayllo","15121",45);
        ZonaPostal zonapostal7 = new ZonaPostal("Comas","15324",37.25);
        ZonaPostal zonapostal8 = new ZonaPostal("El Agustino","15004",26);
        ZonaPostal zonapostal9 = new ZonaPostal("Independencia", "15333", 32);
        ZonaPostal zonapostal10 = new ZonaPostal("Jesus Maria", "15072",23.99);
        ZonaPostal zonapostal11 = new ZonaPostal("La molina", "15023", 36);
        ZonaPostal zonapostal12 = new ZonaPostal("La victoria","15018", 28);
        ZonaPostal zonapostal13 = new ZonaPostal("Lince","15046", 25);
        ZonaPostal zonapostal14 = new ZonaPostal("Los olivos","15304", 29.90);
        ZonaPostal zonapostal15 = new ZonaPostal("Miraflores","15074", 30.99);
        ZonaPostal zonapostal16 = new ZonaPostal("Pueblo libre","15084", 34);
        ZonaPostal zonapostal17 = new ZonaPostal("Puente Piedra","15121", 50);
        ZonaPostal zonapostal18 = new ZonaPostal("Rimac","15093", 36);
        ZonaPostal zonapostal19 = new ZonaPostal("San Borja","15021", 27);
        ZonaPostal zonapostal20 = new ZonaPostal("San Isidro","15036", 31);
        ZonaPostal zonapostal21 = new ZonaPostal("San Juan De Lurigancho","15408", 36);

        listaZonaPostal.add(zonapostal1);
        listaZonaPostal.add(zonapostal2);
        listaZonaPostal.add(zonapostal3);
        listaZonaPostal.add(zonapostal4);
        listaZonaPostal.add(zonapostal5);
        listaZonaPostal.add(zonapostal6);
        listaZonaPostal.add(zonapostal7);
        listaZonaPostal.add(zonapostal7);
        listaZonaPostal.add(zonapostal8);
        listaZonaPostal.add(zonapostal9);
        listaZonaPostal.add(zonapostal10);
        listaZonaPostal.add(zonapostal11);
        listaZonaPostal.add(zonapostal12);
        listaZonaPostal.add(zonapostal13);
        listaZonaPostal.add(zonapostal14);
        listaZonaPostal.add(zonapostal15);
        listaZonaPostal.add(zonapostal16);
        listaZonaPostal.add(zonapostal17);
        listaZonaPostal.add(zonapostal18);
        listaZonaPostal.add(zonapostal19);
        listaZonaPostal.add(zonapostal20);
        listaZonaPostal.add(zonapostal21);
    }
    public static void agregarZonaPostal(ZonaPostal zonaPostal){
        listaZonaPostal.add(zonaPostal);
    }
    public static void imprimirZonasPostales() {
        System.out.println("Lista de Zonas Postales:");
        int contador = 1;

        for (ZonaPostal zona : listaZonaPostal) {
            System.out.println(contador + ". " + zona);
            contador++;
        }
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
                    System.out.print("Ingrese nuevamente el código postal de la Zona Postal: ");
                    codigoPostal = scanner.next();
                    Integer.parseInt(codigoPostal);
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
                String entrada = scanner.next().replace(',', '.');
                tarifaZona = Double.parseDouble(entrada);
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico .");
                scanner.next();
            }
        }

        ZonaPostal nuevaZonaPostal = new ZonaPostal(nombreDistrito, codigoPostal,tarifaZona );
        ZonaPostal.agregarZonaPostal(nuevaZonaPostal);

        System.out.println("Zona Postal registrada correctamente.");
    }
    public static void modificarZonaPostal(String nombreDistrito, String nuevocodigopostal, double nuevatarifaZona, ArrayList<ZonaPostal> listaZonaPostal){
        boolean encontrado;
        encontrado = false;

        for (ZonaPostal zonapostal : listaZonaPostal){
            if (zonapostal.getNombreDistrito().equalsIgnoreCase(nombreDistrito)){
                zonapostal.setCodigoPostal(nuevocodigopostal);
                zonapostal.setTarifaZona(nuevatarifaZona);
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("\nZona postal no encontrado: " + nombreDistrito);
        }

    }
    public static void modificarZonaPostalMain() {
        System.out.println("Modificar Zona Postal:");
        try {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("Ingresa el nombre del distrito a modificar: ");
            String nombreDistrito = scanner.nextLine();

            ZonaPostal zonaPostalParaModificar = buscarZonaPostalPorNombre(nombreDistrito, listaZonaPostal);

            if (zonaPostalParaModificar != null) {
                System.out.println("Registro encontrado del distrito: \n"
                        +">>> Nombre del Distrito: " + zonaPostalParaModificar.getNombreDistrito()
                        +", Código Postal: " + zonaPostalParaModificar.getCodigoPostal()
                        +", Tarifa de la Zona Postal: " + zonaPostalParaModificar.getTarifaZona());
                String nuevoCodigoPostal;
                while (true) {
                    System.out.println("Ingresa nuevo código postal: ");
                    nuevoCodigoPostal = scanner.next();
                    if (Pattern.matches("\\d{1,5}", nuevoCodigoPostal)) {
                        break;
                    } else {
                        System.out.println("Error: El código postal debe contener como máximo 5 dígitos. Inténtelo nuevamente.");
                    }
                }
                double nuevaTarifaZona;
                while (true) {
                    System.out.println("Ingresa la nueva tarifa de la zona postal: ");
                    String inputTarifa = scanner.next().replace(',', '.');
                    try {
                        nuevaTarifaZona = Double.parseDouble(inputTarifa);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingresa un valor numérico para la tarifa. Inténtelo nuevamente.");
                    }
                }
                modificarZonaPostal(nombreDistrito, nuevoCodigoPostal, nuevaTarifaZona, listaZonaPostal);
                System.out.println("** Zona postal modificada correctamente. **");
            } else {
                System.out.println("Distrito no encontrado en la lista.");
            }
        } catch (Exception e) {
            System.out.println("\nError al modificar la zona postal: " + e.getMessage());
        }
    }
    private static ZonaPostal buscarZonaPostalPorNombre(String nombreDistrito, ArrayList<ZonaPostal> listaZonaPostal) {
        for (ZonaPostal zonaPostal : listaZonaPostal) {
            if (zonaPostal.getNombreDistrito().equalsIgnoreCase(nombreDistrito)) {
                return zonaPostal;
            }
        }
        return null;
    }
    public static void eliminarZonaPostal() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Ingrese el nombre del distrito a eliminar: ");
        String nombreDistrito = scanner.nextLine();

        ZonaPostal zonaPostalAEliminar = buscarZonaPostalPorNombre(nombreDistrito, listaZonaPostal);

        if (zonaPostalAEliminar != null) {
            System.out.println("*>Detalles de la Zona Postal:");
            System.out.println("  >Nombre del Distrito: " + zonaPostalAEliminar.getNombreDistrito()
                    + ", Código Postal: " + zonaPostalAEliminar.getCodigoPostal()
                    + ", Tarifa de la Zona Postal: " + zonaPostalAEliminar.getTarifaZona());

            System.out.print("¿Estás seguro de eliminar esta Zona Postal? (S/N): ");
            String respuesta = scanner.nextLine().toUpperCase();

            if (respuesta.equals("S")) {
                listaZonaPostal.remove(zonaPostalAEliminar);
                System.out.println("Zona postal eliminada correctamente.");

            } else {
                System.out.println("Operación cancelada. La Zona Postal no ha sido eliminada.");
            }
            return;
        } else {
            System.out.println("Zona postal no encontrada en la lista.");
        }
    }

    @Override
    public String toString() {
        return
                "Distrito: " + getNombreDistrito()+", Codigo Postal:" + getCodigoPostal() +  ", Tarifa Zona:" + getTarifaZona();
    }
}