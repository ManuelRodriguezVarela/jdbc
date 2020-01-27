package gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_empregados;

import gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_productos.*;
import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Empleado;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaEmpleado;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IEmpleadoDAO;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.EmpleadosComboModel;

public class DetalleTendaEmpleadoPanel extends javax.swing.JPanel {
    
    private TendaEmpleado tendaEmpleado;
    private boolean editable;
    private Empleado empleado;
    private Tenda tenda;
    private EmpleadosComboModel model;

    public EmpleadosComboModel getModel() {
        return model;
    }

    public void setModel(EmpleadosComboModel model) throws ModelException {
        this.model = model;
        nomeEmpleado.setModel(model);
        model.update();
    }

    public TendaEmpleado getTendaEmpleado() {
        return tendaEmpleado;
    }

    public void setTendaEmpleado(TendaEmpleado tendaEmpleado) {
        this.tendaEmpleado = tendaEmpleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
        nomeEmpleado.setEnabled(editable);
        horasSemana.setEditable(editable);
    }
    
    //método cargar datos
    public void loadData(Tenda tenda) {
        this.setTenda(tenda);
        if(tendaEmpleado != null) {
            nomeTenda.setText(tenda.getId().toString());
            horasSemana.setText(tendaEmpleado.getNumeroHorasSemana().toString());
        } else {
            nomeTenda.setText(tenda.getId().toString());
            horasSemana.setText("");
        }
        horasSemana.requestFocus();
    }
    
    //método guardar datos
    public void saveData() {
        if(tendaEmpleado == null) {
            tendaEmpleado = new TendaEmpleado();
        }
        tendaEmpleado.setIdTenda(tenda.getId());
        EmpleadoComboView ecv = (EmpleadoComboView) nomeEmpleado.getSelectedItem();
        tendaEmpleado.setIdEmpleado(ecv.getEmpleado().getId());
        tendaEmpleado.setNumeroHorasSemana(Integer.parseInt(horasSemana.getText()));
    }

    public DetalleTendaEmpleadoPanel() {
        initComponents();
        model = new EmpleadosComboModel(null);
    }
    
    public DetalleTendaEmpleadoPanel(IEmpleadoDAO empleadoDAO, Tenda tenda) throws ModelException {
        initComponents();
        model = new EmpleadosComboModel(empleadoDAO);
        this.tenda = tenda;
        model.update();
        nomeEmpleado.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeTenda = new javax.swing.JTextField();
        horasSemana = new javax.swing.JTextField();
        nomeEmpleado = new javax.swing.JComboBox<>();

        jLabel1.setText("Tenda");

        jLabel2.setText("Empregado Tenda");

        jLabel3.setText("Número de horas semana");

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
                    .addComponent(horasSemana, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(nomeEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(nomeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(horasSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField horasSemana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<EmpleadoComboView> nomeEmpleado;
    private javax.swing.JTextField nomeTenda;
    // End of variables declaration//GEN-END:variables
}
