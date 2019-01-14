package AnsweringPattern;

import java.awt.Rectangle;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class load extends javax.swing.JFrame {

    Connection con;
    Statement state;
    ResultSet res, res1;
    public static int row, colu = 1;
    public static String ss = Home.FP;

    public load() {
        initComponents();
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "Temporal";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, "root", "");
            state = con.createStatement();
            jTextField1.setText(Home.FP);
            System.out.println("connected successfully");
            //state.executeUpdate("truncate table load");


        } catch (Exception e) {
            System.out.println("Excep1:" + e.getMessage());
        }
    }

    public load(String s) {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loading Page");
        setMinimumSize(new java.awt.Dimension(837, 551));
        getContentPane().setLayout(null);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(380, 20, 220, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Process Display", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jButton2.setText("Load ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(60, 90, 116, 33);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(20, 40, 348, 26);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 60, 400, 450);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Path of the Dataset:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 20, 120, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dataset Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Number of Records in original dataset : ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 200, 220, 28);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel5);
        jLabel5.setBounds(260, 200, 70, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel8.setText("Number of Columns : ");
        jLabel8.setToolTipText("");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 380, 115, 28);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel9);
        jLabel9.setBounds(150, 380, 210, 30);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(40, 50, 116, 33);

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(180, 50, 116, 33);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(440, 60, 380, 460);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(430, 60, 30, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


        try {
            Random random = new Random();
            int progress = 0;
            while (progress < 10) {

                Thread.sleep(random.nextInt(10));
                progress += 1;
                jProgressBar1.setValue(110);

                Rectangle progressRect = jProgressBar1.getBounds();
                progressRect.x = 0;
                progressRect.y = 0;
//System.out.print("::::::::::"+progressRect);
                jProgressBar1.paintImmediately(progressRect);
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Temporal", "root", "");
            Statement stmt1 = con.createStatement();
            stmt1.executeUpdate("truncate table dataset");
            stmt1.executeUpdate("truncate table preprocess");
            stmt1.executeUpdate("truncate table detail");
            BufferedReader br1 = new BufferedReader(new FileReader(new File(ss)));
            String str1;
            Statement stmt3 = con.createStatement();
//            stmt3.executeUpdate("TRUNCATE TABLE `dataset`");
            Statement stmt = con.createStatement();
            while ((str1 = br1.readLine()) != null) {
                System.out.println(str1);
                StringTokenizer st1 = new StringTokenizer(str1, ",");
                while (st1.hasMoreTokens()) {
                    String s1 = st1.nextToken();
                    String s2 = st1.nextToken();
                    String s3 = st1.nextToken();
                    String s4 = st1.nextToken();
                    String s5 = st1.nextToken();
                    stmt.executeUpdate("INSERT INTO  `Temporal`.`dataset`  (`AID`, `Query`, `QueryTime`, `ItemRank`, `ClickURL`) VALUES ('" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "')");
                    stmt.executeUpdate("INSERT INTO  `Temporal`.`preprocess`  (`AID`, `Query`, `QueryTime`, `ItemRank`, `ClickURL`) VALUES ('" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "')");
                    stmt.executeUpdate("INSERT INTO  `Temporal`.`detail`  (`AID`,`QueryTime`, `ItemRank`) VALUES ('" + s1 + "','" + s3 + "', '" + s4 + "')");
                }
            }
            JOptionPane.showMessageDialog(null, "Datum are Loaded into Database");
        } catch (Exception e) {
            System.err.println(e);

        }





    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        new Preprocessing().setVisible(true);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            
            res = state.executeQuery("SELECT count(*) FROM `dataset` ");
            while (res.next()) {
                int co1 = res.getInt(1);
                jLabel5.setText(Integer.toString(co1));
               
           // res1 = state.executeQuery("SELECT count(*) FROM `preprocess` ");
            //while (res1.next()) {
                //int co = res1.getInt(1);
               // jLabel2.setText(Integer.toString(co));
            //}
           // jLabel3.setText(" ClickUrl Type Dataset");
//            jLabel5.setText(" 332");
            }
            jLabel9.setText(" 5");
        } catch (Exception e) {
        }



    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new load().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
