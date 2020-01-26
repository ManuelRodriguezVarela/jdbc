package gal.san.clemente.tarefa3_acceso_datos.view.tendas;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaProducto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.ProductosComboModel;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.TendaProductoTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListTendasProductosFrame extends javax.swing.JFrame {
    
    private IDAOManager manager;
    
    private TendaProductoTableModel model;
    
    public ListTendasProductosFrame(IDAOManager manager, Tenda tenda) throws ModelException, SQLException {
        initComponents();
        this.manager = manager;
        this.model = new TendaProductoTableModel(manager.getTendaProductoDAO(), tenda);
        obtenerDatos();
        this.tablaTendaProductos.setModel(model);

        this.detalle.setModel(new ProductosComboModel(manager.getProductoDAO()));
        
        //selección de filas
        this.tablaTendaProductos.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tablaTendaProductos.getSelectedRow() != -1);
            botonEditarProductoTenda.setEnabled(seleccionValida);
            botonEliminarProductoTenda.setEnabled(seleccionValida);
        });
    }
    
    final void obtenerDatos() throws ModelException {
        registrosTendas.setText("Actualizando datos ...");
        model.updateModelTenda();
        registrosTendas.setText(model.getRowCount() + " registros productos de tenda");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTendas = new javax.swing.JToolBar();
        botonCrearProdutoTenda = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonEditarProductoTenda = new javax.swing.JButton();
        botonEliminarProductoTenda = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTendaProductos = new javax.swing.JTable();
        registrosTendas = new javax.swing.JLabel();
        detalle = new gal.san.clemente.tarefa3_acceso_datos.view.tendas.DetalleTendaProductoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión Tendas");

        menuTendas.setRollover(true);

        botonCrearProdutoTenda.setText("Alta Producto Tenda");
        botonCrearProdutoTenda.setFocusable(false);
        botonCrearProdutoTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrearProdutoTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrearProdutoTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearProdutoTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonCrearProdutoTenda);
        menuTendas.add(jSeparator1);

        botonEditarProductoTenda.setText("Editar Producto Tenda");
        botonEditarProductoTenda.setEnabled(false);
        botonEditarProductoTenda.setFocusable(false);
        botonEditarProductoTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditarProductoTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditarProductoTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarProductoTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonEditarProductoTenda);

        botonEliminarProductoTenda.setText("Borrar Producto Tenda");
        botonEliminarProductoTenda.setEnabled(false);
        botonEliminarProductoTenda.setFocusable(false);
        botonEliminarProductoTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminarProductoTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminarProductoTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProductoTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonEliminarProductoTenda);
        menuTendas.add(jSeparator2);

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
        menuTendas.add(botonGuardar);

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
        menuTendas.add(botonCancelar);

        getContentPane().add(menuTendas, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tablaTendaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaTendaProductos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        registrosTendas.setText("0 rexistros de tendas");
        registrosTendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.add(registrosTendas, java.awt.BorderLayout.PAGE_END);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private TendaProducto getTendaProductoSeleccionado() throws ModelException {
        Long id = (Long) tablaTendaProductos.getValueAt(tablaTendaProductos.getSelectedRow(), 0);
        return manager.getTendaProductoDAO().obtener(id);
    }
    
    //método edidar
    private void botonEditarProductoTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarProductoTendaActionPerformed
        try {
            TendaProducto tendaProducto = getTendaProductoSeleccionado();
            detalle.setTendaProducto(tendaProducto);
            detalle.setEditable(true);
            detalle.loadData();
            botonGuardar.setEnabled(true);
            botonCancelar.setEnabled(true);
        } catch (ModelException ex) {
            Logger.getLogger(ListTendasProductosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEditarProductoTendaActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        clean();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCrearProdutoTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearProdutoTendaActionPerformed
        detalle.setTendaProducto(null);
        detalle.loadData();
        detalle.setEditable(true);
        botonGuardar.setEnabled(true);
        botonCancelar.setEnabled(true);
    }//GEN-LAST:event_botonCrearProdutoTendaActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        detalle.saveData();
        TendaProducto tendaProducto = detalle.getTendaProducto();
        try {
            if(tendaProducto.getId() == null) {
                manager.getTendaProductoDAO().insertar(tendaProducto);
            } else {
                manager.getTendaProductoDAO().modificar(tendaProducto);
            }
            clean();
            obtenerDatos();
            //actualiza la tabla
            model.fireTableDataChanged();
        } catch (ModelException ex) {
            Logger.getLogger(ListTendasProductosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarProductoTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProductoTendaActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que queres borralo tenda?", 
                "Borrar Tenda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                TendaProducto tendaProducto = getTendaProductoSeleccionado();
                manager.getTendaProductoDAO().eliminar(tendaProducto);
                obtenerDatos();
                //actualiza la tabla
                model.fireTableDataChanged();
            } catch (ModelException ex) {
                Logger.getLogger(ListTendasProductosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_botonEliminarProductoTendaActionPerformed
    
    private void clean() {
        detalle.setTendaProducto(null);
        detalle.setEditable(false);
        detalle.loadData();
        tablaTendaProductos.clearSelection();
        botonGuardar.setEnabled(false);
        botonCancelar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrearProdutoTenda;
    private javax.swing.JButton botonEditarProductoTenda;
    private javax.swing.JButton botonEliminarProductoTenda;
    private javax.swing.JButton botonGuardar;
    private gal.san.clemente.tarefa3_acceso_datos.view.tendas.DetalleTendaProductoPanel detalle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar menuTendas;
    private javax.swing.JLabel registrosTendas;
    private javax.swing.JTable tablaTendaProductos;
    // End of variables declaration//GEN-END:variables
}
