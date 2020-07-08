package com.sca.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

public class JToggleButtonExample extends JFrame {

    private JToggleButton button;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        new JToggleButtonExample();
    }

    JToggleButtonExample() {
        setTitle("JToggleButton with ItemListener Example");
        setLayout(new FlowLayout());
        initButton();
        //setButtonAction();
        setSize(300, 300);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initButton() {
        button = new MyCustomToggleButton("OFF");
        button.setIcon(getWarningIcon());
        add(button);
    }

    private void setButtonAction() {
        button.addItemListener(createButtonListener());
    }

    private ItemListener createButtonListener() {
        ItemListener itemListener = event -> {
            int buttonState = event.getStateChange();
            if (buttonState == ItemEvent.SELECTED) {
                button.setText("ON");
                button.setBorder(BorderFactory.createLoweredBevelBorder());

            } else {
                button.setText("OFF");
                button.setBorder(BorderFactory.createRaisedBevelBorder());
            }
        };

        return itemListener;
    }

    private ImageIcon getWarningIcon() {
        URL resource = getClass().getResource("/warning.png");

        return new ImageIcon(resource);
    }
}
