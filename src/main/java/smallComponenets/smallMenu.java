/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenuBar;

/**
 *
 * @author Christopher
 */
public class smallMenu extends JMenuBar {

      @Override
      public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
      }
      
      public smallMenu(){
            setForeground(Color.WHITE);
      }
}
