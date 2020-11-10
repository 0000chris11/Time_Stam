/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import org.apache.commons.lang3.SerializationUtils;

/**
 *
 * @author Christopher
 */
public class smallBTN_TG extends JToggleButton {
      
      public Color[] C;

      @Override
      public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            //System.out.println("paintComponent");
            int w = getWidth();
            int h = getHeight();
            if (isEnabled()) {
                  if (isSelected()) {
                        //System.out.println("\tis Selcted");
                        g2.setPaint(new GradientPaint(0, 0, 
                                C[0], w, h, C[1]));
                  } else {
                        //System.out.println("\tNOT");
                        g2.setPaint(new GradientPaint(0, 0, 
                                C[0].darker(), w, h, Color.GRAY));
                  }
            }else{
                  g2.setPaint(new GradientPaint(0, 0, 
                          Color.GRAY.darker(), w, h, Color.WHITE.darker()));
            }
            g2.fillRect(0, 0, w, h);

            super.paintComponents(g);
      }
      
      public smallBTN_TG(Color[] c){
            C = c;
      }
}
