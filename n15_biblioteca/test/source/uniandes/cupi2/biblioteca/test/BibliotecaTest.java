/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: BibliotecaTest.java,v 1.2 2008/09/03 16:05:38 jua-gome Exp $
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
package uniandes.cupi2.biblioteca.test;

import junit.framework.TestCase;
import uniandes.cupi2.biblioteca.mundo.ILibro;
import uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException;
import uniandes.cupi2.biblioteca.mundo.implementacion1.Biblioteca;
import uniandes.cupi2.collections.iterador.Iterador;

/**
 * Clase de pruebas de la clase Bibliteca.
 */
public class BibliotecaTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia de la biblioteca para probar.
     */
    private Biblioteca biblioteca;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Configura un escenario para las pruebas.
     */
    public void setupEscenario1( )
    {
        biblioteca = new Biblioteca( "test/data/libros.info", "test/data/usuarios.info" );
    }

    /**
     * Configura un escenario para las pruebas.
     */
    public void setupEscenario2( )
    {
        biblioteca = new Biblioteca( "test/data/libros.info", "test/data/usuarios.info" );
        String[] autores = new String[3];
        autores[ 0 ] = "Gabriel García Márquez";
        autores[ 1 ] = "";
        autores[ 2 ] = "";
        String[] descriptores1 = new String[4];
        descriptores1[ 0 ] = "Gabo";
        descriptores1[ 1 ] = "Novela";
        descriptores1[ 2 ] = "";
        descriptores1[ 3 ] = "";
        String[] descriptores2 = new String[4];
        descriptores2[ 0 ] = "Gabo";
        descriptores2[ 1 ] = "Novela";
        descriptores2[ 2 ] = "Coronel";
        descriptores2[ 3 ] = "Gallo";
        String[] descriptores3 = new String[4];
        descriptores3[ 0 ] = "Gabo";
        descriptores3[ 1 ] = "Novela";
        descriptores3[ 2 ] = "Vicario";
        descriptores3[ 3 ] = "Virginidad";
        String[] descriptores4 = new String[4];
        descriptores4[ 0 ] = "Gabo";
        descriptores4[ 1 ] = "Novela";
        descriptores4[ 2 ] = "Buendía";
        descriptores4[ 3 ] = "";
        String[] descriptores5 = new String[4];
        descriptores5[ 0 ] = "Gabo";
        descriptores5[ 1 ] = "Novela";
        descriptores5[ 2 ] = "Turbay";
        descriptores5[ 3 ] = "";
        try
        {
            biblioteca.insertarLibro( "Del amor y otros demonios", autores, descriptores1, 2, "1" );
            biblioteca.insertarLibro( "El coronel no tiene quien le escriba", autores, descriptores2, 2, "2" );
            biblioteca.insertarLibro( "Crónica de una muerte anunciada", autores, descriptores3, 2, "3" );
            biblioteca.insertarLibro( "Cien años de soledad", autores, descriptores4, 2, "4" );
            biblioteca.insertarLibro( "Crónica de un secuestro", autores, descriptores5, 2, "5" );
        }
        catch( LibroYaExisteException e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * Configura un escenario para las pruebas.
     */
    public void setupEscenario3( )
    {
        biblioteca = new Biblioteca( "test/data/libros.info", "test/data/usuarios.info" );
        String[] autores = new String[3];
        autores[ 0 ] = "Gabriel García Márquez";
        autores[ 1 ] = "";
        autores[ 2 ] = "";
        String[] descriptores1 = new String[4];
        descriptores1[ 0 ] = "Gabo";
        descriptores1[ 1 ] = "Novela";
        descriptores1[ 2 ] = "";
        descriptores1[ 3 ] = "";
        String[] descriptores2 = new String[4];
        descriptores2[ 0 ] = "Gabo";
        descriptores2[ 1 ] = "Novela";
        descriptores2[ 2 ] = "Coronel";
        descriptores2[ 3 ] = "Gallo";
        String[] descriptores3 = new String[4];
        descriptores3[ 0 ] = "Gabo";
        descriptores3[ 1 ] = "Novela";
        descriptores3[ 2 ] = "Vicario";
        descriptores3[ 3 ] = "Virginidad";
        String[] descriptores4 = new String[4];
        descriptores4[ 0 ] = "Gabo";
        descriptores4[ 1 ] = "Novela";
        descriptores4[ 2 ] = "Buendía";
        descriptores4[ 3 ] = "";
        String[] descriptores5 = new String[4];
        descriptores5[ 0 ] = "Gabo";
        descriptores5[ 1 ] = "Novela";
        descriptores5[ 2 ] = "Turbay";
        descriptores5[ 3 ] = "";
        try
        {
            biblioteca.insertarLibro( "Del amor y otros demonios", autores, descriptores1, 2, "1" );
            biblioteca.insertarLibro( "El coronel no tiene quien le escriba", autores, descriptores2, 2, "2" );
            biblioteca.insertarLibro( "Crónica de una muerte anunciada", autores, descriptores3, 2, "3" );
            biblioteca.insertarLibro( "Cien años de soledad", autores, descriptores4, 2, "4" );
            biblioteca.insertarLibro( "Crónica de un secuestro", autores, descriptores5, 2, "5" );
        }
        catch( LibroYaExisteException e1 )
        {
            fail( e1.getMessage( ) );
        }
        try
        {
            biblioteca.insertarUsuario( "a", "a", "a" );
        }
        catch( UsuarioPreexistenteException e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * Prueba para insertar un Usuario en el sistema de biblioteca.
     */
    public void testInsertarUsuario( )
    {
        try
        {
            setupEscenario1( );
            biblioteca.insertarUsuario( "123", "123", "Uno" );
            boolean autenticar = biblioteca.autenticar( "123", "123" );
            assertTrue( "No inserto correctamente la persona", autenticar );
        }
        catch( UsuarioPreexistenteException e )
        {
            fail( "Encontro un usuario que no estaba en el sistema." );
        }
    }

    /**
     * Prueba para que no se inserte un usuario que estaba previamente en el sistema.
     */
    public void testInsertarUsuarioPreexistente( )
    {
        try
        {
            setupEscenario1( );
            biblioteca.insertarUsuario( "123", "123", "Uno" );
            boolean autenticar = biblioteca.autenticar( "123", "123" );
            assertTrue( "No inserto correctamente la persona", autenticar );
            biblioteca.insertarUsuario( "123", "123", "Dos" );
            fail( "Inserto un usuario que ya existía en el sistema." );
        }
        catch( UsuarioPreexistenteException e )
        {
            // Por aquí debería pasar.
        }
    }

    /**
     * Prueba la inserción de un libro a la biblioteca.
     */
    public void testInsertarLibro( )
    {
        setupEscenario1( );
        String[] autores = new String[3];
        autores[ 0 ] = "Gabriel García Márquez";
        autores[ 1 ] = "";
        autores[ 2 ] = "";
        String[] descriptores = new String[4];
        descriptores[ 0 ] = "Gabo";
        descriptores[ 1 ] = "Novela";
        descriptores[ 2 ] = "";
        descriptores[ 3 ] = "";
        try
        {
            biblioteca.insertarLibro( "Del amor y otros demonios", autores, descriptores, 2, "1" );
            ILibro libro = biblioteca.darLibro( "1" );
            assertTrue( "No se insertó correctamente el libro", libro.darTitulo( ).equals( "Del amor y otros demonios" ) );
            assertTrue( "No se insertó correctamente el libro", libro.darAutores( ).equals( "\"Gabriel García Márquez\" \"\" \"\"" ) );
        }
        catch( LibroYaExisteException e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * Prueba la inserción de un libro a la biblioteca.
     */
    public void testInsertarLibroPreexistente( )
    {
        setupEscenario1( );
        String[] autores = new String[3];
        autores[ 0 ] = "Gabriel García Márquez";
        autores[ 1 ] = "";
        autores[ 2 ] = "";
        String[] descriptores = new String[4];
        descriptores[ 0 ] = "Gabo";
        descriptores[ 1 ] = "Novela";
        descriptores[ 2 ] = "";
        descriptores[ 3 ] = "";
        try
        {
            biblioteca.insertarLibro( "Del amor y otros demonios", autores, descriptores, 2, "1" );
            biblioteca.insertarLibro( "Del amor y otros demonios", autores, descriptores, 2, "1" );
            fail( );
        }
        catch( LibroYaExisteException e )
        {
            // Por aquí debería pasar.
        }
    }

    /**
     *Prueba de la búsqueda de los libros descritos por el título exacto.
     */
    public void testBuscarLibroPorTituloExacto( )
    {
        setupEscenario2( );
        Iterador<ILibro> iterador = biblioteca.buscarPorTituloExacto( "Del amor y otros demonios" );
        ILibro libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darTitulo( ).equals( "Del amor y otros demonios" ) );
        assertTrue( "No se encontro el libro", libro.darAutores( ).equals( "\"Gabriel García Márquez\" \"\" \"\"" ) );
    }

    /**
     * Prueba de la búsqueda de los libros descritos por el alguna palabra del libro.
     */
    public void testBuscarLibroPorTitulo( )
    {
        setupEscenario2( );
        String[] datos = new String[1];
        datos[ 0 ] = "Crónica";
        Iterador<ILibro> iterador = biblioteca.buscarPorTitulo( datos );
        ILibro libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "5" ) );
    }

    /**
     * Prueba de la búsqueda de los libros que escribió el autor.
     */
    public void testuscarPorAutoresExacto( )
    {
        setupEscenario2( );
        Iterador<ILibro> iterador = biblioteca.buscarPorAutoresExacto( "Gabriel García Márquez" );
        ILibro libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
    }

    /**
     * Prueba de la búsqueda de los libros que en los autores tengan una de las palabras dadas.
     */
    public void testBuscarPorAutores( )
    {
        setupEscenario2( );
        String datos[] = new String[1];
        datos[ 0 ] = "Gabriel";
        Iterador<ILibro> iterador = biblioteca.buscarPorAutores( datos );
        ILibro libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
    }

    /**
     * Prueba de la búsqueda de los libros que tengan los siguientes descriptores.
     */
    public void testBuscarPorDescriptoresExacto( )
    {
        setupEscenario2( );
        String[] descriptores = new String[4];
        descriptores[ 0 ] = "Gabo";
        descriptores[ 1 ] = "Novela";
        descriptores[ 2 ] = "Turbay";
        descriptores[ 3 ] = "";
        Iterador<ILibro> iterador = biblioteca.buscarPorDescriptoresExacto( descriptores );
        ILibro libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "5" ) );
    }

    /**
     * Prueba de la búsqueda de los libros que en los descriptores tengan una de las palabras dadas.
     */
    public void testBuscarLibroDescriptores( )
    {
        setupEscenario2( );
        String datos[] = new String[1];
        datos[ 0 ] = "Gabo";
        Iterador<ILibro> iterador = biblioteca.buscarPorDescriptores( datos );
        ILibro libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
        libro = iterador.darSiguiente( );
        assertTrue( "No se encontro el libro", libro.darReferencia( ).equals( "1" ) || libro.darReferencia( ).equals( "2" ) || libro.darReferencia( ).equals( "3" ) || libro.darReferencia( ).equals( "4" ) || libro.darReferencia( ).equals( "5" ) );
    }

    /**
     * Prueba que se haga correctamente el alquiler de un libro.
     */
    public void testAlquilarLibro( )
    {
        setupEscenario3( );
        try
        {
            biblioteca.alquilarLibro( "a", "1" );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibrosEnPrestamo( ) == 1 );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibros( ) == 10 );
            Iterador<ILibro> alquilados = biblioteca.darAlquilados( "a" );
            ILibro libroAlquilado = alquilados.darSiguiente( );
            assertTrue( "No se alquilo correctamente el libro", libroAlquilado.darReferencia( ).equals( "1" ) );
        }
        catch( CopiasInsuficientesException e )
        {
            fail( e.getMessage( ) + ": No debería ocurrir está excepción" );
        }
    }

    /**
     * Prueba que se devuelve los libros alquilados.
     */
    public void darAlquilados( String elUsuario )
    {
        setupEscenario3( );
        try
        {
            biblioteca.alquilarLibro( "a", "1" );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibrosEnPrestamo( ) == 1 );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibros( ) == 10 );
            Iterador<ILibro> alquilados = biblioteca.darAlquilados( "a" );
            ILibro libroAlquilado = alquilados.darSiguiente( );
            assertTrue( "No se alquilo correctamente el libro", libroAlquilado.darReferencia( ).equals( "1" ) );
        }
        catch( CopiasInsuficientesException e )
        {
            fail( e.getMessage( ) + ": No debería ocurrir está excepción" );
        }
    }

    /**
     * Prueba que se devuelve los libros alquilados.
     */
    public void testDevolverLibro( String elUsuario, String referencia )
    {
        setupEscenario3( );
        try
        {
            biblioteca.alquilarLibro( "a", "1" );
            biblioteca.devolverLibro( "a", "1" );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibrosEnPrestamo( ) == 0 );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibros( ) == 10 );

        }
        catch( CopiasInsuficientesException e )
        {
            fail( e.getMessage( ) + ": No debería ocurrir está excepción" );
        }
    }

    /**
     * Prueba que entregue correctamente la cantidad de libros.
     */
    public void testDarTotalLibros( )
    {
        setupEscenario3( );
        assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibros( ) == 10 );
    }

    /**
     * Prueba que entregue correctamente la cantidad de libros en préstamo.
     */
    public void testDarTotalLibrosEnPrestamo( )
    {
        setupEscenario3( );
        try
        {
            biblioteca.alquilarLibro( "a", "1" );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibrosEnPrestamo( ) == 1 );
            biblioteca.devolverLibro( "a", "1" );
            assertTrue( "No se alquila correctamente el libro", biblioteca.darTotalLibrosEnPrestamo( ) == 0 );

        }
        catch( CopiasInsuficientesException e )
        {
            fail( e.getMessage( ) + ": No debería ocurrir está excepción" );
        }
    }

    /**
     * Prueba que se autentique correctamente el Usuario identificado por el login.
     */
    public void testAutenticar( )
    {
        setupEscenario3( );
        assertFalse( "Se aceptan auteticaciones incorrectas", biblioteca.autenticar( "a", "b" ) );
        assertTrue( "Nos se aceptan auteticaciones correctas", biblioteca.autenticar( "a", "a" ) );
    }

    /**
     * Prueba que se devuelve el libro identificado por la referencia.
     */
    public void testDarLibro( )
    {
        setupEscenario3( );
        ILibro libro = biblioteca.darLibro( "1" );
        assertTrue( "No se encontro el libro", libro.darTitulo( ).equals( "Del amor y otros demonios" ) );
        assertTrue( "No se encontro el libro", libro.darAutores( ).equals( "\"Gabriel García Márquez\" \"\" \"\"" ) );
    }

    /**
     * Prueba que se inserte correctamente el libro
     */
    public void testAgregarPorReferencia( String referencia )
    {
        setupEscenario3( );
        try
        {
            biblioteca.agregarCopia( "1" );
            assertTrue( "No se agrefa correctamente la copia", biblioteca.darTotalLibros( ) == 11 );
            ILibro libro = biblioteca.darLibro( "1" );
            assertTrue( "No se agrefa correctamente la copia", libro.darCopiasDisponibles( ) == 3 );
        }
        catch( LibroInexistenteException e )
        {
            fail( );
        }
    }

}
