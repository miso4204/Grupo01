/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAcciones.java,v 1.2 2008/09/03 15:28:38 jua-gome Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n15_biblioteca
 * Autor: Jose Felipe Vargas - 23-Jul-2007
 * Autor: Juan Sebastian Montes - 23-Jul-2007
 * Modificado por: Juan Erasmo Gómez - 20-Ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.biblioteca.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException;

/**
 * Panel de control de la aplicación donde se pueden hacer las acciones que tienen que ver con los usuarios.
 */
public class PanelAcciones extends JPanel implements ActionListener, MouseListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Inserta un usuario nuevo.
     */
    private static final String INSERTAR_USUARIO = "Insertar Usuario";

    /**
     * Autentica el usuario.
     */
    private static final String ENTRAR = "Entrar";

    /**
     * Botón Cancelar.
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Etiqueta Login.
     */
    private JLabel labelLogin;

    /**
     * Cuadro de texto donde se ingresa el nombre del usuario.
     */
    private JTextField textNombreUsuario;

    /**
     * Etiqueta Contraseña.
     */
    private JLabel labelContrasenia;

    /**
     * Cuadro de texto donde se ingresa la clave.
     */
    private JPasswordField textoContrasenia;

    /**
     * Botón para la acción de autenticación.
     */
    private JButton botonEntrar;

    /**
     * Etiqueta donde para registrarse.
     */
    private JLabel labelRegistrarse;

    /**
     * Etiqueta Nuevo Usuario.
     */
    private JLabel labelUsuarioNuevo;

    /**
     * Etiqueta Contraseña.
     */
    private JLabel labelContraseniaNueva;

    /**
     * Etiqueta donde se ingresa el nombre.
     */
    private JLabel labelNombre;

    /**
     * Cuadro de texto donde se ingresa el login del nuevo usuario.
     */
    private JTextField textoUsuarioNuevo;

    /**
     * Cuadro de texto donde se ingresa el nombre del nuevo usuario.
     */
    private JTextField textoNombreNuevo;

    /**
     * Cuadro de texto donde se ingresa la clave del nuevo usuario.
     */
    private JPasswordField passwordNuevo;

    /**
     * Botón Aceptar.
     */
    private JButton botonAceptar = null;

    /**
     * Botón Cancelar.
     */
    private JButton botonCancelar = null;

    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazBiblioteca principal;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     */
    public PanelAcciones( InterfazBiblioteca nPrincipal )
    {
        principal = nPrincipal;
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints( );
        gridBagConstraints9.gridx = 1;
        gridBagConstraints9.gridy = 7;
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints( );
        gridBagConstraints8.gridx = 0;
        gridBagConstraints8.insets = new Insets( 0, 9, 0, 0 );
        gridBagConstraints8.gridy = 7;
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints( );
        gridBagConstraints7.fill = GridBagConstraints.BOTH;
        gridBagConstraints7.gridy = 5;
        gridBagConstraints7.weightx = 1.0;
        gridBagConstraints7.gridx = 1;
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints( );
        gridBagConstraints6.fill = GridBagConstraints.BOTH;
        gridBagConstraints6.gridy = 6;
        gridBagConstraints6.weightx = 1.0;
        gridBagConstraints6.gridx = 1;
        GridBagConstraints gridBagConstraints51 = new GridBagConstraints( );
        gridBagConstraints51.fill = GridBagConstraints.BOTH;
        gridBagConstraints51.gridy = 4;
        gridBagConstraints51.weightx = 1.0;
        gridBagConstraints51.gridx = 1;
        GridBagConstraints gridBagConstraints41 = new GridBagConstraints( );
        gridBagConstraints41.gridx = 0;
        gridBagConstraints41.gridy = 6;
        labelNombre = new JLabel( );
        labelNombre.setText( "Nombre:" );
        labelNombre.setVisible( false );
        GridBagConstraints gridBagConstraints22 = new GridBagConstraints( );
        gridBagConstraints22.gridx = 0;
        gridBagConstraints22.gridy = 5;
        labelContraseniaNueva = new JLabel( );
        labelContraseniaNueva.setText( "Contraseña:" );
        labelContraseniaNueva.setVisible( false );
        GridBagConstraints gridBagConstraints11 = new GridBagConstraints( );
        gridBagConstraints11.gridx = 0;
        gridBagConstraints11.gridy = 4;
        labelUsuarioNuevo = new JLabel( );
        labelUsuarioNuevo.setText( "Usuario:" );
        labelUsuarioNuevo.setVisible( false );
        GridBagConstraints gridBagConstraints21 = new GridBagConstraints( );
        gridBagConstraints21.gridx = 0;
        gridBagConstraints21.gridwidth = 2;
        gridBagConstraints21.fill = GridBagConstraints.NONE;
        gridBagConstraints21.insets = new Insets( 0, 54, 40, 0 );
        gridBagConstraints21.gridheight = 1;
        gridBagConstraints21.weightx = 0.0;
        gridBagConstraints21.anchor = GridBagConstraints.WEST;
        gridBagConstraints21.gridy = 3;
        labelRegistrarse = new JLabel( );
        labelRegistrarse.setText( "¿Sin cuenta? Registrese" );
        labelRegistrarse.setFont( new Font( "Dialog", Font.BOLD, 10 ) );
        labelRegistrarse.setForeground( Color.blue );
        labelRegistrarse.addMouseListener( this );
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints( );
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.fill = GridBagConstraints.NONE;
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridy = 2;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints( );
        gridBagConstraints4.fill = GridBagConstraints.BOTH;
        gridBagConstraints4.gridy = 1;
        gridBagConstraints4.weightx = 1.0;
        gridBagConstraints4.ipadx = 0;
        gridBagConstraints4.insets = new Insets( 10, 10, 10, 10 );
        gridBagConstraints4.gridx = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints( );
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.insets = new Insets( 10, 10, 10, 0 );
        gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.gridy = 1;
        labelContrasenia = new JLabel( );
        labelContrasenia.setText( "Contraseña:" );
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.fill = GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.insets = new Insets( 0, 10, 0, 10 );
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new Insets( 0, 10, 0, 0 );
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 0;
        labelLogin = new JLabel( );
        labelLogin.setText( "Usuario:" );
        setSize( 214, 368 );
        setLayout( new GridBagLayout( ) );
        setBorder( BorderFactory.createTitledBorder( null, "Login", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
        setMaximumSize( new Dimension( 214, 368 ) );
        setBackground( new Color( 255, 255, 204 ) );
        setMinimumSize( new Dimension( 214, 358 ) );
        setPreferredSize( new Dimension( 214, 368 ) );

        // Etiqueta Login
        this.add( labelLogin, gridBagConstraints );
        // Cuadro de texto Nombre del usuario.
        textNombreUsuario = new JTextField( );
        this.add( textNombreUsuario, gridBagConstraints1 );
        // Etiqueta contraseña.
        this.add( labelContrasenia, gridBagConstraints2 );
        // Cuadro de texto de la contraseña.
        textoContrasenia = new JPasswordField( );
        this.add( textoContrasenia, gridBagConstraints4 );
        // Botón entrar.
        botonEntrar = new JButton( );
        botonEntrar.setText( "Entrar" );
        botonEntrar.setActionCommand( ENTRAR );
        botonEntrar.addActionListener( this );
        add( botonEntrar, gridBagConstraints5 );
        // Etiqueta registrarse.
        add( labelRegistrarse, gridBagConstraints21 );
        // Etiqueta Nuevo Usuario.
        add( labelUsuarioNuevo, gridBagConstraints11 );
        // Etiqueta Nueva Clave.
        add( labelContraseniaNueva, gridBagConstraints22 );
        // Etiqueta Nuevo Nombre.
        add( labelNombre, gridBagConstraints41 );
        // Nuevo usuario
        textoUsuarioNuevo = new JTextField( );
        textoUsuarioNuevo.setVisible( false );
        add( textoUsuarioNuevo, gridBagConstraints51 );
        // Nuevo nombre
        textoNombreNuevo = new JTextField( );
        textoNombreNuevo.setVisible( false );
        add( textoNombreNuevo, gridBagConstraints6 );
        // Clave del nuevo usuario.
        passwordNuevo = new JPasswordField( );
        passwordNuevo.setVisible( false );
        add( passwordNuevo, gridBagConstraints7 );
        // Botón Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setVisible( false );
        botonAceptar.addActionListener( this );
        botonAceptar.setActionCommand( INSERTAR_USUARIO );
        add( botonAceptar, gridBagConstraints8 );
        // Botón Cancelar
        botonCancelar = new JButton( );
        botonCancelar.setText( "Cancelar" );
        botonCancelar.setVisible( false );
        botonCancelar.addActionListener( this );
        botonCancelar.setActionCommand( CANCELAR );
        add( botonCancelar, gridBagConstraints9 );
    }

    /**
     * Método que se ejecuta cuando se hace alguna acción sobre los listener del panel.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( INSERTAR_USUARIO ) )
        {
            if( textoUsuarioNuevo.getText( ).equals( "" ) || passwordNuevo.getPassword( ).equals( "" ) || textoNombreNuevo.getText( ).equals( "" ) )
                JOptionPane.showMessageDialog( principal, "Ingrese todos los datos", "Error", JOptionPane.ERROR_MESSAGE );
            else
                try
                {
                    principal.registrarUsuario( textoUsuarioNuevo.getText( ), new String( passwordNuevo.getPassword( ) ), textoNombreNuevo.getText( ) );
                    textNombreUsuario.setEnabled( true );
                    textoContrasenia.setEnabled( true );
                    textoNombreNuevo.setVisible( false );
                    passwordNuevo.setVisible( false );
                    textoUsuarioNuevo.setVisible( false );
                    labelUsuarioNuevo.setVisible( false );
                    labelContraseniaNueva.setVisible( false );
                    labelNombre.setVisible( false );
                    botonAceptar.setVisible( false );
                    botonCancelar.setVisible( false );
                }
                catch( UsuarioPreexistenteException e1 )
                {
                    JOptionPane.showMessageDialog( this, e1.getMessage( ), "Error", JOptionPane.INFORMATION_MESSAGE );
                }
            textoUsuarioNuevo.setText( "" );
            passwordNuevo.setText( "" );
            textoNombreNuevo.setText( "" );
        }
        if( e.getActionCommand( ).equals( ENTRAR ) )
        {
            principal.autenticar( textNombreUsuario.getText( ), new String( textoContrasenia.getPassword( ) ) );
            textNombreUsuario.setText( "" );
            textoContrasenia.setText( "" );
        }
        if( e.getActionCommand( ).equals( CANCELAR ) )
        {
            textNombreUsuario.setEnabled( true );
            textoContrasenia.setEnabled( true );
            textoNombreNuevo.setVisible( false );
            passwordNuevo.setVisible( false );
            textoUsuarioNuevo.setVisible( false );
            labelUsuarioNuevo.setVisible( false );
            labelContraseniaNueva.setVisible( false );
            labelNombre.setVisible( false );
            botonAceptar.setVisible( false );
            botonCancelar.setVisible( false );
            textoUsuarioNuevo.setText( "" );
            passwordNuevo.setText( "" );
            textoNombreNuevo.setText( "" );
        }
    }

    /**
     * Se ejecuta cuando el mouse entra al elemento.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseEntered( MouseEvent e )
    {
        labelRegistrarse.setFont( new Font( "Dialog", Font.BOLD, 10 ) );
        labelRegistrarse.setText( "<html><u>¿Sin cuenta? Registrese</u></html>" );
    }

    /**
     * Se ejecuta cuando se hace un click con el mouse.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseClicked( MouseEvent e )
    {
        textNombreUsuario.setEnabled( false );
        textoContrasenia.setEnabled( false );
        textoNombreNuevo.setVisible( true );
        passwordNuevo.setVisible( true );
        textoUsuarioNuevo.setVisible( true );
        labelUsuarioNuevo.setVisible( true );
        labelContraseniaNueva.setVisible( true );
        labelNombre.setVisible( true );
        botonAceptar.setVisible( true );
        botonCancelar.setVisible( true );
    }

    /**
     * Se ejecuta cuando se mantiene presionado el botón del mouse.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mousePressed( MouseEvent e )
    {
        // No se necesita
    }

    /**
     * Se ejecuta cuando se suelta el botón del mouse.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseReleased( java.awt.event.MouseEvent e )
    {
        // No se necesita
    }

    /**
     * Se ejecuta cuando se mueve el mouse sale del elemento que se está escuchando.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void mouseExited( MouseEvent e )
    {
        labelRegistrarse.setText( "¿Sin cuenta? Registrese" );
    }

}
