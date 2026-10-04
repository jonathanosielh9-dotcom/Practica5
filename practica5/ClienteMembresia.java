package practica 5;

import java.time.LocalDate;

public class ClienteMembresia {
    private TipoMembresia tipo;
    private int diaCumpleanios;
    private int mesCumpleanios;

    public ClienteMembresia(TipoMembresia tipo, int diaCumpleanios, int mesCumpleanios) {
        this.tipo = tipo;
        this.diaCumpleanios = diaCumpleanios;
        this.mesCumpleanios = mesCumpleanios;
    }

    public TipoMembresia getTipo() {
        return tipo;
    }

    public boolean esSuCumpleanios(LocalDate fechaReferencia) {
        return fechaReferencia.getDayOfMonth() == this.diaCumpleanios &&
               fechaReferencia.getMonthValue() == this.mesCumpleanios;
    }
}
