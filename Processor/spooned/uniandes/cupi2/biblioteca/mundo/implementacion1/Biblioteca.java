package uniandes.cupi2.biblioteca.mundo.implementacion1;


/** 
 * Clase que representa una biblioteca.
 */
public class Biblioteca extends uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca {
    /** 
     * Usuarios registrados en el sistema.
     */
    private uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.IUsuario>  usuariosSerializacion;
    
    /** 
     * Libros registrados en el sistema.
     */
    private uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  librosSerializacion;
    
    /** 
     * Archivo donde se encuentran serializados los usuarios.
     */
    private java.io.File archivoBinarioUsuarios;
    
    /** 
     * Archivo donde se encuentran serializados los libros.
     */
    private java.io.File archivoBinarioLibros;
    
    /** 
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por referencia.
     */
    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, uniandes.cupi2.biblioteca.mundo.ILibro>  tablaLibroReferencia;
    
    /** 
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por el autor.
     */
    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>>  tablaLibrosAutor;
    
    /** 
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por el título.
     */
    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>>  tablaLibrosTitulo;
    
    /** 
     * Árbol AVL de libros ordenado por palabras en el título.
     */
    private uniandes.cupi2.collections.arbol.avl.ArbolAVL<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice>  indiceNombre;
    
    /** 
     * Árbol AVL de libros ordenado por palabras en el autor.
     */
    private uniandes.cupi2.collections.arbol.avl.ArbolAVL<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice>  indiceAutor;
    
    /** 
     * Árbol AVL de libros ordenado por por palabras clave.
     */
    private uniandes.cupi2.collections.arbol.avl.ArbolAVL<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice>  indicePalabraClave;
    
    /** 
     * Tabla de hashing con los usuarios que hay en la Biblioteca ordenados por el login.
     */
    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario>  tablaUsuario;
    
    /** 
     * Número de total de libros.
     */
    private int numeroCopiasPrestamo;
    
    /** 
     * Número de libros en préstamo.
     */
    private int numeroTotalCopias;
    
    /** 
     * Construye una biblioteca vacía.
     * @param rutaArchivoLibros Ruta donde están archivados los libros.
     * @param rutaArchivosUsuarios Ruta donde están archivados los usuarios.
     */
    public Biblioteca(java.lang.String rutaArchivoLibros ,java.lang.String rutaArchivosUsuarios) {
        archivoBinarioLibros = new java.io.File(rutaArchivoLibros);
        archivoBinarioUsuarios = new java.io.File(rutaArchivosUsuarios);
        usuariosSerializacion = new uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.IUsuario> ();
        librosSerializacion = new uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro> ();
        tablaLibroReferencia = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, uniandes.cupi2.biblioteca.mundo.ILibro> ();
        tablaLibrosAutor = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>> ();
        tablaLibrosTitulo = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>> ();
        indiceAutor = new uniandes.cupi2.collections.arbol.avl.ArbolAVL<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice> ();
        indiceNombre = new uniandes.cupi2.collections.arbol.avl.ArbolAVL<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice> ();
        indicePalabraClave = new uniandes.cupi2.collections.arbol.avl.ArbolAVL<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice> ();
        tablaUsuario = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario> ();
        numeroTotalCopias = 0;
        numeroCopiasPrestamo = 0;
    }
    
    @annotation.Feature(featureName = "agregarCopia")
    public void agregarCopia(java.lang.String referencia) throws uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException {
        uniandes.cupi2.biblioteca.mundo.ILibro libro = tablaLibroReferencia.dar(referencia);
        if (libro == null)
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException(referencia);
        
        libro.aumentarCopiasDisponibles();
        (numeroTotalCopias)++;
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
    }
    
    @annotation.Feature(featureName = "darLibroPorReferencia")
    public uniandes.cupi2.biblioteca.mundo.ILibro darLibro(java.lang.String referencia) {
        return tablaLibroReferencia.dar(referencia);
    }
    
    @annotation.Feature(featureName = "autenticar")
    public boolean autenticar(java.lang.String login, java.lang.String clave) {
        uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario usuario = tablaUsuario.dar(login);
        return (usuario != null) && (usuario.darClave().equals(clave));
    }
    
