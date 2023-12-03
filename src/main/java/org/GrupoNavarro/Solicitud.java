package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Solicitud extends Servicios{

    //JV23
    private String codigoSolicitud;
    private String fechaAtencion;
    private String fechaEmision;
    private String comentarios;
    private String estado;


    private static ArrayList<Solicitud> listaSolicitudes;

    private static ZonaPostal zona = new ZonaPostal();
    private static ArrayList<ZonaPostal> listaZona = zona.getListaZonaPostal();

    //private static PersonalTecnico tecnico = new PersonalTecnico();
    //private static ArrayList<PersonalTecnico> listaTecnicos = (ArrayList<PersonalTecnico>) tecnico.getTecnicos();

    private static Especialidad especialidad = new Especialidad();
    private static ArrayList<Especialidad> listaEspecialidades = (ArrayList<Especialidad>) especialidad.getEspecialidades();


    public Solicitud(String nombre, double tarifaServicio, String codigoSolicitud, String fechaAtencion, String fechaEmision, String comentarios, PersonalTecnico personalTecnico) {
        super(nombre, tarifaServicio);
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtencion = fechaAtencion;
        this.fechaEmision = fechaEmision;
        this.comentarios = comentarios;
        this.estado = "EN GESTION";
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

    public static double descuentoServicio(Servicios servicio){

        return switch (servicio.getNombre()) {
            case "Alarmas de seguridad" -> 0.20;
            case "Cercos electricos" -> 0.15;
            case "Intercomunicadores" -> 0.10;
            default -> 0;
        };
    }

    public static double costoFinal(double tarifa, double delivery, Servicios servicios){
        double igv = tarifa *0.18;
        double importeDescuento = tarifa *descuentoServicio(servicios);
        return tarifa +igv-importeDescuento+delivery;
    }

    public static void imprimirSolicitudes() {
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
        double costoTotal = 0;
        String especialidadTecnico = "";
        String especialidad = "";
        boolean entradaValida = false;
        boolean entradaValida2 = false;
        boolean entradaValida3 = false;

        System.out.print("");
        System.out.println("AGREGAR SOLICITUD");
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
        ZonaPostal.imprimirZonasPostales();
        System.out.print("--------------------------------------------\n");
        System.out.print("Ingrese código de Zona delivery: ");
        while (!entradaValida){
            String codigo = scanner.nextLine();
            System.out.print("");
            for (ZonaPostal zone: listaZona) {
                if (zone.getCodigoPostal().equals(codigo)) {
                    delivery = zone.getTarifaZona();
                    entradaValida  = true;
                }
            }
            if (!entradaValida){
                System.out.println("ERROR, ingrese una código válido: ");
            }else {
                System.out.println(" -Zona válida -  ");
            }
        }


        System.out.println("\nCosto por delivery: "+delivery);

        System.out.print("");
        Servicios.imprimirServicios();
        System.out.print("--------------------------------------------\n");
        System.out.print("Ingrese Nombre de Servicio a Solicitar: ");
        while (!entradaValida2) {
            String servicios = scanner.nextLine();
            for (Servicios serv: Servicios.listaServicios) {
                if (serv.getNombre().equals(servicios)) {
                    tarifa = serv.getTarifaServicio();
                    descuento = Solicitud.descuentoServicio(serv);
                    costoTotal = Solicitud.costoFinal(tarifa,delivery,serv);
                    entradaValida2 = true;
                }
            }
            if (!entradaValida2){
                System.out.println("ERROR, ingrese un nombre válido: ");
            }else {
                System.out.println(" - Servicio válido -  ");
            }

        }

        System.out.println("Tarifa: "+tarifa+" - Descuento por solicitud de servicio: "+descuento);
        System.out.print("\n");
        Especialidad.imprimirEspecialidades();
        System.out.print("--------------------------------------------\n");
        System.out.print("Ingrese codigo de especialidad a solicitar: ");
        while(!entradaValida3){
            String codigoEspecialidad = scanner.nextLine();
            for (Especialidad especialidad1: listaEspecialidades) {
                if (especialidad1.getCodigo().equals(codigoEspecialidad)) {
                    especialidadTecnico = especialidad1.getNombre();
                    //especialidad = personal.getEspecialidad();
                    entradaValida3=true;
                }
            }
            if (!entradaValida3){
                System.out.println("ERROR, ingrese un código válido: ");
            }else {
                System.out.println(" - Servicio válido -  ");
            }
        }

        System.out.println("Especialidad: "+especialidadTecnico + " con tecnico: " +especialidad);
        System.out.print("--------------------------------------------\n");
        System.out.print("ATENCION! Solicitud contiene los siguientes elementos: \n");
        System.out.print("Código: "+ codSolicitud+"\n");
        System.out.print("Fecha de atención:" +fechaAt+"\n");
        System.out.print("Fecha de emisión:" + fechaEm+"\n");
        System.out.print("Costo por Delivery: "+delivery+"\n");
        System.out.print("Costo por Servicio: "+tarifa+"\n");
        System.out.print("Descuento por Servicio: "+descuento+"\n");
        System.out.print("Especialidad asiganado: "+especialidadTecnico+"\n");
        System.out.print("Especialidad Técnico: "+especialidad+"\n");
        System.out.print("Costo Total del Servicio: "+costoTotal+"\n");
        System.out.print("Cometarios sobre la solicitud: "+comentarios+"\n");


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
