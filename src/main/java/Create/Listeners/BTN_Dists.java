/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
import MC.DT;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author C0FII
 */
public class BTN_Dists implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
            System.out.println("actionPerformed");
            ArrayList<Integer> colsDist = new ArrayList<Integer>();
            ArrayList<Integer> colsTag = new ArrayList<Integer>();
            int colTabl = -1;
            int colClock = -1;
            
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VC_R2.getBTNS_Dist()[a].isSelected()) {
                        colsDist.add(a);
                  }
                  if (VC_R2.getBTNS_Tag()[a].isSelected()) {
                        colsTag.add(a);
                  }
                  if(VC_R2.getBTNS_Tabl()[a].isSelected()/* && 
                          e.getSource() == VC_R2.getBTNS_Tabl()[a]*/){
                        colTabl = a;
                  }
                  if(VC_R2.getBTNS_Clock()[a].isSelected() /*&& 
                          e.getSource() == VC_R2.getBTNS_Clock()[a]*/){
                        colClock = a;
                  }
            }

            String dist = getOutput(colsDist);
            String tag = getOutput(colsTag);
            String tabl = getOutput(colTabl);
            String clock = getOutput(colClock);
            
            setLB(VC_R2.getLB_ADisp()[0], dist);
            setLB(VC_R2.getLB_ADisp()[3], tag);
            setLB(VC_R2.getLB_ADisp()[2], tabl);
            setLB(VC_R2.getLB_ADisp()[4], clock);
      }
      
      private void setLB(JLabel lb, String var){
            if (!var.equals("NONE")) {
                  lb.setForeground(Color.CYAN);
            }else{
                  lb.setForeground(Color.WHITE);
            }
            lb.setText(var);
      }

      private String getOutput(ArrayList<Integer> list) {
            String var = "NONE";
            if (list.size() != 0) {
                  var = "X" + Integer.toString(list.size()) + ": ";
            }

            for (int a = 0; a < list.size(); a++) {
                  if (a != 0) {
                        var += "_";
                  }
                  var += (list.get(a) + 1);
            }

            return var;
      }
      private String getOutput(int val){
            String var = "NONE";
            if(val != -1){
                  var = "C" + (Integer.toString(val + 1));
            }
            return var;
      }

}
