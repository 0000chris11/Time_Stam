/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DT;
import MC.MainInstances;
import com.cofii2.methods.MComp;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class BTN_Dists implements ActionListener {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      @Override
      public void actionPerformed(ActionEvent e) {
            //clockDistControl(e);
            imageCClockAction(e);

            ArrayList<Integer> colsDist = new ArrayList<Integer>();
            ArrayList<Integer> colsTag = new ArrayList<Integer>();
            //int colImageC = -1;
            //int colClock = -1;

            for (int a = 0; a < DT.maxColumns; a++) {
                  if (c.getBTNS_Dist()[a].isSelected()) {
                        colsDist.add(a);
                  }
                  if (c.getBTNS_Tag()[a].isSelected()) {
                        colsTag.add(a);
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++
            int clockN = c.getBTN_ClockSelected();
            int imageCN = c.getBTN_ImageCSelected();

            String dist = getOutput(colsDist);
            String tag = getOutput(colsTag);
            String imageC = getOutput(imageCN);
            String clock = getOutput(clockN);

            //INPUT FOR FOLDER LOCATION (IMAGEC)
            System.out.println("TEST BTN_DIST");
            System.out.println("\timageCN: " + imageCN);
            String name = ((JComponent) e.getSource()).getName();
            System.out.println("\tname: " + name);
            if (imageCN > 0) {
                  dt.getPImageC().setVisible(true);
                  dt.getLBImageC().setVisible(true);
                  //VC_R2.getPR().paintComponents(VC_R2.getPR().getGraphics());
            } else if(name.contains("IMAGEC")){
                  dt.getPImageC().setVisible(false);
                  dt.getLBImageC().setVisible(false);
            }

            //setLB(dt.getLB_ADisp()[2], imageC);
            //+++++++++++++++++++++++++++++++++++
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
            if (val > 0) {
                  var = "C" + (Integer.toString(val));

            }
            return var;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void imageCClockAction(ActionEvent e) {
            //String name = ((JComponent) e.getSource()).getName();
            try {

                  int imageCValue = MComp.getSelectedOnAButtonGroup(e, c.getBTNS_ImageC());

                  //System.out.println("\nimageCValue: " + imageCValue);
                  c.setBTN_ImageCSelected(imageCValue);
                  
                  //int clockValue = MComp.getSelectedOnAButtonGroup(e, c.getBTNS_Clock());
                  //System.out.println("clockValue: " + clockValue);
                  //c.setBTN_ClockSelected(clockValue);

            } catch (NullPointerException ex) {
                  ex.printStackTrace();
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void clockDistControl(ActionEvent e) {
            for (int a = 0; a < DT.maxColumns; a++) {
                  JComponent JC = (JComponent) e.getSource();
                  if (JC.getName().equals(c.getBTNS_Dist()[a].getName())) {
                        if (c.getBTNS_Dist()[a].isSelected()) {
                              c.getBTNS_Clock()[a].setEnabled(false);
                              c.getBTNS_Clock()[a].setSelected(false);
                        } else {
                              c.getBTNS_Clock()[a].setEnabled(true);
                        }
                  }
            }
      }
}
