/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author MManolas
 */
public class Tabs {
    
    /**
     *
     * @param panel
     * @param isEnabled
     */
    public static void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

        Component[] components = panel.getComponents();

        for (int i = 0; i < components.length; i++) {
            if (components[i].getClass().getName() == "javax.swing.JPanel") {
                setPanelEnabled((JPanel) components[i], isEnabled);
            }

            components[i].setEnabled(isEnabled);
        }
    }
    
    
}
