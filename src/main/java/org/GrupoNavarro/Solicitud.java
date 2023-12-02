package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Solicitud extends Servicios{

    private String codigoSolicitud;
    private String fechaAtencion;
    private String fechaEmision;
    private String comentarios;
    private String estado;


    //Llamo a Zona (para sacar tarifa)
    private ZonaPostal zona;
    //Llamo a técnico
    private PersonalTecnico personalTecnico;
    //Listo las solicitudes
    private static ArrayList<Solicitud> listaSolicitudes;
    private final ArrayList<ZonaPostal> listaZonas = new ArrayList<ZonaPostal>();
    private ArrayList<PersonalTecnico> listaPersonal = new ArrayList<PersonalTecnico>();

    public Solicitud(String nombre, double tarifaServico, String codigoSolicitud, String fechaAtención, String fechaEmisión, String comentarios, ZonaPostal zona) {
        super(nombre, tarifaServico);

    private ZonaPostal zona;
    private PersonalTecnico personalTecnico;


    private static ArrayList<Solicitud> listaSolicitudes;


    private static final ArrayList<ZonaPostal> listaZonas = new ArrayList<ZonaPostal>();
    private static final ArrayList<PersonalTecnico> listaPersonal = new ArrayList<PersonalTecnico>();



    public Solicitud(String nombre, double tarifaServicio, String codigoSolicitud, String fechaAtencion, String fechaEmision, String comentarios, ZonaPostal zona, PersonalTecnico personalTecnico) {
        super(nombre, tarifaServicio);
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtencion = fechaAtencion;
        this.fechaEmision = fechaEmision;
        this.comentarios = comentarios;
        this.estado = "EN GESTION";
        this.zona = zona;
        listaSolicitudes = new ArrayList<>();
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(String fechaAtención) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmisión) {
        this.fechaEmision = fechaEmision;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public static void agregarSolicitud(Solicitud solicitud){
        listaSolicitudes.add(solicitud);
    }


    public double descuentoServicio(Servicios servicio){

        if (servicio.getNombre().equals("Alarmas de seguridad")){
            return 0.20;
        } else if (servicio.getNombre().equals("Cercos electricos")) {
            return 0.15;
        } else if (servicio.getNombre().equals("Intercomunicadores")) {
            return 0.10;
        } else {
            return 0;
        }
    }

    public double costoFinal(Servicios servicio, ZonaPostal zona, String distrito){
        //Falta agregar Zona
        double importeBase = servicio.getTarifaServico() + zona.calcularPrecioFinal(distrito);
        double igv = importeBase*0.18;
        return importeBase+igv-descuentoServicio(servicio);
    }

    public void imprimirSolicitudes() {
        System.out.println("\nLista de Solicitudes:");
        int contador = 1;
        for (Solicitud servicio : listaSolicitudes) {
            System.out.println(contador + ". " + servicio);
            contador++;
        }
    }

    public void imprimirZonas() {
        System.out.println("\nLista de Zonas:");
        int contador = 1;
        for (ZonaPostal zona : listaZonas) {
            System.out.println(contador + ". " + zona);
            contador++;
        }
    }

    public static void registrarNuevaSolicitud(){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);;

        System.out.println("Agregar Solicitud:");
        // Ingresar código de nueva solicitud
        System.out.print("Ingrese el código de la solicitud: ");
        String codSolicitud = scanner.nextLine();
        System.out.print("Ingrese la fecha de atención: ");
        String fechaAt = scanner.nextLine();
        System.out.print("Ingrese la fecha de Emisión: ");
        String fechaEm = scanner.nextLine();
        System.out.print("Ingrese comentarios: ");
        String comentarios = scanner.nextLine();
        System.out.print("Seleccione su Zona");
        ZonaPostal.imprimirZona();

        try {
            // Crear y agregar solicitud a la lista
            //Solicitud nuevaSolicitud = new Solicitud(nom,varr,codSolicitud,fechaAt,fechaEm,comentarios,);
            //Solicitud.agregarSolicitud(nuevaSolicitud);
            System.out.println("Solicitud agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el servicio: " + e.getMessage());
        }


    public static double descuentoServicio(Servicios servicio){

        return switch (servicio.getNombre()) {
            case "Alarmas de seguridad" -> 0.20;
            case "Cercos electricos" -> 0.15;
            case "Intercomunicadores" -> 0.10;
            default -> 0;
        };
    }

    public static double costoFinal(double tarifa, Servicios servicios){
        double igv = tarifa *0.18;
        double importeDescuento = tarifa *descuentoServicio(servicios);
        return tarifa +igv-importeDescuento;
    }

    public void imprimirSolicitudes() {
        System.out.println("\nLista de Solicitudes:");
        int contador = 1;
        for (Solicitud servicio : listaSolicitudes) {
            System.out.println(contador + ". " + servicio);
            contador++;
        }

    }

    public static void registrarNuevaSolicitud(){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);;

        double tarifa = 0;
        double descuento = 0;
        double delivery = 0;

        System.out.println("Agregar Solicitud:");
        // Ingresar código de nueva solicitud
        System.out.print("Ingrese el código de la solicitud: ");
        String codSolicitud = scanner.nextLine();
        System.out.print("Ingrese la fecha de atención: ");
        String fechaAt = scanner.nextLine();
        System.out.print("Ingrese la fecha de Emisión: ");
        String fechaEm = scanner.nextLine();
        System.out.print("Ingrese comentarios: ");
        String comentarios = scanner.nextLine();

        System.out.print("");
        Servicios.imprimirServicios();
        System.out.print("");
        System.out.print("Ingrese Servicio a solicitar:");
        String servicios = scanner.nextLine();
        for (Servicios serv: Servicios.listaServicios) {
            if (serv.getNombre().equals(servicios)) {
                tarifa = serv.getTarifaServicio();
                descuento = Solicitud.descuentoServicio(serv);
            }
        }
        System.out.println("Tarifa: "+tarifa+" - Descuento por solicitud de servicio: "+descuento);
        System.out.print("");
        ZonaPostal.imprimirZonasPostales();
        System.out.print("");
        System.out.print("Ingrese código de Zona delivery:");
        String codigo = scanner.nextLine();

        for (ZonaPostal distrito: listaZonas) {
            if (distrito.getCodigoPostal().equals(codigo)) {
                delivery = distrito.getTarifaZona();
            }
        }

        System.out.println("Costo por delivery: "+delivery);





        try {
            // Crear y agregar solicitud a la lista
            //Solicitud nuevaSolicitud = new Solicitud(nom,varr,codSolicitud,fechaAt,fechaEm,comentarios,);
            //Solicitud.agregarSolicitud(nuevaSolicitud);
            System.out.println("Solicitud agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el servicio: " + e.getMessage());
        }

    }



}
