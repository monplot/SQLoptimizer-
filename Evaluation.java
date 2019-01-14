package AnsweringPattern;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class Evaluation extends javax.swing.JFrame {

    public Evaluation() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EvaluationResults");
        setMinimumSize(new java.awt.Dimension(725, 510));
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evaluation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel2.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evaluation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Precision and Recall");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 60, 160, 30);

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setText("Time Efficiency");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(40, 110, 160, 30);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(220, 90, 250, 230);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 40, 630, 430);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Performnace Evaluation Results");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 0, 350, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.setValue(Similarity.preci, "Usingviews", "Precision");
            dataset.setValue(Similarity.recal, "Usingviews", "Recall");
            JFreeChart chart = ChartFactory.createBarChart3D("", "", "SemanticResults",
                    dataset, PlotOrientation.VERTICAL, true, true, false);
            chart.setBackgroundPaint(Color.WHITE);
            chart.getTitle().setPaint(Color.BLACK);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.red);
            ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
            frame1.setVisible(true);
            frame1.setSize(400, 350);
        } catch (Exception e) {
            System.out.println("Button4:" + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       try
       {
            try {

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
             
            dataset.setValue(searching.extime, "VIEWS", "");
            dataset.setValue(SubQuery.extime, "SQ", "");
            dataset.setValue(JoinUsingOO.extime, "OO", "");
            JFreeChart chart = ChartFactory.createBarChart3D("", "", "Time Taken",
                    dataset, PlotOrientation.VERTICAL, true, true, false);
            chart.setBackgroundPaint(Color.WHITE);
            chart.getTitle().setPaint(Color.BLACK);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.red);
            ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
            frame1.setVisible(true);
            frame1.setSize(400, 350);
        } catch (Exception e) {
            System.out.println("Button4:" + e.getMessage());
        }
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Evaluation().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
