package com.mycompany.mdiapplication;

import java.awt.Component;
import java.beans.PropertyVetoException;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 *
 * @author Администратор
 */
public class StaticForm {

/**
 *Enabled/Disabled компонентов типа JTextField & Clear JTextField
 * <br>
 * <strong>b</strong> Enabled/Disabled JTextField
 */
  public static void Add_Visible_JFrame_to_JDesktopPane
         (JDesktopPane jdp, JInternalFrame jif) throws PropertyVetoException{
           boolean est = false;
           if(jdp.getAllFrames() != null){
             for(int i = 0; i < jdp.getAllFrames().length; i++){
                if(jdp.getAllFrames()[i] == jif){
                  est = true;
                }
             }
           }
           if(est){
              jif.show();
              jif.setClosed(false);
              jif.setSelected(true);
              est = false;
           }
           else{
              jdp.add(jif);
              jif.show();
              jif.setClosed(false);
              jif.setSelected(true);
              est = false;
           }
  }
/**
 *Enabled/Disabled компонентов типа JRadioButton
 *</p>
 * <strong>JComponent</strong> ссылка на компонент вмещающий JRadioButton
 * <br>
 * <strong>b</strong> Enabled/Disabled
 * <br>
 * <strong>S_Name_JButoon</strong> отключает только те компоненты JRadioButton, у которых совпадают имена,
 * если null все
 */
   public static void isEnabledDisableRadioButtonComponent(JComponent parent, String[] S_Name_JRadioButton,
                                                    boolean b){
       Component[] component = parent.getComponents();
       if(S_Name_JRadioButton == null){
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof JRadioButton){
                          component[i].setEnabled(b);
                }
            }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof JRadioButton){
                   for(int y = 0; y<S_Name_JRadioButton.length; y++){
                       if(S_Name_JRadioButton[y].equals(component[i].getName())){
                           component[i].setEnabled(b);
                       }
                   }
                }
            }
       }
   }
 /**
 *Проверка значений свойств Text компонентов типа JTextField на ""
 * <br>
 * <strong>parent</strong> ссылка на компонент вмещающиий JTextField
 * <br>
 * <strong>S_Name_JTextField</strong> включает в обработку заданные имена, если <strong>null</strong>
 * обрабатывает все
 * <br>
 * возвращает <strong>true</strong> в случае если присутствуют компоненты JTextField со
 * значением свойства getText() == "", false отсутствуют
 */
   public static boolean getClearJTextField(java.awt.Container parent,
                                                  String[] S_Name_JTextField){
       boolean clear = false;
       java.awt.Component[] component = parent.getComponents();
       if(S_Name_JTextField == null){
          for(int i = 0; i<component.length; i++){
              if(component[i] instanceof javax.swing.JTextField){
                 javax.swing.JTextField jtf = (javax.swing.JTextField) component[i];
                     if(jtf.getText().equals("")){
                            return clear = true;
                     }
              }
          }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof javax.swing.JTextField){
                   javax.swing.JTextField jtf = (javax.swing.JTextField) component[i];
                   for(int y = 0; y<S_Name_JTextField.length; y++){
                           String s = jtf.getName();
                           String s2 = S_Name_JTextField[y];
                       if(S_Name_JTextField[y].equals(jtf.getName())){
                          if(jtf.getText().equals("")){
                              return clear = true;
                          }
                       }
                   }
                }
            }
       }
       return clear;
   }
/**
 *Отключение/включение компонентов типа JButton
 *</p>
 * <strong>parent</strong> ссылка на компонент вмещающий JButton
 * <br>
 * <strong>b</strong> включить/выключить
 * <br>
 * <strong>S_Name_JButoon</strong> отключает только те компоненты JButton, у которых совпадают
 * заданные имена, если <b>null</b> все
 */
   public static void isEnabledDisableButtonComponent(javax.swing.JComponent parent,
                                                            String[] S_Name_JButoon,  boolean b){
       java.awt.Component[] component = parent.getComponents();
       if(S_Name_JButoon == null){
          for(int i = 0; i<component.length; i++){
              if(component[i] instanceof javax.swing.JButton){
                 component[i].setEnabled(b);
              }
          }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof javax.swing.JButton){
                   for(int y = 0; y<S_Name_JButoon.length; y++){
                       if(S_Name_JButoon[y].equals(component[i].getName())){
                           component[i].setEnabled(b);
                       }
                   }
                }
            }
       }
   }
   /**
 *Отключение/включение визуализации компонентов типа JButton
 *</p>
 * <strong>parent</strong> ссылка на компонент вмещающий JButton
 * <br>
 * <strong>b</strong> включить/выключить
 * <br>
 * <strong>S_Name_JButoon</strong> отключает только те компоненты JButton, у которых совпадают заданные
 * имена, если <b>null</b> все
 */
   public static void isVisibleButtonComponent(javax.swing.JComponent parent,
                                                     String[] S_Name_JButoon,  boolean b){
       java.awt.Component[] component = parent.getComponents();
       if(S_Name_JButoon == null){
          for(int i = 0; i<component.length; i++){
              if(component[i] instanceof javax.swing.JButton){
                 component[i].setVisible(b);
              }
          }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof javax.swing.JButton){
                   for(int y = 0; y<S_Name_JButoon.length; y++){
                       if(S_Name_JButoon[y].equals(component[i].getName())){
                           component[i].setVisible(b);
                       }
                   }
                }
            }
       }
   }
