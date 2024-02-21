package franluna.prog07_tarea;

/**
 *
 * @author Francisco Luna Raya
 */
public class Banco {

    private CuentaBancaria[] cuentas;
    private final int MAX_CUENTAS = 100;
    private int numCuentas;


    public Banco() {
        this.numCuentas = 0;
        this.cuentas= new CuentaBancaria[this.MAX_CUENTAS];
    }

    public boolean abrirCuenta (CuentaBancaria c){

        if (this.numCuentas >= this.MAX_CUENTAS) {
            System.out.println("No hay suficiente espacio");
            return false;
        }

        CuentaBancaria existe = this.buscarCuenta(c.getiban());
        if(existe != null) {
            System.out.println("Ya existe la cuenta bancaria");
            return false;
        }

        this.cuentas[this.numCuentas] = c;
        this.numCuentas++;
        return true;
    }

    public String[] listadoCuentas(){
        
        String[] infoCuentas = new String[this.numCuentas];
        for (int i = 0; i < this.numCuentas; i++) {
            infoCuentas[i] = this.cuentas[i].devolverInfoString();
        }
        return infoCuentas;
    }

    public String informacionCuenta(String iban) {

        CuentaBancaria c = this.buscarCuenta(iban);
        if (c != null) {
            return c.devolverInfoString();
        }
        return null;
    }

    public boolean ingresoCuenta(String iban, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(iban);
        if (c != null) {
            c.setSaldoActual(c.getSaldoActual() + cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String iban, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(iban);
        if (c != null) {

            boolean sePuedeRetirar = false;
            
            if (c.getSaldoActual() - cantidad > 0) {
                sePuedeRetirar = true;
            }else if(c instanceof CuentaCorrienteEmpresa){
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)c;
                if(Math.abs(c.getSaldoActual() - cantidad) < aux.getMaximoDescubierto()){
                    sePuedeRetirar = true;
                }
            }
            
            if(sePuedeRetirar){
                c.setSaldoActual(c.getSaldoActual() - cantidad);
            }
            
            return sePuedeRetirar;

        }
        return false;
    }

    public double obtenerSaldo(String iban) {
        CuentaBancaria c = this.buscarCuenta(iban);
        if (c != null) {
            return c.getSaldoActual();
        }
        return -1;
    }

    private CuentaBancaria buscarCuenta(String iban) {
        for (int i = 0; i < this.numCuentas; i++) {
            if (this.cuentas[i].getiban().equals(iban)) {
                return this.cuentas[i];
            }
        }
        return null;
    }
}
