

package com.wrox.begjsp.ch08;
import java.awt.*;
import java.applet.*;
public class CircleApplet extends java.applet.Applet {
    
    private Color circColor = null;
    private int radius = 5;
    public void init() {

     circColor = Color.decode(this.getParameter("color"));
     radius = Integer.parseInt(this.getParameter("radius"));
    }
    public void paint(Graphics gr) {
        gr.setColor(circColor);
        gr.fillOval(10, 10, radius * 2, radius * 2);
        
    }
}
