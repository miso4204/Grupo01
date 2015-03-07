/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Usuario.java,v 1.2 2008/09/03 11:21:34 jua-gome Exp $
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

import java.io.Serializable;

import annotation.Feature;
import annotation.FeatureType;
import uniandes.cupi2.biblioteca.mundo.ILibro;
import uniandes.cupi2.biblioteca.mundo.IUsuario;
import uniandes.cupi2.collections.iterador.Iterador;
import uniandes.cupi2.collections.lista.Lista;

/**
 * Clase que representa al usuario.
 */
public class Usuario implements IUsuario, Serializable
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante de serialización.
     */
    private static final long serialVersionUID = -7920037289310482998L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Clave del usuario.
     */
    private String clave;

    /**
     * Login del usuario.
     */
    private String login;

    /**
     * Libros alquilados por el usuario.
     */
    private Lista<ILibro> librosAlquilados;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo usuario.
     * @param login Login del usuario - login != null.
     * @param clave Clave del usuario - clave != null.
     * @param nombre Nombre del usuario - nombre != null.
     */
    public Usuario( String login, String clave, String nombre )
    {
        this.nombre = nombre;
        this.clave = clave;
        this.login = login;
        librosAlquilados = new Lista<ILibro>( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IUsuario#alquilar(uniandes.cupi2.biblioteca.mundo.ILibro)
     */
    public void alquilar( ILibro libro )
    {
        librosAlquilados.agregar( libro );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IUsuario#devolver(uniandes.cupi2.biblioteca.mundo.ILibro)
     */
    public void devolver( ILibro libro )
    {
        librosAlquilados.eliminar( libro );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IUsuario#darNombre()
     */
    public String darNombre( )
    {
        return nombre;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IUsuario#darLogin()
     */
    public String darLogin( )
    {
        return login;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IUsuario#darClave()
     */
    public String darClave( )
    {
        return clave;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IUsuario#darLibrosAlquilados()
     */
    public Iterador<ILibro> darLibrosAlquilados( )
    {
        return librosAlquilados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IUsuario#asignarLibrosAlquilados(uniandes.cupi2.collections.lista.Lista)
     */
    public void asignarLibrosAlquilados( Lista<ILibro> nLibrosAlquilados )
    {
        librosAlquilados = nLibrosAlquilados;
    }

}
