package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepción lanzada cuando se presenta algún error al cargar la información de la biblioteca.
 */
public class CargarBibliotecaException extends java.lang.Exception {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 354958047650021157L;
    
    /** 
     * Constructor de la excepción.
     * @param mensaje Mensaje de la excepción.
     */
    public CargarBibliotecaException(java.lang.String mensaje) {
        super(mensaje);
    }
    
}

