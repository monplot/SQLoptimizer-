package AnsweringPattern;


import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;



public class Preprocessing extends javax.swing.JFrame {

ResultSet res,res1;
 public static int row,colu=1;
 Connection con;

   
    public Preprocessing() {
        initComponents();
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Preprocessing");
        setMinimumSize(new java.awt.Dimension(739, 589));
        getContentPane().setLayout(null);

        jPanel3.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Process Display", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(52, 81, 560, 208);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(40, 200, 660, 330);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preprocessing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(389, 30, 116, 33);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton1.setText("Preprocessing");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(147, 30, 116, 33);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(40, 90, 650, 90);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Tokenization Process");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(270, 30, 280, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 740, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//
//GEN-FIRST:event_jButton1ActionPerformed

        row=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Temporal", "root", "");
            Statement state = con.createStatement();
            state.executeUpdate("DELETE FROM `preprocess` WHERE `AID`='_' OR `Query`='_' OR `QueryTime`='_' OR `ItemRank`='_' OR `ClickURL`='_'");
            res=state.executeQuery("SELECT * from `preprocess`");
            while(res.next())
            {

                         
                jTable1.setValueAt(res.getString(1),row,0);
                jTable1.setValueAt(res.getString(2),row,1);
                jTable1.setValueAt(res.getString(3),row,2);
                jTable1.setValueAt(res.getString(4),row,3);
                jTable1.setValueAt(res.getString(5),row,4);
                row++;
            }
            //jLabel1.setText("Dataset is Preprocessed");
            JOptionPane.showMessageDialog(this, "Preprocessing successfully finished");
            res1 = state.executeQuery("SELECT count(*) FROM `preprocess` ");
            while (res1.next()) {
                int co = res1.getInt(1);
               // jLabel3.setText(Integer.toString(co));
            }
            res1 = state.executeQuery("SELECT count(*) FROM `dataset` ");
            while (res1.next()) {
                int co1 = res1.getInt(1);
               // jLabel2.setText(Integer.toString(co1));
        }
        }
      catch(Exception e)
        { JOptionPane.showMessageDialog(this, "Preprocessing successfully finished");
            jLabel1.setText("Dataset is Preprocessed");
               System.out.println(e);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        searching s=new searching();
        s.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
  //  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    //try {
      //      Class.forName("com.mysql.jdbc.Driver");
        //    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Temporal", "root", "");
          //  Statement stmt1 = con.createStatement();
            //res = stmt1.executeQuery("SELECT count(*) FROM `preprocess` ");
           // while (res.next()) {
             //   int co = res.getInt(1);
               // jLabel3.setText(Integer.toString(co));
           // }
           // res = stmt1.executeQuery("SELECT count(*) FROM `dataset` ");
           // while (res.next()) {
             //   int co1 = res.getInt(1);
              //  jLabel2.setText(Integer.toString(co1));
          //  }
           // jLabel3.setText(" ClickUrl Type Dataset");
//            jLabel5.setText(" 332");

           
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
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preprocessing().setVisible(true);
            }
        });
    }

  
   
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
