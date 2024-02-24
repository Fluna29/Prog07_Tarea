package franluna.prog07_tarea;

/**
 * Esta clase sirve para crear el tipo de cuenta de ahorro siendo hija de la clase CuentaBancaria.
 * @author Francisco Luna Raya
 */
public class CuentaAhorro extends CuentaBancaria{
    
    private double tipoInteresAnual;

    /**
     * Se crea el constructor de la clase CuentaAhorro, haciendo uso de los siguientes parámetros
     * @param tipoInteresAnual
     * @param iban
     * @param saldoActual
     * @param titular
     */
    public CuentaAhorro(double tipoInteresAnual, String iban, double saldoActual, Persona titular){
        super(iban, saldoActual, titular);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    /**
     * @return double return the tipoInteresAnual
     */
    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    /**
     * @param tipoInteresAnual the tipoInteresAnual to set
     */
    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }

    /**
     * Haciendo uso del override, vamos a devolver el valor de los datos de la cuenta y del tipo de interés anual.
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Tipo de Interés Anual = " + getTipoInteresAnual();
    }
}
