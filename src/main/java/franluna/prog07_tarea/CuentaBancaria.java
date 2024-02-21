package franluna.prog07_tarea;

/**
 * Aquí generamos una clase que usaremos de Parent donde
 * tendremos los datos comunes a todos los tipos de cuentas.
 * @author Francisco Luna Raya
 */
public abstract class CuentaBancaria implements Imprimible {
    

    private String iban;
    private double saldoActual;
    private Persona titular;
    
    /**
     * Creamos un constructor vacío
     */
    protected CuentaBancaria(){
        this.iban = "";
        this.saldoActual = 0.0;
    }
    
    /**
     * Creamos nuestro constructor del objeto CuentaBancaria
     * @param iban
     * @param saldoActual
     * @param titular
     */
    protected CuentaBancaria(String iban, double saldoActual, Persona titular){
        this.iban = iban;
        this.saldoActual = saldoActual;
        this.titular = titular;
    }

    /**
     * @return String return the iban
     */
    public String getiban() {
        return iban;
    }

    /**
     * @param iban the iban to set
     */
    public void setiban(String iban) {
        this.iban = iban;
    }

    /**
     * @return double return the saldoActual
     */
    public double getSaldoActual() {
        return saldoActual;
    }

    /**
     * @param saldoActual the saldoActual to set
     */
    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    /**
     * @return Persona return the titular
     */
    public Persona getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    @Override
    public String devolverInfoString(){
        return "Datos Cuenta {" + " iban = " + iban + " | Saldo Actual = " + saldoActual + " | Titular = " + titular.devolverInfoString() + " }";
    }
}
