package practica5;

import java.time.LocalDate;
import java.util.Scanner;

public class Practica5 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ValidadorEntrada validador = new ValidadorEntrada(scanner);

        System.out.println("   SISTEMA DE DESCUENTOS DE LA TIENDA\n");

        // Lectura y filtrado mediante la clase ValidadorEntrada
        double montoCompra = validador.leerMontoCompra();
        TipoMembresia membresiaElegida = validador.leerTipoMembresia();
        int mesCumple = validador.leerMesCumpleanios();
        int diaCumple = validador.leerDiaCumpleanios(mesCumple);

        // Instanciación de objetos de dominio
        ClienteMembresia cliente = new ClienteMembresia(membresiaElegida, diaCumple, mesCumple);
        CalculadorDescuento calculador = new CalculadorDescuento();
        LocalDate hoy = LocalDate.now();

        // Cálculo
        double totalAPagar = calculador.calcularMontoFinal(montoCompra, cliente, hoy);

        // Impresión de resultados
        System.out.println("\n           RESUMEN DE SU COMPRA           \n");
        System.out.printf("Monto original:          $%.2f%n", montoCompra);
        System.out.println("Tipo de Membresia:       " + cliente.getTipo());
        System.out.println("Fecha de evaluacion:     " + hoy.getDayOfWeek() + " " + hoy);

        if (cliente.esSuCumpleanios(hoy)) {
            System.out.println("FELIZ CUMPLEANIOS\n \tSe aplico un 50% de descuento especial.");
        } else {
            System.out.println("Aplicados descuentos de membresia y promocion por dia (si aplican).");
        }

        System.out.printf("MONTO TOTAL A PAGAR:     $%.2f%n", totalAPagar);

        scanner.close();
    }
}
