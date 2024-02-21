package franluna.prog07_tarea;

/**
 *
 * @author Francisco Luna Raya
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    
    private double maximoDescubierto;
    private double tipoInteresDescubierto;
    private double comisionFijaDescubierto;

    public CuentaCorrienteEmpresa(double maximoDescubierto, double tipoInteresDescubierto, double comisionFijaDescubierto, String listaEntidades, String iban, double saldoActual, Persona titular) {
        super(listaEntidades, iban, saldoActual, titular);
        this.maximoDescubierto = maximoDescubierto;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    /**
     * @return double return the maximoDescubierto
     */
    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    /**
     * @param maximoDescubierto the maximoDescubierto to set
     */
    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    /**
     * @return double return the tipoInteresDescubierto
     */
    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    /**
     * @param tipoInteresDescubierto the tipoInteresDescubierto to set
     */
    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    /**
     * @return double return the comisionFijaDescubierto
     */
    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    /**
     * @param comisionFijaDescubierto the comisionFijaDescubierto to set
     */
    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Máximo Descubierto =" + maximoDescubierto + ", Tipo de Interés Descubierto =" + tipoInteresDescubierto + ", Comisión Fija Descubierto =" + comisionFijaDescubierto	;
    }
}
