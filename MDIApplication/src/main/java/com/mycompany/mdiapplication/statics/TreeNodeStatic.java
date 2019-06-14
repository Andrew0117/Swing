package com.mycompany.mdiapplication.statics;

import com.mycompany.mdiapplication.frames.ObjectInternalFramesForTree;
import com.mycompany.mdiapplication.frames.ThirdInternalFrame;
import com.mycompany.mdiapplication.frames.SecondInternalFrame;
import com.mycompany.mdiapplication.frames.GeneralInternalFrame;
import com.mycompany.mdiapplication.frames.FirstInternalFrame;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Андрей
 */
// Класс возвращающий объекты модели для JTree
public class TreeNodeStatic {

    public static final DefaultMutableTreeNode getFrames(){
          ObjectInternalFramesForTree a2 = 
                  new ObjectInternalFramesForTree(new FirstInternalFrame(),
                                                                           "<< Книги >>");
          ObjectInternalFramesForTree a3 = 
                  new ObjectInternalFramesForTree(new SecondInternalFrame(),
                                                                           "<< Картотека книг >>");
          ObjectInternalFramesForTree a4 = 
                  new ObjectInternalFramesForTree(new ThirdInternalFrame(),
                                                                           "<< Картотека посетителей >>");
          ObjectInternalFramesForTree generalFrame =
                                      new ObjectInternalFramesForTree(new GeneralInternalFrame(), "<< Главная >>");

          DefaultMutableTreeNode root = new DefaultMutableTreeNode("Все задачи");
          DefaultMutableTreeNode subproblems = new DefaultMutableTreeNode("Вспомогательные задачи");
          root.add(subproblems);
          DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(a2);
          subproblems.add(leaf);
          leaf = new DefaultMutableTreeNode(a4);
          subproblems.add(leaf);
          leaf = new DefaultMutableTreeNode(a3);
          subproblems.add(leaf);
          subproblems = new DefaultMutableTreeNode(generalFrame);
          root.add(subproblems);

          return (DefaultMutableTreeNode) root;
    }

}