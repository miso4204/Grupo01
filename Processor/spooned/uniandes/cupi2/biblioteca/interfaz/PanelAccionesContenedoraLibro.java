package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel donde se ponen las acciones con los libros.
 */
public class PanelAccionesContenedoraLibro extends javax.swing.JPanel {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Panel donde se agrega un libro.
     */
    private uniandes.cupi2.biblioteca.interfaz.PanelAccionAgregarLibro panelAccionAgregarLibro;
    
    /** 
     * Layout del panel.
     */
    private java.awt.CardLayout cartas;
    
    /** 
     * Interfaz principal de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal;
    
    /** 
     * Constructor por defecto del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     */
    public PanelAccionesContenedoraLibro(uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca nPrincipal) {
        principal = nPrincipal;
        setSize(244 ,320);
        setMinimumSize(new java.awt.Dimension(244 , 320));
        setMaximumSize(new java.awt.Dimension(244 , 320));
        setPreferredSize(new java.awt.Dimension(244 , 320));
        cartas = new java.awt.CardLayout();
        setLayout(cartas);
        setBackground(new java.awt.Color(255 , 255 , 214));
        panelAccionAgregarLibro = new uniandes.cupi2.biblioteca.interfaz.PanelAccionAgregarLibro(principal);
        panelAccionAgregarLibro.setName("accionAgregarLibro");
        add(panelAccionAgregarLibro ,panelAccionAgregarLibro.getName());
    }
    
    /** 
     * Permita cambiar la ventana según la acción que se va hacer.
     * @param accion Acción que se va realizar.
     */
    public void cambiarVentana(java.lang.String accion) {
        if (accion.equals("BUSCAR")) {
            uniandes.cupi2.biblioteca.interfaz.PanelAccionBuscarLibro abl = new uniandes.cupi2.biblioteca.interfaz.PanelAccionBuscarLibro(principal);
            add(abl ,"Buscar");
            cartas.show(this ,"Buscar");
        } else if (accion.equals("AGREGAR")) {
            uniandes.cupi2.biblioteca.interfaz.PanelAccionAgregarLibro abl = new uniandes.cupi2.biblioteca.interfaz.PanelAccionAgregarLibro(principal);
            add(abl ,"accionAgregarLibro");
            cartas.show(this ,"accionAgregarLibro");
        } else if (accion.equals("BLANCO")) {
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setOpaque(false);
            add(panel ,"blanco");
            cartas.show(this ,"blanco");
        } 
    }
    
}

