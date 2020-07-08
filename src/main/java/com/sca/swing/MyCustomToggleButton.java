package com.sca.swing;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyCustomToggleButton extends JToggleButton implements ItemListener {

    public MyCustomToggleButton(String text) {
        super(text);
        addItemListener(this);
        init();
    }

    private void init() {
        setBorder(BorderFactory.createRaisedBevelBorder());
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        int buttonState = event.getStateChange();
        if (buttonState == ItemEvent.SELECTED) {
            setText("ON");
            setBorder(BorderFactory.createLoweredBevelBorder());
        } else {
            setText("OFF");
            setBorder(BorderFactory.createRaisedBevelBorder());
        }
    }
}
