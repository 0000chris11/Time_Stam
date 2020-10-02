/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofii;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Christopher
 */
public class MImage {
      
      public static void setImageIcon(JButton btn, String url) {
            ImageIcon ic = new ImageIcon(url);
            Icon i = (Icon) ic;
            btn.setIcon(i);
      }
      
      public static ImageIcon resizeIcon(ImageIcon ii) {
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            BufferedImage bimage = new BufferedImage(225, 225, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bimage.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(ii.getImage(), 0, 0, 225, 225, null);

            ImageIcon icon2 = new ImageIcon(bimage);

            //System.out.println("------------------------Icon2 Width: " + icon2.getIconWidth() + "\tHeight: " + icon2.getIconHeight());
            return icon2;
            //++++++++++++++++++++++++++++++++++++++++++++++++++
      }
}
