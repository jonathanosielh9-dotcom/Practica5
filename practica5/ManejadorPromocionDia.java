package practica5;

import java.time.LocalDate;

public class ManejadorPromocionDia {
    public DiaSemana obtenerDiaActual(LocalDate fechaActual) {
        switch (fechaActual.getDayOfWeek()) {
            case MONDAY: return DiaSemana.LUNES;
            case TUESDAY: return DiaSemana.MARTES;
            case WEDNESDAY: return DiaSemana.MIERCOLES;
            case THURSDAY: return DiaSemana.JUEVES;
            case FRIDAY: return DiaSemana.VIERNES;
            case SATURDAY: return DiaSemana.SABADO;
            case SUNDAY: return DiaSemana.DOMINGO;
            default: throw new IllegalArgumentException("Día no válido");
        }
    }

    public double aplicarDescuentoPorDia(double montoActual, TipoMembresia tipoMembresia, DiaSemana dia) {
        if (dia == DiaSemana.LUNES || dia == DiaSemana.JUEVES) {
            // Lunes y Jueves: 12% de descuento a todas las membresías
            return montoActual * (1.0 - 0.12);
        } else if (dia == DiaSemana.MARTES) {
            // Martes: 10% adicional a Oro y Diamante sobre lo ya rebajado
            if (tipoMembresia == TipoMembresia.ORO || tipoMembresia == TipoMembresia.DIAMANTE) {
                return montoActual * (1.0 - 0.10);
            }
        }
        return montoActual;
    }
}
