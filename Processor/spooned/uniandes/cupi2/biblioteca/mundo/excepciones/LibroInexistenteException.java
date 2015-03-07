package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepción lanzada cuando se referencia un libro inexistente.
 */
public class LibroInexistenteException extends java.lang.Exception {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = -3643531559677936939L;
    
    /** 
     * Constructor de la excepción.
     * @param referencia Referencia del libro inexistente.
     */
    public LibroInexistenteException(java.lang.String referencia) {
        super(("No existe ningún libro con la referencia: " + referencia));
    }
    
}

