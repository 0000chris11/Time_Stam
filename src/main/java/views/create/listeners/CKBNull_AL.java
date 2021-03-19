/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class CKBNull_AL implements ActionListener {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private int index;

      public CKBNull_AL(int index) {
            this.index = index;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (c.getUpdateStore() != null) {
                  boolean nulls = c.getCKSNulls()[index].isSelected();
                  boolean nullsC = c.getUpdateStore().getNulls()[index];
                  if(nulls == nullsC){
                        c.getBTNSChange_Nulls()[index].setEnabled(false);
                  }else{
                        c.getBTNSChange_Nulls()[index].setEnabled(true);
                  }
            }
      }

}
