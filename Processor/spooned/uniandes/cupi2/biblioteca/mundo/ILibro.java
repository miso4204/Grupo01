package uniandes.cupi2.biblioteca.mundo;


/** 
 * Interfaz que modela el comportamiento de un libro.
 */
@annotation.Feature(featureName = "GestionDeLibros", featureType = annotation.FeatureType.AND, parentName = "Biblioteca")
public interface ILibro extends java.io.Serializable , java.lang.Comparable<uniandes.cupi2.biblioteca.mundo.ILibro> {
    /** 
     * Reduce el número de copias disponibles en 1.
     * @throws CopiasInsuficientesException El libro no tiene copias suficientes.
     */
    public void reducirCopiasDisponibles() throws uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;
    /** 
     * Reduce el número de copias en préstamo en 1.
     */
    public void reducirCopiasEnPrestamo();
    /** 
     * Aumenta el número de copias disponibles en 1.
     */
    public void aumentarCopiasDisponibles();
    /** 
     * Aumenta el número de copias en préstamo en 1.
     */
    public void aumentarCopiasEnPrestamo();
    /** 
     * Retorna la referencia del libro.
     * @return La referencia del libro.
     */
    public java.lang.String darReferencia();
    /** 
     * Retorna el título del libro.
     * @return El título del libro.
     */
    public java.lang.String darTitulo();
    /** 
     * Retorna una cadena de caracteres con todos los autores asociados al libro.
     * @return Una cadena de caracteres con todos los autores asociados al libro.
     */
    public java.lang.String darAutores();
    /** 
     * Retorna el arreglo de autores del libro.
     * @return El arreglo de autores del libro.
     */
    public java.lang.String[] darArregloAutores();
    /** 
     * Retorna una cadena de caracteres con todos los descriptores asociados al libro.
     * @return Una cadena de caracteres con todos los descriptores asociados al libro.
     */
    public java.lang.String darDescriptores();
    /** 
     * Retorna el número de copias disponibles.
     * @return El número de copias disponibles.
     */
    public int darCopiasDisponibles();
    /** 
     * Retorna el número de copias en préstamo.
     * @return El número de copias en préstamo.
     */
    public int darCopiasPrestamo();
    /** 
     * Retorna el arreglo de descriptores.
     * @return El arreglo de descriptores.
     */
    public java.lang.String[] darArregloDescriptores();
    /** 
     * Verifica si la cadena dada es un descriptor del libro.
     * @param descriptor Descriptor a verificar.
     * @return true si la cadena dada es un descriptor del libro o false en caso contrario.
     */
    public boolean esDescriptor(java.lang.String descriptor);
}

