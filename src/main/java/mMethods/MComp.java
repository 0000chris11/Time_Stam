/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mMethods;

import java.awt.Component;
import java.awt.Container;
import java.awt.FontMetrics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Christopher
 */
public class MComp {
      
    public static int getComponentIndex(Component component) {
            Container c = component.getParent();
            for (int a = 0; a < c.getComponentCount(); a++) {
                  if (c.getComponent(a) == component) {
                        return a;
                  }
            }
            return -1;
      }
  
    public static void setLableToCenter(JLabel LB, JComponent JC){
            FontMetrics FM = LB.getFontMetrics(LB.getFont());
            
            int x = (JC.getWidth() - (int) LB.getWidth()) / 2;
            int y = (FM.getAscent() + 
                    (JC.getHeight() - (FM.getAscent() + FM.getDescent())) / 2);
            
            LB.setLocation(x, y);
      }
    
    public static void setLabelToXCenter(JLabel LB, int y, JComponent JC){
            int x = (JC.getWidth() - (int) LB.getWidth()) / 2;
            LB.setLocation(x, y);
      }
      
    public static void setLabelToXCenter(JLabel LB, int y, JFrame JC){
            int x = (JC.getWidth() - (int) LB.getWidth()) / 2;
            LB.setLocation(x, y);
      }
      
    public static void setComponentFitOnJFrame(JComponent jc, JFrame jf) {
            jc.setBounds(2, 2,
                    jf.getWidth() - 21,
                    jf.getHeight() - 44);

            System.out.println("JP Bounds: " + jc.getBounds());
      }
      
}
