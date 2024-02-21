package franluna.prog07_tarea;

/**
 *
 * @author Francisco Luna Raya
 */
public class Persona implements Imprimible{
    
    private String nombre;
    private String apellidos;
    private String dni;

    /**
     * Creamos un constructor vacío del objeto Persona
     */
    public Persona(){
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
    }

    /**
     * Creamos el constructor del objeto Persona
     * @param nombre
     * @param apellidos
     * @param dni
     */
    public Persona(String nombre, String apellidos, String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return String return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Creamos un override para recibir un String con el nombre, apellidos y DNI del titular de la cuenta.
     */
    @Override
    public String devolverInfoString(){
        return ("Titular Cuenta {Nombre: " + getNombre() + " | Apellidos: " + getApellidos() + " | DNI: " + getDni() + " }");
    }
}
