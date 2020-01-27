package gal.san.clemente.tarefa3_acceso_datos.view.tendas;

import gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_productos.ListTendasProductosFrame;
import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion.DAOManagerJSONImpl;
import gal.san.clemente.tarefa3_acceso_datos.view.MainMenu;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.ProvinciasComboModel;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.TendaTableModel;
import gal.san.clemente.tarefa3_acceso_datos.view.empleados.ListEmpleadosFrame;
import gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_empregados.ListTendasEmpleadosFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListTendasFrame extends javax.swing.JFrame {
    
    private IDAOManager manager;
    
    private TendaTableModel model;
    
    public ListTendasFrame(IDAOManager manager) throws ModelException, SQLException {
        initComponents();
        this.manager = manager;
        this.model = new TendaTableModel(manager.getTendaDAO());
        obtenerDatos();
        this.tablaTendas.setModel(model);
        
        //TODO implementar FACTORY
        IDAOManager manager2 = new DAOManagerJSONImpl();
        this.detalle.setModel(new ProvinciasComboModel(manager2.getProvinciaDAO()));
        
        //selección de filas
        this.tablaTendas.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tablaTendas.getSelectedRow() != -1);
            botonEditarTenda.setEnabled(seleccionValida);
            botonEliminarTenda.setEnabled(seleccionValida);
            gestionEmpleados.setEnabled(seleccionValida);
            gestionProdutos.setEnabled(seleccionValida);
        });
    }
    
    final void obtenerDatos() throws ModelException {
        registrosTendas.setText("Actualizando datos ...");
        model.updateModelTenda();
        registrosTendas.setText(model.getRowCount() + " registros de tendas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTendas = new javax.swing.JToolBar();
        botonCrearTenda = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonEditarTenda = new javax.swing.JButton();
        botonEliminarTenda = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        gestionEmpleados = new javax.swing.JButton();
        gestionProdutos = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTendas = new javax.swing.JTable();
        registrosTendas = new javax.swing.JLabel();
        detalle = new gal.san.clemente.tarefa3_acceso_datos.view.tendas.DetalleTendaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión Tendas");

        menuTendas.setRollover(true);

        botonCrearTenda.setText("Crear Tenda");
        botonCrearTenda.setFocusable(false);
        botonCrearTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrearTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrearTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonCrearTenda);
        menuTendas.add(jSeparator1);

        botonEditarTenda.setText("Editar Tenda");
        botonEditarTenda.setEnabled(false);
        botonEditarTenda.setFocusable(false);
        botonEditarTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditarTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditarTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonEditarTenda);

        botonEliminarTenda.setText("Borrar Tenda");
        botonEliminarTenda.setEnabled(false);
        botonEliminarTenda.setFocusable(false);
        botonEliminarTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminarTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminarTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonEliminarTenda);
        menuTendas.add(jSeparator2);

        gestionEmpleados.setText("Gestión Empleados Tenda");
        gestionEmpleados.setEnabled(false);
        gestionEmpleados.setFocusable(false);
        gestionEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestionEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestionEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionEmpleadosActionPerformed(evt);
            }
        });
        menuTendas.add(gestionEmpleados);

        gestionProdutos.setText("Gestión Produtos Tenda");
        gestionProdutos.setEnabled(false);
        gestionProdutos.setFocusable(false);
        gestionProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestionProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestionProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionProdutosActionPerformed(evt);
            }
        });
        menuTendas.add(gestionProdutos);
        menuTendas.add(jSeparator3);

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

        tablaTendas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaTendas);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        registrosTendas.setText("0 rexistros de tendas");
        registrosTendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.add(registrosTendas, java.awt.BorderLayout.PAGE_END);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private Tenda getTendaSeleccionado() throws ModelException {
        Long id = (Long) tablaTendas.getValueAt(tablaTendas.getSelectedRow(), 0);
        return manager.getTendaDAO().obtener(id);
    }
    
    //método edidar
    private void botonEditarTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarTendaActionPerformed
        try {
            Tenda tenda = getTendaSeleccionado();
            detalle.setTenda(tenda);
            detalle.setEditable(true);
            detalle.loadData();
            botonGuardar.setEnabled(true);
            botonCancelar.setEnabled(true);
        } catch (ModelException ex) {
            Logger.getLogger(ListTendasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEditarTendaActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        clean();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCrearTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearTendaActionPerformed
        detalle.setTenda(null);
        detalle.loadData();
        detalle.setEditable(true);
        botonGuardar.setEnabled(true);
        botonCancelar.setEnabled(true);
    }//GEN-LAST:event_botonCrearTendaActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        detalle.saveData();
        Tenda tenda = detalle.getTenda();
        try {
            if(tenda.getId() == null) {
                manager.getTendaDAO().insertar(tenda);
            } else {
                manager.getTendaDAO().modificar(tenda);
            }
            clean();
            obtenerDatos();
            //actualiza la tabla
            model.fireTableDataChanged();
        } catch (ModelException ex) {
            Logger.getLogger(ListTendasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarTendaActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que queres borralo tenda?", 
                "Borrar Tenda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                Tenda tenda = getTendaSeleccionado();
                manager.getTendaDAO().eliminar(tenda);
                obtenerDatos();
                //actualiza la tabla
                model.fireTableDataChanged();
            } catch (ModelException ex) {
                Logger.getLogger(ListTendasFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_botonEliminarTendaActionPerformed

    private void gestionProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionProdutosActionPerformed
        try {
            Tenda tenda = getTendaSeleccionado();
            ListTendasProductosFrame listaTendaProductos = new ListTendasProductosFrame(manager, tenda);
            listaTendaProductos.setLocationRelativeTo(this);
            listaTendaProductos.setVisible(true);
        } catch (ModelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListTendasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gestionProdutosActionPerformed

    private void gestionEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionEmpleadosActionPerformed
        try {
            Tenda tenda = getTendaSeleccionado();
            ListTendasEmpleadosFrame listaTendaEmpleados = new ListTendasEmpleadosFrame(manager, tenda);
            listaTendaEmpleados.setLocationRelativeTo(this);
            listaTendaEmpleados.setVisible(true);
        } catch (ModelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListTendasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gestionEmpleadosActionPerformed
    
    private void clean() {
        detalle.setTenda(null);
        detalle.setEditable(false);
        detalle.loadData();
        tablaTendas.clearSelection();
        botonGuardar.setEnabled(false);
        botonCancelar.setEnabled(false);
        gestionEmpleados.setEnabled(false);
        gestionProdutos.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrearTenda;
    private javax.swing.JButton botonEditarTenda;
    private javax.swing.JButton botonEliminarTenda;
    private javax.swing.JButton botonGuardar;
    private gal.san.clemente.tarefa3_acceso_datos.view.tendas.DetalleTendaPanel detalle;
    private javax.swing.JButton gestionEmpleados;
    private javax.swing.JButton gestionProdutos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar menuTendas;
    private javax.swing.JLabel registrosTendas;
    private javax.swing.JTable tablaTendas;
    // End of variables declaration//GEN-END:variables
}
