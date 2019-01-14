
package AnsweringPattern;

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
import javax.swing.table.DefaultTableModel;

public class NormalSql extends javax.swing.JFrame {

    Connection con;
    Statement state;
    ResultSet res;
    String s2[] = new String[1000];
    public static int row = 0, colu = 0;
    public static String N;
    int i1;
    int ii;
    String content;
    public static String val, val1;
    private String path;
    private boolean append_to_file = false;
    public static String[] p = new String[382];
    public static String a, b, c;
    public static long stime, etime, ttime;
    public static float extime;
    public static float ld1, ld2, ld3, ld4, ld5, ld6, ld7, tld, util, util1;

    public NormalSql() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SQLOpeartions");
        setMinimumSize(new java.awt.Dimension(997, 521));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Normal SQL Operations");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 0, 340, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SQLOperations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel2.setLayout(null);

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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 40, 340, 200);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 100, 410, 270);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ResourceUtilizations and Time Taken", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setLayout(null);

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel4.add(jTextField2);
        jTextField2.setBounds(230, 60, 130, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("CPULoad");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(110, 70, 70, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("ProcessingSpeed");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(100, 130, 110, 20);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel4.add(jTextField3);
        jTextField3.setBounds(230, 130, 130, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("TimeTaken");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(110, 190, 80, 20);

        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel4.add(jTextField4);
        jTextField4.setBounds(230, 190, 130, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(470, 100, 440, 270);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(480, 40, 100, 33);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(230, 40, 230, 30);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(610, 40, 110, 33);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 60, 960, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        stime = System.currentTimeMillis();
        try {
            jTextField1.setText(Similarity.nn);
            String s;
            N = jTextField1.getText();
            System.out.println("Name=" + N);
            row = 0;
            Vector col = new Vector();
            Vector data = new Vector();
            res = state.executeQuery("Select AID,Query,QueryTime from preprocess  where Query LIKE '%" + N + "%'");

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
                    jTextField2.setText(val);
                    ld1 = Float.parseFloat(jTextField2.getText());
                    util = ld1 / 1000000000;

                }
                if (method.getName().equals("getProcessCpuTime")) {
                    val1 = value.toString();
                    jTextField3.setText(val1);
                    ld2 = Float.parseFloat(jTextField3.getText());
                    util1 = ld2 / 1000000000;
                }

            }
        }
        etime = System.currentTimeMillis();
        extime = etime - stime;
        jTextField4.setText(Float.toString(extime));
        System.out.println("execution time for joining is" + extime);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            DateFunctions df = new DateFunctions();
            df.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(NormalSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NormalSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NormalSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NormalSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalSql().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
