/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.visao;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

public class TelaProduto extends javax.swing.JFrame {

    /**
     * Creates new form TelaProduto
     */
public TelaProduto() {
    initComponents();
    Connect(); // Chame o método de conexão ao inicializar o formulário
    LoadProductNo(); // Chamando o método corrigido
    Fetch();
}

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
  

  
public void Connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacrud", "root", "");
        System.out.println("Conexão estabelecida com sucesso!");
    } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
        System.out.println("Falha na conexão com o banco de dados.");
    }
}

public void LoadProductNo() {
    try {
        pst = con.prepareStatement("SELECT id FROM produto_tb");
        rs = pst.executeQuery();
        jCPid.removeAllItems();
        while(rs.next()) {
            jCPid.addItem(rs.getString(1));
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
}


private void Fetch(){
    try {
        int q;
        pst = con.prepareStatement("SELECT * FROM produto_tb");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        q = rss.getColumnCount();
        
        DefaultTableModel df =(DefaultTableModel)jTable1.getModel();
        df.setRowCount(0);
        while(rs.next()){
            Vector v2 = new Vector();
            for(int a=1; a<q; a++){
                v2.add(rs.getString("id"));
                v2.add(rs.getString("pnome"));
                v2.add(rs.getString("preco"));
                v2.add(rs.getString("qtd"));
            }
            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
}



public void addProduto(String nome, String preco, String quantidade) {
    try {
        pst = con.prepareStatement("INSERT INTO produto_tb(pnome, preco, qtd) VALUES (?, ?, ?)");
        pst.setString(1, nome);
        pst.setString(2, preco);
        pst.setString(3, quantidade);
        
        System.out.println("Tentando executar SQL...");
        int rowsAffected = pst.executeUpdate();
        System.out.println("Linhas afetadas: " + rowsAffected);
        
        if (rowsAffected > 0) {
            System.out.println("Produto adicionado com sucesso!");
            Fetch();
            LoadProductNo();
        } else {
            System.out.println("Falha ao adicionar produto.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTPnome = new javax.swing.JTextField();
        jTPreco = new javax.swing.JTextField();
        jTQtd = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jBadd = new javax.swing.JButton();
        jBAtualizar = new javax.swing.JButton();
        jBDeletar = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCPid = new javax.swing.JComboBox<>();
        jBPesquisa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Produto:");

        jLabel2.setText("Preço do Produto:");

        jLabel3.setText("Quantidade:");

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jBadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBadd.setText("Add");
        jBadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaddActionPerformed(evt);
            }
        });

        jBAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBAtualizar.setText("Atualizar");
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });

        jBDeletar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });

        jBNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBNovo.setText("Exporta ");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBadd)
                .addGap(18, 18, 18)
                .addComponent(jBAtualizar)
                .addGap(18, 18, 18)
                .addComponent(jBDeletar)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jBNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBadd)
                    .addComponent(jBAtualizar)
                    .addComponent(jBDeletar)
                    .addComponent(jBNovo)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID do Produto:");

        jCPid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCPid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPidActionPerformed(evt);
            }
        });

        jBPesquisa.setText("Pesquisa");
        jBPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jCPid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBPesquisa)
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCPid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBPesquisa)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID do Produto", "Nome", "Preço", "Estoque"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("CRUD DA AGENCIA DE VEICULOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTPnome)
                            .addComponent(jTPreco)
                            .addComponent(jTQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTPnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCPidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCPidActionPerformed

    private void jBaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaddActionPerformed
        // TODO add your handling code here:
    Connect(); // Estabelece a conexão
    String nome = jTPnome.getText();
    String preco = jTPreco.getText();
    String quantidade = jTQtd.getText();
    addProduto(nome, preco, quantidade);
    JOptionPane.showMessageDialog(this, "Produto Adicionado com Sucesso!");
    }//GEN-LAST:event_jBaddActionPerformed

    private void jBPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisaActionPerformed
    try {
        // TODO add your handling code here:
        
        String pid = jCPid.getSelectedItem().toString();
        
        pst = con.prepareStatement("SELECT * FROM produto_tb where id=?");
        pst.setString(1, pid);
        rs = pst.executeQuery();
        
        if(rs.next()== true){
            jTPnome.setText(rs.getString(2));
            jTPreco.setText(rs.getString(3));
            jTQtd.setText(rs.getString(4));
        }else{
            JOptionPane.showMessageDialog(this, "nenhum registro encontrado!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jBPesquisaActionPerformed

    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
    try {
        // TODO add your handling code here:
        
        String pnome = jTPnome.getText();
        String preco = jTPreco.getText();
        String qtd = jTQtd.getText();
        String pid = jCPid.getSelectedItem().toString();
        
        pst = con.prepareStatement("UPDATE produto_tb SET pnome=?,preco=?,qtd=? WHERE id=?");
        
        pst.setString(1, pnome);
        pst.setString(2, preco);
        pst.setString(3, qtd);
        pst.setString(4, pid);
        
        
        int k=pst.executeUpdate();
        if(k==1){
            JOptionPane.showMessageDialog(this, "O registro foi atualizado com sucesso");  
                jTPnome.setText("");
                jTPreco.setText("");
                jTQtd.setText("");
                jTPnome.requestFocus();
                Fetch();
                LoadProductNo();
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jBAtualizarActionPerformed

    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
    try {
        // TODO add your handling code here:
        
        String pid = jCPid.getSelectedItem().toString();
        pst = con.prepareStatement("DELETE FROM produto_tb WHERE id=?");
        pst.setString(1, pid);
        
        int k = pst.executeUpdate();
        if(k==1){
            JOptionPane.showMessageDialog(this, "O registro foi deletado com sucesso");
                jTPnome.setText("");
                jTPreco.setText("");
                jTQtd.setText("");
                jTPnome.requestFocus();
                Fetch();
                LoadProductNo();
        }else{
            JOptionPane.showMessageDialog(this, "Ouve um Erro ao Deletar o Registro!!");            
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jBDeletarActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        // TODO add your handling code here:
        
        String filename = "D:\\ExporedFileJava.csv";
        
    try {
        FileWriter fw = new FileWriter(filename);
        pst =con.prepareStatement("SELECT * FROM produto_tb");
        rs = pst.executeQuery();
        
        while(rs.next()){
            fw.append(rs.getString(1));
            fw.append(',');
            fw.append(rs.getString(2));
            fw.append(',');
            fw.append(rs.getString(3));
            fw.append(',');
            fw.append(rs.getString(4));
            fw.append('\n');
        }
        JOptionPane.showMessageDialog(this, "Excel Criado com Sucesso!!"); 
        fw.flush();
        fw.close();
    } catch (IOException ex) {
        Logger.getLogger(TelaProduto.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(TelaProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:  
     // Abre a tela VendaForm
    new TelaDeVendas().setVisible(true);
    this.dispose(); // Fecha a tela atual, se necessário
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
      // Abre a tela de listar vendas
    new Bonaparte().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBDeletar;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBPesquisa;
    private javax.swing.JButton jBadd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCPid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTPnome;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JTextField jTQtd;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
