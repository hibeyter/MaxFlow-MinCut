/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package havuzproblemi;

import java.awt.Button;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.DefaultView;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author beyter
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Graph graph;
    Viewer viewer;
    DefaultView view;
    String allKeys = "-ABCDEFGHIJKLMNOPRSTUVYZ";
    MaxFlow maxFlow;

    public NewJFrame() {
        initComponents();
        graph = new MultiGraph("my beautiful graph");
        graph.setStrict(false);
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        view = (DefaultView) viewer.addDefaultView(false);
        view.setBounds(0, 0, 550, 450);
        panelGraph.add(view);
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addEdgeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        spinnerNodeSize = new javax.swing.JSpinner();
        spinnerCapacity = new javax.swing.JSpinner();
        combobboxParent = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ComboboxChild = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        sizeOkeyBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panelGraph = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        spinnerEdgeSize = new javax.swing.JSpinner();
        runMaxFlowBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 500));
        setPreferredSize(new java.awt.Dimension(775, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addEdgeBtn.setText("Add Edge");
        addEdgeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEdgeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addEdgeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, 38));

        jLabel1.setText("Node Size=>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        spinnerNodeSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerNodeSizeStateChanged(evt);
            }
        });
        getContentPane().add(spinnerNodeSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 50, 30));
        getContentPane().add(spinnerCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 60, 30));
        getContentPane().add(combobboxParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 89, -1));

        jLabel3.setText("Parent");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        getContentPane().add(ComboboxChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 89, -1));

        jLabel4.setText("Child");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        sizeOkeyBtn.setText("Size Okey?");
        sizeOkeyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeOkeyBtnActionPerformed(evt);
            }
        });
        getContentPane().add(sizeOkeyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 100, 30));

        jLabel5.setText("Capacity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        panelGraph.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout panelGraphLayout = new javax.swing.GroupLayout(panelGraph);
        panelGraph.setLayout(panelGraphLayout);
        panelGraphLayout.setHorizontalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        panelGraphLayout.setVerticalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(panelGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 11, 550, 430));

        jLabel2.setText("Edge Size=>");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        spinnerEdgeSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerEdgeSizeStateChanged(evt);
            }
        });
        getContentPane().add(spinnerEdgeSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 50, 30));

        runMaxFlowBtn1.setText("Run Max Flow");
        runMaxFlowBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMaxFlowBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(runMaxFlowBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, 38));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addEdgeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEdgeBtnActionPerformed
        String edgeName = combobboxParent.getSelectedItem().toString() + ComboboxChild.getSelectedItem().toString();
        graph.addEdge(edgeName, edgeName.charAt(0) + "", edgeName.charAt(1) + "")
                .addAttribute("label", "0/" + spinnerCapacity.getValue());
       /* maxFlow.addEdge(combobboxParent.getSelectedIndex(), ComboboxChild.getSelectedIndex(),
                Integer.valueOf(spinnerCapacity.getValue().toString()));*/
        
    }//GEN-LAST:event_addEdgeBtnActionPerformed

    private void sizeOkeyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeOkeyBtnActionPerformed
        maxFlow = new MaxFlow(Integer.valueOf(spinnerNodeSize.getValue().toString()),
                Integer.valueOf(spinnerEdgeSize.getValue().toString()));
    }//GEN-LAST:event_sizeOkeyBtnActionPerformed

    private void spinnerNodeSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerNodeSizeStateChanged
        
        int size = Integer.valueOf(spinnerNodeSize.getValue().toString());
        graph.clear();
        graph.addAttribute("ui.stylesheet", "node { text-style:bold; text-size :25px;} "
                + "edge {text-style:bold; text-size :25px; }");
        for (int i = 1; i <= size; i++) {
            graph.addNode("" + allKeys.charAt(i)).addAttribute("label", "" + allKeys.charAt(i));
        }
        combobboxParent.removeAllItems();
        ComboboxChild.removeAllItems();;
        for (int i = 1; i <= size; i++) {
            combobboxParent.addItem(String.valueOf(allKeys.charAt(i) + ""));
        }
        for (int i = 1; i <= size; i++) {
            ComboboxChild.addItem(String.valueOf(allKeys.charAt(i) + ""));
        }
    }//GEN-LAST:event_spinnerNodeSizeStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void spinnerEdgeSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerEdgeSizeStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spinnerEdgeSizeStateChanged

    private void runMaxFlowBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMaxFlowBtn1ActionPerformed
        graph.getEdge("AB").addAttribute("ui.style", "fill-color: rgb(0,100,255);");
        graph.getEdge("AB").addAttribute("label", "bey");
        repaint();
       
    }//GEN-LAST:event_runMaxFlowBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboboxChild;
    private javax.swing.JButton addEdgeBtn;
    private javax.swing.JComboBox<String> combobboxParent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelGraph;
    private javax.swing.JButton runMaxFlowBtn1;
    private javax.swing.JButton sizeOkeyBtn;
    private javax.swing.JSpinner spinnerCapacity;
    private javax.swing.JSpinner spinnerEdgeSize;
    private javax.swing.JSpinner spinnerNodeSize;
    // End of variables declaration//GEN-END:variables
}
