/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import static Options.DT.JPN;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Christopher
 */
public class JTE_SelectionListener implements TreeSelectionListener {

      @Override
      public void valueChanged(TreeSelectionEvent e) {
            System.out.println(VP.JTEN.getSelectionPath().toString());

            if (VP.JTEN.getSelectionPath().toString().
                    endsWith("Star, Dist Panel]")) {
                  System.out.println("\tRIGHT");
                  VP.radioButtonSetUp(2, new String[]{
                        "Star with Null Layout",
                        "Star with GroupLayout"});

                  //((CardLayout) VP.JPN.getLayout()).show(VP.JPN, "JP Start-Dist Panel");
                  //JP Start-Dist Panel
            } else {

                  for (int a = 0; a < JPN.getComponentCount(); a++) {
                        if (JPN.getComponent(a) instanceof JRadioButton) {
                              JPN.remove(JPN.getComponent(a));
                              //FIXXXXXXXXXXXXX
                        }
                  }

                  System.out.println("\tWRONG");
            }
            JPN.revalidate();
            /*
            try{
                  do{
                  Thread.sleep(500);
                  VP.JPN.repaint();
                  System.out.println("DOING");
                  }while(!VP.rbtns[0].isPaintingTile());
            }catch(InterruptedException ex){
                  
            }
             */
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            //VP.JTEN.getNextMatch("", 0, Position.Bias.Forward);
            /*
            for (int a = 0; a < VP.JTEN.getComponentCount(); a++) {
                  if (VP.JTEN.getComponent(a) instanceof DefaultMutableTreeNode) {

                  }
            }
             */
      }

}
