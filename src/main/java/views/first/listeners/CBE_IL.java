/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import MC.LKCustom;
import com.cofii.myMethods.MComp;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class CBE_IL implements ItemListener{

      private JComboBox CB;
      private JTextField TFE;
      
      public CBE_IL(JComboBox cb){
            CB = cb;
            TFE = (JTextField) CB.getEditor().getEditorComponent();
      }
      
      @Override
      public void itemStateChanged(ItemEvent e) {
            int index = MComp.getLastDigitCharsCountAtEnd(CB.getName()) - 1;
            if(TFE.getBackground().equals(LKCustom.BK_DIST1)){
                  //CB.add
            }else if(TFE.getBackground().equals(LKCustom.BK_DIST2)){
                  
            }
      }
      
}
