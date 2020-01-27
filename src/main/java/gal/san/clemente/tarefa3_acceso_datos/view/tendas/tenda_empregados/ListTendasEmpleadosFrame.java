package gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_empregados;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaEmpleado;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.EmpleadosComboModel;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.TendaEmpregadoTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListTendasEmpleadosFrame extends javax.swing.JFrame {
    
    private IDAOManager manager;
    
    private Tenda tenda;
    
    private TendaEmpregadoTableModel model;
    
    public ListTendasEmpleadosFrame(IDAOManager manager, Tenda tenda) throws ModelException, SQLException {
        initComponents();
        this.manager = manager;
        this.tenda = tenda;
        this.model = new TendaEmpregadoTableModel(manager.getTendaEmpleadoDAO(), tenda);
        obtenerDatos();
        this.tablaTendaEmpleados.setModel(model);

        this.detalle.setModel(new EmpleadosComboModel(manager.getEmpleadoDAO()));
        
        //selección de filas
        this.tablaTendaEmpleados.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tablaTendaEmpleados.getSelectedRow() != -1);
            botonEditarEmpleadoTenda.setEnabled(seleccionValida);
            botonEliminarEmpleadoTenda.setEnabled(seleccionValida);
        });
    }
    
    final void obtenerDatos() throws ModelException {
        registrosTendas.setText("Actualizando datos ...");
        detalle.loadData(tenda);
        model.updateModelTenda();
        registrosTendas.setText(model.getRowCount() + " registros empregados de tenda");
        datosTenda.setText("Tenda: " + tenda.getNome() + ", Provincia: " + tenda.getProvincia() + ", Cidade: " + tenda.getCidade());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTendas = new javax.swing.JToolBar();
        botonCrearEmpleadoTenda = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonEditarEmpleadoTenda = new javax.swing.JButton();
        botonEliminarEmpleadoTenda = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTendaEmpleados = new javax.swing.JTable();
        registrosTendas = new javax.swing.JLabel();
        datosTenda = new javax.swing.JLabel();
        detalle = new gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_empregados.DetalleTendaEmpleadoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión Tendas");

        menuTendas.setRollover(true);

        botonCrearEmpleadoTenda.setText("Alta Empregado Tenda");
        botonCrearEmpleadoTenda.setFocusable(false);
        botonCrearEmpleadoTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrearEmpleadoTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrearEmpleadoTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearEmpleadoTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonCrearEmpleadoTenda);
        menuTendas.add(jSeparator1);

        botonEditarEmpleadoTenda.setText("Editar Empregado Tenda");
        botonEditarEmpleadoTenda.setEnabled(false);
        botonEditarEmpleadoTenda.setFocusable(false);
        botonEditarEmpleadoTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditarEmpleadoTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditarEmpleadoTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarEmpleadoTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonEditarEmpleadoTenda);

        botonEliminarEmpleadoTenda.setText("Borrar Empregado Tenda");
        botonEliminarEmpleadoTenda.setEnabled(false);
        botonEliminarEmpleadoTenda.setFocusable(false);
        botonEliminarEmpleadoTenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminarEmpleadoTenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminarEmpleadoTenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarEmpleadoTendaActionPerformed(evt);
            }
        });
        menuTendas.add(botonEliminarEmpleadoTenda);
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

        tablaTendaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaTendaEmpleados);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        registrosTendas.setText("0 rexistros de tendas");
        registrosTendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.add(registrosTendas, java.awt.BorderLayout.PAGE_END);

        datosTenda.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        datosTenda.setText("Tenda: ");
        datosTenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel1.add(datosTenda, java.awt.BorderLayout.PAGE_START);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private TendaEmpleado getTendaEmpleadoSeleccionado() throws ModelException {
        Long id = (Long) tablaTendaEmpleados.getValueAt(tablaTendaEmpleados.getSelectedRow(), 0);
        return manager.getTendaEmpleadoDAO().obtener(id);
    }
    
    //método edidar
    private void botonEditarEmpleadoTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarEmpleadoTendaActionPerformed
        try {
            TendaEmpleado tendaEmpleado = getTendaEmpleadoSeleccionado();
            detalle.setTendaEmpleado(tendaEmpleado);
            detalle.setTenda(tenda);
            detalle.setEditable(true);
            detalle.loadData(tenda);
            botonGuardar.setEnabled(true);
            botonCancelar.setEnabled(true);
        } catch (ModelException ex) {
            Logger.getLogger(ListTendasEmpleadosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEditarEmpleadoTendaActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        clean();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCrearEmpleadoTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearEmpleadoTendaActionPerformed
        detalle.setTendaEmpleado(null);
        detalle.loadData(tenda);
        detalle.setEditable(true);
        botonGuardar.setEnabled(true);
        botonCancelar.setEnabled(true);
    }//GEN-LAST:event_botonCrearEmpleadoTendaActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        detalle.saveData();
        TendaEmpleado tendaEmpleado = detalle.getTendaEmpleado();
        try {
            if(tendaEmpleado.getId() == null) {
                manager.getTendaEmpleadoDAO().insertar(tendaEmpleado);
            } else {
                manager.getTendaEmpleadoDAO().modificar(tendaEmpleado);
            }
            clean();
            obtenerDatos();
            //actualiza la tabla
            model.fireTableDataChanged();
        } catch (ModelException ex) {
            Logger.getLogger(ListTendasEmpleadosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarEmpleadoTendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarEmpleadoTendaActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que queres borralo empregado da tenda?", 
                "Borrar empregado tenda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                TendaEmpleado tendaEmpleado = getTendaEmpleadoSeleccionado();
                manager.getTendaEmpleadoDAO().eliminar(tendaEmpleado);
                obtenerDatos();
                //actualiza la tabla
                model.fireTableDataChanged();
            } catch (ModelException ex) {
                Logger.getLogger(ListTendasEmpleadosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_botonEliminarEmpleadoTendaActionPerformed
    
    private void clean() {
        detalle.setTendaEmpleado(null);
        detalle.setEditable(false);
        detalle.loadData(tenda);
        tablaTendaEmpleados.clearSelection();
        botonGuardar.setEnabled(false);
        botonCancelar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrearEmpleadoTenda;
    private javax.swing.JButton botonEditarEmpleadoTenda;
    private javax.swing.JButton botonEliminarEmpleadoTenda;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel datosTenda;
    private gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_empregados.DetalleTendaEmpleadoPanel detalle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar menuTendas;
    private javax.swing.JLabel registrosTendas;
    private javax.swing.JTable tablaTendaEmpleados;
    // End of variables declaration//GEN-END:variables
}
