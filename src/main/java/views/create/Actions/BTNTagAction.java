/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import com.cofii2.methods.MList;
import com.cofii2.methods.MString;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.JLabel;
import views.createUpdate.VC_R_DataCom;
import com.cofii2.myInterfaces.IMultiSelection;

/**
 *
 * @author C0FII
 */
public class BTNTagAction implements IMultiSelection{

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      
      @Override
      public void action(EventObject e, ArrayList<Integer> list) {
            String value = MString.getCustomDistTagFormat(list);
            
            JLabel lb = dt.getLBATag();
            lb.setText(value);
            if(value.equals("NONE")){
                  lb.setForeground(Color.WHITE);
            }else{
                  lb.setForeground(Color.CYAN);
            }
      }
      
}
