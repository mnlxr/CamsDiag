/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

/**
 *
 * @author MManolas
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class CameraFoo extends JPanel {
    // only static field here is a constant.
    private static String TEXTS = "0123456789ABCDEF";
    private JSpinner spinner = new JSpinner();
    private JSlider slider = new JSlider(0, 15, 0);

    public CameraFoo() {    
        List<Character> charList = new ArrayList<>();
        Hashtable<Integer, JLabel> table = new Hashtable<>();
        for (int i = 0; i < TEXTS.toCharArray().length; i++) {
            char c = TEXTS.charAt(i);
            String myText = String.valueOf(c);
            JLabel label = new JLabel(myText);
            table.put(i, label);
            charList.add(c);
        }
        SpinnerListModel spinnerModel = new SpinnerListModel(charList);
        spinner.setModel(spinnerModel);
        slider.setLabelTable(table);
        slider.setPaintLabels(true);

        JPanel topPanel = new JPanel();
        topPanel.add(spinner);
        topPanel.add(new JButton(new ButtonAction("Press Me")));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(slider);
    }

    private class ButtonAction extends AbstractAction {
        public ButtonAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            char ch = (char) spinner.getValue();
            int value = TEXTS.indexOf(ch);
            slider.setValue(value);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }

    private static void createAndShowGui() {
        CameraFoo mainPanel = new CameraFoo();
        JFrame frame = new JFrame("CameraFoo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
