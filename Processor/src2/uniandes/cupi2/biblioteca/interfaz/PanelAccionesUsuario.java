/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAccionesUsuario.java,v 1.3 2008/09/04 11:15:16 jua-gome Exp $
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
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca;

/**
 * Panel en el que se manejan las acciones con el usuario.
 */
public class PanelAccionesUsuario extends JPanel implements ActionListener, Observer
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Agregar libro.
     */
    private static final String AGREGAR_LIBRO = "Agregar libro";

    /**
     * Buscar libros.
     */
    private static final String BUSCAR_LIBROS = "Buscar libros";

    /**
     * Ver libros alquilados.
     */
    private static final String VER_LIBROS = "Ver alquilados";

    /**
     * Salir de la aplicación.
     */
    private static final String SALIR = "Terminar sesión";;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazBiblioteca principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Combo box donde se muestran las acciones.
     */
    private JComboBox comboAcciones;

    /**
     * Etiqueta "Acciones".
     */
    private JLabel labelAcciones;

    /**
     * Panel acciones contenedora de las acciones del libro.
     */
    private PanelAccionesContenedoraLibro accionesContenedora;

    /**
     * Etiqueta "Total".
     */
    private JLabel labelTotal;

    /**
     * Etiqueta donde se muestra el total de libros.
     */
    private JLabel labelLibrosTotal;

    /**
     * Etiqueta libros prestados.
     */
    private JLabel labelPrestados;

    /**
     * Etiqueta libros prestados.
     */
    private JLabel labelLibrosPrestados = null;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     * @param nombre Nombre del usuario que hizo login.
     * @param total Total de libros de la biblioteca.
     * @param prestados Total de libros prestado de la biblioteca.
     * @param bibliteca Biblioteca.
     */
    public PanelAccionesUsuario( InterfazBiblioteca nPrincipal, String nombre, int total, int prestados, AbstractBiblioteca bibliteca )
    {
        principal = nPrincipal;
        bibliteca.addObserver( this );
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints( );
        gridBagConstraints9.gridx = 1;
        gridBagConstraints9.gridy = 4;
        labelLibrosPrestados = new JLabel( );
        labelLibrosPrestados.setText( "" );
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints( );
        gridBagConstraints8.gridx = 0;
        gridBagConstraints8.gridy = 4;
        labelPrestados = new JLabel( );
        labelPrestados.setText( "Total prestados:" );
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints( );
        gridBagConstraints7.gridx = 1;
        gridBagConstraints7.gridy = 3;
        labelLibrosTotal = new JLabel( );
        labelLibrosTotal.setText( "" );
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints( );
        gridBagConstraints6.gridx = 0;
        gridBagConstraints6.gridy = 3;
        labelTotal = new JLabel( );
        labelTotal.setText( "Total libros:" );
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints( );
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.fill = GridBagConstraints.BOTH;
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridy = 2;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.anchor = GridBagConstraints.WEST;
        gridBagConstraints1.insets = new Insets( 0, 10, 0, 0 );
        gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.gridy = 0;
        labelAcciones = new JLabel( );
        labelAcciones.setText( "Acciones" );
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets( 0, 10, 0, 10 );
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        labelLibrosTotal.setText( "" + total );
        labelLibrosPrestados.setText( "" + prestados );
        setSize( 244, 378 );
        setLayout( new GridBagLayout( ) );
        setBackground( new Color( 255, 255, 204 ) );
        setBorder( BorderFactory.createTitledBorder( null, nombre, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
        setMaximumSize( new Dimension( 244, 378 ) );
        setMinimumSize( new Dimension( 244, 378 ) );
        setPreferredSize( new Dimension( 244, 378 ) );

        // Combo acciones.
        comboAcciones = new JComboBox( );
        comboAcciones.addItem( AGREGAR_LIBRO );
        comboAcciones.addItem( BUSCAR_LIBROS );
        comboAcciones.addItem( VER_LIBROS );
        comboAcciones.addItem( SALIR );
        comboAcciones.setActionCommand( "COMBO" );
        comboAcciones.addActionListener( this );
        add( comboAcciones, gridBagConstraints );
        // Etiqueta Acciones.
        add( labelAcciones, gridBagConstraints1 );
        // Panel Acciones contenedora.
        accionesContenedora = new PanelAccionesContenedoraLibro( principal );
        add( accionesContenedora, gridBagConstraints5 );
        // Etiqueta total de libros.
        add( labelTotal, gridBagConstraints6 );
        // Etiqueta donde se muestra el número total de libros.
        add( labelLibrosTotal, gridBagConstraints7 );
        // Etiqueta libros prestados.
        this.add( labelPrestados, gridBagConstraints8 );
        // Etiqueta donde se muestra el número total de libros prestados.
        this.add( labelLibrosPrestados, gridBagConstraints9 );
    }

    /**
     * Método en el que se ejecuta las acciones del combo box.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( comboAcciones.getSelectedItem( ).equals( AGREGAR_LIBRO ) )
            accionesContenedora.cambiarVentana( "AGREGAR" );
        else if( comboAcciones.getSelectedItem( ).equals( BUSCAR_LIBROS ) )
            accionesContenedora.cambiarVentana( "BUSCAR" );
        else if( comboAcciones.getSelectedItem( ).equals( VER_LIBROS ) )
        {
            principal.verAlquilados( );
            accionesContenedora.cambiarVentana( "BLANCO" );
        }
        else if( comboAcciones.getSelectedItem( ).equals( SALIR ) )
            principal.salir( );
    }

    /**
     * Método para actualizar el panel.
     * @param observable Objeto que cambio y notifico el cambio.
     * @param objeto Objeto que viene con la actualización del panel.
     */
    public void update( Observable observable, Object objeto )
    {
        if( objeto instanceof int[] )
        {
            int arreglo[] = ( int[] )objeto;
            labelLibrosTotal.setText( "" + arreglo[ 0 ] );
            labelLibrosPrestados.setText( "" + arreglo[ 1 ] );
        }
    }

}
