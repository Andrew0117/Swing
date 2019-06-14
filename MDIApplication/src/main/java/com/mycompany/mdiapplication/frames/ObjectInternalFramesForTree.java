package com.mycompany.mdiapplication.frames;

import javax.swing.JInternalFrame;

/**
 *
 * @author Andrey
 */
public class ObjectInternalFramesForTree {

    /**
     * Construct a variable
     *
     * @param jif the InternalFrame
     * @param aName the String
     */
    public ObjectInternalFramesForTree(JInternalFrame jif, String aName) {
        jframe = jif;
        name = aName;
    }

    public JInternalFrame getFrame() {
        return (JInternalFrame) jframe;
    }

    @Override
    public String toString() {
        return name;
    }
    private JInternalFrame jframe;
    private String name;
}
