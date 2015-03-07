package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel donde se muestran las opciones de búsqueda.
 */
public class PanelAccionBuscarLibro extends javax.swing.JPanel implements java.awt.event.ActionListener {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Constante para la acción buscar.
     */
    private static final java.lang.String BOTON_BUSCAR = "Buscar";
    
    /** 
     * Constante para el radio button que dice que la búsqueda se va hacer por palabras claves.
     */
    private static final java.lang.String RADIO_TODOS = "Descripción";
    
    /** 
     * Constante para el radio button que dice que la búsqueda se va hacer por elementos exactos.
     */
    private static final java.lang.String RADIO_EXACTO = "Exacto";
    
    /** 
     * Constante para definir que la búsqueda se hace por título.
     */
    private static final java.lang.String TITULO = "Por título";
    
    /** 
     * Constante para definir que la búsqueda se hace por autor.
     */
    private static final java.lang.String AUTOR = "Por autor";
    
    /** 
     * Constante para definir que la búsqueda se hace por descriptores.
     */
    private static final java.lang.String DESCRIPTORES = "Por descriptores";
    
    /** 
     * Constante para definir que la acción la hizo el combobox de las acciones.
     */
    private static final java.lang.String COMBO_ACCIONES = "Combo Acciones";
    
    /** 
     * Interfaz principal de la aplicación.
     */
    private uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal;
    
    /** 
     * Etiqueta de palabras.
     */
    private javax.swing.JLabel labelPalabras;
    
    /** 
     * Cuadro de texto de palabras.
     */
    private javax.swing.JTextField textoPalabras;
    
    /** 
     * Combo donde están los parámetros de la búsqueda.
     */
    private javax.swing.JComboBox comboBusqueda;
    
    /** 
     * Etiqueta "Criterio".
     */
    private javax.swing.JLabel labelCriterio;
    
    /** 
     * Radio que indica que la búsqueda es por el elemento exacto.
     */
    private javax.swing.JRadioButton radioExacto;
    
    /** 
     * Radio que indica que no es exacto, que solo cumpla con uno de las palabras del elemento.
     */
    private javax.swing.JRadioButton radioAlmenos;
    
    /** 
     * Etiqueta "Descriptores"
     */
    private javax.swing.JLabel labelDescriptores;
    
    /** 
     * Cuadro de texto donde se ingresa el descriptor 1.
     */
    private javax.swing.JTextField textoDescriptor1;
    
    /** 
     * Cuadro de texto donde se ingresa el descriptor 2.
     */
    private javax.swing.JTextField textoDescriptor2;
    
    /** 
     * Cuadro de texto donde se ingresa el descriptor 3.
     */
    private javax.swing.JTextField textoDescriptor3;
    
    /** 
     * Botón para ejecutar la búsqueda.
     */
    private javax.swing.JButton botonBuscar = null;
    
    /** 
     * Constructor por defecto del panel.
     * @param principal Interfaz principal de la aplicación.
     */
    public PanelAccionBuscarLibro(uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca principal) {
        super();
        this.principal = principal;
        initialize();
    }
    
    /** 
     * Inicializar el panel.
     */
    private void initialize() {
        java.awt.GridBagConstraints gridBagConstraints10 = new java.awt.GridBagConstraints();
        gridBagConstraints10.gridx = 1;
        gridBagConstraints10.insets = new java.awt.Insets(43 , 0 , 0 , 0);
        gridBagConstraints10.gridy = 6;
        java.awt.GridBagConstraints gridBagConstraints9 = new java.awt.GridBagConstraints();
        gridBagConstraints9.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints9.gridy = 5;
        gridBagConstraints9.weightx = 1.0;
        gridBagConstraints9.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints8 = new java.awt.GridBagConstraints();
        gridBagConstraints8.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints8.gridy = 4;
        gridBagConstraints8.weightx = 1.0;
        gridBagConstraints8.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints7 = new java.awt.GridBagConstraints();
        gridBagConstraints7.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints7.gridy = 3;
        gridBagConstraints7.weightx = 1.0;
        gridBagConstraints7.insets = new java.awt.Insets(11 , 0 , 0 , 0);
        gridBagConstraints7.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints6 = new java.awt.GridBagConstraints();
        gridBagConstraints6.gridx = 0;
        gridBagConstraints6.insets = new java.awt.Insets(11 , 0 , 0 , 0);
        gridBagConstraints6.gridy = 3;
        java.awt.GridBagConstraints gridBagConstraints5 = new java.awt.GridBagConstraints();
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints4 = new java.awt.GridBagConstraints();
        gridBagConstraints4.gridx = 1;
        gridBagConstraints4.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints3 = new java.awt.GridBagConstraints();
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 1;
        java.awt.GridBagConstraints gridBagConstraints2 = new java.awt.GridBagConstraints();
        gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        setSize(244 ,320);
        setLayout(new java.awt.GridBagLayout());
        setBorder(javax.swing.BorderFactory.createTitledBorder(null ,"Buscar Libro" ,javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION ,javax.swing.border.TitledBorder.DEFAULT_POSITION ,new java.awt.Font("Dialog" , java.awt.Font.BOLD , 12) ,new java.awt.Color(51 , 51 , 51)));
        setOpaque(false);
        labelPalabras = new javax.swing.JLabel();
        labelPalabras.setText("Palabras:");
        labelPalabras.setToolTipText("Palabras:");
        add(labelPalabras ,gridBagConstraints);
        textoPalabras = new javax.swing.JTextField();
        add(textoPalabras ,gridBagConstraints1);
        comboBusqueda = new javax.swing.JComboBox();
        comboBusqueda.addItem(TITULO);
        comboBusqueda.addItem(AUTOR);
        comboBusqueda.addItem(DESCRIPTORES);
        comboBusqueda.addActionListener(this);
        comboBusqueda.setActionCommand(COMBO_ACCIONES);
        add(comboBusqueda ,gridBagConstraints2);
        labelCriterio = new javax.swing.JLabel();
        labelCriterio.setText("Criterio:");
        add(labelCriterio ,gridBagConstraints3);
        radioExacto = new javax.swing.JRadioButton();
        radioExacto.setText("Todas las palabras");
        radioExacto.setOpaque(false);
        radioExacto.addActionListener(this);
        add(radioExacto ,gridBagConstraints4);
        radioAlmenos = new javax.swing.JRadioButton();
        radioAlmenos.setText("Por palabra");
        radioAlmenos.setOpaque(false);
        radioAlmenos.setSelected(true);
        radioAlmenos.addActionListener(this);
        add(radioAlmenos ,gridBagConstraints5);
        javax.swing.ButtonGroup grupoRadio = new javax.swing.ButtonGroup();
        grupoRadio.add(radioAlmenos);
        grupoRadio.add(radioExacto);
        labelDescriptores = new javax.swing.JLabel();
        labelDescriptores.setText("Descriptores:");
        add(labelDescriptores ,gridBagConstraints6);
        textoDescriptor1 = new javax.swing.JTextField();
        textoDescriptor1.setEnabled(false);
        add(textoDescriptor1 ,gridBagConstraints7);
        textoDescriptor2 = new javax.swing.JTextField();
        textoDescriptor2.setEnabled(false);
        add(textoDescriptor2 ,gridBagConstraints8);
        textoDescriptor3 = new javax.swing.JTextField();
        textoDescriptor3.setEnabled(false);
        add(textoDescriptor3 ,gridBagConstraints9);
        botonBuscar = new javax.swing.JButton();
        botonBuscar.setText("Buscar");
        botonBuscar.setActionCommand(BOTON_BUSCAR);
        botonBuscar.addActionListener(this);
        add(botonBuscar ,gridBagConstraints10);
    }
    