    @annotation.Feature(featureName = "insertarUsuario")
    public void insertarUsuario(java.lang.String login, java.lang.String clave, java.lang.String nombre) throws uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException {
        uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario usuario = new uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario(login , clave , nombre);
        insertarUsuario(usuario);
    }
    
    @annotation.Feature(featureName = "insertarLibro")
    public void insertarLibro(java.lang.String titulo, java.lang.String[] autores, java.lang.String[] descriptores, int ejemplares, java.lang.String ref) throws uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException {
        uniandes.cupi2.biblioteca.mundo.implementacion1.Libro libro = new uniandes.cupi2.biblioteca.mundo.implementacion1.Libro(titulo , autores , descriptores , ejemplares , ref);
        insertarLibro(libro);
    }
    
    @annotation.Feature(featureName = "buscarPorTituloExacto")
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorTituloExacto(java.lang.String titulo) {
        uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = tablaLibrosTitulo.dar(titulo);
        if (libros == null)
            libros = new uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro> ();
        
        return libros.darIterador();
    }
    
    @annotation.Feature(featureName = "buscarPorTitulo")
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorTitulo(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro>  resultados = new uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro> ();
        for (int i = 0 ; i < (datos.length) ; i++) {
            uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice nodo = indiceNombre.buscar(new uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice(datos[i]));
            if (nodo != null) {
                uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  iterador = nodo.darLibros();
                while (iterador.haySiguiente())
                    resultados.insertar(iterador.darSiguiente());
            } 
        }
        return resultados.darIterador();
    }
    
    @annotation.Feature(featureName = "buscarPorAutoresExacto")
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorAutoresExacto(java.lang.String nombreAutor) {
        uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = tablaLibrosAutor.dar(nombreAutor);
        return libros.darIterador();
    }
    
    @annotation.Feature(featureName = "buscarPorAutores")
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorAutores(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro>  resultados = new uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro> ();
        for (int i = 0 ; i < (datos.length) ; i++) {
            uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice nodo = indiceAutor.buscar(new uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice(datos[i]));
            if (nodo != null) {
                uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  iterador = nodo.darLibros();
                while (iterador.haySiguiente())
                    resultados.insertar(iterador.darSiguiente());
            } 
        }
        return resultados.darIterador();
    }
    
    @annotation.Feature(featureName = "buscarPorDescriptoresExacto")
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorDescriptoresExacto(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro>  resultados = new uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro> ();
        if ((datos.length) > 0) {
            uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  iterador = indicePalabraClave.buscar(new uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice(datos[0])).darLibros();
            while (iterador.haySiguiente()) {
                uniandes.cupi2.biblioteca.mundo.ILibro libro = iterador.darSiguiente();
                boolean todosDescriptores = true;
                for (int i = 0 ; (i < (datos.length)) && todosDescriptores ; i++)
                    if (!(libro.esDescriptor(datos[i])))
                        todosDescriptores = false;
                    
                if (todosDescriptores)
                    resultados.insertar(libro);
                
            }
        } 
        return resultados.darIterador();
    }
    
    @annotation.Feature(featureName = "buscarPorDescriptores")
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorDescriptores(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro>  resultados = new uniandes.cupi2.collections.conjunto.Conjunto<uniandes.cupi2.biblioteca.mundo.ILibro> ();
        for (int i = 0 ; i < (datos.length) ; i++) {
            uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice nodoResultante = indicePalabraClave.buscar(new uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice(datos[i]));
            if (nodoResultante != null) {
                uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  iterador = nodoResultante.darLibros();
                while (iterador.haySiguiente())
                    resultados.insertar(iterador.darSiguiente());
            } 
        }
        return resultados.darIterador();
    }
    
