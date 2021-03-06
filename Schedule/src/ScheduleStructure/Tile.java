package ScheduleStructure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angelponce
 */
public class Tile extends JLabel {

    public static final String HOUR = "h";
    public static final String COURSE = "c";
    private String colorChanged = "f";
    private TileListener tileListener;
    private Theme theme;
    private String type;
    private String courseName;
    private String oldCourseName;
    private String url;
    private String hour;
    private JPopupMenu popupMenuCourse;
    private JMenuItem changeName;
    private JMenuItem changeLink;
    private JMenuItem changeBackground;
    private JPopupMenu popupMenuHour;
    private JMenuItem changeHour;
    private JMenuItem changeBackground2;
    private JMenuItem quitColor;
    private JMenuItem quitColor2;
    public static Theme THEME = new Theme(new Model().getProperties().get(1));
    public static JDialog popupInformation;
    public static JPanel containerInformation;
    public static JLabel messageInformation;
    public static JTextField informationField;
    public static JPanel checkBoxContainer;
    public static JCheckBox checkBoxInformation;
    public static JButton aceptButton;
    public static Component componentClicked = null;
    public static boolean changeProperty = false;

    public Tile(String type, String courseName, String url, String hour, Color background, Theme theme) {
        initComponents();
        this.type = type;
        this.courseName = courseName;
        this.url = url;
        this.hour = hour;
        this.theme = theme;
        this.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setBackground(background);
        this.setVisible(true);
        events();
    }

