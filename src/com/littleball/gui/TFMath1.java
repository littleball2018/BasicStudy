package com.littleball.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFMath1 {
    public static void main(String[] args) {
        new Shurukuang("加法计算器");
        //System.out.println(Integer.MAX_VALUE);

    }
}

class Shurukuang extends Frame{
    TextField num1,num2,num3;
    Shurukuang(String title){
        super(title);
        setLocation(500,300);
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(15);
        Label labelPlus = new Label("+");
        Button buttonEqual = new Button("=");
        Monitor monitor = new Monitor(this);
        buttonEqual.addActionListener(monitor);
        setLayout(new FlowLayout());
        add(num1);
        add(labelPlus);
        add(num2);
        add(buttonEqual);
        add(num3);
        pack();
        setVisible(true);

    }
}



class Monitor implements ActionListener{
//    TextField num1,num2,num3;
//
//    Monitor(TextField num1,TextField num2,TextField num3){
//        this.num1 = num1;
//        this.num2 = num2;
//        this.num3 = num3;
//    }


    Shurukuang shurukuang = null;

    Monitor(Shurukuang shurukuang){
        this.shurukuang = shurukuang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n1 = Integer.parseInt(shurukuang.num1.getText());
        int n2 = Integer.parseInt(shurukuang.num2.getText());
        shurukuang.num3.setText(String.valueOf(n1+n2));
    }
}
