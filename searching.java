package AnsweringPattern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class searching extends javax.swing.JFrame {

    Connection con;
    Statement state;
    ResultSet res;
    String s2[] = new String[2000];
    public static int row = 0, colu = 0;
    public static String N;
    int i1;
    int ii;
    String content;
    public static String val, val1;
    private String path;
    private boolean append_to_file = false;
    public static String[] p = new String[382];
    public static String a, b, c, d, e;
    public static long stime, etime;
    public static float extime;

    public searching() {
        initComponents();
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "Temporal";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, "root", "");
            state = con.createStatement();
            System.out.println("connected successfully");
            state.executeUpdate("truncate table searchdetail");
            state.executeUpdate("truncate table Querylist");
            state.executeUpdate("truncate table List");
        } catch (Exception e) {
            System.out.println("Excep1:" + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Searching");
        setMinimumSize(new java.awt.Dimension(811, 658));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Result", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 50, 380, 270);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(460, 50, 240, 270);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 250, 720, 360);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QueryProcessing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(260, 50, 116, 30);
        jPanel4.add(jTextField1);
        jTextField1.setBounds(20, 50, 214, 32);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("RelevantItems");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(410, 50, 140, 30);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(580, 50, 90, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(40, 80, 740, 130);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("SearchingProcessingbyJoiningTwoTables");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 20, 590, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(40, 230, 740, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        stime = System.currentTimeMillis();
        try {
            String s;
            N = jTextField1.getText();
            System.out.println("Name=" + N);
            row = 0;
            Vector col = new Vector();
            Vector data = new Vector();
            res = state.executeQuery("Select d.AID,a.Query,d.QueryTime,a.ItemRank,a.ClickUrl from preprocess a, detail d where a.AID=d.AID and Query LIKE '%" + N + "%'");

            ResultSetMetaData md = res.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                col.addElement(md.getColumnName(i));
            }
            while (res.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(res.getObject(i));
                    a = res.getString(1);
                    b = res.getString(2);
                    c = res.getString(3);
                    d = res.getString(4);
                    e = res.getString(5);

                }
                data.addElement(row);
            }
            DefaultTableModel model = new DefaultTableModel(data, col);
            jTable1.setModel(model);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("get")
                    && Modifier.isPublic(method.getModifiers())) {
                Object value;
                try {
                    value = method.invoke(operatingSystemMXBean);
                    System.out.println("value is:" + value);

                } catch (Exception e) {
                    value = e;
                } // try
                System.out.println(method.getName() + " = " + value);
                if (method.getName().equals("getTotalPhysicalMemorySize")) {
                    val = value.toString();

                }
                if (method.getName().equals("getProcessCpuTime")) {
                    val1 = value.toString();

                }

            }
        }
        try {

            JOptionPane.showMessageDialog(null, "successfully Loaded ");

            for (i1 = 0;; i1++) {
                state.executeUpdate("INSERT INTO `Temporal`.`searchdetail` (`AID` , `Query` , `QueryTime` , `ItemRank` , `ClickURL`) VALUES ('" + jTable1.getValueAt(i1, 0) + "','" + jTable1.getValueAt(i1, 1) + "','" + jTable1.getValueAt(i1, 2) + "','" + jTable1.getValueAt(i1, 3) + "','" + jTable1.getValueAt(i1, 4) + "')");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        etime = System.currentTimeMillis();
        extime = etime - stime;
        System.out.println("execution time for joining is" + extime);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Similarity s = new Similarity();
            s.setVisible(true);
//           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            res = state.executeQuery("SELECT DISTINCT `Query` FROM `searchdetail`");
            int i = 0;
            while (res.next()) {
                p[i] = res.getString(1);
                //       System.out.println("age="+p[i].toString());
                i++;
            }
            for (i = 0; i < p.length; i++) {
                jTextArea1.append(p[i].toString() + "\n");
//                state.executeUpdate("INSERT INTO  `inferring`.`List` (`Query`) VALUES ('" + p[i].toString() + "');");
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        try {

            content = jTextArea1.getText();

            File file = new File("./Similarity.txt");

            
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searching().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
