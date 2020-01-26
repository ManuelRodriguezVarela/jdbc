package gal.san.clemente.tarefa3_acceso_datos.view.productos;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Producto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.ProdutoTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListProdutosFrame extends javax.swing.JFrame {
    
    private IDAOManager manager;
    
    private ProdutoTableModel model;
    
    public ListProdutosFrame(IDAOManager manager) throws ModelException {
        initComponents();
        this.manager = manager;
        this.model = new ProdutoTableModel(manager.getProductoDAO());
        obtenerDatos();
        this.tablaProdutos.setModel(model);
        //selección de filas
        this.tablaProdutos.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tablaProdutos.getSelectedRow() != -1);
            botonEditarProduto.setEnabled(seleccionValida);
            botonEliminarProduto.setEnabled(seleccionValida);
        });
    }
    
    final void obtenerDatos() throws ModelException {
        registrosProduto.setText("Actualizando datos ...");
        model.updateModelProducto();
        registrosProduto.setText(model.getRowCount() + " registros de produtos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuProdutos = new javax.swing.JToolBar();
        botonCrearProduto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonEditarProduto = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonEliminarProduto = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProdutos = new javax.swing.JTable();
        registrosProduto = new javax.swing.JLabel();
        detalle = new gal.san.clemente.tarefa3_acceso_datos.view.productos.DetalleProdutoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión Productos");

        menuProdutos.setRollover(true);

        botonCrearProduto.setText("Crear Produto");
        botonCrearProduto.setFocusable(false);
        botonCrearProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrearProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrearProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(botonCrearProduto);
        menuProdutos.add(jSeparator1);

        botonEditarProduto.setText("Editar Produto");
        botonEditarProduto.setEnabled(false);
        botonEditarProduto.setFocusable(false);
        botonEditarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditarProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(botonEditarProduto);
        menuProdutos.add(jSeparator2);

        botonEliminarProduto.setText("Borrar Produto");
        botonEliminarProduto.setEnabled(false);
        botonEliminarProduto.setFocusable(false);
        botonEliminarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminarProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(botonEliminarProduto);
        menuProdutos.add(jSeparator3);

        botonGuardar.setText("Guardar");
        botonGuardar.setEnabled(false);
        botonGuardar.setFocusable(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        menuProdutos.add(botonGuardar);

        botonCancelar.setText("Cancelar");
        botonCancelar.setEnabled(false);
        botonCancelar.setFocusable(false);
        botonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        menuProdutos.add(botonCancelar);

        getContentPane().add(menuProdutos, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tablaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaProdutos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        registrosProduto.setText("0 rexistros de produtos");
        registrosProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.add(registrosProduto, java.awt.BorderLayout.PAGE_END);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private Producto getProdutoSeleccionado() throws ModelException {
        Long id = (Long) tablaProdutos.getValueAt(tablaProdutos.getSelectedRow(), 0);
        return manager.getProductoDAO().obtener(id);
    }
    
    //método edidar
    private void botonEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarProdutoActionPerformed
        try {
            Producto produto = getProdutoSeleccionado();
            detalle.setProducto(produto);
            detalle.setEditable(true);
            detalle.loadData();
            botonGuardar.setEnabled(true);
            botonCancelar.setEnabled(true);
        } catch (ModelException ex) {
            Logger.getLogger(ListProdutosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEditarProdutoActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        clean();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCrearProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearProdutoActionPerformed
        detalle.setProducto(null);
        detalle.loadData();
        detalle.setEditable(true);
        botonGuardar.setEnabled(true);
        botonCancelar.setEnabled(true);
    }//GEN-LAST:event_botonCrearProdutoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        detalle.saveData();
        Producto producto = detalle.getProducto();
        try {
            if(producto.getId() == null) {
                manager.getProductoDAO().insertar(producto);
            } else {
                manager.getProductoDAO().modificar(producto);
            }
            clean();
            obtenerDatos();
            //actualiza la tabla
            model.fireTableDataChanged();
        } catch (ModelException ex) {
            Logger.getLogger(ListProdutosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProdutoActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que queres borralo produto?", 
                "Borrar Produto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                Producto producto = getProdutoSeleccionado();
                manager.getProductoDAO().eliminar(producto);
                obtenerDatos();
                //actualiza la tabla
                model.fireTableDataChanged();
            } catch (ModelException ex) {
                Logger.getLogger(ListProdutosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_botonEliminarProdutoActionPerformed
    
    private void clean() {
        detalle.setProducto(null);
        detalle.setEditable(false);
        detalle.loadData();
        tablaProdutos.clearSelection();
        botonGuardar.setEnabled(false);
        botonCancelar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrearProduto;
    private javax.swing.JButton botonEditarProduto;
    private javax.swing.JButton botonEliminarProduto;
    private javax.swing.JButton botonGuardar;
    private gal.san.clemente.tarefa3_acceso_datos.view.productos.DetalleProdutoPanel detalle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar menuProdutos;
    private javax.swing.JLabel registrosProduto;
    private javax.swing.JTable tablaProdutos;
    // End of variables declaration//GEN-END:variables
}
