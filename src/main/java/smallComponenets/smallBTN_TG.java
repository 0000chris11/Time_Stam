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
      
      GradientPaint GP;
      GradientPaint GP_D;

      GradientPaint GP_O;
      GradientPaint GP_OD;
      
      GradientPaint GP_EF; 

      Color[] colors = new Color[]{
            Color.BLUE, Color.BLUE.darker(),
            Color.RED, Color.BLUE.darker(),
            Color.GREEN, Color.GREEN.darker(),
            Color.YELLOW, Color.YELLOW.darker(),
            Color.CYAN, Color.CYAN.darker()};

      public static final int blueWhite = 0;
      public static final int blueWhite_D = 5;
      public static final int redWhite = 1;
      public static final int redWhite_D = 6;
      public static final int greenWhite = 2;
      public static final int greenWhite_D = 7;
      public static final int yellowWhite = 3;
      public static final int yellowWhite_D = 8;
      public static final int cyanWhite = 4;
      public static final int cyanWhite_D = 9;

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
                                Color.CYAN, w, h, Color.WHITE));
                  } else {
                        //System.out.println("\tNOT");
                        g2.setPaint(new GradientPaint(0, 0, 
                                Color.BLUE.darker(), w, h, Color.WHITE.darker()));
                  }
            }else{
                  g2.setPaint(new GradientPaint(0, 0, 
                          Color.GRAY.darker(), w, h, Color.WHITE.darker()));
            }
            g2.fillRect(0, 0, w, h);

            super.paintComponents(g);
      }
}
