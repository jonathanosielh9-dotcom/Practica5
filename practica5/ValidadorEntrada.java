package practica5;

import java.util.Scanner;

public class ValidadorEntrada {
    private final Scanner scanner;

    public ValidadorEntrada(Scanner scanner) {
        this.scanner = scanner;
    }

    public double leerMontoCompra() {
        double monto = 0.0;
        while (true) {
            System.out.print("Ingrese el monto de la compra ($): ");
            if (scanner.hasNextDouble()) {
                monto = scanner.nextDouble();
                if (monto > 0) {
                    return monto;
                } else {
                    System.out.println("-> Error: El monto debe ser mayor a 0.");
                }
            } else {
                System.out.println("-> Error: Por favor ingrese un valor numerico valido.");
                scanner.next(); // Limpiar entrada no válida
            }
        }
    }

    public TipoMembresia leerTipoMembresia() {
        while (true) {
            System.out.println("\nSeleccione el tipo de membresia:");
            System.out.println("1. PLATA (5%)");
            System.out.println("2. ORO (8%)");
            System.out.println("3. DIAMANTE (12%)");
            System.out.print("Opcion (1-3): ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1: return TipoMembresia.PLATA;
                    case 2: return TipoMembresia.ORO;
                    case 3: return TipoMembresia.DIAMANTE;
                    default: System.out.println("-> Error: Opcion fuera de rango (1-3).");
                }
            } else {
                System.out.println("-> Error: Ingrese un numero entero.");
                scanner.next();
            }
        }
    }

    public int leerMesCumpleanios() {
        while (true) {
            System.out.print("\nIngrese su mes de nacimiento (1-12): ");
            if (scanner.hasNextInt()) {
                int mes = scanner.nextInt();
                if (mes >= 1 && mes <= 12) {
                    return mes;
                } else {
                    System.out.println("-> Error: El mes debe estar entre 1 y 12.");
                }
            } else {
                System.out.println("-> Error: Ingrese un numero entero.");
                scanner.next();
            }
        }
    }

    public int leerDiaCumpleanios(int mes) {
        int diasMaximos = obtenerDiasDelMes(mes);
        while (true) {
            System.out.print("Ingrese su dia de nacimiento (1-" + diasMaximos + "): ");
            if (scanner.hasNextInt()) {
                int dia = scanner.nextInt();
                if (dia >= 1 && dia <= diasMaximos) {
                    return dia;
                } else {
                    System.out.println("-> Error: Dia no valido para el mes seleccionado.");
                }
            } else {
                System.out.println("-> Error: Ingrese un numero entero.");
                scanner.next();
            }
        }
    }

    private int obtenerDiasDelMes(int mes) {
        switch (mes) {
            case 2: return 29; // Para cubrir años bisiestos
            case 4: case 6: case 9: case 11: return 30;
            default: return 31;
        }
    }
}
