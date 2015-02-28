/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Libro.java,v 1.2 2008/09/03 10:48:21 jua-gome Exp $
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

import uniandes.cupi2.biblioteca.mundo.ILibro;
import uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;

/**
 * Clase que representa un libros.
 */
public class Libro implements ILibro
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante de serialización.
     */
    private static final long serialVersionUID = -8041695659181839380L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Número de copias disponibles.
     */
    private int copiasDisponibles;

    /**
     * Número de copias que están en préstamo.
     */
    private int copiasEnPrestamo;

    /**
     * Autores asociados al libro.
     */
    private String autores[];

    /**
     * Descriptores asociados al libro.
     */
    private String descriptores[];

    /**
     * Título del libro.
     */
    private String titulo;

    /**
     * Referencia del libro.
     */
    private String referencia;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo libro.
     * @param titulo Título del libro - titulo != null.
     * @param autores Autores del libro - autores != null.
     * @param descriptores Descriptores del libro - descriptores != null.
     * @param ejemplares Número de ejemplares del libro - ejemplares > 0.
     * @param referencia Referencia del libro - referencia != null.
     */
    public Libro( String titulo, String[] autores, String[] descriptores, int ejemplares, String referencia )
    {
        this.titulo = titulo;
        this.autores = autores;
        this.descriptores = descriptores;
        copiasDisponibles = ejemplares;
        this.referencia = referencia;
        copiasEnPrestamo = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#reducirCopiasDisponibles()
     */
    public void reducirCopiasDisponibles( ) throws CopiasInsuficientesException
    {
        if( copiasDisponibles == 0 )
            throw new CopiasInsuficientesException( this );
        copiasDisponibles--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#reducirCopiasEnPrestamo()
     */
    public void reducirCopiasEnPrestamo( )
    {
        copiasEnPrestamo--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#aumentarCopiasDisponibles()
     */
    public void aumentarCopiasDisponibles( )
    {
        copiasDisponibles++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#aumentarCopiasEnPrestamo()
     */
    public void aumentarCopiasEnPrestamo( )
    {
        copiasEnPrestamo++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darReferencia()
     */
    public String darReferencia( )
    {
        return referencia;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darTitulo()
     */
    public String darTitulo( )
    {
        return titulo;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darAutores()
     */
    public String darAutores( )
    {
        String autor = "\"" + autores[ 0 ] + "\"";
        for( int i = 1; i < autores.length; i++ )
            autor = autor + " " + "\"" + autores[ i ] + "\"";
        return autor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darArregloAutores()
     */
    public String[] darArregloAutores( )
    {
        return autores;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darDescriptores()
     */
    public String darDescriptores( )
    {
        String des = "\"" + descriptores[ 0 ] + "\"";
        for( int i = 1; i < descriptores.length; i++ )
            des = des + " " + "\"" + descriptores[ i ] + "\"";
        return des;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darCopiasDisponibles()
     */
    public int darCopiasDisponibles( )
    {
        return copiasDisponibles;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darCopiasPrestamo()
     */
    public int darCopiasPrestamo( )
    {
        return copiasEnPrestamo;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo( ILibro libro )
    {
        if( referencia.equals( libro.darReferencia( ) ) )
            return 0;
        else if( titulo.compareTo( libro.darTitulo( ) ) == 0 )
            return libro.darAutores( ).compareTo( darAutores( ) );
        else
            return titulo.compareTo( libro.darTitulo( ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#darArregloDescriptores()
     */
    public String[] darArregloDescriptores( )
    {
        return descriptores;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.ILibro#esDescriptor(java.lang.String)
     */
    public boolean esDescriptor( String descriptor )
    {
        boolean esDescritor = false;
        for( int i = 0; i < descriptores.length; i++ )
            esDescritor |= descriptores[ i ].equals( descriptor );
        return esDescritor;
    }

}