    /** 
     * Manejo de eventos sobre los elementos del panel.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equals(BOTON_BUSCAR))
            buscar();
        
        if (e.getActionCommand().equals(RADIO_EXACTO)) {
            radioAlmenos.setSelected(true);
            radioExacto.setSelected(false);
        } 
        if (e.getActionCommand().equals(RADIO_TODOS)) {
            radioAlmenos.setSelected(false);
            radioExacto.setSelected(true);
        } 
        if (e.getActionCommand().equals(COMBO_ACCIONES))
            seleccionCombo();
        
    }
    
    /** 
     * Manejo de los eventos sobre el combo box de búsqueda.
     */
    public void seleccionCombo() {
        if ((comboBusqueda.getSelectedItem().equals(TITULO)) || (comboBusqueda.getSelectedItem().equals(AUTOR))) {
            textoPalabras.setEnabled(true);
            textoDescriptor1.setEnabled(false);
            textoDescriptor2.setEnabled(false);
            textoDescriptor3.setEnabled(false);
        } else {
            textoPalabras.setEnabled(false);
            textoDescriptor1.setEnabled(true);
            textoDescriptor2.setEnabled(true);
            textoDescriptor3.setEnabled(true);
        }
    }
    
    /** 
     * Ejecuta una búsqueda.
     */
    public void buscar() {
        if (comboBusqueda.getSelectedItem().equals(TITULO)) {
            if (textoPalabras.getText().equals("")) {
                javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese las palabras" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
                return ;
            } 
            if (radioAlmenos.isSelected())
                principal.buscarTituloPorPalabra(textoPalabras.getText().split(" "));
            else
                principal.buscarTituloExacto(textoPalabras.getText());
            
        } 
        if (comboBusqueda.getSelectedItem().equals(AUTOR)) {
            if (textoPalabras.getText().equals("")) {
                javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese las palabras" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
                return ;
            } 
            if (radioAlmenos.isSelected())
                principal.buscarAutoresPorPalabra(textoPalabras.getText().split(" "));
            else
                principal.buscarAutoresExacto(textoPalabras.getText());
            
        } 
        if (comboBusqueda.getSelectedItem().equals(DESCRIPTORES)) {
            if (((textoDescriptor1.getText().equals("")) && (textoDescriptor2.getText().equals(""))) && (textoDescriptor3.getText().equals(""))) {
                javax.swing.JOptionPane.showMessageDialog(principal ,"Ingrese al menos un descriptor" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
                return ;
            } 
            int contador = 0;
            if (!(textoDescriptor1.getText().equals("")))
                contador++;
            
            if (!(textoDescriptor2.getText().equals("")))
                contador++;
            
            if (!(textoDescriptor3.getText().equals("")))
                contador++;
            
            java.lang.String[] datos = new java.lang.String[contador];
            contador = 0;
            if (!(textoDescriptor1.getText().equals(""))) {
                datos[contador] = textoDescriptor1.getText().trim();
                contador++;
            } 
            if (!(textoDescriptor2.getText().equals(""))) {
                datos[contador] = textoDescriptor2.getText().trim();
                contador++;
            } 
            if (!(textoDescriptor3.getText().equals("")))
                datos[contador] = textoDescriptor3.getText().trim();
            
            if (radioAlmenos.isSelected())
                principal.buscarDescriptoresPorPalabra(datos);
            else
                principal.buscarDescriptoresExacto(datos);
            
        } 
    }
    
}

