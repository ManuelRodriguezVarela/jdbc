package gal.san.clemente.tarefa3_acceso_datos.view.tendas;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Provincia;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProvinciaDAO;
import gal.san.clemente.tarefa3_acceso_datos.view.converter.ProvinciasComboModel;

public class DetalleTendaPanel extends javax.swing.JPanel {
    
    private Tenda tenda;
    private boolean editable;
    private Provincia provincia;
    private ProvinciasComboModel model;

    public ProvinciasComboModel getModel() {
        return model;
    }

    public void setModel(ProvinciasComboModel model) throws ModelException {
        this.model = model;
        nomeProvincia.setModel(model);
        model.update();
    }

    public Tenda getTenda() {
        return tenda;
    }

    public void setTenda(Tenda tenda) {
        this.tenda = tenda;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public boolean isEditable() {
        return editable;
    }
    
    //método controlar la edicción de datos
    public void setEditable(boolean editable) {
        this.editable = editable;
        nomeTenda.setEditable(editable);
        nomeProvincia.setEnabled(editable);
        cidadeTenda.setEditable(editable);
    }
    
    //método cargar datos
    public void loadData() {
        if(tenda != null) {
            nomeTenda.setText(tenda.getNome());
            cidadeTenda.setText(tenda.getCidade());
        } else {
            nomeTenda.setText("");
            cidadeTenda.setText("");
        }
        nomeTenda.requestFocus();
    }
    
    //método guardar datos
    public void saveData() {
        if(tenda == null) {
            tenda = new Tenda();
        }
        tenda.setNome(nomeTenda.getText());
        ProvinciaComboView pcv = (ProvinciaComboView) nomeProvincia.getSelectedItem();
        tenda.setProvincia(pcv.getProvincia().getNome());
        tenda.setCidade(cidadeTenda.getText());
    }

    public DetalleTendaPanel() {
        initComponents();
        model = new ProvinciasComboModel(null);
    }
    
    public DetalleTendaPanel(IProvinciaDAO provinciaDAO) throws ModelException {
        initComponents();
        model = new ProvinciasComboModel(provinciaDAO);
        model.update();
        nomeProvincia.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeTenda = new javax.swing.JTextField();
        cidadeTenda = new javax.swing.JTextField();
        nomeProvincia = new javax.swing.JComboBox<>();

        jLabel1.setText("Nome Tenda");

        jLabel2.setText("Provincia Tenda");

        jLabel3.setText("Cidade Tenda");

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
                    .addComponent(cidadeTenda, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(nomeProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(nomeProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cidadeTenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cidadeTenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<ProvinciaComboView> nomeProvincia;
    private javax.swing.JTextField nomeTenda;
    // End of variables declaration//GEN-END:variables
}
