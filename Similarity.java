package AnsweringPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Similarity extends javax.swing.JFrame {

    Connection con;
    Statement state;
    ResultSet res, res1;
    String word;
    double result1, result2;
    int ii = 0;
    private double init[][];
    private double result[][];
    private int n;
    private int m;
    String strLine = null;
    public static String nn;
    public static int retrw, relew, totw;
    public static float pre, prec, rec, reca,preci,recal;

    public Similarity() {
        initComponents();
        try {
            
            String url = "jdbc:mysql://localhost:3306/";
            String db = "Temporal";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, "root", "");
            state = con.createStatement();
            jTextField1.setText(searching.N);
//            jTextField1.setText(Home.FP);
//            System.out.println("connected successfully");



        } catch (Exception e) {
            System.out.println("Excep1:" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Similarity Calculation");
        setMinimumSize(new java.awt.Dimension(911, 552));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "SimilarityFindingBetweenWords", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14)))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Similarity Calculation Using String Matching");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 30, 540, 30);

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(60, 80, 540, 240);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("StringMatching");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(370, 30, 130, 30);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(160, 30, 180, 30);

        jTabbedPane1.addTab("KeywordMatch", jPanel2);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setLayout(null);

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
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(50, 50, 600, 230);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("ExtractMostRelevant");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(260, 300, 170, 30);

        jTabbedPane1.addTab("HighSimilarity", jPanel3);

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precision and Recall Estimation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel5.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("WholeDataCount");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 50, 120, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("RetrievedItems");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(10, 120, 100, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("MostRelevantItems");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 200, 140, 17);

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(jTextField2);
        jTextField2.setBounds(150, 50, 90, 30);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(jTextField3);
        jTextField3.setBounds(150, 120, 90, 30);

        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(jTextField4);
        jTextField4.setBounds(150, 190, 90, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Precision");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(350, 80, 80, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Recall");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(350, 150, 70, 20);

        jTextField5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(jTextField5);
        jTextField5.setBounds(450, 70, 100, 30);

        jTextField6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(jTextField6);
        jTextField6.setBounds(450, 150, 100, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator1);
        jSeparator1.setBounds(290, 30, 20, 220);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(480, 210, 80, 30);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Predict");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);
        jButton4.setBounds(340, 210, 100, 30);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(30, 30, 640, 270);

        jTabbedPane1.addTab("SimilarityCounts", jPanel4);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(70, 80, 700, 380);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 30, 860, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NormalSql ns = new NormalSql();
        ns.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String n;
        String[] m = null;
        try {
            
            nn = jTextField1.getText();
            System.out.println("word2 = " + nn);

            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("./Similarity.txt"));
            {
                String line = reader.readLine();
                while (line != null) {
                    ii++;
                    System.out.println("Number of the line " + ii);
                    StringTokenizer tokens = new StringTokenizer(line, " ");
                    while (tokens.hasMoreTokens()) {

                        word = tokens.nextToken();
                        System.out.println("word1 = " + word);
                        Similarity an = new Similarity();
                        result1 = an.calculateSimilarity(word, nn);
                        jTextArea1.append(word + " similarity value is " + result1 + " in line " + ii + '\n' + '\n');
//result2 = an.calculateSimilarity("art","artwork"); 


//   {
                        System.out.println("line = " + line);
                        state.executeUpdate("INSERT INTO  `Temporal`.`similarity` (`Query`,`value`) VALUES ('" + line + "','" + result1 + "');");
//   }

                    }


                    line = reader.readLine();
                }
                

            }
        } catch (Exception ex) {
            System.out.println("Excep1 in button 1:" + ex.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            JOptionPane.showMessageDialog(null, "successfully calculated high similarity words ");
            Vector col = new Vector();
            Vector data = new Vector();
//            System.out.println("Connected to the database");
            res = state.executeQuery("SELECT distinct(Query) FROM `similarity` WHERE `value`='0.0'");
            ResultSetMetaData md = res.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                col.addElement(md.getColumnName(i));
            }
            while (res.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(res.getObject(i));
                }
                data.addElement(row);
            }
            DefaultTableModel model = new DefaultTableModel(data, col);
            jTable1.setModel(model);
        } catch (Exception e) {
            System.out.println("Excep in view:" + e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            res = state.executeQuery("SELECT count(*) FROM `preprocess`");
            while (res.next()) {
                int tw = res.getInt(1);
                jTextField2.setText(Integer.toString(tw));
                totw = Integer.parseInt(jTextField2.getText());
            }
            res = state.executeQuery("SELECT count(*) FROM `similarity`");
            while (res.next()) {
                int retw = res.getInt(1);
                jTextField3.setText(Integer.toString(retw));
                retrw = Integer.parseInt(jTextField3.getText());
            }
            res = state.executeQuery("SELECT count(distinct(query)) FROM `similarity` WHERE `value`='0.0' ");
            while (res.next()) {
                int relw = res.getInt(1);
                jTextField4.setText(Integer.toString(relw));

                relew = Integer.parseInt(jTextField4.getText());
            }
            pre = relew * retrw;
            prec = (float) relew / retrw*relew;
            System.out.println("precision is" + prec);
            jTextField5.setText(Float.toString(prec));
            preci=Float.parseFloat(jTextField5.getText());
            rec = (float) relew*retrw;
            reca=(float)totw/rec;
            System.out.println("recall is" + reca);
            jTextField6.setText(Float.toString(reca));
             recal=Float.parseFloat(jTextField6.getText());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    private void calculateASCIIDifference(String str1, String str2) {
        try {
            n = str1.length();
            m = str2.length();
            init = new double[n][m];
            for (int i = n - 1, i2 = 0; i >= 0; i--, i2++) {
                for (int j = 0; j < m; j++) {
                    init[i2][j] = Math.abs((int) str1.charAt(i) - (int) str2.charAt(j));
                }
            }
        } catch (Exception e) {
            System.out.println("calculateASCIIDifference exception: " + e.toString());
        }
    }

    public double[][] getASCIIDifference() {
        return init;
    }

    public void setASCIIDifference(double[][] a, int n, int m) {
        this.n = n;
        this.m = m;
        this.init = a;
    }

    // Calculate matrix by values from calculateASCIIDifference()
    public double calculateSimilarity(String str1, String str2) {

        calculateASCIIDifference(str1, str2);
        try {
            result = new double[n][m];
            double res, val1, val2, val3;

            //initialize first element
            result[n - 1][0] = init[n - 1][0];

            //initialize first column
            for (int i = n - 2; i >= 0; i--) {
                result[i][0] = result[i + 1][0] + init[i][0];
            }
            //initialize first row(from down)
            for (int j = 1; j < m; j++) {
                result[n - 1][j] = result[n - 1][j - 1] + init[n - 1][j];
            }
            //initialize others
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 1; j < m; j++) {
                    val1 = result[i][j - 1] + init[i][j];
                    val2 = result[i + 1][j] + init[i][j];
                    val3 = result[i + 1][j - 1] + (init[i][j] * 2);

                    //minimum of the 3 val's
                    res = val1 < val2 ? val1 : val2;
                    res = res < val3 ? res : val3;

                    result[i][j] = res;
                }
            }
            return getSimilarityValue();
        } catch (Exception e) {
            System.out.println("calculateSimilarity exception: " + e.toString());
        }
        return -1;
    }
    //getting result of Similarity

    public double getSimilarityValue() {
        //need to devide if m != n
        if (m != n) {
            return result[0][m - 1] / (m + n);
        } else {
            return result[0][m - 1];
        }
    }

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
            java.util.logging.Logger.getLogger(Similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Similarity().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
