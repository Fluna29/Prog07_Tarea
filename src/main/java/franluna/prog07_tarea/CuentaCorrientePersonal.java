package franluna.prog07_tarea;

/**
 *Aquí tenemos un tipo de cuenta corriente, en este caso Personal, siendo hija de la clase "CuentaCorriente"
 * @author Francisco Luna Raya
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    
    private double comisionMantenimiento;

    /**
     * Creamos el constructor para la Cuenta Corriente Personal, haciendo uso de los siguientes parámetros
     * @param comisionMantenimiento
     * @param listaEntidades
     * @param iban
     * @param saldoActual
     * @param titular
     */
    public CuentaCorrientePersonal(double comisionMantenimiento, String listaEntidades, String iban, double saldoActual, Persona titular){
        super(listaEntidades, iban, saldoActual, titular);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * @return double return the comisionMantenimiento
     */
    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    /**
     * @param comisionMantenimiento the comisionMantenimiento to set
     */
    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Hacemos uso del override de la función de la interfaz, para poder devolver nuestro mensaje
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Comisión de Mantenimiento = " + getComisionMantenimiento();
    }
}