/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import com.cofii2.myMethods.MComp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

/**
 *
 * @author C0FII
 */
public class  SingleSelectionButton <T extends AbstractButton> implements ActionListener{

      private SelectionAction SA;
      private T[] Array;
      
      public SingleSelectionButton(T[] array, SelectionAction sa){
            Array = array;
            SA = sa;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            int num = MComp.setButtonGroup(e, Array) - 1;//- 1 (INDEX)
            System.out.println("Button Group num: " + (num + 1));
            SA.action(num);
            
      }

}

