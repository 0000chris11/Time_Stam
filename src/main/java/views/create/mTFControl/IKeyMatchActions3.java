/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.mTFControl;

import java.util.ArrayList;
import java.util.EventObject;

/**
 *
 * @author C0FII
 */
public abstract class IKeyMatchActions3 {
      
      public void beforeActions(EventObject e) {}
      //++++++++++++++++++++++++++++++++++++++++++++
      public abstract void listsAction(EventObject e, boolean[] matches);
      //++++++++++++++++++++++++++++++++++++++++++++
      public UpdateList getUpdatedList(int listID, ArrayList<String> list) {
            return new UpdateList(listID, list);
      }
      
}
