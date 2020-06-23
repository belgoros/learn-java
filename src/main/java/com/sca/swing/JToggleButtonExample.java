package com.sca.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JToggleButtonExample extends JFrame implements ItemListener {

    private JToggleButton button;

    public static void main(String[] args) {
        new JToggleButtonExample();
    }

    JToggleButtonExample() {
        setTitle("JToggleButton with ItemListener Example");
        setLayout(new FlowLayout());
        setJToggleButton();
        setAction();
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setJToggleButton() {
        button = new JToggleButton("ON");
        add(button);
    }

    private void setAction() {
        button.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (button.isSelected()) {
            button.setText("OFF");
        } else {
            button.setText("ON");
        }
    }
}