/**
 * Отключение/включение визуализации компонентов имена которых совпадают с заданными
 * в S_Name_Component
 * </p>
 * <strong>parent</strong> ссылка на компонент вмещающий JButton
 * <br>
 * <strong>S_Name_Component</strong> отключает/включает визуализацию только тех компонентов,
 * у которых совпадают имена
 */
   public static void isVisibleComponent(java.awt.Container parent, String[] S_Name_Component,  boolean b){
       java.awt.Component[] component = parent.getComponents();
       for(int i = 0; i<component.length; i++){
          for(int y = 0; y<S_Name_Component.length; y++){
              if(S_Name_Component[y].equals(component[i].getName())){
                 component[i].setVisible(b);
              }
          }
       }
   }
/**
 *Отключение/включение компонентов типа JButton
 *</p>
 * <strong>parent</strong> ссылка на компонент вмещающий JButton
 * <br>
 * <strong>b</strong> включить/выключить
 * <br>
 * <strong>S_Name_JButoon</strong> отключает только те компоненты JButton, у которых совпадают имена,
 * если <b>null</b> все
 */
   public static void isEnabledDisableButtonComponent(java.awt.Container parent,
                                                            String[] S_Name_JButoon,  boolean b){
       java.awt.Component[] component = parent.getComponents();
       if(S_Name_JButoon == null){
          for(int i = 0; i<component.length; i++){
              if(component[i] instanceof javax.swing.JButton){
                 component[i].setEnabled(b);
              }
          }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof javax.swing.JButton){
                   for(int y = 0; y<S_Name_JButoon.length; y++){
                       if(S_Name_JButoon[y].equals(component[i].getName())){
                           component[i].setEnabled(b);
                       }
                   }
                }
            }
       }
   }
/**
 *Enabled/Disabled компонентов типа JTextField & Clear JTextField
 *</p>
 * <strong>parent</strong> ссылка на компонент вмещающий JTextField
 * <br>
 * <strong>b</strong> включить/выключить
 * <br>
 * <strong>S_Name_JButoon</strong> отключает только те компоненты JTextField, у которых совпадают имена,
 * если <b>null</b> все
 */
   public static void isClearJTextField(java.awt.Container parent, String[] S_Name_JTextField,  boolean b){
       java.awt.Component[] component = parent.getComponents();
       if(S_Name_JTextField == null){
          for(int i = 0; i<component.length; i++){
              if(component[i] instanceof javax.swing.JTextField){
                 component[i].setEnabled(b);
                 ((javax.swing.JTextField)component[i]).setText("");
              }
          }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof javax.swing.JTextField){
                   for(int y = 0; y < S_Name_JTextField.length; y++){
                       if(S_Name_JTextField[y].equals(component[i].getName())){
                           component[i].setEnabled(b);
                           ((javax.swing.JTextField)component[i]).setText("");
                       }
                   }
                }
            }
       }
   }
/**
 *Clear компонентов типа JTextField
 *</p>
 * <strong>parent</strong> ссылка на компонент вмещающий JTextField
 * <br>
 * <strong>S_Name_JButoon</strong>  <b>setText("")</b> только те компоненты JTextField, у которых совпадают имена,
 * если <b>null</b> все
 */
   public static void isClearJTextField(java.awt.Container parent, String[] S_Name_JTextField){
       java.awt.Component[] component = parent.getComponents();
       if(S_Name_JTextField == null){
          for(int i = 0; i<component.length; i++){
              if(component[i] instanceof javax.swing.JTextField){
                 ((javax.swing.JTextField)component[i]).setText("");
              }
          }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof javax.swing.JTextField){
                   for(int y = 0; y < S_Name_JTextField.length; y++){
                       if(S_Name_JTextField[y].equals(component[i].getName())){
                           ((javax.swing.JTextField)component[i]).setText("");
                       }
                   }
                }
            }
       }
   }
  /** Рамка и название в рамке для компонента JPanel */
  public static Border LineAndTitlePanel(String title){
        Border etched = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createTitledBorder(etched, title);
        return border;
  }

}
