/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: AbstractBiblioteca.java,v 1.3 2008/09/03 11:44:44 jua-gome Exp $
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

import java.util.Observable;

import annotation.Feature;
import annotation.FeatureType;
import uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException;
import uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException;
import uniandes.cupi2.biblioteca.mundo.excepciones.SalvarBibliotecaException;
import uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException;
import uniandes.cupi2.collections.iterador.Iterador;

/**
 * Clase abstracta que modela el comportamiento de una biblioteca.
 */
//@Feature(featureName="Biblioteca",featureType=FeatureType.AND,isRoot=true)
public abstract class AbstractBiblioteca extends Observable
{

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega Usuario a la biblioteca.
     * @param login Login del usuario - login != null.
     * @param clave Clave del usuario - clave != null.
     * @param nombre Nombre del usuario - nombre != null.
     * @throws UsuarioPreexistenteException Si se intenta ingresar un usuario con login repetido.
     */
    public abstract void insertarUsuario( String login, String clave, String nombre ) throws UsuarioPreexistenteException;

    /**
     * Agrega un libro a la biblioteca.
     * @param titulo Título del libro - titulo != null.
     * @param autores Nombres de los autores del libro - autores != null.
     * @param descriptores Palabras claves del libro - descriptores != null.
     * @param ejemplares Número de copias del libro - ejemplares > 0.
     * @param ref Referencia del libro - referencia != null.
     * @throws LibroYaExisteException Si ya existe un libro con la referencia ingresada.
     */
    public abstract void insertarLibro( String titulo, String[] autores, String[] descriptores, int ejemplares, String ref ) throws LibroYaExisteException;

    /**
     * Busca libro según su título exacto.
     * @param titulo Título del libro que se está buscando - titulo != null.
     * @return Libros que cumplen con los parámetros de búsqueda.
     */
    @Feature(featureName="Buscar",parentName="GestionDeLibros",featureType=FeatureType.AND)
    public abstract Iterador<ILibro> buscarPorTituloExacto( String titulo );

    /**
     * Busca libros según su título.
     * @param datos Palabras a buscar en el título - datos != null.
     * @return Libros que cumplen con los parámetros de búsqueda.
     */
    @Feature(featureName="Buscar",parentName="GestionDeLibros",featureType=FeatureType.AND)
    public abstract Iterador<ILibro> buscarPorTitulo( String datos[] );

    /**
     * Busca libros según su autor exacto.
     * @param autor El nombre del autor seleccionado - datos!= null.
     * @return Libros que cumplen con los parámetros de búsqueda.
     */
    @Feature(featureName="Buscar",parentName="GestionDeLibros",featureType=FeatureType.AND)
    public abstract Iterador<ILibro> buscarPorAutoresExacto( String autor );

    /**
     * Busca libros según alguno de sus autores.
     * @param datos Palabras a buscar en los nombres de los autores - datos != null.
     * @return Libros que cumplen con los parámetros de búsqueda.
     */
    @Feature(featureName="Buscar",parentName="GestionDeLibros",featureType=FeatureType.AND)
    public abstract Iterador<ILibro> buscarPorAutores( String datos[] );

    /**
     * Busca libros según sus descriptores exactos.
     * @param datos Descriptores seleccionados - datos != null.
     * @return Libros que cumplen con los parámetros de búsqueda.
     */
    @Feature(featureName="Buscar",parentName="GestionDeLibros",featureType=FeatureType.AND)
    public abstract Iterador<ILibro> buscarPorDescriptoresExacto( String datos[] );

    /**
     * Busca libros según alguno de sus descriptores.
     * @param datos Palabras a buscar en los descriptores del libro - datos != null.
     * @return Libros que cumplen con los parámetros de búsqueda.
     */
    @Feature(featureName="Buscar",parentName="GestionDeLibros",featureType=FeatureType.AND)
    public abstract Iterador<ILibro> buscarPorDescriptores( String datos[] );

    /**
     * Alquila un libro de la biblioteca.<br>
     * <b>pre: </b> El usuario y el libro seleccionados están registrados en el sistema.
     * @param usuario Login del usuario que alquila el libro - usuario!= null.
     * @param referencia Referencia del libro que se va a alquilar - referencia != null.
     * @throws CopiasInsuficientesException Si el libro no tiene copias disponibles para alquilar.
     */
    public abstract void alquilarLibro( String usuario, String referencia ) throws CopiasInsuficientesException;

    /**
     * Retorna los libros alquilados por un usuario. <br>
     * <b>pre: </b>El usuario seleccionado está registrado en el sistema.
     * @param usuario Usuario seleccionado - usuario != null.
     * @return Los libros alquilados por el usuario seleccionado.
     */
    public abstract Iterador<ILibro> darAlquilados( String usuario );

    /**
     * Devuelve un libro que estaba alquilado. <br>
     * <b>pre: </b>El usuario y libro seleccionado están registrados en el sistema, y el libro seleccionado está alquilado por el usuario seleccionado.
     * @param usuario Login del usuario que está devolviendo el libro - usuario != null.
     * @param referencia Referencia del libro que se está devolviendo - referencia != null.
     */
    public abstract void devolverLibro( String usuario, String referencia );

    /**
     * Retorna la cantidad total de libros de la biblioteca.
     * @return La cantidad total de libros de la biblioteca.
     */
    public abstract int darTotalLibros( );

    /**
     * Retorna la totalidad de copias en préstamo.
     * @return La totalidad de copias en préstamo.
     */
    public abstract int darTotalLibrosEnPrestamo( );

    /**
     * Verifica si una clave corresponde a un login de usuario.
     * @param login Login seleccionado - login != null.
     * @param clave Clave seleccionada - clave != null.
     * @return true si la clave seleccionada corresponde al login seleccionado o false en caso contrario.
     */
    public abstract boolean autenticar( String login, String clave );

    /**
     * Busca un libro dada su referencia.
     * @param ref Referencia del libro buscado - ref != null.
     * @return El libro cuya referencia es la referencia ingresada o null en caso de que éste no exista
     */
    public abstract ILibro darLibro( String ref );

    /**
     * Agrega una copia a un libro.
     * @param referencia Referencia del libro seleccionado - referencia != null.
     * @throws LibroInexistenteException Cuando se intenta ingresar una copia de un libro y el libro no está registrado en el sistema.
     */
    public abstract void agregarCopia( String referencia ) throws LibroInexistenteException;

    // -----------------------------------------------------------------
    // Serialización
    // -----------------------------------------------------------------

    /**
     * Salva la información de la biblioteca.
     * @throws SalvarBibliotecaException Si no se puede salvar la biblioteca.
     */
    public abstract void salvar( ) throws SalvarBibliotecaException;

    /**
     * Carga la información de la biblioteca.
     * @throws CargarBibliotecaException Si no se puede cargar los datos de la biblioteca.
     */
    public abstract void cargar( ) throws CargarBibliotecaException;

}
