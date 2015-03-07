package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepción lanzada cuando se intenta ingresar un libro ya registrado.
 */
public class LibroYaExisteException extends java.lang.Exception {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 5325954900283301838L;
    
    /** 
     * Constructor de la excepción.
     * @param referencia Referencia del libro repetido.
     */
    public LibroYaExisteException(java.lang.String referencia) {
        super(("Ya existe un libro con esta referencia: " + referencia));
    }
    
}

