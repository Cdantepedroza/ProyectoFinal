package org.GrupoNavarro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Servicios  {
    private String nombre;
    private double tarifaServicio;
    public static ArrayList<Servicios> listaServicios = new ArrayList<>();

    public Servicios(String nombre, double tarifaServicio) {
        this.nombre = nombre;
        this.tarifaServicio = tarifaServicio;
    }
    public Servicios() {

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getTarifaServicio() {
        return tarifaServicio;
    }

    public void setTarifaServicio(double tarifaServicio) {
        this.tarifaServicio = tarifaServicio;
    }

    public static void setListaServicios(ArrayList<Servicios> listaServicios) {
        Servicios.listaServicios = listaServicios;
    }


    public static void agregarServicio(Servicios servicio) {
        listaServicios.add(servicio);
    }

    public  static void modificarServicio(String nombre, double nuevatarifaServicio, ArrayList<Servicios> listaServicios) {
        String nombreTmp;
        double tarif;
        boolean encontrado;
        nombreTmp = " ";
        tarif = 0;
        encontrado = false;

        for (Servicios servicio : listaServicios){
            nombreTmp = servicio.getNombre();

            if (nombreTmp.equals(nombre)){

                servicio.setTarifaServicio(nuevatarifaServicio);
                Servicios.setListaServicios(listaServicios);
                encontrado = true;
                System.out.println("Servicio modificado correctamente.");
            }
        }
        if (encontrado == false){
            System.out.println("\nServicio no encontrado: " + nombre);
        }
    }
    public static ArrayList<Servicios> getListaServicios() {
        return listaServicios;
    }

    public static void cargaInicialServicios(){
        Servicios servicio1 = new Servicios("Instalación de camaras", 400);
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
        return "Nombre: " + nombre + ", Tarifa: " + tarifaServicio;
    }
    public static void imprimirServicios() {
        String diadehoy;
        double preciosobrecargo;
        double preciolista;
        diadehoy = calculadiahoy();
        preciosobrecargo = 0;
        preciolista = 0;


        System.out.println("\nLista de Servicios:");
        int contador = 1;

        for (Servicios servicio : listaServicios) {

            if (diadehoy.equals("Sabado") || diadehoy.equals("Domingo")){
                preciolista = servicio.getTarifaServicio();
                preciosobrecargo = preciolista * 1.10;
                servicio.setTarifaServicio(preciosobrecargo);
                Servicios.setListaServicios(listaServicios);
            }
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

    public static void modificarServicioT(){
        System.out.println("Modificar servicio:");

        // Solicitar nombre del servicio a modificar
        try {
            System.out.print("Ingrese el nombre del servicio a modificar: ");
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);;
            String nombreServicio = scanner.nextLine();

            System.out.print("Ingrese la nueva tarifa: ");
            Scanner scanner1 = new Scanner(System.in).useLocale(Locale.US);;
            double nuevatarifa = Double.parseDouble(scanner1.nextLine());

            // Modificar el servicio a la lista
            Servicios.modificarServicio(nombreServicio, nuevatarifa, listaServicios);

        } catch (Exception e) {
            System.out.println("\nError al modificar el servicio, la tarifa debe ser valor numérico: " + e.getMessage());
        }
    }

    public static String calculadiahoy(){
        String dhoy;
        // Creamos una instancia del calendario
        Calendar now = Calendar.getInstance();

        System.out.println("Fecha actual : " + (now.get(Calendar.MONTH) + 1)
                + "-"
                + now.get(Calendar.DATE)
                + "-"
                + now.get(Calendar.YEAR));

        // Array con los dias de la semana
        String[] strDays = new String[]{
                "Domingo",
                "Lunes",
                "Martes",
                "Miercoles",
                "Jueves",
                "Viernes",
                "Sabado"};

        dhoy = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];
        // El dia de la semana inicia en el 1 mientras que el array empieza en el 0
        System.out.println("Hoy es : " + strDays[now.get(Calendar.DAY_OF_WEEK) - 1]);
        return dhoy;
    }

}
