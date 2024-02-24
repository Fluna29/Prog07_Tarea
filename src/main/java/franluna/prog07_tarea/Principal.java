package franluna.prog07_tarea;

import java.util.Scanner;
import franluna.prog07_tarea.validadores.Validadores;

/**
 * En esta clase introducimos el método main y todo el código de interacción con el usuario
 * (lectura de teclado y salida por pantalla)
 * @author Francisco Luna Raya
 */
public class Principal {

    static Scanner scanner = new Scanner(System.in);
    static Banco banco = new Banco();
    static CuentaBancaria cuenta = null;

    static String dni;
    static String iban;

    /**
     * Función main que ejecuta el gestor de cuentas de banco
     * @param args
     */
    public static void main(String[] args) {

        int eleccion;

        do {
            menu();

            System.out.println("\nIntroduzca un número acorde al menú (1-7) ");
            
            eleccion = scanner.nextInt();
            if (0 < eleccion && eleccion < 8) {
                switch (eleccion) {
                    case 1:
                        crearCuenta();
                        scanner.nextLine();
                        break;
                    case 2:
                        listarCuentas();
                        scanner.nextLine();
                        break;
                    case 3:
                        datosCuenta();
                        scanner.nextLine();
                        break;
                    case 4:
                        ingresoSaldo();
                        scanner.nextLine();
                        break;
                    case 5:
                        retiradaSaldo();
                        scanner.nextLine();
                        break;
                    case 6:
                        consultarSaldo();
                        scanner.nextLine();
                        break;
                    case 7:
                        System.out.println("\nHasta la próxima");
                        break;
                    default:
                        System.out.println("\nERROR");
                        break;
                }
            }else{
                System.out.println("\nDebe introducir un número acorde al menú (1-7)");
                scanner.nextLine();
            }
        } while (eleccion != 7);
    }
    
    /**
     * Esta función devuelve el texto del menú visual
     */
    public static void menu(){

        System.out.println("\n====MENÚ PRINCIPAL====");
        System.out.println(" 1. Abrir una nueva cuenta");
        System.out.println(" 2. Ver un listado de las cuentas disponibles");
        System.out.println(" 3. Obtener los datos de una cuenta concreta");
        System.out.println(" 4. Realizar un ingreso en una cuenta");
        System.out.println(" 5. Retirar efectivo de una cuenta");
        System.out.println(" 6. Consultar el saldo actual de una cuenta");
        System.out.println(" 7. Salir de la aplicación");
    }

