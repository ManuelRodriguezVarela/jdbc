package gal.san.clemente.tarefa3_acceso_datos.view.empleados;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Empleado;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.EmpleadoTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListEmpleadosFrame extends javax.swing.JFrame {
    
    private IDAOManager manager;
    
    private EmpleadoTableModel model;
    
    public ListEmpleadosFrame(IDAOManager manager) throws ModelException {
        initComponents();
        this.manager = manager;
        this.model = new EmpleadoTableModel(manager.getEmpleadoDAO());
        obtenerDatos();
        this.tablaEmpleados.setModel(model);
        //selección de filas
        this.tablaEmpleados.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tablaEmpleados.getSelectedRow() != -1);
            botonEditarEmpleado.setEnabled(seleccionValida);
            botonEliminarEmpleado.setEnabled(seleccionValida);
        });
    }
    
    final void obtenerDatos() throws ModelException {
        registrosEmpleados.setText("Actualizando datos ...");
        model.updateModelEmpleado();
        registrosEmpleados.setText(model.getRowCount() + " registros de empleados");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuEmpleados = new javax.swing.JToolBar();
        botonCrearEmpleado = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonEditarEmpleado = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonEliminarEmpleado = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        registrosEmpleados = new javax.swing.JLabel();
        detalle = new gal.san.clemente.tarefa3_acceso_datos.view.empleados.DetalleEmpleadoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión Empleados");

        menuEmpleados.setRollover(true);

        botonCrearEmpleado.setText("Crear Empleado");
        botonCrearEmpleado.setFocusable(false);
        botonCrearEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrearEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleados.add(botonCrearEmpleado);
        menuEmpleados.add(jSeparator1);

        botonEditarEmpleado.setText("Editar Empleado");
        botonEditarEmpleado.setEnabled(false);
        botonEditarEmpleado.setFocusable(false);
        botonEditarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditarEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleados.add(botonEditarEmpleado);
        menuEmpleados.add(jSeparator2);

        botonEliminarEmpleado.setText("Borrar Empleado");
        botonEliminarEmpleado.setEnabled(false);
        botonEliminarEmpleado.setFocusable(false);
        botonEliminarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminarEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleados.add(botonEliminarEmpleado);
        menuEmpleados.add(jSeparator3);

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
        menuEmpleados.add(botonGuardar);

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
        menuEmpleados.add(botonCancelar);

        getContentPane().add(menuEmpleados, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaEmpleados);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        registrosEmpleados.setText("0 rexistros de clientes");
        registrosEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.add(registrosEmpleados, java.awt.BorderLayout.PAGE_END);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private Empleado getEmpleadoSeleccionado() throws ModelException {
        Long id = (Long) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0);
        return manager.getEmpleadoDAO().obtener(id);
    }
    
    //método edidar
    private void botonEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarEmpleadoActionPerformed
        try {
            Empleado empleado = getEmpleadoSeleccionado();
            detalle.setEmpleado(empleado);
            detalle.setEditable(true);
            detalle.loadData();
            botonGuardar.setEnabled(true);
            botonCancelar.setEnabled(true);
        } catch (ModelException ex) {
            Logger.getLogger(ListEmpleadosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEditarEmpleadoActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        clean();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearEmpleadoActionPerformed
        detalle.setEmpleado(null);
        detalle.loadData();
        detalle.setEditable(true);
        botonGuardar.setEnabled(true);
        botonCancelar.setEnabled(true);
    }//GEN-LAST:event_botonCrearEmpleadoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        detalle.saveData();
        Empleado empleado = detalle.getEmpleado();
        try {
            if(empleado.getId() == null) {
                manager.getEmpleadoDAO().insertar(empleado);
            } else {
                manager.getEmpleadoDAO().modificar(empleado);
            }
            clean();
            obtenerDatos();
            //actualiza la tabla
            model.fireTableDataChanged();
        } catch (ModelException ex) {
            Logger.getLogger(ListEmpleadosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarEmpleadoActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que queres borralo empleado?", 
                "Borrar empleado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                Empleado empleado = getEmpleadoSeleccionado();
                manager.getEmpleadoDAO().eliminar(empleado);
                obtenerDatos();
                //actualiza la tabla
                model.fireTableDataChanged();
            } catch (ModelException ex) {
                Logger.getLogger(ListEmpleadosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_botonEliminarEmpleadoActionPerformed

    private void clean() {
        detalle.setEmpleado(null);
        detalle.setEditable(false);
        detalle.loadData();
        tablaEmpleados.clearSelection();
        botonGuardar.setEnabled(false);
        botonCancelar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrearEmpleado;
    private javax.swing.JButton botonEditarEmpleado;
    private javax.swing.JButton botonEliminarEmpleado;
    private javax.swing.JButton botonGuardar;
    private gal.san.clemente.tarefa3_acceso_datos.view.empleados.DetalleEmpleadoPanel detalle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar menuEmpleados;
    private javax.swing.JLabel registrosEmpleados;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
