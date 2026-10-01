package practica5;

import java.time.LocalDate;

public class CalculadorDescuento {
    private ManejadorPromocionDia manejadorPromocion;

    public CalculadorDescuento() {
        this.manejadorPromocion = new ManejadorPromocionDia();
    }

    public double calcularMontoFinal(double montoOriginal, ClienteMembresia cliente, LocalDate fechaOperacion) {
        // 1. Prioridad: Promoción de Cumpleaños (50% global)
        if (cliente.esSuCumpleanios(fechaOperacion)) {
            return montoOriginal * 0.50;
        }

        // 2. Aplicar descuento por Membresía
        double montoConMembresia = montoOriginal * (1.0 - cliente.getTipo().getPorcentajeDescuento());

        // 3. Aplicar descuento promocional por Día sobre el monto resultante
        DiaSemana diaActual = manejadorPromocion.obtenerDiaActual(fechaOperacion);
        double montoFinal = manejadorPromocion.aplicarDescuentoPorDia(montoConMembresia, cliente.getTipo(), diaActual);

        return montoFinal;
    }
}
