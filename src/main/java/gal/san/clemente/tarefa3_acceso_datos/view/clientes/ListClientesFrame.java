package gal.san.clemente.tarefa3_acceso_datos.view.clientes;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Cliente;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.ClienteTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListClientesFrame extends javax.swing.JFrame {
    
    private IDAOManager manager;
    
    private ClienteTableModel model;
    
    public ListClientesFrame(IDAOManager manager) throws ModelException {
        initComponents();
        this.manager = manager;
        this.model = new ClienteTableModel(manager.getClienteDAO());
        obtenerDatos();
        this.tablaClientes.setModel(model);
        //selección de filas
        this.tablaClientes.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tablaClientes.getSelectedRow() != -1);
            botonEditarCliente.setEnabled(seleccionValida);
            botonEliminarCliente.setEnabled(seleccionValida);
        });
    }
    
    final void obtenerDatos() throws ModelException {
        registrosClientes.setText("Actualizando datos ...");
        model.updateModelCliente();
        registrosClientes.setText(model.getRowCount() + " registros de clientes");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuClientes = new javax.swing.JToolBar();
        botonCrearCliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonEditarCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonEliminarCliente = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        detalle = new gal.san.clemente.tarefa3_acceso_datos.view.clientes.DetalleClientePanel();
        registrosClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión Clientes");

        menuClientes.setRollover(true);

        botonCrearCliente.setText("Crear Cliente");
        botonCrearCliente.setFocusable(false);
        botonCrearCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrearCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearClienteActionPerformed(evt);
            }
        });
        menuClientes.add(botonCrearCliente);
        menuClientes.add(jSeparator1);

        botonEditarCliente.setText("Editar Cliente");
        botonEditarCliente.setEnabled(false);
        botonEditarCliente.setFocusable(false);
        botonEditarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(botonEditarCliente);
        menuClientes.add(jSeparator2);

        botonEliminarCliente.setText("Borrar Cliente");
        botonEliminarCliente.setEnabled(false);
        botonEliminarCliente.setFocusable(false);
        botonEliminarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(botonEliminarCliente);
        menuClientes.add(jSeparator3);

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
        menuClientes.add(botonGuardar);

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
        menuClientes.add(botonCancelar);

        getContentPane().add(menuClientes, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaClientes);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        registrosClientes.setText("0 rexistros de clientes");
        registrosClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.add(registrosClientes, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private Cliente getClienteSeleccionado() throws ModelException {
        Long id = (Long) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0);
        return manager.getClienteDAO().obtener(id);
    }
    
    //método edidar
    private void botonEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarClienteActionPerformed
        try {
            Cliente cliente = getClienteSeleccionado();
            detalle.setCliente(cliente);
            detalle.setEditable(true);
            detalle.loadData();
            botonGuardar.setEnabled(true);
            botonCancelar.setEnabled(true);
        } catch (ModelException ex) {
            Logger.getLogger(ListClientesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEditarClienteActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        clean();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearClienteActionPerformed
        detalle.setCliente(null);
        detalle.loadData();
        detalle.setEditable(true);
        botonGuardar.setEnabled(true);
        botonCancelar.setEnabled(true);
    }//GEN-LAST:event_botonCrearClienteActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        detalle.saveData();
        Cliente cliente = detalle.getCliente();
        try {
            if(cliente.getId() == null) {
                manager.getClienteDAO().insertar(cliente);
            } else {
                manager.getClienteDAO().modificar(cliente);
            }
            clean();
            obtenerDatos();
            //actualiza la tabla
            model.fireTableDataChanged();
        } catch (ModelException ex) {
            Logger.getLogger(ListClientesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarClienteActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que queres borralo cliente?", 
                "Borrar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                Cliente cliente = getClienteSeleccionado();
                manager.getClienteDAO().eliminar(cliente);
                obtenerDatos();
                //actualiza la tabla
                model.fireTableDataChanged();
            } catch (ModelException ex) {
                Logger.getLogger(ListClientesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_botonEliminarClienteActionPerformed
    
    private void clean() {
        detalle.setCliente(null);
        detalle.setEditable(false);
        detalle.loadData();
        tablaClientes.clearSelection();
        botonGuardar.setEnabled(false);
        botonCancelar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrearCliente;
    private javax.swing.JButton botonEditarCliente;
    private javax.swing.JButton botonEliminarCliente;
    private javax.swing.JButton botonGuardar;
    private gal.san.clemente.tarefa3_acceso_datos.view.clientes.DetalleClientePanel detalle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar menuClientes;
    private javax.swing.JLabel registrosClientes;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
