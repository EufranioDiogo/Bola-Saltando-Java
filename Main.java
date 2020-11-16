package com.mycompany.bolasaltando;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Point;

public class Main extends JFrame  {
    public Main() {
        Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
        
        setSize((int)(screenSize.width / 2), (int)(screenSize.height / 2));
        setLocation((int)(((screenSize.width / 2) - (this.getWidth() / 2))), (int)(((screenSize.height / 2) - (this.getHeight()/ 2))));
        
        
        Point startPoint = new Point((int)(this.getWidth() / 2) - 15, 30);
        Point endPoint = new Point((int)(this.getWidth() / 2) - 15, this.getHeight() - (15 * 3));
        
        add(new Bola(startPoint, endPoint));
        
        
        setVisible(true);
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
