package uniandes.cupi2.biblioteca.mundo.implementacion1;


/** 
 * Clase que representa un libros.
 */
public class Libro implements uniandes.cupi2.biblioteca.mundo.ILibro {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = -8041695659181839380L;
    
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
    private java.lang.String[] autores;
    
    /** 
     * Descriptores asociados al libro.
     */
    private java.lang.String[] descriptores;
    
    /** 
     * Título del libro.
     */
    private java.lang.String titulo;
    
    /** 
     * Referencia del libro.
     */
    private java.lang.String referencia;
    
    /** 
     * Crea un nuevo libro.
     * @param titulo Título del libro - titulo != null.
     * @param autores Autores del libro - autores != null.
     * @param descriptores Descriptores del libro - descriptores != null.
     * @param ejemplares Número de ejemplares del libro - ejemplares > 0.
     * @param referencia Referencia del libro - referencia != null.
     */
    public Libro(java.lang.String titulo ,java.lang.String[] autores ,java.lang.String[] descriptores ,int ejemplares ,java.lang.String referencia) {
        this.titulo = titulo;
        this.autores = autores;
        this.descriptores = descriptores;
        copiasDisponibles = ejemplares;
        this.referencia = referencia;
        copiasEnPrestamo = 0;
    }
    
    public void reducirCopiasDisponibles() throws uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException {
        if ((copiasDisponibles) == 0)
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException(this);
        
        (copiasDisponibles)--;
    }
    
    public void reducirCopiasEnPrestamo() {
        (copiasEnPrestamo)--;
    }
    
    public void aumentarCopiasDisponibles() {
        (copiasDisponibles)++;
    }
    
    public void aumentarCopiasEnPrestamo() {
        (copiasEnPrestamo)++;
    }
    
    public java.lang.String darReferencia() {
        return referencia;
    }
    
    public java.lang.String darTitulo() {
        return titulo;
    }
    
    public java.lang.String darAutores() {
        java.lang.String autor = ("\"" + (autores[0])) + "\"";
        for (int i = 1 ; i < (autores.length) ; i++)
            autor = (((autor + " ") + "\"") + (autores[i])) + "\"";
        return autor;
    }
    
    public java.lang.String[] darArregloAutores() {
        return autores;
    }
    
    public java.lang.String darDescriptores() {
        java.lang.String des = ("\"" + (descriptores[0])) + "\"";
        for (int i = 1 ; i < (descriptores.length) ; i++)
            des = (((des + " ") + "\"") + (descriptores[i])) + "\"";
        return des;
    }
    
    public int darCopiasDisponibles() {
        return copiasDisponibles;
    }
    
    public int darCopiasPrestamo() {
        return copiasEnPrestamo;
    }
    
    public int compareTo(uniandes.cupi2.biblioteca.mundo.ILibro libro) {
        if (referencia.equals(libro.darReferencia()))
            return 0;
        else if ((titulo.compareTo(libro.darTitulo())) == 0)
            return libro.darAutores().compareTo(darAutores());
        else
            return titulo.compareTo(libro.darTitulo());
        
    }
    
    public java.lang.String[] darArregloDescriptores() {
        return descriptores;
    }
    
    public boolean esDescriptor(java.lang.String descriptor) {
        boolean esDescritor = false;
        for (int i = 0 ; i < (descriptores.length) ; i++)
            esDescritor |= descriptores[i].equals(descriptor);
        return esDescritor;
    }
    
}

