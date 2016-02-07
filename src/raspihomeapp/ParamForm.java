/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raspihomeapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import toolbox.RSCommand;

/**
 *
 * @author rossmann
 */
public class ParamForm extends javax.swing.JFrame {
    private Timer timer;
     private Graphics Gg;
     private int xM = 220, yM = 220;
    /**
     * Creates new form ParamForm
     */
    public ParamForm() {
        initComponents();
        timer = new Timer(60000, taskPerformer);
        timer.setInitialDelay(0);
        timer.start();
        Plotxy();
        
   
    }

        ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            timeractionPerformed(evt);
        }
    };
        
    public void timeractionPerformed(final ActionEvent e) {
       
        //jPanel2.paint(Gg);
        drawClock(Gg);
       // String s = RSCommand.GetData(1);//.send_data_Slave("CMD=GETDATA&ADR=1", "192.168.0.28");
        //jTextField1.setText(s);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 480));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jButton3.setBackground(new java.awt.Color(0, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 255, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/undo.png"))); // NOI18N
        jButton3.setText("zurück");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setIconTextGap(10);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(800, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

   

     private void drawClock(final Graphics g) {
     
         g.setColor(Color.white);
      g.drawString("Leistung in W", 1, 8);
      g.drawString("Uhrzeit", 750, 320);
      g.drawLine(20, 320, 20, 15); // Y -Achse
      g.drawLine(10, 310, 790, 310); // X-Achse
      
      
     }
     
     public void Plotxy() {
        XYSeries series1 = new XYSeries("Punkte1");
        series1.add(5, 0);
        series1.add(6, 6);
        series1.add(7, 11);
        series1.add(8, 22);
        series1.add(10, 55);

        XYSeries series2 = new XYSeries("Punkte2");
        series2.add(5, 2);
        series2.add(6, 3);
        series2.add(7, 4);

// Hinzufuegen von series1 und series2 zu der Datenmenge dataset
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(series1);
        dataset2.addSeries(series2);

        XYSplineRenderer dot = new XYSplineRenderer();

        NumberAxis xax = new NumberAxis("x");
        NumberAxis yax = new NumberAxis("y");
        //xax.setLabelPaint(Color.WHITE);

        DateAxis taxis = new DateAxis("t");
        taxis.setDateFormatOverride(new SimpleDateFormat("dd-MM"));

         
        
        XYPlot plot = new XYPlot(dataset2, taxis, yax, dot);

        //plot.setBackgroundPaint(Color.BLACK);
        //plot.setRangeGridlinePaint(Color.GRAY);
    
        
        JFreeChart chart2 = new JFreeChart(" Test ", plot);
        
        //chart2.setBackgroundPaint(Color.BLACK);
        
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        
        
        chartPanel2.setMouseZoomable(true, false);
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(chartPanel2, BorderLayout.CENTER);
        //setContentPane(chartPanel2);

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
