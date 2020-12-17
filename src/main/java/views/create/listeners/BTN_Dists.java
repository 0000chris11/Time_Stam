/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DT;
import com.cofii2.myMethods.MComp;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import views.create.VC_R_DataCom;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class BTN_Dists implements ActionListener {

      private VC_R_DataCom dt = MITableOptions_AL.getVCreateData();
      
      @Override
      public void actionPerformed(ActionEvent e) {
            imageCClockAction(e);

            ArrayList<Integer> colsDist = new ArrayList<Integer>();
            ArrayList<Integer> colsTag = new ArrayList<Integer>();
            //int colImageC = -1;
            //int colClock = -1;

            for (int a = 0; a < DT.maxColumns; a++) {
                  if (dt.getBTNS_Dist()[a].isSelected()) {
                        colsDist.add(a);
                  }
                  if (dt.getBTNS_Tag()[a].isSelected()) {
                        colsTag.add(a);
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++
            int clockN = dt.getBTN_ClockSelected();
            int imageCN = dt.getBTN_ImageCSelected();

            String dist = getOutput(colsDist);
            String tag = getOutput(colsTag);
            String imageC = getOutput(imageCN);
            String clock = getOutput(clockN);

            //INPUT FOR FOLDER LOCATION (IMAGEC)
            if (imageCN > 0) {
                  dt.getBoxImageC().setVisible(true);
                  dt.getLB_ClockLocation().setVisible(true);
                  //VC_R2.getPR().paintComponents(VC_R2.getPR().getGraphics());
            } else {
                  dt.getBoxImageC().setVisible(false);
                  dt.getLB_ClockLocation().setVisible(false);
            }

            setLB(dt.getLB_ADisp()[0], dist);
            setLB(dt.getLB_ADisp()[3], tag);
            setLB(dt.getLB_ADisp()[2], imageC);
            setLB(dt.getLB_ADisp()[4], clock);
            //+++++++++++++++++++++++++++++++++++
            clockDistControl(e);
      }

      private void setLB(JLabel lb, String var) {
            if (!var.equals("NONE")) {
                  lb.setForeground(Color.CYAN);
            } else {
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

      private String getOutput(int val) {
            String var = "NONE";
            if (val != -1) {
                  var = "C" + (Integer.toString(val));

            }
            return var;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void imageCClockAction(ActionEvent e) {
            String name = ((JComponent) e.getSource()).getName();
            try {
                  if (name.contains("BTN_IMAGEC")) {
                        dt.setBTN_ImageCSelected(MComp.setButtonGroup(e,
                                dt.getBTNS_ImageC()));
                  } else if (name.contains("BTN_CLOCK")) {
                        dt.setBTN_ClockSelected(MComp.setButtonGroup(e,
                                dt.getBTNS_Clock()));
                  }
            } catch (NullPointerException ex) {
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void clockDistControl(ActionEvent e) {
            for (int a = 0; a < DT.maxColumns; a++) {
                  JComponent JC = (JComponent) e.getSource();
                  if (JC.getName().equals(dt.getBTNS_Dist()[a].getName())) {
                        if (dt.getBTNS_Dist()[a].isSelected()) {
                              dt.getBTNS_Clock()[a].setEnabled(false);
                        }else{
                              dt.getBTNS_Clock()[a].setEnabled(true);
                        }
                  }
            }
      }
}
