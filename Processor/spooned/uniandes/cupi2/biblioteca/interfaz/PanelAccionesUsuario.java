package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel en el que se manejan las acciones con el usuario.
 */
public class PanelAccionesUsuario extends javax.swing.JPanel implements java.awt.event.ActionListener , java.util.Observer {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Agregar libro.
     */
    private static final java.lang.String AGREGAR_LIBRO = "Agregar libro";
    
    /** 
     * Buscar libros.
     */
    private static final java.lang.String BUSCAR_LIBROS = "Buscar libros";
    
    /** 
     * Ver libros alquilados.
     */
    private static final java.lang.String VER_LIBROS = "Ver alquilados";
    
    /** 
     * Salir de la aplicación.
     */
    private static final java.lang.String SALIR = "Terminar sesión";
    
    /** 
     * Interfaz principal de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal;
    
    /** 
     * Combo box donde se muestran las acciones.
     */
    private javax.swing.JComboBox comboAcciones;
    
    /** 
     * Etiqueta "Acciones".
     */
    private javax.swing.JLabel labelAcciones;
    
    /** 
     * Panel acciones contenedora de las acciones del libro.
     */
    private uniandes.cupi2.biblioteca.interfaz.PanelAccionesContenedoraLibro accionesContenedora;
    
    /** 
     * Etiqueta "Total".
     */
    private javax.swing.JLabel labelTotal;
    
    /** 
     * Etiqueta donde se muestra el total de libros.
     */
    private javax.swing.JLabel labelLibrosTotal;
    
    /** 
     * Etiqueta libros prestados.
     */
    private javax.swing.JLabel labelPrestados;
    
    /** 
     * Etiqueta libros prestados.
     */
    private javax.swing.JLabel labelLibrosPrestados = null;
    
    /** 
     * Constructor del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     * @param nombre Nombre del usuario que hizo login.
     * @param total Total de libros de la biblioteca.
     * @param prestados Total de libros prestado de la biblioteca.
     * @param bibliteca Biblioteca.
     */
    public PanelAccionesUsuario(uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca nPrincipal ,java.lang.String nombre ,int total ,int prestados ,uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca bibliteca) {
        principal = nPrincipal;
        bibliteca.addObserver(this);
        java.awt.GridBagConstraints gridBagConstraints9 = new java.awt.GridBagConstraints();
        gridBagConstraints9.gridx = 1;
        gridBagConstraints9.gridy = 4;
        labelLibrosPrestados = new javax.swing.JLabel();
        labelLibrosPrestados.setText("");
        java.awt.GridBagConstraints gridBagConstraints8 = new java.awt.GridBagConstraints();
        gridBagConstraints8.gridx = 0;
        gridBagConstraints8.gridy = 4;
        labelPrestados = new javax.swing.JLabel();
        labelPrestados.setText("Total prestados:");
        java.awt.GridBagConstraints gridBagConstraints7 = new java.awt.GridBagConstraints();
        gridBagConstraints7.gridx = 1;
        gridBagConstraints7.gridy = 3;
        labelLibrosTotal = new javax.swing.JLabel();
        labelLibrosTotal.setText("");
        java.awt.GridBagConstraints gridBagConstraints6 = new java.awt.GridBagConstraints();
        gridBagConstraints6.gridx = 0;
        gridBagConstraints6.gridy = 3;
        labelTotal = new javax.swing.JLabel();
        labelTotal.setText("Total libros:");
        java.awt.GridBagConstraints gridBagConstraints5 = new java.awt.GridBagConstraints();
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints1.insets = new java.awt.Insets(0 , 10 , 0 , 0);
        gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.gridy = 0;
        labelAcciones = new javax.swing.JLabel();
        labelAcciones.setText("Acciones");
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0 , 10 , 0 , 10);
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        labelLibrosTotal.setText(("" + total));
        labelLibrosPrestados.setText(("" + prestados));
        setSize(244 ,378);
        setLayout(new java.awt.GridBagLayout());
        setBackground(new java.awt.Color(255 , 255 , 204));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null ,nombre ,javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION ,javax.swing.border.TitledBorder.DEFAULT_POSITION ,new java.awt.Font("Dialog" , java.awt.Font.BOLD , 12) ,new java.awt.Color(51 , 51 , 51)));
        setMaximumSize(new java.awt.Dimension(244 , 378));
        setMinimumSize(new java.awt.Dimension(244 , 378));
        setPreferredSize(new java.awt.Dimension(244 , 378));
        comboAcciones = new javax.swing.JComboBox();
        comboAcciones.addItem(AGREGAR_LIBRO);
        comboAcciones.addItem(BUSCAR_LIBROS);
        comboAcciones.addItem(VER_LIBROS);
        comboAcciones.addItem(SALIR);
        comboAcciones.setActionCommand("COMBO");
        comboAcciones.addActionListener(this);
        add(comboAcciones ,gridBagConstraints);
        add(labelAcciones ,gridBagConstraints1);
        accionesContenedora = new uniandes.cupi2.biblioteca.interfaz.PanelAccionesContenedoraLibro(principal);
        add(accionesContenedora ,gridBagConstraints5);
        add(labelTotal ,gridBagConstraints6);
        add(labelLibrosTotal ,gridBagConstraints7);
        add(labelPrestados ,gridBagConstraints8);
        add(labelLibrosPrestados ,gridBagConstraints9);
    }
    
    /** 
     * Método en el que se ejecuta las acciones del combo box.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (comboAcciones.getSelectedItem().equals(AGREGAR_LIBRO))
            accionesContenedora.cambiarVentana("AGREGAR");
        else if (comboAcciones.getSelectedItem().equals(BUSCAR_LIBROS))
            accionesContenedora.cambiarVentana("BUSCAR");
        else if (comboAcciones.getSelectedItem().equals(VER_LIBROS)) {
            principal.verAlquilados();
            accionesContenedora.cambiarVentana("BLANCO");
        } else if (comboAcciones.getSelectedItem().equals(SALIR))
            principal.salir();
        
    }
    
    /** 
     * Método para actualizar el panel.
     * @param observable Objeto que cambio y notifico el cambio.
     * @param objeto Objeto que viene con la actualización del panel.
     */
    public void update(java.util.Observable observable, java.lang.Object objeto) {
        if (objeto instanceof int[]) {
            int[] arreglo = ((int[])(objeto));
            labelLibrosTotal.setText(("" + (arreglo[0])));
            labelLibrosPrestados.setText(("" + (arreglo[1])));
        } 
    }
    
}

