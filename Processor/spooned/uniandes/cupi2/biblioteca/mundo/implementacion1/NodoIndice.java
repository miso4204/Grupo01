package uniandes.cupi2.biblioteca.mundo.implementacion1;


/** 
 * Clase usada para indexar los libros.
 */
public class NodoIndice implements java.lang.Comparable<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice> {
    /** 
     * Llave del nodo.
     */
    private java.lang.String llave;
    
    /** 
     * Lista de libros que están identificados con la llave del nodo.
     */
    private uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  libros;
    
    /** 
     * Constructor del nodo.
     * @param nLlave Llave del nodo.
     */
    public NodoIndice(java.lang.String nLlave) {
        llave = nLlave;
        libros = new uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro> ();
    }
    
    /** 
     * Retorna la llave del nodo.
     * @return la llave del nodo.
     */
    public java.lang.String darLlave() {
        return llave;
    }
    
    /** 
     * Método donde se comparan las llaves de los nodos.
     * @param nodo Nodo con la llave que se quiere comparar.
     */
    public int compareTo(uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice nodo) {
        java.lang.String llave = ((uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice)(nodo)).darLlave();
        return this.llave.compareTo(((java.lang.String)(llave)));
    }
    
    /** 
     * Agrega un libro al nodo.
     * @param libro Libro que se va a agregar al nodo - libro != null.
     */
    public void agregarLibro(uniandes.cupi2.biblioteca.mundo.ILibro libro) {
        libros.agregar(libro);
    }
    
    /** 
     * Retorna los libros del nodo.
     * @return Los libros del nodo.
     */
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  darLibros() {
        return libros.darIterador();
    }
    
}

