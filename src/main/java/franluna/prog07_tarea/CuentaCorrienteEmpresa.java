package franluna.prog07_tarea;

/**
 * Aquí tenemos un tipo de cuenta corriente, en este caso para empresa, siendo hija de la clase "CuentaCorriente"
 * @author Francisco Luna Raya
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    
    private double maximoDescubierto;
    private double tipoInteresDescubierto;
    private double comisionFijaDescubierto;

    /**
     * Creamos el constructor para la cuenta corriente de empresa haciendo uso de los siguientes parámetros.
     * @param maximoDescubierto
     * @param tipoInteresDescubierto
     * @param comisionFijaDescubierto
     * @param listaEntidades
     * @param iban
     * @param saldoActual
     * @param titular
     */
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

    /**
     * Hacemos uso del override de la función de la interfaz, para poder devolver nuestro mensaje
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Máximo Descubierto = " + getMaximoDescubierto() + ", Tipo de Interés Descubierto = " + getTipoInteresDescubierto() + ", Comisión Fija Descubierto = " + getComisionFijaDescubierto();
    }
}
