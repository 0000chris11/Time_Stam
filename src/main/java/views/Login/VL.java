/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class VL extends VL_DataCom{
      
      public VL(){
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            JF.setUndecorated(true);
            JF.setShape(new RoundRectangle2D);
            //++++++++++++++++++++++++
            new VL();
      }
      
      
      public static void main(String[] args){
            SwingUtilities.invokeLater(new Runnable(){
                  @Override
                  public void run() {
                        
                        JF.setLocationRelativeTo(null);
                        JF.setVisible(true);
                  }
                  
            });
      }
}
