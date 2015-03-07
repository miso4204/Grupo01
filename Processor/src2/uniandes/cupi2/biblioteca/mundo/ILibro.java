/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ILibro.java,v 1.3 2008/09/03 10:38:45 jua-gome Exp $
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
package uniandes.cupi2.biblioteca.mundo;

import java.io.Serializable;

import annotation.Feature;
import annotation.FeatureType;
import uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;

/**
 * Interfaz que modela el comportamiento de un libro.
 */
@Feature(featureName="GestionDeLibros",featureType=FeatureType.AND,parentName="Biblioteca")
public interface ILibro extends Serializable, Comparable<ILibro>
{

    /**
     * Reduce el número de copias disponibles en 1.
     * @throws CopiasInsuficientesException El libro no tiene copias suficientes.
     */
    public void reducirCopiasDisponibles( ) throws CopiasInsuficientesException;

    /**
     * Reduce el número de copias en préstamo en 1.
     */
    public void reducirCopiasEnPrestamo( );

    /**
     * Aumenta el número de copias disponibles en 1.
     */
    public void aumentarCopiasDisponibles( );

    /**
     * Aumenta el número de copias en préstamo en 1.
     */
    public void aumentarCopiasEnPrestamo( );

    /**
     * Retorna la referencia del libro.
     * @return La referencia del libro.
     */
    public String darReferencia( );

    /**
     * Retorna el título del libro.
     * @return El título del libro.
     */
    public String darTitulo( );

    /**
     * Retorna una cadena de caracteres con todos los autores asociados al libro.
     * @return Una cadena de caracteres con todos los autores asociados al libro.
     */
    public String darAutores( );

    /**
     * Retorna el arreglo de autores del libro.
     * @return El arreglo de autores del libro.
     */
    public String[] darArregloAutores( );

    /**
     * Retorna una cadena de caracteres con todos los descriptores asociados al libro.
     * @return Una cadena de caracteres con todos los descriptores asociados al libro.
     */
    public String darDescriptores( );

    /**
     * Retorna el número de copias disponibles.
     * @return El número de copias disponibles.
     */
    public int darCopiasDisponibles( );

    /**
     * Retorna el número de copias en préstamo.
     * @return El número de copias en préstamo.
     */
    public int darCopiasPrestamo( );

    /**
     * Retorna el arreglo de descriptores.
     * @return El arreglo de descriptores.
     */
    public String[] darArregloDescriptores( );

    /**
     * Verifica si la cadena dada es un descriptor del libro.
     * @param descriptor Descriptor a verificar.
     * @return true si la cadena dada es un descriptor del libro o false en caso contrario.
     */
    public boolean esDescriptor( String descriptor );

}
