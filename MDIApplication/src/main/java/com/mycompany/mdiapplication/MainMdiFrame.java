package com.mycompany.mdiapplication;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.AbstractAction;

/**
 *
 * @author Андрей
 */
public class MainMdiFrame extends javax.swing.JFrame {

    public MainMdiFrame() {
        initComponents();

        super.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 30);
        super.setLocation(0, 0);
        super.setTitle("MDI form");
        treeSelectFrames = new TreeSelectFrames(jDesktopPane1);

        action = new actionTreeInternalFrame();
        jButton3.setAction(action);
        jMenuItem1.setText("Select task");
        jMenuItem1.addActionListener((ActionEvent e) -> {
            isVisibleTreeInternalFrame();
        });
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener((ActionEvent e) -> {
            MainMdiFrame.this.dispose();
            System.exit(0);
        });
        jMenuItem6.setText("About");
//        jMenuItem6.setAction(aa);

        super.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                MainMdiFrame.this.dispose();
                System.exit(0);
            }
        });
    }

    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        ClockLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(104, 36));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        ClockLabel.setFont(new java.awt.Font("Times New Roman", 3, 14));
        ClockLabel.setForeground(new java.awt.Color(51, 204, 0));
        ClockLabel.setText("jLabel1");

        jMenu1.setText("File");

        jMenuItem1.setText("Выбор задач");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("О программе");

        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(ClockLabel))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ClockLabel)
                                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
        );

        pack();
    }

    private void isVisibleTreeInternalFrame() {
        try
             {
                 StaticForm.Add_Visible_JFrame_to_JDesktopPane(jDesktopPane1, treeSelectFrames);
             }
          catch (PropertyVetoException pve){}
    }

    private class actionTreeInternalFrame extends AbstractAction {

        public actionTreeInternalFrame() {
            super();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            isVisibleTreeInternalFrame();
        }
    }
    private TreeSelectFrames treeSelectFrames;
    private javax.swing.JLabel ClockLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private AbstractAction action;

    public static void main(String[] args) {
        MainMdiFrame mainmdiframe = new MainMdiFrame();
        mainmdiframe.setVisible(true);
    }
}
