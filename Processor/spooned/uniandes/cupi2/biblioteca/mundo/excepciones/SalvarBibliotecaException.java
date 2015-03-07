package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepción lanzada cuando se presenta algún error al salvar la información de la biblioteca.
 */
public class SalvarBibliotecaException extends java.lang.Exception {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = -4720386525812340814L;
    
    /** 
     * Constructor de la excepción.
     * @param mensaje Mensaje de la excepción.
     */
    public SalvarBibliotecaException(java.lang.String mensaje) {
        super(mensaje);
    }
    
}

