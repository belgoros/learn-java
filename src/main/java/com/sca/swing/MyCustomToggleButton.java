package com.sca.swing;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyCustomToggleButton extends JToggleButton implements ItemListener {

    public MyCustomToggleButton(String text) {
        super(text);
        init();
    }

    private void init() {
        addItemListener(this);
        setDeactivated();
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        int buttonState = event.getStateChange();
        if (buttonState == ItemEvent.SELECTED) {
            setActivated();
        } else {
            setDeactivated();
        }
    }

    private void setDeactivated() {
        setText("OFF");
        setBorder(BorderFactory.createRaisedBevelBorder());
    }

    private void setActivated() {
        setText("ON");
        setBorder(BorderFactory.createLoweredBevelBorder());
    }
}
