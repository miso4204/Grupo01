package uniandes.cupi2.biblioteca.mundo;


/** 
 * Interface que modela el comportamiento de un usuario.
 */
@annotation.Feature(featureName = "GestionDeUsuarios", featureType = annotation.FeatureType.AND, parentName = "Biblioteca")
public interface IUsuario {
    /** 
     * Registra un préstamo de libro.
     * @param libro El libro a alquilar - libro != null.
     */
    public void alquilar(uniandes.cupi2.biblioteca.mundo.ILibro libro);
    /** 
     * Registra la devolución de un libro que estaba prestado.<br>
     * <b>pre: </b>El usuario tiene prestado el libro ingresado.
     * @param libro El libro a devolver - libro != null.
     */
    public void devolver(uniandes.cupi2.biblioteca.mundo.ILibro libro);
    /** 
     * Retorna el nombre del usuario.
     * @return El nombre del usuario.
     */
    public java.lang.String darNombre();
    /** 
     * Retorna el login del usuario.
     * @return El login del usuario.
     */
    public java.lang.String darLogin();
    /** 
     * Retorna la clave del usuario.
     * @return La clave del usuario.
     */
    public java.lang.String darClave();
    /** 
     * Retorna las libros alquilados por el usuario.
     * @return Los libros alquilados por el usuario.
     */
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  darLibrosAlquilados();
    /** 
     * Asigna la lista de los libros alquilados.
     * @param nLibrosAlquilados Lista de libros alquilados.
     */
    public void asignarLibrosAlquilados(uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  nLibrosAlquilados);
}

