package org.GrupoNavarro;
import java.util.Scanner;

public class ZonaPostal {
    private String ciudad;
    private double precioBase;

    public ZonaPostal(String ciudad, double precioBase) {
        this.ciudad = ciudad;
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

        // Cerrar el scanner
        scanner.close();
    }
}