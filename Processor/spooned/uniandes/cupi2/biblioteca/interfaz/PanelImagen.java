package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Panel donde está la imagen superior de la aplicación.
 */
public class PanelImagen extends javax.swing.JPanel {
    /** 
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * Label donde está la imagen.
     */
    private javax.swing.JLabel labelImagen = null;
    
    /** 
     * Constructor por defecto del panel.
     */
    public PanelImagen() {
        super();
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        labelImagen = new javax.swing.JLabel();
        labelImagen.setText("");
        labelImagen.setPreferredSize(new java.awt.Dimension(800 , 100));
        labelImagen.setMaximumSize(new java.awt.Dimension(800 , 100));
        labelImagen.setMinimumSize(new java.awt.Dimension(800 , 100));
        labelImagen.setIcon(new javax.swing.ImageIcon("data/imagen.jpg"));
        setSize(640 ,100);
        setLayout(new java.awt.GridBagLayout());
        add(labelImagen ,gridBagConstraints);
    }
    
}

