/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import java.awt.CardLayout;
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
            /*
            if(VP.JTEN.getSelectionPath().toString().
                    endsWith("Star, Dist Panel]")){
                  ((CardLayout) VP.JPN.getLayout()).show(VP.JPN, "JP Start-Dist Panel");
                  //JP Start-Dist Panel
            }else{
                  System.out.println("\tWRONG");
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
