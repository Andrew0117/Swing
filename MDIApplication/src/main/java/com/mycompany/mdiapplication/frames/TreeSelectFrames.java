package com.mycompany.mdiapplication.frames;

import com.mycompany.mdiapplication.statics.TreeNodeStatic;
import java.beans.PropertyChangeEvent;
//import berezhnov.ua.swing.Form.InternalFrame.ObjectInternalFramesForTree;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Andrey
 */
public class TreeSelectFrames extends InternalFrame {

    private javax.swing.JScrollPane jScrollPane1;
    private JTree TreeSelectionAllFrames;

    public TreeSelectFrames(final JDesktopPane jdp) {
        super("Select task.", "/com/mycompany/mdiapplication/icon/Add.PNG");

        TreeSelectionAllFrames = new JTree(TreeNodeStatic.getFrames());

        initComponents();

        TreeSelectionAllFrames.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent event) {
                TreePath path = TreeSelectionAllFrames.getSelectionPath();
                if (path == null) {
                    return;
                }

                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();

                if (selectedNode.isLeaf()) {
                    ObjectInternalFramesForTree aifdl = (ObjectInternalFramesForTree) selectedNode.getUserObject();
                    JInternalFrame jInternalFrame = aifdl.getFrame();
                    try {
                        jInternalFrame.setSize(jdp.getSize());
//                        berezhnov.ua.swing.Form.StaticForm.Add_Visible_JFrame_to_JDesktopPane(jdp, ifr);
                        boolean est = false;
                        if (jdp.getAllFrames() != null) {
                            for (int i = 0; i < jdp.getAllFrames().length; i++) {
                                if (jdp.getAllFrames()[i] == jInternalFrame) {
                                    est = true;
                                }
                            }
                        }
                        if (est) {
                            jInternalFrame.show();
                            jInternalFrame.setClosed(false);
                            jInternalFrame.setSelected(true);
                            est = false;
                        } else {
                            jdp.add(jInternalFrame);
                            jInternalFrame.show();
                            jInternalFrame.setClosed(false);
                            jInternalFrame.setSelected(true);
                            est = false;
                        }
                    } catch (PropertyVetoException e) {
                    }
                }
                TreeSelectionAllFrames.setSelectionRow(0);
            }
        });
        int mode = TreeSelectionModel.SINGLE_TREE_SELECTION;
        TreeSelectionAllFrames.getSelectionModel().setSelectionMode(mode);
        addVetoableChangeListener(new VetoableChangeListener() {
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                String name = evt.getPropertyName();
                Object value = evt.getNewValue();
                if (name.equals("closed") && value.equals(true)) {

                }
            }
        });

    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        jScrollPane1.setViewportView(TreeSelectionAllFrames);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

    }

}
