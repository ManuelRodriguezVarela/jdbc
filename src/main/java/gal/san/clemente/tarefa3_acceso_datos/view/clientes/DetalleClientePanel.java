package gal.san.clemente.tarefa3_acceso_datos.view.clientes;

import gal.san.clemente.tarefa3_acceso_datos.model.Cliente;

public class DetalleClientePanel extends javax.swing.JPanel {
    
    private Cliente cliente;
    private boolean editable;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEditable() {
        return editable;
    }
    
    //método controlar la edicción de datos
    public void setEditable(boolean editable) {
        this.editable = editable;
        nomeCliente.setEditable(editable);
        apelidosCliente.setEditable(editable);
        emailCliente.setEditable(editable);
    }
    
    //método cargar datos
    public void loadData() {
        if(cliente != null) {
            nomeCliente.setText(cliente.getNome());
            apelidosCliente.setText(cliente.getApelidos());
            emailCliente.setText(cliente.getEmail());
        } else {
            nomeCliente.setText("");
            apelidosCliente.setText("");
            emailCliente.setText("");
        }
        nomeCliente.requestFocus();
    }
    
    //método guardar datos
    public void saveData() {
        if(cliente == null) {
            cliente = new Cliente();
        }
        cliente.setNome(nomeCliente.getText());
        cliente.setApelidos(apelidosCliente.getText());
        cliente.setEmail(emailCliente.getText());
    }

    public DetalleClientePanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        apelidosCliente = new javax.swing.JTextField();
        emailCliente = new javax.swing.JTextField();

        jLabel1.setText("Nome Cliente");

        jLabel2.setText("Apelidos Cliente");

        jLabel3.setText("Email Cliente");

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
                    .addComponent(nomeCliente)
                    .addComponent(apelidosCliente)
                    .addComponent(emailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(apelidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apelidosCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeCliente;
    // End of variables declaration//GEN-END:variables
}
