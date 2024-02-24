package franluna.prog07_tarea;

/**
 * Esta clase va a ser hija de CuentaBancaria pero al mismo tiempo va a ser parent de las demás cuentas corrientes
 * @author Francisco Luna Raya
 */
public class CuentaCorriente extends CuentaBancaria{
    
    private String listaEntidades;

    /**
     * Creamos el constructor para la cuenta corriente, haciendo uso de los siguientes parámetros
     * @param listaEntidades
     * @param iban
     * @param saldoActual
     * @param titular
     */
    public CuentaCorriente(String listaEntidades, String iban, double saldoActual, Persona titular) {
        super(iban, saldoActual, titular);
        this.listaEntidades = listaEntidades;
    }
    
    /**
     * @return String return the listaEntidades
     */
    public String getListaEntidades() {
        return listaEntidades;
    }

    /**
     * @param listaEntidades the listaEntidades to set
     */
    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    /**
     * Hacemos uso del override de la función de la interfaz, para poder devolver los datos de la cuenta corriente, en este caso, serán los de la cuenta bancaria + la lista de entidades
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Lista de Entidades = " + getListaEntidades();
    }

}
