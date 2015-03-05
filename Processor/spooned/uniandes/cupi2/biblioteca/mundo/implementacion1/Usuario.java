package uniandes.cupi2.biblioteca.mundo.implementacion1;


/** 
 * Clase que representa al usuario.
 */
public class Usuario implements java.io.Serializable , uniandes.cupi2.biblioteca.mundo.IUsuario {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = -7920037289310482998L;
    
    /** 
     * Nombre del usuario.
     */
    private java.lang.String nombre;
    
    /** 
     * Clave del usuario.
     */
    private java.lang.String clave;
    
    /** 
     * Login del usuario.
     */
    private java.lang.String login;
    
    /** 
     * Libros alquilados por el usuario.
     */
    private uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  librosAlquilados;
    
    /** 
     * Construye un nuevo usuario.
     * @param login Login del usuario - login != null.
     * @param clave Clave del usuario - clave != null.
     * @param nombre Nombre del usuario - nombre != null.
     */
    public Usuario(java.lang.String login ,java.lang.String clave ,java.lang.String nombre) {
        this.nombre = nombre;
        this.clave = clave;
        this.login = login;
        librosAlquilados = new uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro> ();
    }
    
    public void alquilar(uniandes.cupi2.biblioteca.mundo.ILibro libro) {
        librosAlquilados.agregar(libro);
    }
    
    public void devolver(uniandes.cupi2.biblioteca.mundo.ILibro libro) {
        librosAlquilados.eliminar(libro);
    }
    
    public java.lang.String darNombre() {
        return nombre;
    }
    
    public java.lang.String darLogin() {
        return login;
    }
    
    public java.lang.String darClave() {
        return clave;
    }
    
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  darLibrosAlquilados() {
        return librosAlquilados.darIterador();
    }
    
    public void asignarLibrosAlquilados(uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  nLibrosAlquilados) {
        librosAlquilados = nLibrosAlquilados;
    }
    
}

