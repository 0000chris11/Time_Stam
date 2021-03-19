/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import MC.MainInstances;
import com.cofii2.methods.MComp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import views.mainTable.VMT_DataCom;

/**
 *
 * @author C0FII
 */
public class BTN_AL implements ActionListener {

      private VMT_DataCom dt = MainInstances.getVMT_DataCom();
      private JToggleButton[] array;
      
      public BTN_AL(JToggleButton[] array){
            this.array = array;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            MComp.getSelectedOnAButtonGroup(e, array);
            
            if (dt.getBTNDists().isSelected()) {
                  dt.getCD().show(dt.getPU(), "DISTS");
            } else if (dt.getBTNTypes().isSelected()) {
                  if (!dt.getJTDists().getSelectionModel().isSelectionEmpty()) {
                        dt.getCD().show(dt.getPU(), "TYPES");
                  }else{
                        dt.getCD().show(dt.getPU(), "LB_ERRORS");
                  }
            }else if(dt.getBTNIndexs().isSelected()){
                  if (!dt.getJTDists().getSelectionModel().isSelectionEmpty()) {
                        dt.getCD().show(dt.getPU(), "INDEXS");
                  }else{
                        dt.getCD().show(dt.getPU(), "LB_ERRORS");
                  }
            }
      }

}
