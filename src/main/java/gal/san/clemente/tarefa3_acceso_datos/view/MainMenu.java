package gal.san.clemente.tarefa3_acceso_datos.view;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.view.clientes.ListClientesFrame;
import gal.san.clemente.tarefa3_acceso_datos.view.empleados.ListEmpleadosFrame;
import gal.san.clemente.tarefa3_acceso_datos.view.productos.ListProdutosFrame;
import gal.san.clemente.tarefa3_acceso_datos.view.tendas.ListTendasFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu extends javax.swing.JFrame {
    
    private IDAOManager manager;

    public MainMenu(IDAOManager manager) {
        initComponents();
        this.manager = manager;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientes = new javax.swing.JButton();
        produtos = new javax.swing.JButton();
        tendas = new javax.swing.JButton();
        empregados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientes.setText("Xestión Clientes");
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });

        produtos.setText("Xestión Produtos");
        produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosActionPerformed(evt);
            }
        });

        tendas.setText("Xestión Tendas");
        tendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tendasActionPerformed(evt);
            }
        });

        empregados.setText("Xestión Empregados");
        empregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tendas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empregados, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tendas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empregados, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        try {
            ListClientesFrame listaClientes = new ListClientesFrame(manager);
            listaClientes.setLocationRelativeTo(this);
            listaClientes.setVisible(true);
        } catch (ModelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_clientesActionPerformed

    private void tendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tendasActionPerformed
        try {
            ListTendasFrame listaTendas = new ListTendasFrame(manager);
            listaTendas.setLocationRelativeTo(this);
            listaTendas.setVisible(true);
        } catch (ModelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tendasActionPerformed

    private void produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosActionPerformed
        try {
            ListProdutosFrame listaProdutos = new ListProdutosFrame(manager);
            listaProdutos.setLocationRelativeTo(this);
            listaProdutos.setVisible(true);
        } catch (ModelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_produtosActionPerformed

    private void empregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadosActionPerformed
        try {
            ListEmpleadosFrame listaEmpleados = new ListEmpleadosFrame(manager);
            listaEmpleados.setLocationRelativeTo(this);
            listaEmpleados.setVisible(true);
        } catch (ModelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_empregadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientes;
    private javax.swing.JButton empregados;
    private javax.swing.JButton produtos;
    private javax.swing.JButton tendas;
    // End of variables declaration//GEN-END:variables
}
