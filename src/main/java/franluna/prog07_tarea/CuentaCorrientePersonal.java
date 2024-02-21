package franluna.prog07_tarea;

/**
 *
 * @author Francisco Luna Raya
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    
    private double comisionMantenimiento;

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

    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Comisión de Mantenimiento = " + comisionMantenimiento;
    }
}