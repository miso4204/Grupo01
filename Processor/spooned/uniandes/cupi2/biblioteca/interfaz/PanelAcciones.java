package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel de control de la aplicación donde se pueden hacer las acciones que tienen que ver con los usuarios.
 */
public class PanelAcciones extends javax.swing.JPanel implements java.awt.event.ActionListener , java.awt.event.MouseListener {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Inserta un usuario nuevo.
     */
    private static final java.lang.String INSERTAR_USUARIO = "Insertar Usuario";
    
    /** 
     * Autentica el usuario.
     */
    private static final java.lang.String ENTRAR = "Entrar";
    
    /** 
     * Botón Cancelar.
     */
    private static final java.lang.String CANCELAR = "Cancelar";
    
    /** 
     * Etiqueta Login.
     */
    private javax.swing.JLabel labelLogin;
    
    /** 
     * Cuadro de texto donde se ingresa el nombre del usuario.
     */
    private javax.swing.JTextField textNombreUsuario;
    
    /** 
     * Etiqueta Contraseña.
     */
    private javax.swing.JLabel labelContrasenia;
    
    /** 
     * Cuadro de texto donde se ingresa la clave.
     */
    private javax.swing.JPasswordField textoContrasenia;
    
    /** 
     * Botón para la acción de autenticación.
     */
    private javax.swing.JButton botonEntrar;
    
    /** 
     * Etiqueta donde para registrarse.
     */
    private javax.swing.JLabel labelRegistrarse;
    
    /** 
     * Etiqueta Nuevo Usuario.
     */
    private javax.swing.JLabel labelUsuarioNuevo;
    
    /** 
     * Etiqueta Contraseña.
     */
    private javax.swing.JLabel labelContraseniaNueva;
    
    /** 
     * Etiqueta donde se ingresa el nombre.
     */
    private javax.swing.JLabel labelNombre;
    
    /** 
     * Cuadro de texto donde se ingresa el login del nuevo usuario.
     */
    private javax.swing.JTextField textoUsuarioNuevo;
    
    /** 
     * Cuadro de texto donde se ingresa el nombre del nuevo usuario.
     */
    private javax.swing.JTextField textoNombreNuevo;
    
    /** 
     * Cuadro de texto donde se ingresa la clave del nuevo usuario.
     */
    private javax.swing.JPasswordField passwordNuevo;
    
    /** 
     * Botón Aceptar.
     */
    private javax.swing.JButton botonAceptar = null;
    
    /** 
     * Botón Cancelar.
     */
    private javax.swing.JButton botonCancelar = null;
    
