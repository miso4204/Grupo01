/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazBiblioteca.java,v 1.2 2008/09/03 15:52:02 jua-gome Exp $
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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca;
import uniandes.cupi2.biblioteca.mundo.IFabricaBiblioteca;
import uniandes.cupi2.biblioteca.mundo.ILibro;
import uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException;
import uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException;
import uniandes.cupi2.biblioteca.mundo.implementacion1.FabricaBiblioteca;
import uniandes.cupi2.collections.iterador.Iterador;

/**
 * Interfaz principal de la aplicación.
 */
public class InterfazBiblioteca extends JFrame
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
     * Fábrica que construye la clase principal del mundo.
     */
    private IFabricaBiblioteca fabrica;

    /**
     * Interfaz de la clase principal del mundo.
     */
    private AbstractBiblioteca biblioteca;

    /**
     * Login del usuario que está utilizando la aplicación.
     */
    private String loginUsuario;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel principal.
     */
    private JPanel panelPrincipal;

    /**
     * Panel donde está la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Scroll donde está la lista de libros.
     */
    private PanelLibros panelLibros;

    /**
     * Panel donde están ubicadas las acciones.
     */
    private PanelAccionesContenedora panelAccionesContenedora;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de interfaz principal de la aplicación.
     */
    public InterfazBiblioteca( )
    {
        try
        {
            fabrica = new FabricaBiblioteca( );
            loginUsuario = "";
            biblioteca = fabrica.darBiblioteca( "./data/bibliotecaLibros.data", "./data/bibliotecaUsuarios.data" );
            biblioteca.cargar( );
        }
        catch( CargarBibliotecaException e )
        {
            JOptionPane.showMessageDialog( this, "Error cargando el archivo: " + e.getMessage( ) + "\nSe reinicirán los datos del sistema", "Error", JOptionPane.ERROR_MESSAGE );
        }
        setSize( 779, 710 );
        setBackground( new Color( 238, 238, 179 ) );
        setResizable( true );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

        GridBagConstraints gridBagConstraints12 = new GridBagConstraints( );
        gridBagConstraints12.fill = GridBagConstraints.BOTH;
        gridBagConstraints12.gridy = 1;
        gridBagConstraints12.weightx = 1.0;
        gridBagConstraints12.weighty = 1.0;
        gridBagConstraints12.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints12.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 0;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.fill = GridBagConstraints.BOTH;
        gridBagConstraints1.gridwidth = 1;
        gridBagConstraints1.gridy = 1;
        panelPrincipal = new JPanel( );
        panelPrincipal.setLayout( new GridBagLayout( ) );
        panelPrincipal.setMinimumSize( new Dimension( 700, 478 ) );

        // Agregar el panel de la imagen
        panelImagen = new PanelImagen( );
        panelPrincipal.add( panelImagen, gridBagConstraints );

        // Agregar el Scroll de los libros
        panelLibros = new PanelLibros( this );
        panelPrincipal.add( panelLibros, gridBagConstraints12 );

        // Agregar el panel donde están las acciones
        panelAccionesContenedora = new PanelAccionesContenedora( this );
        panelPrincipal.add( panelAccionesContenedora, gridBagConstraints1 );
        add( panelPrincipal );

        setTitle( "Biblioteca" );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Registra un nuevo usuario en el sistemas de biblioteca.
     * @param login Login del usuario.
     * @param contrasenia Contraseña del usuario.
     * @param nombre Nombre del usuario.
     * @throws UsuarioPreexistenteException Si ya existe un usuario con el login ingresado.
     */
    public void registrarUsuario( String login, String contrasenia, String nombre ) throws UsuarioPreexistenteException
    {
        biblioteca.insertarUsuario( login, contrasenia, nombre );
    }

    /**
     * Método para la autenticación del usuario.
     * @param login Login del usuario.
     * @param contrasenia Contraseña de usuario.
     */
    public void autenticar( String login, String contrasenia )
    {
        boolean correcto = biblioteca.autenticar( login, contrasenia );
        if( correcto )
        {
            loginUsuario = login;
            panelLibros.cambiarUsuario( login );
            panelAccionesContenedora.login( login, biblioteca, biblioteca.darTotalLibros( ), biblioteca.darTotalLibrosEnPrestamo( ) );
            JOptionPane.showMessageDialog( this, "Sesión iniciada con exito", "Bienvenido " + login, JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una copia de un libro a la biblioteca.<br>
     * <b>post:</b> En caso que exista el libro aumenta en uno el número de copias.
     * @param referencia Referencia del libro.
     * @throws LibroInexistenteException Se lanza esta excepción cuando se intenta ingresar la copia de un libro que no existe
     */
    public void insertarCopiaLibro( String referencia ) throws LibroInexistenteException
    {
        biblioteca.agregarCopia( referencia );
    }

    /**
     * Agrega un libro a la biblioteca. <br>
     * <b>post:</b> La biblioteca tiene un nuevo libro con los datos dados.
     * @param titulo Nombre del libro.
     * @param autores Autores del libro.
     * @param descriptores Palabras que describen el libro.
     * @param referencia Referencia del libro.
     */
    public void insertarLibro( String titulo, String autores[], String descriptores[], String referencia )
    {
        try
        {
            biblioteca.insertarLibro( titulo, autores, descriptores, 1, referencia );
            JOptionPane.showMessageDialog( this, "Libro agregado con exito", "Libro agregado", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( LibroYaExisteException e )
        {
            JOptionPane.showMessageDialog( this, "El libro ya existía previamente", "Libro agregado", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Termina la sesión.
     */
    public void salir( )
    {
        loginUsuario = null;
        panelAccionesContenedora.salir( );
    }

    /**
     * Hace la búsqueda de un libro por palabras del título.
     * @param datos Datos de la búsqueda.
     */
    public void buscarTituloPorPalabra( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorTitulo( datos );
        panelLibros.actualizarListaBusqueda( libros );

    }

    /**
     * Hace la búsqueda de un libro por el título exacto del libro.
     * @param titulo Título a buscar.
     */
    public void buscarTituloExacto( String titulo )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorTituloExacto( titulo );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Busca los libros descritos por los autores que tienen las palabras dadas.
     * @param datos Datos de la búsqueda.
     */
    public void buscarAutoresPorPalabra( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorAutores( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Hace la búsqueda de los libros por el nombre exacto del autor del libro.
     * @param datos Datos de la búsqueda.
     */
    public void buscarAutoresExacto( String datos )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorAutoresExacto( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Busca los libros descritos por los descriptores que tienen las palabras dadas.
     * @param datos Datos de la búsqueda.
     */
    public void buscarDescriptoresPorPalabra( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorDescriptores( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Hace la búsqueda de los libros por los descriptores exactos del autor del libro.
     * @param datos Datos de la búsqueda.
     */
    public void buscarDescriptoresExacto( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorDescriptoresExacto( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Acción que se ejecuta cuando el usuario que está autenticado alquila un libro.
     * @param libro Libro que va alquilar el usuario.
     * @throws CopiasInsuficientesException Se lanza esta excepción cuando no hay copias suficientes.
     */
    public void alquilar( String libro ) throws CopiasInsuficientesException
    {
        biblioteca.alquilarLibro( loginUsuario, libro );
        JOptionPane.showMessageDialog( this, "Petición realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Acción que se ejecuta cuando el usuario que está autenticado devuelve un libro alquilado.
     * @param libro Libro alquilado que se va devolver.
     */
    public void devolver( String libro )
    {
        biblioteca.devolverLibro( loginUsuario, libro );
        panelLibros.actualizarListaAlquilados( biblioteca.darAlquilados( loginUsuario ) );
        JOptionPane.showMessageDialog( this, "Petición realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Borra un libro que se devolvió de la lista de libros.
     * @param panelLibroAlquilado Panel donde se muestran los datos del libro alquilado.
     */
    public void borrarDevuelto( PanelLibroAlquilado panelLibroAlquilado )
    {
        panelLibros.remove( panelLibroAlquilado );
    }

    /**
     * Muestra los libros que está alquilados por el usuario que está autenticado.
     */
    public void verAlquilados( )
    {
        panelLibros.actualizarListaAlquilados( biblioteca.darAlquilados( loginUsuario ) );
    }

    /**
     * Método que se ejecuta cuando se cierra la aplicación.
     */
    public void dispose( )
    {
        try
        {
            biblioteca.salvar( );
            super.dispose( );
        }
        catch( Exception e )
        {
            setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, "Problemas salvando la información de la biblioteca:\n" + e.getMessage( ) + "\n¿Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION )
            {
                super.dispose( );
            }
        }
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Main de la aplicación.
     * @param args Lista de argumentos con las que corre la aplicación.
     */
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater( new Runnable( )
        {
            public void run( )
            {
                InterfazBiblioteca thisClass = new InterfazBiblioteca( );
                thisClass.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
                thisClass.setVisible( true );
            }
        } );
    }

}
