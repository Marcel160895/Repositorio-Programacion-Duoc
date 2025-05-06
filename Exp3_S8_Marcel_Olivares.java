package com.mycompany.exp3_s8_marcel_olivares;

import java.util.ArrayList;
import java.util.Scanner;

public class Exp3_S8_Marcel_Olivares {

    static String nombreTeatro = "Teatro Moro";
    static final int VentaFin = 100;

    static String ubicacion = "";
    static double precioBase = 0;
    static double descuento = 0;

    static int contadorVentas = 0;
    static int siguienteIdVenta = 1;
    static int siguienteIdReserva = 1;

    static double descuentoAplicado = 0;
    static double precioFinal = 0;
    static double ingresosTotales;

    static int[] idVentas = new int[VentaFin];
    static String[] ubicaciones = new String[VentaFin];
    static int[] asientos = new int[VentaFin];
    static String[] clientes = new String[VentaFin];
    static double[] preciosFinales = new double[VentaFin];
    static ArrayList<String> resumenVentas = new ArrayList<>();
    static ArrayList<String> promociones = new ArrayList<>();
    static ArrayList<String> reservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        for (;;) {
            System.out.println("Bienvenidos al menu de ventas del " + nombreTeatro);
            System.out.println("Seleccione su preferencia");
            System.out.println("");
            System.out.println("1.- Comprar entradas");
            System.out.println("2.- Resumen de compra");
            System.out.println("3.- Generar boleta");
            System.out.println("4.- Resumen ingresos totales");
            System.out.println("5.- Eliminar una venta");
            System.out.println("6.- Modificar cliente");
            System.out.println("7.- Ver reservas");
            System.out.println("8.- Salir");

            int menu = Scanner.nextInt();
            Scanner.nextLine();

            switch (menu) {
                case 1:
                    if (contadorVentas >= VentaFin) {
                        System.out.println("Lo lamentamos! Ya se han vendido todas las entradas");
                        return;
                    }

                    System.out.println("Ingrese su nombre para el registro");
                    String Nombrecliente = Scanner.nextLine();

                    System.out.println("Vamos por la seleccion de ubicacion");
                    System.out.println("1.- Vip con un valor de $20.000");
                    System.out.println("2.- Platea con un valor de $15.000");
                    System.out.println("3.- General con un valor de $10.000");

                    int entrada = Scanner.nextInt();
                    Scanner.nextLine();

                    switch (entrada) {
                        case 1:
                            ubicacion = "VIP";
                            precioBase = 20000;
                            System.out.println("Validaremos si tienes acceso a algun descuento");
                            System.out.println("1.- Soy estudiante");
                            System.out.println("2.- Soy una persona de tercera edad");
                            System.out.println("3.- No soy ninguna de las anteriores");

                            int promo = Scanner.nextInt();
                            Scanner.nextLine();

                            switch (promo) {
                                case 1:
                                    System.out.println("Has obtenido el descuento estudiantil");

                                    descuento = 0.10;
                                    break;
                                case 2:
                                    System.out.println("Has obtenido el descuento tercera edad");

                                    descuento = 0.15;
                                    break;
                                case 3:
                                    System.out.println("No cualificas para ningun descuento");

                                    descuento = 1;
                                    break;
                                default:
                                    System.out.println("Favor, elige una opcion correspondiente");
                                    return;
                            }
                            break;
                        case 2:
                            ubicacion = "Platea";
                            precioBase = 15000;

                            System.out.println("Validaremos si tienes acceso a algun descuento");
                            System.out.println("1.- Soy estudiante");
                            System.out.println("2.- Soy una persona de tercera edad");
                            System.out.println("3.- No soy ninguna de las anteriores");

                            int promo1 = Scanner.nextInt();
                            Scanner.nextLine();

                            switch (promo1) {
                                case 1:
                                    System.out.println("Has obtenido el descuento estudiantil");

                                    descuento = 0.10;
                                    break;
                                case 2:
                                    System.out.println("Has obtenido el descuento tercera edad");

                                    descuento = 0.15;
                                    break;
                                case 3:
                                    System.out.println("No cualificas para ningun descuento");

                                    descuento = 1;
                                    break;
                                default:
                                    System.out.println("Favor, elige una opcion correspondiente");
                                    return;
                            }
                            break;
                        case 3:
                            ubicacion = "General";
                            precioBase = 10000;

                            System.out.println("Validaremos si tienes acceso a algun descuento");
                            System.out.println("1.- Soy estudiante");
                            System.out.println("2.- Soy una persona de tercera edad");
                            System.out.println("3.- No soy ninguna de las anteriores");

                            int promo2 = Scanner.nextInt();
                            Scanner.nextLine();

                            switch (promo2) {
                                case 1:
                                    System.out.println("Has obtenido el descuento estudiantil");

                                    descuento = 0.10;
                                    break;
                                case 2:
                                    System.out.println("Has obtenido el descuento tercera edad");

                                    descuento = 0.15;
                                    break;
                                case 3:
                                    System.out.println("No cualificas para ningun descuento");

                                    descuento = 1;
                                    break;
                                default:
                                    System.out.println("Favor, elige una opcion correspondiente");
                                    return;
                            }
                        default:
                            System.out.println("Favor, elige una opcion correspondiente");
                    }

                    descuentoAplicado = precioBase * descuento;
                    precioFinal = precioBase - descuentoAplicado;

                    int asientoAsignado = contadorVentas + 1;

                    resumenVentas.add("Ubicación: " + ubicacion + " | Precio base: $" + precioBase
                            + " | Descuento: $" + descuentoAplicado + " | Precio final: $" + precioFinal);

                    idVentas[contadorVentas] = siguienteIdVenta++;
                    ubicaciones[contadorVentas] = ubicacion;
                    clientes[contadorVentas] = Nombrecliente;
                    asientos[contadorVentas] = asientoAsignado;
                    preciosFinales[contadorVentas] = precioFinal;

                    ingresosTotales += precioFinal;
                    contadorVentas++;

                    System.out.println("La entrada fue comprada con exito");
                    break;

                case 2:
                    System.out.println("Resumen de compra:");
                    for (int i = 0; i < contadorVentas; i++) {
                        System.out.println("ID: " + idVentas[i]);
                        System.out.println("Cliente: " + clientes[i]);
                        System.out.println("Ubicacion: " + ubicaciones[i]);
                        System.out.println("Asientos: " + asientos[i]);
                        System.out.println("Costo total: $" + preciosFinales[i]);
                    }
                    System.out.println("Gracias por preferir al" + nombreTeatro + ", disfrute la funcion");
                    break;

                case 3:
                    System.out.println("------------------BOLETA DE COMPRA TEATRO MORO------------------");
                    for (int i = 0; i < contadorVentas; i++) {
                        System.out.println("ID: " + idVentas[i] + " | Cliente: " + clientes[i] + " | Asiento: " + asientos[i] + " | Total: $" + preciosFinales[i]);
                    }
                    System.out.println("Total ingresos: $" + ingresosTotales);
                    System.out.println("------------------Gracias por su compra------------------");
                    break;
                case 4:
                    System.out.println("Ingresos totales: $" + ingresosTotales);
                    break;
                case 5:
                    System.out.println("Ingrese ID de venta a eliminar:");
                    int idEliminar = Scanner.nextInt();
                    Scanner.nextLine();
                    eliminarVenta(idEliminar);
                    break;
                 case 6:
                    System.out.println("Ingrese ID de venta a modificar cliente:");
                    int idModificar = Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("Ingrese nuevo nombre:");
                    String nuevoNombre = Scanner.nextLine();
                    modificarCliente(idModificar, nuevoNombre);
                    break;

                case 7:
                    System.out.println("Reservas actuales:");
                    for (String r : reservas) {
                        System.out.println(r);
                    }
                    break;

                case 8:
                    System.out.println("Gracias por su visita al " + nombreTeatro + ". ¡Vuelva pronto!");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
 
    static void eliminarVenta(int id) {
        for (int i = 0; i < contadorVentas; i++) {
            if (idVentas[i] == id) {
                ingresosTotales -= preciosFinales[i];
                for (int j = i; j < contadorVentas - 1; j++) {
                    idVentas[j] = idVentas[j + 1];
                    ubicaciones[j] = ubicaciones[j + 1];
                    clientes[j] = clientes[j + 1];
                    asientos[j] = asientos[j + 1];
                    preciosFinales[j] = preciosFinales[j + 1];
                }
                contadorVentas--;
                System.out.println("Venta eliminada exitosamente.");
                return;
            }
        }
        System.out.println("Venta no encontrada.");
    }

    static void modificarCliente(int id, String nuevoNombre) {
        for (int i = 0; i < contadorVentas; i++) {
            if (idVentas[i] == id) {
                clientes[i] = nuevoNombre;
                System.out.println("Nombre del cliente actualizado.");
                return;
            }
        }
        System.out.println("ID no encontrado.");
    }
}