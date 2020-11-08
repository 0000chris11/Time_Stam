/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
import MC.DT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

/**
 *
 * @author C0FII
 */
public class MButtonGroup<T extends AbstractButton> implements ActionListener {

      private T[] Array;

      public MButtonGroup(T[] array) {
            Array = array;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            for (int a = 0; a < Array.length; a++) {
                  if (e.getSource() == Array[a]) {
                        //IF A BTN IS SELECTED SET THE REST TO DESELECTED
                        if (Array[a].isSelected()) {
                              for (int b = 0; b < Array.length; b++) {
                                    if (b != a) {//MINUS ITSELF
                                          Array[b].setSelected(false);
                                    }
                              }
                        }
                  }
            }
      }
}
