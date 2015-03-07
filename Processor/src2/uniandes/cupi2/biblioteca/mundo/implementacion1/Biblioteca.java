/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Biblioteca.java,v 1.3 2008/09/03 16:06:13 jua-gome Exp $
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
package uniandes.cupi2.biblioteca.mundo.implementacion1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import annotation.Feature;
import annotation.FeatureType;
import annotation.VariationPoint;
import uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca;
import uniandes.cupi2.biblioteca.mundo.ILibro;
import uniandes.cupi2.biblioteca.mundo.IUsuario;
import uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException;
import uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.SalvarBibliotecaException;
import uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException;
import uniandes.cupi2.collections.arbol.ElementoExisteException;
import uniandes.cupi2.collections.arbol.avl.ArbolAVL;
import uniandes.cupi2.collections.conjunto.Conjunto;
import uniandes.cupi2.collections.iterador.Iterador;
import uniandes.cupi2.collections.lista.Lista;
import uniandes.cupi2.collections.tablaHashing.ITablaHashing;
import uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica;

/**
 * Clase que representa una biblioteca.
 */
public class Biblioteca extends AbstractBiblioteca
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos necesarios para la persistencia
    // -----------------------------------------------------------------

    /**
     * Usuarios registrados en el sistema.
     */
    private Lista<IUsuario> usuariosSerializacion;

    /**
     * Libros registrados en el sistema.
     */
    private Lista<ILibro> librosSerializacion;

    /**
     * Archivo donde se encuentran serializados los usuarios.
     */
    private File archivoBinarioUsuarios;

    /**
     * Archivo donde se encuentran serializados los libros.
     */
    private File archivoBinarioLibros;

    // -----------------------------------------------------------------
    // Atributos necesarios para el acceso directo de los libros
    // -----------------------------------------------------------------

    /**
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por referencia.
     */
    private ITablaHashing<String, ILibro> tablaLibroReferencia;

    /**
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por el autor.
     */
    private ITablaHashing<String, Lista<ILibro>> tablaLibrosAutor;

    /**
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por el título.
     */
    private ITablaHashing<String, Lista<ILibro>> tablaLibrosTitulo;

    // -----------------------------------------------------------------
    // Atributos necesarios para la indexación
    // -----------------------------------------------------------------

    /**
     * Árbol AVL de libros ordenado por palabras en el título.
     */
    private ArbolAVL<NodoIndice> indiceNombre;

    /**
     * Árbol AVL de libros ordenado por palabras en el autor.
     */
    private ArbolAVL<NodoIndice> indiceAutor;

    /**
     * Árbol AVL de libros ordenado por por palabras clave.
     */
    private ArbolAVL<NodoIndice> indicePalabraClave;

    // -----------------------------------------------------------------
    // Atributos necesarios para la gestión de usuarios
    // -----------------------------------------------------------------

    /**
     * Tabla de hashing con los usuarios que hay en la Biblioteca ordenados por el login.
     */
    private ITablaHashing<String, Usuario> tablaUsuario;

    /**
     * Número de total de libros.
     */
    private int numeroCopiasPrestamo;

    /**
     * Número de libros en préstamo.
     */
    private int numeroTotalCopias;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye una biblioteca vacía.
     * @param rutaArchivoLibros Ruta donde están archivados los libros.
     * @param rutaArchivosUsuarios Ruta donde están archivados los usuarios.
     */
    public Biblioteca( String rutaArchivoLibros, String rutaArchivosUsuarios )
    {
        // Serialización
        archivoBinarioLibros = new File( rutaArchivoLibros );
        archivoBinarioUsuarios = new File( rutaArchivosUsuarios );
        usuariosSerializacion = new Lista<IUsuario>( );
        librosSerializacion = new Lista<ILibro>( );

        // Tablas
        tablaLibroReferencia = new TablaHashingEstatica<String, ILibro>( );
        tablaLibrosAutor = new TablaHashingEstatica<String, Lista<ILibro>>( );
        tablaLibrosTitulo = new TablaHashingEstatica<String, Lista<ILibro>>( );

        // Indices
        indiceAutor = new ArbolAVL<NodoIndice>( );
        indiceNombre = new ArbolAVL<NodoIndice>( );
        indicePalabraClave = new ArbolAVL<NodoIndice>( );

        // Usuarios
        tablaUsuario = new TablaHashingEstatica<String, Usuario>( );
        numeroTotalCopias = 0;
        numeroCopiasPrestamo = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#agregarCopia(java.lang.String)
     */
    @Feature(featureName="AgregarCopia",parentName="GestionDeLibros")
    public void agregarCopia( String referencia ) throws LibroInexistenteException
    {
        ILibro libro = tablaLibroReferencia.dar( referencia );
        if( libro == null )
            throw new LibroInexistenteException( referencia );
        libro.aumentarCopiasDisponibles( );
        numeroTotalCopias++;
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darLibro(java.lang.String)
     */
    @Feature(featureName="DarLibro",parentName="GestionDeLibros")
    public ILibro darLibro( String referencia )
    {
        return tablaLibroReferencia.dar( referencia );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#autenticar(java.lang.String, java.lang.String)
     */
    @Feature(featureName="AutenticarUsuario",parentName="GestionDeUsuarios")
    public boolean autenticar( String login, String clave )
    {
        Usuario usuario = tablaUsuario.dar( login );
        return usuario != null && usuario.darClave( ).equals( clave );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#insertarUsuario(java.lang.String, java.lang.String, java.lang.String)
     */
    @Feature(featureName="InsertarUsuario",parentName="GestionDeUsuarios")
    public void insertarUsuario( String login, String clave, String nombre ) throws UsuarioPreexistenteException
    {
        Usuario usuario = new Usuario( login, clave, nombre );
        insertarUsuario( usuario );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#insertarLibro(java.lang.String, java.lang.String[], java.lang.String[], int, java.lang.String)
     */
    @Feature(featureName="InsertarLibro",parentName="GestionDeLibros")
    public void insertarLibro( String titulo, String[] autores, String[] descriptores, int ejemplares, String ref ) throws LibroYaExisteException
    {
        Libro libro = new Libro( titulo, autores, descriptores, ejemplares, ref );
        insertarLibro( libro );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorTituloExacto(java.lang.String)
     */
    @Feature(featureName="buscarPorTituloExacto",parentName="Buscar")
    public Iterador<ILibro> buscarPorTituloExacto( String titulo )
    {
        Lista<ILibro> libros = tablaLibrosTitulo.dar( titulo );
        if( libros == null )
            libros = new Lista<ILibro>( );
        return libros.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorTitulo(java.lang.String[])
     */
    @Feature(featureName="Titulo",parentName="Buscar")    
    public Iterador<ILibro> buscarPorTitulo( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        for( int i = 0; i < datos.length; i++ )
        {
            NodoIndice nodo = indiceNombre.buscar( new NodoIndice( datos[ i ] ) );
            if( nodo != null )
            {
                Iterador<ILibro> iterador = nodo.darLibros( );
                while( iterador.haySiguiente( ) )
                    resultados.insertar( iterador.darSiguiente( ) );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorAutoresExacto(java.lang.String)
     */
    @Feature(featureName="AutorExacto",parentName="Buscar")  
    public Iterador<ILibro> buscarPorAutoresExacto( String nombreAutor )
    {
        Lista<ILibro> libros = tablaLibrosAutor.dar( nombreAutor );
        return libros.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorAutores(java.lang.String[])
     */
    @Feature(featureName="Atutor",parentName="Buscar")      
    public Iterador<ILibro> buscarPorAutores( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        for( int i = 0; i < datos.length; i++ )
        {
            NodoIndice nodo = indiceAutor.buscar( new NodoIndice( datos[ i ] ) );
            if( nodo != null )
            {
                Iterador<ILibro> iterador = nodo.darLibros( );
                while( iterador.haySiguiente( ) )
                    resultados.insertar( iterador.darSiguiente( ) );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorDescriptoresExacto(java.lang.String[])
     */
    @Feature(featureName="DescriptorExacto",parentName="Buscar")
    public Iterador<ILibro> buscarPorDescriptoresExacto( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        if( datos.length > 0 )
        {
            Iterador<ILibro> iterador = indicePalabraClave.buscar( new NodoIndice( datos[ 0 ] ) ).darLibros( );
            while( iterador.haySiguiente( ) )
            {
                ILibro libro = iterador.darSiguiente( );
                boolean todosDescriptores = true;
                for( int i = 0; i < datos.length && todosDescriptores; i++ )
                    if( !libro.esDescriptor( datos[ i ] ) )
                        todosDescriptores = false;
                if( todosDescriptores )
                    resultados.insertar( libro );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorDescriptores(java.lang.String[])
     */
    @Feature(featureName="Descriptor",parentName="Buscar")  
    public Iterador<ILibro> buscarPorDescriptores( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        for( int i = 0; i < datos.length; i++ )
        {
            NodoIndice nodoResultante = indicePalabraClave.buscar( new NodoIndice( datos[ i ] ) );
            if( nodoResultante != null )
            {
                Iterador<ILibro> iterador = nodoResultante.darLibros( );
                while( iterador.haySiguiente( ) )
                    resultados.insertar( iterador.darSiguiente( ) );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#alquilarLibro(java.lang.String, java.lang.String)
     */
    @Feature(featureName="AlquilarLibro",parentName="GestionDeLibros")  
    public void alquilarLibro( String elUsuario, String referencia ) throws CopiasInsuficientesException
    {
        IUsuario usuario = tablaUsuario.dar( elUsuario );
        ILibro libro = tablaLibroReferencia.dar( referencia );

        libro.reducirCopiasDisponibles( );
        libro.aumentarCopiasEnPrestamo( );
        usuario.alquilar( libro );
        numeroCopiasPrestamo++;
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#devolverLibro(java.lang.String, java.lang.String)
     */
    @Feature(featureName="DevolverLibro",parentName="GestionDeLibros")
    public void devolverLibro( String elUsuario, String referencia )
    {
        Usuario usuario = tablaUsuario.dar( elUsuario );
        ILibro libro = tablaLibroReferencia.dar( referencia );
        libro.reducirCopiasEnPrestamo( );
        libro.aumentarCopiasDisponibles( );
        usuario.devolver( libro );
        numeroCopiasPrestamo--;
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darTotalLibros()
     */
    @Feature(featureName="NumeroTotalLibros",parentName="GestionDeLibros",mandatory=false)
    public int darTotalLibros( )
    {
        return numeroTotalCopias;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darTotalLibrosEnPrestamo()
     */
    @Feature(featureName="NumeroTotalLibrosPrestados",parentName="GestionDeLibros",mandatory=false)
    public int darTotalLibrosEnPrestamo( )
    {
        return numeroCopiasPrestamo;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darAlquilados(java.lang.String)
     */
    @Feature(featureName="DarAlquilados",parentName="GestionDeLibros")
    public Iterador<ILibro> darAlquilados( String elUsuario )
    {
        Usuario usuario = tablaUsuario.dar( elUsuario );
        return usuario.darLibrosAlquilados( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#salvar()
     */
    public void salvar( ) throws SalvarBibliotecaException
    {
        try
        {
            ObjectOutputStream oos2 = new ObjectOutputStream( new FileOutputStream( archivoBinarioUsuarios ) );
            ObjectOutputStream oos1 = new ObjectOutputStream( new FileOutputStream( archivoBinarioLibros ) );
            oos1.writeObject( librosSerializacion );
            oos2.writeObject( usuariosSerializacion );
            oos1.close( );
            oos2.close( );
        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace( );
            throw new SalvarBibliotecaException( "Error al salvar la biblioteca" );
        }
        catch( IOException e )
        {
            e.printStackTrace( );
            throw new SalvarBibliotecaException( "Error al salvar la biblioteca" );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#cargar()
     */
    public void cargar( ) throws CargarBibliotecaException
    {
        // Cargar los libros
        try
        {
            ObjectInputStream ois2;
            ois2 = new ObjectInputStream( new FileInputStream( archivoBinarioLibros ) );
            Lista<ILibro> librosSerializacion = ( Lista<ILibro> )ois2.readObject( );
            // Inserción libros serialización.
            for( Iterador<ILibro> iter = librosSerializacion.darIterador( ); iter.haySiguiente( ); )
            {
                ILibro libro = iter.darSiguiente( );
                insertarLibro( libro.darTitulo( ), libro.darArregloAutores( ), libro.darArregloDescriptores( ), libro.darCopiasDisponibles( ) + libro.darCopiasPrestamo( ), libro.darReferencia( ) );
            }
            ois2.close( );
        }
        catch( FileNotFoundException e )
        {
            throw new CargarBibliotecaException( "El archivo binario de libros no existe." );
        }
        catch( IOException e )
        {
            throw new CargarBibliotecaException( "Problemas en la lectura del archivo binario de libros." );
        }
        catch( ClassNotFoundException e )
        {
            throw new CargarBibliotecaException( "Problemas en la versión del archivo binario de libros." );
        }
        catch( LibroYaExisteException e )
        {
            throw new CargarBibliotecaException( "El archivo de libros es inconsistente: " + e.getMessage( ) );
        }

        // Cargar los usuarios
        try
        {
            ObjectInputStream ois1;
            ois1 = new ObjectInputStream( new FileInputStream( archivoBinarioUsuarios ) );
            Lista<IUsuario> usuariosSerializacion = ( Lista<IUsuario> )ois1.readObject( );
            // Inserción usuarios serialización.
            for( Iterador<IUsuario> iter = usuariosSerializacion.darIterador( ); iter.haySiguiente( ); )
            {
                IUsuario usuario = iter.darSiguiente( );

                // Insertar el usuario
                insertarUsuario( usuario.darLogin( ), usuario.darClave( ), usuario.darNombre( ) );

                // Registrar los prestamos del usuario
                Iterador<ILibro> librosAlquilados = usuario.darLibrosAlquilados( );
                while( librosAlquilados.haySiguiente( ) )
                    alquilarLibro( usuario.darLogin( ), librosAlquilados.darSiguiente( ).darReferencia( ) );
            }
            ois1.close( );
        }
        catch( FileNotFoundException e )
        {
            throw new CargarBibliotecaException( "El archivo binario de usuarios no existe." );
        }
        catch( IOException e )
        {
            throw new CargarBibliotecaException( "Problemas en la lectura del archivo binario de usuarios." );
        }
        catch( ClassNotFoundException e )
        {
            throw new CargarBibliotecaException( "Problemas en la versión del archivo binario de usuarios." );
        }
        catch( UsuarioPreexistenteException e )
        {
            throw new CargarBibliotecaException( "El archivo de usuarios es incosistente: " + e.getMessage( ) );
        }
        catch( CopiasInsuficientesException e )
        {
            throw new CargarBibliotecaException( "El archivo de usuarios es incosistente: " + e.getMessage( ) );
        }
    }

    // -----------------------------------------------------------------
    // Métodos auxiliares
    // -----------------------------------------------------------------

    /**
     * Agrega Usuario a la biblioteca.
     * @param usuario Usuario que se va insertar en el sistema de bibliotecas - usuario != null.
     * @throws UsuarioPreexistenteException Si se intenta ingresar un usuario con login repetido.
     */
    private void insertarUsuario( Usuario usuario ) throws UsuarioPreexistenteException
    {
        if( tablaUsuario.dar( usuario.darLogin( ) ) != null )
            throw new UsuarioPreexistenteException( usuario );
        tablaUsuario.agregar( usuario.darLogin( ), usuario );
        usuariosSerializacion.agregar( usuario );
    }

    /**
     * Agrega un libro a la biblioteca.
     * @param libro Libro a insertar en el sistema - libro != null.
     * @throws LibroYaExisteException Si ya existe un libro con la referencia ingresada.
     */
    private void insertarLibro( ILibro libro ) throws LibroYaExisteException
    {
        if( tablaLibroReferencia.dar( libro.darReferencia( ) ) != null )
            throw new LibroYaExisteException( libro.darReferencia( ) );

        // Inserción en la tabla de referencias.
        tablaLibroReferencia.agregar( libro.darReferencia( ), libro );

        // Inserción en la tabla de autores.
        String[] autores = libro.darArregloAutores( );
        for( int i = 0; i < autores.length; i++ )
        {
            Lista<ILibro> libros = tablaLibrosAutor.dar( autores[ i ] );
            if( libros == null )
            {
                libros = new Lista<ILibro>( );
                libros.agregar( libro );
                tablaLibrosAutor.agregar( autores[ i ], libros );
            }
            else if( libros.buscar( libro ) == -1 )
                libros.agregar( libro );
        }

        // Inserción en la tabla de títulos.
        String titulo = libro.darTitulo( );
        Lista<ILibro> libros = tablaLibrosTitulo.dar( titulo );
        if( libros == null )
        {
            libros = new Lista<ILibro>( );
            libros.agregar( libro );
            tablaLibrosTitulo.agregar( titulo, libros );
        }
        else
            libros.agregar( libro );

        // Inserción en índice de autor.
        for( int i = 0; i < autores.length; i++ )
            insertarEnIndice( libro, indiceAutor, autores[ i ].split( " " ) );

        // Inserción en índice de descriptores
        insertarEnIndice( libro, indicePalabraClave, libro.darArregloDescriptores( ) );

        // Inserción en índice de título
        insertarEnIndice( libro, indiceNombre, titulo.split( " " ) );

        numeroTotalCopias += ( libro.darCopiasDisponibles( ) + libro.darCopiasPrestamo( ) );
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
        librosSerializacion.agregar( libro );
    }

    /**
     * Inserta un libro en un índice.
     * @param libro Libro que se quiere insertar.
     * @param indice Índice en donde se quiere insertar el libro.
     * @param llaves Llaves con las que se quiere asociar el libro dentro del indice.
     */
    private void insertarEnIndice( ILibro libro, ArbolAVL<NodoIndice> indice, String[] llaves )
    {
        try
        {
            for( int i = 0; i < llaves.length; i++ )
            {
                NodoIndice nodoTemp = new NodoIndice( llaves[ i ] );
                NodoIndice nodo = indice.buscar( new NodoIndice( llaves[ i ] ) );
                if( nodo == null )
                {
                    nodoTemp.agregarLibro( libro );
                    indice.insertar( nodoTemp );
                }
                else
                    nodo.agregarLibro( libro );
            }
        }
        catch( ElementoExisteException e )
        {
            // Esto no va a suceder
        }
    }

}
