package gal.san.clemente.tarefa3_acceso_datos.view.empleados;

import gal.san.clemente.tarefa3_acceso_datos.model.Empleado;

public class DetalleEmpleadoPanel extends javax.swing.JPanel {
    
    private Empleado empleado;
    private boolean editable;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean isEditable() {
        return editable;
    }
    
    //método controlar la edicción de datos
    public void setEditable(boolean editable) {
        this.editable = editable;
        nomeEmpleado.setEditable(editable);
        apelidosEmpleado.setEditable(editable);
    }
    
    //método cargar datos
    public void loadData() {
        if(empleado != null) {
            nomeEmpleado.setText(empleado.getNome());
            apelidosEmpleado.setText(empleado.getApelidos());
        } else {
            nomeEmpleado.setText("");
            apelidosEmpleado.setText("");
        }
        nomeEmpleado.requestFocus();
    }
    
    //método guardar datos
    public void saveData() {
        if(empleado == null) {
            empleado = new Empleado();
        }
        empleado.setNome(nomeEmpleado.getText());
        empleado.setApelidos(apelidosEmpleado.getText());
    }

    public DetalleEmpleadoPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeEmpleado = new javax.swing.JTextField();
        apelidosEmpleado = new javax.swing.JTextField();

        jLabel1.setText("Nome Empleado");

        jLabel2.setText("Apelidos Empleado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomeEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(apelidosEmpleado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(apelidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apelidosEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nomeEmpleado;
    // End of variables declaration//GEN-END:variables
}
