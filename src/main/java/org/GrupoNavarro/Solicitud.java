package org.GrupoNavarro;

import java.text.CollationKey;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solicitud{
    private String codigoSolicitud;
    private String fechaAtencion;
    private String fechaEmision;
    private String comentarios;
    private String estado;
    private double CostoTotal;
    private ZonaPostal zonaPostalAsignada;
    private Cliente clienteAsignado;
    private Servicios servicioAsignado;
    private PersonalTecnico tecnicoAsignado;
    private static ArrayList<Solicitud> listaSolicitudes = new ArrayList<>();

    public Solicitud(String codigoSolicitud, String fechaAtencion, String fechaEmision, String comentarios, String estado,double costoTotal,ZonaPostal zonaPostalAsignada, Cliente clienteAsignado, Servicios servicioAsignado, PersonalTecnico tecnicoAsignado) {
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtencion = fechaAtencion;
        this.fechaEmision = fechaEmision;
        this.comentarios = comentarios;
        this.estado = estado;
        this.CostoTotal = costoTotal;
        this.zonaPostalAsignada = zonaPostalAsignada;
        this.clienteAsignado = clienteAsignado;
        this.servicioAsignado = servicioAsignado;
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public Solicitud() {
        this.codigoSolicitud = codigoSolicitud;
        this.fechaAtencion = fechaAtencion;
        this.fechaEmision = fechaEmision;
        this.comentarios = comentarios;
        this.estado = estado;
        this.clienteAsignado = clienteAsignado;
        this.servicioAsignado = servicioAsignado;
        this.tecnicoAsignado = tecnicoAsignado;
    }
    private static int contadorSolicitudes = 1;
    public static void registroNuevaSolicitud() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("REGISTRAR NUEVA SOLICITUD: \n");

        String fechaAtencion;

        do {
            System.out.print("Ingrese la fecha de atención \n(formato esperado: DD/MM/AAAA):");
            fechaAtencion = scanner.nextLine();
        } while (!validarFormatoFecha(fechaAtencion));

        Date fechaActual = new Date();
        SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
        SimpleDateFormat formatoAnio = new SimpleDateFormat("yy");
        String mesActual = formatoMes.format(fechaActual);
        String anioActual = formatoAnio.format(fechaActual);
        String codigoSolicitud = "GN-" + String.format("%05d", contadorSolicitudes) + "-" + mesActual + anioActual;
        String fechaEmision = formatoMes.format(fechaActual) + "/" + formatoAnio.format(fechaActual);

        System.out.print("Ingrese comentarios:");
        String comentarios = scanner.nextLine();

        System.out.print("Ingrese estado:");
        String estado = scanner.nextLine();

        Cliente clienteElegido = elegirCliente();
        String codigoPostalCliente = clienteElegido.getCodigoPostal();
        ZonaPostal zonaPostalElegida = obtenertarifaZonaPostalPorCodigoPostalCliente(codigoPostalCliente);

        Servicios servicioElegido = elegirServicio();

        PersonalTecnico tecnicoElegido = elegirTecnico(servicioElegido);

        String diaDeHoy = calculadiaCostoTotal();

        double costoTotal = 0;

        for (Servicios servicio : Servicios.listaServicios) {
            double costoServicio = servicioElegido.getTarifaServicio();
            double costoZonaPostal = zonaPostalElegida.getTarifaZona();
            if (diaDeHoy.equals("Sabado") || diaDeHoy.equals("Domingo")) {
                costoTotal = (costoServicio + costoZonaPostal) * 1.10;
                DecimalFormat df = new DecimalFormat("#.##");
                costoTotal = Double.parseDouble(df.format(costoTotal));
            } else {
                costoTotal = costoServicio + costoZonaPostal;
            }
        }

        Solicitud nuevaSolicitud = new Solicitud();
        nuevaSolicitud.codigoSolicitud = codigoSolicitud;
        nuevaSolicitud.fechaAtencion = fechaAtencion;
        nuevaSolicitud.fechaEmision = fechaEmision;
        nuevaSolicitud.comentarios = comentarios;
        nuevaSolicitud.estado = estado;
        nuevaSolicitud.CostoTotal = costoTotal;
        nuevaSolicitud.zonaPostalAsignada = zonaPostalElegida;
        nuevaSolicitud.clienteAsignado = clienteElegido;
        nuevaSolicitud.servicioAsignado = servicioElegido;
        nuevaSolicitud.tecnicoAsignado = tecnicoElegido;

        listaSolicitudes.add(nuevaSolicitud);

        System.out.println("Solicitud registrada exitosamente.");
        System.out.println(nuevaSolicitud.toString());
        contadorSolicitudes++;
    }
    private static ZonaPostal obtenertarifaZonaPostalPorCodigoPostalCliente(String codigoPostalCliente) {
        // Buscar la ZonaPostal correspondiente al código postal del cliente
        for (ZonaPostal zonaPostal : ZonaPostal.getListaZonaPostal()) {
            if (zonaPostal.getCodigoPostal().equals(codigoPostalCliente)) {
                return zonaPostal;
            }
        }

        System.out.println("Zona Postal no encontrada para el código postal del cliente. Seleccionando la primera Zona Postal por defecto.");
        return ZonaPostal.getListaZonaPostal().get(0);
    }

    private static Cliente elegirCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione un cliente:");

        for (int i = 0; i < GrupoNavarro.getListaClientes().size(); i++) {
            Cliente cliente = GrupoNavarro.getListaClientes().get(i);
            System.out.println((i + 1) + ". " + cliente.getnombreCompleto()+cliente.getCodigoPostal());
        }

        int opcionElegida = scanner.nextInt();

        if (opcionElegida >= 1 && opcionElegida <= GrupoNavarro.getListaClientes().size()) {
            return GrupoNavarro.getListaClientes().get(opcionElegida - 1);
        } else {
            System.out.println("Opción no válida. Seleccionando el primer cliente por defecto.");
            return GrupoNavarro.getListaClientes().get(0);
        }
    }
    private static PersonalTecnico elegirTecnico(Servicios servicioElegido) {
        String especialidadServicio = servicioElegido.getNombre();

        List<PersonalTecnico> tecnicosDisponibles = PersonalTecnico.getListaTecnicos().stream()
                .filter(tecnico -> tecnico.getEspecialidadTecnico().equals(especialidadServicio))
                .collect(Collectors.toList());

        if (tecnicosDisponibles.isEmpty()) {
            System.out.println("No hay técnicos disponibles con la especialidad del servicio. Seleccionando el primer técnico disponible.");
            return PersonalTecnico.getListaTecnicos().get(0);
        }

        Random rand = new Random();
        return tecnicosDisponibles.get(rand.nextInt(tecnicosDisponibles.size()));
    }
    private static boolean validarFormatoFecha(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);

        try {
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
            return false;
        }
    }

    private static Servicios elegirServicio() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione un servicio:");

        for (int i = 0; i < Servicios.listaServicios.size(); i++) {
            Servicios servicio = Servicios.listaServicios.get(i);
            System.out.println((i + 1) + ". " + servicio.getNombre()+" "+servicio.getTarifaServicio());
        }

        int opcionElegida = scanner.nextInt();

        if (opcionElegida >= 1 && opcionElegida <= Servicios.listaServicios.size()) {
            return Servicios.listaServicios.get(opcionElegida - 1);
        } else {
            System.out.println("Opción no válida. Seleccionando el primer servicio por defecto.");
            return Servicios.listaServicios.get(0);
        }
    }
    // CALCULAR COSTO TOTAL SEGUN EL DIA
    public static String calculadiaCostoTotal(){
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
    // CALCULAR COSTO TOTAL SEGUN EL DIA

    public static void imprimirListaSolicitudes() {
        System.out.println("Lista de Solicitudes:");
        listaSolicitudes.stream().map(Solicitud::toString2).forEach(System.out::println);
    }
    public String toString2() {
        return  "***Solicitud: \n" +
                "  Código de Solicitud: " + codigoSolicitud +
                ", Fecha de Atención: " + fechaAtencion+
                ", Fecha de Emisión: " + fechaEmision + "\n" +
                "  Comentarios: " + comentarios + "\n" +
                "  Estado: " + estado + "\n" +
                "Cliente: \n" + "  " + clienteAsignado + "\n" +
                "Servicio: \n" + "  " + servicioAsignado + "\n" +
                "Técnico: \n" + "  " + tecnicoAsignado + "\n";
    }
    @Override
    public String toString() {
        return  "***Solicitud: \n" +
                "  Código de Solicitud: " + codigoSolicitud + "\n" +
                "  Fecha de Atención: " + fechaAtencion + "\n" +
                "  Fecha de Emisión: " + fechaEmision + "\n" +
                "  Comentarios: " + comentarios + "\n" +
                "  Estado: " + estado + "\n" +
                "  Costo Total: " + CostoTotal + "\n" +
                "Zona Postal: \n" + "  " + zonaPostalAsignada + "\n"+
                "Cliente: \n" + "  " + clienteAsignado + "\n" +
                "Servicio: \n" + "  " + servicioAsignado + "\n" +
                "Técnico: \n" + "  " + tecnicoAsignado + "\n";
    }

}
