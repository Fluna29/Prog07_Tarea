package franluna.prog07_tarea;

import java.util.Scanner;
import franluna.prog07_tarea.validadores.Validadores;

/**
 *
 * @author Francisco Luna Raya
 */
public class Principal {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int eleccion;
        do {
            menu();
            System.out.println("\nIntroduzca un número acorde al menú (1-7) ");
            eleccion = scanner.nextInt();
            if (0 < eleccion && eleccion < 8) {
                switch (eleccion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
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

    public static void crearCuenta(){
        int eleccion;
        
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
            try {
                Validadores.validadorDni(dni);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                dniValido = true;
            }
        } while (!dniValido);

        do {
            System.out.println("\nSeleccione el tipo de cuenta que desee crear: (1-3)");
            System.out.println(" 1. Cuenta de Ahorro");
            System.out.println(" 2. Cuenta Corriente Personal");
            System.out.println(" 3. Cuenta Corriente de Empresa");
            eleccion = scanner.nextInt();

            if (0 > eleccion && eleccion > 4) {
                System.out.println("\nDebe de introducir un valor acorde al menú (1-3)");
                scanner.nextLine();
            }
        } while (0 < eleccion && eleccion < 4);
        switch (eleccion) {
            case 1:
                
                break;
            case 2:

                break;

            case 3:

                break;
            default:
            
                break;
        }
    }
    
}