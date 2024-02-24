package franluna.prog07_tarea;

/**
 * Mantendrá como atributo la estructura que almacena las cuentas (el array de cuentas) y todas las funciones necesarias para usar todas las demás clases cuentas. 
 * @author Francisco Luna Raya
 */
public class Banco {

    private CuentaBancaria[] cuentas;
    private static final int MAX_CUENTAS = 100;
    private int numCuentas;

    /**
     * Constructor vacío del Banco, haciendo referencia al número de cuenta inicial y el tamaño máximo de cuentas que acepta el banco
     */
    public Banco() {
        this.numCuentas = 0;
        this.cuentas= new CuentaBancaria[Banco.MAX_CUENTAS];
    }

    /**
     * Esta función la hemos creado para que nos sea más sencillo buscar una cuenta por el IBAN y evitar así repetir código innecesario
     * Funciona comparando un IBAN que recibe por parámetro, con el array de cuentas para ver si el IBAN coincide en alguna de estas cuentas
     * @param iban
     * @return
     */
    private CuentaBancaria buscarCuenta(String iban) {
        for (int i = 0; i < this.numCuentas; i++) {
            if (this.cuentas[i].getIban().equals(iban)) {
                return this.cuentas[i];
            }
        }
        return null;
    }

    /**
     * Recibe por parámetro un objeto CuentaBancaria y lo almacena en la estructura. Devuelve true o false indicando si la operación se realizó con éxito.
     * @param cuenta
     * @return
     */
    public boolean abrirCuenta (CuentaBancaria cuenta){

        if (this.numCuentas >= Banco.MAX_CUENTAS) {
            System.out.println("No hay espacio para crear otra cuenta");
            return false;
        }

        CuentaBancaria existe = this.buscarCuenta(cuenta.getIban());
        if(existe != null) {
            System.out.println("La cuenta bancaria ya existe");
            return false;
        }

        this.cuentas[this.numCuentas] = cuenta;
        this.numCuentas++;
        return true;
    }

    /**
     * No recibe parámetro y devuelve un array donde cada elemento es una cadena que representa la información de una cuenta.
     * @return
     */
    public String[] listadoCuentas(){
        
        String[] infoCuentas = new String[this.numCuentas];
        for (int i = 0; i < this.numCuentas; i++) {
            infoCuentas[i] = this.cuentas[i].devolverInfoString();
        }
        return infoCuentas;
    }

    /**
     * Recibe un iban por parámetro y devuelve una cadena con la información de la cuenta o null si la cuenta no existe.
     * @param iban
     * @return
     */
    public String informacionCuenta(String iban) {

        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta != null) {
            return cuenta.devolverInfoString();
        }
        return null;
    }

    /**
     * recibe un iban por parámetro y una cantidad e ingresa la cantidad en la cuenta. Devuelve true o false indicando si la operación se realizó con éxito.
     * @param iban
     * @param cantidad
     * @return
     */
    public boolean ingresoCuenta(String iban, double cantidad) {

        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta != null) {
            cuenta.setSaldoActual(cuenta.getSaldoActual() + cantidad);
            return true;
        }
        return false;
    }

    /**
     * Recibe un iban por parámetro y una cantidad y trata de retirar la cantidad de la cuenta. Devuelve true o false indicando si la operación se realizó con éxito.
     * @param iban
     * @param cantidad
     * @return
     */
    public boolean retiradaCuenta(String iban, double cantidad) {

        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta != null) {

            boolean sePuedeRetirar = false;
            
            if (cuenta.getSaldoActual() - cantidad > 0) {
                sePuedeRetirar = true;
            }else if(cuenta instanceof CuentaCorrienteEmpresa){
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)cuenta;
                if(Math.abs(cuenta.getSaldoActual() - cantidad) < aux.getMaximoDescubierto()){
                    sePuedeRetirar = true;
                }
            }
            
            if(sePuedeRetirar){
                cuenta.setSaldoActual(cuenta.getSaldoActual() - cantidad);
            }
            
            return sePuedeRetirar;
        }
        return false;
    }

    /**
     * Recibe un iban por parámetro y devuelve el saldo de la cuenta si existe. En caso contrario devuelve -1.
     * @param iban
     * @return
     */
    public double obtenerSaldo(String iban) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta != null) {
            return cuenta.getSaldoActual();
        }
        return -1;
    }
}