    @annotation.Feature(featureName = "alquilarLibro")
    public void alquilarLibro(java.lang.String elUsuario, java.lang.String referencia) throws uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException {
        uniandes.cupi2.biblioteca.mundo.IUsuario usuario = tablaUsuario.dar(elUsuario);
        uniandes.cupi2.biblioteca.mundo.ILibro libro = tablaLibroReferencia.dar(referencia);
        libro.reducirCopiasDisponibles();
        libro.aumentarCopiasEnPrestamo();
        usuario.alquilar(libro);
        (numeroCopiasPrestamo)++;
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
    }
    
    @annotation.Feature(featureName = "devolverLibro")
    public void devolverLibro(java.lang.String elUsuario, java.lang.String referencia) {
        uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario usuario = tablaUsuario.dar(elUsuario);
        uniandes.cupi2.biblioteca.mundo.ILibro libro = tablaLibroReferencia.dar(referencia);
        libro.reducirCopiasEnPrestamo();
        libro.aumentarCopiasDisponibles();
        usuario.devolver(libro);
        (numeroCopiasPrestamo)--;
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
    }
    
    @annotation.Feature(featureName = "darTotalLibros")
    public int darTotalLibros() {
        return numeroTotalCopias;
    }
    
    @annotation.Feature(featureName = "darTotalLibrosEnPrestamo")
    public int darTotalLibrosEnPrestamo() {
        return numeroCopiasPrestamo;
    }
    
    @annotation.Feature(featureName = "darAlquilados")
    public uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  darAlquilados(java.lang.String elUsuario) {
        uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario usuario = tablaUsuario.dar(elUsuario);
        return usuario.darLibrosAlquilados();
    }
    
    public void salvar() throws uniandes.cupi2.biblioteca.mundo.excepciones.SalvarBibliotecaException {
        try {
            java.io.ObjectOutputStream oos2 = new java.io.ObjectOutputStream(new java.io.FileOutputStream(archivoBinarioUsuarios));
            java.io.ObjectOutputStream oos1 = new java.io.ObjectOutputStream(new java.io.FileOutputStream(archivoBinarioLibros));
            oos1.writeObject(librosSerializacion);
            oos2.writeObject(usuariosSerializacion);
            oos1.close();
            oos2.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.SalvarBibliotecaException("Error al salvar la biblioteca");
        } catch (java.io.IOException e) {
            e.printStackTrace();
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.SalvarBibliotecaException("Error al salvar la biblioteca");
        }
    }
    
    public void cargar() throws uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException {
        try {
            java.io.ObjectInputStream ois2;
            ois2 = new java.io.ObjectInputStream(new java.io.FileInputStream(archivoBinarioLibros));
            uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  librosSerializacion = ((uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro> )(ois2.readObject()));
            for (uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  iter = librosSerializacion.darIterador() ; iter.haySiguiente() ; ) {
                uniandes.cupi2.biblioteca.mundo.ILibro libro = iter.darSiguiente();
                insertarLibro(libro.darTitulo() ,libro.darArregloAutores() ,libro.darArregloDescriptores() ,((libro.darCopiasDisponibles()) + (libro.darCopiasPrestamo())) ,libro.darReferencia());
            }
            ois2.close();
        } catch (java.io.FileNotFoundException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException("El archivo binario de libros no existe.");
        } catch (java.io.IOException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la lectura del archivo binario de libros.");
        } catch (java.lang.ClassNotFoundException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la versión del archivo binario de libros.");
        } catch (uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException(("El archivo de libros es inconsistente: " + (e.getMessage())));
        }
        try {
            java.io.ObjectInputStream ois1;
            ois1 = new java.io.ObjectInputStream(new java.io.FileInputStream(archivoBinarioUsuarios));
            uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.IUsuario>  usuariosSerializacion = ((uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.IUsuario> )(ois1.readObject()));
            for (uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.IUsuario>  iter = usuariosSerializacion.darIterador() ; iter.haySiguiente() ; ) {
                uniandes.cupi2.biblioteca.mundo.IUsuario usuario = iter.darSiguiente();
                insertarUsuario(usuario.darLogin() ,usuario.darClave() ,usuario.darNombre());
                uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  librosAlquilados = usuario.darLibrosAlquilados();
                while (librosAlquilados.haySiguiente())
                    alquilarLibro(usuario.darLogin() ,librosAlquilados.darSiguiente().darReferencia());
            }
            ois1.close();
        } catch (java.io.FileNotFoundException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException("El archivo binario de usuarios no existe.");
        } catch (java.io.IOException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la lectura del archivo binario de usuarios.");
        } catch (java.lang.ClassNotFoundException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la versión del archivo binario de usuarios.");
        } catch (uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException(("El archivo de usuarios es incosistente: " + (e.getMessage())));
        } catch (uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException e) {
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException(("El archivo de usuarios es incosistente: " + (e.getMessage())));
        }
    }
    
