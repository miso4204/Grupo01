/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: IFabricaBiblioteca.java,v 1.4 2008/09/03 10:38:24 jua-gome Exp $
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

import uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException;

/**
 * Interfaz que modela el comportamiento de una fábrica de bibliotecas.
 */
public interface IFabricaBiblioteca
{

    /**
     * Fabrica una biblioteca nueva.
     * @param archivoSerializacionLibros Ruta al archivo donde se encuentran los libros serializados.
     * @param archivoSerializacionUsuarios Ruta al archivo donde se encuentran los usuarios serializados.
     * @return Una biblioteca con la información presente en los archivos.
     * @throws CargarBibliotecaException Si se presenta algún error al cargar la información de la biblioteca.
     */
    public abstract AbstractBiblioteca darBiblioteca( String archivoSerializacionLibros, String archivoSerializacionUsuarios ) throws CargarBibliotecaException;

}
