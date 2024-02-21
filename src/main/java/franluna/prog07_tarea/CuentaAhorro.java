package franluna.prog07_tarea;

/**
 *
 * @author Francisco Luna Raya
 */
public class CuentaAhorro extends CuentaBancaria{
    
    private double tipoInteresAnual;

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


    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Tipo de Interés Anual = " + tipoInteresAnual;
    }
}
