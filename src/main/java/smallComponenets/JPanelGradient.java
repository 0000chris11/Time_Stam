package smallComponenets;

import MC.DT;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Christopher
 */
public class JPanelGradient extends JPanel {

      private static boolean tdeleted = false;
      public static void setTDeleted(boolean b){
            tdeleted = b;
      }

      @Override
      public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new GradientPaint(
                    0, 0, DT.GP_darkRed[0],
                    getWidth(), getHeight(),
                    DT.GP_darkRed[1]));
            g2.fillRect(0, 0, getWidth(), getHeight());
            
            //TABLE DELETED STATE
            if(tdeleted == true){
                  g2.setStroke(new BasicStroke(3));
                  g2.setColor(Color.RED);
                  g2.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
            }
            super.paintComponents(g);
      }
}
