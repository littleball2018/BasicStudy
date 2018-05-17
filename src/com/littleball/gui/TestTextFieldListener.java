package com.littleball.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTextFieldListener {
    public static void main(String[] args) {
        new MyTextField("MyTextField For Password");

    }

}

class MyTextField extends Frame{
    MyTextField(String title){
        super(title);
        setLayout(new BorderLayout());
        TextField tf = new TextField();
        add(tf);
        tf.setEchoChar('*');
        MyTFActionListener actionListener = new MyTFActionListener();
        tf.addActionListener(actionListener);
        pack();
        setVisible(true);

    }

}

class MyTFActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField tf = (TextField)e.getSource();
        System.out.println(tf.getText());
        tf.setText("");
    }
}
