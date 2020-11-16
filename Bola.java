/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bolasaltando;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;
import java.awt.geom.Ellipse2D;
import java.awt.geom.AffineTransform;



public class Bola extends JPanel implements Runnable {
    public int size = 30;
    public Ellipse2D bola;
    public Point endPoint, startPoint, auxPoint;
    public int velocity = 10;
    public boolean flagQueda = true;
    public Thread thread;
    public int limitOfJump = 30;
    
    public Bola(Point startPoint, Point endPoint) {
        this.bola = new Ellipse2D.Double(startPoint.getX(), startPoint.getY(), this.size, this.size);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.auxPoint = this.startPoint;
        thread = new Thread(this);
        thread.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.ORANGE);
        g2.fillOval(this.auxPoint.x, this.auxPoint.y, this.size, this.size);
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                if (this.flagQueda) {
                    this.auxPoint.y += velocity;
                    if (this.auxPoint.y > this.endPoint.y) {
                        this.flagQueda = false;
                        velocity -= 1;
                    }
                } else {
                    this.auxPoint.y -= velocity;
                    if(this.auxPoint.y <= limitOfJump) {
                        this.flagQueda = true;
                        limitOfJump += 35;
                    }
                }
                
                if (velocity == 0) {
                    break;
                }
                super.repaint();
                thread.sleep(20);
            }
        } catch (Exception e) {
            System.err.println("A error occurred: " + e.getMessage());
        }
    }
}
