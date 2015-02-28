/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelLibroAlquilado.java,v 1.2 2008/09/03 15:12:02 jua-gome Exp $
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.biblioteca.mundo.ILibro;

/**
 * Panel donde se muestra la información de los libros alquilados.
 */
public class PanelLibroAlquilado extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante para devolver el libro.
     */
    private static final String DEVOLVER_LIBRO = "Devolver libro";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Libro del que se van a mostrar los datos.
     */
    private ILibro libro;

    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazBiblioteca principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz.
    // -----------------------------------------------------------------

    /**
     * Etiqueta "Título".
     */
    private JLabel labelTitulo;

    /**
     * Etiqueta "Autores".
     */
    private JLabel labelAutores;

    /**
     * Etiqueta "Descriptores".
     */
    private JLabel labelDescriptores;

    /**
     * Etiqueta para mostrar los libros disponibles.
     */
    private JLabel labelDisponibles;

    /**
     * Etiqueta donde aparece el título.
     */
    private JLabel labelDTitulo;

    /**
     * Etiqueta donde se muestran los autores del libro.
     */
    private JLabel labelDAutores;

    /**
     * Etiqueta donde se muestran los descriptores.
     */
    private JLabel labelDDescriptores;

    /**
     * Etiqueta donde se muestran la cantidad de copias disponibles.
     */
    private JLabel labelDDisponibles;

    /**
     * Botón para devolver una copia del libro.
     */
    private JButton botonDevolver;

    // -----------------------------------------------------------------
    // Constructor
    // ----------------------------------------------------------------

    /**
     * Constructor por defecto de la aplicación.
     * @param elLibro que se le va mostrar la información.
     * @param nPrincipal La interfaz principal de la aplicación.
     */
    public PanelLibroAlquilado( ILibro elLibro, InterfazBiblioteca nPrincipal )
    {
        principal = nPrincipal;
        libro = elLibro;
        setPreferredSize( new Dimension( 517, 144 ) );
        setSize( new Dimension( 517, 144 ) );
        setPreferredSize( new Dimension( 511, 144 ) );
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints( );
        gridBagConstraints9.gridx = 2;
        gridBagConstraints9.gridheight = 2;
        gridBagConstraints9.fill = GridBagConstraints.NONE;
        gridBagConstraints9.insets = new Insets( 0, 0, 0, 2 );
        gridBagConstraints9.gridy = 1;
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints( );
        gridBagConstraints8.gridx = 1;
        gridBagConstraints8.fill = GridBagConstraints.BOTH;
        gridBagConstraints8.anchor = GridBagConstraints.WEST;
        gridBagConstraints8.gridwidth = 2;
        gridBagConstraints8.ipadx = 0;
        gridBagConstraints8.ipady = 46;
        gridBagConstraints8.gridy = 4;
        labelDDisponibles = new JLabel( );
        labelDDisponibles.setBackground( new Color( 218, 208, 197 ) );
        labelDDisponibles.setOpaque( true );
        labelDDisponibles.setFont( new Font( "Dialog", Font.BOLD, 24 ) );
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints( );
        gridBagConstraints7.gridx = 1;
        gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints7.anchor = GridBagConstraints.WEST;
        gridBagConstraints7.gridwidth = 1;
        gridBagConstraints7.gridy = 2;
        labelDDescriptores = new JLabel( );
        labelDDescriptores.setText( libro.darDescriptores( ) );
        labelDDescriptores.setMaximumSize( new Dimension( 345, 14 ) );
        labelDDescriptores.setMinimumSize( new Dimension( 345, 14 ) );
        labelDDescriptores.setPreferredSize( new Dimension( 345, 14 ) );
        labelDDescriptores.setFont( new Font( "Dialog", Font.BOLD, 10 ) );
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints( );
        gridBagConstraints5.gridx = 1;
        gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints5.gridy = 1;
        labelDAutores = new JLabel( );
        labelDAutores.setText( libro.darAutores( ) );
        labelDAutores.setFont( new Font( "Dialog", Font.BOLD, 10 ) );
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints( );
        gridBagConstraints4.gridx = 1;
        gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints4.anchor = GridBagConstraints.WEST;
        gridBagConstraints4.gridy = 0;
        labelDTitulo = new JLabel( );
        labelDTitulo.setText( libro.darTitulo( ) );
        labelDTitulo.setFont( new Font( "Dialog", Font.BOLD, 10 ) );
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints( );
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.fill = GridBagConstraints.BOTH;
        gridBagConstraints3.anchor = GridBagConstraints.WEST;
        gridBagConstraints3.insets = new Insets( 0, 0, 0, 0 );
        gridBagConstraints3.ipadx = 0;
        gridBagConstraints3.ipady = 46;
        gridBagConstraints3.gridwidth = 1;
        gridBagConstraints3.gridy = 4;
        labelDisponibles = new JLabel( );
        labelDisponibles.setText( "" );
        labelDisponibles.setBackground( new Color( 218, 208, 197 ) );
        labelDisponibles.setOpaque( true );
        labelDisponibles.setForeground( Color.black );
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints( );
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.anchor = GridBagConstraints.WEST;
        gridBagConstraints2.insets = new Insets( 0, 0, 0, 0 );
        gridBagConstraints2.gridy = 2;
        labelDescriptores = new JLabel( );
        labelDescriptores.setText( "Descriptores:" );
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.anchor = GridBagConstraints.CENTER;
        gridBagConstraints1.insets = new Insets( 0, 0, 0, 0 );
        gridBagConstraints1.gridy = 1;
        labelAutores = new JLabel( );
        labelAutores.setText( "Autores:" );
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets( 0, 0, 0, 0 );
        gridBagConstraints.gridy = 0;
        labelTitulo = new JLabel( );
        labelTitulo.setText( "Título:" );
        setSize( 515, 144 );
        setLayout( new GridBagLayout( ) );
        setBackground( new Color( 245, 235, 214 ) );
        setMaximumSize( new Dimension( 515, 144 ) );
        setMinimumSize( new Dimension( 515, 144 ) );
        setPreferredSize( new Dimension( 515, 144 ) );
        setBorder( BorderFactory.createTitledBorder( null, libro.darReferencia( ), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), Color.blue ) );
        add( labelTitulo, gridBagConstraints );
        add( labelAutores, gridBagConstraints1 );
        add( labelDescriptores, gridBagConstraints2 );
        add( labelDisponibles, gridBagConstraints3 );
        add( labelDTitulo, gridBagConstraints4 );
        add( labelDAutores, gridBagConstraints5 );
        add( labelDDescriptores, gridBagConstraints7 );
        add( labelDDisponibles, gridBagConstraints8 );
        botonDevolver = new JButton( );
        botonDevolver.setText( "Devolver" );
        botonDevolver.setFont( new Font( "Dialog", Font.BOLD, 10 ) );
        botonDevolver.addActionListener( this );
        botonDevolver.setActionCommand( DEVOLVER_LIBRO );
        add( botonDevolver, gridBagConstraints9 );
    }

    /**
     * Método que se ejecuta cuando se hace alguna acción sobre los listener del panel.
     * @param e Objeto donde va encapsulado los datos del evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( DEVOLVER_LIBRO ) )
        {
            principal.devolver( libro.darReferencia( ) );
            principal.borrarDevuelto( this );
        }
    }

}
