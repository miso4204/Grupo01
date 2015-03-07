package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel de control de la aplicación.
 */
public class PanelAccionesContenedora extends javax.swing.JPanel {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Interfaz principal de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal;
    
    /** 
     * Panel donde se hacen las principales acciones que tienen que ver con el manejo de usuario de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.PanelAcciones panelAcciones;
    
    /** 
     * Panel donde se hacen las principales acciones que tienen que ver con el manejo de libros de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.PanelAccionesUsuario panelAccionesUsuario;
    
    /** 
     * Layout del panel.
     */
    private java.awt.CardLayout cartas;
    
    /** 
     * Constructor por defecto del panel.
     */
    public PanelAccionesContenedora(uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca laInterfaz) {
        principal = laInterfaz;
        setSize(244 ,378);
        cartas = new java.awt.CardLayout();
        setLayout(cartas);
        setPreferredSize(new java.awt.Dimension(244 , 378));
        setMaximumSize(new java.awt.Dimension(244 , 378));
        setMinimumSize(new java.awt.Dimension(244 , 378));
        panelAcciones = new uniandes.cupi2.biblioteca.interfaz.PanelAcciones(principal);
        panelAcciones.setName("panelAcciones");
        add(panelAcciones ,"ACCIONES");
    }
    
    /** 
     * Acción que se hace después de la autenticación. Se cambia el panel de las acciones que manejan usuario por las acciones que manejan libros.
     * @param nombre Nombre del usuario que se autenticó.
     * @param biblioteca Biblioteca.
     * @param total Número total de libros.
     * @param prestados Número total de libros que están en préstamo.
     */
    public void login(java.lang.String nombre, uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca biblioteca, int total, int prestados) {
        panelAccionesUsuario = new uniandes.cupi2.biblioteca.interfaz.PanelAccionesUsuario(principal , nombre , total , prestados , biblioteca);
        add(panelAccionesUsuario ,"USUARIO");
        cartas.show(this ,"USUARIO");
    }
    
    /** 
     * Acción que se hace después hacer log out. Se cambia el panel de las acciones que manejan libros por las acciones que manejan usuarios.
     */
    public void salir() {
        cartas.show(this ,"ACCIONES");
    }
    
}

