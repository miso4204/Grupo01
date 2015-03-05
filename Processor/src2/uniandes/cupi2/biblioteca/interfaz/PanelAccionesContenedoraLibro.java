/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAccionesContenedoraLibro.java,v 1.2 2008/09/03 15:21:48 jua-gome Exp $
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

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Panel donde se ponen las acciones con los libros.
 */
public class PanelAccionesContenedoraLibro extends JPanel
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
     * Panel donde se agrega un libro.
     */
    private PanelAccionAgregarLibro panelAccionAgregarLibro;

    /**
     * Layout del panel.
     */
    private CardLayout cartas;

    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazBiblioteca principal;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor por defecto del panel.
     * @param nPrincipal Interfaz principal de la aplicación.
     */
    public PanelAccionesContenedoraLibro( InterfazBiblioteca nPrincipal )
    {
        principal = nPrincipal;
        setSize( 244, 320 );
        setMinimumSize( new Dimension( 244, 320 ) );
        setMaximumSize( new Dimension( 244, 320 ) );
        setPreferredSize( new Dimension( 244, 320 ) );
        cartas = new CardLayout( );
        setLayout( cartas );
        setBackground( new Color( 255, 255, 214 ) );
        panelAccionAgregarLibro = new PanelAccionAgregarLibro( principal );
        panelAccionAgregarLibro.setName( "accionAgregarLibro" );
        add( panelAccionAgregarLibro, panelAccionAgregarLibro.getName( ) );
    }

    /**
     * Permita cambiar la ventana según la acción que se va hacer.
     * @param accion Acción que se va realizar.
     */
    public void cambiarVentana( String accion )
    {
        if( accion.equals( "BUSCAR" ) )
        {
            PanelAccionBuscarLibro abl = new PanelAccionBuscarLibro( principal );
            add( abl, "Buscar" );
            cartas.show( this, "Buscar" );
        }
        else if( accion.equals( "AGREGAR" ) )
        {
            PanelAccionAgregarLibro abl = new PanelAccionAgregarLibro( principal );
            add( abl, "accionAgregarLibro" );
            cartas.show( this, "accionAgregarLibro" );
        }
        else if( accion.equals( "BLANCO" ) )
        {
            JPanel panel = new JPanel( );
            panel.setOpaque( false );
            add( panel, "blanco" );
            cartas.show( this, "blanco" );
        }
    }
}