    private void events() {
        JLabel label = this;
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

                if (e.isPopupTrigger()) {
                    switch (type) {
                        case Tile.COURSE:
                            popupMenuCourse.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            checkBoxInformation.setEnabled(true);
                            break;
                        case Tile.HOUR:
                            popupMenuHour.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            checkBoxInformation.setEnabled(false);
                            break;
                        default:
                            break;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    switch (type) {
                        case Tile.COURSE:
                            popupMenuCourse.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            checkBoxInformation.setEnabled(true);
                            break;
                        case Tile.HOUR:
                            popupMenuHour.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            checkBoxInformation.setEnabled(false);
                            break;
                        default:
                            break;
                    }
                }
                if (e.getClickCount() == 2 && !getType().equals(Tile.HOUR)) {
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar abrir el enlace de reunión, intenta verificar la información", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (URISyntaxException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar abrir el enlace de reunión, intenta verificar la información", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //Window information tile
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3, false));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (Controller.gridSelected) {
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                } else {
                    label.setBorder(null);
                }
            }
        });

        changeName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageInformation.setText("Ingrese el nuevo nombre:");
                informationField.setText(getCourseName());
                popupInformation.setVisible(true);
                String name = informationField.getText();
                if (name != null && changeProperty) {
                    JLabel label = (JLabel) componentClicked;
                    label.setText(name.trim());
                    setCourseName(name);
                    changeProperty = false;
                }
            }
        });

        changeLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageInformation.setText("Ingrese el nuevo enlace:");
                informationField.setText(getUrl());
                popupInformation.setVisible(true);
                String link = informationField.getText();
                if (link != null && changeProperty) {
                    setUrl(link);
                    changeProperty = false;
                    JOptionPane.showMessageDialog(null, "Se guardo el enlace correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        changeHour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageInformation.setText("Ingrese la nueva hora:");
                informationField.setText(getHour());
                popupInformation.setVisible(true);
                String newHour = informationField.getText();
                if (newHour != null && changeProperty) {
                    JLabel label = (JLabel) componentClicked;
                    label.setText(newHour.trim());
                    hour = newHour;
                    changeProperty = false;
                }
            }
        });

        changeBackground.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color background = JColorChooser.showDialog(null, "Escoja un color", Color.WHITE);
                if (background != null) {
                    JLabel label = (JLabel) componentClicked;
                    label.setBackground(background);
                    setColorChanged("v");
                }
            }
        });

        changeBackground2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color background = JColorChooser.showDialog(null, "Escoja un color", Color.WHITE);
                if (background != null) {
                    JLabel label = (JLabel) componentClicked;
                    label.setBackground(background);
                    setColorChanged("v", false);
                }
            }
        });

        quitColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label = (JLabel) componentClicked;
                label.setBackground(getTheme().coursesColor);
                label.setForeground(getTheme().fontColor);
                setColorChanged("f");
            }
        });

        quitColor2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label = (JLabel) componentClicked;
                label.setBackground(getTheme().hoursColor);
                label.setForeground(getTheme().fontColor2);
                setColorChanged("f", false);
            }
        });

        Tile.aceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeProperty = true;
                Tile.popupInformation.setVisible(false);
            }
        });

        Tile.informationField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    changeProperty = true;
                    Tile.popupInformation.setVisible(false);
                }
            }

        });
    }

    private void initComponents() {
        popupMenuCourse = new JPopupMenu();
        changeName = new JMenuItem();
        changeLink = new JMenuItem();
        changeBackground = new JMenuItem();
        popupMenuHour = new JPopupMenu();
        changeHour = new JMenuItem();
        changeBackground2 = new JMenuItem();
        quitColor = new JMenuItem();
        quitColor2 = new JMenuItem();

        changeName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        changeName.setText("Cambiar nombre");
        popupMenuCourse.add(changeName);

        changeLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png")));
        changeLink.setText("Cambiar enlace");

        popupMenuCourse.add(changeLink);

        changeBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/color.png")));
        changeBackground.setText("Cambiar color");
        popupMenuCourse.add(changeBackground);

        changeHour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png")));
        changeHour.setText("Cambiar hora");
        changeHour.setToolTipText("");
        popupMenuHour.add(changeHour);

        changeBackground2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/color.png")));
        changeBackground2.setText("Cambiar color");
        popupMenuHour.add(changeBackground2);

        quitColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/noColor.png")));
        quitColor.setText("Quitar color");
        popupMenuCourse.add(quitColor);

        quitColor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/noColor.png")));
        quitColor2.setText("Quitar color");
        popupMenuHour.add(quitColor2);

        popupInformation = new JDialog((JDialog) null, true);
        popupInformation.setBounds(0, 0, 500, 200);
        popupInformation.setMinimumSize(new Dimension(500, 150));
        popupInformation.setLocationRelativeTo(null);
        popupInformation.setLayout(new BorderLayout());

        containerInformation = new JPanel();
        containerInformation.setBounds(0, 0, 500, 100);
        containerInformation.setBackground(THEME.daysColor);
        containerInformation.setVisible(true);
        GridLayout gl = new GridLayout();
        gl.setColumns(1);
        gl.setRows(4);
        containerInformation.setLayout(gl);
        popupInformation.add(containerInformation);

        messageInformation = new JLabel();
        messageInformation.setForeground(THEME.fontColor2);
        messageInformation.setFont(new Font("Verdana", Font.BOLD, 14));
        messageInformation.setHorizontalAlignment(JLabel.CENTER);
        messageInformation.setVisible(true);
        containerInformation.add(messageInformation, -1);

        informationField = new JTextField();
        informationField.setForeground(Color.BLACK);
        informationField.setSize(500, 50);
        informationField.setHorizontalAlignment(JTextField.CENTER);
        informationField.setFont(new Font("Verdana", Font.PLAIN, 14));
        informationField.setVisible(true);
        containerInformation.add(informationField, -1);

        checkBoxContainer = new JPanel();
        checkBoxContainer.setBackground(THEME.daysColor);
        checkBoxContainer.setVisible(true);
        checkBoxContainer.setLayout(new FlowLayout());
        containerInformation.add(checkBoxContainer, -1);

        checkBoxInformation = new JCheckBox("¿Desea aplicar los cambios a todas las celdas de este curso?", true);
        checkBoxContainer.add(checkBoxInformation, -1);

        aceptButton = new JButton("Aceptar");
        aceptButton.setSize(500, 50);
        aceptButton.setBackground(THEME.containerColor);
        aceptButton.setForeground(THEME.fontColor);
        aceptButton.setFont(new Font("Verdana", Font.BOLD, 14));
        aceptButton.setVisible(true);
        containerInformation.add(aceptButton, -1);

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        setOldCourseName(this.courseName);
        this.courseName = courseName;
        if (tileListener != null) {
            tileListener.nameChanged(this);
        }
    }

    public void setCourseName(String courseName, boolean v) {
        this.courseName = courseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        if (tileListener != null) {
            tileListener.urlChanged(this);
        }
    }

    public void setUrl(String url, boolean v) {
        this.url = url;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getColorChanged() {
        return colorChanged;
    }

    public void setColorChanged(String colorChanged) {
        this.colorChanged = colorChanged;
        if (tileListener != null) {
            tileListener.backgroundChanged(this);
        }
    }

    public void setColorChanged(String colorChanged, boolean v) {
        this.colorChanged = colorChanged;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void addTileListener(TileListener tl) {
        this.tileListener = tl;
    }

    public String getOldCourseName() {
        return oldCourseName;
    }

    public void setOldCourseName(String oldCourseName) {
        this.oldCourseName = oldCourseName;
    }

}
