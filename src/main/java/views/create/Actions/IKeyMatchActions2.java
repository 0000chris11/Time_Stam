/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public abstract class IKeyMatchActions2 {

      public void beforeActions(KeyEvent e) {}
      public void afterActions() {}
      //++++++++++++++++++++++++++++++++++++++++++++
      public abstract void listAction(KeyEvent e, boolean matchBW);
      //++++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getUpdatedList(ArrayList<String> list) {
            return list;
      }
      //++++++++++++++++++++++++++++++++++++++++++++
      public int getMinusIndex(KeyEvent e, int index){
            return index;
      }
}