    /**
     * Esta función corresponde a la selección 1, y sirve para poder abrir una cuenta
     * Nos retorna un mensaje diciendo si se ha podido crear o no la cuenta
     */
    public static void crearCuenta(){

        System.out.println("\n====CREAR NUEVA CUENTA====");

        System.out.println("\nIntroduzca el nombre del cliente: ");
        String nombre = scanner.nextLine();
        scanner.nextLine();

        System.out.println("\nIntroduzca los apellidos del cliente: ");
        String apellidos = scanner.nextLine();
        scanner.nextLine();

        boolean dniValido = false;
        do {
            System.out.println("\nIntroduzca el DNI del cliente: ");
            String dni = scanner.nextLine();
            scanner.nextLine();
            try {
                Validadores.validadorDni(dni);
                dniValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!dniValido);

        Persona titular = new Persona(nombre, apellidos, dni);

        boolean ibanValido = false;
        do {
            System.out.println("\nIntroduzca el IBAN de su cuenta bancaria: ");
            iban = scanner.nextLine();
            scanner.nextLine();
            try {
                Validadores.validadorIban(iban);
                ibanValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!ibanValido);

        System.out.println("\nIntroduzca el Saldo Inicial: ");
        double saldoActual = scanner.nextDouble();

        int eleccion;
        boolean eleccionValida = false;
        do {
            System.out.println("\nSeleccione el tipo de cuenta que desee crear: (1-3)");
            System.out.println(" 1. Cuenta de Ahorro");
            System.out.println(" 2. Cuenta Corriente Personal");
            System.out.println(" 3. Cuenta Corriente de Empresa");
            eleccion = scanner.nextInt();

            if (0 > eleccion && eleccion > 4) {
                System.out.println("\nDebe de introducir un valor acorde al menú (1-3)");
                scanner.nextLine();
            }else{
                eleccionValida = true;
            }
        } while (!eleccionValida);


        switch (eleccion) {
            case 1:
                System.out.println("\nIntroduzca el tipo de interés: ");
                double tipoInteresAnual = scanner.nextDouble();
                cuenta = new CuentaAhorro(tipoInteresAnual, iban, saldoActual, titular);
                break;

            case 2:
                System.out.println("\nIntroduce la comisión de mantenimiento: ");
                double comisionMantenimiento = scanner.nextDouble();
                System.out.println("\nIntroduzca una lista de entidades autorizadas: ");
                String listaEntidades = scanner.nextLine();
                scanner.nextLine();
                cuenta = new CuentaCorrientePersonal(comisionMantenimiento, listaEntidades, listaEntidades, saldoActual, titular);
                break;

            case 3:
                System.out.println("\nIntroduzca el Máximo Descubierto: ");
                double maximoDescubierto = scanner.nextDouble();
                System.out.println("\nIntroduzca el tipo de interés descubierto: ");
                double tipoInteresDescubierto = scanner.nextDouble();
                System.out.println("\nIntroduzca la comisión fija por descubierto: ");
                double comisionFijaDescubierto = scanner.nextDouble();
                System.out.println("\nIntroduzca una lista de entidades autorizadas: ");
                listaEntidades = scanner.nextLine();
                scanner.nextLine();
                cuenta = new CuentaCorrienteEmpresa(maximoDescubierto, tipoInteresDescubierto, comisionFijaDescubierto, listaEntidades, iban, saldoActual, titular);
                break;

            default:
                System.out.println("ERROR");
                break;
        }

        if (banco.abrirCuenta(cuenta)) {
            System.out.println("\nSe ha abierto la cuenta con éxito");
        }else{
            System.out.println("Ha ocurrido un error al abrir la cuenta");
        }
    }


    /**
     * Esta función corresponde a la selección 2, y sirve para obtener un listado con todas las cuentas disponibles
     * Nos retorna todas las cuentas, pero tan solo el IBAN, los titulares de la cuenta y el saldo.
     */
    public static void listarCuentas(){

        System.out.println("\n====LISTADO DE CUENTAS====");

        String[] listadoCuentas = banco.listadoCuentas();

        for (int i = 0; i < listadoCuentas.length; i++) {
            System.out.println(listadoCuentas[i]);
        }
    }
    
    /**
     * Esta función corresponde a la selección 3, y sirve para poder obtener los datos de una cuenta de la que dispongamos el IBAN
     * Nos retorna todos los datos de la cuenta
     */
    public static void datosCuenta(){

        boolean ibanValido = false;
        do {
            System.out.println("\nIntroduzca el IBAN de su cuenta bancaria: ");
            iban = scanner.nextLine();
            scanner.nextLine();

            try {
                Validadores.validadorIban(iban);
                ibanValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!ibanValido);
        
        String datosCuenta = banco.informacionCuenta(iban);

        if (datosCuenta != null) {
            System.out.println(datosCuenta);    
        } else {
            System.out.println("El IBAN no se corresponde con ninguna cuenta");
        }
    }

    /** 
     * Esta función corresponde a la selección 4, y sirve para ingresar saldo en una de las cuentas sabiendo el IBAN de esta
     * Retorna el nuevo valor del saldo de la cuenta
     */
    public static void ingresoSaldo(){

        System.out.println("\n====INGRESO DE SALDO EN CUENTA====");

        boolean ibanValido = false;
        do {
            System.out.println("\nIntroduzca el IBAN de su cuenta bancaria: ");
            iban = scanner.nextLine();
            scanner.nextLine();

            try {
                Validadores.validadorIban(iban);
                ibanValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!ibanValido);

        System.out.println("\nIntroduzca la cantidad de saldo a ingresar: ");
        double saldo = scanner.nextDouble();

        if(banco.ingresoCuenta(iban, saldo)){
            System.out.println("\nEl ingreso se realizó con exito");
        }else{
            System.out.println("\nHubo un error al realizar el ingreso de saldo");
        }
        System.out.println("\nEl nuevo saldo en la cuenta es de: " + banco.obtenerSaldo(iban) + " euros");
    }

    /**
     * Esta función corresponde a la selección 5, y sirve para retirar saldo de una de las cuentas sabiendo el IBAN de esta
     * Retorna el nuevo valor del saldo de la cuenta
     */
    public static void retiradaSaldo(){
        
        System.out.println("\n====RETIRADA DE SALDO EN CUENTA====");

        boolean ibanValido = false;
        do {
            System.out.println("\nIntroduzca el IBAN de su cuenta bancaria: ");
            iban = scanner.nextLine();
            scanner.nextLine();

            try {
                Validadores.validadorIban(iban);
                ibanValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!ibanValido);

        System.out.println("\nIntroduzca la cantidad de saldo a retirar: ");
        double saldo = scanner.nextDouble();

        if(banco.retiradaCuenta(iban, saldo)){
            System.out.println("\nLa retirada se realizó con éxito");
        }else {
            System.out.println("\nHubo un error al realizar la retirada de saldo");
        }
        System.out.println("\nEl nuevo saldo en la cuenta es de: " + banco.obtenerSaldo(iban) + " euros");
    }

    /**
     * Esta función corresponde a la selección 6, y sirve para consultar el saldo de una cuenta conociendo el IBAN de esta
     * Retorna el saldo de la cuenta en cuestión
     */
    public static void consultarSaldo(){
        
        System.out.println("\n====CONSULTA DE SALDO EN CUENTA====");

        boolean ibanValido = false;
        do {
            System.out.println("\nIntroduzca el IBAN de su cuenta bancaria: ");
            iban = scanner.nextLine();
            scanner.nextLine();

            try {
                Validadores.validadorIban(iban);
                ibanValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!ibanValido);

        System.out.println("\nEl saldo en la cuenta es de: " + banco.obtenerSaldo(iban) + " euros");
    }
}