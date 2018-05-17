package com.littleball.gui;

import java.awt.*;
import java.awt.event.*;

public class TestPaint {
    public static void main(String[] args) {
        new PaintFrame("太阳");

    }

}

class PaintFrame extends Frame{
    PaintFrame(String title){
        super(title);
        setLayout(new BorderLayout());
        MyWindowAdapter myWindowAdapter = new MyWindowAdapter();
        addWindowListener(myWindowAdapter);
        setBackground(Color.cyan);
        setVisible(true);


    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(50,50,40,40);
        g.setColor(Color.red);
        g.drawLine(70,70,70,30);
        g.drawLine(70,70,30,70);
        g.drawLine(70,70,110,70);
        g.drawLine(70,70,70,110);
        g.drawLine(70,70,42,42);
        g.drawLine(70,70,42,98);
        g.drawLine(70,70,98,98);
        g.drawLine(70,70,98,42);
        g.setColor(c);



    }

    private class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
