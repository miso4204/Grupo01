package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel que permite agregar libros.
 */
public class PanelAccionAgregarLibro extends javax.swing.JPanel implements java.awt.event.ActionListener {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Constante para insertar una copia con los datos dados.
     */
    private static final java.lang.String AGREGAR_COPIA = "Agregar copia";
    
    /** 
     * Ingreso de un nuevo libro.
     */
    private static final java.lang.String AGREGAR_LIBRO = "Agregar libro";
    
    /** 
     * Constante para el botón Cancelar.
     */
    private static final java.lang.String CANCELAR = "Cancelar";
    
    /** 
     * Interfaz principal de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal;
    
    /** 
     * Label "Referencia".
     */
    private javax.swing.JLabel labelReferencia;
    
    /** 
     * Cuadro de texto de referencia.
     */
    private javax.swing.JTextField textoReferencia;
    
    /** 
     * Panel contenedor. Donde están todos los elementos.
     */
    private javax.swing.JPanel panelContenedor;
    
    /** 
     * Etiqueta "Título"
     */
    private javax.swing.JLabel labelTitulo;
    
    /** 
     * Cuadro de texto donde se ingresa el título.
     */
    private javax.swing.JTextField textoTitulo;
    
    /** 
     * Etiqueta autores.
     */
    private javax.swing.JLabel labelAutores;
    
    /** 
     * Cuadro de texto donde se ingresa el autor 1.
     */
    private javax.swing.JTextField textoAutor1;
    
    /** 
     * Cuadro de texto donde se ingresa el autor 2.
     */
    private javax.swing.JTextField textoAutor2;
    
    /** 
     * Cuadro de texto donde se ingresa el autor 3.
     */
    private javax.swing.JTextField textoAutor3;
    
    /** 
     * Etiqueta "Descriptores".
     */
    private javax.swing.JLabel labelDescriptores;
    
    /** 
     * Cuadro de texto donde se ingresa el descriptor 1.
     */
    private javax.swing.JTextField textoDescriptores1;
    
    /** 
     * Cuadro de texto donde se ingresa el descriptor 2.
     */
    private javax.swing.JTextField textoDescriptores2;
    
    /** 
     * Cuadro de texto donde se ingresa el descriptor 3.
     */
    private javax.swing.JTextField textoDescriptores3;
    
    /** 
     * Cuadro de texto donde se ingresa el descriptor 4.
     */
    private javax.swing.JTextField textoDescriptores4;
    
    /** 
     * Botón para agregar una nueva copia.
     */
    private javax.swing.JButton botonAgregarCopia;
    
    /** 
     * Botón para agregar un nuevo libro.
     */
    private javax.swing.JButton botonAgregarLibroNuevo;
    
    /** 
     * Botón para cancelar.
     */
    private javax.swing.JButton botonCancelar;
    