    /** 
     * Interfaz principal de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal;
    
    /** 
     * Constructor del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     */
    public PanelAcciones(uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca nPrincipal) {
        principal = nPrincipal;
        java.awt.GridBagConstraints gridBagConstraints9 = new java.awt.GridBagConstraints();
        gridBagConstraints9.gridx = 1;
        gridBagConstraints9.gridy = 7;
        java.awt.GridBagConstraints gridBagConstraints8 = new java.awt.GridBagConstraints();
        gridBagConstraints8.gridx = 0;
        gridBagConstraints8.insets = new java.awt.Insets(0 , 9 , 0 , 0);
        gridBagConstraints8.gridy = 7;
        java.awt.GridBagConstraints gridBagConstraints7 = new java.awt.GridBagConstraints();
        gridBagConstraints7.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints7.gridy = 5;
        gridBagConstraints7.weightx = 1.0;
        gridBagConstraints7.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints6 = new java.awt.GridBagConstraints();
        gridBagConstraints6.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints6.gridy = 6;
        gridBagConstraints6.weightx = 1.0;
        gridBagConstraints6.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints51 = new java.awt.GridBagConstraints();
        gridBagConstraints51.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints51.gridy = 4;
        gridBagConstraints51.weightx = 1.0;
        gridBagConstraints51.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints41 = new java.awt.GridBagConstraints();
        gridBagConstraints41.gridx = 0;
        gridBagConstraints41.gridy = 6;
        labelNombre = new javax.swing.JLabel();
        labelNombre.setText("Nombre:");
        labelNombre.setVisible(false);
        java.awt.GridBagConstraints gridBagConstraints22 = new java.awt.GridBagConstraints();
        gridBagConstraints22.gridx = 0;
        gridBagConstraints22.gridy = 5;
        labelContraseniaNueva = new javax.swing.JLabel();
        labelContraseniaNueva.setText("Contraseña:");
        labelContraseniaNueva.setVisible(false);
        java.awt.GridBagConstraints gridBagConstraints11 = new java.awt.GridBagConstraints();
        gridBagConstraints11.gridx = 0;
        gridBagConstraints11.gridy = 4;
        labelUsuarioNuevo = new javax.swing.JLabel();
        labelUsuarioNuevo.setText("Usuario:");
        labelUsuarioNuevo.setVisible(false);
        java.awt.GridBagConstraints gridBagConstraints21 = new java.awt.GridBagConstraints();
        gridBagConstraints21.gridx = 0;
        gridBagConstraints21.gridwidth = 2;
        gridBagConstraints21.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints21.insets = new java.awt.Insets(0 , 54 , 40 , 0);
        gridBagConstraints21.gridheight = 1;
        gridBagConstraints21.weightx = 0.0;
        gridBagConstraints21.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints21.gridy = 3;
        labelRegistrarse = new javax.swing.JLabel();
        labelRegistrarse.setText("¿Sin cuenta? Registrese");
        labelRegistrarse.setFont(new java.awt.Font("Dialog" , java.awt.Font.BOLD , 10));
        labelRegistrarse.setForeground(java.awt.Color.blue);
        labelRegistrarse.addMouseListener(this);
        java.awt.GridBagConstraints gridBagConstraints5 = new java.awt.GridBagConstraints();
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints4 = new java.awt.GridBagConstraints();
        gridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints4.gridy = 1;
        gridBagConstraints4.weightx = 1.0;
        gridBagConstraints4.ipadx = 0;
        gridBagConstraints4.insets = new java.awt.Insets(10 , 10 , 10 , 10);
        gridBagConstraints4.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints2 = new java.awt.GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.insets = new java.awt.Insets(10 , 10 , 10 , 0);
        gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.gridy = 1;
        labelContrasenia = new javax.swing.JLabel();
        labelContrasenia.setText("Contraseña:");
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.insets = new java.awt.Insets(0 , 10 , 0 , 10);
        gridBagConstraints1.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0 , 10 , 0 , 0);
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 0;
        labelLogin = new javax.swing.JLabel();
        labelLogin.setText("Usuario:");
        setSize(214 ,368);
        setLayout(new java.awt.GridBagLayout());
        setBorder(javax.swing.BorderFactory.createTitledBorder(null ,"Login" ,javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION ,javax.swing.border.TitledBorder.DEFAULT_POSITION ,new java.awt.Font("Dialog" , java.awt.Font.BOLD , 12) ,new java.awt.Color(51 , 51 , 51)));
        setMaximumSize(new java.awt.Dimension(214 , 368));
        setBackground(new java.awt.Color(255 , 255 , 204));
        setMinimumSize(new java.awt.Dimension(214 , 358));
        setPreferredSize(new java.awt.Dimension(214 , 368));
        add(labelLogin ,gridBagConstraints);
        textNombreUsuario = new javax.swing.JTextField();
        add(textNombreUsuario ,gridBagConstraints1);
        add(labelContrasenia ,gridBagConstraints2);
        textoContrasenia = new javax.swing.JPasswordField();
        add(textoContrasenia ,gridBagConstraints4);
        botonEntrar = new javax.swing.JButton();
        botonEntrar.setText("Entrar");
        botonEntrar.setActionCommand(ENTRAR);
        botonEntrar.addActionListener(this);
        add(botonEntrar ,gridBagConstraints5);
        add(labelRegistrarse ,gridBagConstraints21);
        add(labelUsuarioNuevo ,gridBagConstraints11);
        add(labelContraseniaNueva ,gridBagConstraints22);
        add(labelNombre ,gridBagConstraints41);
        textoUsuarioNuevo = new javax.swing.JTextField();
        textoUsuarioNuevo.setVisible(false);
        add(textoUsuarioNuevo ,gridBagConstraints51);
        textoNombreNuevo = new javax.swing.JTextField();
        textoNombreNuevo.setVisible(false);
        add(textoNombreNuevo ,gridBagConstraints6);
        passwordNuevo = new javax.swing.JPasswordField();
        passwordNuevo.setVisible(false);
        add(passwordNuevo ,gridBagConstraints7);
        botonAceptar = new javax.swing.JButton();
        botonAceptar.setText("Aceptar");
        botonAceptar.setVisible(false);
        botonAceptar.addActionListener(this);
        botonAceptar.setActionCommand(INSERTAR_USUARIO);
        add(botonAceptar ,gridBagConstraints8);
        botonCancelar = new javax.swing.JButton();
        botonCancelar.setText("Cancelar");
        botonCancelar.setVisible(false);
        botonCancelar.addActionListener(this);
        botonCancelar.setActionCommand(CANCELAR);
        add(botonCancelar ,gridBagConstraints9);
    }
    
    /** 
     * Método que se ejecuta cuando se hace alguna acción sobre los listener del panel.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equals(INSERTAR_USUARIO)) {
            if (((textoUsuarioNuevo.getText().equals("")) || (passwordNuevo.getPassword().equals(""))) || (textoNombreNuevo.getText().equals("")))
                javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese todos los datos" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
            else
                try {
                    principal.registrarUsuario(textoUsuarioNuevo.getText() ,new java.lang.String(passwordNuevo.getPassword()) ,textoNombreNuevo.getText());
                    textNombreUsuario.setEnabled(true);
                    textoContrasenia.setEnabled(true);
                    textoNombreNuevo.setVisible(false);
                    passwordNuevo.setVisible(false);
                    textoUsuarioNuevo.setVisible(false);
                    labelUsuarioNuevo.setVisible(false);
                    labelContraseniaNueva.setVisible(false);
                    labelNombre.setVisible(false);
                    botonAceptar.setVisible(false);
                    botonCancelar.setVisible(false);
                } catch (uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException e1) {
                    javax.swing.JOptionPane.showMessageDialog(this ,e1.getMessage() ,"Error" ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            
            textoUsuarioNuevo.setText("");
            passwordNuevo.setText("");
            textoNombreNuevo.setText("");
        } 
        if (e.getActionCommand().equals(ENTRAR)) {
            principal.autenticar(textNombreUsuario.getText() ,new java.lang.String(textoContrasenia.getPassword()));
            textNombreUsuario.setText("");
            textoContrasenia.setText("");
        } 
        if (e.getActionCommand().equals(CANCELAR)) {
            textNombreUsuario.setEnabled(true);
            textoContrasenia.setEnabled(true);
            textoNombreNuevo.setVisible(false);
            passwordNuevo.setVisible(false);
            textoUsuarioNuevo.setVisible(false);
            labelUsuarioNuevo.setVisible(false);
            labelContraseniaNueva.setVisible(false);
            labelNombre.setVisible(false);
            botonAceptar.setVisible(false);
            botonCancelar.setVisible(false);
            textoUsuarioNuevo.setText("");
            passwordNuevo.setText("");
            textoNombreNuevo.setText("");
        } 
    }
    
    /** 
     * Se ejecuta cuando el mouse entra al elemento.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseEntered(java.awt.event.MouseEvent e) {
        labelRegistrarse.setFont(new java.awt.Font("Dialog" , java.awt.Font.BOLD , 10));
        labelRegistrarse.setText("<html><u>¿Sin cuenta? Registrese</u></html>");
    }
    
    /** 
     * Se ejecuta cuando se hace un click con el mouse.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseClicked(java.awt.event.MouseEvent e) {
        textNombreUsuario.setEnabled(false);
        textoContrasenia.setEnabled(false);
        textoNombreNuevo.setVisible(true);
        passwordNuevo.setVisible(true);
        textoUsuarioNuevo.setVisible(true);
        labelUsuarioNuevo.setVisible(true);
        labelContraseniaNueva.setVisible(true);
        labelNombre.setVisible(true);
        botonAceptar.setVisible(true);
        botonCancelar.setVisible(true);
    }
    
    /** 
     * Se ejecuta cuando se mantiene presionado el botón del mouse.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mousePressed(java.awt.event.MouseEvent e) {
    }
    
    /** 
     * Se ejecuta cuando se suelta el botón del mouse.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }
    
    /** 
     * Se ejecuta cuando se mueve el mouse sale del elemento que se está escuchando.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseExited(java.awt.event.MouseEvent e) {
        labelRegistrarse.setText("¿Sin cuenta? Registrese");
    }
    
}

