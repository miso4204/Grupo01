package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepción lanzada cuando se intenta prestar un libro que no tiene copias disponibles.
 */
public class CopiasInsuficientesException extends java.lang.Exception {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = -3638303840577988228L;
    
    /** 
     * Constructor de la excepción.
     * @param libro Libro que generó el error de préstamo.
     */
    public CopiasInsuficientesException(uniandes.cupi2.biblioteca.mundo.implementacion1.Libro libro) {
        super((("El libro " + (libro.darTitulo())) + " no tiene copias disponibles"));
    }
    
}