    /** 
     * Agrega Usuario a la biblioteca.
     * @param usuario Usuario que se va insertar en el sistema de bibliotecas - usuario != null.
     * @throws UsuarioPreexistenteException Si se intenta ingresar un usuario con login repetido.
     */
    private void insertarUsuario(uniandes.cupi2.biblioteca.mundo.implementacion1.Usuario usuario) throws uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException {
        if ((tablaUsuario.dar(usuario.darLogin())) != null)
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException(usuario);
        
        tablaUsuario.agregar(usuario.darLogin() ,usuario);
        usuariosSerializacion.agregar(usuario);
    }
    
    /** 
     * Agrega un libro a la biblioteca.
     * @param libro Libro a insertar en el sistema - libro != null.
     * @throws LibroYaExisteException Si ya existe un libro con la referencia ingresada.
     */
    private void insertarLibro(uniandes.cupi2.biblioteca.mundo.ILibro libro) throws uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException {
        if ((tablaLibroReferencia.dar(libro.darReferencia())) != null)
            throw new uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException(libro.darReferencia());
        
        tablaLibroReferencia.agregar(libro.darReferencia() ,libro);
        java.lang.String[] autores = libro.darArregloAutores();
        for (int i = 0 ; i < (autores.length) ; i++) {
            uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = tablaLibrosAutor.dar(autores[i]);
            if (libros == null) {
                libros = new uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro> ();
                libros.agregar(libro);
                tablaLibrosAutor.agregar(autores[i] ,libros);
            } else if ((libros.buscar(libro)) == (-1))
                libros.agregar(libro);
            
        }
        java.lang.String titulo = libro.darTitulo();
        uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = tablaLibrosTitulo.dar(titulo);
        if (libros == null) {
            libros = new uniandes.cupi2.collections.lista.Lista<uniandes.cupi2.biblioteca.mundo.ILibro> ();
            libros.agregar(libro);
            tablaLibrosTitulo.agregar(titulo ,libros);
        } else
            libros.agregar(libro);
        
        for (int i = 0 ; i < (autores.length) ; i++)
            insertarEnIndice(libro ,indiceAutor ,autores[i].split(" "));
        insertarEnIndice(libro ,indicePalabraClave ,libro.darArregloDescriptores());
        insertarEnIndice(libro ,indiceNombre ,titulo.split(" "));
        numeroTotalCopias += (libro.darCopiasDisponibles()) + (libro.darCopiasPrestamo());
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
        librosSerializacion.agregar(libro);
    }
    
    /** 
     * Inserta un libro en un índice.
     * @param libro Libro que se quiere insertar.
     * @param indice Índice en donde se quiere insertar el libro.
     * @param llaves Llaves con las que se quiere asociar el libro dentro del indice.
     */
    private void insertarEnIndice(uniandes.cupi2.biblioteca.mundo.ILibro libro, uniandes.cupi2.collections.arbol.avl.ArbolAVL<uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice>  indice, java.lang.String[] llaves) {
        try {
            for (int i = 0 ; i < (llaves.length) ; i++) {
                uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice nodoTemp = new uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice(llaves[i]);
                uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice nodo = indice.buscar(new uniandes.cupi2.biblioteca.mundo.implementacion1.NodoIndice(llaves[i]));
                if (nodo == null) {
                    nodoTemp.agregarLibro(libro);
                    indice.insertar(nodoTemp);
                } else
                    nodo.agregarLibro(libro);
                
            }
        } catch (uniandes.cupi2.collections.arbol.ElementoExisteException e) {
        }
    }
    
}

