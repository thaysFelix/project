package trabalho4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class EditorArquivos extends javax.swing.JFrame {

    BufferedReader buffRead;
    File f;
    String fileName;

    public EditorArquivos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        conteudoArquivo = new javax.swing.JTextArea();
        caminho = new javax.swing.JLabel();
        linhaEditada = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        abrirArquivo = new javax.swing.JMenuItem();
        botaoSalvar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        conteudoArquivo.setColumns(20);
        conteudoArquivo.setRows(5);
        conteudoArquivo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                conteudoArquivoCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(conteudoArquivo);

        caminho.setText("Caminho:");

        linhaEditada.setText("Linha editada: ");

        menu.setText("Arquivos");

        abrirArquivo.setText("Abrir");
        abrirArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArquivoActionPerformed(evt);
            }
        });
        menu.add(abrirArquivo);

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        menu.add(botaoSalvar);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caminho)
                    .addComponent(linhaEditada))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caminho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linhaEditada)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArquivoActionPerformed
        JFileChooser chooserFile = new JFileChooser();
        chooserFile.showOpenDialog(null);
        f = chooserFile.getSelectedFile();
        fileName = f.getAbsolutePath();
        caminho.setText("Caminho: "+ fileName);
        try {
            FileReader textReader = new FileReader(fileName);

            buffRead = new BufferedReader(textReader);
            conteudoArquivo.read(buffRead, null);
            buffRead.close();
            conteudoArquivo.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_abrirArquivoActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        String texto = conteudoArquivo.getText();

        try {
            FileWriter textWriter = new FileWriter(fileName);
            textWriter.write(texto);
            textWriter.close();
            JOptionPane.showMessageDialog(null, "Texto salvo com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void conteudoArquivoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_conteudoArquivoCaretUpdate
        try {
            int linhaSendoEditada = conteudoArquivo.getLineOfOffset(conteudoArquivo.getCaretPosition()) + 1;
            linhaEditada.setText("Linha editada: "+ String.valueOf(linhaSendoEditada));
            
        } catch (BadLocationException ex) {
            Logger.getLogger(EditorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_conteudoArquivoCaretUpdate

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorArquivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorArquivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorArquivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorArquivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorArquivos().setVisible(true);
            }
        });

        //File.escrever(path);
        //File.leitor(path);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArquivo;
    private javax.swing.JMenuItem botaoSalvar;
    private javax.swing.JLabel caminho;
    private javax.swing.JTextArea conteudoArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel linhaEditada;
    private javax.swing.JMenu menu;
    // End of variables declaration//GEN-END:variables
}
