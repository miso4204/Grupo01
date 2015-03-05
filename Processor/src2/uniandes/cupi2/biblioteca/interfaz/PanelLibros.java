/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelLibros.java,v 1.2 2008/09/03 15:10:14 jua-gome Exp $
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.cupi2.biblioteca.mundo.ILibro;
import uniandes.cupi2.collections.iterador.Iterador;

/**
 * Panel donde se muestra los resultados de una búsqueda.
 */
public class PanelLibros extends JPanel
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazBiblioteca principal;

    /**
     * Login del usuario.
     */
    private String loginUsuario;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel donde se ubican los libros después de la consulta.
     */
    private JPanel panelCentral;

    /**
     * Label donde se muestran los resultados.
     */
    private JLabel labelMostrarResultados;

    /**
     * Scroll donde se ubican los resultados de las búsquedas.
     */
    private JScrollPane scroll;

    /**
     * Layout del panel.
     */
    private GridLayout layout;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     */
    public PanelLibros( InterfazBiblioteca nPrincipal )
    {
        principal = nPrincipal;

        setLayout( new BorderLayout( ) );
        panelCentral = new JPanel( );
        panelCentral.setAlignmentX( 0.0F );
        panelCentral.setBackground( Color.white );
        panelCentral.setAlignmentY( 0.0F );
        layout = new GridLayout( );
        panelCentral.setLayout( layout );

        // Inicialización del scroll pane.
        scroll = new JScrollPane( );
        scroll.setSize( 530, 572 );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setPreferredSize( new Dimension( 530, 572 ) );
        scroll.setViewportView( panelCentral );
        add( scroll, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia el login del usuario.
     * @param nLoginUsuario Nuevo login del usuario.
     */
    public void cambiarUsuario( String nLoginUsuario )
    {
        if( loginUsuario == null )
        {
            loginUsuario = nLoginUsuario;
            return;
        }
        loginUsuario = nLoginUsuario;
    }

    /**
     * Agrega al panel labels importantes para que se pueda mostrar correctamente los resultados de las búsquedas.
     */
    public void anhanirLabeles( )
    {
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.insets = new Insets( 0, 34, 0, 0 );
        gridBagConstraints1.gridy = 0;
        labelMostrarResultados = new JLabel( );
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelCentral.add( labelMostrarResultados );
    }

    /**
     * A partir de un iterador de libros actualiza los resultados de un búsqueda donde se pueden alquilar libros.
     * @param libros Iterador que apunta al primer libro del resultado de la búsqueda
     */
    public void actualizarListaBusqueda( Iterador<ILibro> libros )
    {
        panelCentral.removeAll( );
        anhanirLabeles( );
        int i = 0;
        if( libros != null )
        {

            while( libros.haySiguiente( ) )
            {
                ILibro libro = libros.darSiguiente( );
                panelCentral.add( new PanelLibro( libro, principal ) );
                i++;
            }
            if( i <= 5 )
                layout.setRows( 7 );
            else
            {
                layout.setRows( i + 2 );
                panelCentral.setSize( 511, i * 146 );
            }
            for( int j = i + 2; j < 6; j++ )
            {
                JPanel panel = new JPanel( );
                panel.setBackground( Color.WHITE );
                panelCentral.add( panel );
            }
            labelMostrarResultados.setText( "Resultados de la búsqueda: " + i );
            panelCentral.repaint( );
        }
    }

    /**
     * A partir de un iterador de libros actualiza los resultados de un búsqueda donde se pueden devolver libros.
     * @param libros Iterador que apunta al primer libro del resultado de la búsqueda.
     */
    public void actualizarListaAlquilados( Iterador<ILibro> libros )
    {
        panelCentral.removeAll( );
        anhanirLabeles( );
        int i = 0;
        if( libros != null )
        {

            while( libros.haySiguiente( ) )
            {
                ILibro libro = libros.darSiguiente( );
                panelCentral.add( new PanelLibroAlquilado( libro, principal ) );
                i++;
            }
            if( i <= 5 )
                layout.setRows( 7 );
            else
            {
                layout.setRows( i + 2 );
                panelCentral.setSize( 511, i * 146 );
            }
            for( int j = i + 2; j < 6; j++ )
            {
                JPanel panel = new JPanel( );
                panel.setBackground( Color.WHITE );
                panelCentral.add( panel );
            }
            labelMostrarResultados.setText( "Resultados de la búsqueda: " + i );
            panelCentral.repaint( );
        }
    }

}
