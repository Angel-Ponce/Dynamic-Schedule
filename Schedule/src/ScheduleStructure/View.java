/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

/**
 *
 * @author angelponce
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        hoursPanel = new javax.swing.JPanel();
        daysPanel = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        crossPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        configMenu = new javax.swing.JMenu();
        reestartOption = new javax.swing.JMenuItem();
        separator2 = new javax.swing.JPopupMenu.Separator();
        themeOption = new javax.swing.JMenuItem();
        separator1 = new javax.swing.JPopupMenu.Separator();
        exitOption = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 540));
        setPreferredSize(new java.awt.Dimension(1200, 540));

        container.setForeground(new java.awt.Color(255, 255, 255));
        container.setPreferredSize(new java.awt.Dimension(1200, 440));
        container.setLayout(new java.awt.GridBagLayout());

        hoursPanel.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout hoursPanelLayout = new javax.swing.GroupLayout(hoursPanel);
        hoursPanel.setLayout(hoursPanelLayout);
        hoursPanelLayout.setHorizontalGroup(
            hoursPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        hoursPanelLayout.setVerticalGroup(
            hoursPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 400;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(hoursPanel, gridBagConstraints);

        daysPanel.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout daysPanelLayout = new javax.swing.GroupLayout(daysPanel);
        daysPanel.setLayout(daysPanelLayout);
        daysPanelLayout.setHorizontalGroup(
            daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        daysPanelLayout.setVerticalGroup(
            daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1000;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(daysPanel, gridBagConstraints);

        centerPanel.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1000;
        gridBagConstraints.ipady = 400;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(centerPanel, gridBagConstraints);

        crossPanel.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout crossPanelLayout = new javax.swing.GroupLayout(crossPanel);
        crossPanel.setLayout(crossPanelLayout);
        crossPanelLayout.setHorizontalGroup(
            crossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        crossPanelLayout.setVerticalGroup(
            crossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(crossPanel, gridBagConstraints);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        configMenu.setText("Configuración");

        reestartOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reestart.png"))); // NOI18N
        reestartOption.setText("Reiniciar horario");
        configMenu.add(reestartOption);
        configMenu.add(separator2);

        themeOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/theme.png"))); // NOI18N
        themeOption.setText("Tema");
        configMenu.add(themeOption);
        configMenu.add(separator1);

        exitOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        exitOption.setText("Salir");
        configMenu.add(exitOption);

        menuBar.add(configMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JMenu configMenu;
    private javax.swing.JPanel container;
    private javax.swing.JPanel crossPanel;
    private javax.swing.JPanel daysPanel;
    private javax.swing.JMenuItem exitOption;
    private javax.swing.JPanel hoursPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem reestartOption;
    private javax.swing.JPopupMenu.Separator separator1;
    private javax.swing.JPopupMenu.Separator separator2;
    private javax.swing.JMenuItem themeOption;
    // End of variables declaration//GEN-END:variables
}
