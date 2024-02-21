
package franluna.prog07_tarea.validadores;

/**
 *  En esta clase vamos a incorporar una serie de validadores,
 * para poder evitar diferentes casos que no queremos que se den en nuestro progama.
 * @author Francisco Luna Raya
 */
public class Validadores { //Noncompliant
    
    
    /**
     * Este método devuelve un error si el DNI no tiene los parámetros indicados,
     * es decir, no tiene 8 números y 1 letra válida en mayúsculas.
     * @param dni
     */
    public static void validadorDni(String dni){

        if (!dni.matches("^\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]$")) {
            throw new IllegalArgumentException("\nEl DNI es incorrecto, el DNI debe incluir 8 números y 1 letra válida en mayúsculas.");
        }
    }

    public static void validadorIban(String iban){
        
        if(!iban.matches("^ES\\d{20}$")){
            throw new IllegalArgumentException("\nEl iban debe de contener al inicio \"ES\", seguido de 20 números");
        }
    }
}
