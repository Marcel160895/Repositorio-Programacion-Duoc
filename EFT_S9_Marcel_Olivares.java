/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eft_s9_marcel_olivares;

import java.util.Scanner;

public class EFT_S9_Marcel_Olivares {
    static String nombreTeatro = "---Teatro Moro---";
    static final int VentaFin = 100;
    static int contadorVentas = 0;
    static double precioBase = 0;
    static String ubicacion = "";
    static double descuento = 0;
    static int siguienteIdVenta = 1;
    static double ingresosTotales = 0;
    static int[] idVentas = new int[VentaFin];
    static String[] ubicaciones = new String[VentaFin];
    static int[] asientos = new int[VentaFin];
    static String[] clientes = new String[VentaFin];
    static double[] preciosFinales = new double[VentaFin];
   
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Bienvenidos al menu de ventas del " + nombreTeatro);
            System.out.println("1.- Comprar entradas");
            System.out.println("2.- Resumen de compra");
            System.out.println("3.- Generar boleta");
            System.out.println("4.- Resumen ingresos totales");
            System.out.println("5.- Eliminar una venta");
            System.out.println("6.- Modificar cliente");
            System.out.println("7.- Salir");
            
            int menu = sc.nextInt();
            sc.nextLine();
            
            switch (menu) {
                case 1:
                    if (contadorVentas >= VentaFin) {
                        System.out.println("Lo lamento! Las entradas se agotaron");
                        break;
                    }
                    System.out.println("Favor, indiquenos su nombre");
                    String nombreCliente = sc.nextLine();
                    
                    System.out.println("Ingrese su edad");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    
                    if (edad <= 0 || edad > 120) {
                        System.out.println("Edad no valida");
                        break;
                    }
                    
                    System.out.println("Favor indiquenos su genero");
                    System.out.println("M, para Masculino");
                    System.out.println("F, para femenino");
                    String genero = sc.nextLine();
                    
                    System.out.println("¿Es estudiante? (true/false):");
                    boolean estudiante = sc.nextBoolean();
                    sc.nextLine();
                    
                    System.out.println("Seleccione su entrada");
                    System.out.println("1.- Vip ($30000)");
                    System.out.println("2.- Palco ($25000)");
                    System.out.println("3.- Platea alta ($20000)");
                    System.out.println("4.- Platea Baja ($15000)");
                    System.out.println("5.- Galeria ($10000)");
                    
                    int entrada = sc.nextInt();
                    sc.nextLine();
                    
                    switch (entrada) {
                        case 1:
                            ubicacion = "Vip";
                            precioBase = 30000;
                            break;
                        case 2:
                            ubicacion = "Palco";
                            precioBase = 25000;
                            break;
                        case 3:
                            ubicacion = "Platea alta";
                            precioBase = 20000;
                            break;
                        case 4:
                            ubicacion = "Platea baja";
                            precioBase = 15000;
                            break;  
                        case 5:
                            ubicacion = "Galeria";
                            precioBase = 10000;
                            break;
                        default:
                            System.out.println("Ubicacion no disponible");
                        continue;
                    }
                    double descuento = calcularDescuento(genero, edad, estudiante);
                    double descuentoAplicado = precioBase * descuento;
                    double precioFinal = precioBase - descuentoAplicado;
                    int asientoAsignado = contadorVentas + 1;

                    idVentas[contadorVentas] = siguienteIdVenta++;
                    clientes[contadorVentas] = nombreCliente;
                    ubicaciones[contadorVentas] = ubicacion;
                    asientos[contadorVentas] = asientoAsignado;
                    preciosFinales[contadorVentas] = precioFinal;
                    ingresosTotales += precioFinal;
                    contadorVentas++;
                    
                    System.out.println("Compra exitosa. Asiento asignado: " + asientoAsignado);
                    break;

                case 2:
                    for (int i = 0; i < contadorVentas; i++) {
                        System.out.println("ID: " + idVentas[i] + " | Cliente: " + clientes[i] + " | Ubicación: " + ubicaciones[i] + " | Asiento: " + asientos[i] + " | Total: $" + preciosFinales[i]);
                    }
                    break;

                case 3:
                    System.out.println("---- BOLETA DE COMPRA ----");
                    for (int i = 0; i < contadorVentas; i++) {
                        System.out.println("ID: " + idVentas[i] + " | Cliente: " + clientes[i] + " | Asiento: " + asientos[i] + " | Total: $" + preciosFinales[i]);
                    }
                    System.out.println("Total ingresos: $" + ingresosTotales);
                    break;

                case 4:
                    System.out.println("Ingresos totales: $" + ingresosTotales);
                    break;

                case 5:
                    System.out.println("Ingrese ID de venta a eliminar:");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    eliminarVenta(idEliminar);
                    break;

                case 6:
                    System.out.println("Ingrese ID de venta a modificar:");
                    int idModificar = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nuevo nombre:");
                    String nuevoNombre = sc.nextLine();
                    modificarCliente(idModificar, nuevoNombre);
                    break;

                case 7:
                    System.out.println("Gracias por su visita al " + nombreTeatro);
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    static double calcularDescuento(String genero, int edad, boolean estudiante) {
        if (edad < 12) return 0.10;
        if (edad >= 65) return 0.25;
        if (genero.equalsIgnoreCase("F")) return 0.20;
        if (estudiante) return 0.15;
        return 0.0;
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
                System.out.println("Nombre actualizado.");
                return;
            }
        }
        System.out.println("ID no encontrado.");
    }
}
            