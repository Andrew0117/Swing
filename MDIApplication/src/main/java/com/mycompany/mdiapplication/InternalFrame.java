/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mdiapplication;

import java.awt.Component;
import java.beans.*;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Andrey
 */
// Class extands JInternalFrame
public class InternalFrame extends JInternalFrame {
    
    public InternalFrame() {
        
        super("", true, true, true);
    
    }

    public InternalFrame(String title, URL _url)
    {
        super(title, false, true);
        setFrameIcon(new ImageIcon(_url));
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        try{
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
             SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {
          e.printStackTrace(); // записывать в файл или выводить сообщение ?
        }
    }

    public InternalFrame(String title)
    {
        super(title, true, true, true);
        //setFrameIcon(new ImageIcon(_url));
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        try{
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//             UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
             SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {
          e.printStackTrace(); // записывать в файл или выводить сообщение ?
        }
    }

    public InternalFrame(String title, String icon)
    {
        super(title, false, true);
        setFrameIcon(new ImageIcon(icon));
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        try{
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//             UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
             SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {
          e.printStackTrace(); // записывать в файл или выводить сообщение ?
        }
    }
   public InternalFrame(String title, boolean max, String icon)
    {
        super(title, false, true, max);
        setFrameIcon(new ImageIcon(icon));
        try{
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
             SwingUtilities.updateComponentTreeUI(this);isEnabled();
        }
        catch (Exception e)
        {
          e.printStackTrace(); // записывать в файл или выводить сообщение ?
        }
    }
   public InternalFrame(String title, boolean max, URL _url)
    {
        super(title, false, true, max);
        setFrameIcon(new ImageIcon(_url));
        try{
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
             SwingUtilities.updateComponentTreeUI(this);isEnabled();
        }
        catch (Exception e)
        {
          e.printStackTrace(); // записывать в файл или выводить сообщение ?
        }
    }

/**
 *Enabled/Disabled компонентов типа JTextField & Clear JTextField
 * <br>
 * <strong>b</strong> Enabled/Disabled JTextField
 */
   @Deprecated
   public void isClearEnabled_JTextField(boolean b){
       Component[] component = getRootPane().getContentPane().getComponents();
       for(int i = 0; i<component.length; i++){
           if(component[i] instanceof JTextField){
              JTextField jtf = (JTextField) component[i];
              jtf.setText("");
              jtf.setEnabled(b);
           }
       }
   }
   /**
 *Проверка значений свойств Text компонентов типа JTextField на ""
 * <br>
 * <strong>S_Name_JTextField</strong> исключает в обработке заданные имена, если null обрабатывает все
 * <br>
 * <strong>true</strong> присутствуют компоненты "",  отсутствуют
 */
  @Deprecated
  public boolean getClearJTextField(String[] S_Name_JTextField){
       boolean clear = false;
       Component[] component = getRootPane().getContentPane().getComponents();
       if(S_Name_JTextField == null){
          for(int i = 0; i<component.length; i++){
              if(component[i] instanceof JTextField){
                 JTextField jtf = (JTextField) component[i];
                     if(jtf.getText().equals("")){
                            return clear = true;
                     }
              }
          }
       }
       else{
            for(int i = 0; i<component.length; i++){
                if(component[i] instanceof JTextField){
                   JTextField jtf = (JTextField) component[i];
                   for(int y = 0; y<S_Name_JTextField.length; y++){
                       if(!S_Name_JTextField[y].equals(jtf.getName())){
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



   private final int DEFAULT_WIDTH = 300;
   private final int DEFAULT_HEIGHT = 300;
}
