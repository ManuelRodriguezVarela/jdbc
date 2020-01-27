package gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_productos;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Producto;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaProducto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProductoDAO;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.ProductosComboModel;

public class DetalleTendaProductoPanel extends javax.swing.JPanel {
    
    private TendaProducto tendaProducto;
    private boolean editable;
    private Producto producto;
    private Tenda tenda;
    private ProductosComboModel model;

    public ProductosComboModel getModel() {
        return model;
    }

    public void setModel(ProductosComboModel model) throws ModelException {
        this.model = model;
        nomeProducto.setModel(model);
        model.update();
    }

    public TendaProducto getTendaProducto() {
        return tendaProducto;
    }

    public void setTendaProducto(TendaProducto tendaProducto) {
        this.tendaProducto = tendaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tenda getTenda() {
        return tenda;
    }

    public void setTenda(Tenda tenda) {
        this.tenda = tenda;
    }

    public boolean isEditable() {
        return editable;
    }
    
    //método controlar la edicción de datos
    public void setEditable(boolean editable) {
        this.editable = editable;
        nomeProducto.setEnabled(editable);
        stock.setEditable(editable);
    }
    
    //método cargar datos
    public void loadData(Tenda tenda) {
        this.setTenda(tenda);
        if(tendaProducto != null) {
            nomeTenda.setText(tenda.getId().toString());
            stock.setText(tendaProducto.getStock().toString());
        } else {
            nomeTenda.setText(tenda.getId().toString());
            stock.setText("");
        }
        stock.requestFocus();
    }
    
    //método guardar datos
    public void saveData() {
        if(tendaProducto == null) {
            tendaProducto = new TendaProducto();
        }
        tendaProducto.setIdTenda(tenda.getId());
        ProductoComboView pcv = (ProductoComboView) nomeProducto.getSelectedItem();
        tendaProducto.setIdProducto(pcv.getProducto().getId());
        tendaProducto.setStock(Integer.parseInt(stock.getText()));
    }

    public DetalleTendaProductoPanel() {
        initComponents();
        model = new ProductosComboModel(null);
    }
    
    public DetalleTendaProductoPanel(IProductoDAO productoDAO, Tenda tenda) throws ModelException {
        initComponents();
        model = new ProductosComboModel(productoDAO);
        this.tenda = tenda;
        model.update();
        nomeProducto.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeTenda = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        nomeProducto = new javax.swing.JComboBox<>();

        jLabel1.setText("Tenda");

        jLabel2.setText("Produto Tenda");

        jLabel3.setText("Stock Produto");

        nomeTenda.setEnabled(false);

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
                    .addComponent(nomeTenda)
                    .addComponent(stock, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(nomeProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<ProductoComboView> nomeProducto;
    private javax.swing.JTextField nomeTenda;
    private javax.swing.JTextField stock;
    // End of variables declaration//GEN-END:variables
}
