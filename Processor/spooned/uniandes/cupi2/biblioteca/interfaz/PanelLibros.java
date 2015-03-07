package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel donde se muestra los resultados de una búsqueda.
 */
public class PanelLibros extends javax.swing.JPanel {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Interfaz principal de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal;
    
    /** 
     * Login del usuario.
     */
    private java.lang.String loginUsuario;
    
    /** 
     * Panel donde se ubican los libros después de la consulta.
     */
    private javax.swing.JPanel panelCentral;
    
    /** 
     * Label donde se muestran los resultados.
     */
    private javax.swing.JLabel labelMostrarResultados;
    
    /** 
     * Scroll donde se ubican los resultados de las búsquedas.
     */
    private javax.swing.JScrollPane scroll;
    
    /** 
     * Layout del panel.
     */
    private java.awt.GridLayout layout;
    
    /** 
     * Constructor del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     */
    public PanelLibros(uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca nPrincipal) {
        principal = nPrincipal;
        setLayout(new java.awt.BorderLayout());
        panelCentral = new javax.swing.JPanel();
        panelCentral.setAlignmentX(0.0F);
        panelCentral.setBackground(java.awt.Color.white);
        panelCentral.setAlignmentY(0.0F);
        layout = new java.awt.GridLayout();
        panelCentral.setLayout(layout);
        scroll = new javax.swing.JScrollPane();
        scroll.setSize(530 ,572);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new java.awt.Dimension(530 , 572));
        scroll.setViewportView(panelCentral);
        add(scroll ,java.awt.BorderLayout.CENTER);
    }
    
    /** 
     * Cambia el login del usuario.
     * @param nLoginUsuario Nuevo login del usuario.
     */
    public void cambiarUsuario(java.lang.String nLoginUsuario) {
        if ((loginUsuario) == null) {
            loginUsuario = nLoginUsuario;
            return ;
        } 
        loginUsuario = nLoginUsuario;
    }
    
    /** 
     * Agrega al panel labels importantes para que se pueda mostrar correctamente los resultados de las búsquedas.
     */
    public void anhanirLabeles() {
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.insets = new java.awt.Insets(0 , 34 , 0 , 0);
        gridBagConstraints1.gridy = 0;
        labelMostrarResultados = new javax.swing.JLabel();
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelCentral.add(labelMostrarResultados);
    }
    
    /** 
     * A partir de un iterador de libros actualiza los resultados de un búsqueda donde se pueden alquilar libros.
     * @param libros Iterador que apunta al primer libro del resultado de la búsqueda
     */
    public void actualizarListaBusqueda(uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros) {
        panelCentral.removeAll();
        anhanirLabeles();
        int i = 0;
        if (libros != null) {
            while (libros.haySiguiente()) {
                uniandes.cupi2.biblioteca.mundo.ILibro libro = libros.darSiguiente();
                panelCentral.add(new uniandes.cupi2.biblioteca.interfaz.PanelLibro(libro , principal));
                i++;
            }
            if (i <= 5)
                layout.setRows(7);
            else {
                layout.setRows((i + 2));
                panelCentral.setSize(511 ,(i * 146));
            }
            for (int j = i + 2 ; j < 6 ; j++) {
                javax.swing.JPanel panel = new javax.swing.JPanel();
                panel.setBackground(java.awt.Color.WHITE);
                panelCentral.add(panel);
            }
            labelMostrarResultados.setText(("Resultados de la búsqueda: " + i));
            panelCentral.repaint();
        } 
    }
    
    /** 
     * A partir de un iterador de libros actualiza los resultados de un búsqueda donde se pueden devolver libros.
     * @param libros Iterador que apunta al primer libro del resultado de la búsqueda.
     */
    public void actualizarListaAlquilados(uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros) {
        panelCentral.removeAll();
        anhanirLabeles();
        int i = 0;
        if (libros != null) {
            while (libros.haySiguiente()) {
                uniandes.cupi2.biblioteca.mundo.ILibro libro = libros.darSiguiente();
                panelCentral.add(new uniandes.cupi2.biblioteca.interfaz.PanelLibroAlquilado(libro , principal));
                i++;
            }
            if (i <= 5)
                layout.setRows(7);
            else {
                layout.setRows((i + 2));
                panelCentral.setSize(511 ,(i * 146));
            }
            for (int j = i + 2 ; j < 6 ; j++) {
                javax.swing.JPanel panel = new javax.swing.JPanel();
                panel.setBackground(java.awt.Color.WHITE);
                panelCentral.add(panel);
            }
            labelMostrarResultados.setText(("Resultados de la búsqueda: " + i));
            panelCentral.repaint();
        } 
    }
    
}

