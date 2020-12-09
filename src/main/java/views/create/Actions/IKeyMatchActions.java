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
public abstract class IKeyMatchActions {

      public void beforeActions(KeyEvent e) {}
      public void afterActions() {}
      //++++++++++++++++++++++++++++++++++++++++++++
      public abstract void list1Action(KeyEvent e, boolean matchBW);

      public abstract void list2Action(KeyEvent e, boolean matchEST);
      //++++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getUpdatedList1(ArrayList<String> list) {
            return list;
      }

      public ArrayList<String> getUpdateList2(ArrayList<String> list) {
            return list;
      }
      //++++++++++++++++++++++++++++++++++++++++++++
      public int getMinusIndex(KeyEvent e, int index){
            return index;
      }
}
