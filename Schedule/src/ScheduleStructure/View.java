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

        groupThemes = new javax.swing.ButtonGroup();
        groupFonts = new javax.swing.ButtonGroup();
        popupCharge = new javax.swing.JDialog();
        containerProgressBar = new javax.swing.JPanel();
        infoChargeLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        popupQuestion = new javax.swing.JDialog();
        containerQuestion = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        responseQuestion = new javax.swing.JTextField();
        acceptQuestion = new javax.swing.JButton();
        popupAddCourse = new javax.swing.JDialog();
        container1 = new javax.swing.JPanel();
        informationPanel = new javax.swing.JPanel();
        labelNameCourse = new javax.swing.JLabel();
        areaCourseName = new javax.swing.JTextField();
        labelUrlCourse = new javax.swing.JLabel();
        areaUrlCourse = new javax.swing.JTextField();
        btnChoseColor = new javax.swing.JButton();
        hoursPanel1 = new javax.swing.JPanel();
        daysPanel1 = new javax.swing.JPanel();
        mondayLabel1 = new javax.swing.JLabel();
        tuesdayLabel1 = new javax.swing.JLabel();
        wednesdayLabel1 = new javax.swing.JLabel();
        thursdayLabel1 = new javax.swing.JLabel();
        fridayLabel1 = new javax.swing.JLabel();
        centerPanel1 = new javax.swing.JPanel();
        crossPanel1 = new javax.swing.JPanel();
        hourLabel1 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        hoursPanel = new javax.swing.JPanel();
        daysPanel = new javax.swing.JPanel();
        mondayLabel = new javax.swing.JLabel();
        tuesdayLabel = new javax.swing.JLabel();
        wednesdayLabel = new javax.swing.JLabel();
        thursdayLabel = new javax.swing.JLabel();
        fridayLabel = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        crossPanel = new javax.swing.JPanel();
        hourLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        configMenu = new javax.swing.JMenu();
        addRowOption = new javax.swing.JMenuItem();
        addCourseOption = new javax.swing.JMenuItem();
        createSchedule = new javax.swing.JMenuItem();
        reestartOption = new javax.swing.JMenuItem();
        separator3 = new javax.swing.JPopupMenu.Separator();
        themeOptions = new javax.swing.JMenu();
        lightTheme = new javax.swing.JRadioButtonMenuItem();
        lightBlueTheme = new javax.swing.JRadioButtonMenuItem();
        blueGrayTheme = new javax.swing.JRadioButtonMenuItem();
        grayTheme = new javax.swing.JRadioButtonMenuItem();
        orangeTheme = new javax.swing.JRadioButtonMenuItem();
        pinkTheme = new javax.swing.JRadioButtonMenuItem();
        purpleTheme = new javax.swing.JRadioButtonMenuItem();
        darkTheme = new javax.swing.JRadioButtonMenuItem();
        fontOptions = new javax.swing.JMenu();
        verdanaFontOption = new javax.swing.JRadioButtonMenuItem();
        timesNewRomanFontOption = new javax.swing.JRadioButtonMenuItem();
        blackHighlightFontOption = new javax.swing.JRadioButtonMenuItem();
        lettersFontOption = new javax.swing.JRadioButtonMenuItem();
        josephSophiaFontOption = new javax.swing.JRadioButtonMenuItem();
        gridOption = new javax.swing.JRadioButtonMenuItem();
        separator6 = new javax.swing.JPopupMenu.Separator();
        exitOption = new javax.swing.JMenuItem();

        popupCharge.setMinimumSize(new java.awt.Dimension(400, 50));
        popupCharge.setUndecorated(true);
        popupCharge.setSize(new java.awt.Dimension(400, 50));

        containerProgressBar.setBackground(new java.awt.Color(51, 51, 51));
        containerProgressBar.setLayout(new java.awt.GridLayout(2, 1));

        infoChargeLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoChargeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoChargeLabel.setText("Leyendo los archivos de configuración...");
        containerProgressBar.add(infoChargeLabel);

        progressBar.setBackground(new java.awt.Color(51, 51, 51));
        progressBar.setForeground(new java.awt.Color(255, 255, 255));
        containerProgressBar.add(progressBar);

        popupCharge.getContentPane().add(containerProgressBar, java.awt.BorderLayout.CENTER);

        popupQuestion.setMinimumSize(new java.awt.Dimension(400, 150));
        popupQuestion.setModal(true);
        popupQuestion.setSize(new java.awt.Dimension(400, 150));

        containerQuestion.setLayout(new java.awt.GridLayout(3, 1));

        questionLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionLabel.setText("¿Cuántas horas (filas) tendrá su horario?");
        containerQuestion.add(questionLabel);

        responseQuestion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        responseQuestion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        containerQuestion.add(responseQuestion);

        acceptQuestion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        acceptQuestion.setText("Aceptar");
        containerQuestion.add(acceptQuestion);

        popupQuestion.getContentPane().add(containerQuestion, java.awt.BorderLayout.CENTER);

        popupAddCourse.setMinimumSize(new java.awt.Dimension(800, 470));
        popupAddCourse.setModal(true);
        popupAddCourse.setPreferredSize(new java.awt.Dimension(800, 470));

        container1.setForeground(new java.awt.Color(255, 255, 255));
        container1.setLayout(new java.awt.GridBagLayout());

        informationPanel.setMinimumSize(new java.awt.Dimension(800, 35));
        informationPanel.setPreferredSize(new java.awt.Dimension(800, 35));

        labelNameCourse.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        labelNameCourse.setText("Nombre del curso: ");
        informationPanel.add(labelNameCourse);

        areaCourseName.setPreferredSize(new java.awt.Dimension(225, 24));
        informationPanel.add(areaCourseName);

        labelUrlCourse.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        labelUrlCourse.setText("Enlace de conexión: ");
        informationPanel.add(labelUrlCourse);

        areaUrlCourse.setPreferredSize(new java.awt.Dimension(225, 24));
        informationPanel.add(areaUrlCourse);

        btnChoseColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/color.png"))); // NOI18N
        btnChoseColor.setMaximumSize(new java.awt.Dimension(24, 24));
        btnChoseColor.setMinimumSize(new java.awt.Dimension(24, 24));
        btnChoseColor.setPreferredSize(new java.awt.Dimension(24, 24));
        btnChoseColor.setSize(new java.awt.Dimension(24, 24));
        informationPanel.add(btnChoseColor);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        container1.add(informationPanel, gridBagConstraints);

        hoursPanel1.setMinimumSize(new java.awt.Dimension(200, 400));
        hoursPanel1.setPreferredSize(new java.awt.Dimension(200, 400));
        hoursPanel1.setLayout(new java.awt.GridLayout(1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container1.add(hoursPanel1, gridBagConstraints);

        daysPanel1.setMinimumSize(new java.awt.Dimension(1000, 40));
        daysPanel1.setPreferredSize(new java.awt.Dimension(1000, 40));
        daysPanel1.setLayout(new java.awt.GridLayout(1, 5));

        mondayLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        mondayLabel1.setForeground(new java.awt.Color(0, 0, 0));
        mondayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mondayLabel1.setText("Lunes");
        mondayLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        daysPanel1.add(mondayLabel1);

        tuesdayLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        tuesdayLabel1.setForeground(new java.awt.Color(0, 0, 0));
        tuesdayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tuesdayLabel1.setText("Martes");
        tuesdayLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        daysPanel1.add(tuesdayLabel1);

        wednesdayLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        wednesdayLabel1.setForeground(new java.awt.Color(0, 0, 0));
        wednesdayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wednesdayLabel1.setText("Miércoles");
        wednesdayLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        daysPanel1.add(wednesdayLabel1);

        thursdayLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        thursdayLabel1.setForeground(new java.awt.Color(0, 0, 0));
        thursdayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thursdayLabel1.setText("Jueves");
        thursdayLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        daysPanel1.add(thursdayLabel1);

        fridayLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        fridayLabel1.setForeground(new java.awt.Color(0, 0, 0));
        fridayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fridayLabel1.setText("Viernes");
        fridayLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        daysPanel1.add(fridayLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        container1.add(daysPanel1, gridBagConstraints);

        centerPanel1.setMinimumSize(new java.awt.Dimension(1000, 400));
        centerPanel1.setPreferredSize(new java.awt.Dimension(1000, 400));
        centerPanel1.setLayout(new java.awt.GridLayout(0, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container1.add(centerPanel1, gridBagConstraints);

        crossPanel1.setPreferredSize(new java.awt.Dimension(200, 40));
        crossPanel1.setLayout(new java.awt.GridLayout(1, 0));

        hourLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        hourLabel1.setForeground(new java.awt.Color(0, 0, 0));
        hourLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourLabel1.setText("HORA");
        hourLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        crossPanel1.add(hourLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        container1.add(crossPanel1, gridBagConstraints);

        popupAddCourse.getContentPane().add(container1, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Horario");
        setMinimumSize(new java.awt.Dimension(1200, 540));

        container.setForeground(new java.awt.Color(255, 255, 255));
        container.setPreferredSize(new java.awt.Dimension(1200, 440));
        container.setLayout(new java.awt.GridBagLayout());

        hoursPanel.setBackground(new java.awt.Color(204, 255, 204));
        hoursPanel.setMinimumSize(new java.awt.Dimension(200, 400));
        hoursPanel.setPreferredSize(new java.awt.Dimension(200, 400));
        hoursPanel.setLayout(new java.awt.GridLayout(1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(hoursPanel, gridBagConstraints);

        daysPanel.setBackground(new java.awt.Color(255, 204, 204));
        daysPanel.setMinimumSize(new java.awt.Dimension(1000, 40));
        daysPanel.setPreferredSize(new java.awt.Dimension(1000, 40));
        daysPanel.setLayout(new java.awt.GridLayout(1, 5));

        mondayLabel.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        mondayLabel.setForeground(new java.awt.Color(0, 0, 0));
        mondayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mondayLabel.setText("Lunes");
        daysPanel.add(mondayLabel);

        tuesdayLabel.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        tuesdayLabel.setForeground(new java.awt.Color(0, 0, 0));
        tuesdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tuesdayLabel.setText("Martes");
        daysPanel.add(tuesdayLabel);

        wednesdayLabel.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        wednesdayLabel.setForeground(new java.awt.Color(0, 0, 0));
        wednesdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wednesdayLabel.setText("Miércoles");
        daysPanel.add(wednesdayLabel);

        thursdayLabel.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        thursdayLabel.setForeground(new java.awt.Color(0, 0, 0));
        thursdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thursdayLabel.setText("Jueves");
        daysPanel.add(thursdayLabel);

        fridayLabel.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        fridayLabel.setForeground(new java.awt.Color(0, 0, 0));
        fridayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fridayLabel.setText("Viernes");
        daysPanel.add(fridayLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        container.add(daysPanel, gridBagConstraints);

        centerPanel.setBackground(new java.awt.Color(153, 153, 255));
        centerPanel.setMinimumSize(new java.awt.Dimension(1000, 400));
        centerPanel.setPreferredSize(new java.awt.Dimension(1000, 400));
        centerPanel.setLayout(new java.awt.GridLayout(0, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(centerPanel, gridBagConstraints);

        crossPanel.setBackground(new java.awt.Color(204, 255, 255));
        crossPanel.setPreferredSize(new java.awt.Dimension(200, 40));
        crossPanel.setLayout(new java.awt.GridLayout(1, 0));

        hourLabel.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        hourLabel.setForeground(new java.awt.Color(0, 0, 0));
        hourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourLabel.setText("HORA");
        crossPanel.add(hourLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        container.add(crossPanel, gridBagConstraints);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        configMenu.setForeground(new java.awt.Color(0, 0, 0));
        configMenu.setText("Configuración");
        configMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addRowOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        addRowOption.setText("Agregar fila");
        configMenu.add(addRowOption);

        addCourseOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bloc.png"))); // NOI18N
        addCourseOption.setText("Agregar curso");
        configMenu.add(addCourseOption);

        createSchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/create.png"))); // NOI18N
        createSchedule.setText("Crear horario");
        configMenu.add(createSchedule);

        reestartOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reestart.png"))); // NOI18N
        reestartOption.setText("Reiniciar horario");
        configMenu.add(reestartOption);
        configMenu.add(separator3);

        themeOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/theme.png"))); // NOI18N
        themeOptions.setText("Cambiar tema");

        groupThemes.add(lightTheme);
        lightTheme.setSelected(true);
        lightTheme.setText("Claro");
        lightTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/light.png"))); // NOI18N
        themeOptions.add(lightTheme);

        groupThemes.add(lightBlueTheme);
        lightBlueTheme.setText("Azul-Claro");
        lightBlueTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/light-blue.png"))); // NOI18N
        lightBlueTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightBlueThemeActionPerformed(evt);
            }
        });
        themeOptions.add(lightBlueTheme);

        groupThemes.add(blueGrayTheme);
        blueGrayTheme.setText("Gris-Azulado");
        blueGrayTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/blue-gray.png"))); // NOI18N
        themeOptions.add(blueGrayTheme);

        groupThemes.add(grayTheme);
        grayTheme.setText("Gris");
        grayTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gray.png"))); // NOI18N
        themeOptions.add(grayTheme);

        groupThemes.add(orangeTheme);
        orangeTheme.setText("Naranja");
        orangeTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orange.png"))); // NOI18N
        themeOptions.add(orangeTheme);

        groupThemes.add(pinkTheme);
        pinkTheme.setText("Rosa");
        pinkTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pink.png"))); // NOI18N
        pinkTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinkThemeActionPerformed(evt);
            }
        });
        themeOptions.add(pinkTheme);

        groupThemes.add(purpleTheme);
        purpleTheme.setText("Violeta");
        purpleTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/purple.png"))); // NOI18N
        themeOptions.add(purpleTheme);

        groupThemes.add(darkTheme);
        darkTheme.setText("Oscuro");
        darkTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark.png"))); // NOI18N
        darkTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkThemeActionPerformed(evt);
            }
        });
        themeOptions.add(darkTheme);

        configMenu.add(themeOptions);

        fontOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/font.png"))); // NOI18N
        fontOptions.setText("Cambiar fuente");

        groupFonts.add(verdanaFontOption);
        verdanaFontOption.setText("Verdana");
        verdanaFontOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/f.png"))); // NOI18N
        verdanaFontOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verdanaFontOptionActionPerformed(evt);
            }
        });
        fontOptions.add(verdanaFontOption);

        groupFonts.add(timesNewRomanFontOption);
        timesNewRomanFontOption.setText("Times New Roman");
        timesNewRomanFontOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/f.png"))); // NOI18N
        timesNewRomanFontOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timesNewRomanFontOptionActionPerformed(evt);
            }
        });
        fontOptions.add(timesNewRomanFontOption);

        groupFonts.add(blackHighlightFontOption);
        blackHighlightFontOption.setText("Black Highlight");
        blackHighlightFontOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/f.png"))); // NOI18N
        blackHighlightFontOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackHighlightFontOptionActionPerformed(evt);
            }
        });
        fontOptions.add(blackHighlightFontOption);

        groupFonts.add(lettersFontOption);
        lettersFontOption.setText("Letters");
        lettersFontOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/f.png"))); // NOI18N
        lettersFontOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lettersFontOptionActionPerformed(evt);
            }
        });
        fontOptions.add(lettersFontOption);

        groupFonts.add(josephSophiaFontOption);
        josephSophiaFontOption.setText("JosephSophia");
        josephSophiaFontOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/f.png"))); // NOI18N
        josephSophiaFontOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                josephSophiaFontOptionActionPerformed(evt);
            }
        });
        fontOptions.add(josephSophiaFontOption);

        configMenu.add(fontOptions);

        gridOption.setText("Ver celdas");
        gridOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grid.png"))); // NOI18N
        gridOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridOptionActionPerformed(evt);
            }
        });
        configMenu.add(gridOption);
        configMenu.add(separator6);

        exitOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        exitOption.setText("Salir");
        configMenu.add(exitOption);

        menuBar.add(configMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pinkThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinkThemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pinkThemeActionPerformed

    private void darkThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkThemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_darkThemeActionPerformed

    private void lightBlueThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightBlueThemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lightBlueThemeActionPerformed

    private void verdanaFontOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verdanaFontOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verdanaFontOptionActionPerformed

    private void timesNewRomanFontOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timesNewRomanFontOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timesNewRomanFontOptionActionPerformed

    private void blackHighlightFontOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackHighlightFontOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blackHighlightFontOptionActionPerformed

    private void lettersFontOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lettersFontOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lettersFontOptionActionPerformed

    private void josephSophiaFontOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_josephSophiaFontOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_josephSophiaFontOptionActionPerformed

    private void gridOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gridOptionActionPerformed

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
    public javax.swing.JButton acceptQuestion;
    public javax.swing.JMenuItem addCourseOption;
    public javax.swing.JMenuItem addRowOption;
    public javax.swing.JTextField areaCourseName;
    public javax.swing.JTextField areaUrlCourse;
    public javax.swing.JRadioButtonMenuItem blackHighlightFontOption;
    public javax.swing.JRadioButtonMenuItem blueGrayTheme;
    public javax.swing.JButton btnChoseColor;
    public javax.swing.JPanel centerPanel;
    public javax.swing.JPanel centerPanel1;
    public javax.swing.JMenu configMenu;
    public javax.swing.JPanel container;
    public javax.swing.JPanel container1;
    public javax.swing.JPanel containerProgressBar;
    public javax.swing.JPanel containerQuestion;
    public javax.swing.JMenuItem createSchedule;
    public javax.swing.JPanel crossPanel;
    public javax.swing.JPanel crossPanel1;
    public javax.swing.JRadioButtonMenuItem darkTheme;
    public javax.swing.JPanel daysPanel;
    public javax.swing.JPanel daysPanel1;
    public javax.swing.JMenuItem exitOption;
    public javax.swing.JMenu fontOptions;
    public javax.swing.JLabel fridayLabel;
    public javax.swing.JLabel fridayLabel1;
    public javax.swing.JRadioButtonMenuItem grayTheme;
    public javax.swing.JRadioButtonMenuItem gridOption;
    public javax.swing.ButtonGroup groupFonts;
    public javax.swing.ButtonGroup groupThemes;
    public javax.swing.JLabel hourLabel;
    public javax.swing.JLabel hourLabel1;
    public javax.swing.JPanel hoursPanel;
    public javax.swing.JPanel hoursPanel1;
    public javax.swing.JLabel infoChargeLabel;
    public javax.swing.JPanel informationPanel;
    public javax.swing.JRadioButtonMenuItem josephSophiaFontOption;
    public javax.swing.JLabel labelNameCourse;
    public javax.swing.JLabel labelUrlCourse;
    public javax.swing.JRadioButtonMenuItem lettersFontOption;
    public javax.swing.JRadioButtonMenuItem lightBlueTheme;
    public javax.swing.JRadioButtonMenuItem lightTheme;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JLabel mondayLabel;
    public javax.swing.JLabel mondayLabel1;
    public javax.swing.JRadioButtonMenuItem orangeTheme;
    public javax.swing.JRadioButtonMenuItem pinkTheme;
    public javax.swing.JDialog popupAddCourse;
    public javax.swing.JDialog popupCharge;
    public javax.swing.JDialog popupQuestion;
    public javax.swing.JProgressBar progressBar;
    public javax.swing.JRadioButtonMenuItem purpleTheme;
    public javax.swing.JLabel questionLabel;
    public javax.swing.JMenuItem reestartOption;
    public javax.swing.JTextField responseQuestion;
    public javax.swing.JPopupMenu.Separator separator3;
    public javax.swing.JPopupMenu.Separator separator6;
    public javax.swing.JMenu themeOptions;
    public javax.swing.JLabel thursdayLabel;
    public javax.swing.JLabel thursdayLabel1;
    public javax.swing.JRadioButtonMenuItem timesNewRomanFontOption;
    public javax.swing.JLabel tuesdayLabel;
    public javax.swing.JLabel tuesdayLabel1;
    public javax.swing.JRadioButtonMenuItem verdanaFontOption;
    public javax.swing.JLabel wednesdayLabel;
    public javax.swing.JLabel wednesdayLabel1;
    // End of variables declaration//GEN-END:variables
}
