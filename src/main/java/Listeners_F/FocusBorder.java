
package Listeners_F;

import First.VF_R;
import MC.DT;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;

/**
 *
 * @author Christopher
 */
public class FocusBorder implements FocusListener{

      @Override
      public void focusGained(FocusEvent evt) {
            //System.out.println("\n2 - focusGained");
            JComponent JC = (JComponent) evt.getSource();          
            JC.setBorder(DT.compoundBorder_O);
            
            //System.out.println(cS.toString());
            //System.out.println(cS.getName() + " bounds [" 
              //      + cS.getX() + ", " + cS.getY() + ", " + cS.getWidth() + ", " + cS.getHeight() + "]");
            /*
            VF_R.getP1().repaint();
            new Thread(){
                  @Override
                  public void run(){
                        try{
                              Thread.sleep(100);
                        }catch(InterruptedException ex){
                              ex.printStackTrace();
                        }
                        //System.out.println("calling paintComponents");
                        VF_R.getP1().paintComponents(VF_R.getP1().getGraphics());
                  }
            }.start();
            */
      }

      @Override
      public void focusLost(FocusEvent evt) {
            //System.out.println("\n2 - focusLost");
            JComponent JC = (JComponent) evt.getSource();
            JC.setBorder(DT.compoundBorder_N);
            //cS = JC;
      }
      
}

