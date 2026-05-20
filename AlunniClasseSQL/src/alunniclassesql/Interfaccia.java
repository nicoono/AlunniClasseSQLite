/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package alunniclassesql;

import javax.swing.*;

/**
 *
 * @author onorati.nicolo
 */
public class Interfaccia extends javax.swing.JFrame {
    Gestore g = new Gestore();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Interfaccia.class.getName());

    /**
     * Creates new form Interfaccia
     */
    public Interfaccia() {
        initComponents();
        this.setSize(946, 580);
        for (String classe : g.leggiClassi()) {
                cmb_mostraClassi.addItem(classe);
            }
        txtF_nome.setText("");
        txtF_cognome.setText("");
        txtF_nomeUpdate.setText("");
        txtF_cognomeUpdate.setText("");
        
    }
    public void aggiorna(){
        Object selezionato = cmb_mostraClassi.getSelectedItem();
        if (selezionato == null) {
            return;
        }

        txtA_elencoAlunni.setText("");

        String classeSelezionata = selezionato.toString();
        java.util.ArrayList<String> studenti = g.leggiStudenti(classeSelezionata);

        cmb_scegliAlunni.removeAllItems();
        cmb_scegliAlunniUpdate.removeAllItems();

        for (String s : studenti) {
            txtA_elencoAlunni.append(s + "\n");
            cmb_scegliAlunni.addItem(s);
            cmb_scegliAlunniUpdate.addItem(s);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmb_mostraClassi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_elencoAlunni = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btn_aggiungiAlunno = new javax.swing.JButton();
        btn_rimuovi = new javax.swing.JButton();
        cmb_scegliAlunni = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btn_aggiornaAlunno = new javax.swing.JButton();
        cmb_scegliAlunniUpdate = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtF_nome = new javax.swing.JTextField();
        txtF_cognome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        txtF_nomeUpdate = new javax.swing.JTextField();
        txtF_cognomeUpdate = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        cmb_mostraClassi.addActionListener(this::cmb_mostraClassiActionPerformed);
        getContentPane().add(cmb_mostraClassi);
        cmb_mostraClassi.setBounds(150, 98, 248, 86);

        jLabel1.setText("ELENCO CLASSE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(229, 76, 87, 16);

        txtA_elencoAlunni.setColumns(20);
        txtA_elencoAlunni.setRows(5);
        jScrollPane1.setViewportView(txtA_elencoAlunni);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(31, 240, 460, 209);

        jLabel2.setText("ELENCO ALUNNI");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(219, 218, 90, 16);

        btn_aggiungiAlunno.setText("AGGIUNGI ALUNNO");
        btn_aggiungiAlunno.addActionListener(this::btn_aggiungiAlunnoActionPerformed);
        getContentPane().add(btn_aggiungiAlunno);
        btn_aggiungiAlunno.setBounds(536, 84, 390, 23);

        btn_rimuovi.setText("RIMUOVI ALUNNO");
        btn_rimuovi.addActionListener(this::btn_rimuoviActionPerformed);
        getContentPane().add(btn_rimuovi);
        btn_rimuovi.setBounds(617, 168, 250, 23);

        cmb_scegliAlunni.addActionListener(this::cmb_scegliAlunniActionPerformed);
        getContentPane().add(cmb_scegliAlunni);
        cmb_scegliAlunni.setBounds(617, 203, 250, 49);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(527, 0, 3, 541);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(527, 119, 405, 3);

        jLabel3.setText("NOME");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(542, 22, 64, 16);

        jLabel4.setText("COGNOME");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(866, 22, 60, 16);

        jLabel5.setText("AGGIUNGI ALUNNO");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(679, 0, 107, 16);

        jLabel6.setText("RIMUOVI ALUNNO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(685, 128, 100, 16);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(536, 258, 390, 3);

        jLabel7.setText("AGGIORNA ALUNNO");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(681, 273, 112, 16);

        btn_aggiornaAlunno.setText("AGGIORNA ALUNNO");
        btn_aggiornaAlunno.addActionListener(this::btn_aggiornaAlunnoActionPerformed);
        getContentPane().add(btn_aggiornaAlunno);
        btn_aggiornaAlunno.setBounds(619, 301, 250, 23);

        getContentPane().add(cmb_scegliAlunniUpdate);
        cmb_scegliAlunniUpdate.setBounds(619, 342, 250, 49);

        jLabel8.setText("NOME");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(559, 397, 51, 16);

        jLabel9.setText("COGNOME");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(846, 397, 60, 16);

        txtF_nome.setText("jTextField1");
        getContentPane().add(txtF_nome);
        txtF_nome.setBounds(536, 44, 189, 22);

        txtF_cognome.setText("jTextField2");
        getContentPane().add(txtF_cognome);
        txtF_cognome.setBounds(734, 44, 192, 22);

        jButton1.setText("PASSA A SCHERMATA GITE");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1);
        jButton1.setBounds(594, 483, 281, 23);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(530, 0, 400, 120);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 530, 540);

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(530, 120, 400, 140);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        txtF_nomeUpdate.setText("jTextField3");

        txtF_cognomeUpdate.setText("jTextField4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtF_nomeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtF_cognomeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF_nomeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtF_cognomeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(530, 260, 400, 190);

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(530, 450, 400, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_mostraClassiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_mostraClassiActionPerformed
        Object selezionato = cmb_mostraClassi.getSelectedItem();

        if (selezionato == null) {
            return;
        }

        String classeSelezionata = selezionato.toString();
        txtA_elencoAlunni.setText("");

        this.aggiorna();
    }//GEN-LAST:event_cmb_mostraClassiActionPerformed

    private void btn_rimuoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rimuoviActionPerformed
        Object item = cmb_scegliAlunni.getSelectedItem();

        if (item == null) {
            JOptionPane.showMessageDialog(this, "Seleziona un alunno dalla lista!");
            return;
        }

        String rigaSelezionato = item.toString();

        int id= Integer.parseInt(rigaSelezionato.split(" - ")[0]);

        if (g.rimuoviAlunno(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Alunno rimosso correttamente.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Errore nella rimozione.");
        }
        
        this.aggiorna();
    }//GEN-LAST:event_btn_rimuoviActionPerformed

    private void btn_aggiungiAlunnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aggiungiAlunnoActionPerformed
        
        String nome = txtF_nome.getText().trim();
        String cognome = txtF_cognome.getText().trim();
        Object selezionato = cmb_mostraClassi.getSelectedItem();
        //Estraggo l'ID della classe (es. da "3AI - Informatica" prendo "3AI")
        String idClasse = selezionato.toString().split(" - ")[0];
        String classeSelezionata = selezionato.toString();
        
        if (nome.isEmpty() || cognome.isEmpty() || selezionato == null) {
            JOptionPane.showMessageDialog(this, "Per favore, compila tutti i campi e seleziona una classe.");
        }

        else if (g.aggiungiAlunno(nome, cognome, idClasse)) {
            JOptionPane.showMessageDialog(this, "Alunno inserito!");

            txtF_nome.setText("");
            txtF_cognome.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Errore nell'inserimento.");
        }
        
        this.aggiorna();
    }//GEN-LAST:event_btn_aggiungiAlunnoActionPerformed

    private void cmb_scegliAlunniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_scegliAlunniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_scegliAlunniActionPerformed

    private void btn_aggiornaAlunnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aggiornaAlunnoActionPerformed
        String nome = txtF_nomeUpdate.getText().trim();
        String cognome = txtF_cognomeUpdate.getText().trim();
        Object alunnoScelto = cmb_scegliAlunniUpdate.getSelectedItem();
        
        String rigaAlunno = alunnoScelto.toString();
        int idAlunno = Integer.parseInt(rigaAlunno.split(" - ")[0]);
        
        if (nome.isEmpty() || cognome.isEmpty() || alunnoScelto == null) {
            JOptionPane.showMessageDialog(this, "Per favore, compila tutti i campi e seleziona una classe.");
        }
        else if(g.aggiornaAlunno(idAlunno, nome, cognome)){
            JOptionPane.showMessageDialog(this, "Alunno aggiornato!");
            txtF_nomeUpdate.setText("");
            txtF_cognomeUpdate.setText("");
            this.aggiorna();
        }
         else {
            JOptionPane.showMessageDialog(this, "Errore nell'inserimento.");
        }
        
        
    }//GEN-LAST:event_btn_aggiornaAlunnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InterfacciaGite ig = new InterfacciaGite();
        ig.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Interfaccia().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aggiornaAlunno;
    private javax.swing.JButton btn_aggiungiAlunno;
    private javax.swing.JButton btn_rimuovi;
    private javax.swing.JComboBox<String> cmb_mostraClassi;
    private javax.swing.JComboBox<String> cmb_scegliAlunni;
    private javax.swing.JComboBox<String> cmb_scegliAlunniUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea txtA_elencoAlunni;
    private javax.swing.JTextField txtF_cognome;
    private javax.swing.JTextField txtF_cognomeUpdate;
    private javax.swing.JTextField txtF_nome;
    private javax.swing.JTextField txtF_nomeUpdate;
    // End of variables declaration//GEN-END:variables
}
