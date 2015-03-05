/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAccionBuscarLibro.java,v 1.3 2008/09/04 11:06:00 jua-gome Exp $
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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel donde se muestran las opciones de búsqueda.
 */
public class PanelAccionBuscarLibro extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante para la acción buscar.
     */
    private static final String BOTON_BUSCAR = "Buscar";

    /**
     * Constante para el radio button que dice que la búsqueda se va hacer por palabras claves.
     */
    private static final String RADIO_TODOS = "Descripción";

    /**
     * Constante para el radio button que dice que la búsqueda se va hacer por elementos exactos.
     */
    private static final String RADIO_EXACTO = "Exacto";

    /**
     * Constante para definir que la búsqueda se hace por título.
     */
    private static final String TITULO = "Por título";

    /**
     * Constante para definir que la búsqueda se hace por autor.
     */
    private static final String AUTOR = "Por autor";

    /**
     * Constante para definir que la búsqueda se hace por descriptores.
     */
    private static final String DESCRIPTORES = "Por descriptores";

    /**
     * Constante para definir que la acción la hizo el combobox de las acciones.
     */
    private static final String COMBO_ACCIONES = "Combo Acciones";

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
     * Etiqueta de palabras.
     */
    private JLabel labelPalabras;

    /**
     * Cuadro de texto de palabras.
     */
    private JTextField textoPalabras;

    /**
     * Combo donde están los parámetros de la búsqueda.
     */
    private JComboBox comboBusqueda;

    /**
     * Etiqueta "Criterio".
     */
    private JLabel labelCriterio;

    /**
     * Radio que indica que la búsqueda es por el elemento exacto.
     */
    private JRadioButton radioExacto;

    /**
     * Radio que indica que no es exacto, que solo cumpla con uno de las palabras del elemento.
     */
    private JRadioButton radioAlmenos;

    /**
     * Etiqueta "Descriptores"
     */
    private JLabel labelDescriptores;

    /**
     * Cuadro de texto donde se ingresa el descriptor 1.
     */
    private JTextField textoDescriptor1;

    /**
     * Cuadro de texto donde se ingresa el descriptor 2.
     */
    private JTextField textoDescriptor2;

    /**
     * Cuadro de texto donde se ingresa el descriptor 3.
     */
    private JTextField textoDescriptor3;

    /**
     * Botón para ejecutar la búsqueda.
     */
    private JButton botonBuscar = null;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor por defecto del panel.
     * @param principal Interfaz principal de la aplicación.
     */
    public PanelAccionBuscarLibro( InterfazBiblioteca principal )
    {
        super( );
        this.principal = principal;
        initialize( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializar el panel.
     */
    private void initialize( )
    {
        GridBagConstraints gridBagConstraints10 = new GridBagConstraints( );
        gridBagConstraints10.gridx = 1;
        gridBagConstraints10.insets = new Insets( 43, 0, 0, 0 );
        gridBagConstraints10.gridy = 6;
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints( );
        gridBagConstraints9.fill = GridBagConstraints.BOTH;
        gridBagConstraints9.gridy = 5;
        gridBagConstraints9.weightx = 1.0;
        gridBagConstraints9.gridx = 1;
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints( );
        gridBagConstraints8.fill = GridBagConstraints.BOTH;
        gridBagConstraints8.gridy = 4;
        gridBagConstraints8.weightx = 1.0;
        gridBagConstraints8.gridx = 1;
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints( );
        gridBagConstraints7.fill = GridBagConstraints.BOTH;
        gridBagConstraints7.gridy = 3;
        gridBagConstraints7.weightx = 1.0;
        gridBagConstraints7.insets = new Insets( 11, 0, 0, 0 );
        gridBagConstraints7.gridx = 1;
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints( );
        gridBagConstraints6.gridx = 0;
        gridBagConstraints6.insets = new Insets( 11, 0, 0, 0 );
        gridBagConstraints6.gridy = 3;
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints( );
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.gridy = 2;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints( );
        gridBagConstraints4.gridx = 1;
        gridBagConstraints4.gridy = 2;
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints( );
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints( );
        gridBagConstraints2.fill = GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.gridx = 1;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.fill = GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        this.setSize( 244, 320 );
        this.setLayout( new GridBagLayout( ) );
        this.setBorder( BorderFactory.createTitledBorder( null, "Buscar Libro", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
        this.setOpaque( false );

        // Creación y adición del label palabras.
        labelPalabras = new JLabel( );
        labelPalabras.setText( "Palabras:" );
        labelPalabras.setToolTipText( "Palabras:" );
        add( labelPalabras, gridBagConstraints );

        // Creación y adición del cuadro de texto palabras.
        textoPalabras = new JTextField( );
        add( textoPalabras, gridBagConstraints1 );

        // Creación y edición del combo con búsqueda
        comboBusqueda = new JComboBox( );
        comboBusqueda.addItem( TITULO );
        comboBusqueda.addItem( AUTOR );
        comboBusqueda.addItem( DESCRIPTORES );
        comboBusqueda.addActionListener( this );
        comboBusqueda.setActionCommand( COMBO_ACCIONES );
        add( comboBusqueda, gridBagConstraints2 );

        // Creación y adición del label criterio.
        labelCriterio = new JLabel( );
        labelCriterio.setText( "Criterio:" );
        add( labelCriterio, gridBagConstraints3 );

        // Creación y adición del radio todos.
        radioExacto = new JRadioButton( );
        radioExacto.setText( "Todas las palabras" );
        radioExacto.setOpaque( false );
        radioExacto.addActionListener( this );
        add( radioExacto, gridBagConstraints4 );

        // Creación y adición del radio al menos.
        radioAlmenos = new JRadioButton( );
        radioAlmenos.setText( "Por palabra" );
        radioAlmenos.setOpaque( false );
        radioAlmenos.setSelected( true );
        radioAlmenos.addActionListener( this );
        add( radioAlmenos, gridBagConstraints5 );

        // Creación del radio group
        ButtonGroup grupoRadio = new ButtonGroup( );
        grupoRadio.add( radioAlmenos );
        grupoRadio.add( radioExacto );

        // Creación y edición de label de los descriptores
        labelDescriptores = new JLabel( );
        labelDescriptores.setText( "Descriptores:" );
        add( labelDescriptores, gridBagConstraints6 );

        // Creación y edición de cuadro de texto del descriptor 1.
        textoDescriptor1 = new JTextField( );
        textoDescriptor1.setEnabled( false );
        add( textoDescriptor1, gridBagConstraints7 );

        // Creación y edición de cuadro de texto del descriptor 2.
        textoDescriptor2 = new JTextField( );
        textoDescriptor2.setEnabled( false );
        add( textoDescriptor2, gridBagConstraints8 );

        // Creación y edición de cuadro de texto del descriptor 3.
        textoDescriptor3 = new JTextField( );
        textoDescriptor3.setEnabled( false );
        add( textoDescriptor3, gridBagConstraints9 );

        // Creación y edición del botón buscar.
        botonBuscar = new JButton( );
        botonBuscar.setText( "Buscar" );
        botonBuscar.setActionCommand( BOTON_BUSCAR );
        botonBuscar.addActionListener( this );
        add( botonBuscar, gridBagConstraints10 );
    }

    /**
     * Manejo de eventos sobre los elementos del panel.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( BOTON_BUSCAR ) )
            buscar( );
        if( e.getActionCommand( ).equals( RADIO_EXACTO ) )
        {
            radioAlmenos.setSelected( true );
            radioExacto.setSelected( false );
        }
        if( e.getActionCommand( ).equals( RADIO_TODOS ) )
        {
            radioAlmenos.setSelected( false );
            radioExacto.setSelected( true );
        }
        if( e.getActionCommand( ).equals( COMBO_ACCIONES ) )
            seleccionCombo( );

    }

    /**
     * Manejo de los eventos sobre el combo box de búsqueda.
     */
    public void seleccionCombo( )
    {
        if( comboBusqueda.getSelectedItem( ).equals( TITULO ) || comboBusqueda.getSelectedItem( ).equals( AUTOR ) )
        {
            textoPalabras.setEnabled( true );
            textoDescriptor1.setEnabled( false );
            textoDescriptor2.setEnabled( false );
            textoDescriptor3.setEnabled( false );
        }
        else
        {
            textoPalabras.setEnabled( false );
            textoDescriptor1.setEnabled( true );
            textoDescriptor2.setEnabled( true );
            textoDescriptor3.setEnabled( true );
        }
    }

    /**
     * Ejecuta una búsqueda.
     */
    public void buscar( )
    {
        if( comboBusqueda.getSelectedItem( ).equals( TITULO ) )
        {
            if( textoPalabras.getText( ).equals( "" ) )
            {
                JOptionPane.showMessageDialog( principal, "Ingrese las palabras", "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            if( radioAlmenos.isSelected( ) )
                principal.buscarTituloPorPalabra( textoPalabras.getText( ).split( " " ) );
            else
                principal.buscarTituloExacto( textoPalabras.getText( ) );
        }
        if( comboBusqueda.getSelectedItem( ).equals( AUTOR ) )
        {
            if( textoPalabras.getText( ).equals( "" ) )
            {
                JOptionPane.showMessageDialog( principal, "Ingrese las palabras", "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            if( radioAlmenos.isSelected( ) )
                principal.buscarAutoresPorPalabra( textoPalabras.getText( ).split( " " ) );
            else
                principal.buscarAutoresExacto( textoPalabras.getText( ) );
        }
        if( comboBusqueda.getSelectedItem( ).equals( DESCRIPTORES ) )
        {
            if( textoDescriptor1.getText( ).equals( "" ) && textoDescriptor2.getText( ).equals( "" ) && textoDescriptor3.getText( ).equals( "" ) )
            {
                JOptionPane.showMessageDialog( principal, "Ingrese al menos un descriptor", "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            int contador = 0;
            if( !textoDescriptor1.getText( ).equals( "" ) )
                contador++;
            if( !textoDescriptor2.getText( ).equals( "" ) )
                contador++;
            if( !textoDescriptor3.getText( ).equals( "" ) )
                contador++;

            String datos[] = new String[contador];
            contador = 0;
            if( !textoDescriptor1.getText( ).equals( "" ) )
            {
                datos[ contador ] = textoDescriptor1.getText( ).trim( );
                contador++;
            }
            if( !textoDescriptor2.getText( ).equals( "" ) )
            {
                datos[ contador ] = textoDescriptor2.getText( ).trim( );
                contador++;
            }
            if( !textoDescriptor3.getText( ).equals( "" ) )
                datos[ contador ] = textoDescriptor3.getText( ).trim( );

            if( radioAlmenos.isSelected( ) )
                principal.buscarDescriptoresPorPalabra( datos );
            else
                principal.buscarDescriptoresExacto( datos );
        }
    }

}
