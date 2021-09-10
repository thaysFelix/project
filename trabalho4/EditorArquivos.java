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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditorArquivos extends javax.swing.JFrame {
   // JTextArea conteudoArquivo = new JTextArea();
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
        caminho = new javax.swing.JLabel();
        linhaEditada = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        conteudoArquivo = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        abrirArquivo = new javax.swing.JMenuItem();
        botaoSalvar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        caminho.setText("Caminho:");

        linhaEditada.setText("Linha editada: ");

        jTree1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTree1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel1);

        conteudoArquivo.setColumns(20);
        conteudoArquivo.setRows(5);
        conteudoArquivo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                conteudoArquivoCaretUpdate(evt);
            }
        });
        conteudoArquivo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                conteudoArquivoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(conteudoArquivo);

        jTabbedPane2.addTab("tab2", jScrollPane1);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(caminho)
                        .addGap(456, 456, 456)
                        .addComponent(linhaEditada))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(268, 268, 268)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(linhaEditada)
                            .addComponent(caminho))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArquivoActionPerformed
        JFileChooser chooserFile = new JFileChooser();
        chooserFile.showOpenDialog(null);
        f = chooserFile.getSelectedFile();
        fileName = f.getAbsolutePath();
        
        //jTabbedPane2 = new javax.swing.JTabbedPane();
        JPanel jPanelFirst = new JPanel();
        
        //jTabbedPane2.addTab(fileName, jPanelFirst);
        JTabbedPane jTabbedPane2 = new JTabbedPane();
        jTabbedPane2.add(fileName, jPanelFirst);
        
        caminho.setText("Caminho: "+ fileName);
        try {
            FileReader textReader = new FileReader(fileName);
            JTextArea teste = new JTextArea();
            buffRead = new BufferedReader(textReader);
            teste.read(buffRead, null);
            buffRead.close();
            
            jPanelFirst.add(teste);
            
            teste.requestFocus();

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

    private void jTree1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTree1AncestorAdded
      
    }//GEN-LAST:event_jTree1AncestorAdded

    private void conteudoArquivoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_conteudoArquivoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_conteudoArquivoAncestorAdded

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel linhaEditada;
    private javax.swing.JMenu menu;
    // End of variables declaration//GEN-END:variables
}
