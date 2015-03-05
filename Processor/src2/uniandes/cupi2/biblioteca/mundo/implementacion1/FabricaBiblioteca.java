/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: FabricaBiblioteca.java,v 1.1 2008/09/03 10:50:46 jua-gome Exp $
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

import uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca;
import uniandes.cupi2.biblioteca.mundo.IFabricaBiblioteca;

/**
 * Fabrica que construye bibliotecas.
 */
public class FabricaBiblioteca implements IFabricaBiblioteca
{

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IFabricaBiblioteca#darBiblioteca(java.lang.String, java.lang.String)
     */
    public AbstractBiblioteca darBiblioteca( String archivoSerializacionLibros, String archivoSerializacionUsuarios )
    {
        return new Biblioteca( archivoSerializacionLibros, archivoSerializacionUsuarios );
    }

}
