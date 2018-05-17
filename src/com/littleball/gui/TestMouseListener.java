package com.littleball.gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListener {
    public static void main(String[] args) {
        new MyClickMouseDrawPoint("Drawing Points...");

    }


}

class MyClickMouseDrawPoint extends Frame{
    ArrayList<Point> points = new ArrayList<Point>();

    MyClickMouseDrawPoint(String title){
        super(title);
        setBounds(300,300,400,300);

        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
        }});
        addMouseListener(new MyMouseAdapter());
        setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        Iterator<Point> iterator = points.iterator();
        while (iterator.hasNext()){
            Color c = g.getColor();
            Point p = iterator.next();
            g.setColor(Color.red);
            g.fillOval((int)p.getX(),(int) p.getY(),10,10);
            g.setColor(c);
        }


    }

    private class MyWindowsAdapter extends WindowAdapter{
//        @Override
//        public void windowClosing(WindowEvent e) {
//            System.exit(0);
//        }
    }

    private class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            Point p = new Point(e.getX(),e.getY());
            points.add(p);
            repaint();
        }

//        @Override
//        public void mouseClicked(MouseEvent e) {
//            Point p = new Point(e.getX(),e.getY());
//            points.add(p);
//            repaint();
//
//        }
    }

}


