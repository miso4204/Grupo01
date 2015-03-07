package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepción lanzada cuando se intenta ingresar un usuario preexistente.
 */
public class UsuarioPreexistenteException extends java.lang.Exception {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 9070209798852432330L;
    
    /** 
     * Constructor de la excepción.
     * @param usuario Usuario preexistente que se intentó ingresar.
     */
    public UsuarioPreexistenteException(uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario usuario) {
        super((("El usuario identificado por el login: " + (usuario.darLogin())) + " ya existe en el sistema"));
    }
    
}

