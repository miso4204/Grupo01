/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CopiasInsuficientesException.java,v 1.2 2008/09/03 10:38:04 jua-gome Exp $
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
package uniandes.cupi2.biblioteca.mundo.excepciones;

import uniandes.cupi2.biblioteca.mundo.implementacion1.Libro;

/**
 * Excepción lanzada cuando se intenta prestar un libro que no tiene copias disponibles.
 */
public class CopiasInsuficientesException extends Exception
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante de serialización.
     */
    private static final long serialVersionUID = -3638303840577988228L;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de la excepción.
     * @param libro Libro que generó el error de préstamo.
     */
    public CopiasInsuficientesException( Libro libro )
    {
        super( "El libro " + libro.darTitulo( ) + " no tiene copias disponibles" );
    }

}
