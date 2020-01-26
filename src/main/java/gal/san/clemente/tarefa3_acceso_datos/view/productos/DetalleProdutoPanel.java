package gal.san.clemente.tarefa3_acceso_datos.view.productos;

import gal.san.clemente.tarefa3_acceso_datos.model.Producto;

public class DetalleProdutoPanel extends javax.swing.JPanel {
    
    private Producto producto;
    private boolean editable;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEditable() {
        return editable;
    }
    
    //método controlar la edicción de datos
    public void setEditable(boolean editable) {
        this.editable = editable;
        nomeProduto.setEditable(editable);
        descricionProduto.setEditable(editable);
        prezoProduto.setEditable(editable);
    }
    
    //método cargar datos
    public void loadData() {
        if(producto != null) {
            nomeProduto.setText(producto.getNome());
            descricionProduto.setText(producto.getDescripcion());
            prezoProduto.setText(producto.getPrezo().toString());
        } else {
            nomeProduto.setText("");
            descricionProduto.setText("");
            prezoProduto.setText("");
        }
        nomeProduto.requestFocus();
    }
    
    //método guardar datos
    public void saveData() {
        if(producto == null) {
            producto = new Producto();
        }
        producto.setNome(nomeProduto.getText());
        producto.setDescripcion(descricionProduto.getText());
        producto.setPrezo(Double.valueOf(prezoProduto.getText()));
    }

    public DetalleProdutoPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeProduto = new javax.swing.JTextField();
        descricionProduto = new javax.swing.JTextField();
        prezoProduto = new javax.swing.JTextField();

        jLabel1.setText("Nome Produto");

        jLabel2.setText("Descrición Produto");

        jLabel3.setText("Prezo Produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomeProduto)
                    .addComponent(descricionProduto)
                    .addComponent(prezoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(descricionProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prezoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descricionProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JTextField prezoProduto;
    // End of variables declaration//GEN-END:variables
}
