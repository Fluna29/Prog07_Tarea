package franluna.prog07_tarea;

/**
 *
 * @author Francisco Luna Raya
 */
public class CuentaCorriente extends CuentaBancaria{
    
    private String listaEntidades;

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


    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", Lista de Entidades = " + listaEntidades;
    }

}