    /** 
     * Constructor de panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     */
    public PanelAccionAgregarLibro(uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca nPrincipal) {
        principal = nPrincipal;
        java.awt.GridBagConstraints gridBagConstraints31 = new java.awt.GridBagConstraints();
        gridBagConstraints31.gridx = 1;
        gridBagConstraints31.gridy = 1;
        labelAutores = new javax.swing.JLabel();
        labelAutores.setText("Autores:");
        java.awt.GridBagConstraints gridBagConstraints11 = new java.awt.GridBagConstraints();
        gridBagConstraints11.gridx = 0;
        gridBagConstraints11.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints11.gridwidth = 2;
        gridBagConstraints11.insets = new java.awt.Insets(40 , 6 , 0 , 6);
        gridBagConstraints11.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.insets = new java.awt.Insets(0 , 0 , 0 , 10);
        gridBagConstraints1.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0 , 15 , 0 , 0);
        gridBagConstraints.gridy = 0;
        labelReferencia = new javax.swing.JLabel();
        labelReferencia.setText("Referencia:");
        setSize(244 ,320);
        setLayout(new java.awt.GridBagLayout());
        setBorder(javax.swing.BorderFactory.createTitledBorder(null ,"Agregar Libro" ,javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION ,javax.swing.border.TitledBorder.DEFAULT_POSITION ,new java.awt.Font("Dialog" , java.awt.Font.BOLD , 12) ,new java.awt.Color(51 , 51 , 51)));
        setOpaque(false);
        add(labelReferencia ,gridBagConstraints);
        textoReferencia = new javax.swing.JTextField();
        add(textoReferencia ,gridBagConstraints1);
        armarPanelContenedor();
        add(panelContenedor ,gridBagConstraints11);
        botonAgregarCopia = new javax.swing.JButton();
        botonAgregarCopia.setText("Agregar");
        botonAgregarCopia.addActionListener(this);
        botonAgregarCopia.setActionCommand(AGREGAR_COPIA);
        add(botonAgregarCopia ,gridBagConstraints31);
    }
    
    /** 
     * Arma el panel que contiene los elementos.
     */
    private void armarPanelContenedor() {
        java.awt.GridBagConstraints gridBagConstraints15 = new java.awt.GridBagConstraints();
        gridBagConstraints15.gridx = 2;
        gridBagConstraints15.gridy = 8;
        java.awt.GridBagConstraints gridBagConstraints14 = new java.awt.GridBagConstraints();
        gridBagConstraints14.gridx = 1;
        gridBagConstraints14.gridy = 8;
        java.awt.GridBagConstraints gridBagConstraints13 = new java.awt.GridBagConstraints();
        gridBagConstraints13.fill = java.awt.GridBagConstraints.HORIZONTAL;
        java.awt.GridBagConstraints gridBagConstraints12 = new java.awt.GridBagConstraints();
        gridBagConstraints12.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints12.gridy = 7;
        gridBagConstraints12.weightx = 1.0;
        gridBagConstraints12.gridwidth = 2;
        gridBagConstraints12.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints10 = new java.awt.GridBagConstraints();
        gridBagConstraints10.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints10.gridy = 6;
        gridBagConstraints10.weightx = 1.0;
        gridBagConstraints10.gridwidth = 2;
        gridBagConstraints10.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints9 = new java.awt.GridBagConstraints();
        gridBagConstraints9.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints9.gridy = 5;
        gridBagConstraints9.weightx = 1.0;
        gridBagConstraints9.gridwidth = 2;
        gridBagConstraints9.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints8 = new java.awt.GridBagConstraints();
        gridBagConstraints8.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints8.gridy = 4;
        gridBagConstraints8.weightx = 1.0;
        gridBagConstraints8.gridwidth = 2;
        gridBagConstraints8.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints7 = new java.awt.GridBagConstraints();
        gridBagConstraints7.gridx = 0;
        gridBagConstraints7.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints7.gridy = 4;
        labelDescriptores = new javax.swing.JLabel();
        labelDescriptores.setText("Descriptores");
        java.awt.GridBagConstraints gridBagConstraints6 = new java.awt.GridBagConstraints();
        gridBagConstraints6.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints6.gridy = 3;
        gridBagConstraints6.weightx = 1.0;
        gridBagConstraints6.gridwidth = 2;
        gridBagConstraints6.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints5 = new java.awt.GridBagConstraints();
        gridBagConstraints5.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints5.gridy = 2;
        gridBagConstraints5.weightx = 1.0;
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints4 = new java.awt.GridBagConstraints();
        gridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints4.gridy = 1;
        gridBagConstraints4.weightx = 1.0;
        gridBagConstraints4.gridwidth = 2;
        gridBagConstraints4.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints3 = new java.awt.GridBagConstraints();
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints3.gridy = 1;
        java.awt.GridBagConstraints gridBagConstraints2 = new java.awt.GridBagConstraints();
        gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 0;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.gridwidth = 2;
        gridBagConstraints2.gridx = 1;
        labelTitulo = new javax.swing.JLabel();
        labelTitulo.setText("Titulo:");
        panelContenedor = new javax.swing.JPanel();
        panelContenedor.setLayout(new java.awt.GridBagLayout());
        panelContenedor.setOpaque(false);
        panelContenedor.setVisible(false);
        panelContenedor.add(labelTitulo ,gridBagConstraints13);
        textoTitulo = new javax.swing.JTextField();
        panelContenedor.add(textoTitulo ,gridBagConstraints2);
        panelContenedor.add(labelAutores ,gridBagConstraints3);
        textoAutor1 = new javax.swing.JTextField();
        panelContenedor.add(textoAutor1 ,gridBagConstraints4);
        textoAutor2 = new javax.swing.JTextField();
        panelContenedor.add(textoAutor2 ,gridBagConstraints5);
        textoAutor3 = new javax.swing.JTextField();
        panelContenedor.add(textoAutor3 ,gridBagConstraints6);
        panelContenedor.add(labelDescriptores ,gridBagConstraints7);
        textoDescriptores1 = new javax.swing.JTextField();
        panelContenedor.add(textoDescriptores1 ,gridBagConstraints8);
        textoDescriptores2 = new javax.swing.JTextField();
        panelContenedor.add(textoDescriptores2 ,gridBagConstraints9);
        textoDescriptores3 = new javax.swing.JTextField();
        panelContenedor.add(textoDescriptores3 ,gridBagConstraints10);
        textoDescriptores4 = new javax.swing.JTextField();
        panelContenedor.add(textoDescriptores4 ,gridBagConstraints12);
        botonAgregarLibroNuevo = new javax.swing.JButton();
        botonAgregarLibroNuevo.setText("Agregar");
        botonAgregarLibroNuevo.setFont(new java.awt.Font("Dialog" , java.awt.Font.BOLD , 8));
        botonAgregarLibroNuevo.addActionListener(this);
        botonAgregarLibroNuevo.setActionCommand(AGREGAR_LIBRO);
        panelContenedor.add(botonAgregarLibroNuevo ,gridBagConstraints14);
        botonCancelar = new javax.swing.JButton();
        botonCancelar.setText("Cancelar");
        botonCancelar.setFont(new java.awt.Font("Dialog" , java.awt.Font.BOLD , 8));
        botonCancelar.addActionListener(this);
        botonCancelar.setActionCommand(CANCELAR);
        panelContenedor.add(botonCancelar ,gridBagConstraints15);
    }
    
    /** 
     * Manejo de eventos sobre los elementos del panel.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equals(AGREGAR_COPIA)) {
            if (textoReferencia.getText().equals(""))
                javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese la referencia" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
            else {
                try {
                    principal.insertarCopiaLibro(textoReferencia.getText());
                    textoReferencia.setText("");
                } catch (uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException e1) {
                    int respuesta = javax.swing.JOptionPane.showConfirmDialog(principal ,(("El libro con la referencia " + (textoReferencia.getText())) + " no existe.\n¿Quiere ingresar un libro con esa referencia?") ,"Error" ,javax.swing.JOptionPane.YES_NO_OPTION);
                    if (respuesta == (javax.swing.JOptionPane.YES_OPTION)) {
                        panelContenedor.setVisible(true);
                        botonAgregarCopia.setEnabled(false);
                        textoReferencia.setEditable(false);
                    } 
                }
            }
        } 
        if (e.getActionCommand().equals(AGREGAR_LIBRO))
            accionBotonInsertarNuevoLibro();
        
        if (e.getActionCommand().equals(CANCELAR)) {
            panelContenedor.setVisible(false);
            botonAgregarCopia.setEnabled(true);
            textoReferencia.setEditable(true);
            textoReferencia.setText("");
            textoTitulo.setText("");
            textoAutor1.setText("");
            textoAutor2.setText("");
            textoAutor3.setText("");
            textoDescriptores1.setText("");
            textoDescriptores2.setText("");
            textoDescriptores3.setText("");
            textoDescriptores4.setText("");
        } 
    }
    
    /** 
     * Acción que se ejecuta cuando se ingresa un nuevo libro o copia.
     */
    private void accionBotonInsertarNuevoLibro() {
        if (textoTitulo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese el título" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
            return ;
        } 
        if (((textoAutor1.getText().equals("")) && (textoAutor2.getText().equals(""))) && (textoAutor3.getText().equals(""))) {
            javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese al menos un autor" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
            return ;
        } 
        if ((((textoDescriptores1.getText().equals("")) && (textoDescriptores2.getText().equals(""))) && (textoDescriptores3.getText().equals(""))) && (textoDescriptores4.getText().equals(""))) {
            javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese al menos un descriptor" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
            return ;
        } 
        int contador = 0;
        if (!(textoAutor1.getText().equals("")))
            contador++;
        
        if (!(textoAutor2.getText().equals("")))
            contador++;
        
        if (!(textoAutor3.getText().equals("")))
            contador++;
        
        java.lang.String[] autores = new java.lang.String[contador];
        contador = 0;
        if (!(textoAutor1.getText().equals(""))) {
            autores[contador] = textoAutor1.getText();
            contador++;
        } 
        if (!(textoAutor2.getText().equals(""))) {
            autores[contador] = textoAutor2.getText();
            contador++;
        } 
        if (!(textoAutor3.getText().equals("")))
            autores[contador] = textoAutor3.getText();
        
        contador = 0;
        if (!(textoDescriptores1.getText().equals("")))
            contador++;
        
        if (!(textoDescriptores2.getText().equals("")))
            contador++;
        
        if (!(textoDescriptores3.getText().equals("")))
            contador++;
        
        if (!(textoDescriptores4.getText().equals("")))
            contador++;
        
        java.lang.String[] descriptores = new java.lang.String[contador];
        contador = 0;
        if (!(textoDescriptores1.getText().equals(""))) {
            descriptores[contador] = textoDescriptores1.getText();
            contador++;
        } 
        if (!(textoDescriptores2.getText().equals(""))) {
            descriptores[contador] = textoDescriptores2.getText();
            contador++;
        } 
        if (!(textoDescriptores3.getText().equals(""))) {
            descriptores[contador] = textoDescriptores3.getText();
            contador++;
        } 
        if (!(textoDescriptores4.getText().equals("")))
            descriptores[contador] = textoDescriptores4.getText();
        
        principal.insertarLibro(textoTitulo.getText() ,autores ,descriptores ,textoReferencia.getText());
        panelContenedor.setVisible(false);
        botonAgregarCopia.setEnabled(true);
        textoReferencia.setEditable(true);
        textoReferencia.setText("");
        textoTitulo.setText("");
        textoAutor1.setText("");
        textoAutor2.setText("");
        textoAutor3.setText("");
        textoDescriptores1.setText("");
        textoDescriptores2.setText("");
        textoDescriptores3.setText("");
        textoDescriptores4.setText("");
    }
    
}

