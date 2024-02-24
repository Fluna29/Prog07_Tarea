package franluna.prog07_tarea;

/**
 * Aquí generamos una clase que usaremos de Parent donde
 * tendremos los datos comunes a todos los tipos de cuentas.
 * Implementamos el uso de la interfaz "Imprimible"
 * Esta clase será del tipo abstract, ya que no la vamos a crear, tan solo vamos a hacer uso de ella.
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
     * Creamos nuestro constructor del objeto CuentaBancaria, haciendo uso de los siguientes parámetros
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
    public String getIban() {
        return iban;
    }

    /**
     * @param iban the iban to set
     */
    public void setIban(String iban) {
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

    /**
     * Hacemos uso del override de la función de la interfaz, para poder devolver los datos de las cuentas, siendo estos, el IBAN, el saldo y el titular de la cuenta
     */
    @Override
    public String devolverInfoString(){
        return "Datos Cuenta {" + " IBAN = " + getIban() + " | Saldo Actual = " + getSaldoActual() + " | Titular = " + titular.devolverInfoString() + "}";
    }
}
