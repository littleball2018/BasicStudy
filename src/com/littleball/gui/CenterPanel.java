package com.littleball.gui;

import java.awt.*;

public class CenterPanel {
    public static void main(String[] args) {
        FrameWithPanel f = new FrameWithPanel("My Frame with Panel",100,100,400,300,Color.BLUE,Color.yellow);

    }
}

class FrameWithPanel extends Frame{
   // private Panel p;
    FrameWithPanel(String str,int x,int y,int w,int h,Color out,Color in){
        super(str);
       // setLayout(null);
        setBounds(x,y,w,h);
        setBackground(out);

        Panel p = new Panel(null);
        add(p);p.setBounds((int)w/4,(int)h/4,(int)w/2,(int)h/2);
        p.setBackground(in);
        setVisible(true);



    }

}
