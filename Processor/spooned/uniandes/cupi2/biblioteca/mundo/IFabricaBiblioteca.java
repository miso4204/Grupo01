package uniandes.cupi2.biblioteca.mundo;


/** 
 * Interfaz que modela el comportamiento de una fábrica de bibliotecas.
 */
public interface IFabricaBiblioteca {
    /** 
     * Fabrica una biblioteca nueva.
     * @param archivoSerializacionLibros Ruta al archivo donde se encuentran los libros serializados.
     * @param archivoSerializacionUsuarios Ruta al archivo donde se encuentran los usuarios serializados.
     * @return Una biblioteca con la información presente en los archivos.
     * @throws CargarBibliotecaException Si se presenta algún error al cargar la información de la biblioteca.
     */
    public abstract uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca darBiblioteca(java.lang.String archivoSerializacionLibros, java.lang.String archivoSerializacionUsuarios) throws uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException;
}

